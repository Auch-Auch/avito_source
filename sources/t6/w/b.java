package t6.w;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.ExperimentalStdlibApi;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.TypesJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@ExperimentalStdlibApi
public final class b implements ParameterizedType, Type {
    public final Type[] a;
    public final Class<?> b;
    public final Type c;

    public b(@NotNull Class<?> cls, @Nullable Type type, @NotNull List<? extends Type> list) {
        Intrinsics.checkNotNullParameter(cls, "rawType");
        Intrinsics.checkNotNullParameter(list, "typeArguments");
        this.b = cls;
        this.c = type;
        Object[] array = list.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.a = (Type[]) array;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (Intrinsics.areEqual(this.b, parameterizedType.getRawType()) && Intrinsics.areEqual(this.c, parameterizedType.getOwnerType()) && Arrays.equals(this.a, parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type[] getActualTypeArguments() {
        return this.a;
    }

    @Override // java.lang.reflect.ParameterizedType
    @Nullable
    public Type getOwnerType() {
        return this.c;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type getRawType() {
        return this.b;
    }

    @Override // java.lang.reflect.Type
    @NotNull
    public String getTypeName() {
        StringBuilder sb = new StringBuilder();
        Type type = this.c;
        if (type != null) {
            sb.append(TypesJVMKt.access$typeToString(type));
            sb.append("$");
            sb.append(this.b.getSimpleName());
        } else {
            sb.append(TypesJVMKt.access$typeToString(this.b));
        }
        Type[] typeArr = this.a;
        if (!(typeArr.length == 0)) {
            ArraysKt___ArraysKt.joinTo$default(typeArr, sb, (CharSequence) null, "<", ">", 0, (CharSequence) null, a.a, 50, (Object) null);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = this.b.hashCode();
        Type type = this.c;
        return (hashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(this.a);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return getTypeName();
    }
}
