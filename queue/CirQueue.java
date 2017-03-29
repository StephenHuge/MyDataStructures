package queue;
/**
 * ����һ��Javaʵ�ֵ�ѭ�����С�
 * 
 * @author Stephen Huge
 *
 */
public class CirQueue<T> {
	/** ����ʵ�ֶ��е����� */
	private T[] array; 
	/** ����ͷ��Ԫ�ص������±� */
	private int front;
	/** ����β��Ԫ�ص������±�-1��Ҳ����˵rearָ����Ƕ�βԪ��֮���һ��ֵΪ�յ�����Ԫ�أ���Ĭ�ϲ��洢Ԫ��*/
	private int rear;	
	public CirQueue() {
		this(16);
	} 
	/**
	 * �вι��캯��������һ�����������飬������ȼ�1�Ƕ��е���󳤶�
	 * @param len ���е���󳤶�
	 */
	@SuppressWarnings("unchecked")
	public CirQueue(int len) {
		array = (T[]) (new Object[len]);
		front = 0;
		rear = 0;
	}
	/**
	 * �ж��Ƿ�Ϊ�ն��У����front��rear��ȷ���true������ȷ���false
	 * @return ����Ϊ�շ���true�����򷵻�false
	 */
	public boolean isEmpty() {
		return front == rear;
	}
	/**
	 * �ж��Ƿ�Ϊ�����У����Ϊ������true�����򷵻�false��������ʱ�±�rearָ���
	 * ����Ԫ�ز��洢Ԫ��
	 * @return ����Ϊ������true�����򷵻�false
	 */
	public boolean isFull() {
		return (rear + 1) % array.length == front;
	}
	/**
	 * ��һ������׷�ӵ�����β������ӳɹ�����true�����ʧ�ܷ���false
	 * @param element Ҫ��ӵ�Ԫ��
	 * @return ��ӳɹ�����true�����ʧ�ܷ���false
	 */
	public boolean enQueue(T element) {
		if(isFull()) {
			return false;
		}else{								
			array[rear] = element;
			rear = (rear + 1) % array.length;			
			return true;
		}		
	}
	/**
	 * ������ͷ����Ԫ�س���
	 * @return ���ӵ�ͷ��Ԫ��
	 */
	public T deQueue() {
		if(isEmpty()) {
			return null;
		}else{
			T temp = array[front];
			array[front] = null;
			front = (front + 1) % array.length;
			return temp;
		}		
	}
	/**
	 * �õ���ǰ���еĳ���
	 * @return ��ǰ���еĳ���
	 */
	public int size() {
		return (rear - front + array.length) % array.length;
	}
	public String toString() {		
		if(isEmpty()) {
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			int fTemp = front;			
			//  �������в���ӡ����Ԫ��
			for(; fTemp != rear; 
					fTemp = (fTemp + 1) % array.length) {				
				sb.append(array[fTemp]);
				if(fTemp != rear - 1) {
					sb.append(", ");	
				}
			}
			sb.append("]");
			return sb.toString();
		}				
	}
	
	public static void main(String[] args) {
		CirQueue<String> queue = new CirQueue<String>(5);		
		queue.enQueue("aaa");		
		queue.enQueue("bbb");
		queue.enQueue("ccc");
		queue.enQueue("ddd");
		System.out.println(queue.isFull());
		queue.enQueue("eee");
		System.out.println(queue.size());						
		queue.deQueue();					
		System.out.println(queue.toString());
	}
}
