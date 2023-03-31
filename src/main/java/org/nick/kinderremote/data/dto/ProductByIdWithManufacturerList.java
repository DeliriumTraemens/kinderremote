package org.nick.kinderremote.data.dto;

import org.nick.kinderremote.data.entity.Manufacturer;
import org.nick.kinderremote.data.entity.Product;
import org.nick.kinderremote.data.projections.ProdCardProjIf;

import java.util.List;
import java.util.Set;

public class ProductByIdWithManufacturerList {

    Set<ManufacturerCardDto> manufacturersList;
    List<ProdCardProjIf> productList;
    Set<Manufacturer>manufactSet;
    Set<Product>productSet;
    public ProductByIdWithManufacturerList(List<ProdCardProjIf> productList, Set<ManufacturerCardDto> manufacturersList) {
        this.productList = productList;
        this.manufacturersList = manufacturersList;
    }

    public ProductByIdWithManufacturerList(Set<Manufacturer> manufactSet, Set<Product> productSet) {
        this.manufactSet = manufactSet;
        this.productSet = productSet;
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

    public Set<Manufacturer> getManufactSet() {
        return manufactSet;
    }

    public void setManufactSet(Set<Manufacturer> manufactSet) {
        this.manufactSet = manufactSet;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    @Override
    public String toString() {
        return "ProductByIdWithManufacturerList{" +
                "manufacturersList=" + manufacturersList +
                ", productList=" + productList +
                ", manufactSet=" + manufactSet +
                ", productSet=" + productSet +
                '}';
    }
}
