package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.CategoryRepository;
import domain.Category;

@Controller
@RequestMapping("admin/category")
public class CategoryController {
	
	CategoryRepository repository = new CategoryRepository();
	
	@RequestMapping("index.html")
	public String index(Model model) {
		model.addAttribute("list", repository.getCategorys());
		return "category.index";
	}


	@RequestMapping("add.html")
	public String add(Model model) {
		List<Category> list = repository.getCategorys();
		Map<Integer, String> map = new HashMap<>();
		for (Category item : list) {
			map.put(item.getId(), item.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("obj", new Category());
		return "category.add";
	}

	@RequestMapping(value = "add.html", method = RequestMethod.POST)
	public String add(Model model, Category obj) {
		repository.add(obj);
		return "redirect:/admin/category/index.html";
	}

}
