package doan.ltn.doan_android.Fragment.User;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import doan.ltn.doan_android.Adapter.ProductAdapter;
import doan.ltn.doan_android.Adapter.UserAdapter;
import doan.ltn.doan_android.Interface.APIServices;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.Product;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelUser;
import doan.ltn.doan_android.Object.ResultAPI.ResultListUser;
import doan.ltn.doan_android.R;
import doan.ltn.doan_android.Shared.Constants;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserFagment extends Fragment {


    private Spinner spinnerSort, spinnerRole;
    private ArrayAdapter<CharSequence> spinerAdapterSort, spinerAdapterRole;
    private RadioButton a1, a2, a3, a4;
    private RecyclerView recyclerView;
    private RadioGroup radioGroup;
    private TextView sortTitle;
    private UserAdapter adapterUser;
    private ArrayList<ModelUser> listUser;
    private SearchView txt_Keyword;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        getID(view);
        getData();
        getEvents();
        return view;
    }

    public void getID(View view) {
        try {

            a1 = (RadioButton) view.findViewById(R.id.a1);
            a2 = (RadioButton) view.findViewById(R.id.a2);
            a3 = (RadioButton) view.findViewById(R.id.a3);
            a4 = (RadioButton) view.findViewById(R.id.a4);
            a4.setVisibility(View.INVISIBLE);
            sortTitle=(TextView) view.findViewById(R.id.textView);
            recyclerView = (RecyclerView) view.findViewById(R.id.rec1);
            radioGroup = (RadioGroup) view.findViewById(R.id.g1);
            //radioGroup.check(R.id.a1);
            spinnerRole = (Spinner) view.findViewById(R.id.textinput2);
            spinnerSort = (Spinner) view.findViewById(R.id.textinput);
            spinerAdapterSort = ArrayAdapter.createFromResource(view.getContext(), R.array.sapxep, R.layout.dropdown_item);
            spinerAdapterSort.setDropDownViewResource(R.layout.dropdown_item);
            spinnerSort.setAdapter(spinerAdapterSort);
            spinerAdapterRole = ArrayAdapter.createFromResource(view.getContext(), R.array.role, R.layout.dropdown_item);
            spinerAdapterRole.setDropDownViewResource(R.layout.dropdown_item);
            spinnerRole.setAdapter(spinerAdapterRole);

            txt_Keyword = (SearchView)view.findViewById(R.id.searchProduct);

            a1.setText("ID");
            a2.setText("Tên tài khoản");
            a3.setText("SDT");

            listUser = new ArrayList<>();
        } catch (Exception exception) {

        }
    }

    public void getData() {
        try {
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
            listUser = new ArrayList<>();
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
            adapterUser = new UserAdapter(listUser, new ItemClickListener() {
                @Override
                public void onItemClickListener(int i) {
                    //
                }
            });
            recyclerView.setAdapter(adapterUser);

            Search();
        } catch (Exception exception) {

        }
    }

    public void getEvents() {
        try {
            txt_Keyword.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    _searchValue = query;
                    Search();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });

            spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    _isDes = position == 0? false: true;
                    Search();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    //
                }
            });

            spinnerRole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0:
                            _status = -1;
                            break;
                        case 1:
                            _status = 1;
                            break;
                        case 2:
                            _status = 2;
                            break;
                        case 3:
                            _status = 3;
                            break;
                        case 4:
                            _status = 4;
                            break;
                        default:
                            //
                            break;
                    }
                    Search();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    //
                }
            });
        } catch (Exception exception) {
            //
        }
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
                    _searchType = 5;
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
            RequestBody status = RequestBody.create(Constants.TEXT, String.valueOf(_status));

            APIServices.apiservices.User_SearchPaging(token, htID, startTime, endTime,
                    searchValue, searchType, curPage, pageSize, orderBy, isDes, status).enqueue(new Callback<ResultListUser>() {
                @Override
                public void onResponse(Call<ResultListUser> call, Response<ResultListUser> response) {
                    try{
                        listUser.clear();
                        ResultListUser rs = response.body();
                        List<ModelUser> _listUser = rs.getDataField();
                        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddThh:mm:ss");
                        if(_listUser != null){
                            for(ModelUser item : _listUser){
                                listUser.add(item);
                            }
                        }
                        else{
                            Toast.makeText(getActivity(), "Không tìm thấy dữ liệu phù hợp!", Toast.LENGTH_LONG);
                        }
                        RefreshList();
                    }
                    catch (Exception ex){
                        Toast.makeText(getActivity(), "Có lỗi xảy ra trong quá trình nhận dữ liệu!", Toast.LENGTH_LONG);
                    }
                }

                @Override
                public void onFailure(Call<ResultListUser> call, Throwable t) {
                    Toast.makeText(getActivity(), "Có lỗi xảy ra trong quá trình gửi yêu cầu!", Toast.LENGTH_LONG);
                }
            });
        }
        catch (Exception ex){
            Toast.makeText(getActivity(), "Vui lòng kiểm tra đầu vào và thử lại!", Toast.LENGTH_LONG).show();
        }
    }

    private void RefreshList(){
        adapterUser.notifyDataSetChanged();
    }
}