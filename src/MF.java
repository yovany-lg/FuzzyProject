/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package fuzzysets;
//import java.util.function.*;

/**
 *
 * @author yova
 */
public class MF{
    public Double a,b,c,d,sigma;
    public Double min, max;
    public Integer divs = 20;
    public String mfName = "";
    
    public MF(String mf,Double aa, Double bb, Double cc, Double dd,Double min, Double max){
        //, Trapezoidal
        this.a = aa;
        this.b = bb;
        this.c = cc;
        this.d = dd;
        this.min = min;
        this.max = max;
        this.mfName = mf;
    }
    
    public MF(String mf,Double aa, Double bb, Double cc,Double min, Double max){
        //Triangular, Bell, Sigmoide
        this.a = aa;
        this.b = bb;
        this.c = cc;
        this.min = min;
        this.max = max;
        this.mfName = mf;
    }

    public MF(String mf,Double cc,Double sig,Double min, Double max){
        //Gausiana
        this.c = cc;
        this.sigma = sig;
        this.min = min;
        this.max = max;
        this.mfName = mf;
    }
    
    public double evaluation(Double a){
        if(mfName.compareTo("Triangular") == 0)
            return Triangular(a);
        if(mfName.compareTo("Trapezoidal") == 0)
            return Trapezoidal(a);
        if(mfName.compareTo("Gusianna") == 0)
            return Gussiana(a);
        if(mfName.compareTo("Bell") == 0)
            return Bell(a);
        if(mfName.compareTo("Sigmoide") == 0)
            return Sigmoide(a);
        return 0;
    }    

    public double evaluation(Integer step){
        Double x = getX(step);
        if(mfName.compareTo("Triangular") == 0)
            return Triangular(x);
        if(mfName.compareTo("Trapezoidal") == 0)
            return Trapezoidal(x);
        if(mfName.compareTo("Gusianna") == 0)
            return Gussiana(x);
        if(mfName.compareTo("Bell") == 0)
            return Bell(x);
        if(mfName.compareTo("Sigmoide") == 0)
            return Sigmoide(x);
        return 0;
    }    

    double Triangular(double x)
    {
        if(x <=a )            
            return 0;
        if(a<=x && x<=b)
            return (x-a)/(b-a);
        if(b<=x && x<=c)
            return (c-x)/(c-b);
        if(c<=x)
            return 0;
        return 0;
    }
    
    double Trapezoidal(double x)
    {
        if(x <=a )            
            return 0;
        if(a<=x && x<=b)
            return (x-a)/(b-a);        
        if(b<=x && x<=c)
            return 1;
        if(c<=x && x<=d)
            return (d-x)/(d-c);
        if(d<=x)
            return 0;
        return 0;
    }
    
    double Gussiana(double x)
    {        
        return Math.exp(-0.5*Math.pow((x-c)/sigma, 2));
    }
    
    double Bell(double x)
    {        
        return 1/(a+Math.pow(Math.abs((x-c)/a), 2*b));
    }
    
    double Sigmoide(double x)
    {        
        return 1/(1+Math.exp(-a*(x-c)));
    }    
    
    public Double getX(Integer step){
        Double factor = (max-min)/divs;
        return min + step*factor;
    }
}
