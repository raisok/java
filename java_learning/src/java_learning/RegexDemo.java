package java_learning;

public class RegexDemo {

	public static void CheckQQ()
	{
		String qq = "182839";
		String regex = "[1-9][0-9] {4,14}";
		
		boolean flag = qq.matches(regex);
		if(flag)
			System.out.println(qq+"...is ok");
		else
			System.out.println(qq+"...nononnono");
	}
	
	public static void splitDemo(String str,String reg)
	{

		String[] arr = str.split(reg);
		System.out.println(arr.length);
		for(String s :arr)
		{
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		//CheckQQ();
		splitDemo("zhangsan  lisi  wangwu","\\s{2}");
		splitDemo("c:\\abc\\a.txt","\\\\");
		splitDemo("erkktyqquio","(.)\\1");

	}

}
