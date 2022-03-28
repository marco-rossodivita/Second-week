package com.corso.CreateTable;

import java.sql.SQLException;

public interface db<K> {

    void readDatabase();
    //void writeResult(K result);
    void close() throws SQLException;
}
