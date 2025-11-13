package com.ecommerce;
import java.sql.*;
import java.util.*;

public class ProductDAO {
    public static List<Product> getAllProducts() throws Exception {
        Connection con = DBConnection.getConnection();
        List<Product> list = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM products");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setDescription(rs.getString("description"));
            p.setPrice(rs.getDouble("price"));
            p.setImage(rs.getString("image"));
            list.add(p);
        }
        return list;
    }

    public static Product getProductById(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setDescription(rs.getString("description"));
            p.setPrice(rs.getDouble("price"));
            p.setImage(rs.getString("image"));
            return p;
        }
        return null;
    }
}
