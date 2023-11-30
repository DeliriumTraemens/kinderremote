package org.nick.kinderremote.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@IdClass(ProductAttributeKey.class)
@Table(name = "oc_product_attribute")
public class ProductAttributeMain {
    @Id
    @Column(name = "product_id")
    private Long prodId;

    @Id
    @Column(name = "attribute_id")
    private Long attribId;

    @MapsId("prodId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @MapsId("attribId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    @Column(name = "text")
    private String text;

    @Override
    public String toString() {
        return "\nProductAttributeMain{" +
                "prodId=" + prodId +
                ", attribId=" + attribId +
                ", \n==> attribute=" + attribute +
                ", \ntext='" + text + '\'' +
                '}';
    }
}
    //    @EmbeddedId
//    private ProductAttributeKey id;
