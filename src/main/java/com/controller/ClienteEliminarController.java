/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gomez
 */
@WebServlet(urlPatterns = {"/clientes/eliminar"})
public class ClienteEliminarController extends HttpServlet 
{
    @Inject
    private ClienteDAO clienteService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        /*
         *-------------------------------------------------------------------------
         *ZONA DE PROCESAMIENTO DE DATOS
         *-------------------------------------------------------------------------
         */
        int id = Integer.parseInt(request.getParameter("id"));
        
        
        /*
         *-------------------------------------------------------------------------
         *ZONA DE DESPLIEGUE DE DATOS
         *-------------------------------------------------------------------------
         */
        clienteService.eliminarPorId(id);
        response.sendRedirect(request.getContextPath() + "/clientes/index");
    }

}
