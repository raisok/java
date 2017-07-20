package java_learning;

public class Calculate_sum {
	public static void main (String[] args) {
		int i = 1;
		double temp2 = 1,sum=0;
		while(i <=20) {
			int temp = i;
			i++;
			temp2 = temp2 * temp;
			sum = sum + 1/temp2;

		}
		System.out.println(sum);
		System.out.println("-----------------------");
//书本的实例		
	      double sum2 = 0,a = 1;
	      int j = 1;
	      while(j <= 20)
	      {
	    	  sum2 = sum2+a;
	    	  j = j+1;
	    	  a = a*(1.0/j);
	      }
	      System.out.println(sum2);
	      
	}
}
