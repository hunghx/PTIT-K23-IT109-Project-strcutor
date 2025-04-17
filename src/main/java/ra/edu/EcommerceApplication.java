package ra.edu;


import ra.edu.business.dao.category.CategoryDaoImpl;
import ra.edu.business.dao.category.ICategoryDao;
import ra.edu.business.model.dto.CategoryForUser;
import ra.edu.business.model.entity.User;

import java.sql.*;
import java.util.List;

public class EcommerceApplication {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/jdbc_demo?createDatabaseIfNotExist=true";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456$";
    public static void main(String[] args) {
        ICategoryDao categoryDao = CategoryDaoImpl.getInstance();
//        Category cat = new Category(5, "Television 10", "smart TV Update",false);
//        categoryDao.save(cat);
//        categoryDao.deleteById(5);
        List<CategoryForUser> list = categoryDao.findAllCategoryActive();
        list.forEach(c->{
            System.out.printf("%d - %s \n",c.getId(),c.getName());
        });
    }
    public static void run(){
        // thết lập kết noois
        // khai báo driver
        try {
            Class.forName(DRIVER);
            // tạo kết nối
            Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            // thực hiện câu lệnh
//            String sql = "CREATE TABLE User(id int primary key auto_increment ,name varchar(100) not null)";
            String sql = "select id ,name from user";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // xử lí
            while (rs.next()){
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                System.out.printf("id : %d va Name : %s \n",u.getId(),u.getName());
            }

            System.out.println("Kêt nối thanh cong");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
