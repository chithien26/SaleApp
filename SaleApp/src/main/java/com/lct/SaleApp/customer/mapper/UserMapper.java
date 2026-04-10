package com.lct.SaleApp.customer.mapper;

import com.lct.SaleApp.customer.dto.request.userRequest.RequestCreateUser;
import com.lct.SaleApp.customer.dto.request.userRequest.RequestUpdateUser;
import com.lct.SaleApp.customer.dto.response.UserResponse;
import com.lct.SaleApp.customer.entity.User;
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
