/* 708. Insert into a Sorted Circular Linked List

Given a Circular Linked List node, which is sorted in non-descending order, write a function to insert a value insertVal into the list such that it 
remains a sorted circular list. The given node can be a reference to any single node in the list and may not necessarily be the smallest value in the circular list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, 
the circular list should remain sorted.

If the list is empty (i.e., the given node is null), you should create a new single circular list and return the reference to that single node. 
Otherwise, you should return the originally given node.

Example 1:
Input: head = [3,4,1], insertVal = 2
Output: [3,4,1,2]
Explanation: In the figure above, there is a sorted circular list of three elements. You are given a reference to the node with value 3, 
and we need to insert 2 into the list. The new node should be inserted between node 1 and node 3. After the insertion, the list should 
look like this, and we should still return node 3.

Example 2:
Input: head = [], insertVal = 1
Output: [1]
Explanation: The list is empty (given head is null). We create a new single circular list and return the reference to that single node.

Example 3:
Input: head = [1], insertVal = 0
Output: [1,0]

Constraints:
The number of nodes in the list is in the range [0, 5 * 104].
-10^6 <= Node.val, insertVal <= 10^6
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        //创建一个值为insertVal, 指向null 的新节点
        Node node = new Node(insertVal, null); 

        //1. 当head链表为空的时候：
        if(head == null){
            head = node;
            head.next = head; //指向自己，保证链表head是循环的
            return head;
        }

        // 2. 当head链表只有一个节点的时候
        if(head.next == head){
            head.next = node;
            node.next = head; //将head与新节点node，相连 保证是循环的
            return head;
        }

        // 3. 当链表head有两个节点以上的时候, 两种情况：
        // a. insertVal节点可以插入到某两个节点之间，即存在 node.val <= insertVal && insertVal <= node.next.val
        // b. insertVal节点找不到插入的地方，则说明当前节点是链表head的最大值和最小值，则把节点插入到最大值后面即可
        Node cur = head;
        Node next = head.next;
        //开始主遍历
        while(next != head){
            // a. insertVal节点可以插入到某两个节点之间
            if(insertVal >= cur.val && insertVal <= next.val){
                break; //终止循环
            }

            //b. insertVal节点找不到插入的地方，则说明当前节点是链表head的最大值和最小值
            //则把节点插入到最大值后面即可, 这里的cur表示最大值的节点，next表示回到head点
            else if(cur.val > next.val){
                if(insertVal > cur.val || insertVal < next.val){
                    break; //终止循环
                }
            }

            cur = next; //移动cur指针前进
            next = cur.next; //移动next指针前进
        }

        //在找到的位置插入 值为insertval的新节点node
        cur.next = node;
        node.next = next;

        return head;//输出head链表
    }
}
