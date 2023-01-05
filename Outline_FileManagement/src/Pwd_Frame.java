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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Pwd_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfPhone1;
	private JTextField tfPhone2;
	private JTextField tfId;
	private JTextField tfEmail;

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
		setBounds(100, 100, 450, 345);
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
		
		tfName = new JTextField();
		tfName.setFont(new Font("굴림", Font.PLAIN, 13));
		tfName.setColumns(10);
		tfName.setBounds(157, 60, 199, 25);
		contentPane.add(tfName);
		
		JLabel lblPhone = new JLabel("휴대전화");
		lblPhone.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		lblPhone.setBounds(73, 112, 57, 15);
		contentPane.add(lblPhone);
		
		tfPhone1 = new JTextField();
		tfPhone1.setFont(new Font("굴림", Font.PLAIN, 13));
		tfPhone1.setColumns(10);
		tfPhone1.setBounds(219, 107, 65, 25);
		contentPane.add(tfPhone1);
		
		tfPhone2 = new JTextField();
		tfPhone2.setFont(new Font("굴림", Font.PLAIN, 13));
		tfPhone2.setColumns(10);
		tfPhone2.setBounds(291, 107, 65, 25);
		contentPane.add(tfPhone2);
		
		JLabel lblEmail = new JLabel("아이디");
		lblEmail.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		lblEmail.setBounds(73, 162, 57, 15);
		contentPane.add(lblEmail);
		
		tfId = new JTextField();
		tfId.setFont(new Font("굴림", Font.PLAIN, 13));
		tfId.setColumns(10);
		tfId.setBounds(157, 157, 199, 25);
		contentPane.add(tfId);
		
		JLabel lblEmail_1 = new JLabel("이메일");
		lblEmail_1.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		lblEmail_1.setBounds(73, 207, 57, 15);
		contentPane.add(lblEmail_1);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("굴림", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(157, 202, 199, 25);
		contentPane.add(tfEmail);
		
		JButton btnOk = new JButton("확인");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		btnOk.setBounds(176, 254, 97, 23);
		contentPane.add(btnOk);
		
		JComboBox telBox = new JComboBox();
		telBox.setFont(new Font("굴림", Font.PLAIN, 13));
		telBox.setModel(new DefaultComboBoxModel(new String[] {"010", "011", "016"}));
		telBox.setBounds(157, 107, 55, 25);
		contentPane.add(telBox);
	}

}
