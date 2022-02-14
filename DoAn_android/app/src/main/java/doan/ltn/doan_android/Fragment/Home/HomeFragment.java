package doan.ltn.doan_android.Fragment.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.reflect.Executable;
import java.util.ArrayList;

import javax.xml.transform.Result;

import doan.ltn.doan_android.Adapter.HomeButtomAdapter;
import doan.ltn.doan_android.Adapter.HomeStatusAdapter;
import doan.ltn.doan_android.Interface.APIServices;
import doan.ltn.doan_android.Interface.ItemButtomOnClick;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.ButtomItem;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelDashboardData;
import doan.ltn.doan_android.Object.ResultAPI.ResultDashboardData;
import doan.ltn.doan_android.Object.ResultAPI.ResultGroupID;
import doan.ltn.doan_android.Object.Status;
import doan.ltn.doan_android.Page.Contract.ContractActivity;
import doan.ltn.doan_android.Page.Export.ExportActivity;
import doan.ltn.doan_android.Page.Import.ImportActivity;
import doan.ltn.doan_android.Page.Provider.ProviderAtcivity;
import doan.ltn.doan_android.Page.Store.StoreActivity;
import doan.ltn.doan_android.R;
import doan.ltn.doan_android.Shared.Constants;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    HomeButtomAdapter adapter;
    HomeStatusAdapter statusAdapter;
    ArrayList<ButtomItem> list;
    ArrayList<Status> listStatus;
    RecyclerView recyclerView;
    ConstraintLayout bLayout;
    RecyclerView statusView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_home, container, false);

       getID(view);
        getData(view);



        return view;
    }

    private void getData(View view) {
        list.add(new ButtomItem(R.drawable.factory_1,"Nhà cung cấp",1));
        list.add(new ButtomItem(R.drawable.shop_6,"Cửa hàng",2));
        list.add(new ButtomItem(R.drawable.log,"Lịch sử",3));
        list.add(new ButtomItem(R.drawable.contract_2,"Hợp đồng",4));
        list.add(new ButtomItem(R.drawable.car,"Xuất hàng",5));
        list.add(new ButtomItem(R.drawable.deliverytruck_13,"Nhập kho",6));

        adapter =new HomeButtomAdapter(list, new ItemButtomOnClick() {
            @Override
            public void onClickListener(int key) {
                Intent intent=null ;
                switch (key)
                {
                    case 1:
                        intent= new Intent(view.getContext(), ProviderAtcivity.class);
                        break;
                    case 2:
                        intent= new Intent(view.getContext(), StoreActivity.class);
                        break;
                    case 3:
                        intent= new Intent(view.getContext(), ContractActivity.class);
                        break;
                    case 4:
                        intent= new Intent(view.getContext(), ContractActivity.class);
                        break;
                    case 5:
                        intent= new Intent(view.getContext(), ExportActivity.class);
                        break;
                    case 6:
                        intent= new Intent(view.getContext(), ImportActivity.class);
                        break;

                }

                if (intent != null )
                {
                    startActivity(intent);

                }

            }
        });
        recyclerView.setAdapter(adapter);

        //Get dashboard data
        RequestBody token = RequestBody.create(Constants.TEXT, Constants.Token);
        APIServices.apiservices.GetDashBoardData(token).enqueue(new Callback<ResultDashboardData>() {
            @Override
            public void onResponse(Call<ResultDashboardData> call, Response<ResultDashboardData> response) {
                ResultDashboardData rs = response.body();
                if(response.isSuccessful()){
                    if(rs != null)
                        if(rs.getErrCodeField() == 2){
                            ModelDashboardData dashboardData = rs.getDataField();
                            SetStatus(dashboardData);
                            return;
                        }
                        else{
                            //
                        }
                }
                else{
                    //
                }
                SetStatus(null);
            }

            @Override
            public void onFailure(Call<ResultDashboardData> call, Throwable t) {
                SetStatus(null);
            }
        });


    }
    public void getID(View view)
   {
       bLayout= (ConstraintLayout) view.findViewById(R.id.btn_frame);
       recyclerView= (RecyclerView) view.findViewById(R.id.list);
       recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),3));
       statusView= (RecyclerView) view.findViewById(R.id.listStatus);
       statusView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
       list=new ArrayList<>();
       listStatus=new ArrayList<>();
   }

   private void SetStatus(ModelDashboardData dashboardData){
        try{
            listStatus.add(new Status(11,"Hợp đồng", dashboardData.getTongSoHDField()));
            listStatus.add(new Status(21,"Yêu cầu xuất hàng", dashboardData.getTongSoYCField()));
            listStatus.add(new Status(12,"Hợp đồng chưa HT", dashboardData.getTongSoHDChoField()));
            listStatus.add(new Status(22,"YCXH đã tạo",dashboardData.getTongSoYCChoField()));
            listStatus.add(new Status(13,"Hợp đồng đã HT",dashboardData.getTongSoHDHoanThanhField()));
            listStatus.add(new Status(23,"YCXH đã phê duyệt",dashboardData.getTongSoYCPheDuyetField()));
            listStatus.add(new Status(14,"Phiếu nhập",0));
            listStatus.add(new Status(24,"YCXH đã hoàn thành",dashboardData.getTongSoYCHoanThanhField()));
        }
        catch (Exception ex){
            listStatus.add(new Status(11,"Hợp đồng", 0));
            listStatus.add(new Status(21,"Yêu cầu xuất hàng", 0));
            listStatus.add(new Status(12,"Hợp đồng chưa HT", 0));
            listStatus.add(new Status(22,"YCXH đã tạo", 0));
            listStatus.add(new Status(13,"Hợp đồng đã HT", 0));
            listStatus.add(new Status(23,"YCXH đã phê duyệt", 0));
            listStatus.add(new Status(14,"Phiếu nhập",0));
            listStatus.add(new Status(24,"YCXH đã hoàn thành", 0));
        }

       statusAdapter= new HomeStatusAdapter(listStatus, new ItemClickListener() {
           @Override
           public void onItemClickListener(int i) {

           }
       });
       statusView.setAdapter(statusAdapter);
   }
}