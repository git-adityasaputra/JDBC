package com.enigmacamp.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.enigmacamp.Application;
import com.enigmacamp.entities.Item;
import com.enigmacamp.repository.ItemRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.*;
import org.mockito.MockitoAnnotations;

public class ItemRepositoryTest {

    @InjectMocks
    private ItemRepository repository;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement statement;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAdded() throws SQLException {
        when(connection.prepareStatement(any(String.class))).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
            Item item = new Item(99, "Test item");
            boolean result = repository.add(item);

            assertTrue(result);
    }

    @Test
    public void shouldDeleted() throws SQLException{
        when(connection.prepareStatement(any(String.class))).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
        boolean result = repository.removeById(99);
        assertTrue(result);
    }
}