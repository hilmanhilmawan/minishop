package com.ecommerce.minishop.util;

import com.ecommerce.minishop.exception.InvalidPageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("PageDetailContent")
public class PageBuilderContentDetail implements PageBuilder {
    private static final Sort DEFAULT_SORT = Sort.by("id").descending();

    @Override
    public PageRequest buildPageRequest(int pageNum, int pageSize) {
        return buildPageRequest(pageNum, pageSize, DEFAULT_SORT);
    }

    @Override
    public PageRequest buildPageRequest(int pageNum, int pageSize, Sort sort) {
        if (invalidPageNum(pageNum) || invalidPageSize(pageSize)) {
            throw new InvalidPageRequest("invalid page number/size");
        }

        return PageRequest.of(pageNum, pageSize, sort);
    }

    @Override
    public  Sort.Direction getSortDirection(String direction){
        if(direction.equals("asc")){
            return Sort.Direction.ASC;
        }else if (direction.equals("desc")){
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }

    @Override
    public List<Sort.Order> splitOrder(String order) {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        String[] _sort = order.split(",");
        orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
        return orders;
    }

    private boolean invalidPageNum(int pageNum) {
        return pageNum < 0;
    }

    private boolean invalidPageSize(int pageSize) {
        return pageSize < 1;
    }
}
