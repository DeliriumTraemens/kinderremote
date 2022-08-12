package org.nick.kinderremote.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@ToString(of = {"id", "name", "children"})
@EqualsAndHashCode(of = {"id", "name"})

@Table(name = "oc_category")
@SecondaryTable(name = "oc_category_description",pkJoinColumns = @PrimaryKeyJoinColumn(name = "category_id"))
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;

    @JsonIgnore
    @Column(name = "image")
    private String image;

    @JsonIgnore
    @Column(name = "status")
    private short status;

    @Column(name = "name",table="oc_category_description")
    private String name;

    @Column(name = "description",table="oc_category_description")
    private String description;

    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name ="date_added")
    private LocalDateTime creationDate;

    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name ="date_modified")
    private LocalDateTime modificationDate;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name =  "parent_id")
    @JsonBackReference
    private Category parent;

    @OneToMany(mappedBy="parent",cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id ASC ")
//    @JsonManagedReference
    private Set<Category> children = new HashSet<Category>();
}
