package org.nick.kinderremote.data.dto;

//@Data
//@AllArgsConstructor
public class ProductCardDto {
    private Long id;
    private String image;
    private Float price;
    private String name;

    private Long manId;
    private String manName;
    private String manImage;

    public ProductCardDto() {
    }

    public ProductCardDto(Long id, String image, Float price, String name, Long manId, String manName, String manImage) {
        this.id = id;
        this.image = image;
        this.price = price;
        this.name = name;

        this.manId = manId;
        this.manName = manName;
        this.manImage = manImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getManId() {
        return manId;
    }

    public void setManId(Long manId) {
        this.manId = manId;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getManImage() {
        return manImage;
    }

    public void setManImage(String manImage) {
        this.manImage = manImage;
    }

    //    ManufacturerCardDto manufacturer;



}
