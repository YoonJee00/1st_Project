import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

public class FileManagementSystem extends JFrame {

	private Desktop desktop;
	private FileSystemView fileSystemView;
	private File currentFile;
	private JTree tree;
	private DefaultTreeModel treeModel;
	private JProgressBar progressBar;
//	private FileTableModel fileTableModel;
	private JPanel contentPane;
	private JTextField tfSearch;
	private JTable table;
	private JScrollPane scrollPane;
	private ListSelectionListener listSelectionListener;

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

		fileSystemView = FileSystemView.getFileSystemView();
		desktop = Desktop.getDesktop();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 925, 27);
		contentPane.add(menuBar);

		JButton btnAdd = new JButton("파일열기");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd.setMnemonic('o');

				try {
					desktop.open(currentFile);
				} catch (Throwable t) {
					
				}
			}
		});
		btnAdd.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnAdd);

		JButton btnRevise = new JButton("수정하기");
		btnRevise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String folderPath = "";

				JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				chooser.setCurrentDirectory(new File("/"));
				chooser.setAcceptAllFileFilterUsed(true);
				chooser.setDialogTitle("내 PC");
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				FileNameExtensionFilter fBF = new FileNameExtensionFilter("Binary File", "cd11");
				FileNameExtensionFilter fTF = new FileNameExtensionFilter("텍스트 파일", "txt");
				FileNameExtensionFilter fHF = new FileNameExtensionFilter("한글 파일", "hwp");
				FileNameExtensionFilter fWF = new FileNameExtensionFilter("워드 파일", "docx");
				FileNameExtensionFilter fWPF = new FileNameExtensionFilter("워드패드 파일", "rtf");
				chooser.setFileFilter(fBF);
				chooser.setFileFilter(fTF);
				chooser.setFileFilter(fHF);
				chooser.setFileFilter(fWF);
				chooser.setFileFilter(fWPF);

				int returnVal = chooser.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					folderPath = chooser.getSelectedFile().toString();
					File file = chooser.getSelectedFile();

				}
			}
		});
		btnRevise.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnRevise);

		JButton btnSave = new JButton("작성하기");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSave.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnSave);

		JButton btnDelete = new JButton("복사하기");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete.addMouseListener((MouseListener) this);
			}
		});

		btnDelete.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnDelete);

		JButton btnGet = new JButton("이름편집");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel jp = new JPanel();
				jp.setVisible(true);
			}
		});
		btnGet.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 13));
		menuBar.add(btnGet);

		JButton btnSetting = new JButton("삭제하기");
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

		scrollPane = new JScrollPane();
		scrollPane.setBounds(179, 28, 746, 569);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);

		listSelectionListener = new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectionModel().getLeadSelectionIndex();
				setFileDetails(((FileTableModel) table.getModel()).getFile(row));
			}
		};

		table.getSelectionModel().addListSelectionListener(listSelectionListener);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		treeModel = new DefaultTreeModel(root);

		TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent tse) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tse.getPath().getLastPathComponent();
				showChildren(node);
				setFileDetails((File) node.getUserObject());
			}
		};

		File[] roots = fileSystemView.getRoots();
		for (File fileSystemRoot : roots) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(fileSystemRoot);
			root.add(node);

			File[] files = fileSystemView.getFiles(fileSystemRoot, true);
			for (File file : files) {
				if (file.isDirectory()) {
					node.add(new DefaultMutableTreeNode(file));
				}
			}
		}

		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "\uD30C\uC77C\uBA85", "\uACBD\uB85C", "\uD06C\uAE30", "\uC720\uD615",
						"\uC218\uC815\uD55C \uB0A0\uC9DC", "\uB9CC\uB4E0 \uB0A0\uC9DC" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.setAutoCreateRowSorter(true);

		JScrollPane scrollPane_tree = new JScrollPane();
		scrollPane_tree.setBounds(0, 25, 178, 572);
		contentPane.add(scrollPane_tree);

		tree = new JTree(treeModel);
		scrollPane_tree.setViewportView(tree);
		tree.setRootVisible(false);
		tree.addTreeSelectionListener(treeSelectionListener);
		tree.setCellRenderer(new DefaultTreeCellRenderer());
		tree.expandRow(0);

	}
}
