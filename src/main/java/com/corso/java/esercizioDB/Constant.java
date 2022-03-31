package com.corso.java.esercizioDB;

public class Constant {

    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "lol123";
    public static final String DB_URL = "jdbc:mysql://localhost/jdbc?";
    public static final String DB_MYSQL_URL = "com.mysql.cj.jdbc.Driver";

    public static final String DB_CREATE_DEPARTMENT = "CREATE SCHEMA IF NOT EXISTS dipartimento ;";
    public static final String DB_CREATE_ANAGRAFICA = "CREATE TABLE IF NOT EXISTS `dipartimento`.`anagrafica` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `nome` VARCHAR(45) NOT NULL,\n" +
            "  `cognome` VARCHAR(45) NOT NULL,\n" +
            "  `eta` INT NOT NULL,\n" +
            "  `citta` VARCHAR(45) NOT NULL,\n" +
            "  `provincia` VARCHAR(45) NOT NULL,\n" +
            "  `cap` INT NOT NULL,\n" +
            "  PRIMARY KEY (`id`));";

    public static final String DB_INSERT_ANAGRAFICA = "INSERT INTO `dipartimento`.`anagrafica` (`id`, `nome`, `cognome`, `eta`, `citta`, `provincia`, `cap`) VALUES ('1', 'Marco', 'Rossi', '21', 'Roma', 'Roma', '00100');";
    public static final String DB_INSERT_ANAGRAFICA2 = "INSERT INTO `dipartimento`.`anagrafica` (`nome`, `cognome`, `eta`, `citta`, `provincia`, `cap`) VALUES ('Luigi', 'Zeoli', '25', 'Campobasso', 'Ferrazzano', '86019');";
    public static final String DB_INSERT_ANAGRAFICA3 = "INSERT INTO `dipartimento`.`anagrafica` (`nome`, `cognome`, `eta`, `citta`, `provincia`, `cap`) VALUES ('Giovanni', 'Giorgio', '61', 'Napoli', 'Napoli', '80100');\n";
}
