package com.corso.java.fornitore;

import java.sql.SQLException;

public interface db<K> {

    void readDatabase() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    //void writeResult(K result);
    void close() throws SQLException;

}
