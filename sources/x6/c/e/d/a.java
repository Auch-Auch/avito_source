package x6.c.e.d;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;
public class a {
    public final Method a;

    public a(Method method) {
        this.a = method;
    }

    public final void a(Type type, List<Throwable> list) {
        if (type instanceof TypeVariable) {
            StringBuilder L = a2.b.a.a.a.L("Method ");
            L.append(this.a.getName());
            L.append("() contains unresolved type variable ");
            L.append(type);
            list.add(new Exception(L.toString()));
            return;
        }
        int i = 0;
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i < length) {
                a(actualTypeArguments[i], list);
                i++;
            }
        } else if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            for (Type type2 : wildcardType.getUpperBounds()) {
                a(type2, list);
            }
            Type[] lowerBounds = wildcardType.getLowerBounds();
            int length2 = lowerBounds.length;
            while (i < length2) {
                a(lowerBounds[i], list);
                i++;
            }
        } else if (type instanceof GenericArrayType) {
            a(((GenericArrayType) type).getGenericComponentType(), list);
        }
    }
}
