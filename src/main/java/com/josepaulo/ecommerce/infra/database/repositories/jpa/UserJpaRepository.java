package com.josepaulo.ecommerce.infra.database.repositories.jpa;

import java.util.List;

import com.josepaulo.ecommerce.infra.database.repositories.springdata.SpringDataUserRepository;
import org.springframework.stereotype.Repository;

import com.josepaulo.ecommerce.domain.entities.UserEntity;
import com.josepaulo.ecommerce.domain.repositories.IUserRepository;

@Repository
public class UserJpaRepository implements IUserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    public UserJpaRepository(SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public UserEntity save(UserEntity user) {
        return springDataUserRepository.save(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return springDataUserRepository.findAll();
    }

}
