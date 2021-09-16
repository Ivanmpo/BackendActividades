package com.tienda.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.data.models.Venta;

@Repository
public interface VentaRepository extends CrudRepository<Venta,Long>{

	List<Venta> findAll();
}
