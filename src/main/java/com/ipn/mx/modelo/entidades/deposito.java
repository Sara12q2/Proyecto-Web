/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author LENOVO
 */
@NoArgsConstructor
@Data
public class deposito implements Serializable{
    private int idDeposito;
    private String conceptoDeposito;
    private double montoDeposito;
    Date Fecha;
    
}
