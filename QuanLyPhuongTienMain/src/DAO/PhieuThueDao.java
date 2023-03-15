/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DATA.DatabaseHelper;
import DTO.KhachHang;
import DTO.PhieuThue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class PhieuThueDao {
    public boolean insert(PhieuThue item) throws Exception {
        String sql = "INSERT INTO [dbo].[PhieuThue]([MaPT], [NgayThue], [MaKH], [MaND], [SoNgayThue], [BienSo], [DonGiaNgay])"
                + " values(?, ?, ?, ?, ?, ?, ?)";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
                pre.setString(1, item.getMaPT());
                pre.setString(2, item.getNgayThang());
                pre.setString(3, item.getMaKH());
                pre.setString(4, item.getMaNV());
                pre.setInt(5, item.getSoNgayThue());
                pre.setString(6, item.getBienSo());
                pre.setFloat(7, item.getDonGiaNgay());
                return pre.executeUpdate() > 0;
        }
    }

    public boolean update(PhieuThue item) throws Exception {
        String sql = "UPDATE dbo.PhieuThue"
                + " SET SoNgayThue=?, DonGiaNgay=?"
                + " WHERE MaPT=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
            
                
                pre.setInt(1, item.getSoNgayThue());
                pre.setFloat(2, item.getDonGiaNgay());
                pre.setString(3, item.getMaPT());
            return pre.executeUpdate() > 0;
        }
    }

    public boolean delete(String MaPT) throws Exception {
        String sql = "DELETE FROM PhieuThue"
                + " WHERE MaPT=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            pre.setString(1, MaPT);

            return pre.executeUpdate() > 0;
        }
    }

    public PhieuThue findById(String MaPT) throws Exception {
        String sql = "SELECT * FROM PhieuThue"
                + " WHERE MaPT=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            pre.setString(1, MaPT);
            try (ResultSet rs = pre.executeQuery();) {
                if (rs.next()) {
                    PhieuThue pt = new PhieuThue();
                    pt.setMaPT(rs.getString("MaPT"));
                    pt.setNgayThang(rs.getString("NgayThue"));
                    pt.setMaKH(rs.getString("MaKH"));
                    pt.setMaNV(rs.getString("MaND"));
                    pt.setSoNgayThue(rs.getInt("SoNgayThue"));
                    pt.setBienSo(rs.getString("BienSo"));
                    pt.setDonGiaNgay(rs.getFloat("DonGiaNgay"));
                    return pt;
                }
            }
            return null;
        }
    }

    public List<PhieuThue> findByKh(String MaKH, String NgayThue) throws Exception {
        String sql = "SELECT * FROM PhieuThue"
                + " WHERE MaKH=? AND NgayThue=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            pre.setString(1, MaKH);
            pre.setString(2, NgayThue);
            try (ResultSet rs = pre.executeQuery();) {
                List<PhieuThue> list = new ArrayList<>();
                while (rs.next()) {
                    PhieuThue pt = new PhieuThue();
                    pt.setMaPT(rs.getString("MaPT"));
                    pt.setNgayThang(rs.getString("NgayThue"));
                    pt.setMaKH(rs.getString("MaKH"));
                    pt.setMaNV(rs.getString("MaND"));
                    pt.setSoNgayThue(rs.getInt("SoNgayThue"));
                    pt.setBienSo(rs.getString("BienSo"));
                    pt.setDonGiaNgay(rs.getFloat("DonGiaNgay"));
                    
                    list.add(pt);
                }
                return list;
            }
        }
    }
    public List<PhieuThue> findAll() throws Exception {
        String sql = "SELECT * FROM PhieuThue";
                
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            try (ResultSet rs = pre.executeQuery();) {
                List<PhieuThue> list = new ArrayList<>();
                while (rs.next()) {
                    PhieuThue pt = new PhieuThue();
                    pt.setMaPT(rs.getString("MaPT"));
                    pt.setNgayThang(rs.getString("NgayThue"));
                    pt.setMaKH(rs.getString("MaKH"));
                    pt.setMaNV(rs.getString("MaND"));
                    pt.setSoNgayThue(rs.getInt("SoNgayThue"));
                    pt.setBienSo(rs.getString("BienSo"));
                    pt.setDonGiaNgay(rs.getFloat("DonGiaNgay"));
                    
                    list.add(pt);
                }
                return list;
            }
        }
    }
}
