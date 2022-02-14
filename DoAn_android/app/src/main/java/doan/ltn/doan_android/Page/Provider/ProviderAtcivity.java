package doan.ltn.doan_android.Page.Provider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import doan.ltn.doan_android.Adapter.ContractAdapter;
import doan.ltn.doan_android.Adapter.ProviderAdapter;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.Contract;
import doan.ltn.doan_android.Object.Provider;
import doan.ltn.doan_android.Page.Contract.ContractActivity;
import doan.ltn.doan_android.Page.Contract.DetailContractActivity;
import doan.ltn.doan_android.R;

public class ProviderAtcivity extends AppCompatActivity {
    ProviderAdapter adapter;
    ArrayList<Provider> list;
    RecyclerView recyclerView;
    CheckBox HoanThanh;
    private RadioButton a1,a2,a4,a3;
    Button btn_sort;
    RadioGroup radioGroup;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);
        getSupportActionBar().setTitle("Nhà Cung Cấp");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getID();
        getData();
        getEvents();
    }
    private void getID() {
        a1=(RadioButton) findViewById(R.id.a1);
        a2=(RadioButton) findViewById(R.id.a2);
        a3=(RadioButton) findViewById(R.id.a3);
        a4=(RadioButton) findViewById(R.id.a4);
        a1.setText("Mã NCC");
        a2.setText("Tên NCC");
        a3.setText("Địa chỉ");
        a4.setText("SDT");
        HoanThanh=(CheckBox) findViewById(R.id.b1);

        recyclerView= (RecyclerView) findViewById(R.id.rec1);
        radioGroup= (RadioGroup) findViewById(R.id.g1);
        radioGroup.check(R.id.a1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        spinner= (Spinner) findViewById(R.id.textinput);
        ArrayAdapter<CharSequence> spinerAdapter=ArrayAdapter.createFromResource(this,R.array.sapxep,R.layout.support_simple_spinner_dropdown_item);
        spinerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinerAdapter);
        list= new ArrayList<>();
    }
    public  void getData()
    {
        try {
            for (int i=0; i<10;i++)
            {
                list.add(new Provider(1,"Nhà cung cấp só "+String.valueOf(i),"Địa chỉ","01234556787","1234567","Ngan",1,"20202020","112312",false));
            }

        }
        catch (Exception exception)
        {}




    }
    public  void getEvents()
    {
       try
       {
           adapter = new ProviderAdapter(list, new ItemClickListener() {
               @Override
               public void onItemClickListener(int i) {

                   Intent intent =new Intent(ProviderAtcivity.this, DetailProviderActivity.class);
                   startActivity(intent);
               }
           });
           recyclerView.setAdapter(adapter);






       }
       catch (Exception exception)
       {

       }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_v1, menu);
        MenuItem menuItem=menu.findItem(R.id.search_bar);

        SearchView searchView=(SearchView) menuItem.getActionView();
        searchView.setQueryHint("Nhập từ khóa");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                // xử lí tìm kiếm
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }



}