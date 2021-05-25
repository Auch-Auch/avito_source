package a2.j.f.a;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.util.concurrent.ConcurrentHashMap;
public class a implements ObjectConstructor<T> {
    public a(ConstructorConstructor constructorConstructor) {
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public T construct() {
        return (T) new ConcurrentHashMap();
    }
}
