package org.nick.kinderremote.data.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LocalSession {
private LocalDateTime date;
private String browser;
private String uuid;

}
