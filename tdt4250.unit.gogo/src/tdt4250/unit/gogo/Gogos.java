package tdt4250.unit.gogo;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Component;
import tdt4250.unit.api.Unit;

@Component(
		service = Gogos.class,
		property = {
				"osgi.command.scope=unit",
				"osgi.command.function=add"
		}
	)
public class Gogos {
	
	public void add(String formula) {
		String unitName = formula.substring(2,3);
		BundleContext bc = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		boolean existing = false;
		try {
			for (ServiceReference<Unit> serviceReference : bc.getServiceReferences(Unit.class, null)) {
				Unit exist = bc.getService(serviceReference);
				try {
					if (exist.getName().equals(unitName)){
						exist.addFormula(formula);
						System.out.println("formula added " + formula);
						existing = true;
					}
				} finally {
					bc.ungetService(serviceReference);
				}
			}
		} catch (InvalidSyntaxException e) {
		}
		if (! existing) {
			System.out.println("Source unit does not exist");
		}
	}
}
