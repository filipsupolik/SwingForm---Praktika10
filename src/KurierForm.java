import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class KurierForm {
    private JPanel kurierPanel;
    private JPanel buttonPanel;
    private JButton pridajButton;
    private JButton vymazButton;
    private JTable kurierTable;
    private ArrayList<Kurier> kuriery;
    private MainForm mainForm;
    private DefaultTableModel defaultTableModel;

    public KurierForm(ArrayList<Kurier> kuriery, MainForm mainForm) {
        this.kuriery = kuriery;
        this.mainForm = mainForm;
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(this.kurierPanel);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        this.defaultTableModel = new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "id", "Meno", "Priezvisko", "Plat"
                }
        );
        this.kurierTable.setModel(this.defaultTableModel);
        this.kurierTable.getTableHeader().setReorderingAllowed(false);
        for (Kurier kurier : this.kuriery ) {
            this.pridajKuriera(kurier);
        }
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveArrayList();
            }
        });
        vymazButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vymazButtonActPer();
            }
        });
        pridajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pridajButtonActPer();
            }
        });
    }

    public void saveArrayList() {
        this.mainForm.ArrayListUpdate(this.kuriery);
    }

    public void pridajKuriera(Kurier kurier) {
        if (kurier != null) {
            this.defaultTableModel.addRow(new Object[]{kurier.getId(), kurier.getMeno(), kurier.getPriezvisko(), kurier.getPlat()});
            this.kuriery.add(kurier);
        }
    }

    public void pridajButtonActPer() {
        var okno = new OknoPridajKuriera(this);
    }

    public void vymazButtonActPer() {
        int cisloRiadku = this.kurierTable.getSelectedRow();
        if (cisloRiadku >= 0) {
            this.kuriery.remove(cisloRiadku);
            this.kurierTable.remove(cisloRiadku);
        }
    }

}
