package lk.lochana.pos.repository;


import lk.lochana.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "select * from customer where id=:id", nativeQuery = true)
    Optional<Customer> getMyCustomer(@Param("id") String id);
}
