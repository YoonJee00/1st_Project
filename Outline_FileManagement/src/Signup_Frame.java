import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.Member;

public class Signup_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField tfPhone1;
	private JTextField tfPhone2;
	private JTextField tfId;
	private JPasswordField pfPwd1;
	private JPasswordField pfPwd2;
	private JTextField tfNickname;
	private JTextField tfName;
	private JTextField tfEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup_Frame frame = new Signup_Frame();
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
	public Signup_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSingup = new JLabel("회원가입");
		lblSingup.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 17));
		lblSingup.setBounds(180, 10, 70, 25);
		contentPane.add(lblSingup);
		
		JButton btnSingup = new JButton("가입하기");
		btnSingup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member member = new Member();
				
			}
		});
		btnSingup.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 15));
		btnSingup.setBounds(118, 407, 201, 43);
		contentPane.add(btnSingup);
		
		JButton btnNo = new JButton("취소");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNo.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		btnNo.setBounds(132, 468, 173, 23);
		contentPane.add(btnNo);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblId.setBounds(49, 68, 57, 15);
		contentPane.add(lblId);
		
		JLabel lblPwd = new JLabel("비밀번호");
		lblPwd.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblPwd.setBounds(49, 115, 57, 15);
		contentPane.add(lblPwd);
		
		JLabel lblPwdA = new JLabel("재확인");
		lblPwdA.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblPwdA.setBounds(49, 165, 49, 15);
		contentPane.add(lblPwdA);
		
		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblName.setBounds(49, 261, 57, 15);
		contentPane.add(lblName);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblPhone.setBounds(49, 309, 57, 15);
		contentPane.add(lblPhone);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblEmail.setBounds(49, 361, 57, 15);
		contentPane.add(lblEmail);
		
		JLabel lblNickname = new JLabel("닉네임");
		lblNickname.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNickname.setBounds(49, 213, 57, 15);
		contentPane.add(lblNickname);
		
		JButton btnIdCheck = new JButton("중복 확인");
		btnIdCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIdCheck.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		btnIdCheck.setBounds(314, 65, 97, 23);
		contentPane.add(btnIdCheck);
		
		JButton btnPwdCheck = new JButton("확인하기");
		btnPwdCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPwdCheck.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		btnPwdCheck.setBounds(314, 162, 97, 23);
		contentPane.add(btnPwdCheck);
		
		JButton btnNameCheck = new JButton("중복 확인");
		btnNameCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNameCheck.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		btnNameCheck.setBounds(314, 210, 97, 23);
		contentPane.add(btnNameCheck);
		
		JSpinner spPhone = new JSpinner();
		spPhone.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		spPhone.setBounds(118, 305, 45, 25);
		contentPane.add(spPhone);
		
		tfPhone1 = new JTextField();
		tfPhone1.setBounds(176, 305, 100, 25);
		contentPane.add(tfPhone1);
		tfPhone1.setColumns(10);
		
		tfPhone2 = new JTextField();
		tfPhone2.setBounds(288, 305, 100, 25);
		contentPane.add(tfPhone2);
		tfPhone2.setColumns(10);
		
		tfId = new JTextField();
		tfId.setBounds(118, 64, 158, 25);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		pfPwd1 = new JPasswordField();
		pfPwd1.setBounds(118, 111, 158, 25);
		contentPane.add(pfPwd1);
		
		pfPwd2 = new JPasswordField();
		pfPwd2.setBounds(118, 161, 158, 25);
		contentPane.add(pfPwd2);
		
		tfNickname = new JTextField();
		tfNickname.setBounds(118, 209, 158, 25);
		contentPane.add(tfNickname);
		tfNickname.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(118, 257, 158, 25);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(118, 357, 116, 25);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JSpinner spEmail = new JSpinner();
		spEmail.setFont(new Font("나눔스퀘어_ac", Font.PLAIN, 13));
		spEmail.setBounds(255, 357, 116, 25);
		contentPane.add(spEmail);
		
		JLabel lblmail = new JLabel("@");
		lblmail.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblmail.setBounds(235, 361, 15, 15);
		contentPane.add(lblmail);
	}
}
