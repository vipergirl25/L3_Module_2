package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FileTracker implements ActionListener {
	public static void main(String[] args) {
		new FileTracker().UI();
	}
	String line;
	String completeList;
	String task;
	String input;
	JButton addTask;
	JButton removeTask;
	JButton save;
	JButton load;
	ArrayList<String> list = new ArrayList<String>();
	void UI() {
		addTask = new JButton("add task");
		removeTask = new JButton("remove task");
		save = new JButton("save");
		load = new JButton("load");
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.add(addTask);
		panel.add(removeTask);
		panel.add(save);
		panel.add(load);
		addTask.addActionListener(this);
		removeTask.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addTask) {
			task = JOptionPane.showInputDialog("Enter a task: ");
			list.add(task);
		}else if(e.getSource()==removeTask) {
			String input = JOptionPane.showInputDialog("What task would you like to remove from the list? (starting @0 for first element through the list)" + list.toString());
			int remove = Integer.parseInt(input);
			if(remove>input.length()-1) {
				JOptionPane.showMessageDialog(null, "this element doesn't exist");
			}else {
				list.remove(remove);
			}
		}else if(e.getSource()==save) {
			try {
				FileWriter f = new FileWriter("src/intro_to_file_io/list.txt");
				f.write(list.toString());
				f.close();
			} catch(IOException f) {
				f.printStackTrace();
			}
		}else if(e.getSource()==load) {
			try {
				BufferedReader b = new BufferedReader(new FileReader("src/intro_to_file_io/list.txt"));
				line = b.readLine();
				while(line != null){
					System.out.println(line);
					line = b.readLine();
				}
				b.close();
			}catch(IOException f) {
				f.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, line);
		}
	}
}
