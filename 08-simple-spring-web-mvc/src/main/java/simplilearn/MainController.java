package simplilearn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/showMessage.html")
public class MainController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		ModelAndView modelAndView = new ModelAndView();
		
		//set the logical view name
		modelAndView.setViewName("showMesage");
		
		//set the model data
		modelAndView.addObject("message", "Spring MVC! Java Configuration");
		
		return modelAndView;
	}
}
