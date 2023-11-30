package org.nick.kinderremote.data.dto;

import lombok.Data;
import org.nick.kinderremote.data.entity.AttributeGroup;

import java.util.ArrayList;
import java.util.List;
@Data
public class AttribDtoSecond {
    private List<AttributeGroup> attributeGroups=new ArrayList();
}
