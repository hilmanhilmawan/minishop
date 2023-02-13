package com.ecommerce.minishop.repository;

import com.ecommerce.minishop.model.Keranjang;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface KeranjangRepository extends CrudRepository<Keranjang, Long>, PagingAndSortingRepository<Keranjang, Long> {
    Iterable<Keranjang> findByCreatorIdOrderByCreatorTimeDesc(String username);
    Optional<Keranjang> findAllByRefId(String refid);
}
