package emprestimo.modelo.modelo;

/**
 * @author Carlos Alexandre
 */
public class JCidade {

    private Integer cid_cod;
    private String cid_nome;
    private JEstado estado;

    public Integer getCid_cod() {
        return cid_cod;
    }

    public void setCid_cod(Integer cid_cod) {
        this.cid_cod = cid_cod;
    }

    public String getCid_nome() {
        return cid_nome;
    }

    public void setCid_nome(String cid_nome) {
        this.cid_nome = cid_nome;
    }

    public JEstado getEstado() {
        return estado;
    }

    public void setEstado(JEstado estado) {
        this.estado = estado;
    }
}
