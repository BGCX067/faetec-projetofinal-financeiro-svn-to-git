package emprestimo.modelo.modelo;

/**
 * @author Cláudia Rocha
 */
public class JLogradouro {

    private Integer log_cod;
    private String log_desc;
    private Integer log_num;
    private String log_compl;
    private String log_cep;
    private JBairro bairro;
    private JTipoLogradouro tpl_Log;

    public Integer getLog_cod() {
        return log_cod;
    }

    public void setLog_cod(Integer log_cod) {
        this.log_cod = log_cod;
    }

    public String getLog_desc() {
        return log_desc;
    }

    public void setLog_desc(String log_desc) {
        this.log_desc = log_desc;
    }

    public Integer getLog_num() {
        return log_num;
    }

    public void setLog_num(Integer log_num) {
        this.log_num = log_num;
    }

    public String getLog_compl() {
        return log_compl;
    }

    public void setLog_compl(String log_compl) {
        this.log_compl = log_compl;
    }

    public String getLog_cep() {
        return log_cep;
    }

    public void setLog_cep(String log_cep) {
        this.log_cep = log_cep;
    }

    public JBairro getBairro() {
        return bairro;
    }

    public void setBairro(JBairro bairro) {
        this.bairro = bairro;
    }

    public JTipoLogradouro getTpl_Log() {
        return tpl_Log;
    }

    public void setTpl_Log(JTipoLogradouro tpl_Log) {
        this.tpl_Log = tpl_Log;
    }
}
