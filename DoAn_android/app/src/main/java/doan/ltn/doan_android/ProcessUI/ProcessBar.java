package doan.ltn.doan_android.ProcessUI;

import android.app.Dialog;
import android.content.Context;

import doan.ltn.doan_android.R;


public class ProcessBar {
    Dialog dialog;
    Context context;

    public void CreateProcessBar(Context context) {
        this.dialog = dialog;
        this.context = context;
        start();
    }
    public void start()
    {
        dialog=new Dialog(context);
        dialog.setContentView(R.layout.wait_box);
        dialog.show();
    }

    public void  end()
    {
        dialog.cancel();
    }

}
