package doan.ltn.doan_android.Object;

public class Export {
    private int ID;
    private String NgayLap;
    private String NgayDuyet;
    private String NgayHT;
    private  int NguoiDuyetID;
    private  int CuaHangID;
    private  int TrangThai;
    private  boolean IsDelete;

    public Export(int ID, String ngayLap, String ngayDuyet, String ngayHT, int nguoiDuyetID, int cuaHangID, int trangThai, boolean isDelete) {
        this.ID = ID;
        NgayLap = ngayLap;
        NgayDuyet = ngayDuyet;
        NgayHT = ngayHT;
        NguoiDuyetID = nguoiDuyetID;
        CuaHangID = cuaHangID;
        TrangThai = trangThai;
        IsDelete = isDelete;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String ngayLap) {
        NgayLap = ngayLap;
    }

    public String getNgayDuyet() {
        return NgayDuyet;
    }

    public void setNgayDuyet(String ngayDuyet) {
        NgayDuyet = ngayDuyet;
    }

    public String getNgayHT() {
        return NgayHT;
    }

    public void setNgayHT(String ngayHT) {
        NgayHT = ngayHT;
    }

    public int getNguoiDuyetID() {
        return NguoiDuyetID;
    }

    public void setNguoiDuyetID(int nguoiDuyetID) {
        NguoiDuyetID = nguoiDuyetID;
    }

    public int getCuaHangID() {
        return CuaHangID;
    }

    public void setCuaHangID(int cuaHangID) {
        CuaHangID = cuaHangID;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        TrangThai = trangThai;
    }

    public boolean isDelete() {
        return IsDelete;
    }

    public void setDelete(boolean delete) {
        IsDelete = delete;
    }
}
