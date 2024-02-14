package com.ayrotek.product.mapper;

import com.ayrotek.product.dto.UserDto;
import com.ayrotek.product.model.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    public abstract UserDto toDto(User user);

    public abstract User toEntity(UserDto dto);

    public abstract List<UserDto> toDtoList(List<User> userList);

    public abstract Set<UserDto> toDtoSet(Set<User> userList);

}
