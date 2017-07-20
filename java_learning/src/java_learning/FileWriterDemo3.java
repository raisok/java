package java_learning;

import java.io.*;

/*
 * 演示对已有文件数据的续写
 * */

public class FileWriterDemo3 {

	public static void main(String[] args) {
		
		FileWriter fw = null;
		try
		{	
			fw = new FileWriter("dem1.txt",true);
			fw.write("你好\r\n谢谢");

		}
		catch(IOException e)
		{
			System.out.println("catch:"+e.toString());
		}
		finally
		{
			try
			{
				if (fw != null)
				{
					fw.close();
				}
			}
			catch(IOException e) 
			{
				System.out.println(e.toString());
			}
		}
	}

}
