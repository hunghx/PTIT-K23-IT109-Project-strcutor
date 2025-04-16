package ra.edu.business.service.category;

import ra.edu.business.dao.category.CategoryDaoImpl;
import ra.edu.business.dao.category.ICategoryDao;
import ra.edu.business.dao.product.IProductDao;
import ra.edu.business.dao.product.ProductDaoImpl;

public class CategoryServiceImpl implements ICategoryService{
    private ICategoryDao categoryDao;
    private IProductDao productDao;
    public CategoryServiceImpl(){
        categoryDao = CategoryDaoImpl.getInstance();
        productDao = ProductDaoImpl.getInstance();
    }
}
