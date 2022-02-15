package doan.ltn.doan_android.Shared;

import okhttp3.MediaType;

public class Constants {
    public static String Token;
    public static String UserName;
    public static String Name;
    public static int RoleID;
    public static String RoleName;
    public static int HeThongID;
    public static int CuaHangID;
    public static int NhaCungCapID;
    public static boolean IsLogin = false;

    //Content type
    public static MediaType TEXT = MediaType.parse("text/plain");
    //...

    public static void Clear(){
        Token = "";
        UserName = "";
        Name = "";
        RoleID = -1;
        RoleName = "";
        HeThongID = -1;
        CuaHangID = -1;
        NhaCungCapID = -1;
        IsLogin = false;
    }
}
