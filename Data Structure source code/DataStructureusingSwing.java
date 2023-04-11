package data_structures_project;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DataStructureusingSwing extends JFrame {


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataStructureusingSwing frame = new DataStructureusingSwing();
					frame.setTitle("Data Structures Implementation");  // Sets Title of frame
					frame.setLocationRelativeTo(null);  // Sets JFrame to center of screen
					frame.setResizable(false);  // User cannot resize JFrame
					frame.setVisible(true);  // Makes frame visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param frame 
	 */
	public DataStructureusingSwing() {
		setResizable(false);
		
		// Set custom logo
		setIconImage(Toolkit.getDefaultToolkit().getImage(DataStructureusingSwing.class.getResource("/data_structures_project/logo1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHOOSE A DATASTRUCTURE");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(136, 10, 288, 24);
		contentPane.add(lblNewLabel);
		
		JButton array = new JButton("Array");
		array.setForeground(new Color(0, 0, 255));
		array.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Place array window opening code here
//				Array a = new Array();
//				a.setVisible(true);
				new Array().setVisible(true);
			}
		});
		array.setBackground(new Color(255, 255, 255));
		array.setFont(new Font("Arial", Font.BOLD, 16));
		array.setBounds(42, 87, 185, 50);
		contentPane.add(array);
		
		JButton stack = new JButton("Stack");
		stack.setForeground(new Color(0, 0, 255));
		stack.addActionListener(new ActionListener() {
			// Place Stack opening code here
			public void actionPerformed(ActionEvent e) {
				new Stack().setVisible(true);
			}
		});
		stack.setFont(new Font("Arial", Font.BOLD, 16));
		stack.setBackground(Color.WHITE);
		stack.setBounds(42, 200, 185, 50);
		contentPane.add(stack);
		
		JButton queue = new JButton("Queue");
		queue.setForeground(new Color(0, 0, 255));
		queue.addActionListener(new ActionListener() {
			// Place Queue opening code here
			public void actionPerformed(ActionEvent e) {
				new Queue().setVisible(true);
			}
		});
		queue.setFont(new Font("Arial", Font.BOLD, 16));
		queue.setBackground(Color.WHITE);
		queue.setBounds(42, 334, 185, 50);
		contentPane.add(queue);
		
		JButton cr_queue = new JButton("Circular Queue");
		cr_queue.setForeground(new Color(0, 0, 255));
		cr_queue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Place Circular Queue opening code here
				new CircularQueue().setVisible(true);
			}
		});
		cr_queue.setFont(new Font("Arial", Font.BOLD, 16));
		cr_queue.setBackground(Color.WHITE);
		cr_queue.setBounds(365, 87, 185, 50);
		contentPane.add(cr_queue);
		
		JButton sing_linklist = new JButton("Singly Linked-List");
		sing_linklist.setForeground(new Color(0, 0, 255));
		sing_linklist.addActionListener(new ActionListener() {
			// Place Singly Linked list opening code here
			public void actionPerformed(ActionEvent e) {
				new SinglyLinkedList().setVisible(true);
			}
		});
		sing_linklist.setFont(new Font("Arial", Font.BOLD, 16));
		sing_linklist.setBackground(Color.WHITE);
		sing_linklist.setBounds(365, 200, 185, 50);
		contentPane.add(sing_linklist);
		
		JButton doub_linkList = new JButton("Doubly Linked-List");
		doub_linkList.setForeground(new Color(0, 0, 255));
		doub_linkList.addActionListener(new ActionListener() {
			// Place Doubly Linked list opening code here
			public void actionPerformed(ActionEvent e) {
				new DoublyLinkedList().setVisible(true);
			}
		});
		doub_linkList.setFont(new Font("Arial", Font.BOLD, 16));
		doub_linkList.setBackground(Color.WHITE);
		doub_linkList.setBounds(365, 334, 185, 50);
		contentPane.add(doub_linkList);
	}
}
