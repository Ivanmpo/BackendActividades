package com.tienda.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.tienda.data.models.Producto;
import com.tienda.data.repository.ProductoRepository;



@Service
public class ProductoService {

	private final ProductoRepository prodRepo;
	public ProductoService(ProductoRepository productoRepository) {
		this.prodRepo = productoRepository;
	}
	
	public Producto crear(@Valid Producto producto) {
		return prodRepo.save(producto);
	}

	public List<Producto> findAll() {
		return prodRepo.findAll();
	}
	
	public void eliminar(Long id) {
		prodRepo.deleteById(id);
	}

	public Producto buscar(Long id) {
		Optional<Producto> oProducto = prodRepo.findById(id);
		if(oProducto.isPresent()) {
			return oProducto.get();
		}
		return null;
	}

	public void modificar(@Valid Producto producto) {
		prodRepo.save(producto);
		
	}
	
}
