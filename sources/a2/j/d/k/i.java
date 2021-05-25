package a2.j.d.k;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;
public abstract class i {
    public final Set<Type> a = Sets.newHashSet();

    public final void a(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null && this.a.add(type)) {
                try {
                    if (type instanceof TypeVariable) {
                        e((TypeVariable) type);
                    } else if (type instanceof WildcardType) {
                        f((WildcardType) type);
                    } else if (type instanceof ParameterizedType) {
                        d((ParameterizedType) type);
                    } else if (type instanceof Class) {
                        b((Class) type);
                    } else if (type instanceof GenericArrayType) {
                        c((GenericArrayType) type);
                    } else {
                        throw new AssertionError("Unknown type: " + type);
                    }
                } catch (Throwable th) {
                    this.a.remove(type);
                    throw th;
                }
            }
        }
    }

    public void b(Class<?> cls) {
    }

    public void c(GenericArrayType genericArrayType) {
    }

    public void d(ParameterizedType parameterizedType) {
    }

    public abstract void e(TypeVariable<?> typeVariable);

    public abstract void f(WildcardType wildcardType);
}
