
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Testt {

	static Object mostFrequent(Object arr[], int n)
	{

		// Insert all elements in hash
		Map<Integer, Integer> hp =
				new HashMap<Integer, Integer>();

		for(int i = 0; i < n; i++)
		{
			try {
				int key = (Integer) arr[i];
				if(hp.containsKey(key))
				{
					int freq = hp.get(key);
					freq++;
					hp.put(key, freq);
				}
				else
				{
					hp.put(key, 1);
				}



			}catch(ClassCastException ex) {
				return "Invalid input";
			}
			catch(NullPointerException ex) {
				return "Invalid input";
			}
		}
		int max_count = 0, res = -1;
		for(Entry<Integer, Integer> val : hp.entrySet())
		{
			if (max_count < val.getValue())
			{
				res = val.getKey();
				max_count = val.getValue();
			}
		}

		return res;
	}


	// find max frequency.


	// Driver code
	public static void main (String[] args) {

		Object[] arr = {false,3,2,3,3,5};
		int n = arr.length;

		System.out.println(mostFrequent(arr, n));
	}
}

