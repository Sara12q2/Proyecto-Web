/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.categoriaIngresos;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Pablo
 */
@Data
public class categoriaIngresosDTO implements Serializable{
    private categoriaIngresos entidad;
    
    public categoriaIngresosDTO(){
        entidad = new categoriaIngresos();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Clave Categoria").append(getEntidad().getIdCategoria()).append("\n");
        sb.append("Nombre Categoria").append(getEntidad().getNombreCategoria()).append("\n");
        sb.append("Descripcion Categoria").append(getEntidad().getDescripcionCategoria()).append("\n");
        
        return sb.toString();
    }
}
