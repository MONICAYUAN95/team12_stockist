package team12.stockist.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import team12.stockist.model.Product;
import team12.stockist.service.ProductService;

@RequestMapping(value = "/product/")
@Controller
public class ProductController {
	@Autowired
	private ProductService pservice;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView productListPage() {
		ModelAndView mav = new ModelAndView("product-list");
		ArrayList<Product> pList = (ArrayList<Product>) pservice.findAllProduct();
		mav.addObject("productList", pList);
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView viewLogin() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "/login1", method = RequestMethod.GET)
	public String viewLogin1() {

		return "login";
	}

	//.................. UPDATE PRODUCT........................//
	
	@RequestMapping(value = "/edit/{partID}", method = RequestMethod.GET)
	public ModelAndView editProductPage(@PathVariable Integer partID) {
		// Redirect to product-edit page
		ModelAndView mav = new ModelAndView("product-edit");
		// calling the  findProductById service method(ProductsServiceImpl class method).
		// Return the specific product based on partID
		// result is stored in variable 'product' of type Product
		Product product = pservice.findProductById(partID);
		mav.addObject("product", product);
		return mav;
	}

	@RequestMapping(value = "/edit/{partID}", method = RequestMethod.POST)
	public ModelAndView editProduct(@ModelAttribute Product product, BindingResult result, @PathVariable Integer partID,
			final RedirectAttributes redirectAttributes)

	{
		// REdirect to product-list page
		ModelAndView mav = new ModelAndView("redirect:/product/list");
		// calling ProductServiceImpl service class method updateProduct.
		// update the product
		pservice.updateProduct(product);
		String message = "Product is updated";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
