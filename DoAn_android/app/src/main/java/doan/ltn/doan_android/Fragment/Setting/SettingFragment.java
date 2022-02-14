package doan.ltn.doan_android.Fragment.Setting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import doan.ltn.doan_android.R;


public class SettingFragment extends Fragment {
    TextView name,username,ngaysinh,sdt,chucvu,ngaytao,diachi,tenHT,sdtHT,stkHT,nganhangHT,ngaylapHT,diachiHT;
    TextView btn_HeTHong;
    CardView hethong,btn_DangXuat;
    Switch btn_CheDo;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        getID(view);
        getData();
        getEvents();
        return view;
    }

    public void getID(View view) {
        try {
            name=(TextView) view.findViewById(R.id.name);
            username=(TextView) view.findViewById(R.id.username);
            ngaysinh=(TextView) view.findViewById(R.id.c1);
            sdt=(TextView) view.findViewById(R.id.c2);
            chucvu=(TextView) view.findViewById(R.id.c3);
            ngaytao=(TextView) view.findViewById(R.id.c4);
            diachi=(TextView) view.findViewById(R.id.c5);
            tenHT=(TextView) view.findViewById(R.id.ct1);
            sdtHT=(TextView) view.findViewById(R.id.ct2);
            stkHT=(TextView) view.findViewById(R.id.ct3);
            nganhangHT=(TextView) view.findViewById(R.id.ct4);
            ngaylapHT=(TextView) view.findViewById(R.id.ct5);
            diachi=(TextView) view.findViewById(R.id.ct6);
            btn_HeTHong =(TextView) view.findViewById(R.id.btn_hethong);
            btn_CheDo =(Switch) view.findViewById(R.id.s2);
            btn_DangXuat=(CardView) view.findViewById(R.id.cardview2);
            hethong= (CardView) view.findViewById(R.id.hethong);
        } catch (Exception exception) {

        }

    }

    public void getData() {
        try {

        } catch (Exception exception) {

        }
    }

    public void getEvents() {
        try {
            btn_HeTHong.setOnClickListener(v -> {
                if (hethong.getVisibility()==View.GONE)
                {
                    hethong.setVisibility(View.VISIBLE);
                }
                else
                {
                    hethong.setVisibility(View.GONE);
                }

            });

        } catch (Exception exception) {

        }
    }
}

