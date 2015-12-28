package endereco.modelo;

/**
 * @author Carlos Alexandre
 */
public class Estado {

    public Long est_cod;
    private String est_uf;
    private String est_nome;

    public Long getEst_cod() {
        return est_cod;
    }

    public void setEst_cod(Long est_cod) {
        this.est_cod = est_cod;
    }

    public String getEst_uf() {
        return est_uf;
    }

    public void setEst_uf(String est_uf) {
        this.est_uf = est_uf;
    }

    public String getEst_nome() {
        return est_nome;
    }

    public void setEst_nome(String est_nome) {
        this.est_nome = est_nome;
    }
}
