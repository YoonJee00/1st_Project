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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.MemberDao;

public class Login_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JPasswordField pfPwd2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Frame frame = new Login_Frame();
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
	public Login_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfId = new JTextField();
		tfId.setFont(new Font("굴림", Font.PLAIN, 13));
		tfId.setBounds(185, 46, 158, 25);
		contentPane.add(tfId);
		tfId.setColumns(10);

		JLabel lbId = new JLabel("아이디");
		lbId.setFont(new Font("나눔스퀘어_ac Bold", Font.BOLD, 16));
		lbId.setBounds(106, 50, 57, 15);
		contentPane.add(lbId);

		JLabel lbPwd = new JLabel("비밀번호");
		lbPwd.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 16));
		lbPwd.setBounds(106, 97, 57, 15);
		contentPane.add(lbPwd);

		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Id = tfId.getText();
				String pwd = pfPwd2.getText();
				MemberDao dao = MemberDao.getInstance();

				int result = dao.findByUsernameAndPassword(Id, pwd);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
					FileManagementSystem fileManagement = new FileManagementSystem();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
			}
		});
		btnLogin.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		btnLogin.setBounds(126, 139, 192, 34);
		contentPane.add(btnLogin);

		JButton btnSingup = new JButton("회원가입");
		btnSingup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup_Frame signup = new Signup_Frame();
				signup.setVisible(true);
			}
		});
		btnSingup.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		btnSingup.setBounds(37, 195, 97, 23);
		contentPane.add(btnSingup);

		JButton btnFindId = new JButton("아이디 찾기");
		btnFindId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID_Frame sID = new ID_Frame();
				sID.setVisible(true);
			}
		});
		btnFindId.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		btnFindId.setBounds(173, 195, 97, 23);
		contentPane.add(btnFindId);

		JButton btnFindPwd = new JButton("비밀번호 찾기");
		btnFindPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pwd_Frame sPwd = new Pwd_Frame();
				sPwd.setVisible(true);
			}
		});
		btnFindPwd.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		btnFindPwd.setBounds(308, 195, 97, 23);
		contentPane.add(btnFindPwd);

		pfPwd2 = new JPasswordField();
		pfPwd2.setFont(new Font("굴림", Font.PLAIN, 13));
		pfPwd2.setBounds(185, 93, 158, 25);
		contentPane.add(pfPwd2);
	}
}
