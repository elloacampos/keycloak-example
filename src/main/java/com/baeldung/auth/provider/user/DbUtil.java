package com.baeldung.auth.provider.user;

import static com.baeldung.auth.provider.user.CustomUserStorageProviderConstants.CONFIG_KEY_DB_PASSWORD;
import static com.baeldung.auth.provider.user.CustomUserStorageProviderConstants.CONFIG_KEY_DB_USERNAME;
import static com.baeldung.auth.provider.user.CustomUserStorageProviderConstants.CONFIG_KEY_JDBC_DRIVER;
import static com.baeldung.auth.provider.user.CustomUserStorageProviderConstants.CONFIG_KEY_JDBC_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.keycloak.component.ComponentModel;

public class DbUtil {
	
    public static Connection getConnection(ComponentModel config) throws SQLException{
    	
        String driverClass = config.get(CONFIG_KEY_JDBC_DRIVER);
        try {
            Class.forName(driverClass);
        } catch(ClassNotFoundException nfe) {
            throw new RuntimeException("Invalid JDBC driver: " + driverClass + ". Please check if your driver if properly installed");
        }
        
        Connection conn= DriverManager.getConnection(config.get(CONFIG_KEY_JDBC_URL),
                config.get(CONFIG_KEY_DB_USERNAME),
                config.get(CONFIG_KEY_DB_PASSWORD));
        
        return conn;
    }
}
