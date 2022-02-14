package doan.ltn.doan_android.Fragment.User;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import doan.ltn.doan_android.R;


public class UserFagment extends Fragment {


    private Spinner spinnerSort, spinnerRole;
    private ArrayAdapter<CharSequence> spinerAdapterSort, spinerAdapterRole;
    private ArrayList<Object> list;
    private RadioButton a1, a2, a3, a4;
    private RecyclerView recyclerView;
    private RadioGroup radioGroup;
    private  TextView sortTitle;


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
            radioGroup.check(R.id.a1);
            spinnerRole = (Spinner) view.findViewById(R.id.textinput2);
            spinnerSort = (Spinner) view.findViewById(R.id.textinput);
            spinerAdapterSort = ArrayAdapter.createFromResource(view.getContext(), R.array.sapxep, R.layout.dropdown_item);
            spinerAdapterSort.setDropDownViewResource(R.layout.dropdown_item);
            spinnerSort.setAdapter(spinerAdapterSort);
            spinerAdapterRole = ArrayAdapter.createFromResource(view.getContext(), R.array.role, R.layout.dropdown_item);
            spinerAdapterRole.setDropDownViewResource(R.layout.dropdown_item);
            spinnerRole.setAdapter(spinerAdapterRole);

            a1.setText("ID");
            a2.setText("Tên tài khoản");
            a3.setText("SDT");


            list = new ArrayList<>();
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

        } catch (Exception exception) {

        }
    }

}