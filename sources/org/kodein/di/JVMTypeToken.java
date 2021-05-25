package org.kodein.di;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.TypeToken;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lorg/kodein/di/JVMTypeToken;", "T", "Lorg/kodein/di/TypeToken;", "", "simpleDispString", "()Ljava/lang/String;", "fullDispString", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/reflect/Type;", "getJvmType", "()Ljava/lang/reflect/Type;", "jvmType", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public abstract class JVMTypeToken<T> implements TypeToken<T> {
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof JVMTypeToken) && !(Intrinsics.areEqual(getJvmType(), ((JVMTypeToken) obj).getJvmType()) ^ true);
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public String fullDispString() {
        return TypeDispKt.fullDispString(getJvmType());
    }

    @NotNull
    public abstract Type getJvmType();

    public int hashCode() {
        return getJvmType().hashCode();
    }

    @Override // org.kodein.di.TypeToken
    public boolean isAssignableFrom(@NotNull TypeToken<?> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "typeToken");
        return TypeToken.DefaultImpls.isAssignableFrom(this, typeToken);
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public String simpleDispString() {
        return TypeDispKt.simpleDispString(getJvmType());
    }
}
