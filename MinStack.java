import java.util.*;


public class MinStack
{
    private int[] stack;
    private int[] minStack;
    private int size;

    public MinStack()
    {
        stack = new int[100];
        minStack = new int[100];
        size = 0;
    }

    public void push(int val)
    {
        if(size<stack.length)
        {
            stack[size] = val;
            if(size == 0 || val <= minStack[size - 1])
            {
                minStack[size] = val;
            }
            else
            {
                minStack[size] = minStack[size-1];
            }
            size++;
        }
    }

    public void pop()
    {
        if(size>0)
        {
            size--;
        }
    }

    public int top()
    {
        if(size>0)
        {
            return stack[size-1];
        }
        throw new IllegalStateException("Stack is empty");
    }

    public int minimum()
    {
        if(size>0)
        {
            return minStack[size-1];
        }
        throw new IllegalStateException("Stack is empty");

    }
    public static void main(String[] args) {
        MinStack minstack = new MinStack();
        minstack.push(-2);
        minstack.push(0);
        minstack.push(-3);
        
        System.out.println(minstack.minimum()); // Output: -3
        minstack.pop();
        System.out.println(minstack.top());    // Output: 0
        System.out.println(minstack.minimum()); // Output: -2
    }
}
