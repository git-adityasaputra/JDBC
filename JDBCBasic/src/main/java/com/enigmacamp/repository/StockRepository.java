package com.enigmacamp.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.enigmacamp.entities.Stock;

public class StockRepository implements Repository<Integer, Stock> {

    private final Connection conn;

    public StockRepository(Connection conn) {
        this.conn = conn;
    }

    //ExecuteUpdate return Integer
    @Override
    public boolean add(Stock entity) throws SQLException {
        String sql = "INSERT INTO stock (id, item_id, quantity, unit_id) VALUES (?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, entity.getId());
            stmt.setInt(2, entity.getItem_id());
            stmt.setInt(3, entity.getQuantity());
            stmt.setInt(4, entity.getUnit_id());
            
            int result = stmt.executeUpdate();
            return result == 1;
        }
    }

    @Override
    public boolean edit(Stock entity) throws SQLException {
        String sql = "UPDATE stock SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, entity.getItem_id());
            stmt.setInt(2, entity.getId());
            stmt.setInt(3, entity.getQuantity());
            stmt.setInt(4, entity.getUnit_id());
            int result = stmt.executeUpdate();
            return result == 1;
        }
    }

    public boolean removeById(Integer id) throws SQLException {
        String sql = "DELETE FROM stock WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int result = stmt.executeUpdate();
            return result == 1;
        }
    }

    @Override
    public boolean remove(Stock entitiy) throws SQLException {
        return removeById(entitiy.getId());
    }

    @Override
    public Stock findById(Integer id) throws SQLException {
        String sql = "SELECT id, name FROM stock WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Stock entity = new Stock(rs.getInt("id"),rs.getInt("item_id"),rs.getInt("quantity"),rs.getInt("unit_id"));
                entity.setId(rs.getInt("id"));
                entity.setInt(rs.getString("item_id"));

                return entity;
            }
        }
        return null;
    }

    public List<Stock> findAll() throws SQLException {
        List<Stock> result = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT id, name FROM stock";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //int id = rs.getInt("id");
                //String name = rs.getString("nama");
                Stock entity = new Stock(rs.getInt("id"),rs.getString("name"));
                entity.setId(rs.getInt("id"));
                entity.setName(rs.getString("name"));

                result.add(entity);
            }
        }
        return result;
    }

    @Override
    public boolean removeById(Stock entity) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
}