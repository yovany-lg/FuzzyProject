/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package fuzzysets;

/**
 *
 * @author yova
 */
public class tConorm implements Norm{
    public Double c = 0.5;
    public String mfName = "";
    private MF mf1,mf2;
    Integer stepCount = 20;
    
    public tConorm(String mf){
        this.mfName = mf;
    }
        
    public tConorm(String mf,MF mf1,MF mf2){
        this.mfName = mf;
        this.mf1 = mf1;
        this.mf2 = mf2;
    }

    public tConorm(String mf,Double c,MF mf1,MF mf2){
        this.mfName = mf;
        this.c = c;    
        this.mf1 = mf1;
        this.mf2 = mf2;
    }
   
    public Double union(Double a, Double b){
        return max(a,b);
    }

    public Double Dombi(Double a, Double b){
        Double aTerm, bTerm;
        aTerm = Math.pow( (1/a) - 1 ,c);
        bTerm = Math.pow((1/b) - 1 ,c);
        
        return Math.pow( 1 + Math.pow(aTerm + bTerm,-1/c),-1);
    }
    
    public Double Frank(Double a, Double b, Integer s){
        Double aTerm, bTerm;
        aTerm = Math.pow(s,1 - a) - 1;
        bTerm = Math.pow(s,1 - b) - 1;
        
        return 1 - log((1 + aTerm*bTerm/(s - 1)),s);
    }

    public Double Hamacher(Double a, Double b){
        return (a + b +(c - 2)*a*b)/(c + (c-1)*a*b);
    }

    public Double SchweizerSklar1(Double a, Double b){
        Double term,aTerm,bTerm;
        aTerm = Math.pow(1 - a,c);
        bTerm = Math.pow(1 - b,c);
        term = Math.pow( max(0.0,aTerm + bTerm - 1) , 1/c);
        return 1 - term;
    }
    
    public Double SchweizerSklar2(Double a, Double b){
        Double term;
        term = Math.pow(a,c) + Math.pow(b,c) - Math.pow(a,c)*Math.pow(b,c);
        return Math.pow(term,1/c);
    }

    public Double SchweizerSklar3(Double a, Double b){
        Double aTerm,bTerm;
        aTerm = Math.pow( Math.abs( Math.log(1 - a) ) , c);
        bTerm = Math.pow( Math.abs( Math.log(1 - b) ) , c);
        return 1 - Math.exp( -Math.pow(aTerm + bTerm, 1/c) );
    }
    
    public Double SchweizerSklar4(Double a, Double b,Double p){
        Double aTerm,bTerm;
        aTerm = Math.pow( 1 - a , c);
        bTerm = Math.pow( 1 - b , c);
        return 1 - (1 - a)*(1 - b)/Math.pow(aTerm + bTerm - aTerm*bTerm,1/c);
    }

    public Double Yager(Double a, Double b){
        Double term;
        term = Math.pow( Math.pow(a,c) + Math.pow(b,c) ,1/c);
        return min(1.0,term);
    }

    public Double DuboisPrade(Double a, Double b){
        return 1 - (1 - a)*(1 - b)/max(max(1 - a,1 - b),c);
    }

    public Double Weber(Double a, Double b){
        Double term;
        term = a + b - (c / (1 - c))*a*b;
        return min(1.0,term);
    }

    public Double Yu(Double a, Double b){
        Double term;
        term = a + b + c*a*b;
        return min(1.0,term);
    }
    
    static Double log(Double x, int base)
    {
        return (Math.log(x) / Math.log(base));
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
        if(mfName.compareTo("Union") == 0)
            return union(a,b);
        if(mfName.compareTo("Yager") == 0)
            return Yager(a,b);
        return 0.0;
    }

    @Override
    public Double evaluation(Integer a, Integer b) {
        if(mfName.compareTo("Union") == 0)
            return union(mf1.evaluation(a),mf2.evaluation(a));
        if(mfName.compareTo("Yager") == 0)
            return Yager(mf1.evaluation(a),mf2.evaluation(a));
        return 0.0;
    }

    public double[][] getPlotSet(){
        double [][]vector = null;
        vector = new double[stepCount*stepCount][3];
        int count = 0;
        for(int x = 0; x < stepCount; x++){
            for(int y = 0; y < stepCount; y++){
                vector[count][0] = mf1.getX(x);
                vector[count][1] = mf2.getX(y);
                vector[count][2] = evaluation(x,y);
                count++;
            }
        }
        return vector;
    }
}
