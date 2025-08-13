package ToDoApp;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class toDoApp extends JFrame {
	private DefaultListModel<String> taskListModel;
	private JList<String> taskList;
	private JTextField taskInput;

	public toDoApp() {
		setTitle("To-Do List");
		setSize(400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Task input field
		taskInput = new JTextField();
		add(taskInput, BorderLayout.NORTH);

		// Task list
		taskListModel = new DefaultListModel<>();
		taskList = new JList<>(taskListModel);
		add(new JScrollPane(taskList), BorderLayout.CENTER);

		// Buttons panel
		JPanel buttonPanel = new JPanel();
		JButton addButton = new JButton("Add Task");
		JButton deleteButton = new JButton("Delete Task");

		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		add(buttonPanel, BorderLayout.SOUTH);

		// Add task action
		addButton.addActionListener(e -> {
			String task = taskInput.getText().trim();
			if (!task.isEmpty()) {
				taskListModel.addElement(task);
				taskInput.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "Enter a task before adding.", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		// Delete task action
		deleteButton.addActionListener(e -> {
			int selectedIndex = taskList.getSelectedIndex();
			if (selectedIndex != -1) {
				taskListModel.remove(selectedIndex);
			} else {
				JOptionPane.showMessageDialog(this, "Select a task to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new toDoApp().setVisible(true);
		});
	}

}
