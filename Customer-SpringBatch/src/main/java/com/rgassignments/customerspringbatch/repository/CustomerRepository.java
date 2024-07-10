package com.rgassignments.customerspringbatch.repository;

import com.rgassignments.customerspringbatch.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
