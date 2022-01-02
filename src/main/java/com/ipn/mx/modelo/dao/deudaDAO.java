/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.deudaDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class deudaDAO {
    private static final String SQL_INSERT = "INSERT INTO deuda(\n" +"	 \"conceptoDeuda\", \"montoDeuda\")\n" +"	VALUES (?, ? );	";
    private static final String SQL_UPDATE = "UPDATE deuda SET \"conceptoDeuda\"=?, \"montoDeuda\"=? WHERE \"idDeuda\"=?;";
    private static final String SQL_DELETE = "DELETE FROM deuda WHERE \"idDeuda\" = ?;";
    private static final String SQL_SELECT = "SELECT \"idDeuda\", \"conceptoDeuda\", \"montoDeuda\"\n" +
"	FROM deuda\n" +
"	WHERE \"idDeuda\" = ?;";
    private static final String SQL_SELECT_ALL = "SELECT \"idDeuda\", \"conceptoDeuda\", \"montoDeuda\"\n" +
"	FROM deuda;";

    private Connection conexion;
    
    
    public Connection obtenerConexion() { ////////////////////////////////////
        String usuario = "postgres";
        String clave = "root";
        String url = "jdbc:postgresql://localhost:5432/ProyectoWeb";
        String driverPostgreSql = "org.postgresql.Driver";
        try {
            Class.forName(driverPostgreSql);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(deudaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return conexion;
    }
    
    
    public void create(deudaDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        try{
            ps=conexion.prepareCall(SQL_INSERT);
            ps.setString(1,dto.getEntidad().getConceptoDeuda());
            ps.setInt(2, (int)dto.getEntidad().getMontoDeuda());
            ps.executeUpdate();
            
            
        } finally{
          if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            
        }
    }
    
    public void update(deudaDTO dto) throws SQLException {
        
        obtenerConexion();
        CallableStatement ps = null;
        try {
            ps=conexion.prepareCall(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getConceptoDeuda());
            ps.setInt(2, (int)dto.getEntidad().getMontoDeuda());
            ps.setInt(3, dto.getEntidad().getIdDeuda());
            
            ps.executeUpdate();
            
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }

        }
        
    }
    public void delete(deudaDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        try {
            ps=conexion.prepareCall(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdDeuda());
            ps.executeUpdate();
            
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }

        }
        
    }
    public deudaDTO read(deudaDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conexion.prepareCall(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getIdDeuda());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size()>0){
                return (deudaDTO)resultados.get(0);
            }else{
                return null;
            }
        }finally{
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        }
    }
    
    public List readAll() throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        ResultSet rs = null;
        try{
            ps=conexion.prepareCall(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size()>0){
                return resultados;
            }else{
                return null;
            }
        }finally{
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        }
    }
    
    private List obtenerResultados(ResultSet rs)throws SQLException{
        List resultados = new ArrayList();
        while(rs.next()){
            deudaDTO dto = new deudaDTO();
            dto.getEntidad().setIdDeuda(rs.getInt("idDeuda"));
            dto.getEntidad().setConceptoDeuda(rs.getString("conceptoDeuda"));
            dto.getEntidad().setMontoDeuda(rs.getInt("montoDeuda"));
            
            resultados.add(dto);
        }
        
        return resultados;
    }
    
    public static void main(String[] args) {
        deudaDTO dto = new deudaDTO();
        dto.getEntidad().setConceptoDeuda("Pases para ver elton jhon");
        dto.getEntidad().setMontoDeuda(24.56);
        dto.getEntidad().setIdDeuda(3);

        deudaDAO dao = new deudaDAO();
        try {
            dao.update(dto);
            //System.out.println(dao.read(dto));
        } catch (SQLException ex) {
            Logger.getLogger(deudaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
