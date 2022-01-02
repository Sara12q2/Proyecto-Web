/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.retiro;
import lombok.Data;

/**
 *
 * @author LENOVO
 */
@Data
public class retiroDTO {
     private retiro entidad;
     
     public retiroDTO(){
        entidad= new retiro();
    }
     
      @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id Deposito: ").append(getEntidad().getIdRetiro()).append("\n");
        sb.append("Concepto Deposito: ").append(getEntidad().getConceptoRetiro()).append("\n");
        sb.append("Monto Deposito: ").append(getEntidad().getMontoRetiro()).append("\n");
//        sb.append("Fecha: ").append(getEntidad().getTime()).append("\n");
//        sb.append("Hora:  ").append(getEntidad().getDate()).append("\n");
        
        return sb.toString();
        
    }
    
}
