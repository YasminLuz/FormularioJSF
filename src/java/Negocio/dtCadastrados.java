package Negocio;


import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Yasmin
 */
//@ManagedBean(name ="dtCadastrados")
//@ViewScoped

public class dtCadastrados implements Serializable{

    private ArrayList<FormularioDTO> cadastrados;
     
    @ManagedProperty("#{carService}")
    private ConexaoDAO con;
 
    @PostConstruct
    public void init() {
        cadastrados = con.AllList();
    }
     
    public ArrayList<FormularioDTO> getCadastrados() {
        return cadastrados;
    }
 
//    public void setCadastrados(FormularioDTO service) {
//        this.con = service;
//    }
//}
}

