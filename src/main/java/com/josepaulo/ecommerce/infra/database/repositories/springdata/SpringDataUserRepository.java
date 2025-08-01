package com.josepaulo.ecommerce.infra.database.repositories.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josepaulo.ecommerce.domain.entities.UserEntity;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {

}
