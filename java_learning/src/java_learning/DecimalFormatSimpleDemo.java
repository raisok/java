package java_learning;

import java.text.DecimalFormat;


public class DecimalFormatSimpleDemo {
	//使用实例化对象时设置格式化模式
	static public void SimgleFormat(String pattern,double value) {
		//实例化一个DecimalFormat对象
		DecimalFormat myFormat = new DecimalFormat(pattern);
		String output = myFormat.format(value);	//将数字进行格式化
		System.out.println(value + " " + pattern + " " + output);
	}
	//使用applyPattern()方法对数字进行格式化
	static public void UseApplyPatternMethodFormat(String pattern,double value) {
		DecimalFormat myFormat = new DecimalFormat();
		myFormat.applyPattern(pattern);
		System.out.println(value + " " + pattern + " " + myFormat.format(value));
	}
	
	public static void main(String[] args) {
		SimgleFormat("###,###.###",123456.789);
		SimgleFormat("00000000.###kg",123456.789);
		SimgleFormat("000000.000",123.78);
		UseApplyPatternMethodFormat("#.###%",0.789);
		UseApplyPatternMethodFormat("###.##",123456.789);
		UseApplyPatternMethodFormat("0.00\u2030",0.789);

	}

}
