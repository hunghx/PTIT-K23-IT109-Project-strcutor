package ra.edu.business.dao.category;

import ra.edu.business.model.dto.CategoryForUser;
import ra.edu.business.model.entity.Category;
import ra.edu.config.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao{
    private final String FINDALL = "SELECT id, name, description, status FROM Category";
    private final String FINDALLFORUSER = "SELECT id, name FROM Category WHERE status = 1";
    private final String FINDBYID = "SELECT id, name, description, status FROM Category WHERE id = ";
    private final String DELETE = "DELETE FROM Category WHERE id = ";
    private final String INSERT = "INSERT INTO Category(name, description) VALUES ";
    private final String UPDATE = "UPDATE Category SET ";
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
        List<Category> list = new ArrayList<>();
        // B1: mở ket noi
        Connection conn = ConnectionDB.openConnection();
        // B2 : Tạo Statement và thực thi câu leenh
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(FINDALL);

            while (rs.next()){
                Category cat = new Category();
                cat.setId(rs.getInt("id"));
                cat.setName(rs.getString("name"));
                cat.setDescription(rs.getString("description"));
                cat.setStatus(rs.getBoolean("status"));
                list.add(cat);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }

    }

    @Override
    public List<CategoryForUser> findAllCategoryActive() {
        List<CategoryForUser> list = new ArrayList<>();
        // B1: mở ket noi
        Connection conn = ConnectionDB.openConnection();
        // B2 : Tạo Statement và thực thi câu leenh
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(FINDALL);

            while (rs.next()){
                CategoryForUser cat = new CategoryForUser();
                cat.setId(rs.getInt("id"));
                cat.setName(rs.getString("name"));
                list.add(cat);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public Category findById(Integer id) {

        // B1: mở ket noi
        Connection conn = ConnectionDB.openConnection();
        // B2 : Tạo Statement và thực thi câu leenh
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(FINDBYID+id);

            if (rs.next()){
                Category cat = new Category();
                cat.setId(rs.getInt("id"));
                cat.setName(rs.getString("name"));
                cat.setDescription(rs.getString("description"));
                cat.setStatus(rs.getBoolean("status"));
                return cat;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void save(Category category) {
        // B1: mở ket noi
        Connection conn = ConnectionDB.openConnection();
        // B2 : Tạo Statement và thực thi câu leenh
        try {
            Statement st = conn.createStatement();
            if(findById(category.getId())==null){
                System.out.println(INSERT +"("+category.getName()+","+category.getDescription()+")");
                // theme mowi
                st.executeUpdate(INSERT +"('"+category.getName()+"','"+category.getDescription()+"')");
            }{
                // cap nhat
                st.executeUpdate(UPDATE+"name='"+category.getName()+"',description='"+category.getDescription()+"',status="+category.isStatus()+" WHERE id ="+category.getId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void deleteById(Integer id) {

        // B1: mở ket noi
        Connection conn = ConnectionDB.openConnection();
        // B2 : Tạo Statement và thực thi câu leenh
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(DELETE+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}
