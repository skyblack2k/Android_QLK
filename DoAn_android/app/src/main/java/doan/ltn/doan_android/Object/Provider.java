package doan.ltn.doan_android.Object;

public class Provider {
    private  int ID;
    private  String TenNCC;
    private  String DiaChi;
    private String SDT;
    private  String STK;
    private  String NganHang;
    private  int TaiKhoanID;
    private  String NgayTao;
    private  String NgayCapNhat;
    private  boolean IsDelete;

    public Provider(int ID, String tenNCC, String diaChi, String SDT, String STK, String nganHang, int taiKhoanID, String ngayTao, String ngayCapNhat, boolean isDelete) {
        this.ID = ID;
        TenNCC = tenNCC;
        DiaChi = diaChi;
        this.SDT = SDT;
        this.STK = STK;
        NganHang = nganHang;
        TaiKhoanID = taiKhoanID;
        NgayTao = ngayTao;
        NgayCapNhat = ngayCapNhat;
        IsDelete = isDelete;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String tenNCC) {
        TenNCC = tenNCC;
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

    public String getNganHang() {
        return NganHang;
    }

    public void setNganHang(String nganHang) {
        NganHang = nganHang;
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

    public boolean isDelete() {
        return IsDelete;
    }

    public void setDelete(boolean delete) {
        IsDelete = delete;
    }
}
