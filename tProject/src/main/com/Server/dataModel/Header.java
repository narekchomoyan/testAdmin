package main.com.Server.dataModel;

/**
 * Created by narek on 4/19/17.
 */
public class Header<K,T> {
    private K first;
    private T second;

    public Header(K first, T second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
