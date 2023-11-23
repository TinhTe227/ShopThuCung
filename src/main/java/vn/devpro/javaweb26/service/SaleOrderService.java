package vn.devpro.javaweb26.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import vn.devpro.javaweb26.dto.SearchModel;
import vn.devpro.javaweb26.model.Product;
import vn.devpro.javaweb26.model.SaleOrder;
import vn.devpro.javaweb26.model.User;

@Service
public class SaleOrderService extends BaseService<SaleOrder>{

	@Override
	public Class<SaleOrder> clazz() {
		// TODO Auto-generated method stub
		return SaleOrder.class;
	}
	
	public List<SaleOrder> findAllActive(){
		return super.executeNativeSql("SELECT * FROM tbl_user WHERE status=1");
	}
	
	@Transactional
	public void deleteSaleOrderById (int id) {
		super.deleteById(id);
	}
	
	
}
