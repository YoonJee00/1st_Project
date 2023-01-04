import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class FileManagementSystem extends JFrame {

	private JPanel contentPane;
	private JTextField tfSearch;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileManagementSystem frame = new FileManagementSystem();
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
	public FileManagementSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 935, 25);
		contentPane.add(menuBar);
		
		JButton btnAdd = new JButton("추가하기");
		btnAdd.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnAdd);
		
		JButton btnRevise = new JButton("수정하기");
		btnRevise.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnRevise);
		
		JButton btnSave = new JButton("저장하기");
		btnSave.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnSave);
		
		JButton btnDelete = new JButton("삭제하기");
		btnDelete.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnDelete);
		
		JButton btnGet = new JButton("불러오기");
		btnGet.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnGet);
		
		JButton btnSetting = new JButton("환경설정");
		btnSetting.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnSetting);
		
		JLabel lblSearch = new JLabel("   검색   ");
		lblSearch.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(lblSearch);
		
		tfSearch = new JTextField();
		menuBar.add(tfSearch);
		tfSearch.setColumns(10);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("colors");
						node_1.add(new DefaultMutableTreeNode("blue"));
						node_1.add(new DefaultMutableTreeNode("violet"));
						node_1.add(new DefaultMutableTreeNode("red"));
						node_1.add(new DefaultMutableTreeNode("yellow"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("sports");
						node_1.add(new DefaultMutableTreeNode("basketball"));
						node_1.add(new DefaultMutableTreeNode("soccer"));
						node_1.add(new DefaultMutableTreeNode("football"));
						node_1.add(new DefaultMutableTreeNode("hockey"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("food");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_1.add(new DefaultMutableTreeNode("bananas"));
					add(node_1);
				}
			}
		));
		tree.setBounds(0, 24, 77, 578);
		contentPane.add(tree);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(78, 25, 857, 577);
		contentPane.add(table);
	}
}
