package org.nick.kinderremote.data.dto;

import org.nick.kinderremote.data.projections.ProdCardProjIf;

import java.util.List;
import java.util.Set;

public class ProductByIdWithManufacturerList {

    Set<ManufacturerCardDto> manufacturersList;
    List<ProdCardProjIf> productList;

    public ProductByIdWithManufacturerList(List<ProdCardProjIf> productList, Set<ManufacturerCardDto> manufacturersList ) {
        this.productList = productList;
        this.manufacturersList = manufacturersList;
    }

    public Set<ManufacturerCardDto> getManufacturersList() {
        return manufacturersList;
    }

    public void setManufacturersList(Set<ManufacturerCardDto> manufacturersList) {
        this.manufacturersList = manufacturersList;
    }

    public List<ProdCardProjIf> getProductList() {
        return productList;
    }

    public void setProductList(List<ProdCardProjIf> productList) {
        this.productList = productList;
    }
}
