package java_learning;


/*
 * 字符流和字节流
 * 字节流两个基类
 * InputStream	OutputStream
 * */

import java.io.*;

class FileWriterDemo
{
	public static void main(String[] args) throws IOException 
	{	//创建一个FileWriter对象，该对象一旦初始化就必须要明确被操作的文件
		//而且该文件会被创建在指定目录下，如果该目录下已有同名文件，将被覆盖。
		//其实该步就是明确存放的目的地
		FileWriter fw = new FileWriter("demo.txt");
		//调用wirte方法，将字符串写入到流中
		fw.write("xxx");
		fw.flush();
		fw.write("abscd");
		//关闭流资源，但是关闭之前会刷新一次内部的缓冲中的数据
		//将数据刷到目的地中和flush的区别，flush刷新后流可以继续使用，close刷新后，会将流关闭
		fw.close();
	}
}