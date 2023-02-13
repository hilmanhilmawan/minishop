package com.ecommerce.minishop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produk")
public class Produk extends BaseAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "refid", columnDefinition = "VARCHAR(50)", unique = true, updatable = false, nullable = false)
    private String refId;

    @Column(name = "nama", columnDefinition = "VARCHAR(50)")
    private String namaProduk;

    @Column(name = "harga", columnDefinition = "DOUBLE(18,2)")
    private double harga;

    @Column(name = "deskripsi", columnDefinition = "TEXT")
    private String deskripsi;

    @Column(name = "is_deleted")
    private boolean isDeleted = true;

    @PrePersist
    public void initializeUUID() {
        if (refId == null) {
            refId = UUID.randomUUID().toString();
        }
    }
}
