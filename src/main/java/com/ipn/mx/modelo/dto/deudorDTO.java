/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.deudor;
import java.io.Serializable;
import lombok.Data;
/**
 *
 * @author Pablo
 */
@Data
public class deudorDTO implements Serializable{
    private deudor entidad;
    
    public deudorDTO(){
        entidad = new deudor();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Clave Deudor").append(getEntidad().getIdDeudor()).append("\n");
        sb.append("Concepto Deudor").append(getEntidad().getConceptoDeudor()).append("\n");
        sb.append("Monto Deudor").append(getEntidad().getMontoDeudor()).append("\n");
        
        
        return sb.toString();
    }
}
