/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Cliente;
import com.model.dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/clientes/index"})
public class ClienteListaController extends HttpServlet 
{
    @Inject
    private ClienteDAO clienteService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        /*
         *-------------------------------------------------------------------------
         *ZONA DE DESPLIEGUE DE DATOS
         *-------------------------------------------------------------------------
         */
        double saldoTotal = 0.0;
        List<Cliente> clientes = clienteService.listaClientes();
        
        // Contamos el saldo total y cantidad
        for(Cliente c : clientes)
        {
            saldoTotal += c.getSaldo();
        }
        
        request.setAttribute("lista_clientes", clientes);
        request.setAttribute("saldo_total", saldoTotal);
        request.setAttribute("total_clientes", clientes.size());
        request.getRequestDispatcher("/WEB-INF/cliente/lista_cliente.jsp").forward(request, response);
    }
}
