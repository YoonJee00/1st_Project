import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.MemberDao;
import models.Member;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SignupFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfPhone1;
	private JTextField tfPhone2;
	private JTextField tfId;
	private JPasswordField pfPwd1;
	private JPasswordField pfPwd2;
	private JTextField tfName;
	private JTextField tfEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupFrame frame = new SignupFrame();
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
	public SignupFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 520);
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

				if (tfId.getText().trim().length() == 0 || tfId.getText().trim().equals("아이디")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "아이디 입력", JOptionPane.WARNING_MESSAGE);
					tfId.grabFocus();
					return;
				}

				if (pfPwd1.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.", "비밀번호 입력", JOptionPane.WARNING_MESSAGE);
					pfPwd1.grabFocus();
					return;
				}

				if (pfPwd2.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.", "비밀번호 확인 입력", JOptionPane.WARNING_MESSAGE);
					pfPwd1.grabFocus();
					return;
				}

				if (!(pfPwd1.getText().trim().equals(pfPwd2.getText().trim()))) {
					JOptionPane.showMessageDialog(null, "비밀번호가 같지 않습니다.", "비밀번호 확인", JOptionPane.WARNING_MESSAGE);
					return;
				}

				if (tfName.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요.", "이름 입력", JOptionPane.WARNING_MESSAGE);
					tfName.grabFocus();
					return;
				}

				if (tfPhone1.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "핸드폰 번호를 입력해주세요.", "핸드폰 번호 입력", JOptionPane.WARNING_MESSAGE);
					tfPhone1.grabFocus();
					return;
				}

				if (tfPhone2.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "핸드폰 번호를 입력해주세요.", "핸드폰 번호 입력", JOptionPane.WARNING_MESSAGE);
					tfPhone2.grabFocus();
					return;
				}

				if (tfEmail.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "이메일을 입력해주세요.", "이메일 입력", JOptionPane.WARNING_MESSAGE);
					tfPhone1.grabFocus();
					return;
				}

				Member member = new Member();
				member.setId(tfId.getText());
				member.setPwd(pfPwd2.getText());
				member.setName(tfName.getName());
				member.setEmail(tfEmail.getText());
				member.setPhone1(tfPhone1.getText());
				member.setPhone2(tfPhone2.getText());

				MemberDao dao = MemberDao.getInstance();
				int result = dao.save(member);

				if (result == 1) {
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
					dispose();
				}
			}
		});

		btnSingup.setFont(new Font("나눔스퀘어_ac ExtraBold", Font.PLAIN, 15));
		btnSingup.setBounds(118, 361, 201, 43);
		contentPane.add(btnSingup);

		JButton btnNo = new JButton("취소");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame lgframe = new LoginFrame();
				lgframe.setVisible(true);
				dispose();
			}
		});
		btnNo.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		btnNo.setBounds(128, 414, 184, 23);
		contentPane.add(btnNo);

		JLabel lblId = new JLabel("아이디");
		lblId.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblId.setBounds(49, 65, 57, 15);
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
		lblName.setBounds(49, 215, 57, 15);
		contentPane.add(lblName);

		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblPhone.setBounds(49, 265, 57, 15);
		contentPane.add(lblPhone);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblEmail.setBounds(49, 315, 57, 15);
		contentPane.add(lblEmail);

		JButton btnPwdCheck = new JButton("확인하기");
		btnPwdCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPwdCheck.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		btnPwdCheck.setBounds(314, 162, 97, 23);
		contentPane.add(btnPwdCheck);

		tfPhone1 = new JTextField();
		tfPhone1.setFont(new Font("굴림", Font.PLAIN, 13));
		tfPhone1.setBounds(180, 261, 100, 25);
		contentPane.add(tfPhone1);
		tfPhone1.setColumns(10);

		tfPhone2 = new JTextField();
		tfPhone2.setFont(new Font("굴림", Font.PLAIN, 13));
		tfPhone2.setBounds(288, 261, 100, 25);
		contentPane.add(tfPhone2);
		tfPhone2.setColumns(10);

		tfId = new JTextField();
		tfId.setFont(new Font("굴림", Font.PLAIN, 13));
		tfId.setBounds(118, 61, 158, 25);
		contentPane.add(tfId);
		tfId.setColumns(10);

		pfPwd1 = new JPasswordField();
		pfPwd1.setFont(new Font("굴림", Font.PLAIN, 13));
		pfPwd1.setBounds(118, 111, 158, 25);
		contentPane.add(pfPwd1);

		pfPwd2 = new JPasswordField();
		pfPwd2.setFont(new Font("굴림", Font.PLAIN, 13));
		pfPwd2.setBounds(118, 161, 158, 25);
		contentPane.add(pfPwd2);

		tfName = new JTextField();
		tfName.setFont(new Font("굴림", Font.PLAIN, 13));
		tfName.setBounds(118, 211, 158, 25);
		contentPane.add(tfName);
		tfName.setColumns(10);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("굴림", Font.PLAIN, 13));
		tfEmail.setBounds(118, 311, 116, 25);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);

		JLabel lblmail = new JLabel("@");
		lblmail.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblmail.setBounds(235, 315, 15, 15);
		contentPane.add(lblmail);

		JComboBox telBox = new JComboBox();
		telBox.setFont(new Font("굴림", Font.PLAIN, 13));
		telBox.setModel(new DefaultComboBoxModel(new String[] { "010", "011", "016" }));
		telBox.setBounds(118, 261, 55, 25);
		contentPane.add(telBox);

		JComboBox EmailBox = new JComboBox();
		EmailBox.setFont(new Font("굴림", Font.PLAIN, 13));
		EmailBox.setModel(new DefaultComboBoxModel(
				new String[] { "직접입력", "naver.com", "daum.net", "gmail.com", "nate.com", "hanmail.net" }));
		EmailBox.setToolTipText("");
		EmailBox.setEnabled(true);
		EmailBox.setEditable(true);
		EmailBox.setBounds(255, 311, 116, 25);
		contentPane.add(EmailBox);
	}
}
