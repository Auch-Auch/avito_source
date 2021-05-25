package a2.j.f.a;

import a2.b.a.a.a;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.UnsafeAllocator;
import java.lang.reflect.Type;
public class e implements ObjectConstructor<T> {
    public final UnsafeAllocator a = UnsafeAllocator.create();
    public final /* synthetic */ Class b;
    public final /* synthetic */ Type c;

    public e(ConstructorConstructor constructorConstructor, Class cls, Type type) {
        this.b = cls;
        this.c = type;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public T construct() {
        try {
            return (T) this.a.newInstance(this.b);
        } catch (Exception e) {
            StringBuilder L = a.L("Unable to invoke no-args constructor for ");
            L.append(this.c);
            L.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
            throw new RuntimeException(L.toString(), e);
        }
    }
}
