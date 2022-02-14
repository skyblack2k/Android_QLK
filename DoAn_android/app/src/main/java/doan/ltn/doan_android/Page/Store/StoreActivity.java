package doan.ltn.doan_android.Page.Store;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import doan.ltn.doan_android.Adapter.ContractAdapter;
import doan.ltn.doan_android.Adapter.ProviderAdapter;
import doan.ltn.doan_android.Adapter.StoreAdapter;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.Contract;
import doan.ltn.doan_android.Object.Provider;
import doan.ltn.doan_android.Object.Store;
import doan.ltn.doan_android.Page.Provider.ProviderAtcivity;
import doan.ltn.doan_android.R;

public class StoreActivity extends AppCompatActivity {
    StoreAdapter adapter;
    ArrayList<Store> list;
    RecyclerView recyclerView;
    CheckBox HoanThanh;
    private RadioButton a1,a2,a4,a3;
    Button btn_sort;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);
        getID();
        getData();
        getEvents();
    }
    private void getID() {
        a1=(RadioButton) findViewById(R.id.a1);
        a2=(RadioButton) findViewById(R.id.a2);
        a3=(RadioButton) findViewById(R.id.a3);
        a4=(RadioButton) findViewById(R.id.a4);
        a1.setText("Mã CH");
        a2.setText("Tên CH");
        a3.setText("Địa chỉ");
        a4.setText("SDT");
        HoanThanh=(CheckBox) findViewById(R.id.b1);

        recyclerView= (RecyclerView) findViewById(R.id.rec1);
        radioGroup= (RadioGroup) findViewById(R.id.g1);
        radioGroup.check(R.id.a1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        list= new ArrayList<>();
    }
    public  void getData()
    {

        for (int i=0; i<10;i++)
        {
            list.add(new Store(1,"Nhà cung cấp só "+String.valueOf(i),"Địa chỉ","01234556787","1234567",1,"23123","20202020",1,false));
        }



    }
    public  void getEvents()
    {

        adapter = new StoreAdapter(list, new ItemClickListener() {
            @Override
            public void onItemClickListener(int i) {

            }
        });
        recyclerView.setAdapter(adapter);
    }

}