package com.perscholas.persistence.repo;

import com.perscholas.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>
{

    Role findByName(String name);
}
