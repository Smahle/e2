package tdt4250.unit.meter;

import org.osgi.service.component.annotations.Component;
import tdt4250.unit.util.UnitUtil;
import tdt4250.unit.api.Unit;

@Component(
		property = {
				UnitUtil.UNIT_NAME + "=m",
				UnitUtil.CONVERSION_FORMULAS + "=c=m*100 d=m*10 n=m*1000000000",
				}
		)
public class Meter extends UnitUtil implements Unit{
}
