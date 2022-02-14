package doan.ltn.doan_android.Object;

public class Product {
    private int ID;
    private String TenSP;
    private String MoTa;
    private  int SL;
    private  int Gia;
    private int NhaCungCapID;
    private String NgayTao;
    private  String NgayCapNhat;
    private String Image;
    private  Boolean IsDelete;

    public Product(int ID, String tenSP, int gia,int sl  ,String image ) {
        this.ID = ID;
        TenSP = tenSP;
        Gia = gia;
        Image = image;
        SL=sl;
    }

    public Product(int ID, String tenSP, String moTa, int SL, int gia, int nhaCungCapID, String ngayTao, String ngayCapNhat, String image, Boolean isDelete) {
        this.ID = ID;
        TenSP = tenSP;
        MoTa = moTa;
        this.SL = SL;
        Gia = gia;
        NhaCungCapID = nhaCungCapID;
        NgayTao = ngayTao;
        NgayCapNhat = ngayCapNhat;
        Image = image;
        IsDelete = isDelete;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public int getNhaCungCapID() {
        return NhaCungCapID;
    }

    public void setNhaCungCapID(int nhaCungCapID) {
        NhaCungCapID = nhaCungCapID;
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

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Boolean getDelete() {
        return IsDelete;
    }

    public void setDelete(Boolean delete) {
        IsDelete = delete;
    }
}
