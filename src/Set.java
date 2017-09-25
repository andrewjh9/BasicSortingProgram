/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author AndrewHeath
 */
public class Set {
    private ArrayList<Integer> numberSet ;
  
  public Set(){
      numberSet= new ArrayList<Integer>();
  }
  public void addArrayToSet(int[] array) {
	  for (int i = 0; i < array.length; i++) {
		numberSet.add(array[i]);
	}
  }
  public void addToSet(int number){
    numberSet.add(number);
  }
  public ArrayList<Integer> getNumberSet(){
      return numberSet;
  }
  
  public void bubbleSort() {
	  int n = 0;
	  int temp=0;
	  Integer[] numberSetA = new Integer[numberSet.size()];
	  numberSetA = numberSet.toArray(numberSetA);

	  n = numberSet.size();
			 for(int i=0;i<n-1;i++) {
				 for (int j = 0; j < n-i-1; j++) {
					 if(numberSet.get(j)>numberSet.get(j+1)){
								temp=numberSet.get(j); 
								numberSet.set(j,numberSet.get(j+1));
								numberSet.set(j+1,temp);		
						 }
				}
			
		 }	
		 for (int i = 0; i < numberSet.size(); i++) {
			 System.out.println(numberSet.get(i));
		}
		
	
	  
	  
  }
/*  public void quickSort(ArrayList<Integer> numberSet) {
	  if(numberSet.size()>1) {
		  int  pivot = numberSet.size()/2;
		  int left=numberSet.get(0);
		  int right=numberSet.size();
		  
		  while (left <= right){
			  while (numberSet.get(left)<pivot){
				  left++;
			  }
			  while (numberSet.get(right)>pivot){
				  right--;
			  }
			  if(left<=right) {
				  int temp = numberSet.get(left);
				  numberSet.set(left,numberSet.get(right));
				  numberSet.set(right,numberSet.get(temp));
			  }
			  ArrayList<Integer> al = new ArrayList<Integer>();
			  for(int i=0;i<=right;i++) {
				  al.add(numberSet.get(i));
			  }
			  quickSort(al);
			  ArrayList<Integer> al2 = new ArrayList<Integer>();
			  for(int i=left;i<=numberSet.size();i++) {
				  al.add(numberSet.get(i));
			  }
			  quickSort(al2);
		  }
		  
		  
	  }
	  System.out.println(numberSet);
  }*/

}
