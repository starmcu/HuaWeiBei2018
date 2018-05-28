package com.filetool.main;

import com.elasticcloudservice.predict.Predict;
import com.filetool.util.FileUtil;
import com.filetool.util.LogUtil;

/**
 * 
 * 工具入口
 * 
 * @version [版本号, 2017-12-8]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Main {
	public static void main(String[] args) {

//		临时屏蔽
		if (args.length != 3) {
			System.err
					.println("please input args: ecsDataPath, inputFilePath, resultFilePath");
			return;
		}

//		args[0]="C:/huawei/ecsData.txt";
//		args[1]="C:/huawei/inputData.txt";
//		args[2]="C:/huawei/output.txt";

		String ecsDataPath = args[0];//ECS规格数据
		String inputFilePath = args[1];//输入的历史数据
		String resultFilePath = args[2];//结果输出

		LogUtil.printLog("Begin");

		// 读取输入文件
		String[] ecsContent = FileUtil.read(ecsDataPath, null);//ECS数据的路径
		String[] inputContent = FileUtil.read(inputFilePath, null);//输入的内容

		// 功能实现入口
		String[] resultContents = Predict.predictVm(ecsContent, inputContent);

		// 写入输出文件
		if (hasResults(resultContents)) {
			FileUtil.write(resultFilePath, resultContents, false);
		} else {
			FileUtil.write(resultFilePath, new String[] { "NA" }, false);
		}
		LogUtil.printLog("End");
	}

	private static boolean hasResults(String[] resultContents) {
		if (resultContents == null) {
			return false;
		}
		for (String contents : resultContents) {
			if (contents != null && !contents.trim().isEmpty()) {
				return true;
			}
		}
		return false;
	}

}
