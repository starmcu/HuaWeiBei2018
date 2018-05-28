package com.starmcu.git.junit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.elasticcloudservice.predict.Flavor;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class HuaWeiTest {

	/**
	 * 对日期的处理，比如把年月日转成long
	 * 
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	@Test
	public void test() throws ParseException, java.text.ParseException {

		Calendar now = Calendar.getInstance();
		System.out.println("年: " + now.get(Calendar.YEAR));
		System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");
		System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));
		System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));
		System.out.println("分: " + now.get(Calendar.MINUTE));
		System.out.println("秒: " + now.get(Calendar.SECOND));
		System.out.println("当前时间毫秒数：" + now.getTimeInMillis());
		System.out.println(now.getTime());

		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr = sdf.format(d);
		System.out.println("格式化后的日期：" + dateNowStr);
		String str = "5015-01-01 05:05:33"; // 要跟上面sdf定义的格式一样
		String str2 = "14015-01-01 00:00:00"; // 要跟上面sdf定义的格式一样
		Date today = sdf.parse(str);
		Date today2 = sdf.parse(str2);
		System.out.println("字符串转成日期：" + today2);
		long time = today.getTime();
		long time2 = today2.getTime();
		// System.out.println(time);
		System.out.println(time2 / 24 / 60 / 60 / 1000);
		// long res =time-time%86400000;
		// System.out.println(res);

	}

	/**
	 * 
	 * 时间工具的处理结束，按天来计算的时间
	 * 
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	@Test
	public void test2() throws ParseException, java.text.ParseException {
		System.out.println(Flavor.dateToString("2015-02-28"));
		System.out.println(Flavor.dateToString("2015-03-01"));
		System.out.println(Flavor.dateToString("2015-03-01") - Flavor.dateToString("2015-02-28"));

	}

	public static void main(String[] args) throws ParseException, java.text.ParseException {

	}

	/**
	 * 
	 * 
	 * 把虚拟转换成数字量。
	 */
	@Test
	public void test3() throws ParseException, java.text.ParseException {
			System.out.println(Flavor.flavorNameToInt("flavor9"));
	}
	
	
	
	/**
	 * 
	 * 
	 * 测试一阶
	 */
	@Test
	public void test4() throws ParseException, java.text.ParseException {
		System.out.println(Flavor.jisuanyicipinghuaA(new int[]{1,2,5,9,3,5,7,8,2}));
		
	}
	
	/**
	 *  
	 * 测试一阶
	 */
	@Test
	public void test5() throws ParseException, java.text.ParseException {
		int[] temp=Flavor.shuzupinghua(new int[]{1,2,5,9,3,5,7,8,2});
		System.out.println(temp);
		
	}
}

//
// Java代码一行一行读取txt的内容
// public static void main(String[] args) {
// // 文件夹路径
// String path = "E:\\eclipse work\\ImageUtil\\src\\scan.txt";
// List<String> scanListPath = readFile02(path);
// }
//
//
//
/// **
// * 读取一个文本 一行一行读取
// *
// * @param path
// * @return
// * @throws IOException
// */
// public static List<String> readFile02(String path) throws IOException {
// // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
// List<String> list = new ArrayList<String>();
// FileInputStream fis = new FileInputStream(path);
// // 防止路径乱码 如果utf-8 乱码 改GBK eclipse里创建的txt 用UTF-8，在电脑上自己创建的txt 用GBK
// InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
// BufferedReader br = new BufferedReader(isr);
// String line = "";
// while ((line = br.readLine()) != null) {
// // 如果 t x t文件里的路径 不包含---字符串 这里是对里面的内容进行一个筛选
// if (line.lastIndexOf("---") < 0) {
// list.add(line);
// }
// }
// br.close();
// isr.close();
// fis.close();
// return list;
// }
