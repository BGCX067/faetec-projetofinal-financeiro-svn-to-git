package emprestimo.modelo.modelo;

/**
 * @author Carlos Alexandre
 */
public class JFuncionario {

    private Long func_cod;
    private String func_nome;
    private Long func_mat;
    private JLogradouro logradouro;

    public Long getFunc_cod() {
        return func_cod;
    }

    public void setFunc_cod(Long func_cod) {
        this.func_cod = func_cod;
    }

    public String getFunc_nome() {
        return func_nome;
    }

    public void setFunc_nome(String func_nome) {
        this.func_nome = func_nome;
    }

    public Long getFunc_mat() {
        return func_mat;
    }

    public void setFunc_mat(Long func_mat) {
        this.func_mat = func_mat;
    }

    public JLogradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(JLogradouro logradouro) {
        this.logradouro = logradouro;
    }
}
