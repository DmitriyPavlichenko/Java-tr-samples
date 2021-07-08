package com.company;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame implements TableModelListener {
    MyTableModel myTableModel;
    JTable myTable;

    MyFrame(String title) {
        super(title);
        myTableModel = new MyTableModel();
        myTable = new JTable(myTableModel);
        add(new JScrollPane(myTable));
        myTableModel.addTableModelListener(this);
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame("Hello!");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void tableChanged(TableModelEvent e) {

    }
}

class MyTableModel extends AbstractTableModel {
    List<Order> myData;
    String[] orderNames = {"orderID", "stockSymbol", "quantity", "price"};

    public MyTableModel() {
        Portfolio portfolio = new Portfolio();
        myData = portfolio.getOrder();
    }

    @Override
    public int getRowCount() {
        return orderNames.length;
    }

    @Override
    public int getColumnCount() {
        return myData.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return myData.get(rowIndex).getId();
            }
            case 1 -> {
                return myData.get(rowIndex).getSymbol();
            }
            case 2 -> {
                return myData.get(rowIndex).getQuantity();
            }
            case 3 -> {
                return myData.get(rowIndex).getPrice();
            }
            default -> {
                return "";
            }
        }
    }
}
