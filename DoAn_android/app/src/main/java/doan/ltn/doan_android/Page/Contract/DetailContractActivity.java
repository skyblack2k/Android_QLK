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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import doan.ltn.doan_android.Adapter.CTHDAdapter;
import doan.ltn.doan_android.Adapter.ContractAdapter;
import doan.ltn.doan_android.Interface.APIServices;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.DetailTitle;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelCTHD;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelHopDong;
import doan.ltn.doan_android.Object.ResultAPI.ResultListCTHD;
import doan.ltn.doan_android.R;
import doan.ltn.doan_android.Shared.Constants;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailContractActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,c1,c2,c3,c4,c5,c6,titleForList;
    RecyclerView recyclerView;
    ModelHopDong detailObj;
    CTHDAdapter adapterCTHD;
    ArrayList<ModelCTHD> listCTHD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contract);
        getSupportActionBar().setTitle("Chi tiết hợp đồng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getID();
        getData();
        getEvents();
    }

    public void getID() {
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
        t6.setVisibility(View.GONE);
        c6.setVisibility(View.GONE);
        titleForList=(TextView) findViewById(R.id.titleforlist);

        recyclerView = (RecyclerView) findViewById( R.id.recDetail);
    }

    public void getData()
    {
        try{
            Intent intent = getIntent();
            detailObj = (ModelHopDong) intent.getExtras().getSerializable("DetailObj");
            c1.setText(detailObj.getTenNCCField());
            c2.setText(detailObj.getHoTenField());
            t3.setText("Tên hệ thống: ");
            c3.setText(detailObj.getTenHTField());
            c4.setText(detailObj.getNgayLapField());
            if(detailObj.getTrangThaiField() == 0){
                c5.setText("Chưa hoàn thành");
            }
            else{
                c5.setText("Đã hoàn thành");
            }
            c6.setVisibility(View.GONE);

            //API
            listCTHD = new ArrayList<>();
            recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
            adapterCTHD = new CTHDAdapter(listCTHD, new ItemClickListener() {
                @Override
                public void onItemClickListener(int i) {
                    //
                }
            });
            recyclerView.setAdapter(adapterCTHD);
            Search();
        }
        catch (Exception ex){
            Toast.makeText(DetailContractActivity.this, "Có lỗi xảy ra trong quá trình hiển thị dữ liệu!", Toast.LENGTH_LONG).show();
        }
    }

    public  void getEvents()
    {

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

    private void Search(){
        try{
            RequestBody token = RequestBody.create(Constants.TEXT, Constants.Token);
            RequestBody id = RequestBody.create(Constants.TEXT, String.valueOf(detailObj.getIdField()));

            APIServices.apiservices.HopDong_GetListCTHD(token, id).enqueue(new Callback<ResultListCTHD>() {
                @Override
                public void onResponse(Call<ResultListCTHD> call, Response<ResultListCTHD> response) {
                    listCTHD.clear();
                    try{
                        ResultListCTHD rs = response.body();
                        List<ModelCTHD> rsListCTHD = rs.getDataField();
                        if(rsListCTHD != null){
                            for(ModelCTHD item : rsListCTHD){
                                listCTHD.add(item);
                            }
                        }
                        else{
                            Toast.makeText(DetailContractActivity.this, "Không tìm thấy dữ liệu phù hợp!", Toast.LENGTH_LONG).show();
                        }
                    }
                    catch (Exception ex) {
                        Toast.makeText(DetailContractActivity.this, "Có lỗi xảy ra trong quá trình nhận dữ liệu!", Toast.LENGTH_LONG).show();
                    }

                    RefreshList();
                }

                @Override
                public void onFailure(Call<ResultListCTHD> call, Throwable t) {
                    Toast.makeText(DetailContractActivity.this, "Có lỗi xảy ra trong quá trình gửi yêu cầu!", Toast.LENGTH_LONG).show();
                }
            });
        }
        catch (Exception ex){
            Toast.makeText(DetailContractActivity.this, "Vui lòng kiểm tra đầu vào và thử lại!", Toast.LENGTH_LONG).show();
        }
    }

    private void RefreshList(){
        adapterCTHD.notifyDataSetChanged();
    }
}