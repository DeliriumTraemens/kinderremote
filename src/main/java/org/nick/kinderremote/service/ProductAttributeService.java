package org.nick.kinderremote.service;

import org.nick.kinderremote.data.dto.AttribDtoThird;
import org.nick.kinderremote.data.dto.AttributeGroupDto;
import org.nick.kinderremote.data.entity.Attribute;
import org.nick.kinderremote.data.entity.AttributeGroup;
import org.nick.kinderremote.data.entity.ProductAttributeMain;
import org.nick.kinderremote.repository.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAttributeService {
    private final ProductAttributeRepository pa;

    @Autowired
    public ProductAttributeService(ProductAttributeRepository pa) {
        this.pa = pa;
    }

    List<ProductAttributeMain> findPAById(Long productId){
//        Long id = 264950L;
//        List <Long> ids = Arrays.asList(id);
    List<ProductAttributeMain> paList = pa.findByKeyProductId(productId);

    //        return convertToDto(paList);
        return paList;
    }

    Object convertToDto(List<ProductAttributeMain> paList){
            AttributeGroupDto agd = new AttributeGroupDto();

        for (ProductAttributeMain productAttributeMain : paList) {
            Attribute attribute = productAttributeMain.getAttribute();
            AttributeGroup attributeGroup = attribute.getAttributeGroup();
            //Create GroupAttrDtd
//            AttributeGroupDto agd = new AttributeGroupDto();
             agd.setId(attributeGroup.getId());
             agd.setGroupName(attributeGroup.getName());
             //Create and map attribDto
            AttribDtoThird attrDto=new AttribDtoThird();
            attrDto.setId(attribute.getId());
            attrDto.setType(attribute.getName());
            attrDto.setValue(productAttributeMain.getText());
            agd.attributes.add(attrDto);
        }

        return agd;
    }

}
