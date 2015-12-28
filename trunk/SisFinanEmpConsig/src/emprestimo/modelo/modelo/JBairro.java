package emprestimo.modelo.modelo;

/**
 * @author Cláudia Rocha
 */
public class JBairro {

    private Integer bai_cod;
    private String bai_nome;
    private JCidade cidade;

    public Integer getBai_cod() {
        return bai_cod;
    }

    public void setBai_cod(Integer bai_cod) {
        this.bai_cod = bai_cod;
    }

    public String getBai_nome() {
        return bai_nome;
    }

    public void setBai_nome(String bai_nome) {
        this.bai_nome = bai_nome;
    }

    public JCidade getCidade() {
        return cidade;
    }

    public void setCidade(JCidade cidade) {
        this.cidade = cidade;
    }
}
