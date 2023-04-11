package data_structures_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Stack extends JFrame {
	
	private JTextField fieldLength;

	private JPanel contentPane;
	private JTextField ElementField;
	private JTextField textDisplayField;
	private int arr[];
	private int size;
	private int top = -1;
	
	// Function to display stack element which will be used to display live stack element
	public void Display() {
		String msg = "";
		for(int i = top; i >= 0; i--) {
			msg = msg+" "+arr[i];
		}
		textDisplayField.setText(msg);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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
	public Stack() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DataStructureusingSwing.class.getResource("/data_structures_project/logo1.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STACK DATA STRUCTURE");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(161, 10, 256, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblArrayLength = new JLabel("Enter Stack Length  :");
		lblArrayLength.setFont(new Font("Arial", Font.PLAIN, 16));
		lblArrayLength.setBounds(10, 129, 166, 17); //128
		contentPane.add(lblArrayLength);
		
		fieldLength = new JTextField();
		fieldLength.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fieldLength.setBounds(296, 127, 121, 25);
		contentPane.add(fieldLength);
		fieldLength.setColumns(10);
		
		JLabel lblPushEle = new JLabel("Enter an element to push into the stack :");
		lblPushEle.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPushEle.setBounds(10, 176, 283, 19); //128
		contentPane.add(lblPushEle);
		
		ElementField = new JTextField();
		ElementField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ElementField.setBounds(296, 175, 121, 25);
		contentPane.add(ElementField);
		ElementField.setColumns(10);
		
		JButton CreateButton = new JButton("CREATE");
		CreateButton.setForeground(new Color(0, 128, 0));
		CreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Code to create array
				size = Integer.valueOf(fieldLength.getText());
				arr = new int[size];
				String message = "Array of length "+size+" created successfully";
				JOptionPane.showMessageDialog(contentPane, message);
			}
		});
		CreateButton.setFont(new Font("Arial", Font.BOLD, 14));
		CreateButton.setBounds(441, 126, 121, 25);
		contentPane.add(CreateButton);
		
		JButton PushButton = new JButton("PUSH");
		PushButton.setForeground(new Color(0, 128, 0));
		PushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to push element into the array
				if(top == size-1) {
					String message = "Stack Overflow! Insertion not possible";
					JOptionPane.showMessageDialog(contentPane, message);
				}
				else {
					int ele = Integer.valueOf(ElementField.getText());
					++top;
					arr[top] = ele;
					//String message = ele+" pushed successfully onto the stack";
					JOptionPane.showMessageDialog(contentPane, ele+" pushed successfully onto the stack");
					ElementField.setText("");
					Display();
				}
			}
		});
		PushButton.setFont(new Font("Arial", Font.BOLD, 14));
		PushButton.setBounds(441, 174, 121, 25);
		contentPane.add(PushButton);
		
		JLabel lblCreation = new JLabel("STACK CREATION");
		lblCreation.setFont(new Font("Arial", Font.BOLD, 14));
		lblCreation.setForeground(new Color(0, 0, 255));
		lblCreation.setBounds(10, 88, 129, 17);
		contentPane.add(lblCreation);
		
		JLabel lblDeletion = new JLabel("DLETION OF ELEMENT");
		lblDeletion.setForeground(Color.BLUE);
		lblDeletion.setFont(new Font("Arial", Font.BOLD, 14));
		lblDeletion.setBounds(10, 245, 160, 17);
		contentPane.add(lblDeletion);
		
		JButton PopButton = new JButton("POP");
		PopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to delete an element from the stack
				if(top == -1) {
					JOptionPane.showMessageDialog(contentPane, "Stack Underflow! Deletion not possible");
				}
				else {
					JOptionPane.showMessageDialog(contentPane, arr[top]+" Deleted successfully");
					--top;
					Display();
				}
			}
		});
		PopButton.setForeground(new Color(0, 128, 0));
		PopButton.setFont(new Font("Arial", Font.BOLD, 18));
		PopButton.setBounds(211, 264, 129, 37);
		contentPane.add(PopButton);
		
		textDisplayField = new JTextField();
		textDisplayField.setFont(new Font("Arial", Font.BOLD, 18));
		textDisplayField.setEditable(false);
		textDisplayField.setColumns(10);
		textDisplayField.setBackground(Color.WHITE);
		textDisplayField.setBounds(42, 386, 492, 36);
		contentPane.add(textDisplayField);
		
		JLabel lblStackElement = new JLabel("ELEMENTS IN THE STACK :");
		lblStackElement.setForeground(Color.BLUE);
		lblStackElement.setFont(new Font("Arial", Font.BOLD, 14));
		lblStackElement.setBounds(10, 349, 193, 17);
		contentPane.add(lblStackElement);
	}
}
