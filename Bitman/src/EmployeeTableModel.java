import javax.swing.table.DefaultTableModel;

public class EmployeeTableModel extends DefaultTableModel {

    public EmployeeTableModel(Object fildNames[], int rows) {
        super(fildNames, rows);
    }

    public boolean isCellEditable(int row, int col) {
        if (col == 0) {
            return true;
        }
        return false;
    }

    public Class<?> getColumnClass(int index) {
        if (index == 0) { //0. oszlop logikai
            return (Boolean.class);
        } else if (index == 1 || index == 5) { //1. es 5. oszlop integer
            return (Integer.class);
        } else
            return (String.class); //tobbi sor string
    }
}
