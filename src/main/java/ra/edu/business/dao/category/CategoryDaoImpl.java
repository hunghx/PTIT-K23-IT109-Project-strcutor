package ra.edu.business.dao.category;

import ra.edu.business.model.Category;

import java.util.List;

public class CategoryDaoImpl implements ICategoryDao{
    private static ICategoryDao instance;
    private CategoryDaoImpl(){

    }
    public static ICategoryDao getInstance(){
        if (instance==null){
            instance = new CategoryDaoImpl();
        }
        return instance;
    }
    @Override
    public List<Category> findAll() {
        return List.of();
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
