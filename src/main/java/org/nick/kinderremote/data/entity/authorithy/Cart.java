package org.nick.kinderremote.data.entity.authorithy;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "oc_cartnew")
public class Cart {
    @Id
    @Column(name = "cart_id")
    private Long cartId;

    @Column(name="customer_id")
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name ="session_id")
    private Long sessionId;

}
