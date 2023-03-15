
package DAO;

import DATA.DatabaseHelper;
import DTO.PhieuPhat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhieuPhatDao {
     public boolean insert(PhieuPhat item) throws Exception {
        String sql = "INSERT INTO [dbo].[PhieuPhat]([MaPP] , [MaPT], [NgayPhat], [NoiDungPhat],  [MaKH], [MaND], [TienPhat])"
                + " values(?, ?, ?, ?, ?, ?, ?)";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
                pre.setString(1, item.getMaPP());
                pre.setString(2, item.getMaPT());
                pre.setString(3, item.getNgayPhat());
                pre.setString(4, item.getNoiDungPhat());
                pre.setString(5, item.getMaKH());
                pre.setString(6, item.getMaNV());
                pre.setFloat(7, item.getTienPhat());
                return pre.executeUpdate() > 0;
        }
    }

    public boolean update(PhieuPhat item) throws Exception {
        String sql = "UPDATE dbo.PhieuPhat"
                + " SET NoiDungPhat=?, TienPhat=?"
                + " WHERE MaPP=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
            
                
                pre.setString(1, item.getNoiDungPhat());
                pre.setFloat(2, item.getTienPhat());
                pre.setString(3, item.getMaPP());
            return pre.executeUpdate() > 0;
        }
    }

    public boolean delete(String MaPP) throws Exception {
        String sql = "DELETE FROM dbo.PhieuPhat"
                + " WHERE MaPP=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            pre.setString(1, MaPP);

            return pre.executeUpdate() > 0;
        }
    }

    public PhieuPhat findById(String MaPP) throws Exception {
        String sql = "SELECT * FROM PhieuPhat"
                + " WHERE MaPP=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            pre.setString(1, MaPP);
            try (ResultSet rs = pre.executeQuery();) {
                if (rs.next()) {
                    PhieuPhat pp = new PhieuPhat();
                    pp.setMaPP(rs.getString("MaPP"));
                    pp.setMaPT(rs.getString("MaPT"));
                    pp.setNgayPhat(rs.getString("NgayPhat"));
                    pp.setNoiDungPhat(rs.getString("NoiDungPhat"));
                    pp.setMaKH(rs.getString("MaKH"));
                    pp.setMaNV(rs.getString("MaND"));
                    pp.setTienPhat(rs.getFloat("TienPhat"));
                    
                    return pp;
                }
            }
            return null;
        }
    }
    
    public List<PhieuPhat> findAll() throws Exception {
        String sql = "SELECT * FROM PhieuPhat";
                
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            try (ResultSet rs = pre.executeQuery();) {
                List<PhieuPhat> list = new ArrayList<>();
                while (rs.next()) {
                    PhieuPhat pp = new PhieuPhat();
                    pp.setMaPP(rs.getString("MaPP"));
                    pp.setMaPT(rs.getString("MaPT"));
                   
                    pp.setNgayPhat(rs.getString("NgayPhat"));
                    pp.setNoiDungPhat(rs.getString("NoiDungPhat"));
                    pp.setMaKH(rs.getString("MaKH"));
                    pp.setMaNV(rs.getString("MaND"));
                    pp.setTienPhat(rs.getFloat("TienPhat"));
                    
                    list.add(pp);
                }
                return list;
            }
        }
    }
}
