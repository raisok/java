package extract_fasta;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;


public class FastaReader {
	
	//初始化一个reader对象，用于缓存？
	BufferedReader reader;
	//私有化一个字符串变量 inline值为null，这里null和空有啥区别？
	private String inline = null;
	//私有化一个字符串变量id为空
	private String id = "";
	//
	public FastaReader(String filename)throws IOException
	{
	    this(new File(filename));
	}

	public FastaReader(File filename) throws IOException
	{
		//如果是压缩文件
	    if (filename.getName().endsWith(".gz")) {
	      this.reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(filename))), 5242880);
	    }
	    else {
	      this.reader = new BufferedReader(new FileReader(filename), 5242880);
	    }

	    this.inline = this.reader.readLine();
	}

	public Fasta getNext()
	    throws IOException
	  {
	    StringBuilder sf = new StringBuilder();
	    this.id = this.inline;

	    while ((this.inline = this.reader.readLine()) != null)
	    {
	      if (this.inline.startsWith(">"))
	      {
	        return new Fasta(this.id, sf.toString());
	      }

	      sf.append(this.inline).append("\n");
	    }

	    return new Fasta(this.id, sf.toString());
	  }

	  public boolean hasNext() throws IOException
	  {
	    if (this.inline != null) {
	      return true;
	    }
	    this.reader.close();
	    return false;
	  }

	  public static void main(String[] args)
	    throws IOException
	  {
	    FastaReader fastareader = new FastaReader("E:\\菠萝相关项目\\菠萝-拟南芥-水稻共线性比较\\菠萝基因组数据\\pineapple.20150427.fasta");
	    Fasta fastaIterator;
	    while (fastareader.hasNext())
	      fastaIterator = fastareader.getNext();
	  }

}
