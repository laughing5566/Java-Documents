/*-------------------------------------------ö�٣���ͨ��ʾ����---------------------------------------------*/
public class StaticImport {
	public static void main(String[] args) {
		System.out.println(TrafficLamp.Red);
	}
	/*����һ��ö������
	 * 1��ö�ٵ�Ԫ���б�������ö���ڲ��ĵ�һ�У�
	 * 2��ö���е�ÿһ��Ԫ�ض��Ǹ�ö�����һ������ö�������ö���и���Ԫ�صĸ��ࣻ
	 * 3���ⲿ���ڵ���ö��Ԫ��ʱ�����Զ�������ÿ��ö��Ԫ������Ӧ��ö���ڲ����޲λ��вεĹ��췽����
	 * 4��ö���е�ÿһ��Ԫ�ؾ����Ե���ö���ڲ����޲λ��вι��췽����
	 * 5�����ö���ڲ������˳��󷽷�������Ԫ�ض��������дʵ��ö���еĳ��󷽷���
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
		//����һ�����󷽷���������(��Ԫ���б����)��ʵ��
		public abstract TrafficLamp nextLamp();
	}

}
