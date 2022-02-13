package doan.ltn.doan_android.Shared;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import doan.ltn.doan_android.Interface.APIServices;
import doan.ltn.doan_android.LoginActivity;
import doan.ltn.doan_android.Object.ResultAPI.ResultString;
import doan.ltn.doan_android.ProcessUI.ProcessBar;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SharedFunction {
    public static ProcessBar processBar = new ProcessBar();
    public static void ShowProcessBar(Context context){
        processBar.CreateProcessBar(context);
    }
    public static void HideProcessBar(){
        processBar.end();
    }

}
