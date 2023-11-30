package org.nick.kinderremote.data.entity.test;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "test_attribute_description")
public class AttributeDescriptionTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "attribute_id", nullable = false)
    private Integer attributeId;

    @Column(name = "name")
    private String name;

}
