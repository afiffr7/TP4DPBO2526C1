import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PersonMenu extends JFrame{
    private JTextField textNama;
    private JTextArea dataPersonTextArea;
    private JTextField textId;
    private JTextField textTahunLahir;
    private JTextField textField5;
    private JButton deleteButton;
    private JButton cancelButton;
    private JButton addButton;
    private JTable personTable;
    private JComboBox CBKategori;
    private JPanel mainPane;

    private ArrayList<Person> PersonData;

    public PersonMenu(){
        PersonData = new ArrayList<>();
        PersonData.add(new Person("P001", "Andi", 2000, "Karyawan"));
        personTable.setModel(setTable());

        deleteButton.setVisible(false);

    }

    public final DefaultTableModel setTable(){
        Object[] tHead = {"ID", "Nama", "Tahun Lahir", "Label"};
        DefaultTableModel ret = new DefaultTableModel(null, tHead);

        for(Person obj : PersonData){
            Object[] row = {obj.getId(), obj.getNama(), obj.getTahunLahir(), obj.getKategori()};
            ret.addRow(row);
        }
        return ret;
    }

    public static void main(String[] args){
        PersonMenu menu = new PersonMenu();
        menu.setSize(700,600);
        menu.setContentPane(menu.mainPane);
        menu.getContentPane().setBackground(Color.WHITE);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
