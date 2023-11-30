package org.nick.kinderremote.data.entity.test;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "oc_weight_class_description")
public class OcWeightClassDescriptionTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "weight_class_id", nullable = false)
    private Integer weightClassId;

    @Id
    @Column(name = "language_id", nullable = false)
    private Integer languageId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "unit", nullable = false)
    private String unit;

}
