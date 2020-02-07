import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class EmployeeGUI extends JFrame {
    private JPanel frame;
    private JButton betoltButton;
    private JButton listaButton;
    private JButton bezarButton;
    private JComboBox filetipusComboBox;
    private JTextField filenameTextBox;
    private JTextField fileCountTextBox;
    private String forras;
    private File fbe;
    private EmployeeTableModel etm;

    public EmployeeGUI() {
        bezarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        filetipusComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forras = (String) filetipusComboBox.getSelectedItem();
                filenameTextBox.setText(forras);
                fileCountTextBox.setText("4");
            }
        });
        betoltButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (forras.equals("")) {
                    JOptionPane.showMessageDialog(null, "Válassz ki egy forrást!", "Hibaüzenet", 0);
                }

                if (forras.equals(".csv")) {
                    FileDialog filediag = new FileDialog(new Frame(), " ", FileDialog.LOAD);

                    filediag.setFile("*.csv");
                    filediag.setVisible(true);
                    if (filediag.getFile() != null) {
                        fbe = new File(filediag.getDirectory(), filediag.getFile());
                        String befnev = filediag.getFile();
                        filenameTextBox.setText(befnev);
                        try {
                            FileManager.CSVReader(fbe,etm);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }

                    }
                }
                fileCountTextBox.setText("" + etm.getRowCount());
            }
        });



        listaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeList el = new EmployeeList(EmployeeGUI.this, etm);
                el.setVisible(true);
            }
        });

        Object emptmn[] = {"Jel", "Kód", "Név", "Szülidő", "Lakóhely", "IQ"}; //mezőnevek
        etm = new EmployeeTableModel(emptmn, 0); //etm példányosítása mezőnevekkel, 0 sorral



    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("EmployeeGUI");
        frame.setContentPane(new EmployeeGUI().frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
