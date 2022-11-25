package org.nick.kinderremote.data.dto;

import lombok.Data;

@Data
//@RequiredArgsConstructor
public class ManufacturerCardDto {
    private Long id;
    private String name;
    private String image;

    public ManufacturerCardDto(Long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
}
