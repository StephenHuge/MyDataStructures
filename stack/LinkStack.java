package stack;

import linearlist.LinkList;

/**
 * 这是一个用Java实现的链栈的数据结构。
 * @author Stephen Huge
 *  
 */
public class LinkStack<T>{
	/**
	 * 声明私有链表
	 */
	private LinkList<T> list;
	/**
	 * 栈的长度
	 */
	private int size;
	
	public LinkStack() {
		list = new LinkList<T>();
		size = 0;
	}
	public LinkStack(T element) {
		list = new LinkList<T>(element);
		size = 0;
		size++;
	}
	/**
	 * 返回栈的长度
	 */
	public int size() {		
		return size;
	}
	/**
	 * 判断栈是否是空栈
	 */
	public boolean isEmpty() {		
		return size == 0;
	}
	
	/**
	 * 清空栈
	 */
	public void clear() {
		if(isEmpty()){
			return;
		}else {
			list.clear();
			size = 0;
		}
	}
	
	/**
	 * 压栈
	 */
	public void push(T element) {		
		list.insert(element, size);
		size++;
	}

	/**
	 * 出栈
	 */
	public Object pop() {
		if(isEmpty()){
			return null;
		}else{
			Object temp = (Object) list.get(size-1);
			list.remove();
			size--;
			return temp;
		}
	}
	
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder();
			sb.append("ArrayStack:[");
			for(int i = 0; i < size; i++) {				
				sb.append(list.get(i));
				if(i != size - 1){
					sb.append(", ");
				}
			}			
			sb.append("]");
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
