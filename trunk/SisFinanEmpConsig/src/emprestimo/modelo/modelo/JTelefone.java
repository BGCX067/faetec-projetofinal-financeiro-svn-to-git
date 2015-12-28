package emprestimo.modelo.modelo;

/**
 * @author Carlos Alexandre
 */
public class JTelefone {

    private Long tel_cod;
    private String tel_codarea;
    private String tel_num;
    private String tel_tipo;
    private JCliente cliente;

    public Long getTel_cod() {
        return tel_cod;
    }

    public void setTel_cod(Long tel_cod) {
        this.tel_cod = tel_cod;
    }

    public String getTel_codarea() {
        return tel_codarea;
    }

    public void setTel_codarea(String tel_codarea) {
        this.tel_codarea = tel_codarea;
    }

    public String getTel_num() {
        return tel_num;
    }

    public void setTel_num(String tel_num) {
        this.tel_num = tel_num;
    }

    public String getTel_tipo() {
        return tel_tipo;
    }

    public void setTel_tipo(String tel_tipo) {
        this.tel_tipo = tel_tipo;
    }

    public JCliente getCliente() {
        return cliente;
    }

    public void setCliente(JCliente cliente) {
        this.cliente = cliente;
    }
}
