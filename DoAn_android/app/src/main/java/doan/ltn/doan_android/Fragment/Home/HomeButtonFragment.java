package doan.ltn.doan_android.Fragment.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

import doan.ltn.doan_android.Adapter.HomeButtomAdapter;
import doan.ltn.doan_android.LoginActivity;
import doan.ltn.doan_android.Object.ButtomItem;
import doan.ltn.doan_android.Page.AddProviderActivity;
import doan.ltn.doan_android.R;


public class HomeButtonFragment extends Fragment {
    HomeButtomAdapter adapter;
    ArrayList<ButtomItem> list;
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_button, container, false);
//        recyclerView= (RecyclerView) view.findViewById(R.id.list);
//        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),3));
//            list=new ArrayList<>();
//            list.add(new ButtomItem(R.drawable.factory_1,"Thêm nhà cung cấp",1));
//            list.add(new ButtomItem(R.drawable.shop_6,"Thêm cửa hàng",2));
//            list.add(new ButtomItem(R.drawable.log,"Lịch sử",3));
//            list.add(new ButtomItem(R.drawable.contract_2,"Hợp đồng",4));
//            list.add(new ButtomItem(R.drawable.car,"Xuất hàng",5));
//            list.add(new ButtomItem(R.drawable.deliverytruck_13,"Nhập kho",6));
//
//        adapter =new HomeButtomAdapter(list);
//
//        recyclerView.setAdapter(adapter);
//
//


        return view;
    }

   private  Intent createIntent(int key)
   {
       Intent intent=null;
       switch (key)
       {
           case 1:
               intent= new Intent(this.getActivity(), AddProviderActivity.class);
               break;
           case 2:
               intent= new Intent(this.getActivity(), AddProviderActivity.class);
               break;
           case 3:
               intent= new Intent(this.getActivity(), AddProviderActivity.class);
               break;
           case 4:
               intent= new Intent(this.getActivity(), AddProviderActivity.class);
               break;
           case 5:
               intent= new Intent(this.getActivity(), AddProviderActivity.class);
               break;
       }
       return  intent;
   }

}