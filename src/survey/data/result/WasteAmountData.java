/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data.result;

/**
 *
 * @author rakib
 */
public class WasteAmountData {
    public String wasteSector;
    public double totalWasteAmount;
    public double recyclingPercentage;

    public WasteAmountData(String wasteSector, double totalWasteAmount, double recyclingPercentage) {
        this.wasteSector = wasteSector;
        this.totalWasteAmount = totalWasteAmount;
        this.recyclingPercentage = recyclingPercentage;
    }
}
