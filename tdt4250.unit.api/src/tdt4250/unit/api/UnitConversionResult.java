package tdt4250.unit.api;

public class UnitConversionResult {
	
	private String note;
	private boolean valid;
	
	public UnitConversionResult(String note, boolean valid) {
		this.note = note;
		this.valid = valid;
	}
	
	
	public String getNote() {
		return note;
	}
	public boolean isValid() {
		return valid;
	}
	
}
