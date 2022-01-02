/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.categoriaEgresosDTO;
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
public class categoriaEgresosDAO {
    private static final String SQL_INSERT = "INSERT INTO \"categoriaEgresos\"(\n" +
"	 \"nombreCategoria\", \"descripcionCategoria\")\n" +
"	VALUES (?, ?);";
    private static final String SQL_UPDATE = "UPDATE \"categoriaEgresos\"\n" +
"	SET  \"nombreCategoria\"=?, \"descripcionCategoria\"=?\n" +
"	WHERE \"idCategoria\" = ?;	";
    private static final String SQL_DELETE = "DELETE FROM categoriaEgresos\n" +
"	WHERE \"idCategoria\" = ?;";
    private static final String SQL_SELECT = "SELECT \"idCategoria\", \"nombreCategoria\", \"descripcionCategoria\"\n" +
"	FROM \"categoriaEgresos\"\n" +
"	WHERE \"idCategoria\" = ?;";
    private static final String SQL_SELECT_ALL = "SELECT \"idCategoria\", \"nombreCategoria\", \"descripcionCategoria\"\n" +
"	FROM \"categoriaEgresos\";";

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
            Logger.getLogger(categoriaEgresosDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return conexion;
    }
    
    
    public void create(categoriaEgresosDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        try{
            ps=conexion.prepareCall(SQL_INSERT);
            ps.setString(1,dto.getEntidad().getNombreCategoria());
            ps.setString(2,dto.getEntidad().getDescripcionCategoria());
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
    
    public void update(categoriaEgresosDTO dto) throws SQLException {
        
        obtenerConexion();
        CallableStatement ps = null;
        try {
            ps=conexion.prepareCall(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreCategoria());
            ps.setString(2, dto.getEntidad().getDescripcionCategoria());
            ps.setInt(3, dto.getEntidad().getIdCategoria());
            
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
    public void delete(categoriaEgresosDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        try {
            ps=conexion.prepareCall(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
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
    public categoriaEgresosDTO read(categoriaEgresosDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conexion.prepareCall(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size()>0){
                return (categoriaEgresosDTO)resultados.get(0);
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
            categoriaEgresosDTO dto = new categoriaEgresosDTO();
            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
            dto.getEntidad().setNombreCategoria(rs.getString("nombreCategoria"));
            dto.getEntidad().setDescripcionCategoria(rs.getString("descripcionCategoria"));
            
            
            resultados.add(dto);
        }
        return resultados;
    }
    
}
