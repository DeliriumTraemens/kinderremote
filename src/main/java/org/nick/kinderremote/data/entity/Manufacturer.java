package org.nick.kinderremote.data.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@ToString(of = {"id", "name"})
//@EqualsAndHashCode(of = {"id", "name"})
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manufacturer)) return false;
        Manufacturer that = (Manufacturer) o;
        return getId().equals(that.getId()) &&
                getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
