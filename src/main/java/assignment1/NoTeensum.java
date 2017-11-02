/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Arrays;


public class NoTeensum {
    
    public int noTeenSum(int a, int b, int c) {
        
       int sum1 = fixTeen(a);
       int sum2 = fixTeen(b);
       int sum3 = fixTeen(c);
       
       int totalsum = sum1+sum2+sum3;
       
       return totalsum;
   
  }

    public int fixTeen(int n) {
        
        if (Arrays.asList(13, 14, 17, 18, 19).contains(n) ) {
            return 0;
        }
        else return n;
    }
    
}
