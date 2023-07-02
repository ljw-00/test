public class App {
    public static void main(String[] args) throws Exception {
        ListContainer lc = new ListContainer();

        lc.insertNodetoPos(new Node(0, "abc"), 0);
        lc.insertNodetoPos(new Node(1, "abc"), 1);
        lc.insertNodetoPos(new Node(2, "bb"), 2);
        lc.insertNodetoPos(new Node(3, "cd"), 3);
        lc.insertNodetoPos(new Node(4, "abd"), 4);
        lc.insertNodetoPos(new Node(5, "ee"), 5);
        lc.insertNodetoPos(new Node(6, "fd"), 6);

        // lc.deleteNodeByPos(3);
        // lc.deleteNodeByKey(1);
        // lc.deleteNodeByValue("abc", false);
        lc.deleteNodeByValue("d", true);

        lc.printAll();
    }
}
