package doan.ltn.doan_android.Interface;

import android.support.v4.media.AudioAttributesCompat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import doan.ltn.doan_android.Object.ResultAPI.ResultBoolean;
import doan.ltn.doan_android.Object.ResultAPI.ResultDashboardData;
import doan.ltn.doan_android.Object.ResultAPI.ResultGroupID;
import doan.ltn.doan_android.Object.ResultAPI.ResultListHopDong;
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

    //He thong
    @Multipart
    @POST("api/HeThong/GetDetail")
    Call<ResultUser> HeThong_GetDetail(@Part("Token")RequestBody token,
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
}
