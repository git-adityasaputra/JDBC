package com.enigmacamp;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.enigmacamp.entities.Item;
import com.enigmacamp.repository.ItemRepository;
import com.mysql.cj.jdbc.MysqlDataSource;

public class Application {

    public static Connection getConnection(Properties prop) throws SQLException {
        Properties props = new Properties();
        props.put("user", prop.getProperty("database.user"));
        props.put("password", prop.getProperty("database.password"));

        //(url: protokol:host/database)
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_item" + prop.getProperty("database.name"), props);
        return conn;
    }

    public static DataSource getDataSourceConnection(Properties prop) throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL("jdbc:mysql://localhost:3306/" + prop.getProperty("db.name"));
        ds.setUser(prop.getProperty("db.user"));
        ds.setPassword(prop.getProperty("db.password"));

//        Connection conn = ds.getConnection();
        return ds;
    }

    public static void test(Connection conn) throws SQLException {
        ItemRepository itemRepository = new ItemRepository(conn);
        try {
            conn.setAutoCommit(false);
            System.out.println("add: " + itemRepository.add(new Item(11, "Bambang")));
            Item item = itemRepository.findById(11);
            System.out.println("findById: " + item);
            item.setName("Agus");
            System.out.println("Edit: " + itemRepository.edit(item));
            System.out.println("Remove: " + itemRepository.remove(item));

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
        }
    }

    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        Connection conn = getConnection();
//
//        addItem(conn, 11, "Budi");
//
//        Map<Integer, String> item = findAllItem(conn);
//        System.out.println(item);
//
//        Object[] itemId = findItemById(conn,11);
//        System.out.println(Arrays.toString(itemId));

//        ItemRepository itemRepository = new ItemRepository(conn);
//        Item item = new Item();
//        item.setId(11);
//        item.setName("Aveiro");
//        itemRepository.add(item);
//        System.out.println(item);

        try (InputStream input = new FileInputStream("./config.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            // System.out.println(prop.getProperty("database.user"));
            // System.out.println(prop.getProperty("database.password"));

            DataSource ds = getDataSourceConnection(prop);
            Connection conn = ds.getConnection();

            test(conn);
        }

    }
}