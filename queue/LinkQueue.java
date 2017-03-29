package queue;
/**
 * ����һ��Javaʵ�ֵ������С�
 * @author Stephen Huge
 * 
 */
public class LinkQueue<T> {
	/**
	 * ˽���ڲ���Node
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
	/** ����ͷ��Ԫ�����ڽ�� */
	private Node front;
	/** ����β��Ԫ�����ڽ�� */
	private Node rear;
	/** ���г���*/
	private int size;
	
	public LinkQueue() {	
		front = null;
		rear = null;
	}
	/**
	 * �вι��캯��������һ��Ҫ������е�Ԫ�أ����������еĵ�һ�����
	 * @param element ������е�Ԫ��
	 */
	public LinkQueue(T element) {
		front = new Node(element, null);
		rear = front;
		size++;
	}
	/**
	 * ��һ������׷�ӵ�����β������ӳɹ�����true�����ʧ�ܷ���false
	 * @param element Ҫ��ӵ�Ԫ��
	 * @return ��ӳɹ�����true�����ʧ�ܷ���false
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
	 * ������ͷ����Ԫ�س���
	 * @return ���ӵ�ͷ��Ԫ��
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
	 * �ж��Ƿ�Ϊ�ն��У����front��rear��ȷ���true������ȷ���false
	 * @return ����Ϊ�շ���true�����򷵻�false
	 */
	public boolean isEmpty() {
		return front == null;
	}
	/**
	 * �õ���ǰ���еĳ���
	 * @return ��ǰ���еĳ���
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

