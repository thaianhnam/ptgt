/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.OToDao;
import DAO.PhieuThueDao;
import DATA.DataValidator;
import DATA.MessageDialogHelper;
import DAO.ThongTinXeDao;
import DAO.XeMayDao;
import DAO.XeTaiDao;
import DTO.OTo;
import DTO.PhieuThue;
import DTO.ThongTinXe;
import DTO.XeMay;
import DTO.XeTai;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyThongTinXe extends javax.swing.JPanel {

    private MainForm parentForm;
    private DefaultTableModel tblModel;

    /**
     * Creates new form QuanLyThongTinXe
     */
    public QuanLyThongTinXe() {
        initComponents();

        initTable();

        loadDataToTable();
    }

    public void initTable() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Biển Số","Mã xe", "Ngày Đăng Ký", "Tình Trạng", "Trạng Thái"});
        tblThongTinXe.setModel(tblModel);
    }

    private void loadDataToTable() {
        try {
            ThongTinXeDao dao = new ThongTinXeDao();
            List<ThongTinXe> list = dao.findAll();
            PhieuThueDao dao2 = new PhieuThueDao();
            List<PhieuThue> list2 = dao2.findAll();
            String tinhtrang = "null";
            tblModel.setRowCount(0);
            for (ThongTinXe thongtinxe : list) {
                if( thongtinxe.getMaXM()!=null){
                    for (PhieuThue phieuThue : list2) {
                        if(phieuThue.getBienSo().equalsIgnoreCase(thongtinxe.getBienSo())){
                            tinhtrang = "Đã Thuê";
                            break;
                        }else{
                            tinhtrang = "Chưa Thuê";
                        }
                    }
                    tblModel.addRow(new Object[]{
                    thongtinxe.getBienSo(), thongtinxe.getMaXM(), thongtinxe.getNgayDangKy(), thongtinxe.getTinhTrang(),tinhtrang
                    });
                }else if( thongtinxe.getMaOT()!=null){
                    for (PhieuThue phieuThue : list2) {
                        if(phieuThue.getBienSo().equalsIgnoreCase(thongtinxe.getBienSo())){
                            tinhtrang = "Đã Thuê";
                            break;
                        }else{
                            tinhtrang = "Chưa Thuê";
                        }
                    }
                    tblModel.addRow(new Object[]{
                    thongtinxe.getBienSo(), thongtinxe.getMaOT(), thongtinxe.getNgayDangKy(), thongtinxe.getTinhTrang(),tinhtrang
                    });
                }else{
                    for (PhieuThue phieuThue : list2) {
                        if(phieuThue.getBienSo().equalsIgnoreCase(thongtinxe.getBienSo())){
                            tinhtrang = "Đã Thuê";
                            break;
                        }else{
                            tinhtrang = "Chưa Thuê";
                        }
                    }
                    tblModel.addRow(new Object[]{
                    thongtinxe.getBienSo(), thongtinxe.getMaXT(), thongtinxe.getNgayDangKy(), thongtinxe.getTinhTrang(), tinhtrang
                    });
                }
                
            }

            tblModel.fireTableDataChanged();

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
    
    
    private void loadDataToTableXeTim() {
        try {
            

            ThongTinXeDao dao = new ThongTinXeDao();
            ThongTinXe thongtinxe = dao.findById(txtBienSoTK.getText());
             
            tblModel.setRowCount(0);
           
                if( thongtinxe.getMaXM()!=null){
                    tblModel.addRow(new Object[]{
                    thongtinxe.getBienSo(), thongtinxe.getMaXM(), thongtinxe.getNgayDangKy(), thongtinxe.getTinhTrang()
                    });
                }else if( thongtinxe.getMaOT()!=null){
                    tblModel.addRow(new Object[]{
                    thongtinxe.getBienSo(), thongtinxe.getMaOT(), thongtinxe.getNgayDangKy(), thongtinxe.getTinhTrang()
                    });
                }else{
                    tblModel.addRow(new Object[]{
                    thongtinxe.getBienSo(), thongtinxe.getMaXT(), thongtinxe.getNgayDangKy(), thongtinxe.getTinhTrang()
                    });
                }
            tblModel.fireTableDataChanged();

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTinXe = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtBienSo = new javax.swing.JTextField();
        txtMaLoaiXe = new javax.swing.JTextField();
        txtNgayDangKy = new javax.swing.JTextField();
        txtTinhTrang = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtBienSoTK = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Quản Lý Thông Tin Xe");

        jLabel2.setText("Biển Số:");

        jLabel3.setText("Mã Loại Xe:");

        jLabel4.setText("Ngày Đăng Kí:");

        tblThongTinXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblThongTinXe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongTinXeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThongTinXe);

        jLabel6.setText("Tình Trạng:");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Add-24.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Edit-24.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Delete-24.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        jLabel9.setText("Nhập biển số cần tìm:");

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Search-24.png"))); // NOI18N
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBienSoTK, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnTim)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBienSoTK))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnTim)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reset.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Cancel-24.png"))); // NOI18N
        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBienSo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgayDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(34, 34, 34)
                                .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(8, 8, 8)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDong))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtNgayDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(21, 21, 21)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtBienSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(txtMaLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnThem)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        DataValidator.validdateEmpty(txtBienSo, sb, "Biển số không được bỏ trống");
        DataValidator.validdateEmpty(txtMaLoaiXe, sb, "Mã Loại Xe không được bỏ trống");
        DataValidator.validdateEmpty(txtNgayDangKy, sb, "Ngày đăng ký không được bỏ trống");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }
        try {
            boolean KTMLX = false;
            XeMayDao xmd = new XeMayDao();
            List<XeMay> xm= xmd.findAll();
            for(XeMay xemay : xm){
                if(xemay.getMaXM().trim().equalsIgnoreCase(txtMaLoaiXe.getText().trim())){
                    KTMLX = true;
                }
            }
            OToDao otd = new OToDao();
            List<OTo> ot= otd.findAll();
            for(OTo oto : ot){
                if(oto.getMaOT().trim().equalsIgnoreCase(txtMaLoaiXe.getText().trim())){
                    KTMLX = true;
                }
            }
            XeTaiDao xtd = new XeTaiDao();
            List<XeTai> xt= xtd.findAll();
            for(XeTai xetai : xt){
                if(xetai.getMaXT().trim().equalsIgnoreCase(txtMaLoaiXe.getText().trim())){
                    KTMLX = true;
                }
            }
            
            
            if(KTMLX == true){
                ThongTinXe ttx = new ThongTinXe();
                
                ttx.setBienSo(txtBienSo.getText().trim());
                if(txtMaLoaiXe.getText().startsWith("XM")){
                    ttx.setMaXM(txtMaLoaiXe.getText());
                }else if(txtMaLoaiXe.getText().startsWith("OT")){
                    ttx.setMaOT(txtMaLoaiXe.getText());
                }else if(txtMaLoaiXe.getText().startsWith("XT")){
                    ttx.setMaXT(txtMaLoaiXe.getText());
                }else{
                    MessageDialogHelper.showMessageDialog(parentForm, "Mã Loại Xe phải được bắt đầu bằng XM, OT hoặc XT", "Lỗi");
                    return;
                }


                ttx.setNgayDangKy(txtNgayDangKy.getText());
                ttx.setTinhTrang(txtTinhTrang.getText());

                ThongTinXeDao dao = new ThongTinXeDao();
                boolean CheckTTX = false;
                List<ThongTinXe> lttx = dao.findAll();
                for(ThongTinXe thongtinxe:lttx){
                    if(thongtinxe.getBienSo().trim().equalsIgnoreCase(txtBienSo.getText().trim())){
                        CheckTTX = true;
                    }
                }
                if(CheckTTX == true){
                    MessageDialogHelper.showMessageDialog(parentForm, "Thông tin xe đã tồn tại", "Cảnh báo");
                    return;
                }else{
                    if (dao.insert(ttx)) {
                        MessageDialogHelper.showMessageDialog(parentForm, "Thông tin xe đã được lưu", "Thông báo");
                        btnResetActionPerformed(evt);
                        loadDataToTable();
                    }else {
                        MessageDialogHelper.showConfirmDialog(parentForm, "Thông tin xe không được lưu do lỗi", "Cảnh báo");
                    }
                }
            }else{
                MessageDialogHelper.showMessageDialog(parentForm, "Mã Loại Xe không tồn tại", "Lỗi");
                return;
            }
            
            

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        DataValidator.validdateEmpty(txtBienSo, sb, "Biển số không được bỏ trống");
        DataValidator.validdateEmpty(txtMaLoaiXe, sb, "Mã Loại Xe không được bỏ trống");
        DataValidator.validdateEmpty(txtNgayDangKy, sb, "Ngày đăng ký không được bỏ trống");

        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }

        if (MessageDialogHelper.showConfirmDialog(parentForm, "Bạn có muốn cập nhật thông tin xe không?", "Hỏi") == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            ThongTinXe ttx = new ThongTinXe();
            if(txtMaLoaiXe.getText().startsWith("XM")){
                ttx.setMaXM(txtMaLoaiXe.getText());
            }else if(txtMaLoaiXe.getText().startsWith("OT")){
                ttx.setMaOT(txtMaLoaiXe.getText());
            }else if(txtMaLoaiXe.getText().startsWith("XT")){
                ttx.setMaXT(txtMaLoaiXe.getText());
            }else{
                DataValidator.validdateEmpty(txtMaLoaiXe, sb, "Mã Loại Xe phải được bắt đầu bằng XM, OT hoặc XT");
            }
            ttx.setNgayDangKy(txtNgayDangKy.getText());
            ttx.setTinhTrang(txtTinhTrang.getText());
            ttx.setBienSo(txtBienSo.getText());
            
            ThongTinXeDao dao = new ThongTinXeDao();
            if (dao.update(ttx)) {
                MessageDialogHelper.showMessageDialog(parentForm, "Thông tin xe đã được cập nhật", "Thông báo");
                
                loadDataToTable();
            } else {
                MessageDialogHelper.showConfirmDialog(parentForm, "Thông tin xe không được cập nhật do lỗi", "Cảnh báo");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
       StringBuilder sb = new StringBuilder();
        DataValidator.validdateEmpty(txtBienSo, sb, "Biển số không được bỏ trống");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }

        if (MessageDialogHelper.showConfirmDialog(parentForm, "Bạn có muốn xóa thông tin xe không?", "Hỏi") == JOptionPane.NO_OPTION) {
            return;
        }

        try {

            boolean KTBS = false;
            PhieuThueDao ptd = new PhieuThueDao();
            List<PhieuThue> lpt = ptd.findAll();
            for(PhieuThue pt : lpt){
                if(pt.getBienSo().trim().equalsIgnoreCase(txtBienSo.getText().trim())){
                    KTBS = true;
                    break;
                }
            }
            
            if(KTBS == true){
                MessageDialogHelper.showMessageDialog(parentForm, "Thông tin xe không được xóa do xe đang được thuê", "Cảnh báo");
                return;
            }else{
            
                ThongTinXeDao dao = new ThongTinXeDao();
                if (dao.delete(txtBienSo.getText())) {
                    MessageDialogHelper.showMessageDialog(parentForm, "Thông tin xe đã được xóa", "Thông báo");
                    btnResetActionPerformed(evt);
                    loadDataToTable();
                } else {
                    MessageDialogHelper.showConfirmDialog(parentForm, "Thông tin xe không được xóa do lỗi", "Cảnh báo");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblThongTinXeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinXeMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblThongTinXe.getSelectedRow();

            if (row >= 0) {
                String id = (String) tblThongTinXe.getValueAt(row, 0);
                ThongTinXeDao dao = new ThongTinXeDao();
                ThongTinXe ttx = dao.findById(id);

                if (ttx != null) {
                    txtBienSo.setText(ttx.getBienSo());
                    if(ttx.getMaXM() != null){
                        txtMaLoaiXe.setText(ttx.getMaXM());
                    }else if(ttx.getMaOT() != null){
                        txtMaLoaiXe.setText(ttx.getMaOT());
                    }else if(ttx.getMaXT() != null){
                        txtMaLoaiXe.setText(ttx.getMaXT());
                    }
                    txtNgayDangKy.setText(ttx.getNgayDangKy());
                    txtTinhTrang.setText(ttx.getTinhTrang());

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_tblThongTinXeMouseClicked

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        try
        {
            
            if(!"".equals(txtBienSoTK.getText().trim())){
                ThongTinXeDao dao = new ThongTinXeDao();
                ThongTinXe ttx = dao.findById(txtBienSoTK.getText());
                txtBienSo.setText(ttx.getBienSo());
                txtNgayDangKy.setText(ttx.getNgayDangKy());
                txtTinhTrang.setText(ttx.getTinhTrang());
                if( ttx.getMaXM()!=null){
                    txtMaLoaiXe.setText(ttx.getMaXM());
                }else if( ttx.getMaOT()!=null){
                    txtMaLoaiXe.setText(ttx.getMaOT());
                }else{
                    txtMaLoaiXe.setText(ttx.getMaXT());
                }
                loadDataToTableXeTim();
            }else{
                    MessageDialogHelper.showMessageDialog(parentForm,  "Vui lòng điền thông tin cần tìm!", "Thông báo !");
            }
            
         
        }
        catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm,e.getMessage(),"Lỗi!");
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        txtBienSo.setText("");
        txtMaLoaiXe.setText("");
        txtNgayDangKy.setText("");
        txtTinhTrang.setText("");
        txtBienSoTK.setText("");
        loadDataToTable();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        int index= MainForm.tblMainBoard.indexOfComponent(this);
        MainForm.tblMainBoard.removeTabAt(index);
    }//GEN-LAST:event_btnDongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblThongTinXe;
    private javax.swing.JTextField txtBienSo;
    private javax.swing.JTextField txtBienSoTK;
    private javax.swing.JTextField txtMaLoaiXe;
    private javax.swing.JTextField txtNgayDangKy;
    private javax.swing.JTextField txtTinhTrang;
    // End of variables declaration//GEN-END:variables
}
