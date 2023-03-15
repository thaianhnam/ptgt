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
public class ThongTinXe{
    private String BienSo;
    private String MaXM;
    private String MaOT;
    private String MaXT;
    private String NgayDangKy;
    private String TinhTrang;

    public ThongTinXe() {
    }

    public ThongTinXe(String BienSo, String MaXM, String MaOT, String MaXT, String NgayDangKy, String TinhTrang) {
        this.BienSo = BienSo;
        this.MaXM = MaXM;
        this.MaOT = MaOT;
        this.MaXT = MaXT;
        this.NgayDangKy = NgayDangKy;
        this.TinhTrang = TinhTrang;
    }

    public String getBienSo() {
        return BienSo;
    }

    public void setBienSo(String BienSo) {
        this.BienSo = BienSo;
    }

    public String getMaXM() {
        return MaXM;
    }

    public void setMaXM(String MaXM) {
        this.MaXM = MaXM;
    }

    public String getMaOT() {
        return MaOT;
    }

    public void setMaOT(String MaOT) {
        this.MaOT = MaOT;
    }

    public String getMaXT() {
        return MaXT;
    }

    public void setMaXT(String MaXT) {
        this.MaXT = MaXT;
    }

    public String getNgayDangKy() {
        return NgayDangKy;
    }

    public void setNgayDangKy(String NgayDangKy) {
        this.NgayDangKy = NgayDangKy;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    
   
}
