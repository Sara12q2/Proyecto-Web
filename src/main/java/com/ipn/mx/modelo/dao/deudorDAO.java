/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.deudorDTO;
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
public class deudorDAO {
    private static final String SQL_INSERT = "INSERT INTO deudor(\n" +
"	\"conceptoDeudor\", \"montoDeudor\")\n" +
"	VALUES (?, ?);	";
    private static final String SQL_UPDATE = "UPDATE deudor\n" +
"	SET  \"conceptoDeudor\"=?, \"montoDeudor\"=?\n" +
"	WHERE \"idDeudor\" = ?;";
    private static final String SQL_DELETE = "DELETE FROM deudor\n" +
"	WHERE \"idDeudor\" = ?;";
    private static final String SQL_SELECT = "SELECT \"conceptoDeudor\", \"montoDeudor\"\n" +
"	FROM deudor\n" +
"	WHERE \"idDeudor\" = ?;";
    private static final String SQL_SELECT_ALL = "SELECT \"idDeudor\", \"conceptoDeudor\", \"montoDeudor\"\n" +
"	FROM deudor;";

    private Connection conexion;
    
    
    public Connection obtenerConexion() { ////////////////////////////////////
        String usuario = "postgres";
        String clave = "root";
        String url = "jdbc:postgresql://localhost:5432/Base3CM18";
        String driverPostgreSql = "org.postgresql.Driver";
        try {
            Class.forName(driverPostgreSql);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(deudorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return conexion;
    }
    
    
    public void create(deudorDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        try{
            ps=conexion.prepareCall(SQL_INSERT);
            ps.setString(1,dto.getEntidad().getConceptoDeudor());
            ps.setInt(2, (int)dto.getEntidad().getMontoDeudor());
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
    
    public void update(deudorDTO dto) throws SQLException {
        
        obtenerConexion();
        CallableStatement ps = null;
        try {
            ps=conexion.prepareCall(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getConceptoDeudor());
            ps.setInt(2, (int)dto.getEntidad().getMontoDeudor());
            ps.setInt(3, dto.getEntidad().getIdDeudor());
            
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
    public void delete(deudorDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        try {
            ps=conexion.prepareCall(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdDeudor());
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
    public deudorDTO read(deudorDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conexion.prepareCall(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getIdDeudor());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size()>0){
                return (deudorDTO)resultados.get(0);
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
    
    private List obtenerResultados(ResultSet rs)throws SQLException{List resultados = new ArrayList();
        while(rs.next()){
            deudorDTO dto = new deudorDTO();
            dto.getEntidad().setIdDeudor(rs.getInt("idDeudor"));
            dto.getEntidad().setConceptoDeudor(rs.getString("conceptoDeudor"));
            dto.getEntidad().setMontoDeudor(rs.getInt("montoDeudor"));
            
            resultados.add(dto);
        }
        
        return resultados;
    }
    
}
