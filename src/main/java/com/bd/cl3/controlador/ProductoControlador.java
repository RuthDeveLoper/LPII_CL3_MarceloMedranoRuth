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

	//inyeccion de dependencia...

			@Autowired
			
			private IProductoServicio iproductoservicio;

			//creamos el metodo listado..
			
			@GetMapping("ListadoProducto")

			public String ListadoProducto(Model modelo) {

				//recuperamos el listado de autos..

				List<TblProducto> listado=iproductoservicio.ListadoProducto();

				for(TblProducto lis:listado) {

			System.out.println("codigo "+lis.getIdproductocl3()+" "+" nombre "+lis.getNombrecl3());

				}

				//enviamos la data hacia la vista..

				modelo.addAttribute("listado",listado);

				//retornamos

				return "/Vistas/ListadoProducto";

				

			}  //fin del metodo listado auto...

			

			//creamos los respectivos para metodos para registrar...

			@GetMapping("/RegistrarProducto")

			public String RegistrarProducto(Model modelo) {

				//realizamos la respectiva instancia...

				TblProducto cliente=new TblProducto();

				//enviamos a la vista...

				modelo.addAttribute("regproducto",cliente);

				//retornamos

				return "/Vistas/FrmCrearProducto";

				

			}  //fin del metodo registrar.

			

			//realizamos el mapeo con postmapping

			@PostMapping("/GuardarProducto")

			public String GuardarProducto(@ModelAttribute TblProducto  cliente,Model modelo) {

				iproductoservicio.RegistrarProducto(cliente);

				System.out.println("dato registrado en la bd");

				//retornamos al listado...

				return "redirect:/vistas/ListadoProducto";	

			}  //fin del metodo string...

			

			//*****************crearmos el metodo editar...

			@GetMapping("/editar/{id}")

			public String Editar(@PathVariable("id") Integer idcliente,Model modelo) {

				TblProducto cliente=iproductoservicio.BuscarporId(idcliente);

				//enviamos hacia la vista...

				modelo.addAttribute("regproducto",cliente);

				//retornamos el frmcrearcliente...

				return "/Vistas/FrmCrearProducto";	

			}  //fin del metodo editar...
	
	
			
			@GetMapping("/eliminar/{id}")
		    public String eliminar(@PathVariable("id") Integer idProducto, Model modelo) {
		        iproductoservicio.Eliminar(idProducto);
		        System.out.println("dato Eliminado en la bd");
		        return "redirect:/vistas/ListadoProducto";
		    }
			
			
} //fin de controlador