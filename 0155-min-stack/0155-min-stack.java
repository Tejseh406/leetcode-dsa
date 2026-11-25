import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    private Deque<Long> st;
    private long min;

    public MinStack() {
        st = new ArrayDeque<>();
    }

    public void push(int value) {
        long val = value;
        if (st.isEmpty()) {
            min = val;
            st.push(val);
        } else if (val < min) {
            st.push(2 * val - min);
            min = val;
        } else {
            st.push(val);
        }
    }

    public void pop() {
        if (st.isEmpty()) return;
        long top = st.pop();
        if (top < min) {
            min = 2 * min - top;
        }
    }

    public int top() {
        long top = st.peek();
        if (top < min) {
            return (int) min;
        }
        return (int) top;
    }

    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */