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

import java.util.ArrayList;

import doan.ltn.doan_android.Adapter.HomeButtomAdapter;
import doan.ltn.doan_android.Interface.ItemButtomOnClick;
import doan.ltn.doan_android.Object.ButtomItem;
import doan.ltn.doan_android.Page.AddProviderActivity;
import doan.ltn.doan_android.R;


public class HomeFragment extends Fragment {
    HomeButtomAdapter adapter;
    ArrayList<ButtomItem> list;
    RecyclerView recyclerView;
    ConstraintLayout bLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_home, container, false);

        bLayout= (ConstraintLayout) view.findViewById(R.id.btn_frame);
        recyclerView= (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),3));
        list=new ArrayList<>();
        list.add(new ButtomItem(R.drawable.factory_1,"Thêm nhà cung cấp",1));
        list.add(new ButtomItem(R.drawable.shop_6,"Thêm cửa hàng",2));
        list.add(new ButtomItem(R.drawable.log,"Lịch sử",3));
        list.add(new ButtomItem(R.drawable.contract_2,"Hợp đồng",4));
        list.add(new ButtomItem(R.drawable.car,"Xuất hàng",5));
        list.add(new ButtomItem(R.drawable.deliverytruck_13,"Nhập kho",6));

        adapter =new HomeButtomAdapter(list, new ItemButtomOnClick() {
            @Override
            public void onClickListener(int key) {
                Intent intent =new Intent(view.getContext(),AddProviderActivity.class);
                switch (key)
                {
                    case 1:
                        startActivity(intent);
                        break;
                    case 2:
                        Toast.makeText(view.getContext(),String.valueOf(key),Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(view.getContext(),String.valueOf(key),Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(view.getContext(),String.valueOf(key),Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(view.getContext(),String.valueOf(key),Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(view.getContext(),String.valueOf(key),Toast.LENGTH_SHORT).show();
                        break;

                }


            }
        });

        recyclerView.setAdapter(adapter);


        return view;
    }
}