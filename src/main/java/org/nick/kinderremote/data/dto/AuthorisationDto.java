package org.nick.kinderremote.data.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthorisationDto {
private String token;
private String username;
//private String password;
private LocalDateTime createdAt;
private String sessionId;


}
