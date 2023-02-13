package com.ecommerce.minishop.repository;

import com.ecommerce.minishop.model.Produk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProdukRepository extends CrudRepository<Produk, Long>, PagingAndSortingRepository<Produk, Long> {
    Page<Produk> findByIsDeletedTrue(Pageable pageable);
    Page<Produk> findByIsDeletedTrueAndNamaProdukIgnoreCaseLike(String namaProduk, Pageable pageable);
    Optional<Produk> findByRefId(String refid);
}
