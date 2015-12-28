package emprestimo.modelo.modelo;

import java.util.Date;



/**
 * @author Carlos Alexandre
 */
public class JCliente {

    private Integer cli_cod;
    private String cli_cpf;
    private String cli_nome;
    private String cli_sexo;
    private Date cli_dtnasc;
    private String cli_email;
    private String cli_estadocivil;
    private JTelefone telefone;
    private JLogradouro logradouro;

    public Integer getCli_cod() {
        return cli_cod;
    }

    public void setCli_cod(Integer cli_cod) {
        this.cli_cod = cli_cod;
    }

    public String getCli_cpf() {
        return cli_cpf;
    }

    public void setCli_cpf(String cli_cpf) {
        this.cli_cpf = cli_cpf;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    public String getCli_sexo() {
        return cli_sexo;
    }

    public void setCli_sexo(String cli_sexo) {
        this.cli_sexo = cli_sexo;
    }

    public Date getCli_dtnasc() {
        return cli_dtnasc;
    }

    public void setCli_dtnasc(Date cli_dtnasc) {
        this.cli_dtnasc = cli_dtnasc;
    }

    public String getCli_email() {
        return cli_email;
    }

    public void setCli_email(String cli_email) {
        this.cli_email = cli_email;
    }

    public String getCli_estadocivil() {
        return cli_estadocivil;
    }

    public void setCli_estadocivil(String cli_estadocivil) {
        this.cli_estadocivil = cli_estadocivil;
    }

    public JTelefone getTelefone() {
        return telefone;
    }

    public void setTelefone(JTelefone telefone) {
        this.telefone = telefone;
    }

    public JLogradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(JLogradouro logradouro) {
        this.logradouro = logradouro;
    }



}
