package tdt4250.unit.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tdt4250.unit.api.Unit;
import org.osgi.service.component.annotations.*;
import org.osgi.framework.BundleContext;

@Component(
		configurationPid = UnitUtil.FACTORY_PID,
		configurationPolicy = ConfigurationPolicy.REQUIRE
		)
public class UnitUtil implements Unit {
	
	public static final String FACTORY_PID = "tdt4250.unit.util.UnitUtil";
	
	public static final String UNIT_NAME = "unitName";
	public static final String CONVERSION_FORMULAS = "conversionFormulas";
	
	private String unitName;
	private List<String> conversionFormulas = new ArrayList<>();
	
	public @interface UnitUtilConfig {
		String unitName();
		String conversionFormulas() default "";
	}
	
	@Activate
	public void activate(BundleContext bc, UnitUtilConfig config) {
		unitName = config.unitName();
		conversionFormulas.addAll(Arrays.asList(config.conversionFormulas().split(" ")));

	}
	@Override
	public String getName() {
		return unitName;
	}
	@Override
	public List<String> getFormulas() {
		return conversionFormulas;
	}
	@Override
	public void addFormula(String formula) {
		conversionFormulas.add(formula);
	}
}
