/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DATA.DatabaseHelper;
import DTO.XeTai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class XeTaiDao {

    public boolean insert(XeTai item) throws Exception {
        String sql = "INSERT INTO [dbo].[XeTai]([MaXT],[TenXe], [HangSanXuat], [NamSanXuat], [GiaBan], [MauSon], [TrongTai])"
                + " values(?, ?, ?, ?, ?, ?, ?)";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
                pre.setString(1, item.getMaXT());
                pre.setString(2, item.getTenXe());
                pre.setString(3, item.getHangSanXuat());
                pre.setString(4, item.getNamSanXuat());
                pre.setString(5, item.getGiaBan());
                pre.setString(6, item.getMauSon());
                pre.setFloat(7, item.getTrongTai());
           

            return pre.executeUpdate() > 0;
        }
    }

    public boolean update(XeTai item) throws Exception {
        String sql = "UPDATE dbo.XeTai"
                + " SET TenXe=?, HangSanXuat=?, NamSanXuat=?, GiaBan=?, MauSon=?, TrongTai=?"
                + " WHERE MaXT=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
            
                pre.setString(1, item.getTenXe());
                pre.setString(2, item.getHangSanXuat());
                pre.setString(3, item.getNamSanXuat());
                pre.setString(4, item.getGiaBan());
                pre.setString(5, item.getMauSon());
                pre.setFloat(6, item.getTrongTai());           
                pre.setString(7, item.getMaXT());

            return pre.executeUpdate() > 0;
        }
    }

    public boolean delete(String MaLoaiXe) throws Exception {
        String sql = "DELETE FROM XeTai"
                + " WHERE MaXT=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            pre.setString(1, MaLoaiXe);

            return pre.executeUpdate() > 0;
        }
    }

    public XeTai findById(String MaXT) throws Exception {
        String sql = "SELECT * FROM XeTai"
                + " WHERE MaXT=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            pre.setString(1, MaXT);
            try (ResultSet rs = pre.executeQuery();) {
                if (rs.next()) {
                    XeTai lx = new XeTai();
                    lx.setMaXT(rs.getString("MaXT"));
                    lx.setTenXe(rs.getString("TenXe"));
                    lx.setHangSanXuat(rs.getString("HangSanXuat"));
                    lx.setNamSanXuat(rs.getString("NamSanXuat"));
                    lx.setGiaBan(rs.getString("GiaBan"));
                    lx.setMauSon(rs.getString("MauSon"));
                    lx.setTrongTai(rs.getFloat("TrongTai"));
                  
                    
                    return lx;
                }
            }
            return null;
        }
    }

    public List<XeTai> findByColor(String MauSon) throws Exception {
        String sql = "SELECT * FROM XeTai"
                +" WHERE MauSon=?";

        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
                pre.setString(1, MauSon);
            try (ResultSet rs = pre.executeQuery();) {
                List<XeTai> list = new ArrayList<>();
                while (rs.next()) {
                    XeTai lx = new XeTai();
                    lx.setMaXT(rs.getString("MaXT"));
                    lx.setTenXe(rs.getString("TenXe"));
                    lx.setHangSanXuat(rs.getString("HangSanXuat"));
                    lx.setNamSanXuat(rs.getString("NamSanXuat"));
                    lx.setGiaBan(rs.getString("GiaBan"));
                    lx.setMauSon(rs.getString("MauSon"));
                    lx.setTrongTai(rs.getFloat("TrongTai"));
                    list.add(lx);
                }
                return list;
            }
        }
    }
    public List<XeTai> findAll() throws Exception {
        String sql = "SELECT * FROM XeTai";

        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
            try (ResultSet rs = pre.executeQuery();) {
                List<XeTai> list = new ArrayList<>();
                while (rs.next()) {
                    XeTai lx = new XeTai();
                    lx.setMaXT(rs.getString("MaXT"));
                    lx.setTenXe(rs.getString("TenXe"));
                    lx.setHangSanXuat(rs.getString("HangSanXuat"));
                    lx.setNamSanXuat(rs.getString("NamSanXuat"));
                    lx.setGiaBan(rs.getString("GiaBan"));
                    lx.setMauSon(rs.getString("MauSon"));
                    lx.setTrongTai(rs.getFloat("TrongTai"));
                    list.add(lx);
                }
                return list;
            }
        }
    }
}
