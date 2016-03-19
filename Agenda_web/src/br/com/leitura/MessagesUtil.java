package br.com.leitura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


@ManagedBean(name = "messagesUtil")
@ViewScoped
public class MessagesUtil implements Serializable {

	public static final String MESSAGES = "messages.properties";
	public static final String RESOURCES = "resources";

	private static final long serialVersionUID = 1L;
	private static Properties props;
	private  Properties propert;

	private static Properties carregaArquivo() {
		props = new Properties();
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();

		HttpServletRequest request = (HttpServletRequest) externalContext
				.getRequest();

		File msg = new File(request.getSession().getServletContext()
				.getRealPath(RESOURCES)
				+ File.separator + MESSAGES);
		
		try {
			FileInputStream in = new FileInputStream(msg);
			props.load(in);
			in.close();

		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return props;
	}
	
	private  Properties carregaArquivoMsg() {
		Properties props = new Properties();
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();

		HttpServletRequest request = (HttpServletRequest) externalContext
				.getRequest();

		File msg = new File(request.getSession().getServletContext()
				.getRealPath(RESOURCES)
				+ File.separator + MESSAGES);
		
		try {
			FileInputStream in = new FileInputStream(msg);
			props.load(in);
			in.close();

		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return props;
	}

	public  String getValor(String chave) {
		if (propert == null) {

			propert = carregaArquivoMsg();
		}

		return (String) propert.getProperty(chave);
	}
	
	
	public static String getValorProper(String chave) {
		if (props == null) {

			props = carregaArquivo();
		}

		return (String) props.getProperty(chave);
	}
}