package doan.ltn.doan_android.Interface;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import doan.ltn.doan_android.Object.ResultAPI.ResultLogin;
import doan.ltn.doan_android.Object.test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIServices {
    Gson gson= new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APIServices apiservices= new Retrofit.Builder().baseUrl("http://192.168.1.179:44361/").
            addConverterFactory(GsonConverterFactory.create(gson)).build().create(APIServices.class);



    @POST("api/TaiKhoan/Login")
    Call<ResultLogin> Login(@Query("UserName") String UserName,@Query("Password") String Pasword);
}
