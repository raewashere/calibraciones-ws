package com.pemex.logistica.censos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pemex.logistica.censos.entity.TransporteDucto;

@Repository
public interface TransporteDuctoRepository extends JpaRepository<TransporteDucto, Long> {

}
