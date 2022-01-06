package doan.ltn.doan_android.Object.ResultAPI;

public class ResultLogin {
    public String dataField;
    public int errCodeField;
    public String errDesField;
    public int recordCountField;
    public int pageCountField;

    public ResultLogin(String dataField, int errCodeField, String errDesField, int recordCountField, int pageCountField) {
        this.dataField = dataField;
        this.errCodeField = errCodeField;
        this.errDesField = errDesField;
        this.recordCountField = recordCountField;
        this.pageCountField = pageCountField;
    }

    public String getDataField() {
        return dataField;
    }

    public void setDataField(String dataField) {
        this.dataField = dataField;
    }

    public int getErrCodeField() {
        return errCodeField;
    }

    public void setErrCodeField(int errCodeField) {
        this.errCodeField = errCodeField;
    }

    public String getErrDesField() {
        return errDesField;
    }

    public void setErrDesField(String errDesField) {
        this.errDesField = errDesField;
    }

    public int getRecordCountField() {
        return recordCountField;
    }

    public void setRecordCountField(int recordCountField) {
        this.recordCountField = recordCountField;
    }

    public int getPageCountField() {
        return pageCountField;
    }

    public void setPageCountField(int pageCountField) {
        this.pageCountField = pageCountField;
    }
}
