package doan.ltn.doan_android.Page.Provider;

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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import doan.ltn.doan_android.Adapter.CTHDAdapter;
import doan.ltn.doan_android.Adapter.ProductAdapter;
import doan.ltn.doan_android.Adapter.ProductNCCAdapter;
import doan.ltn.doan_android.Interface.APIServices;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.DetailTitle;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelCuaHang;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelMatHang;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelMatHangHT;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelNCC;
import doan.ltn.doan_android.Object.ResultAPI.ResultListMatHang;
import doan.ltn.doan_android.Object.ResultAPI.ResultListMatHangHT;
import doan.ltn.doan_android.Page.Store.DetailStoreActivity;
import doan.ltn.doan_android.R;
import doan.ltn.doan_android.Shared.Constants;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailProviderActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,c1,c2,c3,c4,c5,c6,c7,c8,c9,titleForList;
    RecyclerView recyclerView;
    ModelNCC detailObj;
    ProductNCCAdapter adapterMH;
    ArrayList<ModelMatHang> listMH;

    //Param for search
    Date _startTime;
    Date _endTime;
    String _searchValue;
    int _searchType;
    int _curPage;
    int _pageSize;
    int _orderBy;
    boolean _isDes;
    int _status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_provider);
        getSupportActionBar().setTitle("Chi tiết nhà cung cấp");
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
            t7= (TextView) findViewById(R.id.tt7);
            t8= (TextView) findViewById(R.id.tt8);
            t9= (TextView) findViewById(R.id.tt9);
            c1= (TextView) findViewById(R.id.ct1);
            c2= (TextView) findViewById(R.id.ct2);
            c3= (TextView) findViewById(R.id.ct3);
            c4= (TextView) findViewById(R.id.ct4);
            c5= (TextView) findViewById(R.id.ct5);
            c6= (TextView) findViewById(R.id.ct6);
            c7= (TextView) findViewById(R.id.ct7);
            c8= (TextView) findViewById(R.id.ct8);
            c9= (TextView) findViewById(R.id.ct9);

            DetailTitle detailTitle=new DetailTitle("Tên NCC:","SDT:","STK","Ngân hàng:","Đại diện:","Tên hệ thống:","Ngày Tạo:","Ngày cập nhật:","Địa chỉ:");
            setTitle(detailTitle);
            titleForList=(TextView) findViewById(R.id.titleforlist);
            recyclerView = (RecyclerView) findViewById( R.id.recDetail);
        }
        catch (Exception exception)
        {

        }
    }

    public void getData()
    {
        try{
            Intent intent = getIntent();
            detailObj = (ModelNCC) intent.getExtras().getSerializable("DetailObj");
            c1.setText(detailObj.getTenField());
            c2.setText(detailObj.getSDTField());
            c3.setText(detailObj.getSTKField());
            c4.setText(detailObj.getNganHangField());
            c5.setText(detailObj.getHoTenField() + " (" + detailObj.getUserNameField() + ")");
            c6.setText(detailObj.getNgayTaoField());
            c7.setText(detailObj.getNgayCapNhatField());
            c8.setText(detailObj.getDiaChiField());

            //API
            //Initialize
            _startTime = null;
            _endTime = null;
            _searchValue = "";
            _searchType = 0;
            _curPage = 1;
            _pageSize = 20;
            _orderBy = 0;
            _isDes = false;
            _status = -1;
            //Show list
            listMH = new ArrayList<>();
            recyclerView.setLayoutManager(new LinearLayoutManager(DetailProviderActivity.this, RecyclerView.VERTICAL,false));
            adapterMH = new ProductNCCAdapter(listMH, new ItemClickListener() {
                @Override
                public void onItemClickListener(int i) {
                    //
                }
            });
            recyclerView.setAdapter(adapterMH);

            Search();
        }
        catch (Exception ex){
            Toast.makeText(DetailProviderActivity.this, "Có lỗi xảy ra trong quá trình hiển thị dữ liệu!", Toast.LENGTH_LONG).show();
        }
    }

    public  void getEvents()
    {
        try {

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
        try {
            t1.setText(title.getC1());
            t2.setText(title.getC2());
            t3.setText(title.getC3());
            t4.setText(title.getC4());
            t5.setText(title.getC5());
            t6.setText(title.getC6());
            t7.setText(title.getC7());
            t8.setText(title.getC8());
            t9.setText(title.getC9());
        }
        catch (Exception exception)
        {

        }
    }

    private void Search(){
        try{
            RequestBody token = RequestBody.create(Constants.TEXT, Constants.Token);
            RequestBody htID = RequestBody.create(Constants.TEXT, String.valueOf(detailObj.getIdField()));

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strStartTime = "", strEndTime = "";
            if(_startTime != null){
                strStartTime = dateFormat.format(_startTime);
            }
            if(_endTime != null){
                strEndTime = dateFormat.format(_endTime);
            }
            RequestBody startTime = RequestBody.create(Constants.TEXT, strStartTime);
            RequestBody endTime = RequestBody.create(Constants.TEXT, strEndTime);

            RequestBody searchValue = RequestBody.create(Constants.TEXT, _searchValue);
            RequestBody searchType = RequestBody.create(Constants.TEXT, String.valueOf(_searchType));
            RequestBody curPage = RequestBody.create(Constants.TEXT, String.valueOf(_curPage));
            RequestBody pageSize = RequestBody.create(Constants.TEXT, String.valueOf(_pageSize));
            RequestBody orderBy = RequestBody.create(Constants.TEXT, String.valueOf(_orderBy));
            RequestBody isDes = RequestBody.create(Constants.TEXT, String.valueOf(_isDes));

            APIServices.apiservices.MatHang_SearchPagingNCC(token, htID, startTime, endTime,
                    searchValue, searchType, curPage, pageSize, orderBy, isDes).enqueue(new Callback<ResultListMatHang>() {
                @Override
                public void onResponse(Call<ResultListMatHang> call, Response<ResultListMatHang> response) {
                    listMH.clear();
                    try{
                        ResultListMatHang rs = response.body();
                        List<ModelMatHang> _listMH = rs.getDataField();
                        if(_listMH != null){
                            for(ModelMatHang item : _listMH){
                                listMH.add(item);
                            }
                        }
                        else{
                            Toast.makeText(DetailProviderActivity.this, "Không tìm thấy dữ liệu phù hợp!", Toast.LENGTH_LONG).show();
                        }
                    }
                    catch (Exception ex) {
                        Toast.makeText(DetailProviderActivity.this, "Có lỗi xảy ra trong quá trình nhận dữ liệu!", Toast.LENGTH_LONG).show();
                    }

                    RefreshList();
                }

                @Override
                public void onFailure(Call<ResultListMatHang> call, Throwable t) {
                    Toast.makeText(DetailProviderActivity.this, "Có lỗi xảy ra trong quá trình gửi yêu cầu!", Toast.LENGTH_LONG).show();
                }
            });
        }
        catch (Exception ex){
            Toast.makeText(DetailProviderActivity.this, "Vui lòng kiểm tra đầu vào và thử lại!", Toast.LENGTH_LONG).show();
        }
    }

    private void RefreshList(){
        adapterMH.notifyDataSetChanged();
    }
}