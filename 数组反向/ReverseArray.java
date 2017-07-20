// 对数组进行反向

public class ReverseArray{
	public static void main(String[] args){
		int[] array = {10,20,30,40,50,60};
		ReverseArray rev = new ReverseArray();
		rev.reverse(array);
	}
	
	public void reverse(int[] array){
		System.out.println("原来的数组为:");
		showArray(array);
		int temp;
		int len = array.length;
		for (int i=0;i < len/2;i++){
			temp = array[i];
			array[i] = array[len-i-1];
			array[len-i-1] = temp;
		}
		System.out.println("反向后的数组为:");
		showArray(array);
	}
	
	public void showArray(int[] array){
		for(int i:array){
			System.out.print("\t" + i);
		}
		System.out.println();
	}
}