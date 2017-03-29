package queue;
/**
 * 这是一个Java实现的链队列。
 * @author Stephen Huge
 * 
 */
public class LinkQueue<T> {
	/**
	 * 私有内部类Node
	 */
	private class Node{
		public T data;
		public Node next;
		public Node() {	}
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}		
	}	
	/** 队列头部元素所在结点 */
	private Node front;
	/** 队列尾部元素所在结点 */
	private Node rear;
	/** 队列长度*/
	private int size;
	
	public LinkQueue() {	
		front = null;
		rear = null;
	}
	/**
	 * 有参构造函数，传入一个要进入队列的元素，生成链队列的第一个结点
	 * @param element 进入队列的元素
	 */
	public LinkQueue(T element) {
		front = new Node(element, null);
		rear = front;
		size++;
	}
	/**
	 * 将一个对象追加到队列尾部，添加成功返回true，添加失败返回false
	 * @param element 要添加的元素
	 * @return 添加成功返回true，添加失败返回false
	 */
	public boolean enQueue(T element) {
		if(isEmpty()) {
			front = new Node(element, null);
			rear = front;			
		}else{
			Node newNode = new Node(element, null);
			rear.next = newNode;
			rear = newNode;
		}
		size++;
		return true;
	}
	/**
	 * 将队列头部的元素出队
	 * @return 出队的头部元素
	 */
	public T deQueue() {
		if(isEmpty()) {
			return null;
		}else{
			Node temp = front;
			front = front.next;
			temp.next = null;
			size--;
			return temp.data;			
		}		
	}
	/**
	 * 判断是否为空队列，如果front和rear相等返回true，不相等返回false
	 * @return 队列为空返回true，否则返回false
	 */
	public boolean isEmpty() {
		return front == null;
	}
	/**
	 * 得到当前队列的长度
	 * @return 当前队列的长度
	 */
	public int size() {
		return size;
	}
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for(Node current = front; current != null; current = current.next){
				sb.append(current.data.toString());
				if(current != rear) {
					sb.append(", ");
				}
			}
			sb.append("]");
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		LinkQueue<String> lq = new LinkQueue<String>();
		lq.enQueue("aaa");
		System.out.println(lq.toString());
		lq.enQueue("bbb");
		System.out.println(lq.toString());
		lq.enQueue("ccc");
		System.out.println(lq.toString());
		System.out.println(lq.size());
		lq.deQueue();
		System.out.println(lq.toString());
		System.out.println(lq.size());
	}
}

