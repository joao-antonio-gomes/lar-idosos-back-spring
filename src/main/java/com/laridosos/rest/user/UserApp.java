package com.laridosos.rest.user;

import com.laridosos.rest.address.Address;
import com.laridosos.rest.patient.Patient;
import com.laridosos.rest.phone.Phone;
import com.laridosos.rest.role.Role;
import com.laridosos.rest.persons.MaritalStatusEnum;
import com.laridosos.rest.persons.GenderEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "user_app")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String cpf;
    private String email;
    private String password;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private MaritalStatusEnum maritalStatus;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @ManyToMany
    @JoinTable(
            name = "users_patients",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "patient_id", referencedColumnName = "id"))
    private Collection<Patient> patients;

    @OneToMany(mappedBy = "userApp")
    private Collection<Address> addresses;

    @OneToMany(mappedBy = "userApp")
    private Collection<Phone> phones;
}
