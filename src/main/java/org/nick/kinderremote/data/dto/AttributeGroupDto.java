package org.nick.kinderremote.data.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AttributeGroupDto {
    private Long id;
    private String groupName;
    public List<AttribDtoThird> attributes = new ArrayList();
}
