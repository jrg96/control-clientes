package com.controller;

import com.model.Cliente;
import com.model.dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/clientes/editar"})
public class ClienteEditarController extends HttpServlet 
{
    @Inject
    private ClienteDAO clienteService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        /*
         *-------------------------------------------------------------------------
         *ZONA DE PROCESAMIENTO DE DATOS
         *-------------------------------------------------------------------------
         */
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = clienteService.encontrarPorId(id);
       
        /*
         *-------------------------------------------------------------------------
         *ZONA DE DESPLIEGUE DE DATOS
         *-------------------------------------------------------------------------
         */
        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("/WEB-INF/cliente/editar_cliente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        /*
         *------------------------------------------------------------------------
         *ZONA DE PROCESAMIENTO DE DATOS
         *------------------------------------------------------------------------
         */
        Cliente cliente = new Cliente();
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setEmail(email);
        cliente.setTelefono(telefono);
        cliente.setSaldo(saldo);
        
        clienteService.guardarCliente(cliente);
        response.sendRedirect(request.getContextPath() + "/clientes/index");
    }
}
