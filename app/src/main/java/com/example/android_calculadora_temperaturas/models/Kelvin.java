package com.example.android_calculadora_temperaturas.models;
public class Kelvin extends Grado{
    public Kelvin(Double valorK) {
        this.setUnidad("°K");
        this.setValor(valorK);
    }
    public Kelvin parse(Celsius c)
    {
        Double k=c.getValor()+273.15;
        return new Kelvin(k);
    }
    public Kelvin parse(Farenheit f)
    {
        Double k=(f.getValor()-32)*5/9+273.15;
        return new Kelvin(k);
    }
}

