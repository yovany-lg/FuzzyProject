    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
class pair<L, R> 
{
 
    private L l;
    private R r;
    public pair(L l, R r)
    {
        this.l = l;
        this.r = r;
    }
    public L getL()
    {
        return l; 
    }
    public R getR()
    { 
        return r; 
    }
    public void setL(L l)
    { this.l = l; 
    }
    public void setR(R r)
    { this.r = r; 
    }
}    

