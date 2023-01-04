import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ID_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfPhone2;
	private JTextField tfEmail;
	private JTextField tfPhone1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ID_Frame frame = new ID_Frame();
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
	public ID_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFindId = new JLabel("아이디 찾기");
		lblFindId.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblFindId.setBounds(178, 21, 74, 25);
		contentPane.add(lblFindId);
		
		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		lblName.setBounds(73, 86, 57, 15);
		contentPane.add(lblName);
		
		JLabel lblPhone = new JLabel("휴대전화");
		lblPhone.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		lblPhone.setBounds(73, 123, 57, 15);
		contentPane.add(lblPhone);
		
		JRadioButton rdbtnPhone = new JRadioButton("휴대전화로 찾기");
		buttonGroup.add(rdbtnPhone);
		rdbtnPhone.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		rdbtnPhone.setBounds(63, 52, 121, 23);
		contentPane.add(rdbtnPhone);
		
		JRadioButton rdbtnEmail = new JRadioButton("이메일로 찾기");
		buttonGroup.add(rdbtnEmail);
		rdbtnEmail.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		rdbtnEmail.setBounds(63, 194, 121, 23);
		contentPane.add(rdbtnEmail);
		
		tfName = new JTextField();
		tfName.setBounds(157, 81, 199, 25);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfPhone2 = new JTextField();
		tfPhone2.setBounds(291, 118, 65, 25);
		contentPane.add(tfPhone2);
		tfPhone2.setColumns(10);
		
		JButton btnOk1 = new JButton("확인");
		btnOk1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		btnOk1.setBounds(178, 165, 97, 23);
		contentPane.add(btnOk1);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		lblEmail.setBounds(73, 223, 57, 15);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(157, 218, 199, 25);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JButton btnOk2 = new JButton("확인");
		btnOk2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk2.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		btnOk2.setBounds(178, 260, 97, 23);
		contentPane.add(btnOk2);
		
		JSpinner spPhone = new JSpinner();
		spPhone.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		spPhone.setBounds(157, 119, 45, 22);
		contentPane.add(spPhone);
		
		tfPhone1 = new JTextField();
		tfPhone1.setColumns(10);
		tfPhone1.setBounds(214, 118, 65, 25);
		contentPane.add(tfPhone1);
	}
}
