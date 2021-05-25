package org.kodein.di;

import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\r2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lorg/kodein/di/ClassTypeToken;", "T", "Lorg/kodein/di/JVMTypeToken;", "", "simpleErasedDispString", "()Ljava/lang/String;", "fullErasedDispString", "getRaw", "()Lorg/kodein/di/ClassTypeToken;", "", "Lorg/kodein/di/TypeToken;", "getGenericParameters", "()[Lorg/kodein/di/TypeToken;", "", "isGeneric", "()Z", "isWildcard", "", "disp", "", "checkIsReified", "(Ljava/lang/Object;)V", "", "getSuper", "()Ljava/util/List;", "typeToken", "isAssignableFrom", "(Lorg/kodein/di/TypeToken;)Z", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/lang/Class;", "getJvmType", "()Ljava/lang/Class;", "jvmType", "<init>", "(Ljava/lang/Class;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
@PublishedApi
public final class ClassTypeToken<T> extends JVMTypeToken<T> {
    @NotNull
    public final Class<T> a;

    public ClassTypeToken(@NotNull Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "jvmType");
        this.a = cls;
    }

    @Override // org.kodein.di.TypeToken
    public void checkIsReified(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "disp");
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public String fullErasedDispString() {
        return TypeDispKt.fullErasedName(getJvmType());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.kodein.di.TypeToken
    @NotNull
    public TypeToken<?>[] getGenericParameters() {
        TypeVariable<Class<T>>[] typeParameters = getJvmType().getTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(typeParameters, "jvmType.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<T>> typeVariable : typeParameters) {
            Intrinsics.checkExpressionValueIsNotNull(typeVariable, "it");
            Type type = typeVariable.getBounds()[0];
            Intrinsics.checkExpressionValueIsNotNull(type, "it.bounds[0]");
            arrayList.add(TypesKt.TT(type));
        }
        Object[] array = arrayList.toArray(new TypeToken[0]);
        if (array != null) {
            return (TypeToken[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // org.kodein.di.JVMTypeToken
    @NotNull
    public Class<T> getJvmType() {
        return this.a;
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public ClassTypeToken<T> getRaw() {
        return this;
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public List<TypeToken<?>> getSuper() {
        List list;
        TypeToken access$_getClassSuperTT = TypesKt.access$_getClassSuperTT(getJvmType());
        if (access$_getClassSuperTT == null || (list = d.listOf(access$_getClassSuperTT)) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Type[] genericInterfaces = getJvmType().getGenericInterfaces();
        Intrinsics.checkExpressionValueIsNotNull(genericInterfaces, "jvmType.genericInterfaces");
        ArrayList arrayList = new ArrayList(genericInterfaces.length);
        for (Type type : genericInterfaces) {
            Intrinsics.checkExpressionValueIsNotNull(type, "it");
            arrayList.add(TypesKt.TT(type));
        }
        return CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) arrayList);
    }

    @Override // org.kodein.di.JVMTypeToken, org.kodein.di.TypeToken
    public boolean isAssignableFrom(@NotNull TypeToken<?> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "typeToken");
        if (typeToken instanceof ClassTypeToken) {
            return getJvmType().isAssignableFrom(((ClassTypeToken) typeToken).getJvmType());
        }
        return super.isAssignableFrom(typeToken);
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
    public String simpleErasedDispString() {
        return TypeDispKt.simpleErasedName(getJvmType());
    }
}
