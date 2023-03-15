/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DATA.DatabaseHelper;
import DTO.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangDao {

    public boolean insert(KhachHang kh) throws Exception{
        String sql = "INSERT INTO dbo.Khachhang(MaKH,HoTen,GioiTinh,CMND,DienThoai,NgaySinh,Email, DiaChi) VALUES(?,?,?,?,?,?,?,?)";
        try( Connection con = DatabaseHelper.openConnection();
                PreparedStatement pre = con.prepareStatement(sql);)  
        {
            pre.setString (1,kh.getMaKH());
            pre.setString (2,kh.getHoTen());
            pre.setInt(3,kh.getGioiTinh());
            pre.setInt(4,kh.getCMND());
            pre.setString(5,kh.getDienThoai());
            pre.setString(6,kh.getNgaySinh());
            pre.setString (7,kh.getEmail());
            pre.setString(8,kh.getDiaChi());
           
          
            return pre.executeUpdate()>0;
        }
           
    }   
    public boolean update(KhachHang kh) throws Exception
    {
        String sql = "UPDATE dbo.KhachHang "
                + " SET HoTen = ?,GioiTinh = ?, CMND = ?, DienThoai = ?,NgaySinh = ?,Email = ?,DiaChi = ? "
                + " WHERE MaKH= ? ";
        try( Connection con = DatabaseHelper.openConnection();
             PreparedStatement pre = con.prepareStatement(sql);)  
        {
            pre.setString (1,kh.getHoTen());
            pre.setInt(2,kh.getGioiTinh());
            pre.setInt(3,kh.getCMND());
            pre.setString(4,kh.getDienThoai());
            pre.setString(5,kh.getNgaySinh());
            pre.setString (6,kh.getEmail());
            pre.setString(7,kh.getDiaChi());
            pre.setString (8,kh.getMaKH());
            
            return pre.executeUpdate()>0;
        }
           
    }    
    public  boolean  delete ( String MaKH) throws Exception
    {
        String sql = "DELETE FROM KhachHang "
                + " WHERE MaKH = ?";
        try( Connection con = DatabaseHelper.openConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);)  
        {
            pstmt.setString (1,MaKH);
           
          return pstmt.executeUpdate()>0;
        }
    }
    public  KhachHang  findDung( String MaKH) throws Exception
    {
        String sql = "SELECT  * FROM KhachHang "
                + " WHERE MaKH = ? ";
        try( Connection con = DatabaseHelper.openConnection();
             PreparedStatement pre = con.prepareStatement(sql);)  
        {
            pre.setString(1,MaKH);
            try(ResultSet rs = pre.executeQuery(); )
            { 
               
                if(rs.next())
                {
                   KhachHang kh = TimKiem(rs);
                    return  kh;
                }
            }
        return null;
        }
    }
    
    public  KhachHang  findByID( String MaKH) throws Exception
    {
        String sql = "SELECT  * FROM KhachHang "
                + " WHERE MaKH = ? ";
        try( Connection con = DatabaseHelper.openConnection();
             PreparedStatement pre = con.prepareStatement(sql);)  
        {
            pre.setString(1,MaKH);
            try(ResultSet rs = pre.executeQuery(); )
            { 
               
                if(rs.next())
                {
                   KhachHang kh = TimKiem(rs);
                    return  kh;
                }
            }
        return null;
        }
    }
    public  List<KhachHang>findAll() throws Exception{
         String sql = "SELECT *  FROM KhachHang ";
        try( Connection con = DatabaseHelper.openConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);)  
            { 
            try(ResultSet rs = pstmt.executeQuery();)
            { 
                List<KhachHang> list = new ArrayList<KhachHang>();
                while(rs.next())
                {
                    KhachHang sv = TimKiem(rs);
                    list.add(sv);
                }
                return list;
            }
        }
        
    }

    private KhachHang TimKiem(final ResultSet rs) throws SQLException {
        KhachHang kh = new KhachHang();
        kh.setMaKH(rs.getString("MaKH"));
        kh.setHoTen(rs.getString("HoTen"));
        kh.setGioiTinh(rs.getInt("GioiTinh"));
        kh.setCMND(rs.getInt("CMND"));
        kh.setDienThoai(rs.getString("DienThoai"));
        kh.setNgaySinh(rs.getString("NgaySinh"));
        kh.setEmail(rs.getString("Email"));
        kh.setDiaChi(rs.getString("DiaChi"));
        
        return kh;
    }
}
