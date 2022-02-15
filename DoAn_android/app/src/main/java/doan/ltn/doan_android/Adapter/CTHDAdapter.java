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
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelCTHD;
import doan.ltn.doan_android.R;

public class CTHDAdapter extends RecyclerView.Adapter<CTHDAdapter.ViewHolder> {

    private ArrayList<ModelCTHD> list;
    private ItemClickListener itemClickListener;

    public CTHDAdapter(ArrayList<ModelCTHD> list, ItemClickListener itemClickListener) {
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
    public void onBindViewHolder(@NonNull CTHDAdapter.ViewHolder viewHolder, int i) {
        ModelCTHD item = list.get(i);
        viewHolder.lb_Ten.setText(String.valueOf(item.getTenField()));
        viewHolder.lb_Ma_Title.setText("Mã SP: ");
        viewHolder.lb_Ma.setText(String.valueOf(item.getMatHangIDField()));
        viewHolder.lb_SoLuong.setText(String.valueOf(item.getSoLuongField()));
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
            lb_DonGia = itemView.findViewById(R.id.date);
            icon=itemView.findViewById(R.id.i1);
        }

    }
}
