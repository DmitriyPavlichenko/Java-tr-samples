package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyCustomizableGUI extends JFrame {
    private final JTextField textField;
    private final JButton preferencesButton;

    MyCustomizableGUI() {
        super("MyCustomizableGUI");
        setLayout(new GridLayout(1, 2));

        textField = new JTextField("Some text");
        add(textField);
        preferencesButton = new JButton("Preferences");
        add(preferencesButton);

        configfileApplying();

        preferencesButton.addActionListener(preferencesButtonEvent -> {
            System.out.println("Preferences button pressed");
            dialogWindowCreating();
        });

        setSize(400, 80);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void dialogWindowCreating() {
        JDialog dialog = new JDialog(this, "Preferences", true);
        dialog.setLayout(new GridLayout(2, 3));

        JComboBox<String> colorBox = new JComboBox<>(UserPreferences.getColorTypes());
        dialog.add(colorBox);
        JComboBox<String> fontBox = new JComboBox<>(UserPreferences.getFontTypes());
        dialog.add(fontBox);
        JComboBox<String> sizeBox = new JComboBox<>(UserPreferences.getSizeTypes());
        dialog.add(sizeBox);
        JButton saveButton = new JButton("Save");
        dialog.add(saveButton);
        JButton cancelButton = new JButton("Cancel");
        dialog.add(cancelButton);

        saveButton.addActionListener(saveButtonEvent -> {
            UserPreferences userPreferences = new UserPreferences();
            userPreferences.setColor((String) colorBox.getSelectedItem());
            userPreferences.setFont((String) fontBox.getSelectedItem());
            userPreferences.setSize((String) sizeBox.getSelectedItem());

            try (FileOutputStream fileOut = new FileOutputStream("preferences.ser");
                 ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                objectOut.writeObject(userPreferences);
                dialog.dispose();
                System.out.println("File is written successfully");
                System.out.println("Dialog closed");
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            }

        });

        cancelButton.addActionListener(cancelButtonEvent -> {
            dialog.dispose();
            System.out.println("Dialog closed");
        });

        dialog.pack();
        dialog.setVisible(true);
    }

    private void configfileApplying() {
        System.out.println("Reading of config-file");
        try (FileInputStream fileIn = new FileInputStream("preferences.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)
        ) {
            UserPreferences userPreferences = (UserPreferences) objectIn.readObject();
            textField.setBackground(Color.getColor(userPreferences.getColor()));
            textField.setBackground(Color.GRAY);
            textField.setFont(Font.getFont(userPreferences.getFont()));
            System.out.println("Config-file read successfully");
        } catch (Exception exc) {
            System.out.println("Error during file reading: " + exc.getMessage());
        }
    }
}
