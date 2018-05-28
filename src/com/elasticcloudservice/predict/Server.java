package com.elasticcloudservice.predict;

import java.util.ArrayList;

public class Server {

	public int id;// 物理机编号
	public int free_cpu;// 核
	public int free_mem;// 内存
	public int daytTime;// 毫秒的时间
	public int num = 0;// 数量
	public int type;// 类型
	

	public Server() {

		this.free_cpu=Flavor.totalCpu;//初始化时剩余CPU等于总CPU
		this.free_mem=Flavor.totalMen; //初始化时剩余内存等于总内存
		this.num = 1;// 数量
		// TODO Auto-generated constructor stub
	}
	ArrayList<Flavor> putFlavor=new ArrayList<>();
	
	///放置虚拟机函数，参数为虚拟机对象，返回值为是否放置成功
	///首先检查剩余CPU和内存是否足够放置该虚拟机
	///如果能够放下虚拟机，则将虚拟机放入服务器，并更新服务器可用内存和可用CPU，并返回true
	///如果剩余内存和CPU不足以放下该虚拟机，则返回false
	public boolean put_flavor(Flavor flavor) {
		if (free_cpu >= flavor.cpu && free_mem >= flavor.neicun) {
			free_cpu -= flavor.cpu;
			free_mem -= flavor.neicun;
			putFlavor.add(flavor);
			return true;
		}
		return false;
	}
	
	///获取服务器CPU使用率
	public double get_cpu_usage_rate() {
		return 1 - free_cpu*1.0 / Flavor.totalCpu;
	}
	
	///获取服务器内存使用率
	public double get_mem_usage_rate() {
		return 1 -free_mem*1.0  / Flavor.totalMen;
	}
	
	
	
	
}
