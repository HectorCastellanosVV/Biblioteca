/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herramientas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Hector
 */
public class ConvertirDate {
    
    public static Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }
    public static Date ParseHora(String hora) {
        DateFormat formato = new SimpleDateFormat("HH:mm:ss");
        Date fecha = null;
        try {
            fecha = formato.parse(hora);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fecha;
    }
}
