/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud.ejemplo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USER
 */
public class EstudianteDAO {
    
    public int insertar(Estudiante estudiante) {
     String sql = "INSERT INTO estudiantes (nombre, correo, promedio) VALUES (?, ?, ?)";
     int filasAfectadas = 0;
 try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
         ps.setString(1, estudiante.getNombre());
         ps.setString(2, estudiante.getCorreo());
         ps.setDouble(3, estudiante.getPromedio());
         filasAfectadas = ps.executeUpdate();
 
         // Recuperar el id autogenerado (SERIAL) que la base de datos asignó
         try (ResultSet claves = ps.getGeneratedKeys()) {
             if (claves.next()) {
                    estudiante.setId(claves.getInt(1));
             }
         }
         System.out.println("Estudiante insertado con id: " + estudiante.getId());
 
     } catch (SQLException e) {
         System.err.println("Error al insertar estudiante: " + e.getMessage());
     }
     return filasAfectadas;
 }
    
    
    public List<Estudiante> buscarTodos() {
        List<Estudiante> lista = new ArrayList<>();
     String sql = "SELECT id, nombre, correo, promedio FROM estudiantes ORDER BY id";
 
     try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
 
            while (rs.next()) {
             Estudiante e = new Estudiante(
                        rs.getInt("id"),
                     rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getDouble("promedio")
             );
             lista.add(e);
         }
 
     } catch (SQLException e) {
         System.err.println("Error al buscar estudiantes: " + e.getMessage());
     }
     return lista;
 }
    
    
    public boolean eliminar(int id) {
    String sql = "DELETE FROM estudiantes WHERE id = ?";
 
    try (Connection conexion = ConexionBD.obtenerConexion();
         PreparedStatement ps = conexion.prepareStatement(sql)) {
 
        ps.setInt(1, id);
 
        int filasAfectadas = ps.executeUpdate();
        if (filasAfectadas > 0) {
            System.out.println("Estudiante eliminado correctamente.");
        } else {
            System.out.println("No existe un estudiante con ese id.");
        }
        return filasAfectadas > 0;
 
    } catch (SQLException e) {
        System.err.println("Error al eliminar estudiante: " + e.getMessage());
        return false;
    }
    
    
}
    
    public boolean actualizar(Estudiante estudiante) {
    String sql = "UPDATE estudiantes SET nombre = ?, correo = ?, promedio = ? WHERE id = ?";
 
    try (Connection conexion = ConexionBD.obtenerConexion();
         PreparedStatement ps = conexion.prepareStatement(sql)) {
 
        ps.setString(1, estudiante.getNombre());
        ps.setString(2, estudiante.getCorreo());
        ps.setDouble(3, estudiante.getPromedio());
        ps.setInt(4, estudiante.getId());
 
        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0; // true si realmente existía y se modificó
 
    } catch (SQLException e) {
        System.err.println("Error al actualizar estudiante: " + e.getMessage());
        return false;
    }
}
    
    
}
