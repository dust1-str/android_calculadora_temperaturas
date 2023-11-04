package com.example.android_calculadora_temperaturas.models;

public class Celsius extends Grado{
    public Celsius(Double valorC) {
        this.setUnidad("°C");
        this.setValor(valorC);
    }
    public Celsius parse(Farenheit f)
    {
        Double c=(f.getValor()-32)*5/9;
        return new Celsius(c);
    }
    public Celsius parse(Kelvin k)
    {
        Double c=k.getValor()-273.15;
        return new Celsius(c);
    }
}

