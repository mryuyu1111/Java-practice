package routePlannerMVC;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Exception.RoutePlannerException;
import Output.CalculateRoute;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class RoutePlanner {
	
	/**
	 * Home page
	 * 
	 * @param DTO
	 * @return
	 */
	@RequestMapping("/")
	public String homeHandler(Model DTO){
		return "home";
	}
	
	/**
	 * Take the user input and user the Djikstra algorithm to 
	 * find the shortest path. Display the result into result.jsp
	 * 
	 * @param DTO		spring model
	 * @param startpos	starting station 
	 * @param endpos	destination station
	 * @param request	HttpServletRequest
	 * @return
	 */
	@RequestMapping(value="RoutePlanning",method=POST)
	public String displayRoute(Model DTO, @RequestParam("startpos") String startpos
						,@RequestParam("endpos") String endpos, HttpServletRequest request){
		request.setAttribute("startpos", startpos);
		request.setAttribute("endpos", endpos);
		List<String> results = null;
		
//		ArrayList<ArrayList<Station>> sl = null;
//		Map<String, Station> map =null;
//		try {
//			map = new XMLParser().parser("H:\\Java\\HeadFirst\\RoutePlanner\\LondonUnderground.xml");
//		} catch (RoutePlannerException e) {
//			e.printStackTrace();
//		}
//		
//		DijkstraEngine engine = new DijkstraEngine(map);
//		Station start = map.get(startpos);
//		Station end = map.get(endpos);
//		try {
//			sl = engine.execute(start, end);
//		} catch (RoutePlannerException e) {
//			
//			e.printStackTrace();
//		}
//		formatOutput directions = new formatOutput();
//		results = directions.getSolution(sl);
		
		try {
			results = new CalculateRoute().calcRoute(startpos,endpos);
		} catch (RoutePlannerException e) {
			request.setAttribute("errormsg", e.getMessage());
		}
		
		request.setAttribute("resultarray", results);
		return "result";
	}
}
