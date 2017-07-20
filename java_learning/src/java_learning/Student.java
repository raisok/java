package java_learning;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Student {

	public static void main(String[] args) {
		String content[] = {"好久不见","最近好吗","常联系"};
		File file = new File("word.txt");
		try {
			FileWriter fw = new FileWriter(file);
			//创建BufferedWriter类对象
			BufferedWriter bufw = new BufferedWriter(fw);
			for (int k = 0;k < content.length;k++) {	//循环遍历数组
				bufw.write(content[k]);	//将字符串数组中的元素写入到磁盘文件中
				bufw.newLine();	//将数组中的单个元素以单行的形式写入文件
			}
			bufw.close();
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			FileReader fr = new FileReader(file);	//创建FileReader类对象
			//创建BufferedReader类对象
			BufferedReader bufr = new BufferedReader(fr);
			String s = null;
			int i = 0;
			//如果文件的文本行数不为null，则进入循环
			while((s = bufr.readLine()) != null) {
				i++;
				System.out.println("第"+ i + "行:" + s );
			}
			bufr.close();
			fr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
