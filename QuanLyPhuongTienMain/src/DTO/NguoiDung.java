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
public class NguoiDung {
    private String MaND; 
    private String TenND ;
    private int Tuoi ;
    private String SoDT  ;
    private int GioiTinh ;
    private String DiaChi ;
    private String ChucVu ;
    private String UserName ;
    private String UserPass ;
    private byte [] Hinh;

    public NguoiDung() {
    }

    public NguoiDung(String MaND, String TenND, int Tuoi, String SoDT, int GioiTinh, String DiaChi, String ChucVu, String UserName, String UserPass, byte[] Hinh) {
        this.MaND = MaND;
        this.TenND = TenND;
        this.Tuoi = Tuoi;
        this.SoDT = SoDT;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.ChucVu = ChucVu;
        this.UserName = UserName;
        this.UserPass = UserPass;
        this.Hinh = Hinh;
    }

    public String getMaND() {
        return MaND;
    }

    public void setMaND(String MaND) {
        this.MaND = MaND;
    }

    public String getTenND() {
        return TenND;
    }

    public void setTenND(String TenND) {
        this.TenND = TenND;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserPass() {
        return UserPass;
    }

    public void setUserPass(String UserPass) {
        this.UserPass = UserPass;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] Hinh) {
        this.Hinh = Hinh;
    }
    
    
}
