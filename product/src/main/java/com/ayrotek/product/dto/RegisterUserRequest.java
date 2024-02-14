package com.ayrotek.product.dto;

import com.ayrotek.product.model.Role;
import lombok.Builder;

import java.util.Set;


@Builder
public record RegisterUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
) {
}
