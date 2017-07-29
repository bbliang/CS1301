public class Stat { //1. default constructor w/o parameters
	private double[] data;
	
	public Stat() {
		data = new double[0];
	}
		
	public Stat(double[] d) { //2. second constructor with double[] parameter
		setData(d);
	}
	
	public Stat(float[] f) { //3. third constructor with float[] parameter
		setData(f);
	}
	
	public Stat(int[] i) { //4. fourth constructor with int[] parameter
		setData(i);
	}
	
	public Stat(long[] lo) { //5. fifth constructor with long[] parameter
		setData(lo);
	}
	
	public void setData(float[] f) { //6. mutator method for float[] data
		double[] newArray = new double[0];
		if (f != null) {
			newArray = new double[f.length];
				
			for (int i = 0; i < f.length; i++) {
				newArray[i] = f[i];
			}
		}
		data = newArray;
	}
	
	public void setData(double[] d) { //7. mutator method for double[] data
		double[] newArray = new double[0];
		if (d != null) {
			newArray = new double[d.length];
				
			for (int i = 0; i < d.length; i++) {
				newArray[i] = d[i];
			}
		}
		data = newArray;
	}
	
	public void setData(int[] i) { //8. mutator method for int[] data
		double[] newArray = new double[0];
		if (i != null) {
			newArray = new double[i.length];
				
			for (int j = 0; j < i.length; j++) {
				newArray[j] = i[j];
			}
		}
		data = newArray;
	}
	
	public void setData(long[] lo) { //9. mutator method for long[] data
		double[] newArray = new double[0];
		if (lo != null) {
			newArray = new double[lo.length];
				
			for (int i = 0; i < lo.length; i++) {
				newArray[i] = lo[i];
			}
		}
		data = newArray;
	}
	
	public double[] getData() { //10. accessor method for data
		return data;
	}
	
	public boolean equals(Stat s) { //11. test equality between two Stat objects
		boolean equality = true;
		
		if (s != null && s.data.length == data.length) {
			for (int i = 0; i < s.data.length; i++) {
				if (Math.abs(s.data[i] - data[i]) > 0.001) {
					equality = false;
					break;
				}
			}
		}
		else {
			equality = false;
		}
		return equality;
	}
	
	public void reset() { //12. reset data
		data = new double[0];
	}
	
	public void append(int[] i) { //13. appends int[] to data
		if (i != null) {
			double[] newArray = new double[data.length + i.length];
			
			for (int j = 0; j < newArray.length; j++) {
				if (j < data.length)
					newArray[j] = data[j];
				else
					newArray[j] = i[j - data.length];
			}
			
			data = newArray;
		}
	}
	
	public void append(float[] f) { //14. appends float[] to data
		if (f != null) {
			double[] newArray = new double[data.length + f.length];
			
			for (int j = 0; j < newArray.length; j++) {
				if (j < data.length)
					newArray[j] = data[j];
				else
					newArray[j] = f[j - data.length];
			}
			
			data = newArray;
		}
	}
	
	public void append(long[] lo) { //15. appends long[] to data
		if (lo != null) {
			double[] newArray = new double[data.length + lo.length];
			
			for (int j = 0; j < newArray.length; j++) {
				if (j < data.length)
					newArray[j] = data[j];
				else
					newArray[j] = lo[j - data.length];
			}
			
			data = newArray;
		}
	}
	
	public void append(double[] d) { //16. appends double[] to data
		if (d != null) {
			double[] newArray = new double[data.length + d.length];
			
			for (int j = 0; j < newArray.length; j++) {
				if (j < data.length)
					newArray[j] = data[j];
				else
					newArray[j] = d[j - data.length];
			}
			
			data = newArray;
		}
	}
	
	public boolean isEmpty() { //17. return boolean data is empty
		return data.length == 0;
	}
	
	public String toString() { //18. override toString to formatted string
		if (isEmpty()) //empty case
			return "[]";
		String s = "[";
		for (int i = 0; i < data.length; i++) {
			s += data[i];
			if (i == data.length - 1)
				s += "]";
			else 
				s += ", ";
		}
		
		return s;
	}
	
	public double min() { //19. return minimum value of an array
		if (!isEmpty()) {
			double min = data[0];
			for (int i = 0; i < data.length; i++) {
				if (min > data[i])
					min = data[i];
			}
			
			return min;
		}
		else
			return Double.NaN;
	}
	
	public double max() { //20. return maximum value of an array
		if (!isEmpty()) {
			double max = data[0];
			for (int i = 0; i < data.length; i++) {
				if (max < data[i])
					max = data[i];
			}
			
			return max;
		}
		else 
			return Double.NaN;
	}
	
	public double average() { //21. return average of an array
		if (!isEmpty()) {
			double sum = 0;
			for (int i = 0; i < data.length; i++) {
				sum += data[i];
			}
			return sum / data.length;
		}
		else
			return Double.NaN;
	}
	
	public double mode() { //22. return mode of an array
		if (!isEmpty()) {
			double mode = 0, iteration = 1;
			
			for (int i = 0; i < data.length; i++) {
				int temp = 0;
				for (int j = i; j < data.length; j++) {
					if (Math.abs(data[i] - data[j]) <= 0.001)
						temp++;
				}
				if (temp > iteration) {
					mode = data[i];
					iteration = temp;
				}
				else if (temp == iteration) {
					mode = Double.NaN;
				}
			}
			
			
			return mode;
		}
		else
			return Double.NaN;
	}
	
	private int occursNumberOfTimes(double d) { //23. return # of times d appears in data
		int counter = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == d)
				counter++;
		}
		
		return counter;
	}
	
	public double variance() { //24. return variance of data
		if (!isEmpty()) {
			double distance = 0;
			
			for (int i = 0; i < data.length; i++)
				distance += Math.pow(data[i] - average(), 2);
			
			return distance / data.length;
		}
		else
			return Double.NaN;
		
	}
	
	public double standardDeviation() { //25. returns standard deviation of data
		return Math.sqrt(variance());
	}
}
