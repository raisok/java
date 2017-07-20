package java_learning;

public class Lingxing {

	public static void main(String[] args) {
		int linenum = 13;	//总共有13行，菱形分成两部分，第一部分为递增，第二部分为递减
		int maxLineNum = (linenum+1)/2;
		for (int i=1; i <= maxLineNum;i++) {
			//循环菱形数量越来越多的几行
			//计算循环过程中空格的数量,空格数量等于最后一行-当前行数
			for(int space=1;space<=(linenum+1)/2-i;space++) {
				System.out.print("  ");
			}
			for(int star=1;star <= (i*2)-1;star++) {
				//输出星号，数量=行数*2-1
				System.out.print("* ");
			}
			System.out.println();
		}
		//循环打印菱形的下半部分
		int declineCount = linenum - maxLineNum;// 计算剩下的几行，这几行星号的数量是递减的
		for(int i=1;i <= declineCount;i++) {
			for(int space=1;space <= i;space++) {	//输出空格，数量=当前行数
				System.out.print("  ");
			}
			for(int star=1;star <=(linenum -(linenum+1)/2 -i +1)*2-1;star++) {// 输出星号，数量等于（总数-当前行数）*2-1
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
