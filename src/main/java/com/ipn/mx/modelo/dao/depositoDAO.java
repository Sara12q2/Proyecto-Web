package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.depositoDTO;
import com.ipn.mx.modelo.dto.deudaDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class depositoDAO {

    private static final String SQL_INSERT = "INSERT INTO deposito(\n" + "	 \"conceptoDeposito\",  \"montoDeposito\",\"fechaDeposito\", \"horaDeposito\", \"idCategoria\")\n" + "	VALUES (?, ?, ?, ?, ? );	";
    private static final String SQL_UPDATE = "UPDATE deposito SET \"conceptoDeposito\"=?, \"montoDeposito\"=?, \"fechaDeposito\"=?, \"horaDeposito\"=?, \"idCategoria\"=? WHERE \"idDeposito\"=?;";
    private static final String SQL_SELECT = "SELECT \"idDeposito\", \"conceptoDeposito\", \"montoDeposito\", \"fechaDeposito\", \"horaDeposito\", \"idCategoria\"\n" + "	FROM deposito\n" + "WHERE \"idDeposito\" = ?;";
    private static final String SQL_SELECT_ALL = "SELECT \"idDeposito\", \"conceptoDeposito\", \"montoDeposito\", \"fechaDeposito\", \"horaDeposito\", \"idCategoria\"\n" + "	FROM deposito;";

    private Connection conexion;

    private void obtenerConexion() {
        String usuario = "postgres";
        String clave = "oso";
        String url = "jdbc:postgresql://localhost:5432/BaseProyecto2";
        String driverPostgreSql = "org.postgresql.Driver";
        try {
            Class.forName(driverPostgreSql);
            conexion = DriverManager.getConnection(url, usuario, clave);

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(depositoDAO.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    public void create(depositoDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getConceptoDeposito());
            ps.setInt(2, (int) dto.getEntidad().getMontoDeposito());
            ps.setInt(4, dto.getEntidad().getIdCategori());
            ps.setDate(5, dto.getEntidad().getFecha());
            ps.setTime(6, dto.getEntidad().getHora());
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

    public void update(depositoDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getConceptoDeposito());
            ps.setInt(2, (int) dto.getEntidad().getMontoDeposito());
            ps.setInt(3, dto.getEntidad().getIdDeposito());
            ps.setInt(4, dto.getEntidad().getIdCategori());
            ps.setDate(5, dto.getEntidad().getFecha());
            ps.setTime(6, dto.getEntidad().getHora());

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

    public List readAll() throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            depositoDTO dto = new depositoDTO();
            dto.getEntidad().setIdDeposito(rs.getInt("idDeposito"));
            dto.getEntidad().setConceptoDeposito(rs.getString("conceptoDeposito"));
            dto.getEntidad().setMontoDeposito(rs.getInt("montoDeposito"));
            dto.getEntidad().setIdCategori(rs.getInt("idCategori"));
            dto.getEntidad().setFecha(rs.getDate("Fecha"));
            dto.getEntidad().setHora(rs.getTime("Hora"));

            resultados.add(dto);
        }

        return resultados;
    }

    public static void main(String[] args) throws SQLException {
        depositoDTO dto = new depositoDTO();
        dto.getEntidad().setIdDeposito(1);
        dto.getEntidad().setConceptoDeposito("deposito por x cosa");
        dto.getEntidad().setMontoDeposito(500);
//        dto.getEntidad().setFecha();
//        dto.getEntidad().setHora();
        dto.getEntidad().setIdCategori(1);

        depositoDAO dao = new depositoDAO();

        dao.create(dto);
        System.out.println(dao.readAll());

    }

}
