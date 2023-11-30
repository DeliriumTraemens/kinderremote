package org.nick.kinderremote.data.entity.test;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "test_attribute")
public class AttributeTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "attribute_id", nullable = false)
    private Integer attributeId;

    @Column(name = "attribute_group_id", nullable = false)
    private Integer attributeGroupId;

}
