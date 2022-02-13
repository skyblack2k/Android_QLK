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

import java.util.ArrayList;

import doan.ltn.doan_android.Adapter.HomeButtomAdapter;
import doan.ltn.doan_android.Adapter.HomeStatusAdapter;
import doan.ltn.doan_android.Interface.ItemButtomOnClick;
import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.ButtomItem;
import doan.ltn.doan_android.Object.Status;
import doan.ltn.doan_android.Page.Contract.ContractActivity;
import doan.ltn.doan_android.Page.ExportActivity;
import doan.ltn.doan_android.Page.ImportActivity;
import doan.ltn.doan_android.Page.ProviderAtcivity;
import doan.ltn.doan_android.Page.StoreActivity;
import doan.ltn.doan_android.R;


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

        listStatus.add(new Status(1,"HĐ chưa HT",10));
        listStatus.add(new Status(2,"Phiếu xuất",122));
        listStatus.add(new Status(3,"Phiếu nhập",103));
        listStatus.add(new Status(4,"HĐ đã HT",103));
        listStatus.add(new Status(5,"Phiếu xuất HT",20));
        listStatus.add(new Status(6,"Phiếu nhập chưa HT",230));
        statusAdapter= new HomeStatusAdapter(listStatus, new ItemClickListener() {
            @Override
            public void onItemClickListener(int i) {

            }
        });
        statusView.setAdapter(statusAdapter);
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
}