package org.kodein.di;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010 \u001a\u00020\u0019¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u0019\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\u0012*\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010 \u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010!8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001dR\u001c\u0010'\u001a\u00020\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b&\u0010\u001f¨\u0006*"}, d2 = {"Lorg/kodein/di/ParameterizedTypeToken;", "T", "Lorg/kodein/di/JVMTypeToken;", "", "simpleErasedDispString", "()Ljava/lang/String;", "fullErasedDispString", "", "Lorg/kodein/di/TypeToken;", "getGenericParameters", "()[Lorg/kodein/di/TypeToken;", "getRaw", "()Lorg/kodein/di/TypeToken;", "", "isGeneric", "()Z", "", "disp", "", "checkIsReified", "(Ljava/lang/Object;)V", "isWildcard", "", "getSuper", "()Ljava/util/List;", "Ljava/lang/reflect/Type;", AuthSource.SEND_ABUSE, "(Ljava/lang/reflect/Type;Ljava/lang/Object;)V", "c", "Ljava/lang/reflect/Type;", "getTrueType", "()Ljava/lang/reflect/Type;", "trueType", "Ljava/lang/Class;", AuthSource.BOOKING_ORDER, "()Ljava/lang/Class;", "rawType", "_type", "getJvmType", "jvmType", "<init>", "(Ljava/lang/reflect/Type;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class ParameterizedTypeToken<T> extends JVMTypeToken<T> {
    public Type a;
    @NotNull
    public final Type b;
    @NotNull
    public final Type c;

    public ParameterizedTypeToken(@NotNull Type type) {
        KodeinWrappedType kodeinWrappedType;
        Intrinsics.checkParameterIsNotNull(type, "trueType");
        this.c = type;
        Type type2 = this.a;
        if (type2 == null) {
            if ((TypesKt.access$get_needPTWrapper$p() || TypesKt.access$get_needGATWrapper$p()) && !(type instanceof Class)) {
                if (!TypesKt.access$get_needPTWrapper$p() || !(type instanceof ParameterizedType)) {
                    kodeinWrappedType = (TypesKt.access$get_needGATWrapper$p() && (type instanceof GenericArrayType)) ? new KodeinWrappedType(type) : kodeinWrappedType;
                } else {
                    new KodeinWrappedType(type);
                }
                type = kodeinWrappedType;
            }
            this.a = type;
            type2 = type;
        }
        this.b = type2;
    }

    public final void a(@NotNull Type type, Object obj) {
        Type javaType = TypesKt.getJavaType(type);
        if (!(javaType instanceof Class)) {
            int i = 0;
            if (javaType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) javaType).getActualTypeArguments();
                int length = actualTypeArguments.length;
                while (i < length) {
                    Type type2 = actualTypeArguments[i];
                    Intrinsics.checkExpressionValueIsNotNull(type2, "arg");
                    a(type2, obj);
                    i++;
                }
            } else if (javaType instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                Intrinsics.checkExpressionValueIsNotNull(genericComponentType, "jvmType.genericComponentType");
                a(genericComponentType, obj);
            } else if (javaType instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) javaType;
                Type[] lowerBounds = wildcardType.getLowerBounds();
                for (Type type3 : lowerBounds) {
                    Intrinsics.checkExpressionValueIsNotNull(type3, "arg");
                    a(type3, obj);
                }
                Type[] upperBounds = wildcardType.getUpperBounds();
                int length2 = upperBounds.length;
                while (i < length2) {
                    Type type4 = upperBounds[i];
                    Intrinsics.checkExpressionValueIsNotNull(type4, "arg");
                    a(type4, obj);
                    i++;
                }
            } else if (javaType instanceof TypeVariable) {
                throw new IllegalArgumentException(obj + " uses a type variable named " + ((TypeVariable) javaType).getName() + ", therefore, the bound value can never be retrieved.");
            } else {
                StringBuilder L = a.L("Unknown type ");
                L.append(javaType.getClass());
                L.append(' ');
                L.append(javaType);
                throw new IllegalArgumentException(L.toString());
            }
        }
    }

    public final Class<?> b() {
        Type type = this.c;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (!(type instanceof ParameterizedType)) {
            return null;
        }
        Type rawType = ((ParameterizedType) type).getRawType();
        if (rawType != null) {
            return (Class) rawType;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
    }

    @Override // org.kodein.di.TypeToken
    public void checkIsReified(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "disp");
        a(getJvmType(), obj);
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public String fullErasedDispString() {
        return TypeDispKt.fullErasedName(this.c);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.ArrayList */
    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.kodein.di.TypeToken
    @NotNull
    public TypeToken<?>[] getGenericParameters() {
        TypeVariable<Class<?>>[] typeParameters;
        TypeToken<?> typeToken;
        Type type = this.a;
        if (!(type instanceof ParameterizedType)) {
            type = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType != null) {
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Intrinsics.checkExpressionValueIsNotNull(actualTypeArguments, "type.actualTypeArguments");
            ArrayList arrayList = new ArrayList(actualTypeArguments.length);
            for (Type type2 : actualTypeArguments) {
                if (type2 instanceof WildcardType) {
                    Type type3 = ((WildcardType) type2).getUpperBounds()[0];
                    Intrinsics.checkExpressionValueIsNotNull(type3, "it.upperBounds[0]");
                    typeToken = TypesKt.TT(type3);
                } else {
                    Intrinsics.checkExpressionValueIsNotNull(type2, "it");
                    typeToken = TypesKt.TT(type2);
                }
                arrayList.add(typeToken);
            }
            Object[] array = arrayList.toArray(new TypeToken[0]);
            if (array != null) {
                return (TypeToken[]) array;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Class<?> b2 = b();
        if (b2 == null || (typeParameters = b2.getTypeParameters()) == null) {
            return new TypeToken[0];
        }
        ArrayList arrayList2 = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            Intrinsics.checkExpressionValueIsNotNull(typeVariable, "it");
            Type type4 = typeVariable.getBounds()[0];
            Intrinsics.checkExpressionValueIsNotNull(type4, "it.bounds[0]");
            arrayList2.add(TypesKt.TT(type4));
        }
        Object[] array2 = arrayList2.toArray(new TypeToken[0]);
        if (array2 != null) {
            return (TypeToken[]) array2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // org.kodein.di.JVMTypeToken
    @NotNull
    public Type getJvmType() {
        return this.b;
    }

    @Override // org.kodein.di.TypeToken
    @Nullable
    public TypeToken<T> getRaw() {
        Class<?> b2 = b();
        if (b2 != null) {
            return new ClassTypeToken(b2);
        }
        return null;
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public List<TypeToken<?>> getSuper() {
        TypeToken typeToken;
        Collection collection;
        List list;
        Type[] genericInterfaces;
        Type jvmType = getJvmType();
        if (jvmType instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) jvmType).getRawType();
            if (rawType != null) {
                typeToken = TypesKt.access$_getClassSuperTT((Class) rawType);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
            }
        } else {
            typeToken = null;
        }
        Class<?> b2 = b();
        if (b2 == null || (genericInterfaces = b2.getGenericInterfaces()) == null) {
            collection = CollectionsKt__CollectionsKt.emptyList();
        } else {
            collection = new ArrayList(genericInterfaces.length);
            for (Type type : genericInterfaces) {
                Intrinsics.checkExpressionValueIsNotNull(type, "it");
                collection.add(TypesKt.TT(type));
            }
        }
        if (typeToken == null || (list = d.listOf(typeToken)) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) collection);
    }

    @NotNull
    public final Type getTrueType() {
        return this.c;
    }

    @Override // org.kodein.di.TypeToken
    public boolean isGeneric() {
        return true;
    }

    @Override // org.kodein.di.TypeToken
    public boolean isWildcard() {
        boolean z;
        Type type = this.c;
        if (!(type instanceof ParameterizedType)) {
            type = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType == null) {
            return false;
        }
        Type rawType = parameterizedType.getRawType();
        if (rawType != null) {
            TypeVariable<Class<T>>[] typeParameters = ((Class) rawType).getTypeParameters();
            Intrinsics.checkExpressionValueIsNotNull(typeParameters, "cls.typeParameters");
            int length = typeParameters.length;
            int i = 0;
            boolean z2 = false;
            int i2 = 0;
            boolean z3 = false;
            while (i < length) {
                TypeVariable<Class<T>> typeVariable = typeParameters[i];
                int i3 = i2 + 1;
                Type type2 = parameterizedType.getActualTypeArguments()[i2];
                if (type2 instanceof WildcardType) {
                    Intrinsics.checkExpressionValueIsNotNull(typeVariable, "variable");
                    Type[] bounds = typeVariable.getBounds();
                    Intrinsics.checkExpressionValueIsNotNull(bounds, "variable.bounds");
                    int length2 = bounds.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            z = false;
                            break;
                        }
                        Type type3 = bounds[i4];
                        Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                        Intrinsics.checkExpressionValueIsNotNull(upperBounds, "argument.upperBounds");
                        if (ArraysKt___ArraysKt.contains(upperBounds, type3)) {
                            z = true;
                            break;
                        }
                        i4++;
                    }
                    if (z) {
                        z2 = true;
                        i++;
                        i2 = i3;
                    }
                }
                z3 = true;
                i++;
                i2 = i3;
            }
            if (!z2 || z3) {
                return false;
            }
            return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public String simpleErasedDispString() {
        return TypeDispKt.simpleErasedName(this.c);
    }
}
