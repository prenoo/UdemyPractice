import javax.swing.*;
import java.io.*;

public class FileManager {
    public static void CSVReader(File filenev, EmployeeTableModel etm) throws FileNotFoundException {
        String kod = "", nev = "", szulido = "", lakhely = "", iq = "", s = "";

        try {
            BufferedReader in = new BufferedReader(new FileReader(filenev));
            s = in.readLine();
            s = in.readLine();
            while (s != null) {
                String[] st = s.split(";");
                etm.addRow(new Object[]{new Boolean(false), Integer.parseInt(st[0]), st[1], st[2], st[3], Integer.parseInt(st[4])});
                s = in.readLine();
            }
            in.close();
            JOptionPane.showMessageDialog(null, "Adatok beolvasva", "Fasz", 1);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "CSVReader: " + e.getMessage(), "Fasz", 0);
        }
    }
}
