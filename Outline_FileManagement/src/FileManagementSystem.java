import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JScrollPane;

public class FileManagementSystem extends JFrame {

	private JPanel contentPane;
	private JTextField tfSearch;
	private JTable table;
	private JScrollPane scrollPane;

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
		setBounds(100, 100, 941, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 925, 27);
		contentPane.add(menuBar);

		JButton btnAdd = new JButton("추가하기");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnAdd);

		JButton btnRevise = new JButton("수정하기");
		btnRevise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRevise.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnRevise);

		JButton btnSave = new JButton("저장하기");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSave.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnSave);

		JButton btnDelete = new JButton("삭제하기");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnDelete);

		JButton btnGet = new JButton("불러오기");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String folderPath = "";

				JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				chooser.setCurrentDirectory(new File("/"));
				chooser.setAcceptAllFileFilterUsed(true);
				chooser.setDialogTitle("내 PC");
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				FileNameExtensionFilter filter = new FileNameExtensionFilter("Binary File", "cd11");
				chooser.setFileFilter(filter);

				int returnVal = chooser.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					folderPath = chooser.getSelectedFile().toString();
				} else if (returnVal == JFileChooser.CANCEL_OPTION) {
					System.out.println("Cancel");
					folderPath = "";
				}
			}
		});
		btnGet.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnGet);

		JButton btnSetting = new JButton("환경설정");
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSetting.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnSetting);

		JLabel lblSearch = new JLabel("   검색   ");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(lblSearch);

		tfSearch = new JTextField();
		menuBar.add(tfSearch);
		tfSearch.setColumns(10);

		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("File") {
			{
			}
		}));
		tree.setBounds(0, 28, 77, 569);
		contentPane.add(tree);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 28, 847, 569);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\uD30C\uC77C\uBA85", "\uACBD\uB85C", "\uD06C\uAE30", "\uC720\uD615", "\uC218\uC815\uD55C \uB0A0\uC9DC", "\uB9CC\uB4E0 \uB0A0\uC9DC"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.setAutoCreateRowSorter(true);
	}
}
