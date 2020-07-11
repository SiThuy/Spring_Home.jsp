package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SumController {
	@RequestMapping("sum.html")
	public String index() {
		return "sum";
	}

	@RequestMapping(value = "sum.html", method = RequestMethod.POST)
	public String index(Model model, int a, int b) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("result", a + b);
		return "sum";
	}

}
