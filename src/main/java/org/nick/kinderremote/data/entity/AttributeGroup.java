package org.nick.kinderremote.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "oc_attribute_group")
@SecondaryTable(name = "oc_attribute_group_description",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "attribute_group_id",
                referencedColumnName = "attribute_group_id"))
public class AttributeGroup {
    @Id
    @Column(name = "attribute_group_id")
    private Long id;

    @Column(name = "name",table="oc_attribute_group_description")
    private String name;

    // Другие поля сущности AttributeGroup

//    @OneToMany(fetch = FetchType.EAGER,mappedBy = "attributeGroup", cascade = CascadeType.ALL)
//    private List<ProductAttribute> attributes;

//    @Override
//    public String toString() {
//        return "AttributeGroup{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", attributes=" + attributes +
//                '}';
//    }
}
