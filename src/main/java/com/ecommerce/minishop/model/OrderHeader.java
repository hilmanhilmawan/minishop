package com.ecommerce.minishop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_header")
public class OrderHeader extends BaseAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "refid", columnDefinition = "VARCHAR(50)", unique = true, updatable = false, nullable = false)
    private String refId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BIGINTEGER(20)")
    private UserLogin userLogin;

    @Column(name = "nama", columnDefinition = "VARCHAR(200)")
    private String nama;

    @Column(name = "no_telepon", columnDefinition = "INT(15)")
    private int nohandPhone;

    @Column(name = "alamat", columnDefinition = "TEXT")
    private String alamat;

    @Column(name = "subtotal", columnDefinition = "DOUBLE(18,2)")
    private double subtotal;

    @Column(name = "payment_type", columnDefinition = "ENUM(COD)")
    private String paymentType;

    @Column(name = "status", columnDefinition = "INT(10)")
    private int status;

    @OneToMany(mappedBy = "produk", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails = new HashSet<>();

    public void addDtl(OrderDetail dtl){
        orderDetails.add(dtl);
        dtl.setOrderHeader(this);
    }

    @PrePersist
    public void initializeUUID() {
        if (refId == null) {
            refId = UUID.randomUUID().toString();
        }
    }
}
