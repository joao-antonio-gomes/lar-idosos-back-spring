package com.laridosos.rest.user;

import com.laridosos.rest.role.RoleEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserApp, Long> {

    @Query("SELECT a FROM UserApp a join a.roles r WHERE (:name is null or LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND r.name = :role")
    Page<UserApp> findAllByNameIgnoreCaseContainingAndRolesEquals(String name, Pageable toPageable, RoleEnum role);

    Optional<UserApp> findByIdAndRolesNameEquals(Long id, RoleEnum role);
}
