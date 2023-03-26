class MyCircularDeque {
    private int capacity;
    private int[] elements;
    private int front , rear = 0;
    public MyCircularDeque(int k) {
        capacity = k + 1 ;
        elements = new int[k + 1];
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        elements[front] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;  
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = (front + 1) % capacity;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = (rear - 1 +capacity) %capacity;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return elements[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return elements[(rear - 1 + capacity) % capacity];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        return front == (rear + 1) % capacity;
    }
}