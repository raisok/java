package java_learning;


import java.io.*;

public class FileReaderDemo 
{

	public static void main(String[] args) throws IOException
	{
		//创建一个文件读取流对象，和指定名称的文件相关联
		//要保证该文件是已经存在的，如果不存在，会发生异常
		FileReader fr = new FileReader("dem1.txt");
		//调用读取流对象的read方法
		//read() 一次读取一个字符，而且会自动往下读
		
		int ch =0;
		while((ch = fr.read()) != -1)
		{
			System.out.println("ch=" + (char)ch);
		}
		/*
		while(true)
		{
			int ch = fr.read();
			if(ch == -1)
				break;
			System.out.println("ch="+(char)ch);
		}
		*/
		fr.close();
	}

}
