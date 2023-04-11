package data_structures_project;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import data_structures.LinkedList.Node;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SinglyLinkedList extends JFrame {

	private JPanel contentPane;
	private JTextField ElementList;
	private JTextField DisplayField;
	class Node{
		int data;
		Node next;
	}
	Node first;
	private JTextField insertPosition;
	private JTextField deletePosition;
	
	public void DisplayList() {
		String msg = "";
		if(first == null) {
			JOptionPane.showMessageDialog(contentPane, "List is Empty!");
		}
		else if(first.next == null) {
			msg = msg+" "+first.data;
			//DisplayField.setText(msg);
		}
		else {
			Node temp;
			temp = first;
			while(temp != null) {
				msg = msg+" "+temp.data;
				temp = temp.next;
			}
			//DisplayField.setText(msg);
		}
		DisplayField.setText(msg);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglyLinkedList frame = new SinglyLinkedList();
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
	public SinglyLinkedList() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DataStructureusingSwing.class.getResource("/data_structures_project/logo1.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSinglyLinkedList = new JLabel("SINGLY LINKED LIST DATA STRUCTURE");
		lblSinglyLinkedList.setFont(new Font("Arial", Font.BOLD, 20));
		lblSinglyLinkedList.setBounds(70, 10, 391, 24);
		contentPane.add(lblSinglyLinkedList);
		
		JLabel lblEnterAnElement = new JLabel("<html>Enter an element and click<br>on a button to</html>");
		lblEnterAnElement.setForeground(Color.BLUE);
		lblEnterAnElement.setFont(new Font("Arial", Font.BOLD, 18));
		lblEnterAnElement.setBounds(10, 99, 250, 44);
		contentPane.add(lblEnterAnElement);
		
		ElementList = new JTextField();
		ElementList.setFont(new Font("Arial", Font.PLAIN, 16));
		ElementList.setColumns(10);
		ElementList.setBounds(312, 97, 219, 46);
		contentPane.add(ElementList);
		
		JButton InsertFront = new JButton("Insert Front");
		InsertFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Code to insert from front
				Node newnode = new Node();
				int ele = Integer.valueOf(ElementList.getText());
				newnode.data = ele;
				newnode.next = null;
				if(first == null) {
					first = newnode;
					JOptionPane.showMessageDialog(contentPane, ele+" inserted into the list successfully");
					ElementList.setText("");
				}
				else {
					newnode.next = first;
					first = newnode;
					JOptionPane.showMessageDialog(contentPane, ele+" inserted into the list successfully");
					ElementList.setText("");
				}
				DisplayList();
			}
		});
		InsertFront.setFont(new Font("Arial", Font.BOLD, 14));
		InsertFront.setBounds(10, 177, 119, 32);
		contentPane.add(InsertFront);
		
		JButton InsertRear = new JButton("Insert Rear");
		InsertRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to insert from rear
				Node newnode = new Node();
				int ele = Integer.valueOf(ElementList.getText());
				newnode.data = ele;
				newnode.next = null;
				if(first == null) {
					first = newnode;
					JOptionPane.showMessageDialog(contentPane, ele+" inserted into the list successfully");
					ElementList.setText("");
				}
				else {
					Node temp = first;
					while(temp.next != null) {
						temp = temp.next;
					}
					temp.next = newnode;
					JOptionPane.showMessageDialog(contentPane, ele+" inserted into the list successfully");
					ElementList.setText("");
				}
				DisplayList();
			}
		});
		InsertRear.setFont(new Font("Arial", Font.BOLD, 14));
		InsertRear.setBounds(412, 177, 119, 32);
		contentPane.add(InsertRear);
		
		JButton InsertNthFront = new JButton("Insert at Nth Pos from Front");
		InsertNthFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code to insert at nth position from front
				Node newnode = new Node();
				int ele = Integer.valueOf(ElementList.getText());
				int pos = Integer.valueOf(insertPosition.getText());
				newnode.data = ele;
				newnode.next = null;
				if(pos == 1) {
					newnode.next = first;
					first = newnode;
					JOptionPane.showMessageDialog(contentPane, ele+" inserted into the list successfully");
				}
				else {
					Node temp = first;
					int count = 1;
					while(count != pos-1) {
						temp = temp.next;
						count++;
					}
					newnode.next = temp.next;
					temp.next = newnode;
					JOptionPane.showMessageDialog(contentPane, ele+" inserted into the list successfully");
				}
				ElementList.setText("");
				insertPosition.setText("");
				DisplayList();
			}
		});
		InsertNthFront.setFont(new Font("Arial", Font.BOLD, 14));
		InsertNthFront.setBounds(294, 299, 237, 32);
		contentPane.add(InsertNthFront);
		
		JButton InsertNthRear = new JButton("Insert at Nth Pos from End");
		InsertNthRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to insert at nth position from end
				Node newnode = new Node();
				int ele = Integer.valueOf(ElementList.getText());
				int pos = Integer.valueOf(insertPosition.getText());
				newnode.data = ele;
				newnode.next = null;
				Node fastPtr = first;
				for(int i = 0; i < pos-1; i++) {
					fastPtr = fastPtr.next;
				}
				if(pos == 1) {
					newnode.next = first;
					first = newnode;
					JOptionPane.showMessageDialog(contentPane, ele+" inserted into the list successfully");
				}
				else {
					Node slowPtr = first;
					while(fastPtr.next != null) {
						fastPtr = fastPtr.next;
						slowPtr = slowPtr.next;
					}
					newnode.next = slowPtr.next;
					slowPtr.next = newnode;
					JOptionPane.showMessageDialog(contentPane, ele+" inserted into the list successfully");
				}
				ElementList.setText("");
				insertPosition.setText("");
				DisplayList();
			}
		});
		InsertNthRear.setFont(new Font("Arial", Font.BOLD, 14));
		InsertNthRear.setBounds(10, 299, 225, 32);
		contentPane.add(InsertNthRear);
		
		JLabel lblEnterAnElement_1 = new JLabel("<html>Click on a button to delete an element from(Position)<br>as per your choice</html>");
		lblEnterAnElement_1.setForeground(Color.BLUE);
		lblEnterAnElement_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblEnterAnElement_1.setBounds(10, 387, 469, 44);
		contentPane.add(lblEnterAnElement_1);
		
		JButton DeleteFront = new JButton("Delete Front");
		DeleteFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Delete from front
				if(first == null) {
					JOptionPane.showMessageDialog(contentPane, "List is empty! Deletion not possible");
				}
				else if(first.next == null) {
					JOptionPane.showMessageDialog(contentPane, first.data+" deleted from the list");
					first = null;
				}
				else {
					JOptionPane.showMessageDialog(contentPane, first.data+" deleted from the list");
					first = first.next;
				}
				DisplayList();
			}
		});
		DeleteFront.setFont(new Font("Arial", Font.BOLD, 14));
		DeleteFront.setBounds(10, 452, 129, 32);
		contentPane.add(DeleteFront);
		
		JButton DeleteRear = new JButton("Delete Rear");
		DeleteRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Delete from rear
				if(first == null) {
					System.out.println("List is empty");
				}
				else if(first.next == null) {
					JOptionPane.showMessageDialog(contentPane, first.data+" deleted successfully");
					first = null;
				}
				else {
					Node temp = first;
					while(temp.next.next != null) {
						temp = temp.next;
					}
					JOptionPane.showMessageDialog(contentPane, temp.next.data+" deleted from the list");
					temp.next = null;
				}
				DisplayList();
			}
		});
		DeleteRear.setFont(new Font("Arial", Font.BOLD, 14));
		DeleteRear.setBounds(412, 452, 119, 32);
		contentPane.add(DeleteRear);
		
		JButton DeleteNthFront = new JButton("Delete at Nth Pos from Front");
		DeleteNthFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Delete from nth position from front
				int pos = Integer.valueOf(deletePosition.getText());
				if(first == null) {
					JOptionPane.showMessageDialog(contentPane, "List is empty!");
				}
				else if(pos == 1) {
					JOptionPane.showMessageDialog(contentPane, first.data+" deleted successfully from the list");
					first = first.next;
				}
				else {
					int counter = 1;
					Node temp = first;
					while(counter != (pos-1)) {
						temp = temp.next;
						counter++;
					}
					JOptionPane.showMessageDialog(contentPane, temp.next.data+" deleted successfully from the list");
					temp.next = temp.next.next;
				}
				deletePosition.setText("");
				DisplayList();
			}
		});
		DeleteNthFront.setFont(new Font("Arial", Font.BOLD, 14));
		DeleteNthFront.setBounds(288, 563, 243, 32);
		contentPane.add(DeleteNthFront);
		
		JButton DeleteNthRear = new JButton("Delete at Nth Pos from End");
		DeleteNthRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Delete from nth position from rear
				int pos = Integer.valueOf(deletePosition.getText());
				Node fastPtr = first;
				for(int i = 0; i < pos; i++) {
					fastPtr = fastPtr.next;
				}
				if(first.next == null) {
					JOptionPane.showMessageDialog(contentPane, first.data+" deleted successfully from the list");
					first = null;
				}
				else if(first == null) {
					JOptionPane.showMessageDialog(contentPane, "List is empty");
				}
				else {
					Node slowPtr = first;
					while(fastPtr.next != null) {
						fastPtr = fastPtr.next;
						slowPtr = slowPtr.next;
					}
					JOptionPane.showMessageDialog(contentPane, slowPtr.next.data+" deleted successfully from the list");
					slowPtr.next = slowPtr.next.next;
				}
				deletePosition.setText("");
				DisplayList();
			}
		});
		DeleteNthRear.setFont(new Font("Arial", Font.BOLD, 14));
		DeleteNthRear.setBounds(10, 563, 225, 32);
		contentPane.add(DeleteNthRear);
		
		JLabel lblEnterAnElement_1_1 = new JLabel("ELEMENTS IN THE LIST :");
		lblEnterAnElement_1_1.setForeground(Color.BLUE);
		lblEnterAnElement_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblEnterAnElement_1_1.setBounds(10, 637, 219, 22);
		contentPane.add(lblEnterAnElement_1_1);
		
		DisplayField = new JTextField();
		DisplayField.setBackground(new Color(255, 255, 255));
		DisplayField.setEditable(false);
		DisplayField.setFont(new Font("Arial", Font.BOLD, 20));
		DisplayField.setBounds(10, 681, 495, 50);
		contentPane.add(DisplayField);
		DisplayField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("or, enter a position");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 245, 168, 22);
		contentPane.add(lblNewLabel);
		
		insertPosition = new JTextField();
		insertPosition.setFont(new Font("Arial", Font.PLAIN, 16));
		insertPosition.setColumns(10);
		insertPosition.setBounds(206, 221, 54, 46);
		contentPane.add(insertPosition);
		
		JLabel lblTo = new JLabel("to,");
		lblTo.setForeground(Color.BLUE);
		lblTo.setFont(new Font("Arial", Font.BOLD, 18));
		lblTo.setBounds(286, 245, 22, 22);
		contentPane.add(lblTo);
		
		JLabel lblEnterAnElement_1_2 = new JLabel("or, enter a position");
		lblEnterAnElement_1_2.setForeground(Color.BLUE);
		lblEnterAnElement_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblEnterAnElement_1_2.setBounds(10, 518, 168, 22);
		contentPane.add(lblEnterAnElement_1_2);
		
		deletePosition = new JTextField();
		deletePosition.setFont(new Font("Arial", Font.PLAIN, 16));
		deletePosition.setColumns(10);
		deletePosition.setBounds(206, 494, 54, 46);
		contentPane.add(deletePosition);
		
		JLabel lblTo_1 = new JLabel("to,");
		lblTo_1.setForeground(Color.BLUE);
		lblTo_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblTo_1.setBounds(286, 518, 22, 22);
		contentPane.add(lblTo_1);
	}
}
