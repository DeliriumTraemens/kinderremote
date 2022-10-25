package org.nick.kinderremote.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "oc_product")
@ToString(of = {"id", "name", "creationDate","manufacturer"})
@EqualsAndHashCode(of = {"id","name"})

@SecondaryTables({
        @SecondaryTable(name = "oc_product_description", pkJoinColumns = @PrimaryKeyJoinColumn(name = "product_id")),
        @SecondaryTable(name = "oc_product_to_category", pkJoinColumns = @PrimaryKeyJoinColumn(name = "product_id"))})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "price")
    private Float price;

    @Column(name = "image")
    private String image;

    @Column(name = "name", table = "oc_product_description")
    private String name;

    //	@JsonIgnore
    @Column(name = "description", table = "oc_product_description")
    private String description;

    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name ="date_added")
    private LocalDateTime creationDate;

    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name ="date_modified")
    private LocalDateTime modificationDate;

    @Column(name = "category_id", table = "oc_product_to_category")
    private Long catId;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name="manufacturer_id")
    private Manufacturer manufacturer;

//    @Override
//    public String toString() {
//        return "\nProduct{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", catId=" + catId +
//                '}';
//    }
}
