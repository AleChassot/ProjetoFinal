package org.example.entity;

import org.example.dao.RentDAO;
import org.example.model.RentACar;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;

public class DisplayRent extends JFrame{

    private JButton adicionar = new JButton("Adicionar carros");

    public DisplayRent() {
        setTitle("Aluguel de Carros");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JMenuBar menu = new JMenuBar();

        setJMenuBar(menu);

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        menu.add(fileMenu);
        menu.add(editMenu);

        RentDAO rd = new RentDAO();
        List<RentACar> rentCar = rd.getRent();

        String[] columnNames = {"Nome do Carro", "Data de Início", "Data de Devolução", "Valor", "Cor", "Placa"};
        Object[][] data = new Object[rentCar.size()][6];

        for (int i = 0; i < rentCar.size(); i++) {
            RentACar car = rentCar.get(i);
            data[i][0] = car.getNomeCar();
            data[i][1] = car.getDataIni();
            data[i][2] = car.getDevolucao();
            data[i][3] = car.getValor();
            data[i][4] = car.getCor();
            data[i][5] = car.getPlaca();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

        JPanel pesqui = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel searchLabel = new JLabel("Pesquisar: ");
        JTextField searchField = new JTextField(20);
        pesqui.add(searchLabel);
        pesqui.add(searchField);
        getContentPane().add(pesqui, BorderLayout.NORTH);

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            public void removeUpdate(DocumentEvent e) {
                search();
            }

            public void changedUpdate(DocumentEvent e) {
                search();
            }

            private void search() {
                String text = searchField.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
         }
});

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DisplayRent::new);
    }
}
