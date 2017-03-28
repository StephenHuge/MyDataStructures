package stack;

import linearlist.LinkList;

/**
 * ����һ����Javaʵ�ֵ���ջ�����ݽṹ��
 * @author Stephen Huge
 *  
 */
public class LinkStack<T>{
	/**
	 * ����˽������
	 */
	private LinkList<T> list;
	/**
	 * ջ�ĳ���
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
	 * ����ջ�ĳ���
	 */
	public int size() {		
		return size;
	}
	/**
	 * �ж�ջ�Ƿ��ǿ�ջ
	 */
	public boolean isEmpty() {		
		return size == 0;
	}
	
	/**
	 * ���ջ
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
	 * ѹջ
	 */
	public void push(T element) {		
		list.insert(element, size);
		size++;
	}

	/**
	 * ��ջ
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
