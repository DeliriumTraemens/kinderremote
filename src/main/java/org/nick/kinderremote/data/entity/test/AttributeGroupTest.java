package org.nick.kinderremote.data.entity.test;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "test_attribute_group")
public class AttributeGroupTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_group_id", nullable = false)
    private Integer attributeGroupId;

}
