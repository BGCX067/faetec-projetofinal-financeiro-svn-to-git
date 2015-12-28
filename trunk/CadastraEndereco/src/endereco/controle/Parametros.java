package endereco.controle;

import java.util.prefs.*;

public class Parametros {
    
    // MySQL 
    private static final String jdbcDriver = "com.mysql.jdbc.Driver";
    private static final String defaultUrl = "jdbc:mysql://127.0.0.1:3306/";
    private static final String defaultDatabase = "sisfinanemprestimo";
    

    private Preferences prefs = Preferences.userNodeForPackage(Parametros.class);
    
    public String getDatabase() {
        return prefs.get("sisfinanemprestimo", defaultDatabase);
    }

    public void setDatabase(String database) {
        //prefs.put("database", database);
	prefs.put("sisfinanemprestimo", database);
    }

    public String getJdbcUrl() {
        return defaultUrl + getDatabase();// + defaultOptions;
    }
    
    public String getJdbcDriver() {
        return jdbcDriver;
    }

}
