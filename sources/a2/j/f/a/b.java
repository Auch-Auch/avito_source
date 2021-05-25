package a2.j.f.a;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.util.TreeMap;
public class b implements ObjectConstructor<T> {
    public b(ConstructorConstructor constructorConstructor) {
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public T construct() {
        return (T) new TreeMap();
    }
}
