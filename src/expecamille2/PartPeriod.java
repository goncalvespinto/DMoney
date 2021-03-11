/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expecamille2;

/**
 *
 * @author thevenet
 */
public class PartPeriod {
    int period;
    int part;

    public PartPeriod(int pe , int pa) {
        part =pa;
        period =pe;
    
    
    }
    
    boolean isEqual(PartPeriod p)
    {
        if ( p.part == part && p.period == period)
        {
            return true;
        }
        
        
        return false;
    }
    
    
}
