import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainForm {
    private ArrayList<Kurier> kuriery;
    private JPanel panel;
    private JButton kurierButton;

    public MainForm() {
        kurierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                klikKurier();
            }
        });
        this.kuriery = new ArrayList<Kurier>();
    }

    private void klikKurier() {
        var form = new KurierForm(this.kuriery, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public void setKuriery(ArrayList<Kurier> kuriery) {
        this.kuriery = kuriery;
    }
}
