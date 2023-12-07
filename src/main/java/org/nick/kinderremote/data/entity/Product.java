package org.nick.kinderremote.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
@Table(name = "oc_product")
//@ToString(of = {"id", "name", "creationDate","manufacturer"})
//@EqualsAndHashCode(of = {"id","name"})

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

    //ImageSet
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<ProductImage> images=new HashSet<>();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId()) &&
                Objects.equals(getPrice(), product.getPrice()) &&
                getName().equals(product.getName()) &&
                Objects.equals(getManufacturer(), product.getManufacturer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getName(), getManufacturer());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", catId=" + catId +
                ", \n\tmanufacturer=" + manufacturer +
                ", \n\timages=" + images +
                '}';
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", \nprice=" + price +
//                ", \nimage='" + image + '\'' +
//                ", \nname='" + name + '\'' +
//                ", \ndescription='" + description + '\'' +
//                ", \ncreationDate=" + creationDate +
//                ", modificationDate=" + modificationDate +
//                ", \ncatId=" + catId +
//                ", \nmanufacturer=" + manufacturer +
//                ", \nimages=" + images +
//                ", \nattributes=" + attributes +
//                '}';
//    }
}
