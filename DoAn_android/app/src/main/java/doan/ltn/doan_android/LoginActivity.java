package doan.ltn.doan_android;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import doan.ltn.doan_android.Interface.APIServices;
import doan.ltn.doan_android.Object.ResultAPI.ResultLogin;
import doan.ltn.doan_android.Object.User;
import doan.ltn.doan_android.Object.test;
import doan.ltn.doan_android.Page.ContractActivity;
import doan.ltn.doan_android.databinding.ActivityLoginBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button Login = (Button) findViewById(R.id.login);
        EditText name= findViewById(R.id.username);
        EditText pass=findViewById(R.id.password);

        Login.setOnClickListener(v ->
        {
            Intent intent =new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

        });

    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);


    }

}