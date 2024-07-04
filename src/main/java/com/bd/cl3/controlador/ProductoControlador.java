package com.bd.cl3.controlador;

import java.util.List;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.cl3.modelo.TblProducto;
import com.bd.cl3.servicio.IProductoServicio;


@Controller
@RequestMapping("/vistas")
public class ProductoControlador {

	//Realizo inyecion

			@Autowired
			private IProductoServicio iproductoservicio;
			//MEtodo lista
			
			@GetMapping("ListadoProducto")

			public String ListadoProducto(Model modelo) {

				List<TblProducto> listado=iproductoservicio.ListadoProducto();

				for(TblProducto lis:listado) {

			System.out.println("codigo "+lis.getIdproductocl3()+" "+" nombre "+lis.getNombrecl3());

				}
				//ENVIO
				modelo.addAttribute("listado",listado);

				return "/Vistas/ListadoProducto";

			}//FIN

		
			// METODO PARA REGISTRO
			@GetMapping("/RegistrarProducto")

			public String RegistrarProducto(Model modelo) {

				TblProducto cliente=new TblProducto();

				//ENVIO

				modelo.addAttribute("regproducto",cliente);

				//LUEGO RETORNO
				return "/Vistas/FrmCrearProducto";

			} //FIN METODO REGISTRO

		
			//REALIZO MAPEO

			@PostMapping("/GuardarProducto")

			public String GuardarProducto(@ModelAttribute TblProducto  cliente,Model modelo) {

				iproductoservicio.RegistrarProducto(cliente);

				System.out.println("dato registrado en la bd");

				//RETORNO MI LISTA
				return "redirect:/vistas/ListadoProducto";	

			} //FIN DE MI METODO

		
			@GetMapping("/editar/{id}")

			public String Editar(@PathVariable("id") Integer idcliente,Model modelo) {

				TblProducto cliente=iproductoservicio.BuscarporId(idcliente);

				//ENVIO
				modelo.addAttribute("regproducto",cliente);

				
				return "/Vistas/FrmCrearProducto";	

			}  //FIN DE MI METODO 
	
	
			@GetMapping("/eliminar/{id}")
		    public String eliminar(@PathVariable("id") Integer idProducto, Model modelo) {
		        iproductoservicio.Eliminar(idProducto);
		        System.out.println("dato Eliminado en la bd");
		        return "redirect:/vistas/ListadoProducto";
		    }
			
}    //FIN DE MI CONTROLADOR