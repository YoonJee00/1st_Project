import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.aspose.cad.internal.bouncycastle.crypto.generators.RSABlindingFactorGenerator;

import dao.MemberDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import dao.MemberDao;
import models.Member;

public class IdFrame extends JFrame {

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
					IdFrame frame = new IdFrame();
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
	public IdFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
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
		tfName.setFont(new Font("굴림", Font.PLAIN, 13));
		tfName.setBounds(157, 81, 199, 25);
		contentPane.add(tfName);
		tfName.setColumns(10);

		tfPhone2 = new JTextField();
		tfPhone2.setFont(new Font("굴림", Font.PLAIN, 13));
		tfPhone2.setBounds(291, 118, 65, 25);
		contentPane.add(tfPhone2);
		tfPhone2.setColumns(10);

		JButton btnOk1 = new JButton("확인");
		btnOk1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

				String Name = tfName.getText();
				String Phone1 = tfPhone1.getText();
				String Phone2 = tfPhone2.getText();
				MemberDao dao = MemberDao.getInstance();

				int result = dao.findIdByPhone(Name, Phone1, Phone2);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "ID");
				} else {
					JOptionPane.showMessageDialog(null, "일치하는 회원 정보가 없습니다.");
				}
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
		tfEmail.setFont(new Font("굴림", Font.PLAIN, 13));
		tfEmail.setBounds(157, 218, 90, 25);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);

		JButton btnOk2 = new JButton("확인");
		btnOk2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfEmail.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "이메일을 입력해주세요.", "이메일 입력", JOptionPane.WARNING_MESSAGE);
					tfEmail.grabFocus();
					return;
				}

				String Email = tfEmail.getText();
				MemberDao dao = MemberDao.getInstance();

				int result = dao.findIdByEmail(Email);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "Email");
				} else {
					JOptionPane.showMessageDialog(null, "일치하는 회원 정보가 없습니다.");
				}
			}
		});
		btnOk2.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		btnOk2.setBounds(178, 260, 97, 23);
		contentPane.add(btnOk2);

		tfPhone1 = new JTextField();
		tfPhone1.setFont(new Font("굴림", Font.PLAIN, 13));
		tfPhone1.setColumns(10);
		tfPhone1.setBounds(219, 118, 65, 25);
		contentPane.add(tfPhone1);

		JComboBox telBox = new JComboBox();
		telBox.setModel(new DefaultComboBoxModel(new String[] { "010", "011", "016" }));
		telBox.setFont(new Font("굴림", Font.PLAIN, 13));
		telBox.setBounds(157, 118, 55, 25);
		contentPane.add(telBox);

		JComboBox EmailBox = new JComboBox();
		EmailBox.setModel(new DefaultComboBoxModel(
				new String[] { "직접입력", "naver.com", "daum.net", "gmail.com", "nate.com", "hanmail.net" }));
		EmailBox.setToolTipText("");
		EmailBox.setFont(new Font("굴림", Font.PLAIN, 13));
		EmailBox.setEnabled(true);
		EmailBox.setEditable(true);
		EmailBox.setBounds(266, 218, 90, 25);
		contentPane.add(EmailBox);

		JLabel lblmail = new JLabel("@");
		lblmail.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblmail.setBounds(248, 222, 15, 15);
		contentPane.add(lblmail);
	}
}
