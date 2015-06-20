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
public class QuestionStat {
    public int yes;
    public int no;
    public int notApplicable;
    public int total;

    public QuestionStat(int yes, int no, int notApplicable) {
        this.yes = yes;
        this.no = no;
        this.notApplicable = notApplicable;
        this.total=yes+no+notApplicable;
    }
    
    public QuestionStat(int yes, int no, int notApplicable, int total){
        this.yes = yes;
        this.no = no;
        this.notApplicable = notApplicable;
        this.total=total;        
    }
    
    
}
