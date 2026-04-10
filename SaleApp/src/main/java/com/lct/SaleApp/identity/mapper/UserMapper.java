package com.lct.SaleApp.identity.mapper;

import com.lct.SaleApp.identity.dto.request.userRequest.RequestCreateUser;
import com.lct.SaleApp.identity.dto.request.userRequest.RequestUpdateUser;
import com.lct.SaleApp.identity.dto.response.UserResponse;
import com.lct.SaleApp.identity.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(RequestCreateUser requestCreateUser);
    UserResponse toUserResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUser(@MappingTarget User user, RequestUpdateUser requestUpdateUser);
}
