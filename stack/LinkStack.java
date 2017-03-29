package stack;

/**
 * 这是一个用Java实现的链栈的数据结构。这里需要注意的是每入栈一个元素，实际操作会把这个元素
 * 变成链表的头结点，也就是会更新头结点而不是尾节点。
 * @author Stephen Huge
 *  
 */
public class LinkStack<T>{
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
	/** 栈顶元素 */
	private Node top;
	/** 栈的长度 */
	private int size = 0;
	/**	栈的构造函数 */
	public LinkStack() {	}
	/** 栈的有参构造函数 */
	public LinkStack(T element) {
		top = new Node(element, null);		
		size++;
	}
	/** 返回栈的长度 */
	public int size() {		
		return size;
	}
	/** 判断栈是否是空栈 */
	public boolean isEmpty() {		
		return size == 0;
	}	
	/** 清空栈 */
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
	 * 入栈操作，在原有的top结点之前添加新的结点，将新建的结点更新为top结点 
	 * @param element 需要入栈的新信息
	 */
	public void push(T element) {		
		top = new Node(element, top);		
		size++;
	}	
	/**
	 * 出栈操作，如果当前栈为空，返回null；如果当前栈不为空，将原来的top结点删除，
	 * 将top结点的next结点更新为top结点，返回出栈前的top结点带的信息
	 * @return 如果当前栈为空，返回null，不空则返回出栈前的top结点带的信息
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
	 /** 按出栈顺序toString() */ 	 
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
