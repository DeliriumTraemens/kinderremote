package org.nick.kinderremote.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString(of = {"id", "name"})
@EqualsAndHashCode(of = {"id", "name"})
@Table(name = "oc_manufacturer")

@SecondaryTables({
        @SecondaryTable(name = "oc_manufacturer_description",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "manufacturer_id"))
})
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manufacturer_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

}
