package doan.ltn.doan_android.Object;

public class Contract {
    private  int MaHD;
    private  String NguoiLap;
    private  String NCC;
    private  int HeThong;
    private String NgayLap;
    private  String NgayHT;

//    public Contract(){
//        //
//    }
    public Contract(int maHD, String nguoiLap, String NCC, int heThong, String ngayLap) {
        MaHD = maHD;
        NguoiLap = nguoiLap;
        this.NCC = NCC;
        HeThong = heThong;
        NgayLap = ngayLap;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int maHD) {
        MaHD = maHD;
    }

    public String getNguoiLap() {
        return NguoiLap;
    }

    public void setNguoiLap(String nguoiLap) {
        NguoiLap = nguoiLap;
    }

    public String getNCC() {
        return NCC;
    }

    public void setNCC(String NCC) {
        this.NCC = NCC;
    }

    public int getHeThong() {
        return HeThong;
    }

    public void setHeThong(int heThong) {
        HeThong = heThong;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String ngayLap) {
        NgayLap = ngayLap;
    }

    public String getNgayHT() {
        return NgayHT;
    }

    public void setNgayHT(String ngayHT) {
        NgayHT = ngayHT;
    }
}
