package com.ecommerce.minishop.repository;

import com.ecommerce.minishop.model.OrderHeader;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderHdrRepository extends CrudRepository<OrderHeader, Long> {
    Optional<OrderHeader> findAllByRefId(String refid);
}
