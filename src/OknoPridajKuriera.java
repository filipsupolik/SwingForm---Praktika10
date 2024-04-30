import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoPridajKuriera {
    private JPanel panel;
    private JTextField idTextField;
    private JTextField MenoTextField;
    private JTextField PriezviskoTextField;
    private JTextField PlatTextField;
    private JButton potvrdButton;
    private JButton zrusButton;
    private JLabel IDLabel;
    private JLabel menoLabel;
    private JLabel priezviskoLabel;
    private JLabel platLabel;
    private JFrame okno;
    private KurierForm kurierForm;

    public OknoPridajKuriera(KurierForm kurierForm) {
        this.kurierForm = kurierForm;
        var frame = new JFrame();
        frame.setContentPane(this.panel);
        frame.setVisible(true);
        frame.pack();
        zrusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.zrusButtonActPer();
            }

            private void zrusButtonActPer() {
                frame.dispose();
            }
        });
        potvrdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pridajButtonActPer();
            }
        });
    }
    //TODO: in progress, dont know to make this method. Create instance Kurier
    public void pridajButtonActPer() {
        StringBuilder warnings = new StringBuilder();
        // TODO: atributom meno, priezvisko, plat,id priradit pociatocne hodnoty
        // prazdne retazce alebo 0
        if (this.idTextField.getText().isEmpty()) {
            warnings.append("ID kuriera musi byt vyplnene");
        } else {
            try {
                int id = Integer.parseInt(this.idTextField.getText());
            } catch (NumberFormatException e) {
                warnings.append("ID musi byt cislo");
            }
        }
        if (this.MenoTextField.getText().isEmpty()) {
            warnings.append("Meno musi byt vyplnene");
        } else {
            String meno = this.MenoTextField.getText();
        }

        if (this.PriezviskoTextField.getText().isEmpty()) {
            warnings.append("Priezvisko musi byt vyplnene");
        } else {
            String priezvisko = this.PriezviskoTextField.getText();
        }

        if (this.PlatTextField.getText().isEmpty()) {
            warnings.append("Plat kuriera musi byt vyplnene");
        } else {
            try {
                int plat = Integer.parseInt(this.PlatTextField.getText());
            } catch (NumberFormatException e) {
                warnings.append("Plat musi byt cislo");
            }
        }

        Kurier kurier = null;
        if (warnings.length() > 0) {
            JOptionPane.showMessageDialog(fra);
        }
    }
}
