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
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CircularQueue extends JFrame {

	private JPanel contentPane;
	private JTextField queueLength;
	private JTextField queueElement;
	private JTextField DisplayQueue;
	private int rear = -1;
	private int front = 0;
	private int count = 0;
	private int size;
	private int cq[];
	
	public void Display() {
		String str = "";
		int fr = front;
		for(int i = 1; i <= count; i++) {
			str = str +" "+cq[fr];
			fr = (fr + 1) % size;
		}
		DisplayQueue.setText(str);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircularQueue frame = new CircularQueue();
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
	public CircularQueue() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DataStructureusingSwing.class.getResource("/data_structures_project/logo1.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCircularQueueData = new JLabel("CIRCULAR QUEUE DATA STRUCTURE");
		lblCircularQueueData.setFont(new Font("Arial", Font.BOLD, 20));
		lblCircularQueueData.setBounds(105, 10, 368, 24);
		contentPane.add(lblCircularQueueData);
		
		JLabel lblQueueCreation = new JLabel("QUEUE CREATION :");
		lblQueueCreation.setForeground(Color.BLUE);
		lblQueueCreation.setFont(new Font("Arial", Font.BOLD, 16));
		lblQueueCreation.setBounds(10, 76, 153, 19);
		contentPane.add(lblQueueCreation);
		
		JLabel lblArrayLength = new JLabel("Enter Queue Length  :");
		lblArrayLength.setFont(new Font("Arial", Font.PLAIN, 16));
		lblArrayLength.setBounds(10, 129, 155, 19);
		contentPane.add(lblArrayLength);
		
		JLabel lblEnterAnElement = new JLabel("<html>Enter an element to insert<br>into the queue :</html>");
		lblEnterAnElement.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEnterAnElement.setBounds(10, 178, 197, 43);
		contentPane.add(lblEnterAnElement);
		
		JLabel lblDequeueAnElement = new JLabel("DEQUEUE AN ELEMENT :");
		lblDequeueAnElement.setForeground(Color.BLUE);
		lblDequeueAnElement.setFont(new Font("Arial", Font.BOLD, 16));
		lblDequeueAnElement.setBounds(10, 258, 204, 19);
		contentPane.add(lblDequeueAnElement);
		
		JButton DequeueQueue = new JButton("DEQUEUE");
		DequeueQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to delete element from the queue
				if(count == 0) {
					JOptionPane.showMessageDialog(contentPane, "Queue is Empty! Nothing to display");
				}
				else {
					JOptionPane.showMessageDialog(contentPane, cq[front]+" deleted successfully from queue");
					front = (front + 1) % size; 
					count--;
					Display();
				}
			}
		});
		DequeueQueue.setForeground(new Color(0, 128, 0));
		DequeueQueue.setFont(new Font("Arial", Font.BOLD, 18));
		DequeueQueue.setBounds(215, 302, 129, 37);
		contentPane.add(DequeueQueue);
		
		queueLength = new JTextField();
		queueLength.setFont(new Font("Arial", Font.PLAIN, 16));
		queueLength.setColumns(10);
		queueLength.setBounds(248, 123, 121, 25);
		contentPane.add(queueLength);
		
		queueElement = new JTextField();
		queueElement.setFont(new Font("Arial", Font.PLAIN, 16));
		queueElement.setColumns(10);
		queueElement.setBounds(248, 196, 121, 25);
		contentPane.add(queueElement);
		
		JButton CreateQueue = new JButton("CREATE");
		CreateQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Code to create circular queue
				size = Integer.valueOf(queueLength.getText());
				cq = new int[size];
				JOptionPane.showMessageDialog(contentPane, "Circular Q of size "+size+" created successfully");
			}
		});
		CreateQueue.setForeground(new Color(0, 128, 0));
		CreateQueue.setFont(new Font("Arial", Font.BOLD, 16));
		CreateQueue.setBounds(426, 123, 121, 25);
		contentPane.add(CreateQueue);
		
		JButton EnqueueQueue = new JButton("ENQUEUE");
		EnqueueQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to insert element into the queue
				if(count == size) {
					JOptionPane.showMessageDialog(contentPane, "Queue overflow! Insertion not possible");
				}
				else {
					int ele = Integer.valueOf(queueElement.getText());
					rear = (rear + 1) % size;
					cq[rear] = ele;
					count++;
					JOptionPane.showMessageDialog(contentPane, ele+" entered successfully into the queue");
					queueElement.setText("");
					Display();
				}
			}
		});
		EnqueueQueue.setForeground(new Color(0, 128, 0));
		EnqueueQueue.setFont(new Font("Arial", Font.BOLD, 16));
		EnqueueQueue.setBounds(426, 196, 121, 25);
		contentPane.add(EnqueueQueue);
		
		JLabel lblElementsInThe = new JLabel("ELEMENTS IN THE QUEUE :");
		lblElementsInThe.setForeground(Color.BLUE);
		lblElementsInThe.setFont(new Font("Arial", Font.BOLD, 16));
		lblElementsInThe.setBounds(10, 373, 223, 19);
		contentPane.add(lblElementsInThe);
		
		DisplayQueue = new JTextField();
		DisplayQueue.setFont(new Font("Arial", Font.BOLD, 18));
		DisplayQueue.setEditable(false);
		DisplayQueue.setColumns(10);
		DisplayQueue.setBackground(Color.WHITE);
		DisplayQueue.setBounds(40, 402, 492, 36);
		contentPane.add(DisplayQueue);
	}
}
