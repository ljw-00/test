public class ListContainer {
    private final int MIN_VALUE = Integer.MIN_VALUE;
    private Node head;      // 첫번째 노드
    private Node tail;      // 마지막 노드
    private int nodeCount;  // 노드 개수

    // 기본생성자
    public ListContainer()
    {
        head = null;
        tail = null;
        nodeCount = 0;
    }

    // 노드를 가지고온다.
    public Node getNode(int index)
    {
        // 잘못된 범위
        if ((index < 0) || (index >= nodeCount))
            return null;

        Node node = head;

        for (int i = 0; i < index; i++)
        {
            node = node.next;
        }

        return node;
    }

    // 앞에 추가
    public boolean insertNodetoFront(Node node)
    {
        // 노드 최초 생성
        if (nodeCount == 0)
        {
            head = node;
            tail = node;
        }
        // 노드가 한개 이상 존재할 때
        else
        {
            head.prev = node;
            node.next = head;            
            head = node;
        }

        nodeCount++;
        return true;
    }

    // 뒤에 추가
    public boolean insertNodetoBack(Node node)
    {
        // 노드 개수가 0개일 때
        if (nodeCount == 0)
        {
            insertNodetoFront(node);
        }
        else
        {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        nodeCount++;
        return true;
    }

    // 특정위치(pos)에 추가
    public boolean insertNodetoPos(Node node, int pos)  // 파라미터는 목적이 먼저 !!!!!!!!!!!!!!!!!!!!!!!!!!!
    {
        // 잘못된 위치를 참조할 경우 false 리턴
        if ((pos < 0) || (pos > nodeCount))
        {
            return false;
        }

        // 추가하려는 위치가 가장 앞일 경우 insertNodetoFront 호출 
        if (pos == 0)
        {
            insertNodetoFront(node);
            return true;
        }

        // 추가하려는 위치가 마지막일 경우 insertNodetoBack 호출
        if (pos == nodeCount)
        {
            insertNodetoBack(node);
            return true;
        }

        // 추가하려는 위치의 이전 노드
        Node prevNode = getNode(pos - 1);

        // 추가하려는 위치의 노드
        Node nextNode = prevNode.next;

        prevNode.next = node;
        node.prev = prevNode;
        node.next = nextNode;
        nextNode.prev = node;

        nodeCount++;
        return true;
    }

    // 위치(pos)로 삭제
    public boolean deleteNodeByPos(int pos)
    {
        // 잘못된 위치를 참조할 경우 false 리턴
        if ((pos < 0) || (pos > nodeCount))
        {
            return false;
        }

        // 노드 개수가 0개일 때 false 리턴
        if (nodeCount == 0)
        {
            return false;
        }
        // 첫번째 노드 삭제
        else if (pos == 0)
        {
            // head를 다음 노드로 지정
            head = head.next;
            
            nodeCount--;
            return true;
        }
        // 마지막 노드 삭제
        else if (pos == nodeCount - 1)
        {
            tail.prev.next = null;
            tail = tail.prev;

            nodeCount--;
            return true;
        }
        // 특정위치(pos) 삭제
        else
        {
            // 삭제할 노드의 이전 노드
            Node prevNode = getNode(pos - 1);
            // 삭제할 노드의 다음 노드
            Node nextNode = getNode(pos + 1);

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            nodeCount--;
            return true;
        }
    }

    // 키를 검색해서 삭제
    public boolean deleteNodeByKey(int key)
    {
        // 노드가 없으면 false 히턴
        if (nodeCount == 0)
        {
            return false;
        }

        Node target = head;
        int targetPos = 0;

        for (int i = 0; i < nodeCount; i++)
        {
            if (target.key == key)
            {
                targetPos = i;
                break;
            }
            target = target.next;
        }

        return deleteNodeByPos(targetPos);
    }

    // 문자로 삭제 
    public boolean deleteNodeByValue(String value, boolean bLike)
    {
        // 노드가 없으면 false 히턴
        if (nodeCount == 0)
        {
            return false;
        }

        Node target = head;
        int targetCount = 0;

        if (bLike == false)
        {
            for (int i = 0; i < nodeCount; i++)
            {
                if (target.value.equals(value))
                {
                    target.key = MIN_VALUE;
                    targetCount++;
                }
                target = target.next;
            }

            for (int i = 0; i < targetCount; i++)
            {
                deleteNodeByKey(MIN_VALUE);
            }
        }
        // bLike == true --> value를 포함하고 있으면 모두 지운다.
        else if (bLike == true)
        {
            for (int i = 0; i < nodeCount; i++)
            {
                if (target.value.contains(value))
                {
                    target.key = MIN_VALUE;
                    targetCount++;
                }
                target = target.next;
            }

            for (int i = 0; i < targetCount; i++)
            {
                deleteNodeByKey(MIN_VALUE);
            }
        }
        return false;
    }

    // 프린트
    public void printAll()
    {     
        Node target = head;

        for (int i = 0; i < nodeCount; i++)
        {
            System.out.printf("pos : %d [key : %d, value : %s]\n", i, target.key, target.value);
            target = target.next;
        }
    }
}
