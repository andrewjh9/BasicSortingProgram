import static org.junit.Assert.*;

import org.junit.Test;

public class TestSet {

	@Test
	public void test() {
		Set set = new Set();
		int[] array = new int[50];
		for(int i = 0; i < array.length; i++) {
		   array[i] = (int)(Math.random()*99 + 1);
		}
		set.addArrayToSet(array);
		set.bubbleSort();
		for (int i = 0; i < set.getNumberSet().size(); i++) {
			if(set.getNumberSet().get(i)>set.getNumberSet().get(i+1)) {
		
				fail("Bubble Sort has failed");
			}
		}
	}

}
