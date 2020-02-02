package com.model.dao;

import com.model.Cliente;
import com.model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO 
{
    private static String SQL_SELECT =  "SELECT * FROM cliente";
    private static String SQL_SELECT_BY_ID = "SELECT * FROM cliente where id = ?";
    private static String SQL_INSERT = "INSERT INTO cliente(nombre, apellido, email, telefono, saldo)"
            + " VALUES(?, ?, ?, ?, ?)";
    private static String SQL_UPDATE = "UPDATE cliente SET nombre = ?, apellido = ?, email = ?, telefono = ?,"
            + " saldo = ? WHERE id = ?";
    private static String SQL_DELETE = "DELETE FROM cliente WHERE id = ?";
    
    
    public List<Cliente> listaClientes()
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente;
        List<Cliente> clientes = new ArrayList<>();
        
        try 
        {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setSaldo(rs.getDouble("saldo"));
                
                clientes.add(cliente);
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        finally
        {
            try 
            {
                conn.close();
                stmt.close();
                rs.close();
            } 
            catch (SQLException exe) 
            {
                exe.printStackTrace();
            }
        }
        
        return clientes;
    }
    
    public Cliente encontrarPorId(int id)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        
        try 
        {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            if (rs.next())
            {
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setSaldo(rs.getDouble("saldo"));
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        
        return cliente;
    }
    
    public Cliente guardarCliente(Cliente cliente)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try 
        {
            conn = Conexion.getConnection();
            
            if (cliente.getId() != 0)
            {
                stmt = conn.prepareStatement(SQL_UPDATE);
            }
            else
            {
                stmt = conn.prepareStatement(SQL_INSERT);
            }
            
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            
            if (cliente.getId() != 0)
            {
                stmt.setInt(6, cliente.getId());
            }
            
            int rows = stmt.executeUpdate();
            
            if (rows != 0)
            {
                rs = stmt.getGeneratedKeys();
                if (rs.next())
                {
                    cliente.setId(rs.getInt(1));
                }
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        
        return cliente;
    }
    
    public void eliminarPorId(int id)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try 
        {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
}
