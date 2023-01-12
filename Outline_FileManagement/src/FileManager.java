import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultTreeModel;

public class FileManager extends JFrame {
	
	public static final String APP_TITLE = "문서 관리 프로그램";
	private Desktop desktop;
	private FileSystemView fileSystemView;
	private File currentFile;
	private JPanel contentPane;
	private JTable table;
	private DefaultTreeModel treeModel;
	private JTextField tfSearch;
	
//	private FileTableModel fileTableModel;
	
	private ListSelectionListener listSelectionListener;
	private boolean cellSizesSet = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileManager frame = new FileManager();
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
	public FileManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 714, 518);
		contentPane.add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 39, 683, 319);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setBounds(5, 5, 0, 0);
		panel_2.add(table);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(20, 6, 626, 23);
		panel_1.add(toolBar);
		
		JButton btnOpen = new JButton("파일열기");
		toolBar.add(btnOpen);
		
		JButton btnEdit = new JButton("수정하기");
		toolBar.add(btnEdit);
		
		JButton btnPrint = new JButton("출력하기");
		toolBar.add(btnPrint);
		
		JButton btnNew = new JButton("새 파일");
		toolBar.add(btnNew);
		
		JButton btnCopy = new JButton("복사하기");
		toolBar.add(btnCopy);
		
		JButton btnRename = new JButton("이름편집");
		toolBar.add(btnRename);
		
		JButton btnDelete = new JButton("삭제하기");
		toolBar.add(btnDelete);
		
		tfSearch = new JTextField();
		tfSearch.setText("검색하기");
		toolBar.add(tfSearch);
		tfSearch.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 356, 683, 160);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(12, 31, 57, 15);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 59, 57, 15);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(12, 89, 57, 15);
		panel_3.add(lblNewLabel_2);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(464, 136, 146, 14);
		panel_3.add(progressBar);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1, 1);
		contentPane.add(desktopPane);
	}
}
