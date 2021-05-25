package org.kodein.di;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\u001a\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001H\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\u0007\u0010\u000b\u001a\u0019\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\u000e\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0007\u0010\u0011\u001a'\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\t2\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014\"\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u001d\u0010\u001d\u001a\u00020\u00158B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019\"\u001b\u0010 \u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u00018F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0017\u0010#\u001a\u00020\f*\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"T", "Lorg/kodein/di/TypeToken;", MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE, "()Lorg/kodein/di/TypeToken;", "erased", "Ljava/lang/Class;", "cls", "TT", "(Ljava/lang/Class;)Lorg/kodein/di/TypeToken;", "", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lorg/kodein/di/TypeToken;", "Ljava/lang/reflect/Type;", "type", "(Ljava/lang/reflect/Type;)Lorg/kodein/di/TypeToken;", "Lorg/kodein/di/TypeReference;", "ref", "(Lorg/kodein/di/TypeReference;)Lorg/kodein/di/TypeToken;", "obj", "TTOf", "(Ljava/lang/Object;)Lorg/kodein/di/TypeToken;", "", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "get_needPTWrapper", "()Z", "_needPTWrapper", "c", "get_needGATWrapper", "_needGATWrapper", "getJvmType", "(Lorg/kodein/di/TypeToken;)Ljava/lang/reflect/Type;", "jvmType", "getJavaType", "(Ljava/lang/reflect/Type;)Ljava/lang/reflect/Type;", "javaType", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class TypesKt {
    public static final /* synthetic */ KProperty[] a = {Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(TypesKt.class, "kodein-di-core"), "_needPTWrapper", "get_needPTWrapper()Z")), Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(TypesKt.class, "kodein-di-core"), "_needGATWrapper", "get_needGATWrapper()Z"))};
    public static final Lazy b = c.lazy(a.c);
    public static final Lazy c = c.lazy(a.b);

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Boolean> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(0);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            int i = this.a;
            if (i == 0) {
                Type type = new TypesKt$_needGATWrapper$2$t1$1().getType();
                if (type != null) {
                    GenericArrayType genericArrayType = (GenericArrayType) type;
                    Type type2 = new TypesKt$_needGATWrapper$2$t2$1().getType();
                    if (type2 != null) {
                        return Boolean.valueOf(!Intrinsics.areEqual(genericArrayType, (GenericArrayType) type2));
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.reflect.GenericArrayType");
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.reflect.GenericArrayType");
            } else if (i == 1) {
                Type type3 = new TypesKt$_needPTWrapper$2$t1$1().getType();
                if (type3 != null) {
                    ParameterizedType parameterizedType = (ParameterizedType) type3;
                    Type type4 = new TypesKt$_needPTWrapper$2$t2$1().getType();
                    if (type4 != null) {
                        return Boolean.valueOf(!Intrinsics.areEqual(parameterizedType, (ParameterizedType) type4));
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
            } else {
                throw null;
            }
        }
    }

    @NotNull
    public static final <T> TypeToken<T> TT(@NotNull Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "cls");
        return new ClassTypeToken(cls);
    }

    @NotNull
    public static final <T> TypeToken<? extends T> TTOf(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "obj");
        return new ClassTypeToken(t.getClass());
    }

    public static final TypeToken access$_getClassSuperTT(Class cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        TypeToken<?> TT = TT(genericSuperclass);
        if (TT != null) {
            return TT;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in T>");
    }

    public static final boolean access$get_needGATWrapper$p() {
        Lazy lazy = c;
        KProperty kProperty = a[1];
        return ((Boolean) lazy.getValue()).booleanValue();
    }

    public static final boolean access$get_needPTWrapper$p() {
        Lazy lazy = b;
        KProperty kProperty = a[0];
        return ((Boolean) lazy.getValue()).booleanValue();
    }

    @NotNull
    public static final Type getJavaType(@NotNull Type type) {
        Type type2;
        Intrinsics.checkParameterIsNotNull(type, "$this$javaType");
        KodeinWrappedType kodeinWrappedType = (KodeinWrappedType) (!(type instanceof KodeinWrappedType) ? null : type);
        return (kodeinWrappedType == null || (type2 = kodeinWrappedType.getType()) == null) ? type : type2;
    }

    @NotNull
    public static final Type getJvmType(@NotNull TypeToken<?> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "$this$jvmType");
        if (typeToken instanceof JVMTypeToken) {
            return getJavaType(((JVMTypeToken) typeToken).getJvmType());
        }
        if (typeToken instanceof CompositeTypeToken) {
            return getJvmType(((CompositeTypeToken) typeToken).getMain());
        }
        throw new IllegalStateException(typeToken.getClass().getSimpleName() + " is not a JVM Type Token");
    }

    @NotNull
    public static final <T> TypeToken<T> TT(@NotNull KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "cls");
        return TT(JvmClassMappingKt.getJavaClass((KClass) kClass));
    }

    @NotNull
    public static final TypeToken<?> TT(@NotNull Type type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        if (type instanceof Class) {
            return new ClassTypeToken((Class) type);
        }
        return new ParameterizedTypeToken(type);
    }

    @NotNull
    public static final <T> TypeToken<T> TT(@NotNull TypeReference<T> typeReference) {
        Intrinsics.checkParameterIsNotNull(typeReference, "ref");
        TypeToken<T> typeToken = (TypeToken<T>) TT(typeReference.getSuperType());
        if (typeToken != null) {
            return typeToken;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<T>");
    }
}
