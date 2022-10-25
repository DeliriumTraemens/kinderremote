package org.nick.kinderremote.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ManufacturerCardDto {
    private Long id;
    private String name;
    private String image;

}
