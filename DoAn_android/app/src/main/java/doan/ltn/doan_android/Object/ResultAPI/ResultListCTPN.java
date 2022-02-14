package doan.ltn.doan_android.Object.ResultAPI;

import java.util.List;

import doan.ltn.doan_android.Object.ResultAPI.Model.ModelCTPN;

public class ResultListCTPN{
	private List<ModelCTPN> dataField;
	private int pageCountField;
	private int recordCountField;
	private int errCodeField;
	private String errDesField;

	public List<ModelCTPN> getDataField(){
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