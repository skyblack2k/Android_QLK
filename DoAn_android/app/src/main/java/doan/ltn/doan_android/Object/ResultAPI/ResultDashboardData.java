package doan.ltn.doan_android.Object.ResultAPI;

import doan.ltn.doan_android.Object.ResultAPI.Model.ModelDashboardData;

public class ResultDashboardData{
	private ModelDashboardData dataField;
	private int pageCountField;
	private int recordCountField;
	private int errCodeField;
	private String errDesField;

	public ModelDashboardData getDataField(){
		return dataField;
	}

	public int getPageCountField(){
		return pageCountField;
	}

	public int getRecordCountField(){
		return recordCountField;
	}

	public int getErrCodeField(){
		return errCodeField;
	}

	public String getErrDesField(){
		return errDesField;
	}
}
