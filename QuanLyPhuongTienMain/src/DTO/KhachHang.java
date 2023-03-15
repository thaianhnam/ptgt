/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class KhachHang {
    private String MaKH;
    private String HoTen;
    private int GioiTinh;
    private int CMND;
    private String NgaySinh;
     private String Email;
    private String DienThoai;
    private String DiaChi; 

    public KhachHang() {
    }

    public KhachHang(String MaKH, String HoTen, int GioiTinh, int CMND, String NgaySinh, String Email, String DienThoai, String DiaChi) {
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.CMND = CMND;
        this.NgaySinh = NgaySinh;
        this.Email = Email;
        this.DienThoai = DienThoai;
        this.DiaChi = DiaChi;
    }

    

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public int getCMND() {
        return CMND;
    }

    public void setCMND(int CMND) {
        this.CMND = CMND;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DaiChi) {
        this.DiaChi = DaiChi;
    }
    
    
       
}
