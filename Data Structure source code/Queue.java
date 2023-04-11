package data_structures_project;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Queue extends JFrame {

	private JPanel contentPane;
	public int arr[];
	public int size;
	public int rear = -1;
	public int front = 0;
	private JTextField QueueLength;
	private JTextField QueueElement;
	private JTextField DisplayQueue;
	
	// Function to display queue elements
	public void Display() {
		if((rear == -1) || (front > rear)) {
			JOptionPane.showMessageDialog(contentPane, "Queue is empty! Nothing to display");
		}
		else {
			String msg = "";
			for(int i = front; i <= rear; i++) {
				msg = msg+" "+arr[i];
			}
			DisplayQueue.setText(msg);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queue frame = new Queue();
					frame.setTitle("Data Structures Implementation");  // Sets Title of frame
					frame.setLocationRelativeTo(null);  // Sets JFrame to center of screen
					frame.setResizable(false);  // User cannot resize JFrame
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Queue() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DataStructureusingSwing.class.getResource("/data_structures_project/logo1.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // If set EXIT_ON_CLOSE then it will close all jframes
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUEUE DATA STRUCTURE");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(157, 10, 259, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblQueueCreation = new JLabel("QUEUE CREATION :");
		lblQueueCreation.setForeground(Color.BLUE);
		lblQueueCreation.setFont(new Font("Arial", Font.BOLD, 16));
		lblQueueCreation.setBounds(10, 79, 153, 19);
		contentPane.add(lblQueueCreation);
		
		JLabel lblArrayLength = new JLabel("Enter Queue Length  :");
		lblArrayLength.setFont(new Font("Arial", Font.PLAIN, 16));
		lblArrayLength.setBounds(10, 128, 155, 19);
		contentPane.add(lblArrayLength);
		
		JLabel lblEnterAnElement = new JLabel("<html>Enter an element to insert<br>into the queue :</html>");
		lblEnterAnElement.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEnterAnElement.setBounds(10, 176, 197, 43);
		contentPane.add(lblEnterAnElement);
		
		QueueLength = new JTextField();
		QueueLength.setFont(new Font("Arial", Font.PLAIN, 16));
		QueueLength.setColumns(10);
		QueueLength.setBounds(265, 124, 121, 25);
		contentPane.add(QueueLength);
		
		QueueElement = new JTextField();
		QueueElement.setFont(new Font("Arial", Font.PLAIN, 16));
		QueueElement.setColumns(10);
		QueueElement.setBounds(265, 194, 121, 25);
		contentPane.add(QueueElement);
		
		JButton CreateArray = new JButton("CREATE");
		CreateArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to create queue length
				size = Integer.valueOf(QueueLength.getText());
				arr = new int[size];
				JOptionPane.showMessageDialog(contentPane, "Queue of length "+size+" created successfully");
			}
		});
		CreateArray.setForeground(new Color(0, 128, 0));
		CreateArray.setFont(new Font("Arial", Font.BOLD, 16));
		CreateArray.setBounds(435, 122, 121, 25);
		contentPane.add(CreateArray);
		
		JButton EnqueueQueue = new JButton("ENQUEUE");
		EnqueueQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to enter queue element
				if(rear == arr.length-1) {
					JOptionPane.showMessageDialog(contentPane, "Queue overflow! Insertion not possible");
				}
				else {
					int ele = Integer.valueOf(QueueElement.getText());
					arr[++rear] = ele;
					JOptionPane.showMessageDialog(contentPane, ele+" inserted successfully into the queue");
					QueueElement.setText("");
					Display();
				}
			}
		});
		EnqueueQueue.setForeground(new Color(0, 128, 0));
		EnqueueQueue.setFont(new Font("Arial", Font.BOLD, 16));
		EnqueueQueue.setBounds(435, 194, 121, 25);
		contentPane.add(EnqueueQueue);
		
		JLabel lblDequeueAnElement = new JLabel("DEQUEUE AN ELEMENT :");
		lblDequeueAnElement.setForeground(Color.BLUE);
		lblDequeueAnElement.setFont(new Font("Arial", Font.BOLD, 16));
		lblDequeueAnElement.setBounds(10, 240, 204, 19);
		contentPane.add(lblDequeueAnElement);
		
		JButton DequeueButton = new JButton("DEQUEUE");
		DequeueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to delete element from the queue
				if(rear == -1 || front > rear) {
					JOptionPane.showMessageDialog(contentPane, "Queue is empty! Nothing to display");
				}
				else {
					JOptionPane.showMessageDialog(contentPane, arr[front]+" deleted successfully");
					//Display();
					front++;
					Display();
				}
			}
		});
		DequeueButton.setForeground(new Color(0, 128, 0));
		DequeueButton.setFont(new Font("Arial", Font.BOLD, 18));
		DequeueButton.setBounds(207, 283, 129, 37);
		contentPane.add(DequeueButton);
		
		JLabel lblElementsInThe = new JLabel("ELEMENTS IN THE QUEUE :");
		lblElementsInThe.setForeground(Color.BLUE);
		lblElementsInThe.setFont(new Font("Arial", Font.BOLD, 16));
		lblElementsInThe.setBounds(10, 358, 223, 19);
		contentPane.add(lblElementsInThe);
		
		DisplayQueue = new JTextField();
		DisplayQueue.setFont(new Font("Arial", Font.BOLD, 18));
		DisplayQueue.setEditable(false);
		DisplayQueue.setColumns(10);
		DisplayQueue.setBackground(Color.WHITE);
		DisplayQueue.setBounds(44, 397, 492, 36);
		contentPane.add(DisplayQueue);
	}

}
