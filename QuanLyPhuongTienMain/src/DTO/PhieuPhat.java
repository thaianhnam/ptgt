
package DTO;


public class PhieuPhat {
    private String MaPP, MaPT, NgayPhat, NoiDungPhat, MaKH, MaNV;
    private float TienPhat;

    public PhieuPhat() {
    }

    public PhieuPhat(String MaPP, String MaPT, String NgayPhat, String NoiDungPhat, String MaKH, String MaNV, float TienPhat) {
        this.MaPP = MaPP;
        this.MaPT = MaPT;
        this.NgayPhat = NgayPhat;
        this.NoiDungPhat = NoiDungPhat;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.TienPhat = TienPhat;
    }

    public String getMaPP() {
        return MaPP;
    }

    public void setMaPP(String MaPP) {
        this.MaPP = MaPP;
    }

    public String getMaPT() {
        return MaPT;
    }

    public void setMaPT(String MaPT) {
        this.MaPT = MaPT;
    }

    public String getNgayPhat() {
        return NgayPhat;
    }

    public void setNgayPhat(String NgayPhat) {
        this.NgayPhat = NgayPhat;
    }

    public String getNoiDungPhat() {
        return NoiDungPhat;
    }

    public void setNoiDungPhat(String NoiDungPhat) {
        this.NoiDungPhat = NoiDungPhat;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public float getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(float TienPhat) {
        this.TienPhat = TienPhat;
    }
    
}
