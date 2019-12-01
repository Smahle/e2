package tdt4250.unit.newton;

import org.osgi.service.component.annotations.Component;
import tdt4250.unit.util.UnitUtil;
import tdt4250.unit.api.Unit;

@Component(
		property = {
				UnitUtil.UNIT_NAME + "=n",
				UnitUtil.CONVERSION_FORMULAS + "=p=n*0.138255 k=n*9.80665 l=n*4.448222",
				}
		)
public class Newton extends UnitUtil implements Unit{
}
