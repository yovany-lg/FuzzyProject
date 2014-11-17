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
public interface Norm {
    public Double evaluation(Double a, Double b);
    public Double evaluation(Integer a, Integer b);
}
