package Labs.lab04;

public class MyLinkedList_660261 
{

    public class Node
    {
        int data;
        Node next;

        public Node(int d)
        {
            data = d;
        }
    }

    Node head = null;

    MyLinkedList_660261()
    {
        
    }

    public void add(int d)
    {
        Node p = new Node(d);
        p.next = head;
        head = p;
    }

    public void insert(int d)
    {
        Node p = head;
        Node q = new Node(d);
        if(head == null || head.data >= d)
        {
            q.next = head;
            head = q;
            return;
        }

        while(p.next != null && p.next.data < d)
        {
            p = p.next;
        }

        q.next = p.next;
        p.next = q;
    }

    public int find(int d)
    {
        Node p = head;
        int index = 0;
        while(p != null)
        {
            if(p.data == d) return index;
            p = p.next;
            index++;
        }
        return -1;
    }

    public void delete(int d)
    {
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while((p.next != null) && (p.next.data != d))
        {
            p = p.next;
        }
        if(p.next != null)
        {
            p.next = p.next.next;
        }
        head = t.next;
    }

    @Override
    public String toString() 
    {
        Node p = head;
        String res = "";
        res += "head -> ";
        while(p != null)
        {
            res += p.data + " -> ";
            p = p.next;
        }
        res += "null";
        return res;
    }

    public int size()
    {
        int size = 0;
        Node p = head;
        while(p != null)
        {
            p = p.next;
            size++;
        }
        return size;
    }

    public void add(int[] d)
    {
        for(int i = d.length - 1; i >= 0; i--)
        {
            add(d[i]);
        }
    }

    public void insert(int[] d)
    {
        for(int i = 0; i < d.length; i++)
        {
            insert(d[i]);
        }
    }

}
