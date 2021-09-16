package com.tienda.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;


import com.tienda.data.models.Venta;
import com.tienda.data.repository.VentaRepository;

@Service
public class VentaService {

	private final VentaRepository vr;
	public VentaService(VentaRepository vr) {
		this.vr = vr;
	}
	
	public Venta crearVenta(@Valid Venta venta) {
		return vr.save(venta);
	}

	public List<Venta> findAll() {
		return vr.findAll();
	}
	
	public void eliminarVenta(Long id) {
		vr.deleteById(id);
	}

	public Venta buscarVenta(Long id) {
		Optional<Venta> oVenta = vr.findById(id);
		if(oVenta.isPresent()) {
			return oVenta.get();
		}
		return null;
	}

	public void modificarVenta(@Valid Venta venta) {
		vr.save(venta);
		
	}
}
