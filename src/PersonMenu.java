import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PersonMenu extends JFrame{
    private JTextField textNama;
    private JTextField textId;
    private JTextField textTahunLahir;
    private JButton deleteButton;
    private JButton cancelButton;
    private JButton addButton;
    private JTable personTable;
    private JComboBox CBKategori;
    private JPanel mainPane;
    private JComboBox CBWarna;

    private ArrayList<Person> PersonData;
    private int selectIdx;

    public PersonMenu(){
        PersonData = new ArrayList<>();
        PersonData.add(new Person("P001", "Andi", 2000, "Crypto", "Hijau"));
        personTable.setModel(setTable());
        selectIdx = -1;

        String[] listKategori = {"", "Crypto", "Forex", "Bitcoin"};
        CBKategori.setModel(new DefaultComboBoxModel<>(listKategori));
        String[] listWarna = {"", "Hijau", "Merah", "Biru", "Kuning", "Ungu"};
        CBWarna.setModel(new DefaultComboBoxModel<>(listWarna));

        deleteButton.setVisible(false);
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                insertUpdateData();
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                resetForm();
            }
        });
        deleteButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                deleteData();
            }
        });
        personTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                selectIdx = personTable.getSelectedRow();
                textId.setText(PersonData.get(selectIdx).getId());
                textNama.setText(PersonData.get(selectIdx).getNama());
                textTahunLahir.setText(String.valueOf(PersonData.get(selectIdx).getTahunLahir()));
                CBKategori.setSelectedItem(PersonData.get(selectIdx).getKategori());
                CBWarna.setSelectedItem(PersonData.get(selectIdx).getWarna());

                addButton.setText("Update");
                deleteButton.setVisible(true);
            }
        });
    }

    public void insertUpdateData(){
        String id = textId.getText();
        String nama = textNama.getText();
        String kategori = CBKategori.getSelectedItem().toString();
        String warna = CBWarna.getSelectedItem().toString();
        try{
            int tahunLahir = Integer.parseInt(textTahunLahir.getText());
            if(id.equals("") || nama.equals("") || kategori.equals("") || warna.equals("")){
                JOptionPane.showMessageDialog(null, "Semua data perlu diisi!");
            }else {
                if(selectIdx != -1){
                    Person edited = PersonData.get(selectIdx);
                    edited.setId(id);
                    edited.setNama(nama);
                    edited.setTahunLahir(tahunLahir);
                    edited.setKategori(kategori);
                    edited.setWarna(warna);
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
                }else{
                    PersonData.add(new Person(id, nama, tahunLahir, kategori, warna));
                    JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
                }
                personTable.setModel(setTable());
                resetForm();
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Tahun Lahir harus angka!","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteData(){
        int yesOrNo = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data ini?", "Delete Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(yesOrNo == JOptionPane.YES_OPTION){
            PersonData.remove(selectIdx);
            selectIdx = -1;
            resetForm();
            personTable.setModel(setTable());
        }
    }

    public void resetForm(){
        textId.setText("");
        textNama.setText("");
        textTahunLahir.setText("");
        CBKategori.setSelectedItem("");
        CBWarna.setSelectedItem("");

        selectIdx = -1;
        deleteButton.setVisible(false);
        addButton.setText("Add");
    }

    public final DefaultTableModel setTable(){
        Object[] tHead = {"ID", "Nama", "Tahun Lahir", "Kategori", "WarnaMcLaren"};
        DefaultTableModel ret = new DefaultTableModel(null, tHead);

        for(Person obj : PersonData){
            Object[] row = {obj.getId(), obj.getNama(), obj.getTahunLahir(), obj.getKategori(), obj.getWarna()};
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
