package org.nick.kinderremote.data.dto;

import org.nick.kinderremote.data.entity.Manufacturer;
import org.nick.kinderremote.data.entity.Product;

import java.util.Set;

public class ProductSearchDto {
    Set<Product> productSearchList;
    Set<Manufacturer> manufacturerSet;

    public ProductSearchDto(Set<Product> productSearchList, Set<Manufacturer> manufacturerSet) {
        this.productSearchList = productSearchList;
        this.manufacturerSet = manufacturerSet;
    }

    public Set<Product> getProductSearchList() {
        return productSearchList;
    }

    public void setProductSearchList(Set<Product> productSearchList) {
        this.productSearchList = productSearchList;
    }

    public Set<Manufacturer> getManufacturerSet() {
        return manufacturerSet;
    }

    public void setManufacturerSet(Set<Manufacturer> manufacturerSet) {
        this.manufacturerSet = manufacturerSet;
    }
}
