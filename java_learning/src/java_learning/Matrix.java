package java_learning;

public class Matrix {

	public static void main(String[] args) {
		//int a[][] = new int[3][4];
		int a[][] = new int[][] {{1},{2,3},{4,5,6}};
		for(int i = 0;i < a.length;i++) {
			for(int j = 0; j < a[i].length;j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		
	}

}

