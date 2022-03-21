package DateStruckStudy;

/**
 * 单向链表存取容器
 * @param <E>
 */
public class MySinglyLinkedList<E> implements MyList<E> {

    /**
     * 定义节点对象
     */
    class Node<E>{
        private E item;//存储元素
        private Node next;//存储下一个节点对象的地址
        Node(E item, Node next){
            this.item = item;
            this.next = next;
        }
    }
    private Node head;//存放链表的头节点
    private int size;//记录元素个数

    /**
     * 添加元素
     * @param element
     */
    @Override
    public void add(E element) {
        //创建节点
        Node<E> node = new Node<>(element,null);
        //找到尾节点
        Node tail = getTail();
        //节点挂接
        if(tail == null){
            this.head = node;
        }else {
            tail.next = node;
        }
        //元素记录
        this.size++;
    }
    /**
     * 找尾节点
     */
    private Node getTail(){
        if(this.head == null){
            return null;
        }
        else {
            Node node = this.head;
            while (true){
                if(node.next == null){
                    return node;
                }
                node = node.next;

            }
        }
    }

    /**
     * 获取元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        //校验index合法性
        this.checkIndex(index);
        //根据位置获取指定节点
        Node<E> node = this.getNode(index);
        //返回节点

        return node.item;
    }

    /**
     * 对index进行校验
     */
    private void checkIndex(int index){
        if(!(index>=0&&index<this.size)){
            throw new IndexOutOfBoundsException("Index:"+index+"Size:"+this.size);
        }
    }
    /**
     * 根据位置获取节点
     */
    private Node getNode(int index){
        Node<E> node = this.head;
        for(int i = 0;i<index;i++){
            node = node.next;
        }
        return node;
    }

    /**
     * 获取元素个数
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * 删除元素
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        //校验位置
        checkIndex(index);
        //找到节点对象
        Node<E> node =getNode(index);
        //获取节点中的元素
        E item = node.item;
        //删除节点
        //判断是否为头节点
        if(this.head == node){
            this.head = node.next;

        }else {
            Node<E> temp = this.head;
            for (int i = 0;i<index-1;i++){
                temp = temp.next;
            }
            temp.next = node.next;

        }
         node.next = null;
        //更新记录
        this.size--;

        //返回元素
        return item;

    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        MySinglyLinkedList<String > mySinglyLinkedList = new MySinglyLinkedList<>();
        mySinglyLinkedList.add("a");
        mySinglyLinkedList.add("b");
        mySinglyLinkedList.add("c");
        mySinglyLinkedList.add("d");
        System.out.println(mySinglyLinkedList.size());
        System.out.println(mySinglyLinkedList.remove(0));
        for (int i = 0;i< mySinglyLinkedList.size();i++){
            System.out.println(mySinglyLinkedList.get(i));
        }
    }
}
