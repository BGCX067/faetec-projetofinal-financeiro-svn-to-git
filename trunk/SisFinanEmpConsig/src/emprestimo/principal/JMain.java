package emprestimo.principal;

import emprestimo.utilitario.JSplash;
import emprestimo.visao.JLogin;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Carlos Alexandre
 */
public class JMain {

    private static JSplash splash;
    public static JLogin login;
    public static UIManager.LookAndFeelInfo[] temas;
    public static String[] strtemas;
    
    public JMain() {
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, Exception {
        // TODO code application logic here
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            temas = UIManager.getInstalledLookAndFeels();
            strtemas = new String[temas.length];
            for (int x=0; x < temas.length; x++) {
                strtemas[x] = temas[x].getName();
            }
            mudarTemas(3);
            //Tradução dos Botões
            UIManager.put("OptionPane.yesButtonText", "Sim");
            UIManager.put("OptionPane.noButtonText", "Não");
            UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        } catch (Exception e) {
        }

           LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
        for (LookAndFeelInfo lookAndFeelInfo : lafs) {
            System.out.println(lookAndFeelInfo.getName());
        }


        String sistema_operacional = System.getProperty("os.name");
        String versao_java = System.getProperty("java.version");

        splash = new JSplash("/emprestimo/imagens/figuras/sisfec_logo.jpg");
        splash.showSplash();
        splash.setProgressMaxMin(0, 100);


        try {
            TimeUnit.SECONDS.sleep(1);
            splash.setDisplayString(10, "Inicializando o Sistema....");
        } catch (InterruptedException ex) {
            Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            TimeUnit.SECONDS.sleep(1);
            splash.setDisplayString(25, "Carregando os Módulos....");
        } catch (InterruptedException ex) {
            Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            TimeUnit.SECONDS.sleep(0);
            //splash.startDatabase();
        } catch (InterruptedException ex) {
            Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            TimeUnit.SECONDS.sleep(1);
            splash.setDisplayString(44, "Conectando ao Banco de Dados....");
        } catch (InterruptedException ex) {
            Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            TimeUnit.SECONDS.sleep(1);
            splash.setDisplayString(57, "Carregando a Interface....");
        } catch (InterruptedException ex) {
            Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            TimeUnit.SECONDS.sleep(1);
            splash.setDisplayString(74, "Verificando Compatibilidade com o Sistema Operacional " + sistema_operacional);
        } catch (InterruptedException ex) {
            Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            TimeUnit.SECONDS.sleep(1);
            splash.setDisplayString(89, "Utilizando Java Version " + versao_java);
        } catch (InterruptedException ex) {
            Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            TimeUnit.SECONDS.sleep(1);
            splash.setDisplayString(98, "Abrindo o SisFEC!");
        } catch (InterruptedException ex) {
            Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            TimeUnit.SECONDS.sleep(2);
            splash.setDisplayString(100, null);
        } catch (InterruptedException ex) {
            Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        splash.hideSplash();
        login = new JLogin(null, true);
        login.setVisible(true);

    }

    public static void mudarTemas(int tema) {
    try {
        temas = UIManager.getInstalledLookAndFeels();
        UIManager.setLookAndFeel(temas[tema].getClassName());

    } catch (Exception e) {
        e.printStackTrace();
        }
    }
}
