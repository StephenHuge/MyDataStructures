package linearlist;

/**
 * 这是一个用Java实现的链表的数据结构。
 * @author Stephen Huge
 */
public class LinkList<T> {
	/**
	 * LinkList的一个内部类Node，它的成员变量包括一个T类型的变量data和Node类型的变量next。
	 */
	public class Node {
		private T data;
		private Node next;
		public Node() {	}
		/**
		 * 内部类Node的有参构造方法
		 */
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	/**	链表的头结点  */
	private Node header;
	/**	链表的尾结点 */
	private Node tail;
	/**	链表的长度*/
	private int size;
	
	/**
	 * 默认构造函数
	 */
	public LinkList() {
		header = null;
		tail = null;
	}
	/**
	 * 有参构造函数，其将变量element设置为该链表的头结点，此时链表中只有element
	 * 一个元素，所以头结点和尾结点相同。
	 */
	public LinkList(T element) {
		header = new Node(element, null);
		tail = header;
		size++;
	}
	/**
	 * 获得链表的当前长度
	 */
	public int length() {
		return size;
	}
	/** 
	 * 返回制定位置index的结点
	 */
	public T get(int index) {
		return getNodeByIndex(index).data;
	}
	
	private Node getNodeByIndex(int index) {
		if(index < 0 || index > size - 1){
			throw new IndexOutOfBoundsException("线性表越界");
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
	 * 返回element在链表的位置，-1表示不存在
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
	 * 在index位置插入结点element
	 */
	public void insert(T element, int index) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("线性表索引越界");
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
	 * 采用尾插法为链表添加新结点
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
	 * 采用头插法为链表添加新结点
	 */
	public void addAtHeader(T element) {
			header = new Node(element, header);
			if(tail == null){
				tail = header;
			}			
			size++;
	}
	/**
	 * 删除index位置的结点
	 */
	public T delete(int index) {
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("线性表索引越界");
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
	 * 从链表后面删除一个结点
	 */
	public T remove() {		
		return delete(size - 1);
	}
	
	/**
	 * 判断链表是否为空
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * 清空链表
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
		System.out.println("ccc在链表中的位置："+list.locate("ccc"));  
        System.out.println("链表中索引2处的元素："+list.get(2));  
	}
}
