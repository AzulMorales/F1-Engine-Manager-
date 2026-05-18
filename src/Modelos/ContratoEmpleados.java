/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author nathm
 */
public class ContratoEmpleados {
    private Date fechaInicio;
    private int duracion; // En meses
    private double salarioBase;
    private double bonificaciones;
    private String rolAsignado;

    public ContratoEmpleados(Date fechaInicio, int duracion, double salarioBase, double bonificaciones, String rolAsignado) {
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.salarioBase = salarioBase;
        this.bonificaciones = bonificaciones;
        this.rolAsignado = rolAsignado;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the salarioBase
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * @return the bonificaciones
     */
    public double getBonificaciones() {
        return bonificaciones;
    }

    /**
     * @param bonificaciones the bonificaciones to set
     */
    public void setBonificaciones(double bonificaciones) {
        this.bonificaciones = bonificaciones;
    }

    /**
     * @return the rolAsignado
     */
    public String getRolAsignado() {
        return rolAsignado;
    }

    /**
     * @param rolAsignado the rolAsignado to set
     */
    public void setRolAsignado(String rolAsignado) {
        this.rolAsignado = rolAsignado;
    }
    
}
