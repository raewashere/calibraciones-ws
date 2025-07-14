package com.pemex.logistica.censos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pemex.logistica.censos.entity.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {

    // Additional query methods can be defined here if needed
    // For example:
    // List<Direccion> findByCiudad(String ciudad);
    // List<Direccion> findByCodigoPostal(String codigoPostal);
    // You can also use Spring Data JPA's query derivation feature to create methods based on naming conventions
    // Refer to the Spring Data JPA documentation for more details on query methods.
    
}
