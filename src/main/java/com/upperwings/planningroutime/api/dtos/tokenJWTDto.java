package com.upperwings.planningroutime.api.dtos;

public record tokenJWTDto(String token, java.time.OffsetDateTime expiresAt) {
}
