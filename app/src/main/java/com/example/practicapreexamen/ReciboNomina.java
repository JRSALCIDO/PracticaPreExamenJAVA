package com.example.practicapreexamen;

public class ReciboNomina {
    private double horasTrabajadasNormales;
    private double horasTrabajadasExtra;
    private int puesto;
    private double porcentajeImpuesto;
    private double subtotal;
    private double impuesto;
    private double total;
    private final double pagobase = 200.0;

    public ReciboNomina(double horasTrabajadasNormales, double horasTrabajadasExtra, int puesto) {
        this.horasTrabajadasNormales = horasTrabajadasNormales;
        this.horasTrabajadasExtra = horasTrabajadasExtra;
        this.puesto = puesto;
        this.porcentajeImpuesto = 0.16;
        this.subtotal = 0.0;
        this.impuesto = 0.0;
        this.total = 0.0;
    }

    public double calcularPagoPorPuesto() {
        switch (this.puesto) {
            case 1:
                return pagobase * 1.20;
            case 2:
                return pagobase * 1.50;
            case 3:
                return pagobase * 2.00;
            default:
                return 0.0;
        }
    }

    public void calcularSubtotal() {
        double pagoPorHora = calcularPagoPorPuesto();
        this.subtotal = this.horasTrabajadasNormales * pagoPorHora + this.horasTrabajadasExtra * pagoPorHora * 2;
    }

    public void calcularImpuesto() {
        this.impuesto = this.porcentajeImpuesto * this.subtotal;
    }

    public void calcularTotal() {
        this.total = this.subtotal - this.impuesto;
    }

    // Getters and Setters
    public double getHorasTrabajadasNormales() {
        return horasTrabajadasNormales;
    }

    public void setHorasTrabajadasNormales(double horasTrabajadasNormales) {
        this.horasTrabajadasNormales = horasTrabajadasNormales;
    }

    public double getHorasTrabajadasExtra() {
        return horasTrabajadasExtra;
    }

    public void setHorasTrabajadasExtra(double horasTrabajadasExtra) {
        this.horasTrabajadasExtra = horasTrabajadasExtra;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public double getPorcentajeImpuesto() {
        return porcentajeImpuesto;
    }

    public void setPorcentajeImpuesto(double porcentajeImpuesto) {
        this.porcentajeImpuesto = porcentajeImpuesto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getTotal() {
        return total;
    }
}
