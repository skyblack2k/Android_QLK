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
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelMatHang;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelMatHangHT;
import doan.ltn.doan_android.R;

public class ProductNCCAdapter extends RecyclerView.Adapter<ProductNCCAdapter.ViewHolder> {

    private ArrayList<ModelMatHang> list;
    private ItemClickListener itemClickListener;

    public ProductNCCAdapter(ArrayList<ModelMatHang> list, ItemClickListener itemClickListener) {
        this.list = list;
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
    public void onBindViewHolder(@NonNull ProductNCCAdapter.ViewHolder viewHolder, int i) {
        ModelMatHang item = list.get(i);
        viewHolder.lb_Ten.setText(String.valueOf(item.getTenField()));
        viewHolder.lb_Ma_Title.setText("Mã SP: ");
        viewHolder.lb_Ma.setText(String.valueOf(item.getIdField()));
        //viewHolder.lb_SoLuong.setText("Số lượng: " + String.valueOf(item.getSoLuongField()));
        viewHolder.lb_DonGia.setText(String.valueOf(item.getGiaField() + " VNĐ"));
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
        private TextView lb_Ten;
        private TextView lb_SoLuong;
        private TextView lb_Ma_Title;
        private TextView lb_Ma;
        private TextView lb_DonGia;
        private ImageView icon;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            lb_Ten = itemView.findViewById(R.id.ncc);
            lb_Ma = itemView.findViewById(R.id.ma);
            lb_Ma_Title = itemView.findViewById(R.id.textView5);
            lb_SoLuong = itemView.findViewById(R.id.status);
            lb_SoLuong.setVisibility(View.GONE);
            lb_DonGia = itemView.findViewById(R.id.date);
            icon=itemView.findViewById(R.id.i1);
        }

    }
}
