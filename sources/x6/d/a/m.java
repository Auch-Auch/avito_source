package x6.d.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public abstract class m<T> {
    @NotNull
    public final Type getType() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            Intrinsics.checkExpressionValueIsNotNull(type, "(javaClass.genericSuperc…e).actualTypeArguments[0]");
            return type;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
    }
}
