/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import DAO.KhachHangDao;
import DAO.NguoiDungDao;
import DAO.NhanVienDao;
import DATA.DataValidator;
import DATA.MessageDialogHelper;
import DAO.PhieuThueDao;
import DAO.ThongTinXeDao;
import DTO.KhachHang;
import DTO.NguoiDung;
import DTO.PhieuThue;
import DTO.ThongTinXe;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyPhieuThue extends javax.swing.JPanel {

    private MainForm parentForm;
    private DefaultTableModel tblModel;
    /**
     * Creates new form PhieuThue
     */
    public QuanLyPhieuThue() {
        initComponents();
        initTable();
        loadDataToTable();
        txtTongTien.setEnabled(false);
        
    }

    public void initTable() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Mã phiếu thuê", "Ngày lập", "Ma khách hàng", "Ma nhân viên", "Biển số xe thuê", "Số ngày thuê", "Đơn giá ngày", "Tổng tiền"});
        tblPhieuThue.setModel(tblModel);
    }
    
    private void loadDataToTable() {
        try {
            PhieuThueDao dao = new PhieuThueDao();
            List<PhieuThue> list = dao.findAll();
            tblModel.setRowCount(0);
            for (PhieuThue phieuThue : list) {
                tblModel.addRow(new Object[]{
                    phieuThue.getMaPT(), phieuThue.getNgayThang(), phieuThue.getMaKH(), phieuThue.getMaNV(),phieuThue.getBienSo(), phieuThue.getSoNgayThue(), phieuThue.getDonGiaNgay(), phieuThue.getTongTien()
                });
              
            }
           
            
            tblModel.fireTableDataChanged();

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
    private  void LoadDataTableByID()
    {
       try
       {
           PhieuThueDao dao = new PhieuThueDao();
           PhieuThue phieuThue =dao.findById(txtMaPhieu.getText());  
           tblModel.setRowCount(0);
          
            tblModel.addRow(new Object[]{
                    phieuThue.getMaPT(), phieuThue.getNgayThang(), phieuThue.getMaKH(), phieuThue.getMaNV(),phieuThue.getBienSo(), phieuThue.getSoNgayThue(), phieuThue.getDonGiaNgay(), phieuThue.getTongTien()
                });
          
          tblModel.fireTableDataChanged();                          
       }
       catch ( Exception e)     
       {
           e.printStackTrace();
           MessageDialogHelper.showErrorDialog(parentForm,e.getMessage(),"Lỗi!");
       }     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnLapPhieu = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtMaPhieu = new javax.swing.JTextField();
        txtNgayThang = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtSoNgayThue = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuThue = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        btnXuatPhieu = new javax.swing.JButton();
        txtDonGiaNgay = new javax.swing.JTextField();
        DonGiaNgay = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtBienSo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnTim = new javax.swing.JButton();
        txtMaPhieuTK = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Quản Lý Phiếu Thuê");

        jLabel2.setText("Mã Phiếu:");

        jLabel3.setText("Ngày Lập:");

        jLabel4.setText("Mã Nhân Viên:");

        jLabel5.setText("Số Ngày Thuê:");

        jLabel6.setText("Mã Khách Hàng:");

        btnLapPhieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Add-24.png"))); // NOI18N
        btnLapPhieu.setText("Lập Phiếu");
        btnLapPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapPhieuActionPerformed(evt);
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

        tblPhieuThue.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPhieuThue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuThueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuThue);

        btnXuatPhieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Enter-24.png"))); // NOI18N
        btnXuatPhieu.setText("Xuất Phiếu");
        btnXuatPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatPhieuActionPerformed(evt);
            }
        });

        DonGiaNgay.setText("Đơn Giá Ngày: ");

        jLabel8.setText("Tổng tiền: ");

        jLabel7.setText("Biển Số: ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Search-24.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel9.setText("Nhập mã phiểu tìm kiếm:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaPhieuTK, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnTim)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtMaPhieuTK))
                    .addComponent(btnTim))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel7)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBienSo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNgayThang, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel5))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtSoNgayThue)
                                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(DonGiaNgay)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtDonGiaNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(64, 64, 64))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnLapPhieu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSua)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnXoa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnReset)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnXuatPhieu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDong))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNgayThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSoNgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DonGiaNgay)
                            .addComponent(txtDonGiaNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBienSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLapPhieu)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnXuatPhieu)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuatPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatPhieuActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validdateEmpty(txtMaPhieu, sb, "Mã phiếu không được để trống");
        
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }
        
        try {
            
            PhieuThueDao dao = new PhieuThueDao();
            List<PhieuThue> list = dao.findByKh(txtMaKH.getText().trim(), txtNgayThang.getText().trim());
            
            new PhieuThueView(list).setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnXuatPhieuActionPerformed

    private void tblPhieuThueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuThueMouseClicked
        try {
            int row = tblPhieuThue.getSelectedRow();

            if (row >= 0) {
                String id = (String) tblPhieuThue.getValueAt(row, 0);
                PhieuThueDao dao = new PhieuThueDao();
                PhieuThue pt = dao.findById(id);

                if (pt != null) {
                    txtMaPhieu.setText(pt.getMaPT());
                    txtNgayThang.setText(pt.getNgayThang());
                    txtMaKH.setText(pt.getMaKH());
                    txtMaNV.setText(pt.getMaNV());
                    txtSoNgayThue.setText(""+pt.getSoNgayThue());
                    txtBienSo.setText(pt.getBienSo());
                    txtDonGiaNgay.setText(""+pt.getDonGiaNgay());
                    txtTongTien.setText(""+pt.getTongTien());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_tblPhieuThueMouseClicked

    private void btnLapPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapPhieuActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validdateEmpty(txtMaPhieu, sb, "Mã phiếu không được để trống");
        DataValidator.validdateEmpty(txtNgayThang, sb, "Ngày lập không được bỏ trống");
        DataValidator.validdateEmpty(txtMaKH, sb, "Mã khách hàng không được bỏ trống");
        DataValidator.validdateEmpty(txtMaNV, sb, "Mã nhân viên không được bỏ trống");
        DataValidator.validdateEmpty(txtSoNgayThue, sb, "Số ngày thuê không được bỏ trống");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }
        
        try {
            boolean KTPT = false;
            boolean KTBS = false;
            boolean KTNV = false;
            boolean KTKH = false;
            PhieuThueDao dao = new PhieuThueDao();
            List<PhieuThue> list = dao.findAll();
            for (PhieuThue phieuThue : list) {
                if(phieuThue.getMaPT().trim().equalsIgnoreCase(txtMaPhieu.getText().trim())){
                    KTPT = true;
                }
                if(phieuThue.getBienSo().trim().equalsIgnoreCase(txtBienSo.getText().trim())){
                    MessageDialogHelper.showMessageDialog(parentForm, "Phiếu thuê không được lưu do xe đã được thuê", "Cảnh báo");
                    return;
                }
            }
            
            
            ThongTinXeDao ttxd = new ThongTinXeDao();
            List<ThongTinXe> ttx= ttxd.findAll();
            for(ThongTinXe thongtinxe : ttx){
                if(thongtinxe.getBienSo().trim().equalsIgnoreCase(txtBienSo.getText().trim())){
                    KTBS = true;
                }
            }
            KhachHangDao khd = new KhachHangDao();
            List<KhachHang> kh= khd.findAll();
            for(KhachHang khachhang : kh){
                if(khachhang.getMaKH().trim().equalsIgnoreCase(txtMaKH.getText().trim())){
                    KTKH = true;
                }
            }
            NhanVienDao nvd = new NhanVienDao();
            List<NguoiDung> nd= nvd.findAll();
            for(NguoiDung nguoidung : nd){
                if(nguoidung.getMaND().trim().equalsIgnoreCase(txtMaNV.getText().trim())){
                    KTNV = true;
                }
            }
            if(KTPT == false){
                if(KTBS == true){
                    if(KTKH == true){
                        if(KTNV == true){
                            PhieuThue pt = new PhieuThue();
                            pt.setMaPT(txtMaPhieu.getText().trim());
                            pt.setNgayThang(txtNgayThang.getText());
                            pt.setMaKH(txtMaKH.getText());
                            pt.setMaNV(txtMaNV.getText());
                            pt.setSoNgayThue(Integer.parseInt(txtSoNgayThue.getText()));
                            pt.setBienSo(txtBienSo.getText());
                            pt.setDonGiaNgay(Float.parseFloat(txtDonGiaNgay.getText()));
                            

                            if (dao.insert(pt)) {
                                MessageDialogHelper.showMessageDialog(parentForm, "Phiếu thuê đã được lưu", "Thông báo");
                                btnResetActionPerformed(evt);
                                loadDataToTable();
                            } else {
                                MessageDialogHelper.showConfirmDialog(parentForm, "Phiếu thuê không được lưu do lỗi", "Cảnh báo");
                            }
                        }else{
                            MessageDialogHelper.showMessageDialog(parentForm, "Nhân viên không tồn tại", "Cảnh báo");
                            return;
                        }
                    }else{
                        MessageDialogHelper.showMessageDialog(parentForm, "Khách hàng không tồn tại", "Cảnh báo");
                        return;
                    }
                }else{
                    MessageDialogHelper.showMessageDialog(parentForm, "Biển số không tồn tại", "Cảnh báo");
                    return;
                }
            }else{
                MessageDialogHelper.showMessageDialog(parentForm, "Phiếu thuê đã tồn tại", "Cảnh báo");
                return;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnLapPhieuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validdateEmpty(txtMaPhieu, sb, "Mã phiếu không được để trống");
        DataValidator.validdateEmpty(txtSoNgayThue, sb, "Số ngày thuê không được bỏ trống");
        DataValidator.validdateEmpty(txtDonGiaNgay, sb, "Đơn giá ngày không được bỏ trống");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        } 

        if (MessageDialogHelper.showConfirmDialog(parentForm, "Bạn có muốn cập nhật phiếu thuê không?", "Hỏi") == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            PhieuThue pt = new PhieuThue();
            pt.setMaPT(txtMaPhieu.getText());
            pt.setSoNgayThue(Integer.parseInt(txtSoNgayThue.getText()));
            pt.setDonGiaNgay(Float.parseFloat(txtDonGiaNgay.getText()));

           PhieuThueDao dao = new PhieuThueDao();
            if (dao.update(pt)) {
                MessageDialogHelper.showMessageDialog(parentForm, "Phiếu thuê đã được cập nhật", "Thông báo");
                btnResetActionPerformed(evt);
                loadDataToTable();
            } else {
                MessageDialogHelper.showConfirmDialog(parentForm, "Phiếu thuê không được lưu do lỗi", "Cảnh báo");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validdateEmpty(txtMaPhieu, sb, "Mã phiếu không được để trống");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }

        if (MessageDialogHelper.showConfirmDialog(parentForm, "Bạn có muốn xóa thông tin phiếu thuê không?", "Hỏi") == JOptionPane.NO_OPTION) {
            return;
        }

        try {

            PhieuThueDao dao = new PhieuThueDao();
            if (dao.delete(txtMaPhieu.getText())) {
                MessageDialogHelper.showMessageDialog(parentForm, "Phiếu thuê đã được xóa", "Thông báo");
                btnResetActionPerformed(evt);
                loadDataToTable();
            } else {
                MessageDialogHelper.showConfirmDialog(parentForm, "Phiếu thuê không được xóa do lỗi", "Cảnh báo");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        try
        {
            PhieuThueDao dao = new PhieuThueDao();
            PhieuThue pt = dao.findById(txtMaPhieuTK.getText().trim());
            if(pt !=null)
            {
                txtMaPhieu.setText(pt.getMaPT());
                txtNgayThang.setText(pt.getNgayThang());
                txtMaKH.setText(pt.getMaKH());
                txtMaNV.setText(pt.getMaNV());
                txtSoNgayThue.setText(""+pt.getSoNgayThue());
                txtBienSo.setText(pt.getBienSo());
                txtDonGiaNgay.setText(""+pt.getDonGiaNgay());
                txtTongTien.setText(""+pt.getTongTien()); 
                LoadDataTableByID();
                
            }
            else
            {
                MessageDialogHelper.showMessageDialog(parentForm,  "Không tim thấy khách hàng cần tìm!", "Thông báo !");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm,e.getMessage(),"Lỗi!");
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        txtMaPhieu.setText("");
        txtNgayThang.setText("");
        txtMaKH.setText("");
        txtMaNV.setText("");
        txtSoNgayThue.setText("");
        txtBienSo.setText("");
        txtDonGiaNgay.setText("");
        txtTongTien.setText(""); 
        loadDataToTable();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        int index= MainForm.tblMainBoard.indexOfComponent(this);
        MainForm.tblMainBoard.removeTabAt(index);
    }//GEN-LAST:event_btnDongActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DonGiaNgay;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnLapPhieu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatPhieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblPhieuThue;
    private javax.swing.JTextField txtBienSo;
    private javax.swing.JTextField txtDonGiaNgay;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPhieu;
    private javax.swing.JTextField txtMaPhieuTK;
    private javax.swing.JTextField txtNgayThang;
    private javax.swing.JTextField txtSoNgayThue;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
