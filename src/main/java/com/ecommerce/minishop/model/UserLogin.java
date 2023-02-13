package com.ecommerce.minishop.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_login")
@EqualsAndHashCode(callSuper = true)
public class UserLogin extends BaseAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ref_id", columnDefinition = "VARCHAR(50)", unique = true, updatable = false, nullable = false)
    private String refId;
    @Column(name = "username", columnDefinition = "VARCHAR(70)", unique = true, nullable = false)
    private String username;

    @Column(name = "password", columnDefinition = "VARCHAR(100)", nullable = false)
    private String password;

    @Column(name = "fullname", columnDefinition = "VARCHAR(200)", nullable = false)
    private String fullname;

    @Column(name = "email", columnDefinition = "VARCHAR(150)")
    private String email;

    @Column(name = "no_handphone", columnDefinition = "VARCHAR(20)")
    private String noHandphone;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "is_deleted", columnDefinition = "CHAR(1)")
    private Character idDeleted;

    @PrePersist
    public void initializeUUID() {
        if (refId == null) {
            refId = UUID.randomUUID().toString();
        }
    }
}
