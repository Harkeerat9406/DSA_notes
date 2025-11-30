public class DLL {
    Node head;

    private class Node
    {
        Node next, prev;
        int value;
        private Node(int value)
        {
            this.value= value;
        }`
    }


    public void insertFirst(int val)
    {
        Node newNode = new Node(val);
        newNode.prev= null;
        newNode.next= head;
        if (head!=null)
        {
            head.prev= newNode;
        }
        head= newNode;
    }


    public void insertLast(int val)
    {
        Node newNode= new Node(val);
        Node temp= head;
        newNode.next= null;
        if(head==null)
        {
            newNode.prev= null;
            head= newNode;
            return;
        }
        
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next= newNode;
        newNode.prev= temp;
    }


    public void insert(int val, int index)
    {
        if(index==0)
        {
            insertFirst(val);
            return;
        }
        Node temp= getNodeByIndex(index);
        Node newNode= new Node(val);

        if(temp.next==null)
        {
            temp.next=newNode;
            newNode.next= null;
            newNode.prev= temp;
            return;
        }

        newNode.prev= temp;
        newNode.next= temp.next;
        temp.next.prev= newNode;
        temp.next= newNode;
    }


    public void deleteFirst()
    {
        if(head==null) return;

        if (head.next == null) 
        {
            head = null;
            return;
        }
        head= head.next;
        head.prev= null;
    }


    public void deleteLast()
    {
        if(head==null) return;
        else if(head.next==null)
        {
            head=null;
            return;
        }
        Node temp = head;
        while(temp.next!=null)
        {
            temp= temp.next;
        }
        temp.prev.next= null; 
    }


    public void delete(int index)
    {
        if(head==null)  return;

        if(index==0)
        {
            deleteFirst();
            return;
        }

        Node temp= getNodeByIndex(index);

        if(temp.next==null)
        {
            System.out.println("Index out of bounds");
            return;
        }

        if(temp.next.next==null)
        {
            temp.next= null;
            return;
        }
        temp.next= temp.next.next;
        temp.next.prev= temp;
    }


    public Node getNodeByIndex(int index)
    {
        if(index==0)
        {
            return head;
        }
        Node temp= head;
        for(int i=1; i<index; i++)
        {
            temp= temp.next;
        }
        return temp;
    }


    public void display()
    {
        Node temp= head;
        while(temp!= null)
        {
            System.out.print(temp.value+" -> ");
        }
        System.out.println("end");
    }
}
