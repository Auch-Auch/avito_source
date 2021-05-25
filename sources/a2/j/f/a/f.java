package a2.j.f.a;

import a2.b.a.a.a;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
public class f implements ObjectConstructor<T> {
    public final /* synthetic */ Constructor a;

    public f(ConstructorConstructor constructorConstructor, Constructor constructor) {
        this.a = constructor;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public T construct() {
        try {
            return (T) this.a.newInstance(null);
        } catch (InstantiationException e) {
            StringBuilder L = a.L("Failed to invoke ");
            L.append(this.a);
            L.append(" with no args");
            throw new RuntimeException(L.toString(), e);
        } catch (InvocationTargetException e2) {
            StringBuilder L2 = a.L("Failed to invoke ");
            L2.append(this.a);
            L2.append(" with no args");
            throw new RuntimeException(L2.toString(), e2.getTargetException());
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        }
    }
}
