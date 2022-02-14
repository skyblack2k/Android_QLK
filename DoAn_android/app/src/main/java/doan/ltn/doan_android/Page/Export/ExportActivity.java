package doan.ltn.doan_android.Page.Export;

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
import doan.ltn.doan_android.Adapter.ExportAdapter;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.Contract;
import doan.ltn.doan_android.Object.Export;
import doan.ltn.doan_android.Page.Contract.ContractActivity;
import doan.ltn.doan_android.Page.Contract.DetailContractActivity;
import doan.ltn.doan_android.R;

public class ExportActivity extends AppCompatActivity {
    ExportAdapter adapter;
    ArrayList<Export> listExport;
    RecyclerView recyclerView;
    Button btn_sort;
    RadioGroup radioGroup;
    CheckBox HoanThanh;
    RadioButton a1,a2,a3;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);

        getSupportActionBar().setTitle("Phiếu Xuất");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getID();
        getData();
        getEvents();
    }
    private void getID() {
        try {
            a1=(RadioButton) findViewById(R.id.a1);
            a2=(RadioButton) findViewById(R.id.a2);
            a3=(RadioButton) findViewById(R.id.a3);
            a1.setText("Mã PX");
            a2.setText("Cửa hàng");
            a3.setText("Người lập");
            recyclerView= (RecyclerView) findViewById(R.id.rec1);
            radioGroup= (RadioGroup) findViewById(R.id.g1);
            recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
            spinner= (Spinner) findViewById(R.id.textinput);
            ArrayAdapter<CharSequence> spinerAdapter=ArrayAdapter.createFromResource(this,R.array.sapxep,R.layout.support_simple_spinner_dropdown_item);
            spinerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner.setAdapter(spinerAdapter);

            listExport= new ArrayList<>();
            radioGroup.check(R.id.a1);
        }
        catch (Exception exception)
        {}

    }
    public  void getData()
    {
        for (int i=0; i<10;i++)
        {
            listExport.add(new Export(i,"14/02/2020","14/02/2020","14/02/2022",1,1,1,false));
        }


    }
    public  void getEvents()
    {
        adapter=new ExportAdapter(listExport, new ItemClickListener() {
            @Override
            public void onItemClickListener(int i) {
                Intent intent =new Intent(ExportActivity.this, DetailExportActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
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