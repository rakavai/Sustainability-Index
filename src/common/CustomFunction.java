/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.text.DecimalFormat;

/**
 *
 * @author rakib
 */
public class CustomFunction {

    public static int combination(int n, int r) {
        return permutation(n) / (permutation(r) * permutation(n - r));
    }

    public static int permutation(int n) {
        if (n == 1) {
            return 1;
        }
        return n * permutation(n - 1);
    }

    public static String toTwoDecimal(double value) {
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(value);
    }
}
