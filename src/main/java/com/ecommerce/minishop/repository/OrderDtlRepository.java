package com.ecommerce.minishop.repository;

import com.ecommerce.minishop.model.OrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface OrderDtlRepository extends CrudRepository<OrderDetail, Long> {
}
