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
import doan.ltn.doan_android.R;

public class ProviderAdapter extends RecyclerView.Adapter<ProviderAdapter.ViewHolder> {

    private ArrayList<Provider> lisProvider;
    private ItemClickListener itemClickListener;

    public ProviderAdapter(ArrayList<Provider> list, ItemClickListener itemClickListener) {
    this.lisProvider=list;
    this.itemClickListener=itemClickListener;

    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_export,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProviderAdapter.ViewHolder viewHolder, int i) {
        Provider item=lisProvider.get(i);
        viewHolder.ma.setText(String.valueOf(String.valueOf(item.getID())));
        viewHolder.name.setText(String.valueOf(item.getTenNCC()));

        viewHolder.date.setText(String.valueOf(item.getDiaChi()));
        viewHolder.itemView.setOnClickListener(v -> {

            itemClickListener.onItemClickListener(i);
        });
    }

    @Override
    public int getItemCount() {
        if (lisProvider !=null)
        {return lisProvider.size();}
        return 0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView ma;
        private TextView date;
        private TextView name;
        private TextView status;
        private ImageView icon;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
                ma=itemView.findViewById(R.id.ma);
            date=itemView.findViewById(R.id.date);
            name=itemView.findViewById(R.id.ncc);
            status=itemView.findViewById(R.id.status);
            icon=itemView.findViewById(R.id.i1);
        }

    }
}
