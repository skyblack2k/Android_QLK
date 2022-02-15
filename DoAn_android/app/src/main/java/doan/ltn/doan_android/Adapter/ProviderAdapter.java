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
import doan.ltn.doan_android.Object.Import;
import doan.ltn.doan_android.Object.Provider;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelCuaHang;
import doan.ltn.doan_android.Object.ResultAPI.Model.ModelNCC;
import doan.ltn.doan_android.R;

public class ProviderAdapter extends RecyclerView.Adapter<ProviderAdapter.ViewHolder> {

    private ArrayList<ModelNCC> listNCC;
    private ItemClickListener itemClickListener;

    public ProviderAdapter(ArrayList<ModelNCC> list, ItemClickListener itemClickListener) {
    this.listNCC = list;
    this.itemClickListener=itemClickListener;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product, viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProviderAdapter.ViewHolder viewHolder, int i) {
        ModelNCC item = listNCC.get(i);
        viewHolder.name.setText(item.getTenField());
        viewHolder.lb_Title.setText("Mã NCC: " + String.valueOf(item.getIdField()));
        viewHolder.date.setText("Địa chỉ: " + item.getDiaChiField());
        viewHolder.status.setText("Đại diện: " + item.getHoTenField() + " (" + item.getUserNameField() + ")");
        viewHolder.itemView.setOnClickListener(v -> {

            itemClickListener.onItemClickListener(i);
        });
    }

    @Override
    public int getItemCount() {
        if (listNCC != null)
        {return listNCC.size();}
        return 0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView ma;
        private TextView date;
        private TextView name;
        private TextView status;
        private TextView lb_Title;
        private TextView lb_DiaChi;
        private ImageView icon;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            ma=itemView.findViewById(R.id.ma);
            ma.setVisibility(View.GONE);
            date=itemView.findViewById(R.id.date);
            name=itemView.findViewById(R.id.ncc);
            status=itemView.findViewById(R.id.status);
            lb_Title = itemView.findViewById(R.id.textView5);
            lb_DiaChi = itemView.findViewById(R.id.status);
            icon=itemView.findViewById(R.id.i1);
        }
    }
}
