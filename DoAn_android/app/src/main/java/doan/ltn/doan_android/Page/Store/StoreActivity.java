package doan.ltn.doan_android.Page.Store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import doan.ltn.doan_android.Adapter.ContractAdapter;
import doan.ltn.doan_android.Adapter.ProductAdapter;
import doan.ltn.doan_android.Adapter.ProviderAdapter;
import doan.ltn.doan_android.Adapter.StoreAdapter;
import doan.ltn.doan_android.Interface.APIServices;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.Contract;
import doan.ltn.doan_android.Object.Provider;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelCuaHang;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelHopDong;
import doan.ltn.doan_android.Object.ResultAPI.ResultListCuaHang;
import doan.ltn.doan_android.Object.ResultAPI.ResultListHopDong;
import doan.ltn.doan_android.Object.Store;
import doan.ltn.doan_android.Page.Contract.ContractActivity;
import doan.ltn.doan_android.Page.Contract.DetailContractActivity;
import doan.ltn.doan_android.Page.Provider.ProviderAtcivity;
import doan.ltn.doan_android.R;
import doan.ltn.doan_android.Shared.Constants;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreActivity extends AppCompatActivity {
    StoreAdapter adapter;
    ArrayList<ModelCuaHang> list;
    RecyclerView recyclerView;
    CheckBox HoanThanh;
    private RadioButton a1,a2,a4,a3;
    Button btn_sort;
    RadioGroup radioGroup;
    private Spinner spinner;
    TextView lb_Status;
    RadioGroup rg_Status;

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
        setContentView(R.layout.activity_contract);
        getSupportActionBar().setTitle("Cửa Hàng");
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
        a1.setText("Mã CH");
        a2.setText("Tên CH");
        a3.setText("Địa chỉ");

        recyclerView= (RecyclerView) findViewById(R.id.rec1);
        radioGroup= (RadioGroup) findViewById(R.id.g1);
        //radioGroup.check(R.id.a1);

        lb_Status = (TextView) findViewById(R.id.textView4);
        lb_Status.setVisibility(View.INVISIBLE);
        rg_Status = (RadioGroup) findViewById(R.id.rg_Status);
        rg_Status.setVisibility(View.INVISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        spinner= (Spinner) findViewById(R.id.textinput);
        ArrayAdapter<CharSequence> spinerAdapter=ArrayAdapter.createFromResource(this,R.array.sapxep,R.layout.support_simple_spinner_dropdown_item);
        spinerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinerAdapter);
        list= new ArrayList<>();
    }
    public  void getData()
    {
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
    }

    public  void getEvents()
    {
        adapter = new StoreAdapter(list, new ItemClickListener() {
            @Override
            public void onItemClickListener(int i) {
                Intent intent =new Intent(StoreActivity.this, DetailStoreActivity.class);
                intent.putExtra("DetailObj", list.get(i));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

        Search();
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

    private void Search(){
        try{
            switch (radioGroup.getCheckedRadioButtonId()){
                case R.id.a1:
                    _searchType = 1;
                    break;
                case R.id.a2:
                    _searchType = 2;
                    break;
                case R.id.a3:
                    _searchType = 3;
                    break;
                default:
                    _searchType = 0;
            }

            RequestBody token = RequestBody.create(Constants.TEXT, Constants.Token);
            RequestBody htID = RequestBody.create(Constants.TEXT, String.valueOf(Constants.HeThongID));

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

            APIServices.apiservices.CuaHang_SearchPaging(token, htID, startTime, endTime,
                    searchValue, searchType, curPage, pageSize, orderBy, isDes).enqueue(new Callback<ResultListCuaHang>() {
                @Override
                public void onResponse(Call<ResultListCuaHang> call, Response<ResultListCuaHang> response) {
                    try{
                        list.clear();
                        ResultListCuaHang rs = response.body();
                        List<ModelCuaHang> listCH = rs.getDataField();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm dd/MM/yyyy");
                        if(listCH != null){
                            for(ModelCuaHang item : listCH){
                                list.add(item);
                            }
                        }
                        else{
                            Toast.makeText(StoreActivity.this, "Không tìm thấy dữ liệu phù hợp!", Toast.LENGTH_LONG);
                        }
                        RefreshList();
                    }
                    catch (Exception ex){
                        Toast.makeText(StoreActivity.this, "Có lỗi xảy ra trong quá trình nhận dữ liệu!", Toast.LENGTH_LONG);
                    }
                }

                @Override
                public void onFailure(Call<ResultListCuaHang> call, Throwable t) {
                    Toast.makeText(StoreActivity.this, "Có lỗi xảy ra trong quá trình gửi yêu cầu!", Toast.LENGTH_LONG);
                }
            });
        }
        catch (Exception ex){
            Toast.makeText(StoreActivity.this, "Vui lòng kiểm tra đầu vào và thử lại!", Toast.LENGTH_LONG).show();
        }
    }

    void RefreshList(){
        adapter.notifyDataSetChanged();
    }
}