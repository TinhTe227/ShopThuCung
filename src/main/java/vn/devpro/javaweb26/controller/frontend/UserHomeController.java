package vn.devpro.javaweb26.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.javaweb26.controller.BaseController;
import vn.devpro.javaweb26.model.Product;
import vn.devpro.javaweb26.model.ProductImage;
import vn.devpro.javaweb26.service.ProductImageService;
import vn.devpro.javaweb26.service.ProductService;

@Controller
public class UserHomeController extends BaseController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired 
	private ProductImageService productImageService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(final Model model , final HttpServletRequest request, final HttpServletResponse response ) throws IOException{
		
		List<Product> products = productService.findAllActive();
		model.addAttribute("products", products);
		int totalProducts = products.size();
		model.addAttribute("totalProducts", totalProducts);
		return "frontend/index";
	}
	
	@RequestMapping(value = "/product-detail/{productId}", method = RequestMethod.GET)
	public String productDetail(final Model model , final HttpServletRequest request, final HttpServletResponse response, @PathVariable("productId") int productId ) throws IOException{
		
		Product product = productService.getById(productId);
		model.addAttribute("product", product);
	
		List<ProductImage> productImages = productImageService.findAllImage(productId);
		model.addAttribute("productImages", productImages);
		return "frontend/product-detail";
	}
	
	
}
