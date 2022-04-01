package com.corso.java.olympic;

import java.io.IOException;
import java.sql.SQLException;

public interface Repository<K> {

    void insert() throws IOException, SQLException;
    void update(K k) throws IOException, SQLException;
    void delete() throws IOException, SQLException;
    void findByPrimaryKey() throws SQLException, IOException;
    void findAll() throws IOException, SQLException;

}
