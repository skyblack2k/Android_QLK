package doan.ltn.doan_android.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import doan.ltn.doan_android.Interface.ItemClickListener;
import doan.ltn.doan_android.Object.Contract;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelUser;
import doan.ltn.doan_android.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<ModelUser> list;
    private ItemClickListener itemClickListener;

    public UserAdapter(ArrayList<ModelUser> list, ItemClickListener itemClickListener) {
    this.list=list;
    this.itemClickListener=itemClickListener;

    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder viewHolder, int i) {
        ModelUser item=list.get(i);
        viewHolder.lb_HoTen.setText(item.getHoTenField());
        viewHolder.lb_UserName.setText("Tài khoản: " + item.getUserNameField());
        viewHolder.lb_PhanQuyen.setText("Phân quyền: " + item.getPhanQuyenField());
        viewHolder.itemView.setOnClickListener(v -> {
            itemClickListener.onItemClickListener(i);
        });
    }

    @Override
    public int getItemCount() {
        if (list !=null)
        {return list.size();}
        return 0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView lb_UserName;
        private TextView lb_HoTen;
        private TextView lb_PhanQuyen;
        private TextView lb_NgaySinh;
        private ImageView icon;
        private  TextView lb_Hidden;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            lb_HoTen = itemView.findViewById(R.id.ncc);
            lb_UserName = itemView.findViewById(R.id.textView5);
            lb_Hidden = itemView.findViewById(R.id.ma);
            lb_Hidden.setVisibility(View.GONE);
            lb_PhanQuyen = itemView.findViewById(R.id.status);
            lb_NgaySinh = itemView.findViewById(R.id.date);
            lb_NgaySinh.setVisibility(View.GONE);
            icon=itemView.findViewById(R.id.i1);
        }
    }
}
