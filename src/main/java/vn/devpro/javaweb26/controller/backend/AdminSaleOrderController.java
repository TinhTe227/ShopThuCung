package vn.devpro.javaweb26.controller.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.javaweb26.controller.BaseController;
import vn.devpro.javaweb26.dto.Jw26Constants;
import vn.devpro.javaweb26.dto.SearchModel;
import vn.devpro.javaweb26.model.Product;
import vn.devpro.javaweb26.model.SaleOrder;
import vn.devpro.javaweb26.model.User;
import vn.devpro.javaweb26.service.SaleOrderService;

@Controller
public class AdminSaleOrderController extends BaseController implements Jw26Constants {

	@Autowired
	private SaleOrderService saleOrderService;
	
	@RequestMapping(value = "/admin/order", method = RequestMethod.GET)
	public String orderList(final Model model, final HttpServletRequest request) throws IOException {
		//lay danh sach user tu tbl_user trong db
				List<SaleOrder> saleOrders = saleOrderService.findAll();
				model.addAttribute("saleOrders", saleOrders);
				return "backend/order";
				
	}
}
