package java_learning;

import java.io.*;


class CopyText 
{

	public static void main(String[] args) throws IOException
	{
		//copy1();
		copy2();
	}
	
	public static void copy2() 
	{
		FileWriter fw = null;
		FileReader fr = null;
		
		try
		{
			fw = new FileWriter("Matrix_copy.txt");
			fr = new FileReader("Matrix.java");
			
			char [] buf = new char[1024];
			
			int len =0;
			while(( len = fr.read(buf)) != -1)
			{
				fw.write(buf,0,len);
			}
		}
		catch(IOException e)
		{
			throw new RuntimeException("读写失败");
		}
		finally
		{
			if(fr != null)
				try
				{
					fr.close();
				}
				catch(IOException e)
				{
					
				}
			if (fw != null)
				try
				{
					fw.close();
				}
				catch(IOException e)
				{
					
				}
		}
		
	}
	//从C盘读一个字符，就往D盘写一个字符
	public static void copy1() throws IOException
	{
		//创建目的地
		FileWriter  fw = new FileWriter("xxx.txt");
		//与已有文件关联
		FileReader fr = new FileReader("Matrix.java");
		
		int ch = 0;
		while((ch=fr.read()) != -1)
		{
			fw.write(ch);
		}
		
		fw.close();
		fr.close();
	}
}
