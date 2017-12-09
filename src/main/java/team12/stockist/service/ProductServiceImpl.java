package team12.stockist.service;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import team12.stockist.model.Product;
import team12.stockist.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductRepository prepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see team12.stockist.service.ProductService#findAllProduct()
	 */
	@Override
	@Transactional
	public ArrayList<Product> findAllProduct() {
		ArrayList<Product> sl = (ArrayList<Product>) prepo.findAll();
		return sl;
	}

	// Find product based on partID
	@Override
	@Transactional
	public Product findProduct(int partID) {
		return prepo.findOne(partID);
	}

	// Update the specific product given as argument
	@Override
	@Transactional

	public Product changeProduct(Product p) {
		return prepo.saveAndFlush(p);
	}

}
