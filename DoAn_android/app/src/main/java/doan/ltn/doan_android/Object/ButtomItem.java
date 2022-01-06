package doan.ltn.doan_android.Object;

import android.media.Image;

public class ButtomItem {
    private int icon;
    private String title;
    private  int key;


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ButtomItem(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }
    public ButtomItem(int icon, String title, int key) {
        this.icon = icon;
        this.title = title;
        this.key = key;
    }
    public ButtomItem()
    {
        this(0,"",0);
    }
}
