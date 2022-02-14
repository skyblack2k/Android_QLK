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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import doan.ltn.doan_android.Adapter.ContractAdapter;
import doan.ltn.doan_android.Interface.APIServices;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.Contract;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelHopDong;
import doan.ltn.doan_android.Object.ResultAPI.ResultListHopDong;
import doan.ltn.doan_android.R;
import doan.ltn.doan_android.Shared.Constants;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContractActivity extends AppCompatActivity {
    ContractAdapter adapter;
    ArrayList<Contract> list;
    RecyclerView recyclerView;
    Spinner spinner;
    Button btn_sort;
    RadioGroup radioGroup;
    private RadioButton a1,a2,a3;
    RadioGroup  rg_Status;
    ArrayAdapter<CharSequence>  spinerAdapter;

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
            recyclerView= (RecyclerView) findViewById(R.id.rec1);
            radioGroup= (RadioGroup) findViewById(R.id.g1);
            //radioGroup.check(R.id.a1);
            rg_Status = (RadioGroup) findViewById(R.id.rg_Status);
            spinner= (Spinner) findViewById(R.id.textinput);
            spinerAdapter=ArrayAdapter.createFromResource(ContractActivity.this,R.array.sapxep,R.layout.dropdown_item);
            spinerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner.setAdapter(spinerAdapter);
            list= new ArrayList<>();
        }
        catch ( Exception exception)
        {

        }
    }

    public void getData()
    {
        //Initialize
        _startTime = null;
        _endTime = null;
        _searchValue = "";
        _searchType = 0;
        _curPage = 1;
        _pageSize = 10;
        _orderBy = 0;
        _isDes = false;
        _status = -1;
        //Show list
        list = new ArrayList<>();
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

    public void getEvents()
    {
        //
        rg_Status.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cb_Status_CHT:
                        _status = 0;
                        break;
                    case R.id.cb_Status_HT:
                        _status = 1;
                        break;
                    default:
                        _status = -1;
                        break;
                }
                Toast.makeText(ContractActivity.this, String.valueOf(_status), Toast.LENGTH_LONG).show();
                Search();
            }
        });
        //
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                _isDes = position == 0? false: true;
                Search();
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
                _searchValue = s;
                Toast.makeText(ContractActivity.this, "Keyword: " + _searchValue, Toast.LENGTH_LONG).show();
                Search();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //Toast.makeText(ContractActivity.this, "Keyword: " + s, Toast.LENGTH_LONG);
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
            RequestBody nccID = RequestBody.create(Constants.TEXT, String.valueOf(Constants.NhaCungCapID));

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
            RequestBody status = RequestBody.create(Constants.TEXT, String.valueOf(_status));

            APIServices.apiservices.HopDong_SearchPaging(token, htID, nccID,
                    startTime, endTime,
                    searchValue, searchType, curPage, pageSize, orderBy, isDes, status).enqueue(new Callback<ResultListHopDong>() {
                @Override
                public void onResponse(Call<ResultListHopDong> call, Response<ResultListHopDong> response) {
                    try{
                        list.clear();
                        ResultListHopDong rs = response.body();
                        List<ModelHopDong> listHD = rs.getDataField();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm dd/MM/yyyy");
                        for(ModelHopDong item : listHD){
                            list.add(new Contract(item.getIdField(), item.getHoTenField(), item.getTenNCCField(), item.getHeThongIDField(), item.getNgayLapField()));
                        }
                        RefreshList();
                    }
                    catch (Exception ex){
                        Toast.makeText(ContractActivity.this, "Có lỗi xảy ra trong quá trình nhận dữ liệu!", Toast.LENGTH_LONG);
                    }
                }

                @Override
                public void onFailure(Call<ResultListHopDong> call, Throwable t) {
                    Toast.makeText(ContractActivity.this, "Có lỗi xảy ra trong quá trình gửi yêu cầu!", Toast.LENGTH_LONG);
                }
            });
        }
        catch (Exception ex){
            Toast.makeText(ContractActivity.this, "Vui lòng kiểm tra đầu vào và thử lại!", Toast.LENGTH_LONG).show();
        }
    }

    void RefreshList(){
        adapter.notifyDataSetChanged();
    }
}