public class LL {
    Node head, tail;
    int size;               //set to default value = 0, only done for instance or static variables not local ones


    private class Node
    {
        private int value;
        private Node next;
        

        public Node(int value)
        {
            this.value = value;
        }

        public Node(int value, Node next)
        {
            this.value = value;
            this.next = next;
        }
    }


    public void insertFirst(int val)
    {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail==null)
        {
            tail = head;
        }
        /*Above we first create a reference variable 'newNode' and make object using 'new Node(data)'
        Then we point the 'next' variable of the object to what head is pointing at using 'newNode.next = head
        And then point head to the object by setting its value as newNode which is the reference variable*/
    }


    public void insertLast(int val)
    {
        if(tail==null)
        {
            insertFirst(val);
            return;
        }

        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
        size++;
        /*Tail is initially pointing towards the last object. So when inserting at last position, we set 'next' 
        variable of the last object to point towards the newly inserted Node object using 'tail.next = newNode'
        Now we set tail to point to the last object using 'tail = newNode'
         */
    }


    public void insert(int val, int index)
    {
        if(index==0)
        {
            insertFirst(val);
            return;
        }
        else if(index==size)
        {
            insertLast(val);
            return;
        }

        Node temp = head;
        for(int i=1; i<index; i++)
        {
            temp = temp.next;
        }

        Node insertNode = new Node(val, temp.next);
        temp.next = insertNode;
        size++;
        /*Linked list = 3, 5, 9, 8, 12
        To insert val=7 just after 9, first we traverse from head to the object storing value 9. Now temp points 
        to the object storing val=9. 
        Then we create new node and set its val=7 and node.next= temp.next (stores address for 8)
        Now new node.next points to 8 so we make temp.next point to the new node with val=7
         */
    }


    public int deleteFirst()
    {
        int val = head.value;
        head = head.next;
        if(head==null)
        {
            tail=null;
        }
        size--;
        return val;
    }


    public int deleteLast()
    {
        if(size<=1)
        {
            return deleteFirst();
        }
        int val= tail.value;
        
        tail= getNodeByIndex(size-2);
        tail.next=null;
        size--;
        return val;
    }


    public int deleteByIndex(int index)
    {
        if(index==0)
        {
            deleteFirst();
            return 0;
        }
        else if(index==size-1)
        {
            deleteLast();
        }
        Node temp= getNodeByIndex(index-1);
        int val= temp.next.value;
        temp.next= temp.next.next;
        size--;
        return val;
    }


    public Node getNodeByIndex(int index)
    {                               //5->4->3->8->2
        Node temp= head;
        for(int i=0; i<index;i++)
        {
            temp=temp.next;
        }
        return temp;
    }


    public Node getNodeByValue(int value)
    {
        Node temp= head;
        while(temp!=null)
        {
            if(temp.value==value)
            {
                return temp;
            }
            temp= temp.next;
        }
        return null;
    }


    public void display()
    {
        Node temp= head;
        while(temp!=null)
        {
            System.out.print(temp.value+" -> ");
            temp=temp.next;
        }
        System.out.println();
    }
}
