package doan.ltn.doan_android.Page.Import;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import doan.ltn.doan_android.Object.DetailTitle;
import doan.ltn.doan_android.R;

public class DetailImportActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,c1,c2,c3,c4,c5,c6,titleForList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contract);
        getSupportActionBar().setTitle("Chi tiết phiếu nhập");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getID();
        getData();
        getEvents();
    }
    public void getID() {
        try {
            t1= (TextView) findViewById(R.id.tt1);
            t2= (TextView) findViewById(R.id.tt2);
            t3= (TextView) findViewById(R.id.tt3);
            t4= (TextView) findViewById(R.id.tt4);
            t5= (TextView) findViewById(R.id.tt5);
            t6= (TextView) findViewById(R.id.tt6);
            c1= (TextView) findViewById(R.id.ct1);
            c2= (TextView) findViewById(R.id.ct2);
            c3= (TextView) findViewById(R.id.ct3);
            c4= (TextView) findViewById(R.id.ct4);
            c5= (TextView) findViewById(R.id.ct5);
            c6= (TextView) findViewById(R.id.ct6);

            DetailTitle detailTitle=new DetailTitle("Thuộc hợp đồng:","Người lập:","Ngày lập:","Người giao:","Ngày hoàn Thành:","ko có");
            setTitle(detailTitle);
            t6.setVisibility(View.GONE);
            c6.setVisibility(View.GONE);
            titleForList=(TextView) findViewById(R.id.titleforlist);

            recyclerView = (RecyclerView) findViewById( R.id.recDetail);
        }
        catch (Exception exception)
        {

        }

    }
    public void getData()
    {
        try
        {

        }
        catch (Exception exception)
        {

        }

    }
    public  void getEvents()
    {
        try
        {

        }
        catch (Exception exception)
        {

        }
    }
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
    public void setTitle(DetailTitle title)
    {
        t1.setText(title.getC1());
        t2.setText(title.getC2());
        t3.setText(title.getC3());
        t4.setText(title.getC4());
        t5.setText(title.getC5());
        t6.setText(title.getC6());

    }


}