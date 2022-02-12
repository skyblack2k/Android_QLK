package doan.ltn.doan_android.Page;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import doan.ltn.doan_android.Adapter.ContractAdapter;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.Contract;
import doan.ltn.doan_android.R;

public class ProviderAtcivity extends AppCompatActivity {
    ContractAdapter adapter;
    ArrayList<Contract> list;
    RecyclerView recyclerView;
    SearchView searchView;
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
        recyclerView= (RecyclerView) findViewById(R.id.rec1);
        radioGroup= (RadioGroup) findViewById(R.id.g1);
        searchView =(SearchView) findViewById(R.id.searchView);
        btn_sort =(Button) findViewById(R.id.sort);
        list= new ArrayList<>();
    }
    public  void getData()
    {

        for (int i=0; i<10;i++)
        {
            list.add(new Contract(i,"Nguyễn Văn ","Nhà cung cấp số"+String.valueOf(i),i,"20/10/2000") );
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        adapter = new ContractAdapter(list, new ItemClickListener() {
            @Override
            public void onItemClickListener(int i) {

                Toast.makeText(ProviderAtcivity.this,String.valueOf(i),Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(adapter);

    }
    public  void getEvents()
    {
        radioGroup.check(R.id.a1);
    }

}