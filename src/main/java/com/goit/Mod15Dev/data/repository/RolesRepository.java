package com.goit.Mod15Dev.data.repository;
import com.goit.Mod15Dev.data.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.goit.Mod15Dev.utils.UserRole;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Long> {

    Optional<RolesEntity> findByName(UserRole name);

    @Query("FROM RoleEntity re WHERE re.name IN :names")
    Set<RolesEntity> findByNames(@Param("names") Collection<UserRole> names);
}
