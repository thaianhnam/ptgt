/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import DAO.NhanVienDao;
import DATA.DataValidator;
import DATA.MessageDialogHelper;
import DAO.PhieuPhatDao;
import DAO.PhieuThueDao;
import DTO.NguoiDung;
import DTO.PhieuPhat;
import DTO.PhieuThue;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Admin
 */
public class QuanLyPhieuPhat extends javax.swing.JPanel {

    private MainForm parentForm;
    private DefaultTableModel tblModel;
    /**
     * Creates new form PhieuPhat
     */
    public QuanLyPhieuPhat() {
        initComponents();
        initTable();
        loadDataToTable();
    }

    public void initTable() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Ma phiếu phạt" , "Mã phiếu thuê", "Ngày phạt", "Nội dung phạt",  "Mã khách hàng", "Mã nhân viên", "Tiền phạt"});
        tblPhieuPhat.setModel(tblModel);
    }
    
    private void loadDataToTable() {
        try {
            PhieuPhatDao dao = new PhieuPhatDao();
            List<PhieuPhat> list = dao.findAll();
            tblModel.setRowCount(0);
            for (PhieuPhat phieuPhat : list) {
                tblModel.addRow(new Object[]{
                    phieuPhat.getMaPP(), phieuPhat.getMaPT(), phieuPhat.getNgayPhat(), phieuPhat.getNoiDungPhat(), phieuPhat.getMaKH(), phieuPhat.getMaNV(), phieuPhat.getTienPhat()
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
           PhieuPhatDao dao = new PhieuPhatDao();
           PhieuPhat phieuPhat =dao.findById(txtMaPhieuPhat.getText());  
           tblModel.setRowCount(0);
          
            tblModel.addRow(new Object[]{
                    phieuPhat.getMaPP(), phieuPhat.getMaPT(), phieuPhat.getNgayPhat(), phieuPhat.getNoiDungPhat(), phieuPhat.getMaKH(), phieuPhat.getMaNV(), phieuPhat.getTienPhat()
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

        quanLyPhieuThue1 = new GUI.QuanLyPhieuThue();
        quanLyPhieuThue2 = new GUI.QuanLyPhieuThue();
        txtTienPhat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuPhat = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnLapPhieu = new javax.swing.JButton();
        btnXuatPhieu = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMaPhieuPhat = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtNgayLap = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNoiDung = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnTim = new javax.swing.JButton();
        txtMaPhieuTK = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel5.setText("Số Tiền Phạt:");

        tblPhieuPhat.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPhieuPhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuPhatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuPhat);

        jLabel6.setText("Mã Khách Hàng:");

        btnLapPhieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Add-24.png"))); // NOI18N
        btnLapPhieu.setText("Lập Phiếu");
        btnLapPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapPhieuActionPerformed(evt);
            }
        });

        btnXuatPhieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Enter-24.png"))); // NOI18N
        btnXuatPhieu.setText("Xuất Phiếu");
        btnXuatPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatPhieuActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Quản Lý Phiếu Phạt");

        jLabel2.setText("Mã Phiếu Phạt:");

        jLabel3.setText("Ngày Lập:");

        jLabel4.setText("Mã Nhân Viên:");

        jLabel7.setText("Mã Phiếu Thuê:");

        jLabel8.setText("Nội Dung: ");

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reset.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

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
                .addGap(31, 31, 31)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txtMaPhieuTK, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnTim)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTim)
                    .addComponent(jLabel9)
                    .addComponent(txtMaPhieuTK))
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Cancel-24.png"))); // NOI18N
        jButton1.setText("Đóng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(32, 32, 32)
                                            .addComponent(txtNoiDung))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel7))
                                            .addGap(10, 10, 10)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtMaPhieuPhat)
                                                .addComponent(txtNgayLap)
                                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(36, 36, 36)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel5))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtMaKH, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtTienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnLapPhieu)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXuatPhieu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1332, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaPhieuPhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLapPhieu)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnXuatPhieu)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblPhieuPhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuPhatMouseClicked
        try {
            int row = tblPhieuPhat.getSelectedRow();

            if (row >= 0) {
                String id = (String) tblPhieuPhat.getValueAt(row, 0);
                PhieuPhatDao dao = new PhieuPhatDao();
                PhieuPhat pt = dao.findById(id);

                if (pt != null) {
                    txtMaPhieuPhat.setText(pt.getMaPP());
                    txtMaHD.setText(pt.getMaPT());
                    txtNgayLap.setText(pt.getNgayPhat());
                    txtMaKH.setText(pt.getMaKH());
                    txtMaNV.setText(pt.getMaNV());
                    txtNoiDung.setText(pt.getNoiDungPhat());
                    txtTienPhat.setText(""+pt.getTienPhat());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_tblPhieuPhatMouseClicked

    private void btnLapPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapPhieuActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validdateEmpty(txtMaPhieuPhat, sb, "Mã phiếu không được để trống");
        DataValidator.validdateEmpty(txtNgayLap, sb, "Ngày lập không được bỏ trống");
        DataValidator.validdateEmpty(txtMaKH, sb, "Mã khách hàng không được bỏ trống");
        DataValidator.validdateEmpty(txtMaNV, sb, "Mã nhân viên không được bỏ trống");
        DataValidator.validdateEmpty(txtTienPhat, sb, "Tiền phạt không được bỏ trống");
        DataValidator.validdateEmpty(txtMaHD, sb, "Mã hợp đồng không được bỏ trống");
        DataValidator.validdateEmpty(txtNoiDung, sb, "Nội dung không được bỏ trống");
        
        try {
            boolean KTKH = false;
            boolean KTNV = false;
            boolean KTPT = false;
            boolean KTPP = false;
            boolean checkPT = false;
            PhieuThueDao ptd = new PhieuThueDao();
            List<PhieuThue> lpt = ptd.findAll();
            for(PhieuThue pt : lpt){
                if(pt.getMaPT().trim().equalsIgnoreCase(txtMaHD.getText().trim())){
                    KTPT = true;
                    if(pt.getMaNV().trim().equalsIgnoreCase(txtMaNV.getText().trim())){
                        KTNV = true;  
                    }
                    if(pt.getMaKH().trim().equalsIgnoreCase(txtMaKH.getText().trim())){
                        KTKH = true;
                    }
                }
            }
            PhieuPhatDao dao = new PhieuPhatDao();
            List<PhieuPhat> lpp= dao.findAll();
            for(PhieuPhat pp : lpp){
                if(pp.getMaPP().trim().equalsIgnoreCase(txtMaPhieuPhat.getText().trim())){
                    KTPP = true;
                    
                }
                if(pp.getMaPT().trim().equalsIgnoreCase(txtMaHD.getText().trim())){
                    checkPT = true;
                }
            }
            if(KTPP == false){
                if(checkPT == false){
                    if(KTPT == true){
                        if(KTNV == true ){
                            if(KTKH == true){

                                PhieuPhat pp = new PhieuPhat();
                                pp.setMaPP(txtMaPhieuPhat.getText().trim());
                                pp.setNgayPhat(txtNgayLap.getText());
                                pp.setMaPT(txtMaHD.getText());
                                pp.setMaKH(txtMaKH.getText());
                                pp.setMaNV(txtMaNV.getText());
                                pp.setNoiDungPhat(txtNoiDung.getText());
                                pp.setTienPhat(Float.parseFloat(txtTienPhat.getText()));

                                if (dao.insert(pp)) {
                                    MessageDialogHelper.showMessageDialog(parentForm, "Phiếu phạt đã được tạo", "Thông báo");
                                    btnResetActionPerformed(evt);
                                    loadDataToTable();
                                } else {
                                    MessageDialogHelper.showConfirmDialog(parentForm, "Phiếu phạt không được lưu do lỗi", "Cảnh báo");
                                }

                            }else{
                                MessageDialogHelper.showMessageDialog(parentForm, "Vui lòng nhập đúng mã khách hàng trong phiếu thuê ", "Cảnh báo");
                                return;
                            }   
                        }else{
                            MessageDialogHelper.showMessageDialog(parentForm, "Vui lòng nhập đúng mã nhân viên trong phiếu thuê", "Cảnh báo");
                            return;
                        }
                    }else{
                        MessageDialogHelper.showMessageDialog(parentForm, "Mã phiếu thuê không tồn tại", "Cảnh báo");
                        return;
                    }
                }else{
                    MessageDialogHelper.showMessageDialog(parentForm, "Mã phiếu thuê đã tồn tại", "Cảnh báo");
                        return;
                }
            }else{
                MessageDialogHelper.showMessageDialog(parentForm, "Phiếu phạt này đã tồn tại", "Cảnh báo");
                return;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnLapPhieuActionPerformed

    private void btnXuatPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatPhieuActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validdateEmpty(txtMaPhieuPhat, sb, "Mã phiếu phạt không được để trống");
        
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }
        
        try {
            
            PhieuPhatDao dao = new PhieuPhatDao();
            PhieuPhat pp = dao.findById(txtMaPhieuPhat.getText());
            new PhieuPhatView(pp).setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnXuatPhieuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validdateEmpty(txtMaPhieuPhat, sb, "Mã phiếu phạt không được để trống");
        DataValidator.validdateEmpty(txtNoiDung, sb, "Nội dung không được để trống");
        DataValidator.validdateEmpty(txtTienPhat, sb, "Tiền phạt không được bỏ trống");

        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }

        if (MessageDialogHelper.showConfirmDialog(parentForm, "Bạn có muốn cập nhật phiếu phạt không?", "Hỏi") == JOptionPane.NO_OPTION) {
            
        }

        try {
            PhieuPhat pt = new PhieuPhat();
            pt.setMaPP(txtMaPhieuPhat.getText());
            pt.setNgayPhat(txtNgayLap.getText());
            pt.setMaPT(txtMaHD.getText());
            pt.setMaKH(txtMaKH.getText());
            pt.setMaNV(txtMaNV.getText());
            pt.setNoiDungPhat(txtNoiDung.getText());
            pt.setTienPhat(Float.parseFloat(txtTienPhat.getText()));

            PhieuPhatDao dao = new PhieuPhatDao();
            if (dao.update(pt)) {
                MessageDialogHelper.showMessageDialog(parentForm, "Phiếu phạt đã được lưu", "Thông báo");
                btnResetActionPerformed(evt);
                loadDataToTable();
            } else {
                MessageDialogHelper.showConfirmDialog(parentForm, "Phiếu phạt không được lưu do lỗi", "Cảnh báo");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validdateEmpty(txtMaPhieuPhat, sb, "Mã phiếu không được để trống");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }
        
        if (MessageDialogHelper.showConfirmDialog(parentForm, "Bạn có muốn xóa phiếu phạt không?", "Hỏi") == JOptionPane.NO_OPTION) {
            return;
        }

        try {

            PhieuPhatDao dao = new PhieuPhatDao();
            if (dao.delete(txtMaPhieuPhat.getText())) {
                MessageDialogHelper.showMessageDialog(parentForm, "Phiếu phạt đã được xóa", "Thông báo");
                btnResetActionPerformed(evt);
                loadDataToTable();
            } else {
                MessageDialogHelper.showConfirmDialog(parentForm, "Phiếu phạt không được xóa do lỗi", "Cảnh báo");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        try
        {
            PhieuPhatDao dao = new PhieuPhatDao();
            PhieuPhat pt = dao.findById(txtMaPhieuTK.getText().trim());
            if(pt !=null)
            {
                txtMaPhieuPhat.setText(pt.getMaPP());
                txtMaHD.setText(pt.getMaPT());
                txtNgayLap.setText(pt.getNgayPhat());
                txtMaKH.setText(pt.getMaKH());
                txtMaNV.setText(pt.getMaNV());
                txtNoiDung.setText(pt.getNoiDungPhat());
                txtTienPhat.setText(""+pt.getTienPhat());

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

        txtMaPhieuPhat.setText("");
        txtMaHD.setText("");
        txtNgayLap.setText("");
        txtMaKH.setText("");
        txtMaNV.setText("");
        txtNoiDung.setText("");
        txtTienPhat.setText("");
        txtMaPhieuTK.setText("");
        loadDataToTable();
    }//GEN-LAST:event_btnResetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index= MainForm.tblMainBoard.indexOfComponent(this);
        MainForm.tblMainBoard.removeTabAt(index);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLapPhieu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatPhieu;
    private javax.swing.JButton jButton1;
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
    private GUI.QuanLyPhieuThue quanLyPhieuThue1;
    private GUI.QuanLyPhieuThue quanLyPhieuThue2;
    private javax.swing.JTable tblPhieuPhat;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPhieuPhat;
    private javax.swing.JTextField txtMaPhieuTK;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtNoiDung;
    private javax.swing.JTextField txtTienPhat;
    // End of variables declaration//GEN-END:variables
}
