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
public class PTGT {
    private String TenXe;
    private String HangSanXuat ;
    private String NamSanXuat ;
    private String GiaBan;
    private String MauSon;

    public PTGT( String TenXe, String HangSanXuat, String NamSanXuat, String GiaBan, String MauSon) {
        this.TenXe = TenXe;
        this.HangSanXuat = HangSanXuat;
        this.NamSanXuat = NamSanXuat;
        this.GiaBan = GiaBan;
        this.MauSon = MauSon;
    }

    public PTGT() {
    }

    public String getTenXe() {
        return TenXe;
    }

    public void setTenXe(String TenXe) {
        this.TenXe = TenXe;
    }

    public String getHangSanXuat() {
        return HangSanXuat;
    }

    public void setHangSanXuat(String HangSanXuat) {
        this.HangSanXuat = HangSanXuat;
    }

    public String getNamSanXuat() {
        return NamSanXuat;
    }

    public void setNamSanXuat(String NamSanXuat) {
        this.NamSanXuat = NamSanXuat;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getMauSon() {
        return MauSon;
    }

    public void setMauSon(String MauSon) {
        this.MauSon = MauSon;
    }

    
    
    
    
}
