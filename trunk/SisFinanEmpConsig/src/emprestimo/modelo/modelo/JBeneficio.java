package emprestimo.modelo.modelo;

import emprestimo.modelo.modelo.*;


/**
 * @author Carlos Alexandre
 */
public class JBeneficio {

    private Integer ben_cod;
    private int ben_numero;
    private int ben_codinss;
    private String ben_desc;
    private Double ben_renda;
    private JCliente cliente;

    public Integer getBen_cod() {
        return ben_cod;
    }

    public void setBen_cod(Integer ben_cod) {
        this.ben_cod = ben_cod;
    }

    public int getBen_numero() {
        return ben_numero;
    }

    public void setBen_numero(int ben_numero) {
        this.ben_numero = ben_numero;
    }

    public int getBen_codinss() {
        return ben_codinss;
    }

    public void setBen_codInss(int ben_codinss) {
        this.ben_codinss = ben_codinss;
    }

    public String getBen_desc() {
        return ben_desc;
    }

    public void setBen_desc(String ben_desc) {
        this.ben_desc = ben_desc;
    }

    public Double getBen_renda() {
        return ben_renda;
    }

    public void setBen_renda(Double ben_renda) {
        this.ben_renda = ben_renda;
    }

    public JCliente getCliente() {
        return cliente;
    }

    public void setCliente(JCliente cliente) {
        this.cliente = cliente;
    }

}
