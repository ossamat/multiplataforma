package com.br.webservice.pessoa;

import java.io.Serializable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import agenda.PessoaServiceLocal;
import agenda.PessoaServiceRemote;
import br.com.agenda.entidades.Pessoa;

@Path("/pessoa")
public class PessoaResource implements Serializable{
	private static final long serialVersionUID = 1L;

	
@GET
@Path("/retornar")
@Produces(MediaType.APPLICATION_XML)
public Pessoa retornarPessoa() {
	
	Context ctx = null;
	PessoaServiceRemote pessoaService=null;
	Pessoa pessoaList=null;
	try {
		ctx = new InitialContext();
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		pessoaService = (PessoaServiceRemote) 
			ctx.lookup("ejb:" + "Agenda_EAR" + "/" + "Agenda_ejb" + "/"+"/" + "PessoaRemoteService" + "!" + "agenda.PessoaServiceRemote");
		 pessoaList= pessoaService.recuperarPessoa();
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	/*Pessoa p = new Pessoa();
	p.setId(1L);
	p.setIdFoto(1L);
	p.setNome("jose");
	p.setSexo("M");
	p.setDataNascimento(new Date());
	return p;
	*/
	return pessoaList;
}	
	
	
}
