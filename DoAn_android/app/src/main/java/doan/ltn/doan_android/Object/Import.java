package doan.ltn.doan_android.Object;

public class Import {
    private  int ID;
    private  String NguoiGiao;
    private  String NgayLap;
    private int HopDongID;
    private int TrangThai;
    private boolean IsDelete;

    public Import(int ID, String nguoiGiao, String ngayLap, int hopDongID, int trangThai, boolean isDelete) {
        this.ID = ID;
        NguoiGiao = nguoiGiao;
        NgayLap = ngayLap;
        HopDongID = hopDongID;
        TrangThai = trangThai;
        IsDelete = isDelete;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNguoiGiao() {
        return NguoiGiao;
    }

    public void setNguoiGiao(String nguoiGiao) {
        NguoiGiao = nguoiGiao;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String ngayLap) {
        NgayLap = ngayLap;
    }

    public int getHopDongID() {
        return HopDongID;
    }

    public void setHopDongID(int hopDongID) {
        HopDongID = hopDongID;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        TrangThai = trangThai;
    }

    public boolean getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(boolean isDelete) {
        IsDelete = isDelete;
    }
}
