package tomasVilla.dds.entities;

import java.util.ArrayList;
import java.util.List;

import tomasVilla.dds.exceptions.ErrorGenerarRemito;

public class Compra {

	int precio;

	List<Item> items;

	DocumentoComercial documentoComercial;

	boolean cerrada;

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		if (!cerrada) {
			this.precio = precio;			
		}
	}

	public List<Item> getItems() {
		return items;
	}

	public DocumentoComercial getDocumentoComercial() {
		return documentoComercial;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void setDocumentoComercial(DocumentoComercial documentoComercial) {
		this.documentoComercial = documentoComercial;
	}

	public boolean isCerrada() {
		return cerrada;
	}

	public void setCerrada(boolean cerrada) {
		this.cerrada = cerrada;
	}

	public int calcularValor() {
		int valor = 0;
		for (Item item : items) {
			valor += item.getValor();
		}
		return valor;
	}
	
	public void agregarItem(Item item){
		if (this.getItems() == null) {
			List<Item> items = new ArrayList<Item>();
			this.setItems(items);
		}
		this.items.add(item);
	}
	
	public Remito generarRemito() throws Exception{
		for (Item item : items) {
			if (!(item instanceof Articulo)) {
				throw new ErrorGenerarRemito("No se puede generar el remito ya que hay items que no son articulos");
			}
		}
		
		Remito remito = new Remito();
		remito.setTipo(1);
		remito.setNumero(2222);
		this.setDocumentoComercial(remito);
		
		
		return remito;
	}

}
