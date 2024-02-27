package org.nick.kinderremote.data.entity.authorithy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name ="oc_ordernew")
public class Order {

    @Id
    private Long orderId;
    private String uuid;
    private LocalDateTime createdAt;
//    private Customer customer;
}
