package doan.ltn.doan_android.Object;

public class Status {
    private int ID;
    private String Title;
    private int Count;

    public Status(int ID, String title, int count) {
        this.ID = ID;
        Title = title;
        Count = count;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }
}
