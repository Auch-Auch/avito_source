package t6.w;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.ExperimentalStdlibApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.TypesJVMKt;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@ExperimentalStdlibApi
public final class a implements GenericArrayType, Type {
    public final Type a;

    public a(@NotNull Type type) {
        Intrinsics.checkNotNullParameter(type, "elementType");
        this.a = type;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof GenericArrayType) && Intrinsics.areEqual(this.a, ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    @NotNull
    public Type getGenericComponentType() {
        return this.a;
    }

    @Override // java.lang.reflect.Type
    @NotNull
    public String getTypeName() {
        return TypesJVMKt.access$typeToString(this.a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return getTypeName();
    }
}
