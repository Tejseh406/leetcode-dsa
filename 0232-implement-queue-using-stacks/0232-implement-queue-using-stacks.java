import java.util.*;

class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        inStack.push(x);

        while(!outStack.isEmpty()){
            inStack.push(outStack.pop());
        }
    }

    public int pop() {
        return inStack.pop();
    }

    public int peek() {
        return inStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}