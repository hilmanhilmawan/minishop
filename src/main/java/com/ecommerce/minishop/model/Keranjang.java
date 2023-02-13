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
@Table(name = "keranjang")
public class Keranjang extends BaseAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "refid", columnDefinition = "VARCHAR(50)", unique = true, updatable = false, nullable = false)
    private String refId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produk_id", columnDefinition = "BIGINTEGER(20)")
    private Produk produk;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BIGINTEGER(20)")
    private UserLogin userLogin;

    @Column(name = "qty", columnDefinition = "INT(11)")
    private int qty;

    @PrePersist
    public void initializeUUID() {
        if (refId == null) {
            refId = UUID.randomUUID().toString();
        }
    }
}
