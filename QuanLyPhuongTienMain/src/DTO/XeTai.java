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
public class XeTai extends PTGT{
    private String MaXT;
    private float TrongTai;

    public XeTai() {
    }

    public XeTai(String MaXT, float TrongTai, String TenXe, String HangSanXuat, String NamSanXuat, String GiaBan, String MauSon) {
        super(TenXe, HangSanXuat, NamSanXuat, GiaBan, MauSon);
        this.MaXT = MaXT;
        this.TrongTai = TrongTai;
    }

    public String getMaXT() {
        return MaXT;
    }

    public void setMaXT(String MaXT) {
        this.MaXT = MaXT;
    }

    public float getTrongTai() {
        return TrongTai;
    }

    public void setTrongTai(float TrongTai) {
        this.TrongTai = TrongTai;
    }

    

    
    
    
}
