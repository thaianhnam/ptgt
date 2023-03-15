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
public class XeMay extends PTGT{
    private String MaXM;
    private float CongSuat;

    public XeMay() {
    }

    public XeMay(String MaXM, float CongSuat, String TenXe, String HangSanXuat, String NamSanXuat, String GiaBan, String MauSon) {
        super(TenXe, HangSanXuat, NamSanXuat, GiaBan, MauSon);
        this.MaXM = MaXM;
        this.CongSuat = CongSuat;
    }

    public String getMaXM() {
        return MaXM;
    }

    public void setMaXM(String MaXM) {
        this.MaXM = MaXM;
    }

    public float getCongSuat() {
        return CongSuat;
    }

    public void setCongSuat(float CongSuat) {
        this.CongSuat = CongSuat;
    }

    
    
}
