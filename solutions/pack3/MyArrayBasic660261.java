package solutions.pack3;

import java.util.Arrays;

public class MyArrayBasic660261
{
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

    public MyArrayBasic660261(int ...a)
    {
        size = a.length;
        if(MAX_SIZE < a.length)
        {
            data = new int[a.length];
            MAX_SIZE = a.length;
        }
        for(int i = 0; i < a.length; i++)
        {
            data[i] = a[i];
        }
    }

    public int add(int d)
    {
        if(isFull())
            return -1;
        data[size++] = d;
        return size;
    }

    public void insert(int d, int index)
    {
        for(int i = size; i > index; i--)
        {
            data[i] = data[i - 1];
        }
        data[index] = d;
        size++;
    }

    public int find(int d)
    {
        for(int i = 0; i < size; i++)
            if(data[i] == d)
                return i;
        return -1;
    }

    public int binarySearch(int d)
    {
        int head = 0;
        int tail = size - 1;
        while(head <= tail)
        {
            int mid = (head + tail) / 2;
            if(data[mid] == d)
                return mid;
            if(d < data[mid])
                tail = mid - 1;
            else
                head = mid + 1;
        }
        return -1;
    }

    public void delete(int index)
    {
        if(isEmpty())
            return;
        for(int i = index; i < size; i++)
        {
            data[i] = data[i + 1];
        }
        size--;
    }

    public boolean isFull()
    {
        return size == MAX_SIZE;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }

    // @Override
    // public String toString() {
    //     StringBuffer sb = new StringBuffer();
    //     sb.append("[");
    //     for(int i = 0; i < size - 1; i++)
    //     {
    //         sb.append(data[i]);
    //         sb.append(",");
    //     }
    //     if(size > 0) sb.append(data[size - 1]);
    //     sb.append("]");
    //     return sb.toString();
    // }

    @Override
    public String toString() {
        return "MyArrayBasic [MAX_SIZE=" + MAX_SIZE + ", data=" + Arrays.toString(data) + ", size=" + size + "]";
    }

    
}
