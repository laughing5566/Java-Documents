/*-------------------------------------------枚举：交通灯示例：---------------------------------------------*/
public class StaticImport {
	public static void main(String[] args) {
		System.out.println(TrafficLamp.Red);
	}
	/*定义一个枚举类型
	 * 1，枚举的元素列表必须放在枚举内部的第一行；
	 * 2，枚举中的每一个元素都是该枚举类的一个对象，枚举类就是枚举中各个元素的父类；
	 * 3，外部类在调用枚举元素时，都自动调用了每个枚举元素所对应的枚举内部的无参或有参的构造方法；
	 * 4，枚举中的每一个元素均可以调用枚举内部的无参或有参构造方法；
	 * 5，如果枚举内部定义了抽象方法，各个元素对象必须重写实现枚举中的抽象方法。
	 * */
	public enum TrafficLamp{
		Red(50){
			public TrafficLamp nextLamp(){
				return null;
			}
		},
		Green(23){
			public TrafficLamp nextLamp(){
				return Yellow;
			}
		},
		Yellow(56){
			public TrafficLamp nextLamp(){
				return Red;
			}
		};
		private TrafficLamp(int time){
			System.out.println(time);
		}
		//定义一个抽象方法，由子类(即元素列表对象)来实现
		public abstract TrafficLamp nextLamp();
	}

}
