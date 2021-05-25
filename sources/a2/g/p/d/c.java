package a2.g.p.d;

import javax.annotation.Nullable;
public interface c<T> {
    @Nullable
    T get(int i);

    int getSize(T t);

    @Nullable
    T pop();

    void put(T t);
}
