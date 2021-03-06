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
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Executable;
import java.util.ArrayList;

import javax.xml.transform.Result;

import doan.ltn.doan_android.Adapter.HomeButtomAdapter;
import doan.ltn.doan_android.Adapter.HomeStatusAdapter;
import doan.ltn.doan_android.Interface.APIServices;
import doan.ltn.doan_android.Interface.ItemButtomOnClick;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.MainActivity;
import doan.ltn.doan_android.Object.ButtomItem;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelDashboardData;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelUser;
import doan.ltn.doan_android.Object.ResultAPI.ResultBoolean;
import doan.ltn.doan_android.Object.ResultAPI.ResultDashboardData;
import doan.ltn.doan_android.Object.ResultAPI.ResultGroupID;
import doan.ltn.doan_android.Object.ResultAPI.ResultUser;
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
    //User info
    TextView lb_HoTen, lb_UserName, lb_ChucVu;

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
        //Get global data
        getData();

        //
        list.add(new ButtomItem(R.drawable.factory_1,"Nh?? cung c???p",1));
        list.add(new ButtomItem(R.drawable.shop_6,"C???a h??ng",2));
        list.add(new ButtomItem(R.drawable.log,"L???ch s???",3));
        list.add(new ButtomItem(R.drawable.contract_2,"H???p ?????ng",4));
        list.add(new ButtomItem(R.drawable.car,"Xu???t h??ng",5));
        list.add(new ButtomItem(R.drawable.deliverytruck_13,"Nh???p kho",6));

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
        try{
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
        catch (Exception ex){
            SetStatus(null);
        }
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
       //User info
       lb_HoTen = (TextView) view.findViewById(R.id.TenNguoiDung);
       lb_UserName = (TextView) view.findViewById(R.id.TenTaiKhoan);
       lb_ChucVu = (TextView) view.findViewById(R.id.ChucVu);
   }

   public void getData(){
       //CheckLogin
       try
       {
           RequestBody token = RequestBody.create(Constants.TEXT, Constants.Token);
           APIServices.apiservices.User_CheckLogin(token).enqueue(new Callback<ResultBoolean>() {
               @Override
               public void onResponse(Call<ResultBoolean> call, Response<ResultBoolean> response) {
                   try{
                       ResultBoolean rs = response.body();
                       if(response.isSuccessful()){
                           if(rs != null)
                               if(rs.getErrCodeField() == 2){
                                   if(!rs.isDataField()) {
                                       //Ch??a ????ng nh???p
                                       Toast.makeText(getActivity(), "Phi??n ????ng nh???p h???t h???n!", Toast.LENGTH_LONG).show();
                                       getActivity().finish();
                                   }
                                   else{
                                       //Get user info
                                       RequestBody token = RequestBody.create(Constants.TEXT, Constants.Token);
                                       APIServices.apiservices.User_GetUser(token).enqueue(new Callback<ResultUser>() {
                                           @Override
                                           public void onResponse(Call<ResultUser> call, Response<ResultUser> response) {
                                               try{
                                                   ResultUser rs = response.body();
                                                   ModelUser curUser = rs.getDataField();
                                                   Constants.UserName = curUser.getUserNameField();
                                                   Constants.Name = curUser.getHoTenField();
                                                   Constants.RoleID = curUser.getPhanQuyenIDField();
                                                   Constants.RoleName = curUser.getPhanQuyenField();
                                               }
                                               catch (Exception ex){
                                                   Toast.makeText(getActivity(), "Get user info ex: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                                               }

                                               SetUserInfo();
                                           }

                                           @Override
                                           public void onFailure(Call<ResultUser> call, Throwable t) {
                                               SetUserInfo();
                                           }
                                       });

                                       //Get group id
                                       APIServices.apiservices.User_GetGroupID(token).enqueue(new Callback<ResultGroupID>() {
                                           @Override
                                           public void onResponse(Call<ResultGroupID> call, Response<ResultGroupID> response) {
                                               try{
                                                   ResultGroupID rs = response.body();
                                                   Constants.HeThongID = rs.getDataField().getHeThongIDField();
                                                   Constants.CuaHangID = rs.getDataField().getCuaHangIDField();
                                                   Constants.NhaCungCapID = rs.getDataField().getNhaCungCapIDField();
                                               }
                                               catch (Exception ex){
                                                   //
                                               }
                                           }

                                           @Override
                                           public void onFailure(Call<ResultGroupID> call, Throwable t) {
                                               //
                                           }
                                       });
                                   }
                               }
                               else{
                                   Toast.makeText(getActivity(), "Null reponse! " , Toast.LENGTH_LONG).show();
                               }
                           }
                           else{
                               Toast.makeText(getActivity(), "Response error: " + response.code() + " " + response.message(), Toast.LENGTH_LONG).show();
                           }
                       }
                       catch (Exception ex){
                            //
                       }
                   }

               @Override
               public void onFailure(Call<ResultBoolean> call, Throwable t) {
                   Toast.makeText(getActivity(), "Fail call: " + t.getMessage(), Toast.LENGTH_LONG).show();
               }
           });
       }
       catch (Exception exception)
       {
            //
       }
   }

   private void SetStatus(ModelDashboardData dashboardData){
        try{
            listStatus.add(new Status(11,"H???p ?????ng", dashboardData.getTongSoHDField()));
            listStatus.add(new Status(21,"Y??u c???u xu???t h??ng", dashboardData.getTongSoYCField()));
            listStatus.add(new Status(12,"H???p ?????ng ch??a HT", dashboardData.getTongSoHDChoField()));
            listStatus.add(new Status(22,"YCXH ???? t???o",dashboardData.getTongSoYCChoField()));
            listStatus.add(new Status(13,"H???p ?????ng ???? HT",dashboardData.getTongSoHDHoanThanhField()));
            listStatus.add(new Status(23,"YCXH ???? ph?? duy???t",dashboardData.getTongSoYCPheDuyetField()));
            listStatus.add(new Status(14,"Phi???u nh???p",0));
            listStatus.add(new Status(24,"YCXH ???? ho??n th??nh",dashboardData.getTongSoYCHoanThanhField()));
        }
        catch (Exception ex){
            listStatus.add(new Status(11,"H???p ?????ng", 0));
            listStatus.add(new Status(21,"Y??u c???u xu???t h??ng", 0));
            listStatus.add(new Status(12,"H???p ?????ng ch??a HT", 0));
            listStatus.add(new Status(22,"YCXH ???? t???o", 0));
            listStatus.add(new Status(13,"H???p ?????ng ???? HT", 0));
            listStatus.add(new Status(23,"YCXH ???? ph?? duy???t", 0));
            listStatus.add(new Status(14,"Phi???u nh???p",0));
            listStatus.add(new Status(24,"YCXH ???? ho??n th??nh", 0));
        }

       statusAdapter= new HomeStatusAdapter(listStatus, new ItemClickListener() {
           @Override
           public void onItemClickListener(int i) {
                switch (i){
                    case 0:
                    case 2:
                    case 4:
                        Intent intentHD = new Intent(getContext(), ContractActivity.class);
                        if(i == 2){
                            intentHD.putExtra("_status", 0);
                        }
                        else if(i == 4){
                            intentHD.putExtra("_status", 1);
                        }
                        startActivity(intentHD);
                        break;
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                        Intent intentYC = new Intent(getContext(), ExportActivity.class);
                        if(i == 3){
                            intentYC.putExtra("_status", 0);
                        }
                        else if(i == 5){
                            intentYC.putExtra("_status", 1);
                        }
                        else if(i == 7){
                            intentYC.putExtra("_status", 2);
                        }
                        startActivity(intentYC);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Ch???c n??ng ??ang b??? kh??a ????? b???o tr??!", Toast.LENGTH_LONG);
                        break;
                }
           }
       });
       statusView.setAdapter(statusAdapter);
   }

   private void SetUserInfo(){
        if(Constants.Name != null && Constants.Name != ""){
            lb_HoTen.setText(Constants.Name);
        }
        else{
            lb_HoTen.setText("Ch??a ????ng nh???p!");
        }

       if(Constants.UserName != null && Constants.UserName != ""){
           lb_UserName.setText("T??i kho???n: " + Constants.UserName);
       }
       else{
           lb_UserName.setText("T??i kho???n: " + "????ng nh???p ????? hi???n th???!");
       }

       if(Constants.RoleName != null && Constants.RoleName != ""){
           lb_ChucVu.setText("Ph??n quy???n: " + Constants.RoleName);
       }
       else{
           lb_ChucVu.setText("Ph??n quy???n: kh??ng x??c ?????nh!");
       }
   }
}