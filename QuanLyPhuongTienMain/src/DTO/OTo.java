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
public class OTo extends PTGT{
    private String MaOT;
    private String KieuDongCo;
    private int SoChoNgoi;
    private byte [] Hinh;

    public OTo() {
    }

    public OTo(String MaOT, String KieuDongCo, int SoChoNgoi, String TenXe, String HangSanXuat, String NamSanXuat, String GiaBan, String MauSon) {
        super(TenXe, HangSanXuat, NamSanXuat, GiaBan, MauSon);
        this.MaOT = MaOT;
        this.KieuDongCo = KieuDongCo;
        this.SoChoNgoi = SoChoNgoi;
    }

    public OTo(String MaOT, String KieuDongCo, int SoChoNgoi, byte[] Hinh, String TenXe, String HangSanXuat, String NamSanXuat, String GiaBan, String MauSon) {
        super(TenXe, HangSanXuat, NamSanXuat, GiaBan, MauSon);
        this.MaOT = MaOT;
        this.KieuDongCo = KieuDongCo;
        this.SoChoNgoi = SoChoNgoi;
        this.Hinh = Hinh;
    }
    
    
    
    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] Hinh) {
        this.Hinh = Hinh;
    }
    
    
    public String getMaOT() {
        return MaOT;
    }

    public void setMaOT(String MaOT) {
        this.MaOT = MaOT;
    }

    public String getKieuDongCo() {
        return KieuDongCo;
    }

    public void setKieuDongCo(String KieuDongCo) {
        this.KieuDongCo = KieuDongCo;
    }

    public int getSoChoNgoi() {
        return SoChoNgoi;
    }

    public void setSoChoNgoi(int SoChoNgoi) {
        this.SoChoNgoi = SoChoNgoi;
    }
    
}
