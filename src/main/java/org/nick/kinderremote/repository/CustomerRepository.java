package org.nick.kinderremote.repository;

import org.nick.kinderremote.data.entity.authorithy.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
