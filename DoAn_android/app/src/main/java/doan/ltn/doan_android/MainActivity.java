package doan.ltn.doan_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import doan.ltn.doan_android.Fragment.Home.HomeFragment;
import doan.ltn.doan_android.Fragment.Product.ProductFragment;
import doan.ltn.doan_android.Fragment.Setting.SettingFragment;
import doan.ltn.doan_android.Fragment.User.UserFagment;
import doan.ltn.doan_android.Interface.APIServices;
import doan.ltn.doan_android.Object.ResultAPI.ResultBoolean;
import doan.ltn.doan_android.Object.ResultAPI.ResultString;
import doan.ltn.doan_android.Object.ResultAPI.ResultUser;
import doan.ltn.doan_android.Shared.Constants;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Multipart;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.button_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.subactivity, new HomeFragment()).commit();

        //CheckLogin
        RequestBody token = RequestBody.create(Constants.TEXT, Constants.Token);
        APIServices.apiservices.UserCheckLogin(token).enqueue(new Callback<ResultBoolean>() {
            @Override
            public void onResponse(Call<ResultBoolean> call, Response<ResultBoolean> response) {
                ResultBoolean rs = response.body();
                if(response.isSuccessful()){
                    if(rs != null)
                        if(rs.getErrCodeField() == 2){
                            if(!rs.isDataField()) {
                                //Chưa đăng nhập
                                Toast.makeText(MainActivity.this, "Phiên đăng nhập hết hạn!", Toast.LENGTH_LONG).show();
                                MainActivity.this.finish();
                            }
                            else{
                                //Get user info
                                RequestBody token = RequestBody.create(Constants.TEXT, Constants.Token);
                                APIServices.apiservices.UserGetUser(token).enqueue(new Callback<ResultUser>() {
                                    @Override
                                    public void onResponse(Call<ResultUser> call, Response<ResultUser> response) {
                                        ResultUser rs = response.body();
                                        if(response.isSuccessful()){
                                            if(rs != null)
                                                if(rs.getErrCodeField() == 2){
                                                    Constants.UserName = rs.getDataField().getUserNameField();
                                                    Constants.Name = rs.getDataField().getHoTenField();
                                                    Constants.RoleID = rs.getDataField().getPhanQuyenIDField();
                                                    Constants.RoleName = rs.getDataField().getPhanQuyenField();
                                                }
                                                else{
                                                    Toast.makeText(MainActivity.this, "Null reponse! " , Toast.LENGTH_LONG).show();
                                                }
                                        }
                                        else{
                                            Toast.makeText(MainActivity.this, "Response error: " + response.code() + " " + response.message(), Toast.LENGTH_LONG).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<ResultUser> call, Throwable t) {
                                        Toast.makeText(MainActivity.this, "Fail call: " + t.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Null reponse! " , Toast.LENGTH_LONG).show();
                        }
                }
                else{
                    Toast.makeText(MainActivity.this, "Response error: " + response.code() + " " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResultBoolean> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail call: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.home_nav:
                        fragment = new HomeFragment();
                        break;
                    case R.id.storage_nav:
                        fragment = new ProductFragment();

                        break;
                    case R.id.customer_nav:
                        fragment = new UserFagment();
                        break;

                    case R.id.setting_nav:
                        fragment = new SettingFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.subactivity, fragment).commit();


                return true;
            }
        });
    }

}