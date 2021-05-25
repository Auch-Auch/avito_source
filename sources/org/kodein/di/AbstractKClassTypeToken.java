package org.kodein.di;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0013\u0012\n\u0010&\u001a\u0006\u0012\u0002\b\u00030!¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0019\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\u000e2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R \u0010&\u001a\u0006\u0012\u0002\b\u00030!8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lorg/kodein/di/AbstractKClassTypeToken;", "T", "Lorg/kodein/di/TypeToken;", "", "simpleDispString", "()Ljava/lang/String;", "fullDispString", "", "disp", "", "checkIsReified", "(Ljava/lang/Object;)V", "getRaw", "()Lorg/kodein/di/TypeToken;", "", "isGeneric", "()Z", "isWildcard", "", "getSuper", "()Ljava/util/List;", "", "getGenericParameters", "()[Lorg/kodein/di/TypeToken;", "typeToken", "isAssignableFrom", "(Lorg/kodein/di/TypeToken;)Z", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlin/reflect/KClass;", AuthSource.SEND_ABUSE, "Lkotlin/reflect/KClass;", "getType", "()Lkotlin/reflect/KClass;", "type", "<init>", "(Lkotlin/reflect/KClass;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public abstract class AbstractKClassTypeToken<T> implements TypeToken<T> {
    @NotNull
    public final KClass<?> a;

    public AbstractKClassTypeToken(@NotNull KClass<?> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "type");
        this.a = kClass;
    }

    @Override // org.kodein.di.TypeToken
    public void checkIsReified(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "disp");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractKClassTypeToken) && !(Intrinsics.areEqual(this.a, ((AbstractKClassTypeToken) obj).a) ^ true);
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public String fullDispString() {
        return fullErasedDispString();
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public TypeToken<?>[] getGenericParameters() {
        return new TypeToken[0];
    }

    @Override // org.kodein.di.TypeToken
    @Nullable
    public TypeToken<T> getRaw() {
        return this;
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public List<TypeToken<?>> getSuper() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public final KClass<?> getType() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // org.kodein.di.TypeToken
    public boolean isAssignableFrom(@NotNull TypeToken<?> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "typeToken");
        if (!Intrinsics.areEqual(this, typeToken) && !Intrinsics.areEqual(this.a, Reflection.getOrCreateKotlinClass(Object.class))) {
            return false;
        }
        return true;
    }

    @Override // org.kodein.di.TypeToken
    public boolean isGeneric() {
        return false;
    }

    @Override // org.kodein.di.TypeToken
    public boolean isWildcard() {
        return false;
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public String simpleDispString() {
        return simpleErasedDispString();
    }
}
