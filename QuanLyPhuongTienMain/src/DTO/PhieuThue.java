/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author admin
 */
public class PhieuThue {
    private String MaPT, MaNV, NgayThang, MaKH, BienSo;
    private int SoNgayThue;
    private float DonGiaNgay;

    public PhieuThue() {
    }

    public PhieuThue(String MaPT, String MaNV, String NgayThang, String MaKH, String BienSo, int SoNgayThue, float DonGiaNgay) {
        this.MaPT = MaPT;
        this.MaNV = MaNV;
        this.NgayThang = NgayThang;
        this.MaKH = MaKH;
        this.BienSo = BienSo;
        this.SoNgayThue = SoNgayThue;
        this.DonGiaNgay = DonGiaNgay;
    }

    public String getMaPT() {
        return MaPT;
    }

    public void setMaPT(String MaPT) {
        this.MaPT = MaPT;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getBienSo() {
        return BienSo;
    }

    public void setBienSo(String BienSo) {
        this.BienSo = BienSo;
    }

    

    public String getNgayThang() {
        return NgayThang;
    }

    public void setNgayThang(String NgayThang) {
        this.NgayThang = NgayThang;
    }

    public int getSoNgayThue() {
        return SoNgayThue;
    }

    public void setSoNgayThue(int SoNgayThue) {
        this.SoNgayThue = SoNgayThue;
    }

    public float getDonGiaNgay() {
        return DonGiaNgay;
    }

    public void setDonGiaNgay(float DonGiaNgay) {
        this.DonGiaNgay = DonGiaNgay;
    }
    
    public double getTongTien(){
        return SoNgayThue * DonGiaNgay;
    }
    
    
    
    
    
    
}
