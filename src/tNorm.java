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
public class tNorm implements Norm{
    public Double c = 0.5;
    public String mfName = "";
    private MF mf1,mf2;
    Integer stepCount = 20;
    
    public tNorm(String mf){
        this.mfName = mf;
    }
    
    public tNorm(String mf,MF mf1,MF mf2){
        this.mfName = mf;
        this.mf1 = mf1;
        this.mf2 = mf2;
    }

    public tNorm(String mf,Double c,MF mf1,MF mf2){
        this.mfName = mf;
        this.c = c;    
        this.mf1 = mf1;
        this.mf2 = mf2;
    }
    
    /**
     * Interseccion Standard
     * @param a: Evaluacion de la F.M. 1
     * @param b: Evaluacion de la F.M. 2
     * @return: min(a,b) 
     */
    public Double intersection(Double a, Double b){
        return min(a,b);
    }
    
    public Double product(Double a, Double b){
        return a*b;
    }

    public Double Dombi(Double a, Double b){
        Double aTerm, bTerm;
        aTerm = Math.pow( (1/a) - 1 ,c);
        bTerm = Math.pow((1/b) - 1 ,c);
        
        return Math.pow( 1 + Math.pow(aTerm + bTerm,1/c),-1);
    }
    
    public Double Frank(Double a, Double b, Integer s){
        Double aTerm, bTerm;
        aTerm = Math.pow(s,a) - 1;
        bTerm = Math.pow(s,b) - 1;
        
        return log((1 + aTerm*bTerm/(s - 1)),s);
    }
    
    static Double log(Double x, int base)
    {
        return (Math.log(x) / Math.log(base));
    }
    
    public Double Hamacher(Double a, Double b){
        return a*b/(c + (1-c)*(a + b - a*b));
    }
    
    public Double SchweizerSklar1(Double a, Double b){
        Double term,aTerm,bTerm;
        aTerm = Math.pow(a,c);
        bTerm = Math.pow(b,c);
        term = Math.pow( max(0.0,aTerm + bTerm - 1) , 1/c);
        return term;
    }    
    
    public Double SchweizerSklar2(Double a, Double b){
        Double aTerm,bTerm;
        aTerm = Math.pow( 1 - a , c);
        bTerm = Math.pow( 1 - b , c);
        return 1 - Math.pow(aTerm + bTerm - aTerm*bTerm,1/c);
    }

    public Double SchweizerSklar3(Double a, Double b){
        Double aTerm,bTerm;
        aTerm = Math.pow( Math.abs( Math.log(a) ) , c);
        bTerm = Math.pow( Math.abs( Math.log(b) ) , c);
        return Math.exp( -Math.pow(aTerm + bTerm, 1/c) );
    }

    public Double SchweizerSklar4(Double a, Double b){
        Double aTerm,bTerm;
        aTerm = Math.pow( a , c);
        bTerm = Math.pow( b , c);
        return a*b/Math.pow(aTerm + bTerm - aTerm*bTerm,1/c);
    }

    public Double Yager(Double a, Double b){
        Double term;
        term = Math.pow( Math.pow(1 - a,c) + Math.pow(1 - b,c) ,1/c);
        return 1 - min(1.0,term);
    }
    
    public Double DuboisPrade(Double a, Double b){
        return a*b/max(max(a,b),c);
    }
    
    public Double Weber(Double a, Double b){
        Double term;
        term = (a + b + c*a*b - 1)/(1 + c);
        return max(0.0,term);
    }
    
    public Double Yu(Double a, Double b){
        Double term;
        term = (1 + c)*(a + b -1) - c*a*b;
        return max(0.0,term);
    }
    
    Double min(Double x, Double y){
        if(Double.compare(x , y) < 0){
            return x;
        }else{
            return y;
        }
    }

    Double max(Double x, Double y){
        if(Double.compare(x , y) < 0){
            return y;
        }else{
            return x;
        }
    }    

    @Override
    public Double evaluation(Double a, Double b) {
        if(mfName.compareTo("Producto") == 0)
            return product(a,b);
        if(mfName.compareTo("Intersection") == 0)
            return intersection(a,b);
        if(mfName.compareTo("Yager") == 0)
            return Yager(a,b);
        return 0.0;
    }

    @Override
    public Double evaluation(Integer a, Integer b) {
        if(mfName.compareTo("Producto") == 0)
            return product(mf1.evaluation(a),mf2.evaluation(a));
        if(mfName.compareTo("Intersection") == 0)
            return intersection(mf1.evaluation(a),mf2.evaluation(a));
        if(mfName.compareTo("Yager") == 0)
            return Yager(mf1.evaluation(a),mf2.evaluation(a));
        return 0.0;
    }

    public double[][] getPlotSet(){
        double [][]vector = null;
        vector = new double[stepCount][3];
        for(int x = 0; x < stepCount; x++){
            for(int y = 0; y < stepCount; y++){
                vector[x][0] = mf1.evaluation(x);
                vector[x][1] = mf2.evaluation(y);
                vector[x][2] = evaluation(x,y);
            }
        }
        return vector;
    }
}
