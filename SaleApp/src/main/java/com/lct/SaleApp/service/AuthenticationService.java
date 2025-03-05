package com.lct.SaleApp.service;

import com.lct.SaleApp.entity.User;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class AuthenticationService {
    UserService userService;
    PasswordEncoder passwordEncoder;
    protected static final String SIGNER_KEY = "qh19ye3tep3uibkxgxvh9x9fia8l910mqh19ye3tep3uibkxgxvh9x9fia8l910m";

    public String login(String username, String password){
        User user = userService.getUserByUserName(username);
        if (!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("Login fail!");
        }
        return generateToken(username);
    }

    public String generateToken(String username){
        long expitationTime = 1000 * 60 * 60;
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("mockhoaxinh.com")
                .issueTime(new Date())
                .expirationTime(new Date(new Date().getTime() + expitationTime))
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
        } catch (JOSEException e) {
            log.error("Cannot create token!");
            throw new RuntimeException(e);
        }
        return jwsObject.serialize();
    }
}
