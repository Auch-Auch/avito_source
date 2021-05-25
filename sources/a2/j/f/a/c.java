package a2.j.f.a;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.util.LinkedHashMap;
public class c implements ObjectConstructor<T> {
    public c(ConstructorConstructor constructorConstructor) {
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public T construct() {
        return (T) new LinkedHashMap();
    }
}
