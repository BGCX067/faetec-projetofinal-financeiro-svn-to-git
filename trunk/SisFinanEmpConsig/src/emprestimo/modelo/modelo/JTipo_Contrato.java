package emprestimo.modelo.modelo;

/**
 * @author Carlos Alexandre
 */
public class JTipo_Contrato {

    private Long tpcont_cod;
    private String tpcont_desc;


    public Long getTpcont_cod() {
        return tpcont_cod;
    }

      public void setTpcont_cod(Long tpcont_cod) {
        this.tpcont_cod = tpcont_cod;
    }

    public String getTpcont_desc() {
        return tpcont_desc;
    }

    public void setTpcont_desc(String tpcont_desc) {
        this.tpcont_desc = tpcont_desc;
    }
}
