package com.pemex.logistica.censos.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pemex.logistica.censos.entity.ComputadoraFlujo;

@Repository
public interface ComputadoraFlujoRepository extends JpaRepository<ComputadoraFlujo, String> {

    // Additional query methods can be defined here if needed
    // For example:
    // List<ComputadoraFlujo> findByEquipoId(Long equipoId);
    // List<ComputadoraFlujo> findByFechaBetween(Date startDate, Date endDate);
    // You can also use Spring Data JPA's query derivation feature to create methods
    // based on naming conventions
    // Refer to the Spring Data JPA documentation for more details on query methods.

}
