package com.laridosos.rest.phone;

import com.laridosos.rest.user.UserApp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String ddd;
    private String number;

    @Column(name = "is_main")
    private boolean isMain;

    @Enumerated(EnumType.STRING)
    @Column(name = "phone_type")
    private PhoneTypeEnum phoneType;

    @ManyToOne
    private UserApp userApp;
}
