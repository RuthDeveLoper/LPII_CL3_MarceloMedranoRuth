package com.bd.cl3.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_productocl3")
public class TblProducto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproductocl3; 
	private String nombrecl3; 
	private double precioventacl3; 
	 private int stock;
	 private double preciocompcl3; 
	 private String estadocl3;
	 private String descripcl3;
	 
	 //CONSTRUCTOR CON TODOS SUS ATRIBUTOS
	@Override
	public String toString() {
		return "TblProducto [idproductocl3=" + idproductocl3 + ", nombrecl3=" + nombrecl3 + ", precioventacl3="
				+ precioventacl3 + ", stock=" + stock + ", preciocompcl3=" + preciocompcl3 + ", estadocl3=" + estadocl3
				+ ", descripcl3=" + descripcl3 + ", getIdproductocl3()=" + getIdproductocl3() + ", getNombrecl3()="
				+ getNombrecl3() + ", getPrecioventacl3()=" + getPrecioventacl3() + ", getStock()=" + getStock()
				+ ", getPreciocompcl3()=" + getPreciocompcl3() + ", getEstadocl3()=" + getEstadocl3()
				+ ", getDescripcl3()=" + getDescripcl3() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	//METODOS GET Y SET
	public int getIdproductocl3() {
		return idproductocl3;
	}
	public void setIdproductocl3(int idproductocl3) {
		this.idproductocl3 = idproductocl3;
	}
	public String getNombrecl3() {
		return nombrecl3;
	}
	public void setNombrecl3(String nombrecl3) {
		this.nombrecl3 = nombrecl3;
	}
	public double getPrecioventacl3() {
		return precioventacl3;
	}
	public void setPrecioventacl3(double precioventacl3) {
		this.precioventacl3 = precioventacl3;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPreciocompcl3() {
		return preciocompcl3;
	}
	public void setPreciocompcl3(double preciocompcl3) {
		this.preciocompcl3 = preciocompcl3;
	}
	public String getEstadocl3() {
		return estadocl3;
	}
	public void setEstadocl3(String estadocl3) {
		this.estadocl3 = estadocl3;
	}
	public String getDescripcl3() {
		return descripcl3;
	}
	public void setDescripcl3(String descripcl3) {
		this.descripcl3 = descripcl3;
	} 
	
}

