package com.ecommerce.minishop.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PageBuilder {
    PageRequest buildPageRequest(int pageNum, int pageSize);

    PageRequest buildPageRequest(int pageNum, int pageSize, Sort sort);

    Sort.Direction getSortDirection(String direction);

    List<Sort.Order> splitOrder (String order);
}
