package test2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.Icon;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

import java.awt.SystemColor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class Wintest2 {

	private JFrame frmMain;
	private JTable table;
	private JTextField txtMaDia;
	private JTextField txtTenDia;
	private JTextField txtGHT;
	private JTextField txtSLTon;
	private JTextField txtLoaiDia;
	private JTextField txtTLoai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wintest2 window = new Wintest2();
					window.frmMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Wintest2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void LoadDuLieu(JTable table) {
		try {
			table.removeAll();
			String[] arr = {"Mã đĩa", "Tên đĩa", "Giới hạn tuổi", "SL Tồn", "Loại đĩa", "Thể loại"};
			DefaultTableModel model = new DefaultTableModel(arr, 0);
			model.addRow(arr);
			String[] arr2 = {null, null, null, null, null, null};
			model.addRow(arr2);
			
			Connection cnn = DAO.getConnection();
			String query = "select * from dbo.DIA";
			PreparedStatement ps = cnn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector vector = new Vector();
				vector.add(rs.getString("MaDia"));
				vector.add(rs.getString("TenDia"));
				vector.add(rs.getInt("GHTuoi"));
				vector.add(rs.getInt("SLTon"));
				vector.add(rs.getString("MaLoai"));
				vector.add(rs.getString("MaTL"));
				model.addRow(vector);
			}
			table.setModel(model);
			DAO.closeConnection(cnn);
		} catch (Exception e2) {
			e2.printStackTrace();// TODO: handle exception
		}
	}
	
	public void LoadDSKH() {
		try {
			table_kh.removeAll();
			String[] arr = {"Số CMND", "Tên KH", "Năm sinh", "SĐT", "Địa chỉ"};
			DefaultTableModel model = new DefaultTableModel(arr, 0);
			model.addRow(arr);
			String[] arr2 = {null, null, null, null, null};
			model.addRow(arr2);
			
			Connection cnn = DAO.getConnection();
			String query = "select * from dbo.KhachHang";
			PreparedStatement ps = cnn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector vector = new Vector();
				vector.add(rs.getString("CMND"));
				vector.add(rs.getString("TenKH"));
				vector.add(rs.getInt("NamSinh"));
				vector.add(rs.getString("SDT"));
				vector.add(rs.getString("DiaChi"));
				model.addRow(vector);
			}
			table_kh.setModel(model);
			DAO.closeConnection(cnn);
		} catch (Exception e2) {
			e2.printStackTrace();// TODO: handle exception
		}
	}
	
	public void LoadPM() {
		try {
			table_PM.removeAll();
			String[] arr = {"Mã phiếu", "CMND", "Ngày thuê", "Tổng tiền", "Tiền cọc", "Tình trạng"};
			DefaultTableModel model = new DefaultTableModel(arr, 0);
			model.addRow(arr);
			String[] arr2 = {null, null, null, null, null, null};
			model.addRow(arr2);
			
			Connection cnn = DAO.getConnection();
			String query = "select * from dbo.PhieuThue";
			PreparedStatement ps = cnn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector vector = new Vector();
				vector.add(rs.getString("MaPhThue"));
				vector.add(rs.getString("CMND"));
				vector.add(rs.getDate("NgayThue"));
				vector.add(rs.getInt("TongTien"));
				vector.add(rs.getInt("TienCoc"));
				vector.add(rs.getString("TinhTrang"));
				model.addRow(vector);
			}
			table_PM.setModel(model);
			DAO.closeConnection(cnn);
		} catch (Exception e2) {
			e2.printStackTrace();// TODO: handle exception
		}
	}
	
	public void LoadPT() {
		try {
			table_PT.removeAll();
			String[] arr = {"Mã phiếu", "Ngày trả", "Tiền hoàn"};
			DefaultTableModel model = new DefaultTableModel(arr, 0);
			model.addRow(arr);
			String[] arr2 = {null, null, null};
			model.addRow(arr2);
			
			Connection cnn = DAO.getConnection();
			String query = "select * from dbo.PhieuTra";
			PreparedStatement ps = cnn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector vector = new Vector();
				vector.add(rs.getString("MaPhThue"));
				vector.add(rs.getDate("NgayTra"));
				vector.add(rs.getInt("TienHoan"));
				model.addRow(vector);
			}
			table_PT.setModel(model);
			DAO.closeConnection(cnn);
		} catch (Exception e2) {
			e2.printStackTrace();// TODO: handle exception
		}
	}
	
	public int CheckMaDia(String madia) {
		Vector vector = new Vector();
		try {
			Connection cnn = DAO.getConnection();
			String query = "select * from dbo.DIA\r\n"
					+ "where MaDia = '" + madia + "'";
			PreparedStatement ps = cnn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vector.add(rs.getString("MaDia"));
				vector.add(rs.getString("TenDia"));
				vector.add(rs.getInt("GHTuoi"));
				vector.add(rs.getInt("SLTon"));
				vector.add(rs.getString("MaLoai"));
				vector.add(rs.getString("MaTL"));
			}
			DAO.closeConnection(cnn);
		} catch (Exception e2) {
			e2.printStackTrace();// TODO: handle exception
		}
		if (!vector.isEmpty())
			return 1;
		return 0;
	}
	
	public int CheckDiaChuaTra(String madia) {
		Vector vector = new Vector();
		try {
			Connection cnn = DAO.getConnection();
			String query = "select MaDia from PhieuThue, CTPhThue\r\n"
					+ "where TinhTrang = 'C' and MaDia = '" + madia + "'";
			PreparedStatement ps = cnn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vector.add(rs.getString("MaDia"));
			}
			DAO.closeConnection(cnn);
		} catch (Exception e2) {
			e2.printStackTrace();// TODO: handle exception
		}
		if (!vector.isEmpty())
			return 1;
		return 0;
	}
	
	public int CheckKHChuaTra(String cmnd) {
		Vector vector = new Vector();
		try {
			Connection cnn = DAO.getConnection();
			String query = "select CMND from PhieuThue\r\n"
					+ "where TinhTrang = 'C' and CMND = '" + cmnd + "'";
			PreparedStatement ps = cnn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vector.add(rs.getString("CMND"));
			}
			DAO.closeConnection(cnn);
		} catch (Exception e2) {
			e2.printStackTrace();// TODO: handle exception
		}
		if (!vector.isEmpty())
			return 1;
		return 0;
	}
	
	public int CheckCMND (String cmnd) {
		Vector vector = new Vector();
		try {
			Connection cnn = DAO.getConnection();
			String query = "select * from dbo.KhachHang\r\n"
					+ "where CMND = '" + cmnd + "'";
			PreparedStatement ps = cnn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vector.add(rs.getString("CMND"));
				vector.add(rs.getString("TenKH"));
				vector.add(rs.getInt("NamSinh"));
				vector.add(rs.getString("SDT"));
				vector.add(rs.getString("DiaChi"));
			}
			DAO.closeConnection(cnn);
		} catch (Exception e2) {
			e2.printStackTrace();// TODO: handle exception
		}
		if (!vector.isEmpty())
			return 1;
		return 0;
	}
	
	public SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	public int CheckSoPhieu(String sophieu) {
		String maPH = sdf.format(Date.valueOf(java.time.LocalDate.now())) + sophieu;
		Vector vector = new Vector();
		try {
			Connection cnn = DAO.getConnection();
			String query = "select * from dbo.PhieuThue\r\n"
					+ "where MaPhThue = '" + maPH + "'";
			PreparedStatement ps = cnn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vector.add(rs.getString("MaPhThue"));
				vector.add(rs.getString("CMND"));
				vector.add(rs.getDate("NgayThue"));
				vector.add(rs.getInt("TongTien"));
				vector.add(rs.getInt("TienCoc"));
				vector.add(rs.getString("TinhTrang"));
			}
			DAO.closeConnection(cnn);
		} catch (Exception e2) {
			e2.printStackTrace();// TODO: handle exception
		}
		if (!vector.isEmpty())
			return 1;
		return 0;
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        long i = Long.parseLong(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public List<String> listDangMuon = new ArrayList<String>();
	
	public DefaultTableModel modelDangMuon;
	public void LapModelDangMuon() {
		table_3.removeAll();
		String[] arr = {"Mã đĩa", "Tên đĩa", "Giá thuê", "Số lượng", "Tổng tiền"};
		modelDangMuon = new DefaultTableModel(arr, 0);
		modelDangMuon.addRow(arr);
		String[] arr2 = {null, null, null, null, null, null};
		modelDangMuon.addRow(arr2);
		table_3.setModel(modelDangMuon);
	}
	
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField txtSLMuon;
	private JTextField txtMaDiaMuon;
	private JTextField txtTenDiaMuon;
	private JTextField txtCMNDMuon;
	private JTextField txtTienCoc;
	private JTable table_kh;
	private JTextField txtCMND;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtNSinh;
	private JTextField txtUpdateSLMuon;
	private JTextField txtSoPhieu;
	private JTextField txtMaPhTracuu;
	private JTextField txtCMNDTracuu;
	private JTable table_PM;
	private JTextField txtMaPHTra;
	private JTable table_PT;
	private JTextField txtMaPhieuTra;
	private JTextField txtTienHoan;
	private void initialize() {
		frmMain = new JFrame();
		frmMain.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				LapModelDangMuon();
			}
		});
		frmMain.getContentPane().setBackground(Color.DARK_GRAY);
		frmMain.setBackground(Color.BLACK);
		frmMain.setTitle("Ti\u1EC7m b\u0103ng \u0111\u0129a");
		frmMain.setResizable(false);
		frmMain.setBounds(100, 100, 941, 570);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);
		
		JLabel lblTieuDe = new JLabel("TI\u1EC6M B\u0102NG \u0110\u0128A H\u1EA2I NGO\u1EA0I");
		lblTieuDe.setForeground(Color.MAGENTA);
		lblTieuDe.setFont(new Font("Montserrat Black", Font.BOLD, 40));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setBounds(147, 48, 658, 49);
		frmMain.getContentPane().add(lblTieuDe);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(33, 108, 866, 412);
		frmMain.getContentPane().add(tabbedPane);
		
		JPanel pnlTabDia = new JPanel();
		pnlTabDia.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				LoadDuLieu(table_1);
			}
		});
		pnlTabDia.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		pnlTabDia.setBackground(SystemColor.menu);
		tabbedPane.addTab("Tra c\u1EE9u \u0111\u0129a", null, pnlTabDia, null);
		pnlTabDia.setLayout(null);
		
		JButton btnTraCuu = new JButton("Tra cứu");
		btnTraCuu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (txtMaDia.getText().equals("") && txtTenDia.getText().equals(""))
						throw new Exception("Chỉ có thể tra cứu theo mã đĩa hoặc tên đĩa.");
					if (!(txtMaDia.getText().equals("") || txtTenDia.getText().equals("")))
						throw new Exception("Hãy để trống 1 trường mới có thể tra cứu.");
					
					table_1.removeAll();
					String[] arr = {"Mã đĩa", "Tên đĩa", "Giới hạn tuổi", "SL Tồn", "Loại đĩa", "Thể loại"};
					DefaultTableModel model = new DefaultTableModel(arr, 0);
					model.addRow(arr);
					String[] arr2 = {null, null, null, null, null, null};
					model.addRow(arr2);
					
					Connection cnn = DAO.getConnection();
					String kw = null;
					String query = null;
					if (!(txtMaDia.getText().equals(""))) {
						kw = "'%" + txtMaDia.getText() + "%'";
						query = "select * from dbo.DIA\r\n"
								+ "where MaDia like " + kw;
					}
					else {
						kw = "N'%" + txtTenDia.getText() + "%'";
						query = "select * from dbo.DIA\r\n"
								+ "where TenDia like " + kw;
					}
					PreparedStatement ps = cnn.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Vector vector = new Vector();
						vector.add(rs.getString("MaDia"));
						vector.add(rs.getString("TenDia"));
						vector.add(rs.getInt("GHTuoi"));
						vector.add(rs.getInt("SLTon"));
						vector.add(rs.getString("MaLoai"));
						vector.add(rs.getString("MaTL"));
						model.addRow(vector);
					}
					table_1.setModel(model);
					DAO.closeConnection(cnn);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);// TODO: handle exception
				}
			}
		});
		btnTraCuu.setBackground(Color.LIGHT_GRAY);
		btnTraCuu.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnTraCuu.setForeground(Color.MAGENTA);
		btnTraCuu.setBounds(42, 174, 96, 35);
		pnlTabDia.add(btnTraCuu);
		
		JLabel lblMaDia = new JLabel("Mã đĩa");
		lblMaDia.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblMaDia.setBounds(10, 21, 42, 23);
		pnlTabDia.add(lblMaDia);
		
		txtMaDia = new JTextField();
		txtMaDia.setBounds(62, 21, 218, 23);
		pnlTabDia.add(txtMaDia);
		txtMaDia.setColumns(10);
		
		JLabel lblTenDia = new JLabel("Tên đĩa");
		lblTenDia.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblTenDia.setBounds(10, 55, 42, 23);
		pnlTabDia.add(lblTenDia);
		
		txtTenDia = new JTextField();
		txtTenDia.setColumns(10);
		txtTenDia.setBounds(62, 55, 218, 23);
		pnlTabDia.add(txtTenDia);
		
		JLabel lblGHT = new JLabel("GHTuổi");
		lblGHT.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblGHT.setBounds(10, 89, 42, 23);
		pnlTabDia.add(lblGHT);
		
		txtGHT = new JTextField();
		txtGHT.setColumns(10);
		txtGHT.setBounds(62, 89, 60, 23);
		pnlTabDia.add(txtGHT);
		
		txtSLTon = new JTextField();
		txtSLTon.setColumns(10);
		txtSLTon.setBounds(184, 89, 60, 23);
		pnlTabDia.add(txtSLTon);
		
		JLabel lblSLTon = new JLabel("SL Tồn");
		lblSLTon.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblSLTon.setBounds(132, 89, 42, 23);
		pnlTabDia.add(lblSLTon);
		
		JLabel lblLoaiDia = new JLabel("Loại đĩa");
		lblLoaiDia.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblLoaiDia.setBounds(10, 123, 42, 23);
		pnlTabDia.add(lblLoaiDia);
		
		txtLoaiDia = new JTextField();
		txtLoaiDia.setColumns(10);
		txtLoaiDia.setBounds(62, 123, 60, 23);
		pnlTabDia.add(txtLoaiDia);
		
		JLabel lblTLoai = new JLabel("Thể loại");
		lblTLoai.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblTLoai.setBounds(132, 123, 42, 23);
		pnlTabDia.add(lblTLoai);
		
		txtTLoai = new JTextField();
		txtTLoai.setColumns(10);
		txtTLoai.setBounds(184, 123, 96, 23);
		pnlTabDia.add(txtTLoai);
		
		JButton btnThem = new JButton("Thêm đĩa");
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (txtMaDia.getText().equals("") || txtTenDia.getText().equals("") || txtGHT.getText().equals("") || 
							txtSLTon.getText().equals("") || txtLoaiDia.getText().equals("") || txtTLoai.getText().equals("")) {
						throw new Exception("Các trường không được để trống.");
					}
					if (CheckMaDia(txtMaDia.getText()) == 1)
						throw new Exception("Mã đĩa đã tồn tại.");
					if (txtMaDia.getText().length() != 6)
						throw new Exception("Mã đĩa buộc có 6 ký tự.");
					if (!txtMaDia.getText().startsWith("NA") && !txtMaDia.getText().startsWith("PH"))
						throw new Exception("Mã đĩa cần bắt đầu bằng NA hoặc PH.");
					if (!isNumeric(txtMaDia.getText().substring(2)))
						throw new Exception("Mã đĩa không hợp lệ.\nCần kết thúc bằng 4 chữ số.");
					if (!txtLoaiDia.getText().equals("C") && !txtLoaiDia.getText().equals("D"))
						throw new Exception("Loại đĩa ghi C hoặc D.");
					String arr[] = {"N1", "N2", "N3", "N4", "P1", "P2", "P3", "P4"};
					if (!Arrays.asList(arr).contains(txtTLoai.getText()))
						throw new Exception("Thể loại không hợp lệ.");
					if (!isNumeric(txtGHT.getText()))
						throw new Exception("Giới hạn tuổi phải là số.");
					if (Integer.parseInt(txtGHT.getText()) < 0)
						throw new Exception("Giới hạn tuổi nhỏ nhất là 0.");
					if (!isNumeric(txtSLTon.getText()))
						throw new Exception("Số tồn không hợp lệ.");
					if (Integer.parseInt(txtSLTon.getText()) < 1)
						throw new Exception("Nhập đĩa mới phải tồn hơn 0.");
					
					Connection cnn = DAO.getConnection();
					String query = "insert into dbo.DIA(MaDia, TenDia, GHTuoi, SLTon, MaLoai, MaTL)\r\n"
							+ "values (?, ?, ?, ?, ?, ?)";
					PreparedStatement ps = cnn.prepareStatement(query);
					ps.setString(1, txtMaDia.getText());
					ps.setString(2, txtTenDia.getText());
					ps.setInt(3, Integer.parseInt(txtGHT.getText()));
					ps.setInt(4, Integer.parseInt(txtSLTon.getText()));
					ps.setString(5, txtLoaiDia.getText());
					ps.setString(6, txtTLoai.getText());
					ps.executeUpdate();
					DAO.closeConnection(cnn);
					JOptionPane.showMessageDialog(null, "Thêm đĩa thành công.\nHệ thống sẽ refresh.");
					LoadDuLieu(table_1);
				}
				catch (Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnThem.setForeground(Color.MAGENTA);
		btnThem.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnThem.setBackground(Color.LIGHT_GRAY);
		btnThem.setBounds(42, 231, 96, 35);
		pnlTabDia.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa đĩa");
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table_1.getSelectedRow() > 1)
				{
					try {
						int SelectedRow = table_1.getSelectedRow();
						if (CheckDiaChuaTra(table_1.getModel().getValueAt(SelectedRow, 0).toString()) == 1)
							throw new Exception("Còn đĩa chưa trả.\nKhông thể xóa.");
						Connection cnn = DAO.getConnection();
						String query = "delete from dbo.CTPhThue\r\n"
								+ "where MaDia = ?";
						PreparedStatement ps = cnn.prepareStatement(query);
						ps.setString(1, table_1.getModel().getValueAt(SelectedRow, 0).toString());
						ps.executeUpdate();
						String query2 = "delete from dbo.DIA\r\n"
								+ "where MaDia = ?";
						PreparedStatement ps2 = cnn.prepareStatement(query2);
						ps2.setString(1, table_1.getModel().getValueAt(SelectedRow, 0).toString());
						ps2.executeUpdate();
						DAO.closeConnection(cnn);
						JOptionPane.showMessageDialog(null, "Xóa đĩa thành công.\nHệ thống sẽ refresh.");
						LoadDuLieu(table_1);
					}
					catch (Exception e2)
					{
						JOptionPane.showMessageDialog(null, e2);
					}
				}
			}
		});
		btnXoa.setForeground(Color.MAGENTA);
		btnXoa.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnXoa.setBackground(Color.LIGHT_GRAY);
		btnXoa.setBounds(42, 289, 96, 35);
		pnlTabDia.add(btnXoa);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (txtMaDia.getText().equals("") || txtTenDia.getText().equals("") || txtGHT.getText().equals("") || 
							txtSLTon.getText().equals("") || txtLoaiDia.getText().equals("") || txtTLoai.getText().equals("")) {
						throw new Exception("Các trường không được để trống.");
					}
					if (CheckMaDia(txtMaDia.getText()) == 0)
						throw new Exception("Mã đĩa không tồn tại.");
					if (!txtLoaiDia.getText().equals("C") && !txtLoaiDia.getText().equals("D"))
						throw new Exception("Loại đĩa ghi C hoặc D.");
					String arr[] = {"N1", "N2", "N3", "N4", "P1", "P2", "P3", "P4"};
					if (!Arrays.asList(arr).contains(txtTLoai.getText()))
						throw new Exception("Thể loại không hợp lệ.");
					if (!isNumeric(txtGHT.getText()))
						throw new Exception("Giới hạn tuổi phải là số.");
					if (Integer.parseInt(txtGHT.getText()) < 0)
						throw new Exception("Giới hạn tuổi nhỏ nhất là 0.");
					if (!isNumeric(txtSLTon.getText()))
						throw new Exception("Số tồn không hợp lệ.");
					if (Integer.parseInt(txtSLTon.getText()) < 0)
						throw new Exception("Tồn không thể âm.");
					
					Connection cnn = DAO.getConnection();
					String query = "update dbo.DIA\r\n"
							+ "set TenDia = ?, GHTuoi = ?, SLTon = ?, MaLoai = ?, MaTL = ?\r\n"
							+ "where MaDia = ?";
					PreparedStatement ps = cnn.prepareStatement(query);
					ps.setString(1, txtTenDia.getText());
					ps.setInt(2, Integer.parseInt(txtGHT.getText()));
					ps.setInt(3, Integer.parseInt(txtSLTon.getText()));
					ps.setString(4, txtLoaiDia.getText());
					ps.setString(5, txtTLoai.getText());
					ps.setString(6, txtMaDia.getText());
					ps.executeUpdate();
					DAO.closeConnection(cnn);
					JOptionPane.showMessageDialog(null, "Cập nhật thông tin đĩa thành công.\nHệ thống sẽ refresh.");
					LoadDuLieu(table_1);
				}
				catch (Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnUpdate.setForeground(Color.MAGENTA);
		btnUpdate.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setBounds(170, 174, 96, 35);
		pnlTabDia.add(btnUpdate);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadDuLieu(table_1);
			}
		});
		btnRefresh.setForeground(Color.MAGENTA);
		btnRefresh.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnRefresh.setBackground(Color.LIGHT_GRAY);
		btnRefresh.setBounds(170, 231, 96, 35);
		pnlTabDia.add(btnRefresh);
		
		table_1 = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedRow = table_1.getSelectedRow();
				if (SelectedRow > 1)
				{
					txtMaDia.setText(table_1.getModel().getValueAt(SelectedRow, 0).toString());
					txtTenDia.setText(table_1.getModel().getValueAt(SelectedRow, 1).toString());
					txtGHT.setText(table_1.getModel().getValueAt(SelectedRow, 2).toString());
					txtSLTon.setText(table_1.getModel().getValueAt(SelectedRow, 3).toString());
					String loaidia = table_1.getModel().getValueAt(SelectedRow, 4).toString();
					if (loaidia == "C")
						txtLoaiDia.setText("CD");
					else
						txtLoaiDia.setText("DVD");
					String theloai = table_1.getModel().getValueAt(SelectedRow, 5).toString();
					switch(theloai) {
					case "N1":
						theloai = "Nhạc Việt"; break;
					case "N2":
						theloai = "Nhạc Hàn Quốc"; break;
					case "N3":
						theloai = "Nhạc Âu Mỹ"; break;
					case "N4":
						theloai = "Nhạc không lời"; break;
					case "P1":
						theloai = "Hành động"; break;
					case "P2":
						theloai = "Tình cảm"; break;
					case "P3":
						theloai = "KHVT"; break;
					case "P4":
						theloai = "Kinh dị"; break;
					}
					txtTLoai.setText(theloai);
				}
			}
		});
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		table_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table_1.setBackground(SystemColor.menu);
		table_1.setBounds(290, 11, 561, 361);
		pnlTabDia.add(table_1);
		
		JPanel pnlTabPhieu = new JPanel();
		pnlTabPhieu.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				LoadDuLieu(table_2);
			}
		});
		
		JPanel pnlTabTCPM = new JPanel();
		pnlTabTCPM.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				LoadPM();
				
			}
		});
		tabbedPane.addTab("Tra cứu PM", null, pnlTabTCPM, null);
		pnlTabTCPM.setLayout(null);
		
		JLabel lblMaPHTracuu = new JLabel("Mã phiếu");
		lblMaPHTracuu.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblMaPHTracuu.setBounds(10, 26, 64, 23);
		pnlTabTCPM.add(lblMaPHTracuu);
		
		txtMaPhTracuu = new JTextField();
		txtMaPhTracuu.setColumns(10);
		txtMaPhTracuu.setBounds(84, 26, 196, 23);
		pnlTabTCPM.add(txtMaPhTracuu);
		
		JLabel lblCMNDTracuu = new JLabel("CMND");
		lblCMNDTracuu.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblCMNDTracuu.setBounds(10, 60, 64, 23);
		pnlTabTCPM.add(lblCMNDTracuu);
		
		txtCMNDTracuu = new JTextField();
		txtCMNDTracuu.setColumns(10);
		txtCMNDTracuu.setBounds(84, 60, 196, 23);
		pnlTabTCPM.add(txtCMNDTracuu);
		
		JButton btnTraCuuPM = new JButton("Tra cứu");
		btnTraCuuPM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (txtMaPhTracuu.getText().equals("") && txtCMNDTracuu.getText().equals(""))
						throw new Exception("Cần gõ vào ít nhất 1 trường.");
					if (!(txtMaPhTracuu.getText().equals("") || txtCMNDTracuu.getText().equals("")))
						throw new Exception("Hãy để trống 1 trường mới có thể tra cứu.");
					
					table_PM.removeAll();
					String[] arr = {"Mã phiếu", "CMNDKH", "Ngày thuê", "Tổng tiền", "Tiền cọc", "Tình trạng"};
					DefaultTableModel model = new DefaultTableModel(arr, 0);
					model.addRow(arr);
					String[] arr2 = {null, null, null, null, null, null};
					model.addRow(arr2);
					
					Connection cnn = DAO.getConnection();
					String kw = null;
					String query = null;
					if (!(txtMaPhTracuu.getText().equals(""))) {
						kw = "'%" + txtMaPhTracuu.getText() + "%'";
						query = "select * from dbo.PhieuThue\r\n"
								+ "where MaPhThue like " + kw;
					}
					else {
						kw = "N'%" + txtCMNDTracuu.getText() + "%'";
						query = "select * from dbo.PhieuThue\r\n"
								+ "where CMND like " + kw;
					}
					PreparedStatement ps = cnn.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Vector vector = new Vector();
						vector.add(rs.getString("MaPhThue"));
						vector.add(rs.getString("CMND"));
						vector.add(rs.getDate("NgayThue"));
						vector.add(rs.getInt("TongTien"));
						vector.add(rs.getInt("TienCoc"));
						vector.add(rs.getString("TinhTrang"));
						model.addRow(vector);
					}
					table_PM.setModel(model);
					DAO.closeConnection(cnn);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);// TODO: handle exception
				}
			}
		});
		btnTraCuuPM.setForeground(Color.MAGENTA);
		btnTraCuuPM.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnTraCuuPM.setBackground(Color.LIGHT_GRAY);
		btnTraCuuPM.setBounds(99, 111, 96, 35);
		pnlTabTCPM.add(btnTraCuuPM);
		
		table_PM = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_PM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_PM.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		table_PM.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table_PM.setBackground(SystemColor.menu);
		table_PM.setBounds(290, 11, 561, 361);
		pnlTabTCPM.add(table_PM);
		
		JButton btnRefreshPM = new JButton("Refresh");
		btnRefreshPM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadPM();
			}
		});
		btnRefreshPM.setForeground(Color.MAGENTA);
		btnRefreshPM.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnRefreshPM.setBackground(Color.LIGHT_GRAY);
		btnRefreshPM.setBounds(99, 220, 96, 35);
		pnlTabTCPM.add(btnRefreshPM);
		
		JButton btnCTPM = new JButton("Xem CT");
		btnCTPM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedRow = table_PM.getSelectedRow();
				
				if (table_PM.getColumnCount() > 4) {
					if (SelectedRow > 1) {
						try {
							table_PM.removeAll();
							String[] arr = {"Mã phiếu", "Mã đĩa", "Tên đĩa", "Số lượng"};
							DefaultTableModel model = new DefaultTableModel(arr, 0);
							model.addRow(arr);
							String[] arr2 = {null, null, null, null};
							model.addRow(arr2);
							
							Connection cnn = DAO.getConnection();
							String query = "select MaPhThue, DIA.MaDia, TenDia, SoLuong\r\n"
									+ "from dbo.DIA, dbo.CTPhThue\r\n"
									+ "where MaPhThue = ? and DIA.MaDia = CTPhThue.MaDia";
							PreparedStatement ps = cnn.prepareStatement(query);
							ps.setString(1, table_PM.getModel().getValueAt(SelectedRow, 0).toString());
							ResultSet rs = ps.executeQuery();
							while (rs.next()) {
								Vector vector = new Vector();
								vector.add(rs.getString("MaPhThue"));
								vector.add(rs.getString("MaDia"));
								vector.add(rs.getString("TenDia"));
								vector.add(rs.getInt("SoLuong"));
								model.addRow(vector);
							}
							table_PM.setModel(model);
							DAO.closeConnection(cnn);
						} catch (Exception e2) {
							e2.printStackTrace();// TODO: handle exception
						}
					}
				}
			}
		});
		btnCTPM.setForeground(Color.MAGENTA);
		btnCTPM.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnCTPM.setBackground(Color.LIGHT_GRAY);
		btnCTPM.setBounds(99, 167, 96, 35);
		pnlTabTCPM.add(btnCTPM);
		
		JButton btnLapPT = new JButton("Lập PT");
		btnLapPT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table_PM.getColumnCount() > 4) {
					int SelectedRow = table_PM.getSelectedRow();
					if (SelectedRow > 1) {
						if (table_PM.getModel().getValueAt(SelectedRow, 5).toString().equals("C")) {
							try {
								txtMaPhieuTra.setText(table_PM.getModel().getValueAt(SelectedRow, 0).toString());
								int tienhoan = Integer.parseInt(table_PM.getModel().getValueAt(SelectedRow, 4).toString()) 
										- Integer.parseInt(table_PM.getModel().getValueAt(SelectedRow, 3).toString());
								txtTienHoan.setText(Integer.toString(tienhoan));
							} catch (Exception e2) {
								e2.printStackTrace();// TODO: handle exception
							}
						}
					}
				}
			}
		});
		btnLapPT.setForeground(Color.MAGENTA);
		btnLapPT.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnLapPT.setBackground(Color.LIGHT_GRAY);
		btnLapPT.setBounds(99, 271, 96, 35);
		pnlTabTCPM.add(btnLapPT);
		pnlTabPhieu.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		pnlTabPhieu.setBackground(SystemColor.menu);
		tabbedPane.addTab("Lập phiếu mượn", null, pnlTabPhieu, null);
		pnlTabPhieu.setLayout(null);
		
		table_2 = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		table_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table_2.setBackground(SystemColor.menu);
		table_2.setBounds(290, 11, 561, 361);
		pnlTabPhieu.add(table_2);
		
		JLabel lblNhapSL = new JLabel("Nhập số lượng");
		lblNhapSL.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhapSL.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblNhapSL.setBounds(103, 165, 96, 23);
		pnlTabPhieu.add(lblNhapSL);
		
		txtSLMuon = new JTextField();
		txtSLMuon.setColumns(10);
		txtSLMuon.setBounds(58, 204, 196, 23);
		pnlTabPhieu.add(txtSLMuon);
		
		JButton btnThemMuon = new JButton("Thêm");
		btnThemMuon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedRow = table_2.getSelectedRow();
				if (SelectedRow > 1)
				{
					try {
						if (txtSLMuon.getText().equals(""))
							throw new Exception("Hãy nhập số lượng muốn mượn.");
						if (!isNumeric(txtSLMuon.getText()))
							throw new Exception("Hãy nhập số lượng hợp lệ.");
						if (Integer.parseInt(txtSLMuon.getText()) < 1)
							throw new Exception("Mượn ít nhất 1 đĩa.");
						if (Integer.parseInt(txtSLMuon.getText()) > Integer.parseInt(table_2.getModel().getValueAt(SelectedRow, 3).toString()))
							throw new Exception("SL tồn không đủ.");
						if (!listDangMuon.isEmpty())
							if (listDangMuon.contains(table_2.getModel().getValueAt(SelectedRow, 0).toString()))
								throw new Exception("Phiếu đang lập đã có đĩa này.");
						
						listDangMuon.add(table_2.getModel().getValueAt(SelectedRow, 0).toString());
						Vector vector = new Vector();
						vector.add(table_2.getModel().getValueAt(SelectedRow, 0).toString());
						vector.add(table_2.getModel().getValueAt(SelectedRow, 1).toString());
						int gia = 0;
						int tongtien = 0;
						if (table_2.getModel().getValueAt(SelectedRow, 4).toString().equals("C"))
							gia = 2000;
						else
							gia = 5000;
						tongtien = gia*Integer.parseInt(txtSLMuon.getText());
						vector.add(Integer.toString(gia));
						vector.add(txtSLMuon.getText());
						vector.add(Integer.toString(tongtien));
						modelDangMuon.addRow(vector);
						JOptionPane.showMessageDialog(null, "Thêm vào phiếu mượn thành công.");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2);// TODO: handle exception
					}
				}
			}
		});
		btnThemMuon.setForeground(Color.MAGENTA);
		btnThemMuon.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnThemMuon.setBackground(Color.LIGHT_GRAY);
		btnThemMuon.setBounds(103, 248, 105, 45);
		pnlTabPhieu.add(btnThemMuon);
		
		JLabel lblMaDiaMuon = new JLabel("Mã đĩa");
		lblMaDiaMuon.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblMaDiaMuon.setBounds(10, 26, 42, 23);
		pnlTabPhieu.add(lblMaDiaMuon);
		
		txtMaDiaMuon = new JTextField();
		txtMaDiaMuon.setColumns(10);
		txtMaDiaMuon.setBounds(62, 26, 218, 23);
		pnlTabPhieu.add(txtMaDiaMuon);
		
		JLabel lblTenDiaMuon = new JLabel("Tên đĩa");
		lblTenDiaMuon.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblTenDiaMuon.setBounds(10, 60, 42, 23);
		pnlTabPhieu.add(lblTenDiaMuon);
		
		txtTenDiaMuon = new JTextField();
		txtTenDiaMuon.setColumns(10);
		txtTenDiaMuon.setBounds(62, 60, 218, 23);
		pnlTabPhieu.add(txtTenDiaMuon);
		
		JButton btnTraCuuMuon = new JButton("Tra cứu");
		btnTraCuuMuon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (txtMaDiaMuon.getText().equals("") && txtTenDiaMuon.getText().equals(""))
						throw new Exception("Chỉ có thể tra cứu theo mã đĩa hoặc tên đĩa.");
					if (!(txtMaDiaMuon.getText().equals("") || txtTenDiaMuon.getText().equals("")))
						throw new Exception("Hãy để trống 1 trường mới có thể tra cứu.");
					
					table_2.removeAll();
					String[] arr = {"Mã đĩa", "Tên đĩa", "Giới hạn tuổi", "SL Tồn", "Loại đĩa", "Thể loại"};
					DefaultTableModel model = new DefaultTableModel(arr, 0);
					model.addRow(arr);
					String[] arr2 = {null, null, null, null, null, null};
					model.addRow(arr2);
					
					Connection cnn = DAO.getConnection();
					String kw = null;
					String query = null;
					if (!(txtMaDiaMuon.getText().equals(""))) {
						kw = "'%" + txtMaDiaMuon.getText() + "%'";
						query = "select * from dbo.DIA\r\n"
								+ "where MaDia like " + kw;
					}
					else {
						kw = "N'%" + txtTenDiaMuon.getText() + "%'";
						query = "select * from dbo.DIA\r\n"
								+ "where TenDia like " + kw;
					}
					PreparedStatement ps = cnn.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Vector vector = new Vector();
						vector.add(rs.getString("MaDia"));
						vector.add(rs.getString("TenDia"));
						vector.add(rs.getInt("GHTuoi"));
						vector.add(rs.getInt("SLTon"));
						vector.add(rs.getString("MaLoai"));
						vector.add(rs.getString("MaTL"));
						model.addRow(vector);
					}
					table_2.setModel(model);
					DAO.closeConnection(cnn);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);// TODO: handle exception
				}
			}
		});
		btnTraCuuMuon.setForeground(Color.MAGENTA);
		btnTraCuuMuon.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnTraCuuMuon.setBackground(Color.LIGHT_GRAY);
		btnTraCuuMuon.setBounds(47, 108, 96, 35);
		pnlTabPhieu.add(btnTraCuuMuon);
		
		JButton btnRefreshMuon = new JButton("Refresh");
		btnRefreshMuon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadDuLieu(table_2);
			}
		});
		btnRefreshMuon.setForeground(Color.MAGENTA);
		btnRefreshMuon.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnRefreshMuon.setBackground(Color.LIGHT_GRAY);
		btnRefreshMuon.setBounds(170, 108, 96, 35);
		pnlTabPhieu.add(btnRefreshMuon);
		
		JPanel pnlPMHT = new JPanel();
		pnlPMHT.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				table_3.setModel(modelDangMuon);
			}
		});
		tabbedPane.addTab("Phiếu mượn đang lập", null, pnlPMHT, null);
		pnlPMHT.setLayout(null);
		
		table_3 = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_3.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		table_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table_3.setBackground(SystemColor.menu);
		table_3.setBounds(290, 11, 561, 361);
		pnlPMHT.add(table_3);
		
		JLabel lblCMNDMuon = new JLabel("Nhập CMND");
		lblCMNDMuon.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblCMNDMuon.setBounds(10, 230, 76, 23);
		pnlPMHT.add(lblCMNDMuon);
		
		txtCMNDMuon = new JTextField();
		txtCMNDMuon.setColumns(10);
		txtCMNDMuon.setBounds(85, 230, 195, 23);
		pnlPMHT.add(txtCMNDMuon);
		
		JLabel lblTienCoc = new JLabel("Tiền cọc");
		lblTienCoc.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblTienCoc.setBounds(10, 264, 76, 23);
		pnlPMHT.add(lblTienCoc);
		
		txtTienCoc = new JTextField();
		txtTienCoc.setColumns(10);
		txtTienCoc.setBounds(85, 264, 195, 23);
		pnlPMHT.add(txtTienCoc);
		
		JButton btnXacNhan = new JButton("XÁC NHẬN");
		btnXacNhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (txtCMNDMuon.getText().equals("") || txtTienCoc.getText().equals("") || txtSoPhieu.getText().equals(""))
						throw new Exception("Các trường không được để trống.");
					if (txtSoPhieu.getText().length() != 3)
						throw new Exception("Hãy nhập 3 chữ số.");
					if (!txtSoPhieu.getText().startsWith("0")) {
						if (!isNumeric(txtSoPhieu.getText()))
							throw new Exception("Hãy nhập 3 chữ số.");
					}
					else if (!txtSoPhieu.getText().substring(1).startsWith("0")) {
						if (!isNumeric(txtSoPhieu.getText().substring(1)))
							throw new Exception("Hãy nhập 3 chữ số.");
					}
					else if (!isNumeric(txtSoPhieu.getText().substring(2)))
						throw new Exception("Hãy nhập 3 chữ số.");
					if (CheckSoPhieu(txtSoPhieu.getText()) == 1)
						throw new Exception("Hôm nay đã có số phiếu này.");
					if (CheckCMND(txtCMNDMuon.getText()) == 0)
						throw new Exception("Khách hàng chưa có trong hệ thống.");
					if (!isNumeric(txtTienCoc.getText()))
						throw new Exception("Hãy nhập số tiền hợp lệ.");
					
					int tongtien = 0;
					for (int i = 2; i < modelDangMuon.getRowCount(); i++)
						tongtien += Integer.parseInt(modelDangMuon.getValueAt(i, 4).toString());
					int tiencoc = tongtien*2;
					if (Integer.parseInt(txtTienCoc.getText()) < tiencoc)
						throw new Exception("Tiền cọc không đủ.");
					
					Connection cnn = DAO.getConnection();
					String query = "insert into dbo.PhieuThue(MaPhThue, CMND, NgayThue, TongTien, TienCoc, TinhTrang)\r\n"
							+ "values (?, ?, ?, ?, ?, ?)";
					PreparedStatement ps = cnn.prepareStatement(query);
					ps.setString(1, sdf.format(Date.valueOf(java.time.LocalDate.now())).concat(txtSoPhieu.getText()));
					ps.setString(2, txtCMNDMuon.getText());
					ps.setDate(3, Date.valueOf(java.time.LocalDate.now()));
					ps.setInt(4, tongtien);
					ps.setInt(5, Integer.parseInt(txtTienCoc.getText()));
					ps.setString(6, "C");
					ps.executeUpdate();
					
					for (int i = 2; i < modelDangMuon.getRowCount(); i++)
					{
						String query2 = "insert into dbo.CTPhThue(MaPhThue, MaDia, SoLuong)\r\n"
								+ "values (?, ?, ?)";
						PreparedStatement ps2 = cnn.prepareStatement(query2);
						ps2.setString(1, sdf.format(Date.valueOf(java.time.LocalDate.now())) + txtSoPhieu.getText());
						ps2.setString(2, modelDangMuon.getValueAt(i, 0).toString());
						ps2.setInt(3, Integer.parseInt(modelDangMuon.getValueAt(i, 3).toString()));
						ps2.executeUpdate();
						
						String query3 = "update dbo.DIA\r\n"
								+ "set SLTon = SLTon - ?\r\n"
								+ "where MaDia = ?";
						PreparedStatement ps3 = cnn.prepareStatement(query3);
						ps3.setInt(1,Integer.parseInt(modelDangMuon.getValueAt(i, 3).toString()));
						ps3.setString(2, modelDangMuon.getValueAt(i, 0).toString());
						ps3.executeUpdate();
					}
					
					listDangMuon.clear();
					LapModelDangMuon();
					DAO.closeConnection(cnn);
					JOptionPane.showMessageDialog(null, "Lập phiếu mượn thành công.\nHệ thống sẽ refresh.");
					LoadDSKH();
				}
				catch (Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnXacNhan.setForeground(Color.MAGENTA);
		btnXacNhan.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnXacNhan.setBackground(Color.LIGHT_GRAY);
		btnXacNhan.setBounds(94, 317, 105, 45);
		pnlPMHT.add(btnXacNhan);
		
		txtUpdateSLMuon = new JTextField();
		txtUpdateSLMuon.setColumns(10);
		txtUpdateSLMuon.setBounds(29, 35, 98, 23);
		pnlPMHT.add(txtUpdateSLMuon);
		
		JButton btnUpdateSLMuon = new JButton("Sửa số lượng");
		btnUpdateSLMuon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedRow = table_3.getSelectedRow();
				if (SelectedRow > 1) {
					try {
						if (txtUpdateSLMuon.getText().equals(""))
							throw new Exception("Hãy nhập số lượng muốn sửa.");
						if (!isNumeric(txtUpdateSLMuon.getText()))
							throw new Exception("Nhập số lượng hợp lệ.");
						if (Integer.parseInt(txtUpdateSLMuon.getText()) < 1)
							throw new Exception("Mượn ít nhất 1 đĩa.");
						if (txtUpdateSLMuon.getText().equals(table_3.getModel().getValueAt(SelectedRow, 3).toString()))
							throw new Exception("Số lượng không có gì thay đổi.");
						if (Integer.parseInt(txtUpdateSLMuon.getText()) > Integer.parseInt(table_3.getModel().getValueAt(SelectedRow, 3).toString())) {
							LoadDuLieu(table_1);
							for(int i = 2; i < table_1.getRowCount(); i++) {
								if (table_3.getModel().getValueAt(SelectedRow, 0).toString().equals(table_1.getModel().getValueAt(i, 0).toString())) {
									if (Integer.parseInt(txtUpdateSLMuon.getText()) > Integer.parseInt(table_1.getModel().getValueAt(i, 3).toString()))
										throw new Exception("Số lượng tồn không đủ.");
									break;
								}
							}
						}
						
						for (int i = 2; i < modelDangMuon.getRowCount(); i++) {
							if (table_3.getModel().getValueAt(SelectedRow, 0).toString().equals(modelDangMuon.getValueAt(i, 0).toString())) {
								modelDangMuon.setValueAt(txtUpdateSLMuon.getText(), i, 3);
								int tongtien = Integer.parseInt(txtUpdateSLMuon.getText())*Integer.parseInt(modelDangMuon.getValueAt(i, 2).toString());
								modelDangMuon.setValueAt(Integer.toString(tongtien), i, 4);
								break;
							}
						}
						table_3.setModel(modelDangMuon);
						JOptionPane.showMessageDialog(null, "Thay đổi số lượng thành công.");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2);// TODO: handle exception
					}
				}
			}
		});
		btnUpdateSLMuon.setForeground(Color.MAGENTA);
		btnUpdateSLMuon.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnUpdateSLMuon.setBackground(Color.LIGHT_GRAY);
		btnUpdateSLMuon.setBounds(157, 23, 123, 45);
		pnlPMHT.add(btnUpdateSLMuon);
		
		JButton btnXoaMuon = new JButton("XÓA");
		btnXoaMuon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedRow = table_3.getSelectedRow();
				if (SelectedRow > 1) {
					try {
						modelDangMuon.removeRow(SelectedRow);
						table_3.setModel(modelDangMuon);
						JOptionPane.showMessageDialog(null, "Xóa thành công.");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2);// TODO: handle exception
					}
				}
			}
		});
		btnXoaMuon.setForeground(Color.MAGENTA);
		btnXoaMuon.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnXoaMuon.setBackground(Color.LIGHT_GRAY);
		btnXoaMuon.setBounds(157, 91, 105, 45);
		pnlPMHT.add(btnXoaMuon);
		
		JLabel lblLapPM = new JLabel("Lập phiếu mượn");
		lblLapPM.setHorizontalAlignment(SwingConstants.CENTER);
		lblLapPM.setFont(new Font("Montserrat Medium", Font.BOLD, 24));
		lblLapPM.setBounds(10, 147, 270, 41);
		pnlPMHT.add(lblLapPM);
		
		JLabel lblSoPhieu = new JLabel("Số phiếu");
		lblSoPhieu.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblSoPhieu.setBounds(10, 196, 76, 23);
		pnlPMHT.add(lblSoPhieu);
		
		txtSoPhieu = new JTextField();
		txtSoPhieu.setColumns(10);
		txtSoPhieu.setBounds(85, 196, 195, 23);
		pnlPMHT.add(txtSoPhieu);
		
		JPanel pnlTabTra = new JPanel();
		pnlTabTra.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				LoadPT();
			}
		});
		tabbedPane.addTab("Lập phiếu trả", null, pnlTabTra, null);
		pnlTabTra.setLayout(null);
		
		JLabel lblMaPHTra = new JLabel("Mã phiếu");
		lblMaPHTra.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblMaPHTra.setBounds(10, 26, 64, 23);
		pnlTabTra.add(lblMaPHTra);
		
		txtMaPHTra = new JTextField();
		txtMaPHTra.setColumns(10);
		txtMaPHTra.setBounds(84, 26, 196, 23);
		pnlTabTra.add(txtMaPHTra);
		
		JButton btnTraCuuPT = new JButton("Tra cứu");
		btnTraCuuPT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (txtMaPhieuTra.getText().equals(""))
						throw new Exception("Gõ mã phiếu cần tra cứu.");
					
					table_PT.removeAll();
					String[] arr = {"Mã phiếu", "Ngày trả", "Tiền hoàn"};
					DefaultTableModel model = new DefaultTableModel(arr, 0);
					model.addRow(arr);
					String[] arr2 = {null, null, null};
					model.addRow(arr2);
					
					Connection cnn = DAO.getConnection();
					String kw = "'%" + txtMaPhieuTra.getText() + "%'";
					String query = "select * from dbo.PhieuTra\r\n"
								+ "where MaPhThue like " + kw;
					PreparedStatement ps = cnn.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Vector vector = new Vector();
						vector.add(rs.getString("MaPhThue"));
						vector.add(rs.getDate("NgayTra"));
						vector.add(rs.getInt("TienHoan"));
						model.addRow(vector);
					}
					table_PT.setModel(model);
					DAO.closeConnection(cnn);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);// TODO: handle exception
				}
			}
		});
		btnTraCuuPT.setForeground(Color.MAGENTA);
		btnTraCuuPT.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnTraCuuPT.setBackground(Color.LIGHT_GRAY);
		btnTraCuuPT.setBounds(99, 60, 96, 35);
		pnlTabTra.add(btnTraCuuPT);
		
		JButton btnRefreshPT = new JButton("Refresh");
		btnRefreshPT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadPT();
			}
		});
		btnRefreshPT.setForeground(Color.MAGENTA);
		btnRefreshPT.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnRefreshPT.setBackground(Color.LIGHT_GRAY);
		btnRefreshPT.setBounds(99, 106, 96, 35);
		pnlTabTra.add(btnRefreshPT);
		
		table_PT = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_PT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_PT.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		table_PT.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table_PT.setBackground(SystemColor.menu);
		table_PT.setBounds(290, 11, 561, 361);
		pnlTabTra.add(table_PT);
		
		JLabel lblLapPT = new JLabel("Lập phiếu trả");
		lblLapPT.setHorizontalAlignment(SwingConstants.CENTER);
		lblLapPT.setFont(new Font("Montserrat Medium", Font.BOLD, 24));
		lblLapPT.setBounds(10, 152, 270, 41);
		pnlTabTra.add(lblLapPT);
		
		JLabel lblMaPhieuTra = new JLabel("Mã phiếu");
		lblMaPhieuTra.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblMaPhieuTra.setBounds(10, 201, 76, 23);
		pnlTabTra.add(lblMaPhieuTra);
		
		txtMaPhieuTra = new JTextField();
		txtMaPhieuTra.setEnabled(false);
		txtMaPhieuTra.setColumns(10);
		txtMaPhieuTra.setBounds(85, 201, 195, 23);
		pnlTabTra.add(txtMaPhieuTra);
		
		JLabel lblTienHoan = new JLabel("Tiền hoàn");
		lblTienHoan.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblTienHoan.setBounds(10, 235, 76, 23);
		pnlTabTra.add(lblTienHoan);
		
		txtTienHoan = new JTextField();
		txtTienHoan.setEnabled(false);
		txtTienHoan.setColumns(10);
		txtTienHoan.setBounds(85, 235, 195, 23);
		pnlTabTra.add(txtTienHoan);
		
		JButton btnXacNhanTra = new JButton("XÁC NHẬN");
		btnXacNhanTra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (txtMaPhieuTra.getText().equals(""))
						throw new Exception("Chưa chọn phiếu mượn nào.");
					
					Connection cnn = DAO.getConnection();
					String query = "insert into dbo.PhieuTra(MaPhThue, NgayTra, TienHoan)\r\n"
							+ "values (?, ?, ?)";
					PreparedStatement ps = cnn.prepareStatement(query);
					ps.setString(1, txtMaPhieuTra.getText());
					ps.setDate(2, Date.valueOf(java.time.LocalDate.now()));
					ps.setInt(3, Integer.parseInt(txtTienHoan.getText()));
					ps.executeUpdate();
					
					String[] arr = {null, null};
					DefaultTableModel model = new DefaultTableModel(arr, 0);
					model.addRow(arr);
					String query2 = "select MaDia, SoLuong from dbo.CTPhThue where MaPhThue = ?";
					PreparedStatement ps2 = cnn.prepareStatement(query2);
					ps2.setString(1, txtMaPhieuTra.getText());
					ResultSet rs = ps2.executeQuery();
					while(rs.next()) {
						Vector vector = new Vector();
						vector.add(rs.getString("MaDia"));
						vector.add(rs.getInt("SoLuong"));
						model.addRow(vector);
					}
					
					for (int i = 1; i < model.getRowCount(); i++)
					{
						String query3 = "update dbo.DIA\r\n"
								+ "set SLTon = SLTon + ?\r\n"
								+ "where MaDia = ?";
						PreparedStatement ps3 = cnn.prepareStatement(query3);
						ps3.setInt(1, Integer.parseInt(model.getValueAt(i, 1).toString()));
						ps3.setString(2, model.getValueAt(i, 0).toString());
						ps3.executeUpdate();
					}
					
					String query3 = "update dbo.PhieuThue set TinhTrang = 'R' where MaPhThue = ?";
					PreparedStatement ps3 = cnn.prepareStatement(query3);
					ps3.setString(1, txtMaPhieuTra.getText());
					ps3.executeUpdate();
					
					LoadPT();
					DAO.closeConnection(cnn);
					JOptionPane.showMessageDialog(null, "Lập phiếu trả thành công.\nMã phiếu: " + txtMaPhieuTra.getText() + 
							"\nSố tiền cần hoàn: " + txtTienHoan.getText() + "\nHệ thống sẽ refresh.");
					LoadDSKH();
				}
				catch (Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnXacNhanTra.setForeground(Color.MAGENTA);
		btnXacNhanTra.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnXacNhanTra.setBackground(Color.LIGHT_GRAY);
		btnXacNhanTra.setBounds(94, 288, 105, 45);
		pnlTabTra.add(btnXacNhanTra);
		
		JPanel pnlTabKH = new JPanel();
		pnlTabKH.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				LoadDSKH();
			}
		});
		pnlTabKH.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		pnlTabKH.setBackground(SystemColor.menu);
		tabbedPane.addTab("Th\u00F4ng tin KH", null, pnlTabKH, null);
		pnlTabKH.setLayout(null);
		
		table_kh = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_kh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedRow = table_kh.getSelectedRow();
				if (SelectedRow > 1)
				{
					txtCMND.setText(table_kh.getModel().getValueAt(SelectedRow, 0).toString());
					txtTenKH.setText(table_kh.getModel().getValueAt(SelectedRow, 1).toString());
					txtNSinh.setText(table_kh.getModel().getValueAt(SelectedRow, 2).toString());
					txtSDT.setText(table_kh.getModel().getValueAt(SelectedRow, 3).toString());
					txtDiaChi.setText(table_kh.getModel().getValueAt(SelectedRow, 4).toString());
				}
			}
		});
		table_kh.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_kh.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		table_kh.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table_kh.setBackground(SystemColor.menu);
		table_kh.setBounds(290, 11, 561, 361);
		pnlTabKH.add(table_kh);
		
		JLabel lblCMND = new JLabel("CMND");
		lblCMND.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblCMND.setBounds(10, 24, 42, 23);
		pnlTabKH.add(lblCMND);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(62, 24, 218, 23);
		pnlTabKH.add(txtCMND);
		
		JLabel lblTenKH = new JLabel("Tên KH");
		lblTenKH.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblTenKH.setBounds(10, 58, 42, 23);
		pnlTabKH.add(lblTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(62, 58, 218, 23);
		pnlTabKH.add(txtTenKH);
		
		JLabel lblSDT = new JLabel("SĐT");
		lblSDT.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblSDT.setBounds(10, 92, 42, 23);
		pnlTabKH.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(62, 92, 218, 23);
		pnlTabKH.add(txtSDT);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblDiaChi.setBounds(10, 126, 42, 23);
		pnlTabKH.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(62, 126, 91, 23);
		pnlTabKH.add(txtDiaChi);
		
		JLabel lblNSinh = new JLabel("Năm sinh");
		lblNSinh.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		lblNSinh.setBounds(166, 126, 52, 23);
		pnlTabKH.add(lblNSinh);
		
		txtNSinh = new JTextField();
		txtNSinh.setColumns(10);
		txtNSinh.setBounds(228, 126, 52, 23);
		pnlTabKH.add(txtNSinh);
		
		JButton btnTraCuuKH = new JButton("Tra cứu");
		btnTraCuuKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (txtCMND.getText().equals("") && txtTenKH.getText().equals(""))
						throw new Exception("Chỉ có thể tra cứu theo CMND hoặc tên KH.");
					if (!(txtCMND.getText().equals("") || txtTenKH.getText().equals("")))
						throw new Exception("Hãy để trống 1 trường mới có thể tra cứu.");
					
					table_kh.removeAll();
					String[] arr = {"Số CMND", "Tên KH", "Năm sinh", "SĐT", "Địa chỉ"};
					DefaultTableModel model = new DefaultTableModel(arr, 0);
					model.addRow(arr);
					String[] arr2 = {null, null, null, null, null};
					model.addRow(arr2);
					
					Connection cnn = DAO.getConnection();
					String kw = null;
					String query = null;
					if (!(txtCMND.getText().equals(""))) {
						kw = "'%" + txtCMND.getText() + "%'";
						query = "select * from dbo.KhachHang\r\n"
								+ "where CMND like " + kw;
					}
					else {
						kw = "N'%" + txtTenKH.getText() + "%'";
						query = "select * from dbo.KhachHang\r\n"
								+ "where TenKH like " + kw;
					}
					PreparedStatement ps = cnn.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Vector vector = new Vector();
						vector.add(rs.getString("CMND"));
						vector.add(rs.getString("TenKH"));
						vector.add(rs.getInt("NamSinh"));
						vector.add(rs.getString("SDT"));
						vector.add(rs.getString("DiaChi"));
						model.addRow(vector);
					}
					table_kh.setModel(model);
					DAO.closeConnection(cnn);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);// TODO: handle exception
				}
			}
		});
		btnTraCuuKH.setForeground(Color.MAGENTA);
		btnTraCuuKH.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnTraCuuKH.setBackground(Color.LIGHT_GRAY);
		btnTraCuuKH.setBounds(40, 175, 96, 35);
		pnlTabKH.add(btnTraCuuKH);
		
		JButton btnUpdateKH = new JButton("Cập nhật");
		btnUpdateKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (txtCMND.getText().equals("") || txtTenKH.getText().equals("") || txtNSinh.getText().equals("") || 
							txtSDT.getText().equals("") || txtDiaChi.getText().equals("")) {
						throw new Exception("Các trường không được để trống.");
					}
					if (CheckCMND(txtCMND.getText()) == 0)
						throw new Exception("Khách hàng chưa có trong hệ thống.");
					if (!isNumeric(txtNSinh.getText()))
						throw new Exception("Năm sinh phải là số.");
					if (Integer.parseInt(txtNSinh.getText()) > 2012)
						throw new Exception("Khách hàng cần trên 10 tuổi.");
					if (!txtSDT.getText().startsWith("0"))
						throw new Exception("SĐT bắt đầu là 0.");
					if (!isNumeric(txtSDT.getText().substring(1)))
						throw new Exception("SĐT không hợp lệ.");
					if (txtSDT.getText().length() != 10)
						throw new Exception("SĐT phải đủ 10 số.");
					
					Connection cnn = DAO.getConnection();
					String query = "update dbo.KhachHang\r\n"
							+ "set TenKH = ?, NamSinh = ?, SDT = ?, DiaChi = ?\r\n"
							+ "where CMND = ?";
					PreparedStatement ps = cnn.prepareStatement(query);
					ps.setString(1, txtTenKH.getText());
					ps.setInt(2, Integer.parseInt(txtNSinh.getText()));
					ps.setString(3, txtSDT.getText());
					ps.setString(4, txtDiaChi.getText());
					ps.setString(5, txtCMND.getText());
					ps.executeUpdate();
					DAO.closeConnection(cnn);
					JOptionPane.showMessageDialog(null, "Cập nhật thông tin KH thành công.\nHệ thống sẽ refresh.");
					LoadDSKH();
				}
				catch (Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnUpdateKH.setForeground(Color.MAGENTA);
		btnUpdateKH.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnUpdateKH.setBackground(Color.LIGHT_GRAY);
		btnUpdateKH.setBounds(168, 175, 96, 35);
		pnlTabKH.add(btnUpdateKH);
		
		JButton btnThemKH = new JButton("Thêm KH");
		btnThemKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (txtCMND.getText().equals("") || txtTenKH.getText().equals("") || txtNSinh.getText().equals("") || 
							txtSDT.getText().equals("") || txtDiaChi.getText().equals("")) {
						throw new Exception("Các trường không được để trống.");
					}
					if (CheckCMND(txtCMND.getText()) == 1)
						throw new Exception("Khách hàng đã có trong hệ thống.");
					if (txtCMND.getText().length() != 9 && txtCMND.getText().length() != 12)
						throw new Exception("CMND có 9 hoặc 12 ký tự.");
					if (!txtCMND.getText().startsWith("0")) {
						if (!isNumeric(txtCMND.getText()))
							throw new Exception("CMND phải là 1 dãy số.");
					}
					else if (!isNumeric(txtCMND.getText().substring(1)))
							throw new Exception("CMND phải là 1 dãy số.");
					if (!isNumeric(txtNSinh.getText()))
						throw new Exception("Năm sinh phải là số.");
					if (Integer.parseInt(txtNSinh.getText()) > 2012)
						throw new Exception("Khách hàng cần trên 10 tuổi.");
					if (!txtSDT.getText().startsWith("0"))
						throw new Exception("SĐT bắt đầu là 0.");
					if (!isNumeric(txtSDT.getText().substring(1)))
						throw new Exception("SĐT không hợp lệ.");
					if (txtSDT.getText().length() != 10)
						throw new Exception("SĐT phải đủ 10 số.");
					
					Connection cnn = DAO.getConnection();
					String query = "insert into dbo.KhachHang(CMND, TenKH, NamSinh, SDT, DiaChi)\r\n"
							+ "values (?, ?, ?, ?, ?)";
					PreparedStatement ps = cnn.prepareStatement(query);
					ps.setString(1, txtCMND.getText());
					ps.setString(2, txtTenKH.getText());
					ps.setInt(3, Integer.parseInt(txtNSinh.getText()));
					ps.setString(4, txtSDT.getText());
					ps.setString(5, txtDiaChi.getText());
					ps.executeUpdate();
					DAO.closeConnection(cnn);
					JOptionPane.showMessageDialog(null, "Thêm KH mới thành công.\nHệ thống sẽ refresh.");
					LoadDSKH();;
				}
				catch (Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnThemKH.setForeground(Color.MAGENTA);
		btnThemKH.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnThemKH.setBackground(Color.LIGHT_GRAY);
		btnThemKH.setBounds(40, 232, 96, 35);
		pnlTabKH.add(btnThemKH);
		
		JButton btnRefreshKH = new JButton("Refresh");
		btnRefreshKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadDSKH();
			}
		});
		btnRefreshKH.setForeground(Color.MAGENTA);
		btnRefreshKH.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnRefreshKH.setBackground(Color.LIGHT_GRAY);
		btnRefreshKH.setBounds(168, 232, 96, 35);
		pnlTabKH.add(btnRefreshKH);
		
		JButton btnXoaKH = new JButton("Xóa KH");
		btnXoaKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table_kh.getSelectedRow() > 1)
				{
					try {
						int SelectedRow = table_kh.getSelectedRow();
						if (CheckKHChuaTra(table_kh.getModel().getValueAt(SelectedRow, 0).toString()) == 1)
							throw new Exception("Khách hàng còn mượn đĩa.\nKhông thể xóa.");
						
						Connection cnn = DAO.getConnection();
						String query = "select MaPhThue from dbo.PhieuThue\r\n"
								+ "where CMND = ?";
						PreparedStatement ps = cnn.prepareStatement(query);
						ps.setString(1, table_kh.getModel().getValueAt(SelectedRow, 0).toString());
						ResultSet rs = ps.executeQuery();
						List<String> list = new ArrayList<String>();
						while (rs.next()) {
							list.add(rs.getString("MaPhThue"));
						}
						for (int i = 0; i < list.size(); i++) {
							String query2 = "delete from dbo.CTPhThue\r\n"
									+ "where MaPhThue = ?";
							PreparedStatement ps2 = cnn.prepareStatement(query2);
							ps2.setString(1, list.get(i));
							ps2.executeUpdate();
							
							String query3 = "delete from dbo.PhieuThue\r\n"
									+ "where MaPhThue = ?";
							PreparedStatement ps3 = cnn.prepareStatement(query3);
							ps3.setString(1, list.get(i));
							ps3.executeUpdate();
						}
						
						String query4 = "delete from dbo.KhachHang\r\n"
								+ "where CMND = ?";
						PreparedStatement ps4 = cnn.prepareStatement(query4);
						ps4.setString(1, table_kh.getModel().getValueAt(SelectedRow, 0).toString());
						ps4.executeUpdate();
						DAO.closeConnection(cnn);
						JOptionPane.showMessageDialog(null, "Xóa KH thành công.\nHệ thống sẽ refresh.");
						LoadDSKH();
					}
					catch (Exception e2)
					{
						JOptionPane.showMessageDialog(null, e2);
					}
				}
			}
		});
		btnXoaKH.setForeground(Color.MAGENTA);
		btnXoaKH.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
		btnXoaKH.setBackground(Color.LIGHT_GRAY);
		btnXoaKH.setBounds(40, 290, 96, 35);
		pnlTabKH.add(btnXoaKH);
	}
}
