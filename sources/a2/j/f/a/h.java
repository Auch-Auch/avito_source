package a2.j.f.a;

import a2.b.a.a.a;
import com.google.gson.JsonIOException;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;
public class h implements ObjectConstructor<T> {
    public final /* synthetic */ Type a;

    public h(ConstructorConstructor constructorConstructor, Type type) {
        this.a = type;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public T construct() {
        Type type = this.a;
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            StringBuilder L = a.L("Invalid EnumSet type: ");
            L.append(this.a.toString());
            throw new JsonIOException(L.toString());
        }
        StringBuilder L2 = a.L("Invalid EnumSet type: ");
        L2.append(this.a.toString());
        throw new JsonIOException(L2.toString());
    }
}
