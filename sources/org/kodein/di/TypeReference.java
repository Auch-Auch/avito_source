package org.kodein.di;

import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lorg/kodein/di/TypeReference;", "T", "", "Ljava/lang/reflect/Type;", AuthSource.SEND_ABUSE, "Ljava/lang/reflect/Type;", "getSuperType", "()Ljava/lang/reflect/Type;", "superType", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public abstract class TypeReference<T> {
    @NotNull
    public final Type a;

    public TypeReference() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) (!(genericSuperclass instanceof ParameterizedType) ? null : genericSuperclass);
        if (parameterizedType != null) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            Intrinsics.checkExpressionValueIsNotNull(type, "(javaClass.genericSuperc…)).actualTypeArguments[0]");
            this.a = type;
            return;
        }
        throw new RuntimeException("Invalid TypeToken; must specify type parameters");
    }

    @NotNull
    public final Type getSuperType() {
        return this.a;
    }
}
