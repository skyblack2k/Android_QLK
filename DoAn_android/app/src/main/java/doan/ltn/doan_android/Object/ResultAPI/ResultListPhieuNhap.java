package doan.ltn.doan_android.Object.ResultAPI;

import java.util.List;

import doan.ltn.doan_android.Object.ResultAPI.Model.ModelPhieuNhap;

public class ResultListPhieuNhap{
	private List<ModelPhieuNhap> dataField;
	private int pageCountField;
	private int recordCountField;
	private int errCodeField;
	private String errDesField;

	public List<ModelPhieuNhap> getDataField(){
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