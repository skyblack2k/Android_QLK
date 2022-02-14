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
        viewHolder.ma.setText(String.valueOf(item.getUserNameField()));
        viewHolder.name.setText(String.valueOf(item.getHoTenField()));
        viewHolder.date.setText(String.valueOf(item.getNgaySinhField()));
        viewHolder.title.setText("Username: ");
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
        private TextView ma;
        private TextView date;
        private TextView name;
        private TextView status;
        private ImageView icon;
        private  TextView title;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.textView5);
                ma=itemView.findViewById(R.id.ma);
            date=itemView.findViewById(R.id.date);
            name=itemView.findViewById(R.id.ncc);
            status=itemView.findViewById(R.id.status);
            icon=itemView.findViewById(R.id.i1);

        }

    }
}
