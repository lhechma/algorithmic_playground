package org.lhechma.ChangeProblem;

import java.util.List;
import java.util.ArrayList;


public class ChangeProblemDP{
    public static void main(String... args){
        int[] denominators = {1,5,10,25};
        int change = 30;
        int[] solution = new int[change+1];
        for(int i=0; i<solution.length;i++){
            solution[i] = Integer.MAX_VALUE;
        }
        solution[0] = 0;
        Parent[] parents = new Parent[change+1];
        parents[0] = new Parent(0,-1);
        Parent NO_PARENT = new Parent(Integer.MAX_VALUE,Integer.MAX_VALUE);
        for(int i=1; i<=change; i++){
            parents[i] = NO_PARENT;
        }

        for(int i=0;i <= change; i++){
            for(int j = 0 ; j <denominators.length && i+denominators[j] <= change;j++){
                int compare = Integer.compare(solution[i+denominators[j]],solution[i]+1);
                if(compare > 0){
                    parents[i+denominators[j]] = new Parent(denominators[j],i);
                    solution[i+denominators[j]] = solution[i]+1;
                }
            }
        }

        int index = change;
        System.out.println("coins "+solution[index]);
        while(index != 0){
            System.out.println(parents[index].denominator);
            index = parents[index].parentIndex;
        }

    }

    private static class Parent{
        int denominator;
        int parentIndex;

        Parent(int denominator, int parentIndex){
            this.denominator = denominator;
            this.parentIndex = parentIndex;
        }
    }


}