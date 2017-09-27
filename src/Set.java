


import java.util.ArrayList;

import static java.lang.StrictMath.sqrt;

/**
 * @class Extends ArrayList<Integer> Add methods for mathematical analysis of arrayList content
 * @version 0.2
 * @author AndrewHeath
 */
public class Set extends ArrayList<Integer>{

  public void addToSet(int number)
  {
    this.add(number);
  }

  public void bubbleSort()
  {
	  int tempHolder = 0;
	  for (int i = 0; i < this.size() - 1; i++)
	  {
		  for (int j = 0; j < this.size() - i - 1; j++)
		  {
			  if (this.get(j) > this.get(j + 1))
			  {
				  tempHolder = this.get(j);
				 this.set(j, this.get(j + 1));
				  this.set(j + 1, tempHolder);
			  }
		  }

	  }

  }
	//A series of methods for calculating various statistical values
	public double getMean()
  {
	  int sum = 0;
	  for (int count = 0;count < this.size(); count++)
	  {
		  sum += get(count);
	  }
	  return (float)sum / this.size();
  }
  public double getSd()
  {
	  return sqrt(variance());
  }

	/**
	 * @brief Calculates the top part of the variance
	 * @return
	 */
  private float variance()
  {
	  float variance =0;
	  for(int count=0;count<this.size();count++)
	  {
		  variance+=Math.pow(this.get(count)-getMean(),2);
	  }

	return variance/(this.size()-1);
  }
	public int largest()
	{
		bubbleSort();
		return get((size()-1));
	}
	public int smallest()
	{
		bubbleSort();
		return get(0);
	}
	public String getRange()
	{
  		return Integer.toString(smallest())+" -> "+Integer.toString(largest());
	}
	public int rangeValue()
	{
  		return largest()-smallest();
	}
	private  float getMedian(){
  		if(size()%2==0){
  			bubbleSort();
			return get(size()/2);
		}
			return 0;

	}

}
