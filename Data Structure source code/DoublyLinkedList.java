package data_structures_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoublyLinkedList extends JFrame {

	private JPanel contentPane;
	private JTextField ElementField;
	private JTextField displayFront;
	private JTextField displayRear;
	
	class Node{
		int data;
		Node previousLink;
		Node nextlink;
	}
	Node first;
	
	public void DisplayReverse() {
		String msg = "";
		if(first == null) {
			JOptionPane.showMessageDialog(contentPane, "List is empty! Nothing to display");
		}
		else if(first.nextlink == null) {
			msg = msg+" "+first.data;
		}
		else {
			Node temp = first;
			while(temp.nextlink != null) {
				temp = temp.nextlink;
			}
			while(temp != null) {
				msg = msg +" "+ temp.data;
				temp = temp.previousLink;
			}
		}
		displayRear.setText(msg);
	}
	
	public void DisplayFromFront() {
		String msg = "";
		if(first == null) {
			JOptionPane.showMessageDialog(contentPane, "List is empty! Nothing to display");
		}
		else {
			Node temp = first;
			while(temp != null) {
				msg = msg +" "+temp.data;
				temp = temp.nextlink;
			}
		}
		displayFront.setText(msg);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoublyLinkedList frame = new DoublyLinkedList();
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
	public DoublyLinkedList() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DataStructureusingSwing.class.getResource("/data_structures_project/logo1.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoublyLinkedList = new JLabel("DOUBLY LINKED LIST DATA STRUCTURE");
		lblDoublyLinkedList.setFont(new Font("Arial", Font.BOLD, 20));
		lblDoublyLinkedList.setBounds(83, 10, 401, 24);
		contentPane.add(lblDoublyLinkedList);
		
		JLabel lblEnterAnElement_1 = new JLabel("Enter an element and click on a button below to");
		lblEnterAnElement_1.setForeground(Color.BLUE);
		lblEnterAnElement_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblEnterAnElement_1.setBounds(10, 102, 424, 22);
		contentPane.add(lblEnterAnElement_1);
		
		ElementField = new JTextField();
		ElementField.setFont(new Font("Arial", Font.PLAIN, 16));
		ElementField.setColumns(10);
		ElementField.setBounds(171, 134, 219, 46);
		contentPane.add(ElementField);
		
		JButton InsertFront = new JButton("Insert Front");
		InsertFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Code to insert element from front
				int ele = Integer.valueOf(ElementField.getText());
				Node newnode = new Node();
				newnode.data = ele;
				newnode.previousLink = null;
				newnode.nextlink = null;
				if(first == null) {
					first = newnode;
				}
				else {
					newnode.nextlink = first;
					first.previousLink = newnode;
					first = newnode;
				}
				JOptionPane.showMessageDialog(contentPane, ele+" inserted into the list successfully");
				ElementField.setText("");
				DisplayFromFront();
				DisplayReverse();
			}
		});
		InsertFront.setFont(new Font("Arial", Font.BOLD, 14));
		InsertFront.setBounds(103, 203, 128, 32);
		contentPane.add(InsertFront);
		
		JButton InsertRear = new JButton("Insert Rear");
		InsertRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to insert element from rear
				int ele = Integer.valueOf(ElementField.getText());
				Node newnode = new Node();
				newnode.data = ele;
				newnode.previousLink = null;
				newnode.nextlink = null;
				if(first == null) {
					first = newnode;
				}
				else {
					Node temp = first;
					while(temp.nextlink != null) {
						temp = temp.nextlink;
					}
					temp.nextlink = newnode;
					newnode.previousLink = temp;
				}
				JOptionPane.showMessageDialog(contentPane, ele+" inserted into the list successfully");
				ElementField.setText("");
				DisplayFromFront();
				DisplayReverse();
			}
		});
		InsertRear.setFont(new Font("Arial", Font.BOLD, 14));
		InsertRear.setBounds(345, 203, 119, 32);
		contentPane.add(InsertRear);
		
		JButton DeleteFront = new JButton("Delete Front");
		DeleteFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to delete element from front
				if(first == null) {
					JOptionPane.showMessageDialog(contentPane, "List is empty");
				}
				else if(first.nextlink == null) {
					JOptionPane.showMessageDialog(contentPane, first.data+" deleted successfully from the list");
					first = null;
				}
				else {
					JOptionPane.showMessageDialog(contentPane, first.data+" deleted successfully from the list");
					first = first.nextlink;
				}
				DisplayFromFront();
				DisplayReverse();
			}
		});
		DeleteFront.setFont(new Font("Arial", Font.BOLD, 14));
		DeleteFront.setBounds(103, 256, 128, 32);
		contentPane.add(DeleteFront);
		
		JButton DeleteRear = new JButton("Delete Rear");
		DeleteRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to delete element from rear
				if(first == null) {
					JOptionPane.showMessageDialog(contentPane, first.data+" deleted from the list successfully");
				}
				else if(first.nextlink == null) {
					JOptionPane.showMessageDialog(contentPane, first.data+" deleted from the list successfully");
					first = null;
				}
				else {
					Node temp = first;
					while(temp.nextlink.nextlink != null) {
						temp = temp.nextlink;
					}
					JOptionPane.showMessageDialog(contentPane, temp.nextlink.data+" deleted from the list successfully");
					temp.nextlink = null;
				}
				DisplayFromFront();
				DisplayReverse();
			}
		});
		DeleteRear.setFont(new Font("Arial", Font.BOLD, 14));
		DeleteRear.setBounds(345, 256, 119, 32);
		contentPane.add(DeleteRear);
		
		JLabel lblEnterAnElement_1_1 = new JLabel("Elements in list from front");
		lblEnterAnElement_1_1.setForeground(Color.BLUE);
		lblEnterAnElement_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblEnterAnElement_1_1.setBounds(10, 329, 230, 22);
		contentPane.add(lblEnterAnElement_1_1);
		
		displayFront = new JTextField();
		displayFront.setFont(new Font("Arial", Font.BOLD, 20));
		displayFront.setEditable(false);
		displayFront.setColumns(10);
		displayFront.setBackground(Color.WHITE);
		displayFront.setBounds(10, 361, 495, 50);
		contentPane.add(displayFront);
		
		JLabel lblEnterAnElement_1_1_1 = new JLabel("Elements in list from rear");
		lblEnterAnElement_1_1_1.setForeground(Color.BLUE);
		lblEnterAnElement_1_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblEnterAnElement_1_1_1.setBounds(10, 453, 230, 22);
		contentPane.add(lblEnterAnElement_1_1_1);
		
		displayRear = new JTextField();
		displayRear.setFont(new Font("Arial", Font.BOLD, 20));
		displayRear.setEditable(false);
		displayRear.setColumns(10);
		displayRear.setBackground(Color.WHITE);
		displayRear.setBounds(10, 485, 495, 50);
		contentPane.add(displayRear);
	}
}
