package queue;
/**
 * 这是一个Java实现的循环队列。
 * 
 * @author Stephen Huge
 *
 */
public class CirQueue<T> {
	/** 用来实现队列的数组 */
	private T[] array; 
	/** 队列头部元素的数组下标 */
	private int front;
	/** 队列尾部元素的数组下标-1，也就是说rear指向的是对尾元素之后的一个值为空的数组元素，其默认不存储元素*/
	private int rear;	
	public CirQueue() {
		this(16);
	} 
	/**
	 * 有参构造函数，产生一个定长的数组，这个长度减1是队列的最大长度
	 * @param len 队列的最大长度
	 */
	@SuppressWarnings("unchecked")
	public CirQueue(int len) {
		array = (T[]) (new Object[len]);
		front = 0;
		rear = 0;
	}
	/**
	 * 判断是否为空队列，如果front和rear相等返回true，不相等返回false
	 * @return 队列为空返回true，否则返回false
	 */
	public boolean isEmpty() {
		return front == rear;
	}
	/**
	 * 判断是否为满队列，如果为满返回true，否则返回false，队列满时下标rear指向的
	 * 数组元素不存储元素
	 * @return 队列为满返回true，否则返回false
	 */
	public boolean isFull() {
		return (rear + 1) % array.length == front;
	}
	/**
	 * 将一个对象追加到队列尾部，添加成功返回true，添加失败返回false
	 * @param element 要添加的元素
	 * @return 添加成功返回true，添加失败返回false
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
	 * 将队列头部的元素出队
	 * @return 出队的头部元素
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
	 * 得到当前队列的长度
	 * @return 当前队列的长度
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
			//  遍历队列并打印其中元素
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
