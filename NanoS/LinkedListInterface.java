public interface LinkedListInterface<T> {
    void insertFirst(T value);
    void insertLast(T value);
    void insertAtPos(T value, int pos);
    void deleteFirst();
    void deleteLast();
    void deleteAtPos(int pos);
    void display();
    int count();
}
