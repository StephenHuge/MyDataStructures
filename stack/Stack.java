package stack;

/**
 * 这是一个用Java实现的栈的数据结构。
 * @author Stephen Huge
 *
 */
public class Stack {
	
	private Object[] objs;
	/**	栈的大小	*/
	private int size;			
	/**	构造方法*/
	public Stack() {	
		objs = new Object[16];
		size = 0;
	}
	/**	构造方法*/
	public Stack(Object element) {
		objs = new Object[16];
		size = 0;
		objs[size] = element;
		size++;
	}
	/**
	 * 返回栈的长度
	 */
	
	public int size() {
		return size;
	}
	/**
	 * 判断是否是空栈
	 */
	
	public boolean isEmpty() {		
		return size==0;
	}
	/**
	 * 清空栈内数据
	 */
	
	public void clear() {
		for(int i = 0; i < objs.length; i++){
			if(objs[i] != null) {
				objs[i] = null;	
			}
		}		
		size = 0;
	}
	
	public void push(Object element) {
		//判断是否需要扩容
		if(size >= objs.length) {
			reSize();
		}		
		objs[size++] = element;		
	}
	/**
	 * 数组扩容
	 */
	private void reSize() {
		Object[] temp = new Object[2 * objs.length];
		for(int i = 0; i < objs.length; i++){
			temp[i] = objs[i];
		}
		objs = temp;
	}
	/**
	 * 出栈
	 */
	
	public Object pop() {
		if(isEmpty()) {
			return null;			
		}else {
			Object temp = objs[size - 1];
			objs[size - 1] = null;
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
				sb.append(objs[i].toString());
				if(i != size - 1){
					sb.append(", ");
				}				
			}
			sb.append("]");
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		Stack myStack = new Stack("aaa");
		System.out.println(myStack.isEmpty());
		myStack.push("bbb");
		myStack.push("ccc");
		myStack.push("ddd");
		System.out.println(myStack.size());
		myStack.pop();
		System.out.println(myStack.size());
		System.out.println(myStack.toString());
	}
}