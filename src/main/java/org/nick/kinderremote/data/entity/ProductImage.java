package org.nick.kinderremote.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(of = {"id","name"})
@Table(name = "oc_product_image")
public class ProductImage {
    @Id
    @GeneratedValue
    @Column(name="product_image_id")
    private Long id;

    @Column(name="image")
    private String image;
}
