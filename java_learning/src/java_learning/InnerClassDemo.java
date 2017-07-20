package java_learning;
/*
 * 内部类访问规则：
 * 1.内部类可以直接访问外部类中的成员，包括私有
 * 2.外部类要访问内部类，需要建立内部类对象
 * */
class Outer
{
	private int x = 3;
	class Inner
	{
		void function()
		{
			System.out.println("inner :" + x);
		}
	}
	
	void method()
	{
		Inner in = new Inner();
		in.function();
	}
}


class InnerClassDemo {

	public static void main(String[] args) {
		Outer out = new Outer();
		out.method();

	}

}
