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
        String sql = "UPDATE stock SET id = ? WHERE id = ?";
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
    public boolean remove(Stock entity) throws SQLException {
        return removeById(entity.getId());
    }
    
    @Override
    public Stock findById(Integer id) throws SQLException {
        String sql = "SELECT id, item_id, quantity, unit_id FROM stock WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Stock entity = new Stock(rs.getInt("id"), rs.getInt("item_id"), rs.getInt("quantity"),
                rs.getInt("unit_id"));
                entity.setId(rs.getInt("id"));
                return entity;
            }
        }
        return null;
    }
    
    public List<Stock> joinStockItemUnit() throws SQLException {
        List<Stock> result = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT s.id, s.item_id, s.quantity, s.unit_id, u.name as name_unit, i.name as name_item FROM stock s JOIN unit u ON s.unit_id = u.id JOIN item i ON s.item_id = i.id";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Stock entity = new Stock(rs.getInt("id"), rs.getInt("item_id"), rs.getInt("quantity"),
                        rs.getInt("unit_id"),rs.getString("name_item"),rs.getString("name_unit"));
                entity.setId(rs.getInt("id"));

                result.add(entity);
            }
        }
        return result;
    }
    
    @Override
    public List<Stock> findAll() throws SQLException {
        List<Stock> result = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT id, name FROM stock";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Stock entity = new Stock(rs.getInt("id"), rs.getInt("item_id"), rs.getInt("quantity"),
                        rs.getInt("unit_id"));

                result.add(entity);
            }
        }
        return result;
    }

    @Override
    public boolean removeById(Stock entity) throws SQLException {
        return false;
    }
}