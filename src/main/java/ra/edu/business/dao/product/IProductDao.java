package ra.edu.business.dao.product;

import ra.edu.business.dao.IGenericDao;
import ra.edu.business.model.entity.Product;

import java.util.List;

public interface IProductDao extends IGenericDao<Product, String> {
    List<Product> findProductByName(String name);
}
