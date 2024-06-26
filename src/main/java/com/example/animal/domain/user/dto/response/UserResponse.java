package com.example.animal.domain.user.dto.response;

import com.example.animal.domain.user.entity.User;
import lombok.Builder;

@Builder
public record UserResponse(
    String id
) {

  public static UserResponse fromEntity(User user) {
    return UserResponse.builder()
        .id(user.getId())
        .build();
  }
}
