package doan.ltn.doan_android.Object.ResultAPI.Model;

import java.io.Serializable;

public class ModelCuaHang implements Serializable {
	private String diaChiField;
	private int idField;
	private String tenField;
	private String sDTField;
	private String nganHangField;
	private String sTKField;
	private String ngayCapNhatField;
	private String userNameField;
	private String ngayTaoField;
	private boolean isDeleteField;
	private int taiKhoanIDField;
	private int heThongIDField;
	private String hoTenField;

	public String getDiaChiField(){
		return diaChiField;
	}

	public int getIdField(){
		return idField;
	}

	public String getTenField(){
		return tenField;
	}

	public String getSDTField(){
		return sDTField;
	}

	public String getNganHangField(){
		return nganHangField;
	}

	public String getSTKField(){
		return sTKField;
	}

	public String getNgayCapNhatField(){
		return ngayCapNhatField;
	}

	public String getUserNameField(){
		return userNameField;
	}

	public String getNgayTaoField(){
		return ngayTaoField;
	}

	public boolean isIsDeleteField(){
		return isDeleteField;
	}

	public int getTaiKhoanIDField(){
		return taiKhoanIDField;
	}

	public int getHeThongIDField(){
		return heThongIDField;
	}

	public String getHoTenField(){
		return hoTenField;
	}
}
