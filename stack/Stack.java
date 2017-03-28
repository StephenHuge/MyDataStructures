package stack;

/**
 * ����һ����Javaʵ�ֵ�ջ�����ݽṹ��
 * @author Stephen Huge
 *
 */
public class Stack {
	
	private Object[] objs;
	/**	ջ�Ĵ�С	*/
	private int size;			
	/**	���췽��*/
	public Stack() {	
		objs = new Object[16];
		size = 0;
	}
	/**	���췽��*/
	public Stack(Object element) {
		objs = new Object[16];
		size = 0;
		objs[size] = element;
		size++;
	}
	/**
	 * ����ջ�ĳ���
	 */
	
	public int size() {
		return size;
	}
	/**
	 * �ж��Ƿ��ǿ�ջ
	 */
	
	public boolean isEmpty() {		
		return size==0;
	}
	/**
	 * ���ջ������
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
		//�ж��Ƿ���Ҫ����
		if(size >= objs.length) {
			reSize();
		}		
		objs[size++] = element;		
	}
	/**
	 * ��������
	 */
	private void reSize() {
		Object[] temp = new Object[2 * objs.length];
		for(int i = 0; i < objs.length; i++){
			temp[i] = objs[i];
		}
		objs = temp;
	}
	/**
	 * ��ջ
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