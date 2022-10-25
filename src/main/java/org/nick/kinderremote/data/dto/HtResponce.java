package org.nick.kinderremote.data.dto;

import lombok.Data;

import java.util.List;
@Data
public class HtResponce {
//    CatList
    private List<Object>catList;
//    ProdList
    private List<Object>prodList;
    private int requestedPage;
    private int totalPages;


}
