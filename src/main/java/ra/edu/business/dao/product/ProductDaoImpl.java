package ra.edu.business.dao.product;

import ra.edu.business.model.entity.Product;

import java.util.List;

public class ProductDaoImpl implements IProductDao{
    private static IProductDao instance;
    private ProductDaoImpl(){

    }
    public static IProductDao getInstance(){
        if (instance==null){
            instance = new ProductDaoImpl();
        }
        return instance;
    }
    @Override
    public List<Product> findProductByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void deleteById(String id) {

    }

}
