package org.nick.kinderremote.data.entity.test;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "test_attribute_group_description")
public class AttributeGroupDescriptionTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "attribute_group_id", nullable = false)
    private Integer attributeGroupId;

    @Column(name = "name")
    private String name;

}
