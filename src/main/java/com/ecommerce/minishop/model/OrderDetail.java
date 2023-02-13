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
@Table(name = "order_detail")
public class OrderDetail extends BaseAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "refid", columnDefinition = "VARCHAR(50)", unique = true, updatable = false, nullable = false)
    private String refId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_hdr_id", columnDefinition = "BIGINTEGER(20)")
    private OrderHeader orderHeader;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produk_id", columnDefinition = "BIGINTEGER(20)")
    private Produk produk;

    @Column(name = "harga", columnDefinition = "DOUBLE(18,2)")
    private double harga;

    @Column(name = "qty", columnDefinition = "INT(11)")
    private int qty;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetail)) return false;
        return id != null && id.equals(((OrderDetail) o).getId());
    }

    @PrePersist
    public void initializeUUID() {
        if (refId == null) {
            refId = UUID.randomUUID().toString();
        }
    }
}
