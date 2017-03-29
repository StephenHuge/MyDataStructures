package stack;

/**
 * ����һ����Javaʵ�ֵ���ջ�����ݽṹ��������Ҫע�����ÿ��ջһ��Ԫ�أ�ʵ�ʲ���������Ԫ��
 * ��������ͷ��㣬Ҳ���ǻ����ͷ��������β�ڵ㡣
 * @author Stephen Huge
 *  
 */
public class LinkStack<T>{
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
	/** ջ��Ԫ�� */
	private Node top;
	/** ջ�ĳ��� */
	private int size = 0;
	/**	ջ�Ĺ��캯�� */
	public LinkStack() {	}
	/** ջ���вι��캯�� */
	public LinkStack(T element) {
		top = new Node(element, null);		
		size++;
	}
	/** ����ջ�ĳ��� */
	public int size() {		
		return size;
	}
	/** �ж�ջ�Ƿ��ǿ�ջ */
	public boolean isEmpty() {		
		return size == 0;
	}	
	/** ���ջ */
	public void clear() {
		if(isEmpty()){
			return;
		}else {
			top = null;
			top.data = null;
			size = 0;
		}
	}
		
	/**
	 * ��ջ��������ԭ�е�top���֮ǰ����µĽ�㣬���½��Ľ�����Ϊtop��� 
	 * @param element ��Ҫ��ջ������Ϣ
	 */
	public void push(T element) {		
		top = new Node(element, top);		
		size++;
	}	
	/**
	 * ��ջ�����������ǰջΪ�գ�����null�������ǰջ��Ϊ�գ���ԭ����top���ɾ����
	 * ��top����next������Ϊtop��㣬���س�ջǰ��top��������Ϣ
	 * @return �����ǰջΪ�գ�����null�������򷵻س�ջǰ��top��������Ϣ
	 */
	public T pop() {
		if(isEmpty()){
			return null;
		}else{
			Node prevTop = top;
			top = top.next;
			prevTop.next = null;
			size--;
			return prevTop.data;
		}
	}
	 /** ����ջ˳��toString() */ 	 
		public String toString() {
			if(isEmpty()) {
				return "[]";
			}else{
				StringBuilder sb = new StringBuilder();
				Node temp = top;
				sb.append("Top[");
				for(int i = 0; i < size; i++) {				
					sb.append(temp.data.toString());
					temp = temp.next;
					if(i != size - 1){
						sb.append(", ");
					}
				}			
				sb.append("]Bottom");
				return sb.toString();
			}
		}
	
	public static void main(String[] args) {
		LinkStack<String> myLinkStack = new LinkStack<String>("aaa");
		System.out.println(myLinkStack.isEmpty());
		myLinkStack.push("bbb");
		myLinkStack.push("ccc");
		myLinkStack.push("ddd");
		System.out.println(myLinkStack.size());
		myLinkStack.pop();
		System.out.println(myLinkStack.size());
		System.out.println(myLinkStack.toString());
	}	
}
