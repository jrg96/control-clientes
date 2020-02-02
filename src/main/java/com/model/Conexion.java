package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import oracle.jdbc.datasource.OracleDataSource;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;


public class Conexion 
{
    private static final String JDBC_URL = "jdbc:oracle:thin:@//localhost:1521/orcl";
    private static final String JDBC_USER = "controlclientedb";
    private static final String JDBC_PASSWORD = "controlclientepw";
    
    public static DataSource getDataSource()
    {
        OracleDataSource ds = null;
        
        try
        {
            ds  = new OracleConnectionPoolDataSource();
            ds.setURL(JDBC_URL);
            ds.setUser(JDBC_USER);
            ds.setPassword(JDBC_PASSWORD);
        }
        catch (Exception e)
        {
        }
        
        return ds;
    }
    
    public static Connection getConnection() throws SQLException
    {
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs)
    {
        try 
        {
            rs.close();
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    public static void close(PreparedStatement stmt)
    {
        try 
        {
            stmt.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    public static void close(Connection conn)
    {
        try 
        {
            conn.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
}
