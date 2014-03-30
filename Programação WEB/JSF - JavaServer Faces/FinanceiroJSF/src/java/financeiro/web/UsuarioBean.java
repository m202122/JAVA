package financeiro.web;

import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean(name="usuarioBean") // ManagedBean tem como função declarar a classe como uma ManagedBean, para que possa ser acessível nas páginas JSF
								 // Ela tem um atributo interno 'name' que declara o nome dessa ManagedBean, porém isso não é obrigatório.
@RequestScoped
public class UsuarioBean {
    
    private String nome, email, senha, confirmaSenha;
    
    @ManagedProperty(value="#{param}")
    
    private Map<String,String> parametros;

    public Map<String, String> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, String> parametros) {
        this.parametros = parametros;
    }
           
    public String novo() { // Método usado em index.xhtml para chamar a página usuario.xhtml para criação de um novo usuário
        return "usuario";
    }
    
    public String salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if(!this.senha.equalsIgnoreCase(this.confirmaSenha)) { // Se a senha de confirmação não bate, permanece na página de usuario.xhtml
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Senha confirmada incorretamente",""));
            return "usuario";
        }
        // Salva usuário. Abre a página mostraUsuario.xhtml com as informações do usuário cadastrado.
        return "mostraUsuario";
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
    
}
