package com.company;

public class CheckIfDead {
    boolean check(int i,int w,int f,int m,boolean warehouse){
        if(i<=0 )
        {
            return true;
        }
        else if(w<=0)
        {
            return true;
        }
        else if(m<=0)
        {
            return true;
        }
        else if(f<=0)
        {
            if(warehouse==false)
            return true;
            else return false;
        }
        return  false;
    }
}
