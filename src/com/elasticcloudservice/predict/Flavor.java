package com.elasticcloudservice.predict;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.sun.swing.internal.plaf.basic.resources.basic;

//自定义的虚拟机类，方便配置
//工具类也写在这里
public class Flavor {
	public int id;// 物理机编号
	public int cpu;// 核
	public int neicun;// 内存
	public int daytTime;// 毫秒的时间
	public int num = 0;// 数量
	public int type;// 类型

	public String uuid;
	public String name;
	public String createTime;
	public String nianyueri;
	public String shifenmiao;

	public Date createDate;// 日期的时间

	public Flavor() {
		// TODO Auto-generated constructor stub
	}

	public Flavor(int type) {
		super();
		this.type = type;
	}

	public Flavor(String name) {
		super();
		this.name = name;
	}

	public Flavor(String uuid, String name, int daytTime) {
		this.uuid = uuid;
		this.name = name;
		this.daytTime = daytTime;
	}

	public void genFlavorCpuAndMenByName() {
		// 通过类型对每种虚拟机进行分配
		switch (name) {
		case "flavor1":
			cpu = 1;
			neicun = 1024;
			break; // flavor1 1 1024
		case "flavor2":
			cpu = 1;
			neicun = 2048;
			break; // flavor2 1 2048
		case "flavor3":
			cpu = 1;
			neicun = 4096;
			break; // flavor3 1 4096
		case "flavor4":
			cpu = 2;
			neicun = 2048;
			break; // flavor4 2 2048
		case "flavor5":
			cpu = 2;
			neicun = 4096;
			break; // flavor5 2 4096
		case "flavor6":
			cpu = 2;
			neicun = 8192;
			break; // flavor6 2 8192
		case "flavor7":
			cpu = 4;
			neicun = 4096;
			break; // flavor7 4 4096
		case "flavor8":
			cpu = 4;
			neicun = 8192;
			break; // flavor8 4 8192
		case "flavor9":
			cpu = 4;
			neicun = 16384;
			break; // flavor9 4 16384
		case "flavor10":
			cpu = 8;
			neicun = 8192;
			break; // flavor10 8 8192
		case "flavor11":
			cpu = 8;
			neicun = 16384;
			break; // flavor11 8 16384
		case "flavor12":
			cpu = 8;
			neicun = 32768;
			break; // flavor12 8 32768
		case "flavor13":
			cpu = 16;
			neicun = 16384;
			break;// flavor13 16 16384
		case "flavor14":
			cpu = 16;
			neicun = 32768;
			break;// flavor14 16 32768
		case "flavor15":
			cpu = 16;
			neicun = 65536;
			break;// flavor15 16 65536
		default:
			cpu = 0;
			neicun = 0;
		}
	}

	public void genFlavorCpuAndMenByType() {
		// 通过类型对每种虚拟机进行分配
		switch (type) {
		case 1:
			cpu = 1;
			neicun = 1024;
			break; // flavor1 1 1024
		case 2:
			cpu = 1;
			neicun = 2048;
			break; // flavor2 1 2048
		case 3:
			cpu = 1;
			neicun = 4096;
			break; // flavor3 1 4096
		case 4:
			cpu = 2;
			neicun = 2048;
			break; // flavor4 2 2048
		case 5:
			cpu = 2;
			neicun = 4096;
			break; // flavor5 2 4096
		case 6:
			cpu = 2;
			neicun = 8192;
			break; // flavor6 2 8192
		case 7:
			cpu = 4;
			neicun = 4096;
			break; // flavor7 4 4096
		case 8:
			cpu = 4;
			neicun = 8192;
			break; // flavor8 4 8192
		case 9:
			cpu = 4;
			neicun = 16384;
			break; // flavor9 4 16384
		case 10:
			cpu = 8;
			neicun = 8192;
			break; // flavor10 8 8192
		case 11:
			cpu = 8;
			neicun = 16384;
			break; // flavor11 8 16384
		case 12:
			cpu = 8;
			neicun = 32768;
			break; // flavor12 8 32768
		case 13:
			cpu = 16;
			neicun = 16384;
			break;// flavor13 16 16384
		case 14:
			cpu = 16;
			neicun = 32768;
			break;// flavor14 16 32768
		case 15:
			cpu = 16;
			neicun = 65536;
			break;// flavor15 16 65536
		default:
			cpu = 0;
			neicun = 0;
		}
	}

	/**
	 * 
	 * 
	 * public static final int totalCpu = 56; // 物理机的总CPU public static final int
	 * totalMen = 128 * 1024;// 物理机的总内存 public static final int totalRoom =
	 * 1200*1024;// 物理机的总内存 //先全部计算，然后根据在不在这里面对其进行输出 public static ArrayList<String>
	 * flavorTypes = new ArrayList<>();//记录给定的虚拟机的名字 public static int startTime;//
	 * 预测的开始时间 public static int endTime;// 预测的结束时间
	 * 
	 */

	public static void ecsInfoDeal(String[] flavorInfo) {// 把处理的规格都弄好了
		String[] wuliji = flavorInfo[0].split(" ");
		totalCpu = Integer.valueOf(wuliji[0]);
		totalMen = Integer.valueOf(wuliji[1]) * 1024;
		totalRoom = Integer.valueOf(wuliji[2]);
		// 物理机的规格好了
		int index = 2;
		int types = Integer.valueOf(flavorInfo[index].trim());
		System.out.println(types);
		flavorTypes.add("flavor0");// 占坟，不使用。
		for (int i = 0; i < types; i++) {
			index++;
			flavorTypes.add(flavorInfo[index].split(" ")[0]);
			System.out.println(flavorInfo[index].split(" ")[0]);
		}

		// 整理出了虚拟机的数目,进行降序排序
		Collections.sort(flavorTypes, new Comparator<String>() {
			// 从大到小排序数组
			/**
			 * 升序排的话就是第一个参数.compareTo(第二个参数); 降序排的话就是第二个参数.compareTo(第一个参数);
			 */
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.substring(6)) - Integer.valueOf(o2.substring(6));
			}
		});
		index += 2;
		youhuaType = flavorInfo[index].trim();
		System.out.println(youhuaType);
		try {
			index += 2;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = flavorInfo[index].trim(); // 要跟上面sdf定义的格式一样
			Date today = sdf.parse(str);	
			startTime = today.getTime() / 60 / 60 / 24 / 1000;
//			System.out.println(startTime);
			index++;
			str = flavorInfo[index].trim(); // 要跟上面sdf定义的格式一样
			today = sdf.parse(str);
			endTime = today.getTime() / 60 / 60 / 24 / 1000;
//			System.out.println(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	
	/**
	 * 
	 * 把String字符串转换long
	 * 
	 * @param date
	 * @return
	 */
	public static int dateToString(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String str = date; // 要跟上面sdf定义的格式一样
			Date today = sdf.parse(str);
			long tmp = today.getTime() / 60 / 60 / 24 / 1000;
			return (int) tmp;
			// 这里处理数据年月日的时间，后面可以自己更改为毫秒
			// 这个数都不会超过0x0fffffff的
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}
	/**
	 * 
	 * 把虚拟机的类型从String转换成int
	 * 
	 * @param date
	 * @return
	 */
	public static int flavorNameToInt(String flavorName) {
		return Integer.valueOf(flavorName.substring(6));
	}

	/**
	 * 
	 * 
	 * 生成虚拟机的二维数组
	 * 
	 * @param flavorInfo
	 * @return
	 */
	public static int[][] genArr2(String[] flavorInfo) {// 输入的虚拟机信息
		/** =========do your work here========== **/
		List<Flavor> flavors = new ArrayList<>();// 读入虚拟机的列表
		int dayMin = Integer.MAX_VALUE;
		int dayMax = Integer.MIN_VALUE;
		int flavorTypes = 0;
		int len = flavorInfo.length;
		// 第一部分，循环读数据
		for (int i = 0; i < len; i++) {// 从第0行开始读的
			if (flavorInfo[i].contains("\t") && flavorInfo[i].split("\t").length >= 3) {
				// 这段是把文本转换成对象的
				String[] array = flavorInfo[i].split("\t");
				String uuid = array[0];// 编号
				String flavorName = array[1];// 虚拟机的名称
				String createTime = array[2].split(" ")[0];// 创建的时间
				int type = Flavor.flavorNameToInt(flavorName);// 确定种类
				int dayTime = Flavor.dateToString(createTime);// 按天数
				// System.out.println(type);
				// System.out.println(createTime);
				// System.out.println(dayTime);
				if (flavorTypes < type) {// 告诉有多少种类
					flavorTypes = type;
				}
				if (dayMax < dayTime) {// 告诉最大的时间
					dayMax = dayTime;
				}
				if (dayTime < dayMin) {// 告诉最大的时间
					dayMin = dayTime;
				}
				// 整理虚拟机数据
				Flavor flavor = new Flavor(uuid, flavorName, dayTime);
				flavor.daytTime = dayTime;
				flavor.type = type;
				flavor.num = 1;
				flavors.add(flavor);// 把数据保存到 Array中去了。
				/** =========do your work here========== **/
				// history.add(uuid + " " + flavorName + " " + createTime);
			}
		}

		/**
		 * 第二部分，构造二维数组了 竖代表某虚拟机的数据 横代表日期 a[i][]代表每种虚拟机,type,a[0][]不使用。
		 * 最初的日期是dayMin+数组下标,
		 **/
		int[][] flavorArr = new int[flavorTypes + 1][dayMax - dayMin + 1];
		for (Flavor tmp : flavors) {
			flavorArr[tmp.type][tmp.daytTime - dayMin]++;
		}
		// 遍历数组
		// for (int i = 1; i <= flavorTypes; i++) {
		// System.out.println("flavor" + i + "型号主机在" + (dayMax - dayMin + 1) +
		// "天内销售情况：");
		// for (int j = 0; j < dayMax - dayMin + 1; j++) {
		// System.out.print(flavorArr[i][j] + " ");
		// }
		// System.out.println("");
		// }

		return flavorArr;// 引用一下
	}

	/**
	 * 平滑去噪
	 * 
	 * for i in range(maxFlavorType): sum1=0 sum2=0 for j in range(timePeriod):
	 * sum1+=DataTrain[j][i] sum2+=DataTrain[j][i]**2 mean=sum1/(timePeriod*1.0)#ave
	 * std=math.sqrt(sum2/(timePeriod*1.0)-mean**2)#std biaozhuncha
	 * thresh=round(mean+3*std) for k in range(timePeriod): if
	 * DataTrain[k][i]>thresh: DataTrain[k][i]=thresh
	 */
	public static int[] shuzupinghua(int[] arr) {
		// 由于我的下标就是记录的天数的，
		// 所以我这里时间周期直接使用下标就好了
		int timePeriod = arr.length;
		double sum1 = 0;
		double sum2 = 0;
		for (int i = 0; i < timePeriod; i++) {
			sum1 += arr[i];
			sum2 += arr[i] * arr[i];
		}
		double mean = sum1 / (timePeriod * 1.0);// 求sum1的平均值
		double std = Math.sqrt(sum2 / (timePeriod * 1.0) - mean * mean);// 求标准差
		double thresh =  mean *4.5;
		for (int i = 0; i < timePeriod; i++) {
			if (thresh < arr[i]*1.0) {
				arr[i] = (int) Math.round(mean*3.55);
			}
		}
		return arr;
	}

	/**
	 * 一次平滑系数的计算
	 * 
	 * @return
	 */
	public static double jisuanyicipinghuaA(int[] arr) {
		double jiange = 0.01;
		int len = arr.length;// 设定长度
		// double[] a=new double[len+1];
		int minFlag = 0;// 记录最小均均差的时对应a的下标
		double minMAD = Double.MAX_VALUE;// 当前最小的方差值
		// double[] MAD=new double[len+1];//每个的均方差
		for (int i = 0; i <= 100; i++) {
			double[] MAD = new double[len - 1];
			double a = i * jiange;
			double S = arr[0];
			// 这段就是那个核心代码
			for (int j = 1; j < len; j++) {
				double S_1 = a * arr[j] + (1 - a) * S;
				double E_i = arr[j] * 1.0 - S;
				S = S_1;
				MAD[j - 1] = Math.abs(E_i);// 这里我已经取了绝对值
			}
			// 这段是求mean的绝对值的和
			double sum = 0;
			for (int j = 0; j < len - 1; j++) {
				sum += MAD[j];
			}
			if (minMAD > sum) {
				// 取绝对值和最小的那个下标
				// 因为len-1是固定的，所以不需要除以len-1再比较
				minMAD = sum;
				minFlag = i;
			}
		}
		return minFlag * jiange;
	}

	/**
	 * 
	 * 把每个虚拟机生成的数组进行分组求和 按照给定的长度 把数组分组，较远的数据就不要了 长度小于2的时候就是返回原值
	 */
	public static int[] shuzuzidyingyifenzu(int[] arr, int changdu) {
		int len = arr.length;// 输入数组的长度
		if (len < changdu || changdu < 2) {
			// 如果输入的数组小于给定长度，或者长度值小于2，就把原始数组返回
			return arr;
		}
		int[] res = new int[len / changdu];// 初始化需要返回的数组
		int youbiao = len / changdu - 1;// 设置下标为数组的最后一个位置
		int temp = changdu;// 赋值tmp，因为需要对长度进行调用
		for (int i = len - 1, sum = 0; i >= 0; i--) {
			// 每changdu个数据相加，从后往前计算,越早的数据可能就被抛弃了
			if (temp > 0) {
				sum += arr[i];
				temp--;
			} else {
				res[youbiao] = sum;// 赋值了
				youbiao--;// 往前走一位
				sum = 0;// 初始化和
				temp = changdu;// 初始化长度
			}
		}
		return res;// 返回结果
	}

	/**
	 * 
	 * 对某型号虚拟机进行预测
	 * 
	 * @param arr
	 *            输入的虚拟就数组
	 * @param type
	 *            对应的主机类型
	 * @return 返回接下来一段时间的数量
	 */
	public static int yuce(int[] arr, int type) {
		double S0 = 0;
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			S0 += arr[i];
		}
		double S = 0;
		S0 = S0 / len;// 求第一个平滑值
		for (int i = 1; i < len; i++) {
			S = a[type] * arr[i] + (1 - a[type]) * S0;
			S0 = S;
		}
		return (int) S;
	}

	/**
	 * 将预测后的数据放入arraylist中排序
	 * 
	 * @param arr
	 * @param type
	 * @return
	 */
	public static ArrayList<Flavor> shuzuzhuanFlavor(int num, int type) {
		ArrayList<Flavor> res = new ArrayList<>();
		int j = 0;
		while (num > j) {
			Flavor temp = new Flavor(type);
			temp.num = 1;
			temp.genFlavorCpuAndMenByType();
			res.add(temp);
			j++;
		}
		return res;
	}

	///使用模拟退火算法找最佳的虚拟机放置方式
	///输入参数：
	///map_predict_num_flavors：上一步预测出来的各种虚拟机数量，key是虚拟机名称，value是虚拟机数量
	///map_flavor_cpu_mem：程序输入的虚拟机类型数据，key为虚拟机名称，value是虚拟机类型（包括name，cpu，mem字段）
	///server_mem && server_cpu：程序输入的服务器参数，CPU和内存大小
	///CPUorMEM：是使CPU利用率最高还是使内存利用率最高
	///输出参数：
	///res_servers：存放有计算出的最优服务器中虚拟机存放方式，
	//可通过成员flavors访问每个服务器中存放的虚拟机
	public static ArrayList<ArrayList<Flavor>> monituihuo(ArrayList<Flavor> input) {
		//vector用于存放所有预测出来的flavor
		ArrayList<Flavor> vec_flavors=new ArrayList<>(input);
	    //=========================================================================
	    //模拟退火算法找最优解
		double min_server = Double.MAX_VALUE;
		ArrayList<Server> res_servers =null;

		double T = 100.0;  //模拟退火初始温度
	    double Tmin = 1;   //模拟退火终止温度
	    double r = 0.9999; //温度下降系数
	
	    ArrayList<Integer> dice =new ArrayList<>(); //骰子，每次随机投掷，取vector前两个变量作为每次退火需要交换顺序的虚拟机
	    for (int i = 0; i < vec_flavors.size(); i++) {
	    	dice.add(i);
	    }
	    while (T > Tmin) {
	        //投掷骰子，如vector前两个数为3和9，
	    	//则把vec_flavors[3]和vec_flavors[9]进行交换作为新的flavors顺序
	    	Collections.shuffle(dice); 
	    	ArrayList<Flavor> new_vec_flavors=new ArrayList<>(vec_flavors);
	    	Collections.swap(new_vec_flavors, dice.get(0), dice.get(dice.size()-1));
	    
	        //把上一步计算出来的虚拟机尝试加入到服务器中
	        //先使用一个服务器用于放置虚拟机
	    	ArrayList<Server> servers=new ArrayList<>();
	    	Server firstServer =new Server();
	    	servers.add(firstServer);
	    
	        //放置虚拟机主要逻辑
	        //如果当前所有服务器都放不下虚拟机，就新建一个服务器用于存放
	    	for (Flavor element : new_vec_flavors) {
	    		int i=0;
	    		for(;i<servers.size();i++){
	    			if(servers.get(i).put_flavor(element)) {
	    				break;
	    			}
	    		}
	    		if(i==servers.size()) {
	    			Server newserver =new Server();
	    			newserver.put_flavor(element);
	    			servers.add(newserver);
	    		}
	            //计算本次放置虚拟机耗费服务器评价分数(double型)
	            //如果使用了N个服务器，则前N-1个服务器贡献分数为1，第N个服务器分数为资源利用率
	            //模拟退火就是得到取得分数最小的放置方式
	            double server_num;
	            //对于题目关心CPU还是MEM，需要分开讨论，资源利用率计算方法不同
	            if (Flavor.youhuaType.equals("CPU"))
	                server_num = servers.size() - 1 + servers.get(servers.size()-1).get_cpu_usage_rate();
	            else
	                server_num = servers.size() - 1 + servers.get(servers.size()-1).get_mem_usage_rate();
	            //如果分数更低，则保存结果
	            if (server_num < min_server) {
	                min_server = server_num;
	                res_servers = servers;
	                vec_flavors = new_vec_flavors;
	            }
	                //如果分数更高，则以一定概率保存结果，防止优化陷入局部最优解
	            else {
	            	double RAND_MAX=1.0;
	                if (Math.exp((min_server - server_num) / T) > (Math.random() / RAND_MAX)) {
	                    min_server = server_num;
	                    res_servers = servers;
	                    vec_flavors = new_vec_flavors;
	                }
	            }
	            T = r * T;  //一次循环结束，温度降低
			}
	    }
	    
	    ArrayList<ArrayList<Flavor>> res =new ArrayList<ArrayList<Flavor>>();
	    for (Server  tmp: res_servers) {
	    	res.add(tmp.putFlavor);
		}
		return res;
	}
	
	
	
  
	/**
	 * 将预测后的数据放入arraylist中排序
	 * 
	 * @param arr
	 * @param type
	 * @return
	 */
	
	public static ArrayList<ArrayList<Flavor>> fangzhisuanfa(ArrayList<Flavor> input) {
		if (youhuaType.equals("CPU")) {
//			System.out.println("CPU预测");
			// 判断每台虚拟机是否被占用
			boolean[] flag = new boolean[input.size()];
			ArrayList<ArrayList<Flavor>> res = new ArrayList<>();
			for (int i = 0; i < input.size(); i++) {
				ArrayList<Flavor> temp = new ArrayList<Flavor>();
				int cpus = totalCpu;
				int mens = totalMen;
				for (int j = i; j < input.size(); j++) {
					Flavor tmp = input.get(j);
					cpus -= tmp.cpu;
					mens -= tmp.neicun;
					if (flag[j] == false && cpus >= 0 && mens > 0) {
						// 这是优先考虑CPU
						temp.add(tmp);
						flag[j] = true;
					} else if (flag[j] == false && cpus > 0 && mens == 0) {
						if (j == input.size() - 1) {
							temp.add(tmp);
							flag[j] = true;
						} else {
							cpus += tmp.cpu;
							mens += tmp.neicun;
						}
					} else {
						cpus += tmp.cpu;
						mens += tmp.neicun;
					}
					if (cpus <= 0 && mens <= 0) {
						break;
					}
				}
				if (temp.size() > 0) {
					res.add(temp);
				}
			}
			return res;
		} else {
			// 判断每台虚拟机是否被占用
			boolean[] flag = new boolean[input.size()];
			ArrayList<ArrayList<Flavor>> res = new ArrayList<>();
			for (int i = 0; i < input.size(); i++) {
				ArrayList<Flavor> temp = new ArrayList<Flavor>();
				int cpus = totalCpu;
				int mens = totalMen;
				for (int j = i; j < input.size(); j++) {
					Flavor tmp = input.get(j);
					cpus -= tmp.cpu;
					mens -= tmp.neicun;
					if (flag[j] == false && cpus >= 0 && mens >= 0) {
						// 这是优先考虑内存
						temp.add(tmp);
						flag[j] = true;
					} else {
						cpus += tmp.cpu;
						mens += tmp.neicun;
					}
					if (cpus <= 0 && mens <= 0) {
						break;
					}
				}
				if (temp.size() > 0) {
					res.add(temp);
				}
			}
			return res;
		}
	}

	public static String[] outFileGen(ArrayList<ArrayList<Flavor>> res) {
		// 放置算法统计完之后输出
		Map<String, Integer> flavorTotal = new HashMap<String, Integer>();// 输出时记录各类虚拟机的数目
		for (int j = 0; j < flavorTypes.size(); j++) {
			String key = flavorTypes.get(j);
			// 设置指定虚拟机的key
			flavorTotal.put(key, 0);
		}
		int totalSum = 0;
		int wulijitaishu = res.size();// 统计物理机的数目;
		for (int i = 0; i < res.size(); i++) {
			ArrayList<Flavor> temp = res.get(i);
			// 统计虚拟机总数
			totalSum += temp.size();
			for (int j = 0; j < temp.size(); j++) {
				String key = "flavor" + temp.get(j).type;
				// 统计各类虚拟机的数目的
				if (flavorTotal.containsKey(key)) {
					int value = flavorTotal.get(key) + 1;
					flavorTotal.put(key, value);
				}
			}
		}
		// 计算完后开始输出了
		// 首先输出总数
		String[] results = new String[Flavor.flavorTypes.size() + 1 + 1 + wulijitaishu];
		results[0] = totalSum + "";
		int index = 1;
		for (int i = 1; i < Flavor.flavorTypes.size(); i++) {
			int fNum = flavorTotal.get(Flavor.flavorTypes.get(i));
			// 即使是0 也要输出
			// if (fNum <= 0) {// 预测个数为0的就不要了
			// continue;
			// }
			String temp = Flavor.flavorTypes.get(i) + " " + fNum;
			results[index] = temp + "";
			index++;
		}
		results[index] = "";
		index++;
		results[index++] = wulijitaishu + "";// 输出后下标加1
		for (int i = 0; i < wulijitaishu; i++) {
			ArrayList<Flavor> tmp = res.get(i);
			Map<String, Integer> count = new HashMap<String, Integer>();// 输出时记录各类虚拟机的数目
			for (int j = 0; j < tmp.size(); j++) {// 整合
				String key = "flavor" + tmp.get(j).type;
				if (count.containsKey(key)) {
					int value = count.get(key) + 1;
					count.put(key, value);
				} else {
					count.put(key, 1);
				}
			}
			results[index] = i + "";// 物理机编号
			for (int j = 1; j < Flavor.flavorTypes.size(); j++) {// 输出文本信息
				String key = Flavor.flavorTypes.get(j);
				if (count.containsKey(key)) {
					results[index] += " " + key + " " + count.get(key);
				}
			}
			results[index] += "";
			index++;
		}
		return results;
	}

	public static double a[];// 一次平滑系数,不同虚拟机是不同的
	public static double a2[];// 二次平滑系数,不同虚拟机是不同的
	public static double a3[];// 三次平滑系数,不同虚拟机是不同的
	public static int[][] tranFlavorArr;// 训练的数据
	public static int[][] forecastFlavorArr;// 预测的数据

	public static ArrayList<Flavor> finalRes = new ArrayList<>();// 预测后虚拟机的集合
	public static ArrayList<ArrayList<Flavor>> fangzhiFlavor = new ArrayList<>();// 放置虚拟机序列的集合
	public static int totalCpu = 56; // 物理机的总CPU
	public static int totalMen = 128 * 1024;// 物理机的总内存
	public static int totalRoom = 1200 * 1024;// 物理机的总内存
	// 先全部计算，然后根据在不在这里面对其进行输出
	public static ArrayList<String> flavorTypes = new ArrayList<>();// 记录给定的虚拟机的名字
	public static long startTime;// 预测的开始时间
	public static long endTime;// 预测的结束时间
	public static String youhuaType;// 需要优化的类型

	/**
	 * ------------------------------------------------------------------------------
	 * 华丽丽的分割线
	 */

	/**
	 * 后续加强版本
	 * 
	 */

	// L0指A的最小值
	// L1指A的步长
	// L2指A的最大值
	// A的颗粒度自己取了//0.38-0.62
	public static double yicipinghua(int[] arr) {
		int L0 = 38;
		int L1 = 2;
		int L2 = 62;
		double[][] s = new double[(L2 - L0) / L1 + 1][arr.length];
		double[] e = new double[arr.length];
		double[] MAD = new double[(L2 - L0) / L1 + 1];
		int[] x = arr;
		int k = 0;
		int A = L0;// 取整数的步子
		double minMAD = Double.MAX_VALUE;
		int minK = 0;
		double a = 0;
		while (A <= L2) {
			a = A / 100.0;// **************************这里自己修改
			s[k][0] = arr[0];
			e[0] = 0;
			double sum1 = e[0];
			for (int i = 1; i < arr.length; i++) {
				s[k][i] = x[i] + (1 - a) * s[k][i - 1];
				e[i] = x[i] - s[k][i - 1];
				sum1 += Math.abs(e[i]);
			}
			MAD[k] = sum1;
			if (sum1 < minMAD) {
				minMAD = sum1;
				minK = k;
			}
			k += 1;
			A += L1;
		}
		k = minK;
		a = (L0 + L1 * k) / 100.0;// **************************这里自己修改
		double y = s[k][arr.length - 1];
		return Math.round(a * x[x.length - 1] + (1 - a) * y);

	}

	public static double ercipinghua(int[] arr) {
		int[] x = arr;
		int L0 = 38;
		int L1 = 2;
		int L2 = 62;
		double[][] s1 = new double[(L2 - L0) / L1 + 1][arr.length];
		double[][] s2 = new double[(L2 - L0) / L1 + 1][arr.length];
		double[][] a2 = new double[(L2 - L0) / L1 + 1][arr.length];
		double[][] b2 = new double[(L2 - L0) / L1 + 1][arr.length];
		double[][] y = new double[(L2 - L0) / L1 + 1][arr.length + 1];
		double[] e2 = new double[arr.length];
		double[] MAD2 = new double[(L2 - L0) / L1 + 1];
		double minMAD2 = Double.MAX_VALUE;
		int minK = 0;
		int k = 0;// 循环次数
		int A = L0;// 取整数的步子
		double a = 0;
		while (A <= L2) {
			a = A / 100.0;// **************************这里自己修改
			s1[k][0] = x[0];// 初值
			s2[k][0] = x[0];
			e2[0] = 0;// 残差初值
			e2[1] = 0;
			double sum1 = e2[0];// 总残差
			for (int i = 1; i < x.length; i++) {
				s1[k][i] = a * x[i] + (1 - a) * s1[k][i - 1];
				s2[k][i] = a * s1[k][i] + (1 - a) * s2[k][i - 1];
				a2[k][i] = 2 * s1[k][i] - s2[k][i];
				b2[k][i] = (s1[k][i] - s2[k][i]) * (a / (1 - a));
				y[k][i + 1] = a2[k][i] + b2[k][i];
				if (y[k][i + 1] < 0) {
					y[k][i + 1] = 0;
				}
				if (i + 1 < x.length) {
					e2[i + 1] = x[i + 1] - y[k][i + 1];
				}
				sum1 += Math.abs(e2[i]);
			}
			MAD2[k] = sum1;
			if (sum1 < minMAD2) {
				minMAD2 = sum1;
				minK = k;
			}
			k += 1;
			A += L1;
		}
		k = minK;
		a = (L0 + L1 * k) / 100.0;// **************************这里自己修改
		return y[k][arr.length];
	}

	public static double sancipinghua(int[] arr) {
		int[] x = arr;
		int L0 = 38;
		int L1 = 2;
		int L2 = 62;
		double[][] s1 = new double[(L2 - L0) / L1 + 1][arr.length];
		double[][] s2 = new double[(L2 - L0) / L1 + 1][arr.length];
		double[][] s3 = new double[(L2 - L0) / L1 + 1][arr.length];
		double[][] a3 = new double[(L2 - L0) / L1 + 1][arr.length];
		double[][] b3 = new double[(L2 - L0) / L1 + 1][arr.length];
		double[][] c3 = new double[(L2 - L0) / L1 + 1][arr.length];
		double[][] y  = new double[(L2 - L0) / L1 + 1][arr.length + 1];
		double[] e3 = new double[arr.length];
		double[] MAD3 = new double[(L2 - L0) / L1 + 1];
		double minMAD3 = Double.MAX_VALUE;
		int minK = 0;
		int k = 0;// 循环次数
		int A = L0;// 取整数的步子
		double a = 0;
		while (A <= L2) {
			a = A / 100.0;// **************************这里自己修改
			s1[k][0] = x[0];
			s2[k][0] =((x[0] + x[1]) / 2);
			s3[k][0] =((x[0] + x[1] + x[2]) / 3);
			e3[0] = 0;
			e3[1] = x[1] - s3[k][0];
			double sum1 = e3[0];
			for (int i = 1; i < x.length; i++) {
				s1[k][i] = a * x[i] + (1 - a) * s1[k][i - 1];
				s2[k][i] = a * s1[k][i] + (1 - a) * s2[k][i - 1];
				s3[k][i] = a * s2[k][i] + (1 - a) * s3[k][i - 1];
				a3[k][i] = 3 * s1[k][i] - 3 * s2[k][i] + s3[k][i];
				b3[k][i] = (a / (2 * (1 - a) * (1 - a)))
						* ((6 - 5 * a) * s1[k][i] - (10 - 8 * a) * s2[k][i] + (4 - 3 * a) * s3[k][i]);
				c3[k][i] = (a * a / (2 * (1 - a) * (1 - a))) * (s1[k][i] - 2 * s2[k][i] + s3[k][i]);
				y[k][i + 1] = a3[k][i] + b3[k][i] + c3[k][i];
				if (y[k][i + 1] < 0) {
					y[k][i + 1] = 0;
				}
				if (i + 1 < x.length) {
					e3[i + 1] = x[i + 1] - y[k][i + 1];
					sum1 += Math.abs(e3[i]);
				}
				MAD3[k] = sum1;
				if (sum1 < minMAD3) {
					minMAD3 = sum1;
					minK = k;
				}
			}
			k += 1;
			A += L1;
		}
		k=minK;
		a=L0+L1*k;
		return y[k][x.length];
			
	}

	

	/**
	 * 
	 * 
	 * 
	 * def zsph1(x,L0,L1,L2):#一次指数平滑 s = zeros(int(round((L2 - L0)/L1))+1,len(x))
	 * e=zeros(len(x),1) MAD=zeros(int(round((L2-L0)/L1))+1,1) k=0 a=L0 while a<=L2:
	 * s[k][0]=x[0] e[0]=0 sum1=e[0] for i in range(1,len(x),1):
	 * s[k][i]=a*x[i]+(1-a)*s[k][i-1] e[i]=x[i]-s[k][i-1] sum1+=abs(e[i])
	 * MAD[k]=sum1 k+=1 a+=L1 k=MAD.index(min(MAD)) a=L0+L1*k y=s[k][-1]
	 * zsph1=round(a*x[-1]+(1-a)*y) return zsph1
	 */

}
