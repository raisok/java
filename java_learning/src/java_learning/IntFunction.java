package java_learning;

public class IntFunction {

	public static void main(String[] args) {
		//返回第一个大于等于参数的整数
		System.out.println("使用ceil()方法取整：" + Math.ceil(5.2));
		//返回第一个小于等于参数的整数
		System.out.println("使用floor()方法取整：" + Math.floor(2.5));
		//返回与参数最接近的整数
		System.out.println("使用rint()方法取整："+ Math.rint(2.7));
		//返回与参数最接近的整数
		System.out.println("使用rint()方法取整："+ Math.rint(2.5));
		//将参数加上0.5后返回最接近的整数
		System.out.println("使用round()方法取整：" + Math.round(3.4f));
		//将参数加上0.5后返回最接近的整数，并将结果强制转换为长整型
		System.out.println("使用round()方法取整：" + Math.round(2.5));
		//取两个数的较大者
		System.out.println("4和8较大者：" + Math.max(4, 8));
		//取两个数的较小者
		System.out.println("4.4和4较小者：" + Math.max(4.4, 4));
		//取绝对值
		System.out.println("-7的绝对值：" + Math.abs(-1));

	}

}
