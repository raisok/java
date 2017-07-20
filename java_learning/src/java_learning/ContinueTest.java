package java_learning;

public class ContinueTest {

	public static void main(String[] args) {
		for (int i = 1; i < 20;i++) {
			//如果i除以2的余数为0，就不打印继续下一个循环
			if (i % 2 == 0) {
				continue;
			}
			System.out.println(i);
		}

	}

}
