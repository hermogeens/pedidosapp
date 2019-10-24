package com.pedidosapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotEmpty;




@Entity
public class Carga {

	@Id 
	@NotEmpty
	private String id;
	
	@NotEmpty
	private String dataCarga;

	@NotEmpty
	private String nomeMotorista;

	@NotEmpty
	private String unidade1;

	@NotEmpty
	private String unidade2;


	private String unidade3;

	@NotEmpty
	private Long capacidade;

	
	@ManyToOne
	private Pedido pedido;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDataCarga() {
		return dataCarga;
	}

	public void setDataCarga(String dataCarga) {
		this.dataCarga = dataCarga;
	}

	public String getNomeMotorista() {
		return nomeMotorista;
	}

	public void setNomeMotorista(String nomeMotorista) {
		this.nomeMotorista = nomeMotorista;
	}

	public String getUnidade1() {
		return unidade1;
	}

	public void setUnidade1(String unidade1) {
		this.unidade1 = unidade1;
	}

	public String getUnidade2() {
		return unidade2;
	}

	public void setUnidade2(String unidade2) {
		this.unidade2 = unidade2;
	}

	public String getUnidade3() {
		return unidade3;
	}

	public void setUnidade3(String unidade3) {
		this.unidade3 = unidade3;
	}

	public Long getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Long capacidade) {
		this.capacidade = capacidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
