package ra.edu.business.dao.category;

import ra.edu.business.dao.IGenericDao;
import ra.edu.business.model.dto.CategoryForUser;
import ra.edu.business.model.entity.Category;

import java.util.List;

public interface ICategoryDao extends IGenericDao<Category, Integer> {
    List<CategoryForUser> findAllCategoryActive();

}
