package Labs.lab04;

import java.util.ArrayList;

public class MyLinkedListTricky_660261 extends MyLinkedList_660261
{

    public void q1_counter_clockwise(int k)
    {
        Node current = head;
        int count = 1;
        while(current != null && count < k)
        {
            current = current.next;
            count++;
        }

        if(current == null) return;

        Node kNode = current;

        while(current.next != null)
        {
            current = current.next;
        }

        current.next = head;
        head = kNode.next;

        kNode.next = null;
    }

    public void q2_reverse()
    {
        Node current = head;
        Node previous = null;
        Node next = null;

        while(current != null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    public void q3_remove_dup()
    {
        Node current = head;
        Node prev = null;
        ArrayList<Integer> arr = new ArrayList<>();

        while(current != null)
        {
            if(arr.contains(current.data))
                prev.next = current.next;
            else
            {
                arr.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    public void q4_add_one()
    {
        q2_reverse();

        Node current = head;
        int carry = 1;

        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            current = current.next;
        }

        q2_reverse();
    }

    public boolean q5_isPalindrome()
    {
        Node p = head;
        String str1 = "";
        String str2 = "";
        while(p != null)
        {
            str1 += Integer.toString(p.data);
            p = p.next;
        }

        q2_reverse();
        p = head;
        while(p != null)
        {
            str2 += Integer.toString(p.data);
            p = p.next;
        }
        return str1.equals(str2);
    }
}
