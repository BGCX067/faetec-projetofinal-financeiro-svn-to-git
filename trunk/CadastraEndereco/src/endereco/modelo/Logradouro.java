package endereco.modelo;

/**
 *
 * @author Carlos Alexandre
 */
public class Logradouro {
    
    private Long log_cod;
    private String log_desc;
    private Integer log_num;
    private String log_compl;
    private Bairro bairro;
    private TipoLogradouro tpl_Log;

    public Long getLog_cod() {
        return log_cod;
    }

    public void setLog_cod(Long log_cod) {
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

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public TipoLogradouro getTpl_Log() {
        return tpl_Log;
    }

    public void setTpl_Log(TipoLogradouro tpl_Log) {
        this.tpl_Log = tpl_Log;
    }
    
}
