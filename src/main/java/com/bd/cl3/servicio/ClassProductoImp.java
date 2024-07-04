package com.bd.cl3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.cl3.modelo.TblProducto;
import com.bd.cl3.repositorio.IProductoRepositorio;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ClassProductoImp implements IProductoServicio{

	//aplico la inyeccion de dependencia..
	@Autowired 
	private IProductoRepositorio iproductorepository;

	@Override
	public List<TblProducto> ListadoProducto() {
		return (List<TblProducto>)iproductorepository.findAll();
	}

	@Override
	public void RegistrarProducto(TblProducto producto) {
		//Registro datos
		iproductorepository.save(producto);
		
	}

	@Override
	public TblProducto BuscarporId(Integer id) {
		//busco por id
		
		return iproductorepository.findById(id).orElse(null);
	}

	@Override
	public void Eliminar(Integer id) {
		//Eliminar por id
		iproductorepository.deleteById(id);
		
	}
	
	
} //fin de la clase