package com.enigmacamp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.enigmacamp.entities.Unit;

public class UnitRepository implements Repository<Integer, Unit>{
    private final Connection conn;

    public UnitRepository(Connection conn) {
        this.conn = conn;
    }

    public boolean add(Integer id, String name) throws SQLException {
        String sql = "INSERT INTO unit (id, name) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            int result = stmt.executeUpdate();
            return result == 1;
        }
    }

    public boolean edit(Unit entity) throws SQLException {
        String sql = "UPDATE unit SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, entity.getName());
            stmt.setInt(2, entity.getId());
            int result = stmt.executeUpdate();
            return result == 1;
        }
    }

    public boolean remove(int entity) throws SQLException {
        String sql = "DELETE FROM unit WHERE id = ?";
        try (PreparedStatement start = conn.prepareStatement(sql)) {
            start.setInt(1, entity);
            int result = start.executeUpdate();
            return result == 1;
        }
    }

    public boolean remove(Unit entity) throws SQLException {
        return remove(entity.getId());
    }

    public Unit findById(Integer id) throws SQLException {

        String sql = "SELECT id, name FROM unit WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Unit entity = new Unit(rs.getInt("id"), rs.getString("name"));
                return entity;
            }
        }
        return null;
    }

    public List<Unit> findAll() throws SQLException {
        List<Unit> bebas = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT id, name FROM unit";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Unit entity = new Unit(rs.getInt("id"), rs.getString("name"));

                bebas.add(entity);
            }
        }
        return bebas;
    }

    public void printTampilan(List<Unit> namaList) { //print to.string
        for (Unit entity : namaList) {
            System.out.println(entity);
        }
    }

    @Override
    public boolean add(Unit entity) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeById(Unit entity) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
}