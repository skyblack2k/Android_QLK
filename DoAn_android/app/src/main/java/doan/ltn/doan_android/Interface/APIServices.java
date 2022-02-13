package doan.ltn.doan_android.Interface;

import android.support.v4.media.AudioAttributesCompat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import doan.ltn.doan_android.Object.ResultAPI.ResultBoolean;
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
    //User
    @Multipart
    @POST("api/TaiKhoan/Login")
    Call<ResultString> UserLogin(@Part("UserName")RequestBody userName,
                             @Part("Password")RequestBody password);

    @Multipart
    @POST("api/TaiKhoan/CheckLogin")
    Call<ResultBoolean> UserCheckLogin(@Part("Token")RequestBody token);

    @Multipart
    @POST("api/TaiKhoan/GetUser")
    Call<ResultUser> UserGetUser(@Part("Token")RequestBody token);

}
