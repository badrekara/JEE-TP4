package org.sid.orderservice.repository;

import org.sid.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order,Long> {
    @RestResource(path="/byCustomerId")//order me permet de me donner les commandes dun client http://localhost:9999/order-service/orders/search/byCustomerId?customerId=1
    List<Order> findByCustomerId(@Param("customerId") Long customerId);
}
