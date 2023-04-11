package data_structures_project;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Array extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLength;
	private JTextField textFieldElement;
	private JTextField textFieldPosition;
	private JTextField textFieldPositionDelete;
	private JTextField textDisplayField;
	private int arr[];
	
	public void Display() {
		String msg = "";
		for(int i = 0; i < arr.length; i++) {
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
					Array frame = new Array();
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
	public Array() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DataStructureusingSwing.class.getResource("/data_structures_project/logo1.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ARRAY DATASTRUCTURE");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(152, 10, 252, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblArrayLength = new JLabel("Enter Array Length  :");
		lblArrayLength.setFont(new Font("Arial", Font.PLAIN, 14));
		lblArrayLength.setBounds(22, 114, 166, 17); //128
		contentPane.add(lblArrayLength);
		
		JLabel lblEnterInt = new JLabel("Enter an integer Element :");
		lblEnterInt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEnterInt.setBounds(22, 153, 166, 17);
		contentPane.add(lblEnterInt);
		
		JLabel lblEnterPosition = new JLabel("Enter position :");
		lblEnterPosition.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEnterPosition.setBounds(22, 192, 166, 17);
		contentPane.add(lblEnterPosition);
		
		textFieldLength = new JTextField();
		textFieldLength.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldLength.setBounds(247, 111, 121, 25);
		contentPane.add(textFieldLength);
		textFieldLength.setColumns(10);
		
		textFieldElement = new JTextField();
		textFieldElement.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldElement.setBounds(247, 150, 121, 25);
		contentPane.add(textFieldElement);
		textFieldElement.setColumns(10);
		
		textFieldPosition = new JTextField();
		textFieldPosition.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldPosition.setBounds(247, 189, 121, 25);
		contentPane.add(textFieldPosition);
		textFieldPosition.setColumns(10);
		
		JButton btnCreateButton = new JButton("Create Array");
		btnCreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			// Code to create array length
				
				// Now below line will get the text from the text field which is in string 
				// format then convert it into integer and store it in int variable len
				int len = Integer.valueOf(textFieldLength.getText());
				arr = new int[len];
				String message = "Array of length "+len+" created successfully";
				JOptionPane.showMessageDialog(contentPane, message);
			}
		});
		btnCreateButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnCreateButton.setBounds(425, 110, 121, 25);
		contentPane.add(btnCreateButton);
		
		JButton btnInsertButton = new JButton("Insert");
		btnInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to insert element into the array
				int elem = Integer.valueOf(textFieldElement.getText());
				int pos = Integer.valueOf(textFieldPosition.getText());
				arr[pos-1] = elem;
				String message = elem+" inserted into the array at position "+pos+" successfully";
				JOptionPane.showMessageDialog(contentPane, message);
				textFieldElement.setText("");
				textFieldPosition.setText("");
				Display();
			}
		});
		btnInsertButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnInsertButton.setBounds(425, 188, 121, 25);
		contentPane.add(btnInsertButton);
		
		JLabel lblEnter_del_Pos = new JLabel("Enter a position to delete \r\nan element from");
		lblEnter_del_Pos.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEnter_del_Pos.setBounds(22, 290, 266, 17);
		contentPane.add(lblEnter_del_Pos);
		
		JLabel lblInsertion = new JLabel("INSERTION");
		lblInsertion.setForeground(new Color(0, 0, 255));
		lblInsertion.setFont(new Font("Arial", Font.BOLD, 14));
		lblInsertion.setBounds(22, 74, 78, 17);
		contentPane.add(lblInsertion);
		
		JLabel lblDeletion = new JLabel("DELETION");
		lblDeletion.setForeground(new Color(0, 0, 255));
		lblDeletion.setFont(new Font("Arial", Font.BOLD, 14));
		lblDeletion.setBounds(22, 258, 73, 17);
		contentPane.add(lblDeletion);
		
		textFieldPositionDelete = new JTextField();
		textFieldPositionDelete.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldPositionDelete.setBounds(313, 287, 121, 25);
		contentPane.add(textFieldPositionDelete);
		textFieldPositionDelete.setColumns(10);
		
		JButton btnDeleteButton = new JButton("Delete");
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to delete element from the array
				int pos  = Integer.valueOf(textFieldPositionDelete.getText());
				arr[pos-1] = 0;
				String message = "Element deleted at position "+pos+" successfully!";
				JOptionPane.showMessageDialog(contentPane, message);
				textFieldPositionDelete.setText("");
				Display();
			}
		});
		btnDeleteButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeleteButton.setBounds(444, 287, 121, 25);
		contentPane.add(btnDeleteButton);
		
		textDisplayField = new JTextField();
		textDisplayField.setFont(new Font("Arial", Font.BOLD, 18));
		textDisplayField.setBackground(new Color(255, 255, 255));
		textDisplayField.setEditable(false);
		textDisplayField.setBounds(22, 388, 412, 36);
		contentPane.add(textDisplayField);
		textDisplayField.setColumns(10);
		
		JLabel lblElementsInArray = new JLabel("ELEMENTS IN THE ARRAY");
		lblElementsInArray.setForeground(Color.BLUE);
		lblElementsInArray.setFont(new Font("Arial", Font.BOLD, 14));
		lblElementsInArray.setBounds(22, 361, 186, 17);
		contentPane.add(lblElementsInArray);
		
	}
}
