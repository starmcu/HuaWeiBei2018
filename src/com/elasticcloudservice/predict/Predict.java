package com.elasticcloudservice.predict;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Predict {

	public static String[] predictVm(String[] ecsContent, String[] inputContent) {

		Flavor.ecsInfoDeal(inputContent);//读取信息
//		System.out.println(inputContent);

		
		// 处理数据ecsContent
		Flavor.tranFlavorArr = Flavor.genArr2(ecsContent);// 二维数组，保存虚拟机数据
		
		//在此修改算法：
		
		//只对需要处理的虚拟机进行计算
//		Flavor.a  = new double[Flavor.tranFlavorArr.length];// 一次平滑的算法确定长度
//		Flavor.a2 = new double[Flavor.tranFlavorArr.length];// 二次平滑的算法确定长度
//		Flavor.a3 = new double[Flavor.tranFlavorArr.length];// 三次平滑的算法确定长度
		String flavorname = "";
		for (int i = 1; i < Flavor.flavorTypes.size(); i++) {
			flavorname += Flavor.flavorTypes.get(i) + " ";
		}
		
		for (int i = 1; i < Flavor.tranFlavorArr.length; i++) {// 避免无意义的虚拟机计算
			String f = "flavor" + i;
			if (flavorname.contains(f)) {
				// 先去噪，再计算a的值,最后后预测
				int[] temp = Flavor.shuzuzidyingyifenzu(Flavor.shuzupinghua(Flavor.tranFlavorArr[i]),
						(int) (Flavor.endTime - Flavor.startTime));
//				Flavor.a[i] = Flavor.jisuanyicipinghuaA(temp);// 每个虚拟机计算一次a,
				double res =0.04*Flavor.ercipinghua(temp)+ 0.96*Flavor.sancipinghua(temp);
//				double res = Flavor.yuce(temp, i);// 每个虚拟机计算一次a
				Flavor.finalRes.addAll(Flavor.shuzuzhuanFlavor((int)Math.round(res), i));
//				System.out.println(Flavor.a[i]);// 展示一下
			}
		}
		
		ArrayList<ArrayList<Flavor>> res = Flavor.monituihuo(Flavor.finalRes);
		// 至此，预测虚拟机数求出来了，
		// 整理出了虚拟机的数目,进行降序排序
//		Collections.sort(Flavor.finalRes, new Comparator<Flavor>() {
//			// 从大到小排序数组
//			public int compare(Flavor flavor1, Flavor flavor2) {
//				/**
//				 * 升序排的话就是第一个参数.compareTo(第二个参数); 降序排的话就是第二个参数.compareTo(第一个参数);
//				 */
//				return flavor2.type - flavor1.type;// 降序
//			}
//		});
		// 对虚拟机进行背包算法
//		ArrayList<ArrayList<Flavor>> res = Flavor.fangzhisuanfa(Flavor.finalRes);
		
//		for (int i = 0; i < res.size(); i++) {// 方便后面的输出,从小到大
//			Collections.sort(res.get(i), new Comparator<Flavor>() {
//				// 从大到小排序数组
//				public int compare(Flavor flavor1, Flavor flavor2) {
//					/**
//					 * 升序排的话就是第一个参数.compareTo(第二个参数); 降序排的话就是第二个参数.compareTo(第一个参数);
//					 */
//					return flavor1.type - flavor2.type;// 降序
//				}
//			});
//		}


		return Flavor.outFileGen(res);
	}

	//
	//
	// //处理数据ecsContent
	// Flavor.tranFlavorArr=Flavor.genArr2(ecsContent);//二维测试数组，
	// Flavor.a=new double[Flavor.tranFlavorArr.length];//确定长度
	// for (int i = 1; i < Flavor.tranFlavorArr.length; i++) {
	// //先去噪，后计算a的值
	// int[] temp
	// =Flavor.shuzuzidyingyifenzu(Flavor.shuzupinghua(Flavor.tranFlavorArr[i]),
	// (int)(Flavor.endTime-Flavor.startTime));
	// Flavor.a[i]=Flavor.jisuanyicipinghuaA(temp);//每个虚拟机计算一次a,
	// //System.out.println(Flavor.a[i]);//展示一下
	// }
	// //至此，a求出来了，
	//
	//
	// //下面对实际数据进行预测
	// Flavor.forecastFlavorArr=Flavor.genArr2(inputContent);//整理好了的数据
	//// System.out.println("=============================================================================");
	//// for (int i = 1; i < Flavor.forecastFlavorArr.length; i++) {
	// for (int i = 1; i < 16; i++) {
	// //先去噪，后预测
	// int[] temp
	// =Flavor.shuzuzidyingyifenzu(Flavor.shuzupinghua(Flavor.tranFlavorArr[i]),
	// (int)(Flavor.endTime-Flavor.startTime));
	// int res =Flavor.yuce(temp, i);//每个虚拟机计算一次a,
	// Flavor.finalRes.addAll(Flavor.shuzuzhuanFlavor(res,i));
	//// System.out.println("flavor"+i+"型号预计："+res+"台");//展示一下
	// }
	//
	// //整理出了虚拟机的数目,进行降序排序
	// Collections.sort(Flavor.finalRes, new Comparator<Flavor>() {
	// //从大到小排序数组
	// public int compare(Flavor flavor1, Flavor flavor2) {
	// /**
	// * 升序排的话就是第一个参数.compareTo(第二个参数);
	// * 降序排的话就是第二个参数.compareTo(第一个参数);
	// */
	// return flavor2.type-flavor1.type;//降序
	// }
	// });
	// //对虚拟机进行背包算法
	//
	// ArrayList<ArrayList<Flavor>> res= Flavor.fangzhisuanfaCPU(Flavor.finalRes);
	// System.out.println(res);

}

