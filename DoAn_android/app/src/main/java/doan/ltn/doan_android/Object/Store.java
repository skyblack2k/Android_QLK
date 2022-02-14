package doan.ltn.doan_android.Object;

public class Store {
    private  int ID;
    private  String TenCH;
    private  String DiaChi;
    private  String SDT;
    private  String STK;
    private  int TaiKhoanID;
    private  String NgayTao;
    private  String NgayCapNhat;
    private   int HeTHongID;
    private  boolean IsDelete;

    public Store(int ID, String tenCH, String diaChi, String SDT, String STK, int taiKhoanID, String ngayTao, String ngayCapNhat, int heTHongID, boolean isDelete) {
        this.ID = ID;
        TenCH = tenCH;
        DiaChi = diaChi;
        this.SDT = SDT;
        this.STK = STK;
        TaiKhoanID = taiKhoanID;
        NgayTao = ngayTao;
        NgayCapNhat = ngayCapNhat;
        HeTHongID = heTHongID;
        IsDelete = isDelete;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenCH() {
        return TenCH;
    }

    public void setTenCH(String tenCH) {
        TenCH = tenCH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getSTK() {
        return STK;
    }

    public void setSTK(String STK) {
        this.STK = STK;
    }

    public int getTaiKhoanID() {
        return TaiKhoanID;
    }

    public void setTaiKhoanID(int taiKhoanID) {
        TaiKhoanID = taiKhoanID;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String ngayTao) {
        NgayTao = ngayTao;
    }

    public String getNgayCapNhat() {
        return NgayCapNhat;
    }

    public void setNgayCapNhat(String ngayCapNhat) {
        NgayCapNhat = ngayCapNhat;
    }

    public int getHeTHongID() {
        return HeTHongID;
    }

    public void setHeTHongID(int heTHongID) {
        HeTHongID = heTHongID;
    }

    public boolean isDelete() {
        return IsDelete;
    }

    public void setDelete(boolean delete) {
        IsDelete = delete;
    }
}
