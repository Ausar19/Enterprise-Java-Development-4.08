package EnterpriseJavaDevelopment408.repositories;

import EnterpriseJavaDevelopment408.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
