package org.lhechma.ChangeProblem;

import java.lang.Comparable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ChangeProblem{
	
	public static void main(String... args){
	    int[] denominators = {1,5,10,25};
		Set<Change> solutionSpace = new TreeSet<>();
		doFindChange(77,denominators,new LinkedList<Integer>(), solutionSpace);
		System.out.println(solutionSpace.iterator().next());
		
	}
	
	private static void doFindChange(int amount, int[] denominators, LinkedList<Integer> coins , Set<Change> solutions  ){
		if(amount ==0){
			solutions.add(new Change(coins));
		    return;
		}else if(amount < 0){
			return;
		}
		for(int i =0;i < denominators.length; i++){
		   coins.add(denominators[i]);
		   doFindChange(amount - denominators[i],denominators,coins,solutions);
           coins.removeLast();		   
		}
		
	}
	
	private static class Change implements Comparable<Change>{
	     private List<Integer> coins;
		 
		 private Change(List<Integer> coins){
		    this.coins = Collections.unmodifiableList(coins);
		 }
		 
		public int compareTo(Change other){
		     return Integer.compare(this.coins.size(),other.coins.size());
		}
	}
}