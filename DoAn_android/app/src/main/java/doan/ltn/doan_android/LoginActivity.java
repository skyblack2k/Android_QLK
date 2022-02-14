package doan.ltn.doan_android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import doan.ltn.doan_android.Interface.APIServices;
import doan.ltn.doan_android.Object.ResultAPI.ResultString;
import doan.ltn.doan_android.Shared.Constants;
import doan.ltn.doan_android.Shared.SharedFunction;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
        TextView btn_signup;
        EditText txt_UserName;
        Button Login;
        EditText txt_Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getID();
        getEvents();


    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);


    }

    public void getID()
    {
        try
        {
            btn_signup = (TextView) findViewById(R.id.btn_signup);
            Login = (Button) findViewById(R.id.login);
            txt_UserName= findViewById(R.id.username);
            txt_Password=findViewById(R.id.password);

            txt_UserName.setText("quanly_1");
            txt_Password.setText("matkhau");
        }
        catch(Exception exception)
        {
            //
        }
    }

    public  void  getEvents()
    {
        btn_signup.setOnClickListener(v -> {
            try
            {
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
            }
            catch (Exception exception)
            {}
        });

        Login.setOnClickListener(v ->
        {
            SharedFunction.ShowProcessBar(LoginActivity.this);
            String userName = txt_UserName.getText().toString();
            String password = txt_Password.getText().toString();
            RequestBody rqUserName = RequestBody.create(MediaType.parse("text/plain"), userName);
            RequestBody rqPassword = RequestBody.create(MediaType.parse("text/plain"), password);

            APIServices.apiservices.User_Login(rqUserName, rqPassword).enqueue(new Callback<ResultString>() {
                @Override
                public void onResponse(Call<ResultString> call, Response<ResultString> response) {
                    SharedFunction.HideProcessBar();
                    ResultString rs = response.body();
                    if(response.isSuccessful()){
                        if(rs != null)
                            if(rs.getErrCodeField() == 2){
                                Constants.Token = rs.getDataField();
                                Toast.makeText(LoginActivity.this, Constants.Token, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(LoginActivity.this, "Null reponse! " , Toast.LENGTH_LONG).show();
                            }
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Response error: " + response.code() + " " + response.message(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<ResultString> call, Throwable t) {
                    SharedFunction.HideProcessBar();
                    Toast.makeText(LoginActivity.this, "Fail call: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}