package com.example.android_calculadora_temperaturas.models;

public class Farenheit extends Grado{
        public Farenheit(Double valorF) {
            this.setUnidad("°F");
            this.setValor(valorF);
        }
        public Farenheit parse(Celsius c)
        {
            Double f=(c.getValor()*9/5)+32;
            return new Farenheit(f);
        }
        public Farenheit parse(Kelvin k)
        {
            Double f=(k.getValor()- 273.15)* 9/5 + 32;
            return new Farenheit(f);
        }
}
