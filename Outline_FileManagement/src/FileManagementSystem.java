import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.apache.commons.io.FileUtils;

public class FileManagementSystem {

	public static final String APP_TITLE = "File Management System";
	private Desktop desktop;
	private FileSystemView fileSystemView;
	private File currentFile;
	private JPanel Outline;
	private JTree tree;
	private DefaultTreeModel treeModel;
	private JTable table;
	private FileTableModel fileTableModel;
	private JProgressBar progressBar;

	private ListSelectionListener listSelectionListener;
	private boolean cellSizesSet = false;
	private int rowIconPadding = 6;

	private JButton btnOpen;
	private JButton btnPrint;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnNew;
	private JButton btnCopy;
	private JButton btnRename;

	private JLabel lbfileName;
	private JTextField tfpath;
	private JLabel lbdate;
	private JLabel lbsize;
	private JRadioButton rbDirectory;
	private JRadioButton rbFile;

	private JPanel newFilePanel;
	private JRadioButton rbnewTypeFile;
	private JTextField tfname;

	public Container getGui() {
		if (Outline == null) {
			Outline = new JPanel(new BorderLayout(3, 3));
			Outline.setBorder(new EmptyBorder(5, 5, 5, 5));

			fileSystemView = FileSystemView.getFileSystemView();
			desktop = Desktop.getDesktop();

			JPanel fileInfo = new JPanel(new BorderLayout(3, 3));

			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setAutoCreateRowSorter(true);
			table.setShowVerticalLines(true);

			listSelectionListener = new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					int row = table.getSelectionModel().getLeadSelectionIndex();
					setFileDetails(((FileTableModel) table.getModel()).getFile(row));
				}
			};

			table.getSelectionModel().addListSelectionListener(listSelectionListener);
			JScrollPane tableScroll = new JScrollPane(table);
			Dimension d = tableScroll.getPreferredSize();
			tableScroll.setPreferredSize(new Dimension((int) d.getWidth(), (int) d.getHeight() / 2));
			fileInfo.add(tableScroll, BorderLayout.CENTER);

			DefaultMutableTreeNode root = new DefaultMutableTreeNode();
			treeModel = new DefaultTreeModel(root);

			TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {

				@Override
				public void valueChanged(TreeSelectionEvent e) {
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
					showChild(node);
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

			tree = new JTree(treeModel);
			tree.setRootVisible(false);
			tree.addTreeSelectionListener(treeSelectionListener);
			tree.setCellRenderer(new FileTreeCellRenderer());
			tree.expandRow(0);
			JScrollPane treeScroll = new JScrollPane(tree);

			tree.setVisibleRowCount(15);

			Dimension preferredSize = treeScroll.getPreferredSize();
			Dimension widePreffered = new Dimension(200, (int) preferredSize.getHeight());
			treeScroll.setPreferredSize(widePreffered);

			JPanel mainFile = new JPanel(new BorderLayout(4, 2));
			mainFile.setBorder(new EmptyBorder(0, 6, 0, 6));

			JPanel fileLabels = new JPanel(new GridLayout(0, 1, 2, 2));
			mainFile.add(fileLabels, BorderLayout.WEST);

			JPanel fileValues = new JPanel(new GridLayout(0, 1, 2, 2));
			mainFile.add(fileValues, BorderLayout.CENTER);

			fileLabels.add(new JLabel("파일명", JLabel.TRAILING));
			lbfileName = new JLabel();
			fileValues.add(lbfileName);
			fileLabels.add(new JLabel("경로", JLabel.TRAILING));
			tfpath = new JTextField(8);
			tfpath.setEditable(true);
			fileValues.add(tfpath);
			fileLabels.add(new JLabel("수정한 날짜", JLabel.TRAILING));
			lbdate = new JLabel();
			fileValues.add(lbdate);
			fileLabels.add(new JLabel("파일 크기", JLabel.TRAILING));
			lbsize = new JLabel();
			fileValues.add(lbsize);
			fileLabels.add(new JLabel("종류", JLabel.TRAILING));

			JPanel fileType = new JPanel(new FlowLayout(FlowLayout.LEADING, 4, 0));
			rbDirectory = new JRadioButton("파일");
			rbDirectory.setEnabled(false);
			fileType.add(rbDirectory);

			rbFile = new JRadioButton("문서");
			rbFile.setEnabled(false);
			fileType.add(rbFile);
			fileValues.add(fileType);

			int count = fileLabels.getComponentCount();
			for (int i = 0; i < count; i++) {
				fileLabels.getComponent(i).setEnabled(false);
			}

			JToolBar toolBar = new JToolBar();
			toolBar.setFloatable(false);

			btnOpen = new JButton("파일열기");
			btnOpen.setMnemonic('o');

			btnOpen.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						desktop.open(currentFile);
					} catch (Throwable t) {
						showThrowable(t);
					}

					Outline.repaint();
				}
			});
			toolBar.add(btnOpen);

			btnEdit = new JButton("편집하기");
			btnEdit.setMnemonic('e');
			btnEdit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						desktop.edit(currentFile);
					} catch (Throwable t) {
						showThrowable(t);
					}
				}
			});
			toolBar.add(btnEdit);

			btnPrint = new JButton("출력하기");
			btnPrint.setMnemonic('p');
			btnPrint.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						desktop.print(currentFile);
					} catch (Throwable t) {
						showThrowable(t);
					}
				}
			});
			toolBar.add(btnPrint);

			btnOpen.setEnabled(desktop.isSupported(Desktop.Action.OPEN));
			btnEdit.setEnabled(desktop.isSupported(Desktop.Action.EDIT));
			btnPrint.setEnabled(desktop.isSupported(Desktop.Action.PRINT));

			toolBar.addSeparator();

			btnNew = new JButton("새파일");
			btnNew.setMnemonic('n');
			btnNew.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					newFile();
				}
			});
			toolBar.add(btnNew);

			btnCopy = new JButton("복사하기");
			btnCopy.setMnemonic('c');
			btnCopy.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
//					
//					

				}
			});
			toolBar.add(btnCopy);

			btnRename = new JButton("이름편집");
			btnRename.setMnemonic('r');
			btnRename.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					renameFile();
				}
			});
			toolBar.add(btnRename);

			btnDelete = new JButton("삭제하기");
			btnDelete.setMnemonic('d');
			btnDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					deleteFile();
				}
			});
			toolBar.add(btnDelete);

			JPanel fileView = new JPanel(new BorderLayout(3, 3));

			fileView.add(toolBar, BorderLayout.NORTH);
			fileView.add(mainFile, BorderLayout.CENTER);

			fileInfo.add(fileView, BorderLayout.SOUTH);

			JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, fileInfo, treeScroll);
			Outline.add(splitPane, BorderLayout.CENTER);

			JPanel pbBar = new JPanel(new BorderLayout(3, 3));
			progressBar = new JProgressBar();
			pbBar.add(progressBar, BorderLayout.EAST);
			progressBar.setVisible(true);

			Outline.add(pbBar, BorderLayout.SOUTH);
		}
		return Outline;
	}

	public void showRootFile() {
		tree.setSelectionInterval(0, 0);
	}

	private TreePath findTreePath(File find) {
		for (int i = 0; i < tree.getRowCount(); i++) {
			TreePath treePath = tree.getPathForRow(i);
			Object object = treePath.getLastPathComponent();
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) object;
			File nodeFile = (File) node.getUserObject();

			if (nodeFile.equals(find))
				;
			return treePath;
		}

		return null;
	}

	private void deleteFile() {
		if (currentFile == null) {
			showErrorMessage("파일을 선택해주세요.", "Select File");
			return;
		}

		int result = JOptionPane.showConfirmDialog(Outline, "파일을 삭제하시겠습니까?", "Delete File", JOptionPane.ERROR_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			try {
				System.out.println("currentFile : " + currentFile);
				TreePath parentPath = findTreePath(currentFile.getParentFile());
				System.out.println("parentPath : " + parentPath);
				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
				System.out.println("parentNode : " + parentNode);

				boolean directory = currentFile.isDirectory();
				if (FileUtils.deleteQuietly(currentFile)) {
					if (directory) {
						TreePath currentPath = findTreePath(currentFile);
						System.out.println(currentPath);
						DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) currentPath
								.getLastPathComponent();

						treeModel.removeNodeFromParent(currentNode);
					}

					showChild(parentNode);
				} else {
					String message = currentFile + " 파일을 삭제할 수 없습니다.";
					showErrorMessage(message, "Delete Failed");
				}
			} catch (Throwable t) {
				showThrowable(t);
			}
		}

		Outline.repaint();
	}

	private void renameFile() {
		if (currentFile == null) {
			showErrorMessage("파일을 선택해주세요.", "Select File");
			return;
		}

		String renameTo = JOptionPane.showInputDialog(Outline, "새이름");
		if (renameTo != null) {
			try {
				boolean directory = currentFile.isDirectory();
				TreePath parentPath = findTreePath(currentFile.getParentFile());
				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();

				boolean renamed = currentFile.renameTo(new File(currentFile.getParentFile(), renameTo));
				if (renamed) {
					if (directory) {
						TreePath currentPath = findTreePath(currentFile);
						System.out.println(currentPath);
						DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) currentPath
								.getLastPathComponent();

						treeModel.removeNodeFromParent(currentNode);
					}

					showChild(parentNode);
				} else {
					String message = currentFile + " 파일의 이름을 변경할 수 없습니다.";
					showErrorMessage(message, "Rename Failed");
				}

			} catch (Throwable t) {
				showThrowable(t);
			}
		}

		Outline.repaint();
	}

	private void newFile() {
		if (currentFile == null) {
			showErrorMessage("저장공간을 선택해주세요.", "Select Location");
			return;
		}

		if (newFilePanel == null) {
			newFilePanel = new JPanel(new BorderLayout(3, 3));

			JPanel southRadio = new JPanel(new GridLayout(1, 0, 2, 2));
			rbnewTypeFile = new JRadioButton("문서", true);
			JRadioButton newTypeDirectory = new JRadioButton("파일");
			ButtonGroup bg = new ButtonGroup();
			bg.add(rbnewTypeFile);
			bg.add(newTypeDirectory);
			southRadio.add(rbnewTypeFile);
			southRadio.add(newTypeDirectory);

			tfname = new JTextField(15);

			newFilePanel.add(new JLabel("Name"), BorderLayout.WEST);
			newFilePanel.add(tfname);
			newFilePanel.add(southRadio, BorderLayout.SOUTH);
		}

		int result = JOptionPane.showConfirmDialog(Outline, newFilePanel, "파일생성", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			try {
				boolean created;
				File parentFile = currentFile;
				if (!parentFile.isDirectory()) {
					parentFile = parentFile.getParentFile();
				}

				File file = new File(parentFile, tfname.getText());
				if (rbnewTypeFile.isSelected()) {
					created = file.createNewFile();
				} else {
					created = file.mkdirs();
				}

				if (created) {
					TreePath parentPath = findTreePath(parentFile);
					DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();

					if (file.isDirectory()) {
						DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(file);

						TreePath currentPath = findTreePath(currentFile);
						DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) currentPath
								.getLastPathComponent();

						treeModel.insertNodeInto(newNode, parentNode, parentNode.getChildCount());
					}

					showChild(parentNode);
				} else {
					String message = currentFile + " 파일 생성에 실패했습니다.";
					showErrorMessage(message, "Create Failed");
				}
			} catch (Throwable t) {
				showThrowable(t);
			}
		}

		Outline.repaint();
	}

	private void showErrorMessage(String errorMessage, String errorTitle) {
		JOptionPane.showMessageDialog(Outline, errorMessage, errorTitle, JOptionPane.ERROR_MESSAGE);
	}

	private void showThrowable(Throwable t) {
		t.printStackTrace();
		JOptionPane.showMessageDialog(Outline, t.toString(), t.getMessage(), JOptionPane.ERROR_MESSAGE);
		Outline.repaint();
	}

	private void setTableData(final File[] files) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				if (fileTableModel == null) {
					fileTableModel = new FileTableModel();
					table.setModel(fileTableModel);
				}

				table.getSelectionModel().removeListSelectionListener(listSelectionListener);
				fileTableModel.setFiles(files);
				table.getSelectionModel().addListSelectionListener(listSelectionListener);
				if (!cellSizesSet) {
					Icon icon = fileSystemView.getSystemIcon(files[0]);

					table.setRowHeight(icon.getIconHeight() + rowIconPadding);

					setColumnWidth(0, -1);
					setColumnWidth(3, 60);
					table.getColumnModel().getColumn(3).setMaxWidth(120);
					setColumnWidth(4, -1);
					setColumnWidth(5, -1);

					cellSizesSet = true;
				}
			}
		});
	}

	private void setColumnWidth(int column, int width) {
		TableColumn tableColumn = table.getColumnModel().getColumn(column);
		if (width <= 0) {
			JLabel label = new JLabel((String) tableColumn.getHeaderValue());
			Dimension preferred = label.getPreferredSize();
			width = (int) preferred.getWidth();
		}

		tableColumn.setPreferredWidth(width);
		tableColumn.setMaxWidth(width);
		tableColumn.setMinWidth(width);
	}

	protected void showChild(final DefaultMutableTreeNode node) {
		tree.setEnabled(false);
		progressBar.setVisible(true);
		progressBar.setIndeterminate(true);

		SwingWorker<Void, File> worker = new SwingWorker<Void, File>() {

			@Override
			public Void doInBackground() throws Exception {
				File file = (File) node.getUserObject();
				if (file.isDirectory()) {
					File[] files = fileSystemView.getFiles(file, true);
					if (node.isLeaf()) {
						for (File child : files) {
							if (child.isDirectory()) {
								publish(child);
							}
						}
					}

					setTableData(files);
				}
				return null;
			}

			@Override
			protected void process(List<File> chunks) {
				for (File child : chunks) {
					node.add(new DefaultMutableTreeNode(child));
				}
			}

			@Override
			protected void done() {
				progressBar.setIndeterminate(false);
				progressBar.setVisible(false);
				tree.setEnabled(true);
			}
		};

		worker.execute();
	}

	protected void setFileDetails(File file) {
		currentFile = file;
		Icon icon = fileSystemView.getSystemIcon(file);
		lbfileName.setIcon(icon);
		lbfileName.setText(fileSystemView.getSystemDisplayName(file));
		tfpath.setText(file.getPath());
		lbdate.setText(new Date(file.lastModified()).toString());
		lbsize.setText(file.length() + "bytes");

		rbDirectory.setSelected(file.isDirectory());
		rbFile.setSelected(file.isFile());

		JFrame f = (JFrame) Outline.getTopLevelAncestor();
		if (f != null) {
			f.setTitle(APP_TITLE + " :: " + fileSystemView.getSystemDisplayName(file));
		}

		Outline.repaint();
	}

	public static boolean copyFile(File from, File to) throws IOException {

		boolean created = to.createNewFile();

		if (created) {
			FileChannel fromChannel = null;
			FileChannel toChannel = null;

			try {
				fromChannel = new FileInputStream(from).getChannel();
				toChannel = new FileOutputStream(to).getChannel();

				toChannel.transferFrom(fromChannel, 0, fromChannel.size());
			} finally {
				if (fromChannel != null) {
					fromChannel.close();
				}

				if (toChannel != null) {
					toChannel.close();
				}

				return false;
			}
		}

		return created;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {

				}

				JFrame f = new JFrame(APP_TITLE);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				FileManagementSystem fileManager = new FileManagementSystem();
				f.setContentPane(fileManager.getGui());

				try {
					URL urlBig = fileManager.getClass().getResource("fm-icon-32x32.png");
					URL urlSmall = fileManager.getClass().getResource("fm-icon-16x16.png");
					ArrayList<Image> images = new ArrayList<Image>();
					images.add(ImageIO.read(urlBig));
					images.add(ImageIO.read(urlSmall));
					f.setIconImages(images);
				} catch (Exception e) {

				}

				f.pack();
				f.setLocationByPlatform(true);
				f.setMinimumSize(f.getSize());
				f.setVisible(true);

				fileManager.showRootFile();
			}
		});
	}

}
