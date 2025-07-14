package com.pemex.logistica.censos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pemex.logistica.censos.entity.TipoSensor;

@Repository
public interface TipoSensorRepository extends JpaRepository<TipoSensor, Long> {

    // Additional query methods can be defined here if needed
    
}
