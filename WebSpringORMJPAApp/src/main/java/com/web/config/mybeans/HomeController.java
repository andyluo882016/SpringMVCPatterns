package com.web.config.mybeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.spring.orm.model.Product;
import com.web.spring.orm.service.ProductService;

import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/")
public class HomeController {

	//@Autowired
	//ProductService productService;
	
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
	
	//Get service from context. (service's dependency (ProductDAO) is autowired in ProductService)
	ProductService productService = ctx.getBean(ProductService.class);
	
	//Do some data operation
	
	
	

	@RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model){
        model.addAttribute("greeting", "Spring MVC Java Configuration Example");
        
        this.productService.add(new Product(1, "Bulb"));
		this.productService.add(new Product(2, "Dijone mustard"));
		
		System.out.println("listAll: " + this.productService.listAll());
       
        
        return "home";
    }
	
	 @RequestMapping(value="/hello-page")
	    public ModelAndView goToHelloPage() {
	        ModelAndView view = new ModelAndView();
	        view.setViewName("hello"); //name of the jsp-file in the "page" folder
	         
	        String str = "MVC Spring is here!";
	        view.addObject("message", str); //adding of str object as "message" parameter
	         
	        return view;
	    }
}
