package org.nick.kinderremote.data.dto;

import lombok.Data;
import org.nick.kinderremote.data.entity.Manufacturer;
import org.nick.kinderremote.data.entity.ProductImage;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Data
public class ProductDetailsDto {

    private Long id;

    private Float price;

    private String image;

    private String name;

    private String description;

    private LocalDateTime creationDate;

    private LocalDateTime modificationDate;

    private Long catId;

    private Manufacturer manufacturer;

    //ImageSet
    private Set<ProductImage> images=new HashSet<>();

    private Object groupAttribute;
}
