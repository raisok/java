package java_learning;


//this的应用：当定义类中功能时，该函数内部要用到调用该函数的对象时，这时用this来表示这个对象。

public class PersonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person();
		Person p2 = new Person("zhangsan");
	}

}

class Person{
	private String name;
	private int age;
	
	Person()
	{
		System.out.println("A: name="+name+",,age="+age);
	}
	//构造函数
	Person(String name)
	{
		//this就代表本类的对象，代表它所在函数所属对象的引用，简单说那个对象调用this所在的函数，this就代表那个对象
		this.name = name ;
		System.out.println("B :name="+name+",,age="+age);
	}
	
	Person(String name, int age)
	{
		this.name = name ;
		this.age = age;
		System.out.println("C :name="+name+",,age="+age);
	}
	
	public void cry()
	{
		System.out.println("cry....");
	}
	//构造代码块中定义的是不同对象共性的初始化内容
	{
		cry();
		//System.out.println("person code run");
	}
}