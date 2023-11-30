package org.nick.kinderremote.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "oc_attribute")
@SecondaryTable(name = "oc_attribute_description",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "attribute_id",
                referencedColumnName = "attribute_id"))
public class Attribute {
    @Id
    @Column(name = "attribute_id")
    private Long id;

    @Column(table = "oc_attribute_description", name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "attribute_group_id")
    private AttributeGroup attributeGroup;
}

