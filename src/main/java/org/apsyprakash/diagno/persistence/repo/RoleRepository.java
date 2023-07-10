package org.apsyprakash.diagno.persistence.repo;

import org.apsyprakash.diagno.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>
{

    Role findByName(String name);
}
