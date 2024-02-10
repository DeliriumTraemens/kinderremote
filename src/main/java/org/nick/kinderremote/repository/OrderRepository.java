package org.nick.kinderremote.repository;

import org.nick.kinderremote.data.entity.authorithy.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
