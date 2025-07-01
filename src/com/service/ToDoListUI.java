package com.service;
import javax.swing.*;

public class ToDoListUI {

    JFrame frame;
    JTextField taskField;
    JButton addButton;
    JButton deleteButton;
    JList<String> taskList;
    DefaultListModel<String> taskListModel;

    public ToDoListUI() {
        
        frame = new JFrame("To-Do List");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        
        taskField = new JTextField();
        taskField.setBounds(20, 20, 260, 30);
        frame.add(taskField);

        
        addButton = new JButton("Add Task");
        addButton.setBounds(290, 20, 80, 30);
        frame.add(addButton);

        
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(20, 60, 350, 340);
        frame.add(scrollPane);

        
        deleteButton = new JButton("Delete Task");
        deleteButton.setBounds(20, 410, 350, 30);
        frame.add(deleteButton);

        
        frame.setVisible(true);
        
     
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);  // Add to the list
                taskField.setText("");           // Clear the text field
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a task.");
            }
        });

        
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);  // Remove selected task
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a task to delete.");
            }
        });

    }
}

