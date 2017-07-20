package java_learning;

public class Tautog {

	public static void main(String[] args) {
				int arr2[][] = {{4,3},{1,2}};
				System.out.println("数组中的元素是：");
				int i = 0;
				for(int x[] : arr2) {
					i++;
					int j = 0;
					for (int e : x) {
						j++;
						if(i == arr2.length && j == x.length) {	//判断变量是二维数组中的最后一个元素
							System.out.print(e);	//输出二维数组中的最后一个元素	
						}else {
							System.out.print(e + "、");
						}
					}
				}
	}

}
