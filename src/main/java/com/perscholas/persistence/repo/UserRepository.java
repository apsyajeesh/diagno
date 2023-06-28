package com.perscholas.persistence.repo;

import com.perscholas.persistence.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
