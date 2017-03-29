package linearlist;

/**
 * ����һ����Javaʵ�ֵ���������ݽṹ��
 * @author Stephen Huge
 */
public class LinkList<T> {
	/**
	 * LinkList��һ���ڲ���Node�����ĳ�Ա��������һ��T���͵ı���data��Node���͵ı���next��
	 */
	public class Node {
		private T data;
		private Node next;
		public Node() {	}
		/**
		 * �ڲ���Node���вι��췽��
		 */
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	/**	�����ͷ���  */
	private Node header;
	/**	�����β��� */
	private Node tail;
	/**	����ĳ���*/
	private int size;
	
	/**
	 * Ĭ�Ϲ��캯��
	 */
	public LinkList() {
		header = null;
		tail = null;
	}
	/**
	 * �вι��캯�����佫����element����Ϊ�������ͷ��㣬��ʱ������ֻ��element
	 * һ��Ԫ�أ�����ͷ����β�����ͬ��
	 */
	public LinkList(T element) {
		header = new Node(element, null);
		tail = header;
		size++;
	}
	/**
	 * �������ĵ�ǰ����
	 */
	public int length() {
		return size;
	}
	/** 
	 * �����ƶ�λ��index�Ľ��
	 */
	public T get(int index) {
		return getNodeByIndex(index).data;
	}
	
	private Node getNodeByIndex(int index) {
		if(index < 0 || index > size - 1){
			throw new IndexOutOfBoundsException("���Ա�Խ��");
		}
		Node current = header;
		for(int i = 0; i < size && current != null; i++, current = current.next){
			if(i == index) {
				return current;
			}	
		}
		return null;
	}
	
	/**
	 * ����element�������λ�ã�-1��ʾ������
	 */
	public int locate(T element) {
		Node current = header;
		for(int i = 0; i < size && current != null; i++, current = current.next){
			if(current.data == element) {
				return i;
			}	 
		}
		return -1;
	}
	
	/**
	 * ��indexλ�ò�����element
	 */
	public void insert(T element, int index) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		if(header == null) {
			add(element);
		}else{
			if(index == 0) {
				addAtHeader(element);
			}else{
				Node prev = getNodeByIndex(index - 1);
				prev.next = new Node(element, prev.next);
				size++;
			}
		}
	}
	/**
	 * ����β�巨Ϊ��������½��
	 */
	public void add(T element) {
		if(header == null) {
			header = new Node(element, null);
			tail = header;
		}else{
			Node newNode = new Node(element, null);
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	/**
	 * ����ͷ�巨Ϊ��������½��
	 */
	public void addAtHeader(T element) {
			header = new Node(element, header);
			if(tail == null){
				tail = header;
			}			
			size++;
	}
	/**
	 * ɾ��indexλ�õĽ��
	 */
	public T delete(int index) {
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		Node del = null;
		if(index == 0) {
			del = header;
			header = header.next;			
		}else{
			Node pre = getNodeByIndex(index - 1);
			del = pre.next;
			pre.next = del.next;
			del.next = null;			
		}
		size--;
		return del.data;
	}
	/**
	 * ���������ɾ��һ�����
	 */
	public T remove() {		
		return delete(size - 1);
	}
	
	/**
	 * �ж������Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * �������
	 */
	public void clear() {
		header = null;
		tail = null;
		size = 0;
	}
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[");
			for(Node current = header; current != null; current = current.next){
				sb.append(current.data.toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}		
	}
	
	public static void main(String[] args) {
		LinkList<String> list = new LinkList<String>();
		list.insert("aaa", 0);
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		System.out.print(list.toString());
		list.insert("eee", 1);
		System.out.print(list.toString());
		list.delete(3);
		System.out.print(list.toString());
		System.out.println("ccc�������е�λ�ã�"+list.locate("ccc"));  
        System.out.println("����������2����Ԫ�أ�"+list.get(2));  
	}
}
