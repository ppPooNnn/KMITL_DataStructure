package solutions.pack5_Postfix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyQueueExtendsLinkedList<T> extends LinkedList<T> {

    public void enqueue(T d)
    {
        this.add(d);
    }

    public T dequeue()
    {
        return this.poll();
    }

    public T top()
    {
        return this.peek();
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T item : this) {
            if (item instanceof Number || isOperator(item) || isDigit(item)) {
                sb.append(item.toString()).append(" ");
            }
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }

    private boolean isOperator(T item) {
        if (item instanceof Character) {
            char ch = (Character) item;
            return ch == '+' || ch == '-' || ch == '*' || ch == '/';
        } else if (item instanceof String) {
            String str = (String) item;
            return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
        }
        return false;
    }

    private boolean isDigit(T item) {
        if (item instanceof Character) {
            char ch = (Character) item;
            return Character.isDigit(ch);
        } else if (item instanceof String) {
            String str = (String) item;
            return str.chars().allMatch(Character::isDigit);
        }
        return false;
    }

    public class Type1<T> 
    {
        private ArrayList<T> items = new ArrayList<>();
        private int count;

        public void add(T item)
        {
            items.add(item);
            count++;
        }

        public T get(int index)
        {
            return items.get(index);
        }
    }

    public class Type2 <T> implements Iterable<T> 
    {
        private ArrayList<T> items = new ArrayList<>();
        private int count;
        public void add(T item) 
        {
            items.add(item);
            count++;
        }
        public T get(int index) 
        {
            return items.get(index);
        }
        @Override
        public Iterator<T> iterator() 
        {
            return new AnyItemsIterator(this);
        }
        private class AnyItemsIterator implements Iterator <T> 
        {
            private Type2<T> lis;
            private int idx;

            public AnyItemsIterator(Type2<T> arg) 
            {
                this.lis = arg;
            }
            @Override
            public boolean hasNext() 
            {
                return (idx < lis.count);
            }

            @Override
            public T next()
            {
                return lis.items.get(idx++);
            }
        }
    }
}