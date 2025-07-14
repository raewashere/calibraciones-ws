package com.pemex.logistica.censos.service;

import java.util.List;

import com.pemex.logistica.censos.entity.ComputadoraFlujo;

public interface ComputadoraFlujoService {
    List<ComputadoraFlujo> findAll();
    ComputadoraFlujo findById(String id);
    ComputadoraFlujo save(ComputadoraFlujo computadoraFlujo);
    void deleteById(String id);
}
