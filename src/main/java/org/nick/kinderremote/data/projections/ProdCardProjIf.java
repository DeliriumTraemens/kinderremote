package org.nick.kinderremote.data.projections;

public interface ProdCardProjIf {
    Long getId();
    String getName();
    String getImage();
    ManProjIf getManufacturer();
    Float getPrice();

}
