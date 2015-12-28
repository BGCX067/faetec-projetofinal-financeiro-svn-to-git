package emprestimo.modelo.modelo.sistema;

import com.mysql.jdbc.Blob;
import emprestimo.modelo.modelo.JFuncionario;

/**
 * @author Cl�udia Rocha
 */
public class JConta_Usuario {

    private String usu_login;
    private String usu_senha;
    private Blob usu_foto;
    private JNivel_Acesso nivel;
    private JFuncionario funcionario;

    public String getUsu_login() {
        return usu_login;
    }

    public void setUsu_login(String usu_login) {
        this.usu_login = usu_login;
    }

    public String getUsu_senha() {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }

    public Blob getUsu_foto() {
        return usu_foto;
    }

    public void setUsu_foto(Blob usu_foto) {
        this.usu_foto = usu_foto;
    }

    public JNivel_Acesso getNivel() {
        return nivel;
    }

    public void setNivel(JNivel_Acesso nivel) {
        this.nivel = nivel;
    }

    public JFuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(JFuncionario funcionario) {
        this.funcionario = funcionario;
    }
}
