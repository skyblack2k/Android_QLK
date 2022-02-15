package doan.ltn.doan_android.Object.ResultAPI.Model;

import java.io.Serializable;

public class ModelNCC implements Serializable {
	private String diaChiField;
	private int idField;
	private String userNameField;
	private String tenField;
	private String ngayTaoField;
	private boolean isDeleteField;
	private String sDTField;
	private int taiKhoanIDField;
	private String nganHangField;
	private String sTKField;
	private String ngayCapNhatField;
	private String hoTenField;

	public String getDiaChiField(){
		return diaChiField;
	}

	public int getIdField(){
		return idField;
	}

	public String getUserNameField(){
		return userNameField;
	}

	public String getTenField(){
		return tenField;
	}

	public String getNgayTaoField(){
		return ngayTaoField;
	}

	public boolean isIsDeleteField(){
		return isDeleteField;
	}

	public String getSDTField(){
		return sDTField;
	}

	public int getTaiKhoanIDField(){
		return taiKhoanIDField;
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

	public String getHoTenField(){
		return hoTenField;
	}
}
