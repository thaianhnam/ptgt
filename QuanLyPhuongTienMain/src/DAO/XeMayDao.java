/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DATA.DatabaseHelper;
import DTO.XeMay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class XeMayDao {

    public boolean insert(XeMay item) throws Exception {
        String sql = "INSERT INTO [dbo].[XeMay]([MaXM],[TenXe], [HangSanXuat], [NamSanXuat], [GiaBan], [MauSon], [CongSuat])"
                + " values(?, ?, ?, ?, ?, ?, ?)";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
                pre.setString(1, item.getMaXM());
                pre.setString(2, item.getTenXe());
                pre.setString(3, item.getHangSanXuat());
                pre.setString(4, item.getNamSanXuat());
                pre.setString(5, item.getGiaBan());
                pre.setString(6, item.getMauSon());
                pre.setFloat(7, item.getCongSuat());
           

            return pre.executeUpdate() > 0;
        }
    }

    public boolean update(XeMay item) throws Exception {
        String sql = "UPDATE dbo.XeMay"
                + " SET TenXe=?, HangSanXuat=?, NamSanXuat=?, GiaBan=?, MauSon=?, CongSuat=?"
                + " WHERE MaXM=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
            
                pre.setString(1, item.getTenXe());
                pre.setString(2, item.getHangSanXuat());
                pre.setString(3, item.getNamSanXuat());
                pre.setString(4, item.getGiaBan());
                pre.setString(5, item.getMauSon());
                pre.setFloat(6, item.getCongSuat());           
                pre.setString(7, item.getMaXM());

            return pre.executeUpdate() > 0;
        }
    }

    public boolean delete(String MaXM) throws Exception {
        String sql = "DELETE FROM XeMay"
                + " WHERE MaXM=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            pre.setString(1, MaXM);

            return pre.executeUpdate() > 0;
        }
    }

    public XeMay findById(String MaXM) throws Exception {
        String sql = "SELECT * FROM XeMay"
                + " WHERE MaXM=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            pre.setString(1, MaXM);
            try (ResultSet rs = pre.executeQuery();) {
                if (rs.next()) {
                    XeMay lx = new XeMay();
                    lx.setMaXM(rs.getString("MaXM"));
                    lx.setTenXe(rs.getString("TenXe"));
                    lx.setHangSanXuat(rs.getString("HangSanXuat"));
                    lx.setNamSanXuat(rs.getString("NamSanXuat"));
                    lx.setGiaBan(rs.getString("GiaBan"));
                    lx.setMauSon(rs.getString("MauSon"));
                    lx.setCongSuat(rs.getFloat("CongSuat"));
                  
                    
                    return lx;
                }
            }
            return null;
        }
    }
    public List<XeMay> findByColor(String MauSon) throws Exception {
        String sql = "SELECT * FROM XeMay"
                + " WHERE MauSon=?";

        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
            
            pre.setString(1, MauSon);
            try (ResultSet rs = pre.executeQuery();) {
                List<XeMay> list = new ArrayList<>();
                while (rs.next()) {
                    XeMay lx = new XeMay();
                    lx.setMaXM(rs.getString("MaXM"));
                    lx.setTenXe(rs.getString("TenXe"));
                    lx.setHangSanXuat(rs.getString("HangSanXuat"));
                    lx.setNamSanXuat(rs.getString("NamSanXuat"));
                    lx.setGiaBan(rs.getString("GiaBan"));
                    lx.setMauSon(rs.getString("MauSon"));
                    lx.setCongSuat(rs.getFloat("CongSuat"));
                    list.add(lx);
                }
                return list;
            }
        }
    }
    public List<XeMay> findAll() throws Exception {
        String sql = "SELECT * FROM XeMay";

        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
            try (ResultSet rs = pre.executeQuery();) {
                List<XeMay> list = new ArrayList<>();
                while (rs.next()) {
                    XeMay lx = new XeMay();
                    lx.setMaXM(rs.getString("MaXM"));
                    lx.setTenXe(rs.getString("TenXe"));
                    lx.setHangSanXuat(rs.getString("HangSanXuat"));
                    lx.setNamSanXuat(rs.getString("NamSanXuat"));
                    lx.setGiaBan(rs.getString("GiaBan"));
                    lx.setMauSon(rs.getString("MauSon"));
                    lx.setCongSuat(rs.getFloat("CongSuat"));
                    list.add(lx);
                }
                return list;
            }
        }
    }
}
