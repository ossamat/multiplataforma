package br.com.agenda.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;



@Entity ( name = "Pessoa")
@Table(name = "sia_pessoa")
@XmlRootElement
public class Pessoa  implements Serializable {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Nao criar setter para o id, visto que, possui uma sequence atrelada a entidade.
	 */
	@Id 
	@Column(name = "cd_pessoa", columnDefinition = "Integer")
	private Long id;


	@Column(name = "cd_foto", columnDefinition = "Integer")
	private Long idFoto;
	
	@Column(name = "nm_pessoa", length = 250)
	@NotNull
	private String nome;


	@Column(name = "sg_sexo", length = 1)
	private String sexo;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Date dataNascimento;
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(Long idFoto) {
		this.idFoto = idFoto;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	

	
}
