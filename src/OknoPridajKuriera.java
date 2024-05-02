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
        okno = new JFrame("KurierAddForm");
        okno.setContentPane(this.panel);
        okno.setVisible(true);
        okno.pack();
        zrusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.zrusButtonActPer();
            }

            private void zrusButtonActPer() {
                okno.dispose();
            }
        });
        potvrdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pridajButtonActPer();
            }
        });
    }
    public void pridajButtonActPer() {
        StringBuilder warnings = new StringBuilder();
        if (this.idTextField.getText().isEmpty()) {
            warnings.append("ID kuriera musi byt vyplnene\n");
        } else {
            try {
                int id = Integer.parseInt(this.idTextField.getText());
            } catch (NumberFormatException e) {
                warnings.append("ID musi byt cislo\n");
            }
        }
        if (this.MenoTextField.getText().isEmpty()) {
            warnings.append("Meno musi byt vyplnene\n");
        } else {
            String meno = this.MenoTextField.getText();
        }

        if (this.PriezviskoTextField.getText().isEmpty()) {
            warnings.append("Priezvisko musi byt vyplnene\n");
        } else {
            String priezvisko = this.PriezviskoTextField.getText();
        }

        if (this.PlatTextField.getText().isEmpty()) {
            warnings.append("Plat kuriera musi byt vyplnene\n");
        } else {
            try {
                int plat = Integer.parseInt(this.PlatTextField.getText());
            } catch (NumberFormatException e) {
                warnings.append("Plat musi byt cislo\n");
            }
        }

        Kurier kurier = new Kurier(0, "", "", 0);
        if (warnings.length() > 0) {
            JOptionPane.showMessageDialog(this.okno, warnings.toString(), "Vstupne upozornenia", JOptionPane.WARNING_MESSAGE);
        } else {
            kurier.setId(Integer.parseInt(this.idTextField.getText()));
            kurier.setMeno(this.MenoTextField.getText());
            kurier.setPriezvisko(this.PriezviskoTextField.getText());
            kurier.setPlat(Double.parseDouble(this.PlatTextField.getText()));
            this.okno.dispose();
        }
        this.kurierForm.pridajKuriera(kurier);
    }
}
