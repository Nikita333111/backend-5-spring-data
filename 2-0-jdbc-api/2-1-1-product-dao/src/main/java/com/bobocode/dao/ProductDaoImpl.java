package com.bobocode.dao;

import com.bobocode.model.Product;
import com.bobocode.util.ExerciseNotCompletedException;

import java.sql.*;
import java.util.List;
import javax.sql.DataSource;

public class ProductDaoImpl implements ProductDao {

    private final DataSource dataSource;

    public ProductDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Product product) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO products(name,producer,price,expiration_date) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getProducer());
            statement.setBigDecimal(3, product.getPrice());
            statement.setDate(4, Date.valueOf(product.getExpirationDate()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        throw new ExerciseNotCompletedException();// todo
    }

    @Override
    public Product findOne(Long id) {
        throw new ExerciseNotCompletedException();// todo
    }

    @Override
    public void update(Product product) {
        throw new ExerciseNotCompletedException();// todo
    }

    @Override
    public void remove(Product product) {
        throw new ExerciseNotCompletedException();// todo
    }

}
