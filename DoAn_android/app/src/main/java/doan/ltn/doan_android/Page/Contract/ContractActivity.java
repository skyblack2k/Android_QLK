package doan.ltn.doan_android.Page.Contract;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import doan.ltn.doan_android.Adapter.ContractAdapter;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.Contract;
import doan.ltn.doan_android.R;

public class ContractActivity extends AppCompatActivity {
    ContractAdapter adapter;
    ArrayList<Contract> list;
    RecyclerView recyclerView;
    Spinner spinner;
    Button btn_sort;
    RadioGroup radioGroup;
    private RadioButton a1,a2,a3,a4;
    ArrayAdapter<CharSequence>  spinerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);
        getSupportActionBar().setTitle("Hợp Đồng");
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
            a4=(RadioButton) findViewById(R.id.a4);
            a4.setVisibility(View.INVISIBLE);
            recyclerView= (RecyclerView) findViewById(R.id.rec1);
            radioGroup= (RadioGroup) findViewById(R.id.g1);
            radioGroup.check(R.id.a1);
            spinner= (Spinner) findViewById(R.id.textinput);
            spinerAdapter=ArrayAdapter.createFromResource(ContractActivity.this,R.array.sapxep,R.layout.support_simple_spinner_dropdown_item);
            spinerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner.setAdapter(spinerAdapter);
            list= new ArrayList<>();
        }
        catch ( Exception exception)
        {

        }

    }
    public  void getData()
    {


        try {
            for (int i=0; i<10;i++)
            {
                list.add(new Contract(i,"Nguyễn Văn ","Nhà cung cấp số"+String.valueOf(i),i,"20/10/2000") );
            }

            recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
            adapter = new ContractAdapter(list, new ItemClickListener() {
                @Override
                public void onItemClickListener(int i) {

                    Intent intent =new Intent(ContractActivity.this,DetailContractActivity.class);
                    startActivity(intent);
                }
            });
            recyclerView.setAdapter(adapter);
        }
        catch (Exception exception)
        {

        }



    }


    public  void getEvents()
    {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ContractActivity.this, spinerAdapter.getItem(position).toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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