package tdt4250.unit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

import org.osgi.service.component.annotations.*;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardServletPattern;
import tdt4250.unit.api.UnitConversionResult;
import tdt4250.unit.api.Unit;
import tdt4250.unit.api.UnitConverter;
import org.osgi.framework.BundleContext;


@Component
@HttpWhiteboardServletPattern("/convert/*")
public class UnitServlet extends HttpServlet implements Servlet {
	
	private static final long serialVersionUID = 1L;
	private UnitConverter converter = new UnitConverter();
	
	@Reference(
			cardinality = ReferenceCardinality.MULTIPLE,
			policy = ReferencePolicy.DYNAMIC,
			bind = "addUnit",
			unbind = "removeUnit"
			)
	public void addUnit(Unit unit) {
		converter.addUnit(unit);
	}
	public void removeUnit(Unit unit) {
		converter.addUnit(unit);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String q = request.getParameter("q").toLowerCase();
		UnitConversionResult result = converter.convert(q);
		writer.print(result.getNote());
		}
		
	

}