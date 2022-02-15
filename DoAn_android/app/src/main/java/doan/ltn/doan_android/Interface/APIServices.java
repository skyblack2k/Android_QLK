package doan.ltn.doan_android.Interface;

import android.support.v4.media.AudioAttributesCompat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import doan.ltn.doan_android.Object.ResultAPI.Model.ModelMatHang;
import doan.ltn.doan_android.Object.ResultAPI.ResultBoolean;
import doan.ltn.doan_android.Object.ResultAPI.ResultCuaHang;
import doan.ltn.doan_android.Object.ResultAPI.ResultDashboardData;
import doan.ltn.doan_android.Object.ResultAPI.ResultFloat;
import doan.ltn.doan_android.Object.ResultAPI.ResultGroupID;
import doan.ltn.doan_android.Object.ResultAPI.ResultHeThong;
import doan.ltn.doan_android.Object.ResultAPI.ResultHopDong;
import doan.ltn.doan_android.Object.ResultAPI.ResultListCTHD;
import doan.ltn.doan_android.Object.ResultAPI.ResultListCTPN;
import doan.ltn.doan_android.Object.ResultAPI.ResultListCTPX;
import doan.ltn.doan_android.Object.ResultAPI.ResultListCuaHang;
import doan.ltn.doan_android.Object.ResultAPI.ResultListHopDong;
import doan.ltn.doan_android.Object.ResultAPI.ResultListMatHang;
import doan.ltn.doan_android.Object.ResultAPI.ResultListMatHangHT;
import doan.ltn.doan_android.Object.ResultAPI.ResultListNCC;
import doan.ltn.doan_android.Object.ResultAPI.ResultListPhieuNhap;
import doan.ltn.doan_android.Object.ResultAPI.ResultListPhieuXuat;
import doan.ltn.doan_android.Object.ResultAPI.ResultListUser;
import doan.ltn.doan_android.Object.ResultAPI.ResultMatHang;
import doan.ltn.doan_android.Object.ResultAPI.ResultNCC;
import doan.ltn.doan_android.Object.ResultAPI.ResultPhieuXuat;
import doan.ltn.doan_android.Object.ResultAPI.ResultString;
import doan.ltn.doan_android.Object.ResultAPI.ResultUser;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface APIServices {
    Gson gson= new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APIServices apiservices= new Retrofit.Builder()
            .baseUrl("http://192.168.1.179:44361/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIServices.class);

    //Call API
    @Multipart
    @POST("api/TaiKhoan/GetDashboardData")
    Call<ResultDashboardData> GetDashBoardData(@Part("Token")RequestBody token);

    //User
    @Multipart
    @POST("api/TaiKhoan/Login")
    Call<ResultString> User_Login(@Part("UserName")RequestBody userName,
                             @Part("Password")RequestBody password);

    @Multipart
    @POST("api/TaiKhoan/CheckLogin")
    Call<ResultBoolean> User_CheckLogin(@Part("Token")RequestBody token);

    @Multipart
    @POST("api/TaiKhoan/GetUser")
    Call<ResultUser> User_GetUser(@Part("Token")RequestBody token);

    @Multipart
    @POST("api/TaiKhoan/GetGroupID")
    Call<ResultGroupID> User_GetGroupID(@Part("Token")RequestBody token);

    @Multipart
    @POST("api/TaiKhoan/SearchPaging")
    Call<ResultListUser> User_SearchPaging(@Part("Token")RequestBody token,
                                           @Part("HeThongID")RequestBody htID,
                                           @Part("StartTime")RequestBody sTime,
                                           @Part("EndTime")RequestBody eTime,
                                           @Part("SearchValue")RequestBody keyword,
                                           @Part("SearchType")RequestBody searchType,
                                           @Part("CurPage")RequestBody curPage,
                                           @Part("PageSize")RequestBody pageSize,
                                           @Part("OrderBy")RequestBody orderBy,
                                           @Part("IsDescending")RequestBody isDes,
                                           @Part("Status")RequestBody status
                                        );

    //He thong
    @Multipart
    @POST("api/HeThong/GetDetail")
    Call<ResultHeThong> HeThong_GetDetail(@Part("Token")RequestBody token,
                                          @Part("ID")RequestBody id);


    //HopDong
    @Multipart
    @POST("api/HopDong/SearchPaging")
    Call<ResultListHopDong> HopDong_SearchPaging(@Part("Token")RequestBody token,
                                                 @Part("HeThongID")RequestBody htID,
                                                 @Part("NhaCungCapID")RequestBody nccID,
                                                 @Part("StartTime")RequestBody sTime,
                                                 @Part("EndTime")RequestBody eTime,
                                                 @Part("SearchValue")RequestBody keyword,
                                                 @Part("SearchType")RequestBody searchType,
                                                 @Part("CurPage")RequestBody curPage,
                                                 @Part("PageSize")RequestBody pageSize,
                                                 @Part("OrderBy")RequestBody orderBy,
                                                 @Part("IsDescending")RequestBody isDes,
                                                 @Part("Status")RequestBody statuss
                                                 );

    @Multipart
    @POST("api/HopDong/GetDetail")
    Call<ResultHopDong> HopDong_GetDetail(@Part("Token")RequestBody token,
                                          @Part("ID")RequestBody id);

    @Multipart
    @POST("api/HopDong/GetProgress")
    Call<ResultFloat> HopDong_GetProgress(@Part("Token")RequestBody token,
                                          @Part("ID")RequestBody id);

    @Multipart
    @POST("api/HopDong/GetListCTHD")
    Call<ResultListCTHD> HopDong_GetListCTHD(@Part("Token")RequestBody token,
                                             @Part("ID")RequestBody id);

    //Phieu nhap
    @Multipart
    @POST("api/HopDong/GetListPN")
    Call<ResultListPhieuNhap> PhieuNhap_GetListPhieuNhap(@Part("Token")RequestBody token,
                                                      @Part("ID")RequestBody id);

    @Multipart
    @POST("api/HopDong/GetListCTPN")
    Call<ResultListCTPN> PhieuNhap_GetListCTPN(@Part("Token")RequestBody token,
                                               @Part("ID")RequestBody id);
    //HeThong
    @Multipart
    @POST("api/NhaCungCap/SearchPaging")
    Call<ResultListNCC> NhaCungCap_SearchPaging(@Part("Token")RequestBody token,
                                                @Part("StartTime")RequestBody sTime,
                                                @Part("EndTime")RequestBody eTime,
                                                @Part("SearchValue")RequestBody keyword,
                                                @Part("SearchType")RequestBody searchType,
                                                @Part("CurPage")RequestBody curPage,
                                                @Part("PageSize")RequestBody pageSize,
                                                @Part("OrderBy")RequestBody orderBy,
                                                @Part("IsDescending")RequestBody isDes
                                                );

    @Multipart
    @POST("api/NhaCungCap/GetDetail")
    Call<ResultNCC> NhaCungCap_GetDetail(@Part("Token")RequestBody token,
                                         @Part("ID")RequestBody id);

    //MatHang
    @Multipart
    @POST("api/MatHang/SearchPagingNCC")
    Call<ResultListMatHang> MatHang_SearchPagingNCC(@Part("Token")RequestBody token,
                                                    @Part("NhaCungCapID")RequestBody nccID,
                                                    @Part("StartTime")RequestBody sTime,
                                                    @Part("EndTime")RequestBody eTime,
                                                    @Part("SearchValue")RequestBody keyword,
                                                    @Part("SearchType")RequestBody searchType,
                                                    @Part("CurPage")RequestBody curPage,
                                                    @Part("PageSize")RequestBody pageSize,
                                                    @Part("OrderBy")RequestBody orderBy,
                                                    @Part("IsDescending")RequestBody isDes);

    @Multipart
    @POST("api/MatHang/SearchPagingHT")
    Call<ResultListMatHangHT> MatHang_SearchPagingHT(@Part("Token")RequestBody token,
                                                     @Part("HeThongID")RequestBody htID,
                                                     @Part("StartTime")RequestBody sTime,
                                                     @Part("EndTime")RequestBody eTime,
                                                     @Part("SearchValue")RequestBody keyword,
                                                     @Part("SearchType")RequestBody searchType,
                                                     @Part("CurPage")RequestBody curPage,
                                                     @Part("PageSize")RequestBody pageSize,
                                                     @Part("OrderBy")RequestBody orderBy,
                                                     @Part("IsDescending")RequestBody isDes);

    @Multipart
    @POST("api/MatHang/SearchPagingHD")
    Call<ResultListMatHang> MatHang_SearchPagingHD(@Part("Token")RequestBody token,
                                                    @Part("HopDongID")RequestBody hdID,
                                                    @Part("StartTime")RequestBody sTime,
                                                    @Part("EndTime")RequestBody eTime,
                                                    @Part("SearchValue")RequestBody keyword,
                                                    @Part("SearchType")RequestBody searchType,
                                                    @Part("CurPage")RequestBody curPage,
                                                    @Part("PageSize")RequestBody pageSize,
                                                    @Part("OrderBy")RequestBody orderBy,
                                                    @Part("IsDescending")RequestBody isDes);

    @Multipart
    @POST("api/MatHang/GetDetail")
    Call<ResultMatHang> MatHang_GetDetail(@Part("Token")RequestBody token,
                                          @Part("ID")RequestBody id);

    //CuaHang
    @Multipart
    @POST("api/CuaHang/SearchPaging")
    Call<ResultListCuaHang> CuaHang_SearchPaging(@Part("Token")RequestBody token,
                                                 @Part("HeThongID")RequestBody htID,
                                                 @Part("StartTime")RequestBody sTime,
                                                 @Part("EndTime")RequestBody eTime,
                                                 @Part("SearchValue")RequestBody keyword,
                                                 @Part("SearchType")RequestBody searchType,
                                                 @Part("CurPage")RequestBody curPage,
                                                 @Part("PageSize")RequestBody pageSize,
                                                 @Part("OrderBy")RequestBody orderBy,
                                                 @Part("IsDescending")RequestBody isDes
                                                 );

    @Multipart
    @POST("api/CuaHang/GetDetail")
    Call<ResultCuaHang> CuaHang_GetDetail(@Part("Token")RequestBody token,
                                          @Part("ID")RequestBody id);

    //Phieu xuat
    @Multipart
    @POST("api/PhieuXuat/SearchPaging")
    Call<ResultListPhieuXuat> PhieuXuat_SearchPaging(@Part("Token")RequestBody token,
                                                     @Part("HeThongID")RequestBody htID,
                                                     @Part("CuaHangID")RequestBody chID,
                                                     @Part("StartTime")RequestBody sTime,
                                                     @Part("EndTime")RequestBody eTime,
                                                     @Part("SearchValue")RequestBody keyword,
                                                     @Part("SearchType")RequestBody searchType,
                                                     @Part("CurPage")RequestBody curPage,
                                                     @Part("PageSize")RequestBody pageSize,
                                                     @Part("OrderBy")RequestBody orderBy,
                                                     @Part("IsDescending")RequestBody isDes
                                                );

    @Multipart
    @POST("api/PhieuXuat/GetDetail")
    Call<ResultPhieuXuat> PhieuXuat_GetDetail(@Part("Token")RequestBody token,
                                              @Part("ID")RequestBody id);

    @Multipart
    @POST("api/PhieuXuat/PheDuyet")
    Call<ResultBoolean> PhieuXuat_PheDuyet(@Part("Token")RequestBody token,
                                           @Part("ID")RequestBody id);

    @Multipart
    @POST("api/PhieuXuat/HoanThanh")
    Call<ResultBoolean> PhieuXuat_HoanThanh(@Part("Token")RequestBody token,
                                            @Part("ID")RequestBody id);

    @Multipart
    @POST("api/PhieuXuat/GetListCTPX")
    Call<ResultListCTPX> PhieuXuat_GetListCTPX(@Part("Token")RequestBody token,
                                               @Part("ID")RequestBody id);
}
