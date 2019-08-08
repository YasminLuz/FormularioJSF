package Negocio;

import java.util.ArrayList;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 *
 * @author Yasmin
 */

@Named(value = "form")
@RequestScoped

public class FormularioDTO {
    private String emailDestinatario, emailRemetente, nomeDestinatario, nomeRemetente; 
    private long telefaxDestinatario, telefaxRemetente;
    private Date data;
  

    public FormularioDTO() {
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public long getTelefaxDestinatario() {
        return telefaxDestinatario;
    }

    public void setTelefaxDestinatario(long telefaxDestinatario) {
        this.telefaxDestinatario = telefaxDestinatario;
    }

    public long getTelefaxRemetente() {
        return telefaxRemetente;
    }

    public void setTelefaxRemetente(long telefaxRemetente) {
        this.telefaxRemetente = telefaxRemetente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getNomeRemetente() {
        return nomeRemetente;
    }

    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }
    
    public ArrayList<FormularioDTO> getCadastrados(){
        return ConexaoDAO.getInstance().AllList();
    }
    
    public void enviar() {
        FacesContext context = FacesContext.getCurrentInstance();   
        ConexaoDAO.getInstance().create(this);
        context.addMessage(null, new FacesMessage("Sucesso", "Salvo no banco de dados!" ));
    }
    
    public String redirecionaCadastro(){
        return "index";
    }
    
    public String redirecionaLista(){
        return "list";
    }
    
    public String redirecionaInicio(){
        return "home";
    }
    
}
