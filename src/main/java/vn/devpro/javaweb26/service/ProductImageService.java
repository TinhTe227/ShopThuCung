package vn.devpro.javaweb26.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb26.model.ProductImage;

@Service
public class ProductImageService extends BaseService<ProductImage> {

	@Override
	public Class<ProductImage> clazz() {
		return ProductImage.class;
	}
	
	public List<ProductImage> findAllImage(int productId){
		return super.executeNativeSql("select * from tbl_product_image where product_id = "+productId);
	}
}
