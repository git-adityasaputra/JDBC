package com.enigmacamp.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.enigmacamp.entities.Item;

public class ItemRepository implements Repository<Integer, Item> {

    private final Connection conn;

    public ItemRepository(Connection conn) {
        this.conn = conn;
    }

    //ExecuteUpdate return Integer
    @Override
    public boolean add(Item entity) throws SQLException {
        String sql = "INSERT INTO item (id, name) VALUES (?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, entity.getId());
            stmt.setString(2, entity.getName());
            int result = stmt.executeUpdate();
            return result == 1;
        }
    }

    @Override
    public boolean edit(Item entity) throws SQLException {
        String sql = "UPDATE item SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, entity.getName());
            stmt.setInt(2, entity.getId());
            int result = stmt.executeUpdate();
            return result == 1;
        }
    }

    public boolean removeById(Integer id) throws SQLException {
        String sql = "DELETE FROM item WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int result = stmt.executeUpdate();
            return result == 1;
        }
    }

    @Override
    public boolean remove(Item entitiy) throws SQLException {
        return removeById(entitiy.getId());
    }

    @Override
    public Item findById(Integer id) throws SQLException {
        String sql = "SELECT id, name FROM item WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Item entity = new Item(rs.getInt("id"),rs.getString("name"));
                entity.setId(rs.getInt("id"));
                entity.setName(rs.getString("name"));

                return entity;
            }
        }
        return null;
    }

    public List<Item> findAll() throws SQLException {
        List<Item> result = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT id, name FROM item";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //int id = rs.getInt("id");
                //String name = rs.getString("nama");
                Item entity = new Item(rs.getInt("id"),rs.getString("name"));
                entity.setId(rs.getInt("id"));
                entity.setName(rs.getString("name"));

                result.add(entity);
            }
        }
        return result;
    }

    @Override
    public boolean removeById(Item entity) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
}