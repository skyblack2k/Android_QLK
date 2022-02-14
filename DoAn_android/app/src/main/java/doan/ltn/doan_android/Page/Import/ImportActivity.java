package doan.ltn.doan_android.Page.Import;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import doan.ltn.doan_android.Adapter.ContractAdapter;
import doan.ltn.doan_android.Adapter.ImportAdapter;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.Contract;
import doan.ltn.doan_android.Object.Import;
import doan.ltn.doan_android.R;

public class ImportActivity extends AppCompatActivity {
    ImportAdapter adapter;
    ArrayList<Import> listImport;
    RecyclerView recyclerView;
    Button btn_sort;
    RadioGroup radioGroup;
    CheckBox HoanThanh;
    private RadioButton a1,a2,a4,a3;

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
        a1.setText("Mã PN");
        a2.setText("Mã HĐ");
        a3.setText("Người lập");
        a4.setText("Người duyệt");
        HoanThanh=(CheckBox) findViewById(R.id.b1);

        recyclerView= (RecyclerView) findViewById(R.id.rec1);
        radioGroup= (RadioGroup) findViewById(R.id.g1);
        radioGroup.check(R.id.a1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        listImport= new ArrayList<>();
    }
    public  void getData()
    {

        for (int i=0; i<10;i++)
        {
         listImport.add(new Import(i,"Lưu Văn Nợi","20/02/2020",1,1,false  ));
        }



    }
    public  void getEvents()
    {

        adapter=new ImportAdapter(listImport, new ItemClickListener() {
            @Override
            public void onItemClickListener(int i) {

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