package org.nick.kinderremote.data.entity;

import java.io.Serializable;

//@Entity
//@Data
//@Table(name = "oc_category")
//@EqualsAndHashCode(of = {"id", "name"})
//@SecondaryTable(name = "oc_category_description",pkJoinColumns = @PrimaryKeyJoinColumn(name = "category_id"))
public class Catalog implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name ="category_id")
//    private Long id;
//
//    @Column(name = "name",table="oc_category_description")
//    @JoinColumn(name = "category_id" )
//    private String name;
//
//    @JsonIgnore
//    @Column(name = "status")
//    private short status;
//
//    @ManyToOne(fetch = FetchType.LAZY)
////    @JsonIgnore
//    @JoinColumn(name =  "parent_id")
//    @JsonBackReference
//    private Catalog parent;
//
//    @OneToMany(mappedBy="parent",cascade = CascadeType.ALL, orphanRemoval = true)
//    @OrderBy("id ASC ")
////    @JsonManagedReference
//    private Set<Catalog> children= new HashSet<Catalog>();
//
//    @Override
//    public String toString() {
//        return "Catalog{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", children=" + children +
//                '}';
//    }
}
