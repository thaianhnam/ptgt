/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DATA.DatabaseHelper;
import DTO.OTo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OToDao {

    public boolean insert(OTo item) throws Exception {
        String sql = "INSERT INTO [dbo].[OTo]([MaOT],[TenXe],[HangSanXuat], [NamSanXuat], [GiaBan], [MauSon], [KieuDongCo], [SoChoNgoi])"
                + " values(?, ?, ?, ?, ?, ?, ?, ?)";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
            pre.setString(1, item.getMaOT());
            pre.setString(2, item.getTenXe());
            pre.setString(3, item.getHangSanXuat());
            pre.setString(4, item.getNamSanXuat());
            pre.setString(5, item.getGiaBan());
            pre.setString(6, item.getMauSon());
            pre.setString(7, item.getKieuDongCo());
            pre.setFloat(8, item.getSoChoNgoi());
           

            return pre.executeUpdate() > 0;
        }
    }

    public boolean update(OTo item) throws Exception {
        String sql = "UPDATE dbo.OTo"
                + " SET TenXe=?, HangSanXuat=?, NamSanXuat=?, GiaBan=?, MauSon=?, KieuDongCo=?, SoChoNgoi=?"
                + " WHERE MaOT=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
                pre.setString(1, item.getTenXe());
                pre.setString(2, item.getHangSanXuat());
                pre.setString(3, item.getNamSanXuat());
                pre.setString(4, item.getGiaBan());
                pre.setString(5, item.getMauSon());
                pre.setString(6, item.getKieuDongCo());
                pre.setFloat(7, item.getSoChoNgoi());
                pre.setString(8, item.getMaOT());

            return pre.executeUpdate() > 0;
        }
    }

    public boolean delete(String MaOT) throws Exception {
        String sql = "DELETE FROM OTo"
                + " WHERE MaOT=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            pre.setString(1, MaOT);

            return pre.executeUpdate() > 0;
        }
    }

    public OTo findById(String MaOT) throws Exception {
        String sql = "SELECT * FROM OTo"
                + " WHERE MaOT=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            pre.setString(1, MaOT);
            try (ResultSet rs = pre.executeQuery();) {
                if (rs.next()) {
                    OTo lx = new OTo();
                    lx.setMaOT(rs.getString("MaOT"));
                    
                    lx.setTenXe(rs.getString("TenXe"));
                    lx.setHangSanXuat(rs.getString("HangSanXuat"));
                    lx.setNamSanXuat(rs.getString("NamSanXuat"));
                    lx.setGiaBan(rs.getString("GiaBan"));
                    lx.setMauSon(rs.getString("MauSon"));
                    lx.setKieuDongCo(rs.getString("KieuDongCo"));
                    lx.setSoChoNgoi(rs.getInt("SoChoNgoi"));
                   
                    
                    return lx;
                }
            }
            return null;
        }
    }
    public List<OTo> findByColor(String MauSon) throws Exception {
        String sql = "SELECT * FROM OTo"
                + " WHERE MauSon=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
            pre.setString(1, MauSon);
            try (ResultSet rs = pre.executeQuery();) {
                List<OTo> list = new ArrayList<>();
                while (rs.next()) {
                    OTo lx = new OTo();
                    lx.setMaOT(rs.getString("MaOT"));
                   
                    lx.setTenXe(rs.getString("TenXe"));
                    lx.setHangSanXuat(rs.getString("HangSanXuat"));
                    lx.setNamSanXuat(rs.getString("NamSanXuat"));
                    lx.setGiaBan(rs.getString("GiaBan"));
                    lx.setMauSon(rs.getString("MauSon"));
                    lx.setKieuDongCo(rs.getString("KieuDongCo"));
                    lx.setSoChoNgoi(rs.getInt("SoChoNgoi"));
                    
                    list.add(lx);
                }
                return list;
            }
        }
    }

    public List<OTo> findAll() throws Exception {
        String sql = "SELECT * FROM OTo";

        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            try (ResultSet rs = pre.executeQuery();) {
                List<OTo> list = new ArrayList<>();
                while (rs.next()) {
                    OTo lx = new OTo();
                    lx.setMaOT(rs.getString("MaOT"));
                   
                    lx.setTenXe(rs.getString("TenXe"));
                    lx.setHangSanXuat(rs.getString("HangSanXuat"));
                    lx.setNamSanXuat(rs.getString("NamSanXuat"));
                    lx.setGiaBan(rs.getString("GiaBan"));
                    lx.setMauSon(rs.getString("MauSon"));
                    lx.setKieuDongCo(rs.getString("KieuDongCo"));
                    lx.setSoChoNgoi(rs.getInt("SoChoNgoi"));
                    
                    list.add(lx);
                }
                return list;
            }
        }
    }
}
