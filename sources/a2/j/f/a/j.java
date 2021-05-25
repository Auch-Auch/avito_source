package a2.j.f.a;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.util.ArrayDeque;
public class j implements ObjectConstructor<T> {
    public j(ConstructorConstructor constructorConstructor) {
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public T construct() {
        return (T) new ArrayDeque();
    }
}
