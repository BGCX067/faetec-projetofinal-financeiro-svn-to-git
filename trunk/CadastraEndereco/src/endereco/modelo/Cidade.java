package endereco.modelo;

/**
 * @author Carlos Alexandre
 */
public class Cidade {
    
    private Long cid_cod;
    private String cid_nome;
    private Estado estado;

    public Long getCid_cod() {
        return cid_cod;
    }

    public void setCid_cod(Long cid_cod) {
        this.cid_cod = cid_cod;
    }

    public String getCid_nome() {
        return cid_nome;
    }

    public void setCid_nome(String cid_nome) {
        this.cid_nome = cid_nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }   
}
