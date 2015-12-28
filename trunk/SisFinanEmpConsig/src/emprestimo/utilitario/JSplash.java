package emprestimo.utilitario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 * @author Carlos Alexandre
 */
public class JSplash extends JWindow {

    private JProgressBar progressBar;

    public JSplash(String jpeg) {

        JPanel panel;
        Image imagem = Toolkit.getDefaultToolkit().getImage(getClass().getResource(jpeg));
        JLabel label = new JLabel(new ImageIcon(imagem));

        add(label, BorderLayout.CENTER);

        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));

        progressBar = new JProgressBar(JProgressBar.HORIZONTAL);
        progressBar.setStringPainted(true);
        panel.add(progressBar);

        add(panel, BorderLayout.SOUTH);

        pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = label.getPreferredSize();
        setLocation(screenSize.width / 2 - (labelSize.width / 2), screenSize.height / 2 - (labelSize.height / 2));
        setAlwaysOnTop(true);

    }

    public void showSplash() {
        setVisible(true);
    }

    public void hideSplash() {
        setVisible(false);
        dispose();
    }

    public void setDisplayString(int v, String s) {
        progressBar.setString(s);
        progressBar.setValue(v);
    }

    public void setProgressMaxMin(int min, int max) {
        progressBar.setMaximum(max);
        progressBar.setMinimum(min);
    }
    
    public void startDatabase() {
        final String dir = System.getProperty("user.dir");
        //final String dir = "C:\\SisSalaoBelissima1.0";
        Process input = null;
        try {
            input = Runtime.getRuntime().exec("cmd /c start \"\" " + dir + "\\wampmanager");
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(JSplash.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(input.equals(true)){
            JOptionPane.showMessageDialog(null, "Conexão!");
        }
    }
}
