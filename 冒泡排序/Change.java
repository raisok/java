//将数组1的前三个元素赋值给数组2
public class Change {

	public static void main (String[] args)
	{
		int[] array1 = {1,2,3,4,5,6};
		int[] array2 = {2,3,4,2,3,4};
		Change exchange = new Change();

		System.out.println("原始的数组1为:");
		exchange.showArray(array1);
		System.out.println("原始的数组2为:");
		exchange.showArray(array2);
	
		for (int i =0;i<=2;i++)
		{
			array2[i] = array1[i];
		}

		System.out.println("改变后的数组1为:");
		exchange.showArray(array1);
		System.out.println("改变后的数组2为:");
		exchange.showArray(array2);

	}

//如果想要调用这个方法，需要初始化一个类
	public void showArray(int[] array)
	{
		for(int i : array)
		{
			System.out.print("\t"+i);
		}
		System.out.println();
	}
}