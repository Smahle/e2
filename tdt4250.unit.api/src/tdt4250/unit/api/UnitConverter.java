package tdt4250.unit.api;
import java.util.ArrayList;
import java.util.List;



public class UnitConverter {
	
	private List<Unit> units = new ArrayList<>();
	
	public void addUnit(Unit unit) {
		units.add(unit);
	}
	
	public void removeUnit(Unit unit) {
		units.remove(unit);
	}
	
	public UnitConversionResult convert(String query) {	
		String startUnit = query.substring(0,1);
		String endUnit = query.substring(1,2);
		String value = query.substring(2, query.length());
		List<String> formulas = null;	

		for (Unit unit : units) {
			if (unit.getName().equals(startUnit)) {
				formulas = unit.getFormulas();
				break;
			}
		}
		
		if (formulas == null) {
			return new UnitConversionResult("formula not detected", false);
		}
		
		for (String formula : formulas) {
			if (formula.substring(0, 1).equals(endUnit)) {
				try {
					return new UnitConversionResult(value + startUnit + "=" + Double.parseDouble(formula.substring(4, formula.length()))*Double.parseDouble(value) + endUnit, true);
				} catch(Exception e) {
					System.out.println("Incorrect input");
				}
				
			}
		}
		return new UnitConversionResult("Unit " + endUnit + " is not convertable from " + startUnit, false);
	}

}
