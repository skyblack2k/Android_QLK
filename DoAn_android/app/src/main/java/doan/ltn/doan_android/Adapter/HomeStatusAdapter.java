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
import doan.ltn.doan_android.Object.Status;
import doan.ltn.doan_android.R;

public class HomeStatusAdapter extends RecyclerView.Adapter<HomeStatusAdapter.ViewHolder> {

    private ArrayList<Status> list;
    private ItemClickListener itemClickListener;

    public HomeStatusAdapter(ArrayList<Status> list, ItemClickListener itemClickListener) {
    this.list=list;
    this.itemClickListener=itemClickListener;

    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_status,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeStatusAdapter.ViewHolder viewHolder, int i) {
        Status item = list.get(i);
        viewHolder.status.setText(item.getTitle());
        viewHolder.sl.setText(String.valueOf(item.getCount()));

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

        private TextView sl;
        private TextView status;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            sl=itemView.findViewById(R.id.t2);
            status=itemView.findViewById(R.id.t1);

        }

    }
}
