package java_learning;

import java.io.*;


public class FileReaderTest {

	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("xxx.java");
		
		char [] buf = new char[1024];
		
		int num = 0;
		
		while((num = fr.read(buf)) != -1)
		{
			System.out.print(new String(buf,0,num));
		}
		
		fr.close();
	}

}
