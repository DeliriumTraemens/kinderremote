package org.nick.kinderremote.data.entity.authorithy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oc_customerAddress")
public class CustomerAddress {
    @Id
    private Long addressId;
    private Integer zip;
    private String city;
    private String street;
    private Integer building;
    private Integer apartment;

}
