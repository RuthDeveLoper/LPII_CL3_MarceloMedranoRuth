package com.bd.cl3.servicio;

import java.util.List;

import com.bd.cl3.modelo.TblProducto;

public interface IProductoServicio {
	//MIS METODOS PARA MI CRUD
	public List<TblProducto> ListadoProducto();
	public void RegistrarProducto(TblProducto producto);
	public TblProducto BuscarporId(Integer id);
	public void Eliminar(Integer id);
	
	
}      //FIN DE MI INTERFACE