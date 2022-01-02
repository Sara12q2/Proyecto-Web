/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.entidades;


import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author Pablo
 */

@NoArgsConstructor
@Data
public class deuda implements Serializable {
    private int idDeuda;
    private String conceptoDeuda;
    private double montoDeuda;
}
