public class code<T> {
    private Object[] arr;
    private int top;
    private int size;

    // Constructor
    public code(int size) {
        this.size = size;
        arr = new Object[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(T value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + value);
        } else {
            arr[++top] = value;
            System.out.println(value + " pushed into stack.");
        }
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Nothing to pop.");
            return null;
        } else {
            T value = (T) arr[top--];
            System.out.println(value + " popped from stack.");
            return value;
        }
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        } else {
            return (T) arr[top];
        }
    }

    // Main method to test the stack
    public static void main(String[] args) {
        code<Integer> s = new code<>(5); // stack of integers, size 5
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Top element: " + s.peek());

        s.pop();
        System.out.println("Top element after pop: " + s.peek());

        s.pop();
        s.pop();
        s.pop(); // will show underflow
    }
}
