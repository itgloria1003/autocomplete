package hk.sfc.cec.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class FrequencyUsedCentralEntityEntry {
	
	@Id
	private String ceref;



	private String fullname;
    private String stockCode;
	public String getCeref() {
		return ceref;
	}
	public void setCeref(String ceref) {
		this.ceref = ceref;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
    

}
