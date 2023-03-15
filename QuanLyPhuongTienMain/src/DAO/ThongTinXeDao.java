/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DATA.DatabaseHelper;
import DTO.ThongTinXe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongTinXeDao {
    public boolean insert(ThongTinXe item) throws Exception {
        String sql = "INSERT INTO [dbo].[ThongTinXe]([BienSo], [MaXM], [MaOT], [MaXT],[NgayDangKy], [TinhTrang])"
                + " values(?, ?, ?, ?, ?, ?)";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
                pre.setString(1, item.getBienSo());
                pre.setString(2, item.getMaXM());
                pre.setString(3, item.getMaOT());
                pre.setString(4, item.getMaXT());
                pre.setString(5, item.getNgayDangKy());
                pre.setString(6, item.getTinhTrang());
                return pre.executeUpdate() > 0;
        }
    }

    public boolean update(ThongTinXe item) throws Exception {
        String sql = "UPDATE dbo.ThongTinXe"
                + " SET NgayDangKy=?, TinhTrang=?"
                + " WHERE BienSo=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {
            
                pre.setString(1, item.getNgayDangKy());
                pre.setString(2, item.getTinhTrang());
                pre.setString(3, item.getBienSo());
            return pre.executeUpdate() > 0;
        }
    }

    public boolean delete(String BienSo) throws Exception {
        String sql = "DELETE FROM ThongTinXe"
                + " WHERE BienSo=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            pre.setString(1, BienSo);

            return pre.executeUpdate() > 0;
        }
    }

    public ThongTinXe findById(String BienSo) throws Exception {
        String sql = "SELECT * FROM ThongTinXe "
                + " WHERE BienSo=?";
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            pre.setString(1, BienSo);
            try (ResultSet rs = pre.executeQuery();) {
                if (rs.next()) {
                    ThongTinXe ttx = new ThongTinXe();
                    ttx.setBienSo(rs.getString("BienSo"));
                    ttx.setMaXM(rs.getString("MaXM"));
                    ttx.setMaOT(rs.getString("MaOT"));
                    ttx.setMaXT(rs.getString("MaXT"));
                    ttx.setNgayDangKy(rs.getString("NgayDangKy"));
                    ttx.setTinhTrang(rs.getString("TinhTrang"));
                    
                    return ttx;
                }
            }
            return null;
        }
    }
    
    
    
    public List<ThongTinXe> findAll() throws Exception {
        String sql = "SELECT * FROM ThongTinXe ";
                
        try (
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);) {

            try (ResultSet rs = pre.executeQuery();) {
                List<ThongTinXe> list = new ArrayList<>();
                while (rs.next()) {
                    ThongTinXe ttx = new ThongTinXe();
                    ttx.setBienSo(rs.getString("BienSo"));
                    ttx.setMaXM(rs.getString("MaXM"));
                    ttx.setMaOT(rs.getString("MaOT"));
                    ttx.setMaXT(rs.getString("MaXT"));
                    ttx.setNgayDangKy(rs.getString("NgayDangKy"));
                    ttx.setTinhTrang(rs.getString("TinhTrang"));
                    
                    list.add(ttx);
                }
                return list;
            }
        }
    }
}
