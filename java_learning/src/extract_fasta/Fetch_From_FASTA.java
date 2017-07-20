package extract_fasta;


/*
 * 需求：编写一个能根据id提取对应的序列的类
 * 思路：
 * 1.读入一个fasta文件，并存为字典
 * 2.读取需要提取的id文件，并判断是否存在于字典的键，如果存在就打印出来
 * */

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Fetch_From_FASTA 
{
	//写一个类，具有一个方法，读入两个文件
	public static void ReadFasta(String fasta,String list) throws IOException
	{	
		Map<String, String> map = new HashMap<String, String>();
		
		FileReader fr = new FileReader(fasta);
		BufferedReader br = new BufferedReader(fr);
		
		String str = null; 
		String regex = "^>\\w+";

		String id = null;
		String seq = "";
		while((str = br.readLine()) != null)
		{
			//将>号作为换行符，如果匹配到>(\w+)\n,就当做字典的键
			if (str.matches(regex))
			{	id = str;
				seq = "";
			}
			else
			{
				seq = seq + str;	//如果不是>开头，说明是基因的序列，如果是多行需要将序列信息连接在一起
			}
			map.put(id, seq);
		}
		
		FileReader fr2 = new FileReader(list);
		BufferedReader br2 = new BufferedReader(fr2);
		String str2 = null;
		while((str2=br2.readLine()) != null)
		{
			String str3 = ">" + str2;
			boolean containsKey = map.containsKey(str3);
			if (containsKey == true)
				System.out.println(str3);
				System.out.println(map.get(str3));
		}
		
		fr2.close();
		/*
		 * 这里是迭代测试所存的哈希是否有问题
		Set<String> set = map.keySet();
		Iterator <String> it = set.iterator();
		System.out.println("key集合中的元素：");
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		Collection <String> coll = map.values();
		it = coll.iterator();
		System.out.println("values 集合中的元素：");
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		*/
		fr.close();
	}
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("第一个参数是："+args[0]);
		System.out.println("第二个参数是："+args[1]);
		ReadFasta(args[0],args[1]);
	}
}
