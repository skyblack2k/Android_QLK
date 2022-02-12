package doan.ltn.doan_android.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import doan.ltn.doan_android.Interface.ItemButtomOnClick;
import doan.ltn.doan_android.Object.ButtomItem;
import doan.ltn.doan_android.R;

public class HomeButtomAdapter extends RecyclerView.Adapter<HomeButtomAdapter.ViewHolder> {

    private ArrayList<ButtomItem> list;
    private  int key;
    private ItemButtomOnClick itemButtomOnClick;
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public HomeButtomAdapter(ArrayList<ButtomItem> list, ItemButtomOnClick itemButtomOnClick) {
        this.list =new ArrayList<>();
        this.list.addAll(list);
        this.itemButtomOnClick=itemButtomOnClick;
        key=0;

    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_button,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeButtomAdapter.ViewHolder viewHolder, int i) {
        ButtomItem item=list.get(i);

        viewHolder.icon.setImageResource(item.getIcon());
        viewHolder.title.setText(item.getTitle());

        viewHolder.itemView.setOnClickListener(v -> {

           itemButtomOnClick.onClickListener(item.getKey());
        });




    }

    @Override
    public int getItemCount() {
        if (list !=null)
        {return list.size();}
        return 0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView title;
        private ImageView icon;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            icon=itemView.findViewById(R.id.item_number);
            title=itemView.findViewById(R.id.item_content);
        }

    }
}
