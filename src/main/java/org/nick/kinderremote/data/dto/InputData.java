package org.nick.kinderremote.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


/**
 * Тип запрашиваемых данных
 * -ктегория продукт маануфактурер
 * id
 * requested page
 * current page
 * */

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class InputData {
    private Long id;
    private String header;
    private String status;
    private int page;
    private int totalPages;



}
