package solutions.pack3;

public class MyArray660261 extends MyArrayBasic660261
{
    public MyArray660261()
    {
        super.MAX_SIZE = 100_000;
        super.data = new int[MAX_SIZE];
    }

    public MyArray660261(int max)
    {
        super.MAX_SIZE = max;
        super.data = new int[MAX_SIZE];
    }

    public int add(int d)
    {
        if(isFull())
            return -1;
        data[size++] = d;
        return size;
    }

    public boolean isFull()
    {
        return size == MAX_SIZE;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }

    public int[] expandByK(int k)
    {
        MAX_SIZE = k * MAX_SIZE;
        int newData[] = new int[MAX_SIZE];
        System.arraycopy(data, 0, newData, 0, size);
        super.data = newData;
        return super.data;
    }
    public int[] expand()
    {
        return expandByK(2);
    }

}
