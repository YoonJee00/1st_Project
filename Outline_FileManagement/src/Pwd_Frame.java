import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pwd_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pwd_Frame frame = new Pwd_Frame();
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
	public Pwd_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFindPwd = new JLabel("비밀번호 찾기");
		lblFindPwd.setBounds(178, 21, 82, 17);
		lblFindPwd.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		contentPane.add(lblFindPwd);
		
		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		lblName.setBounds(73, 65, 57, 15);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(157, 60, 199, 25);
		contentPane.add(textField);
		
		JLabel lblPhone = new JLabel("휴대전화");
		lblPhone.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		lblPhone.setBounds(73, 112, 57, 15);
		contentPane.add(lblPhone);
		
		JSpinner spPhone = new JSpinner();
		spPhone.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		spPhone.setBounds(157, 108, 45, 22);
		contentPane.add(spPhone);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(214, 107, 65, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(291, 107, 65, 25);
		contentPane.add(textField_2);
		
		JLabel lblEmail = new JLabel("아이디");
		lblEmail.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		lblEmail.setBounds(73, 162, 57, 15);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(157, 157, 199, 25);
		contentPane.add(textField_3);
		
		JLabel lblEmail_1 = new JLabel("이메일");
		lblEmail_1.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		lblEmail_1.setBounds(73, 207, 57, 15);
		contentPane.add(lblEmail_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(157, 202, 199, 25);
		contentPane.add(textField_4);
		
		JButton btnOk2 = new JButton("확인");
		btnOk2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk2.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		btnOk2.setBounds(176, 254, 97, 23);
		contentPane.add(btnOk2);
	}

}
