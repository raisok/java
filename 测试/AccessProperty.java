public class AccessProperty{
	static int i =47;
	public void call(){
		System.out.println("调用call()方法");
		for(i=0;i<3;i++){
			System.out.print(i+" ");
			if(i ==2){
				System.out.println("\n");
			}
		}
	}
	public AccessProperty(){
		
	}
	public static void main(String[] args){
		AccessProperty t1 = new AccessProperty();
		AccessProperty t2 = new AccessProperty();
//由于初始化的i的变量值是47，故打印结果也为47
		System.out.println("第一个实例对象调用变量i的结果: "+ t1.i);
		System.out.println("第二个实例对象调用变量i的结果: "+ t2.i);
		System.out.println("对第二个对象t2的i的变量赋值为60: ");
		t2.i = 60;
//这里由于t2.i是对i的值进行了改变，故i的值此时为60
		System.out.println("第一个实例对象调用变量i的结果: " +t1.i);
		System.out.println("---------------------------------------");
//这里打印出来的结果是60是因为打印的值是t1.i，打印的是自增前的结果
		System.out.println("第一个实例对象调用变量i的结果: " +t1.i++);
//这里打印的是自增之后的值
		System.out.println("自增之后的i的变量值为: "+t1.i);
		System.out.println("---------------------------------------");
//调用call方法之后i的值会改变
		t1.call();
		System.out.println("调用call之后的第一个实例的i的值为: "+t1.i);
//这里的i为3是因为调用call之后i的值由0循环增加至3，但是不满足循环条件退出了，但是i的值依然是3
		System.out.println("第二个实例对象调用变量i的结果: " +t2.i);
		t2.call();
	}
	
}
