package org.nick.kinderremote.data.entity.authorithy;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "oc_customernew")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "customerId")
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;


    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

//    @Column(name = "cart")
//    @OneToMany(mappedBy="customer")
//    private List <Cart> cart;

//    @Column(name = "wishlist")
////    @OneToMany
//    @ElementCollection
//    private Set<Long> wishlist;

//    @Column(name = "newsletter")
//    private Byte newsletter;

    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "custom_field")
    private String customField;

    @Column(name = "ip")
    private String ip;

    @Column(name = "status")
    private Byte status;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "safe")
    private Boolean safe;

    @Column(name = "token")
    private String token;

    @Column(name = "code")
    private String code;

    @Column(name = "date_added")
    private LocalDateTime dateAdded;

//    @ElementCollection
//    @CollectionTable(name="oc_session_ids")
//    @CollectionId(
//            columns = @Column(name="id"),
//            type = @Type(type="long"),
//            generator = "sequence"
//    )
//    private List<Long> sessions;

    @OneToMany(fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<Session>sessions = new ArrayList<>();

//    @OneToMany
//    private List<Product> viewed;
//    private CustomerGroup customerGroup;
//
//    @OneToOne
//    private CustomerAddress address;
//
//    private LocalDateTime created;
//    private CustomerStatus customerStatus;


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", fax='" + fax + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", addressId=" + addressId +
                ", customField='" + customField + '\'' +
                ", ip='" + ip + '\'' +
                ", status=" + status +
                ", approved=" + approved +
                ", safe=" + safe +
                ", token='" + token + '\'' +
                ", code='" + code + '\'' +
                ", dateAdded=" + dateAdded +
                ", sessions=" + sessions +
                '}';
    }
}
