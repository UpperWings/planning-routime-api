package com.upperwings.planningroutime.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserAuthDto(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}
