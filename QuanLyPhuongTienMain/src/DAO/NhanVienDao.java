/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DATA.DatabaseHelper;
import DTO.NguoiDung;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author Admin
 */
public class NhanVienDao {

    public boolean insert(NguoiDung item) throws Exception {
        String sql = "INSERT INTO dbo.NguoiDung( MaND ,TenND  ,Tuoi ,SoDT ,GioiTinh ,DiaChi, ChucVu,UserName, UserPass, Hinh) "
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
            pre.setString(1, item.getMaND());
            pre.setString(2, item.getTenND());
            pre.setInt(3, item.getTuoi());
            pre.setString(4, item.getSoDT());
            pre.setInt(5, item.getGioiTinh());
            pre.setString(6, item.getDiaChi());
            pre.setString(7, item.getChucVu());
            pre.setString(8, item.getUserName());
            pre.setString(9, item.getUserPass());

            if (item.getHinh() != null) {
                Blob hinh = new SerialBlob(item.getHinh());
                pre.setBlob(10, hinh);
            } else {
                Blob hinh = null;
                pre.setBlob(10, hinh);
            }
            return pre.executeUpdate() > 0;
        }

    }

    public boolean update(NguoiDung item) throws Exception {
        String sql = "UPDATE dbo.NguoiDung "
                + " SET TenND =? ,Tuoi =?,SoDT =? ,GioiTinh =?,DiaChi=? ,ChucVu=? ,UserName=?, UserPass=?, Hinh=? "
                + " WHERE MaND = ?";
        try (Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
            pre.setString(1, item.getTenND());
            pre.setInt(2, item.getTuoi());
            pre.setString(3, item.getSoDT());
            pre.setInt(4, item.getGioiTinh());
            pre.setString(5, item.getDiaChi());
            pre.setString(6, item.getChucVu());
            pre.setString(7, item.getUserName());
            pre.setString(8, item.getUserPass());
            if (item.getHinh() != null) {
                Blob hinh = new SerialBlob(item.getHinh());
                pre.setBlob(9, hinh);
            } else {
                Blob hinh = null;
                pre.setBlob(9, hinh);
            }
            pre.setString(10, item.getMaND());
            
            return pre.executeUpdate() > 0;
        }

    }

    public boolean delete(String MaND) throws Exception {
        String sql = "DELETE FROM NguoiDung WHERE MaND = ?";
        try (Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, MaND);

            return pstmt.executeUpdate() > 0;
        }
    }

    public NguoiDung findDung(String MaND) throws Exception {
        String sql = "SELECT * FROM  NguoiDung WHERE MaND = ? ";
        try (Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, MaND);
            try (ResultSet rs = pstmt.executeQuery();) {

                if (rs.next()) {
                    NguoiDung nd = TimKiem(rs);
                    return nd;
                }
            }
            return null;
        }
    }
    public  NguoiDung  findByID( String MaND) throws Exception
    {
        String sql = "SELECT  * FROM NguoiDung "
                + " WHERE MaND = ? ";
        try( Connection con = DatabaseHelper.openConnection();
             PreparedStatement pre = con.prepareStatement(sql);)  
        {
            pre.setString(1,MaND);
            try(ResultSet rs = pre.executeQuery(); )
            { 
               
                if(rs.next())
                {
                   NguoiDung kh = TimKiem(rs);
                    return  kh;
                }
            }
        return null;
        }
    }

    public List<NguoiDung> findAll() throws Exception {
        String sql = "SELECT *  FROM NguoiDung ";
        try (Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            try (ResultSet rs = pstmt.executeQuery();) {
                List<NguoiDung> list = new ArrayList<>();
                while (rs.next()) {
                    NguoiDung nd = TimKiem(rs);
                    list.add(nd);
                }
                return list;
            }
        }

    }

    private NguoiDung TimKiem(final ResultSet rs) throws SQLException {
        NguoiDung nd = new NguoiDung();
        nd.setMaND(rs.getString("MaND"));
        nd.setTenND(rs.getString("TenND"));
        nd.setTuoi(rs.getInt("Tuoi"));
        nd.setSoDT(rs.getString("SoDT"));
        nd.setGioiTinh(rs.getInt("GioiTinh"));
        nd.setDiaChi(rs.getString("DiaChi"));
        nd.setChucVu(rs.getString("ChucVu"));
        nd.setUserName(rs.getString("UserName"));
        nd.setUserPass(rs.getString("UserPass"));
        Blob blob = rs.getBlob("Hinh");
        if (blob != null) {
            nd.setHinh(blob.getBytes(1, (int) blob.length()));
        }
        return nd;
    }
}
