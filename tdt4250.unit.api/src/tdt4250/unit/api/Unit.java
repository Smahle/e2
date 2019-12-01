package tdt4250.unit.api;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface Unit {
	String getName();
	List<String> getFormulas();
	void addFormula(String formula);
}