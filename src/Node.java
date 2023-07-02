public class Node {
    public int key;
    public String value;
    public Node prev;   // 이전 노드객체의 참조값
    public Node next;   // 다음 노드객체의 참조값

    // 기본생성자
    public Node()
    {
        key = 0;
        value = "";
        prev = null;
        next = null;
    }

    // 오버로딩 생성자
    public Node(int key, String value)
    {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }

    // Getter, Setter
    // public int getKey() {
    //     return this.key;
    // }

    // public String getValue() {
    //     return this.value;
    // }

    // public Node getPrev() {
    //     return this.prev;
    // }

    // public void setPrev(Node prev) {
    //     this.prev = prev;
    // }

    // public Node getNext() {
    //     return this.next;
    // }

    // public void setNext(Node next) {
    //     this.next = next;
    // }
}
