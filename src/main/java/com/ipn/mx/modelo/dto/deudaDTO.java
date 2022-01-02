/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.deuda;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Pablo
 */
@Data
public class deudaDTO implements Serializable{
    private deuda entidad;
    
    public deudaDTO(){
        entidad= new deuda();
    }
    
      @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Clave Deuda").append(getEntidad().getIdDeuda()).append("\n");
        sb.append("Concepto Deuda").append(getEntidad().getConceptoDeuda()).append("\n");
        sb.append("Monto Deuda").append(getEntidad().getMontoDeuda()).append("\n");
        
        
        return sb.toString();
        
    }
}
