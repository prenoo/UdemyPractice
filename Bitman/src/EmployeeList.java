import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

public class EmployeeList extends JDialog {
    private JPanel contentPane;
    private JTable table;
    private EmployeeTableModel etm;

    public EmployeeList(JFrame frame, EmployeeTableModel betm) {
        super(frame, "Dolgozók listája", true);
        etm = betm;
        setContentPane(contentPane);
        table = new JTable(etm);

        TableColumn tc = null;
        for (int i = 0; i < 6; i++) {
            tc = table.getColumnModel().getColumn(i);
            if (i == 0 || i == 1 || i == 5) {
                tc.setPreferredWidth(30);
            } else
                tc.setPreferredWidth(100);
        }

        table.setAutoCreateRowSorter(true);
        TableRowSorter<EmployeeTableModel> trs = (TableRowSorter<EmployeeTableModel>) table.getRowSorter();
        trs.setSortable(0, false); //0. oszlop rendezhetőségének letiltása
    }
}
