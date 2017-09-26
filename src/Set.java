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
public class Set extends ArrayList<Integer>{

  public void addToSet(int number){
    this.add(number);
  }

  public void bubbleSort() {
	  int tempHolder = 0;
	  for (int i = 0; i < this.size() - 1; i++) {
		  for (int j = 0; j < this.size() - i - 1; j++) {
			  if (this.get(j) > this.get(j + 1)) {
				  tempHolder = this.get(j);
				 this.set(j, this.get(j + 1));
				  this.set(j + 1, tempHolder);
			  }
		  }

	  }

  }
}
