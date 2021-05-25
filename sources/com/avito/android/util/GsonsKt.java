package com.avito.android.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a(\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\b\u001a\u00020\u0007\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\b¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0007\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\b¢\u0006\u0004\b\n\u0010\t\u001a\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u0010\u001a\u00020\u000f*\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "T", "Lcom/google/gson/Gson;", "", "json", "fromJson", "(Lcom/google/gson/Gson;Ljava/lang/String;)Ljava/lang/Object;", "Ljava/lang/reflect/Type;", "typeToken", "()Ljava/lang/reflect/Type;", "gsonTypeToken", "type", "removeTypeWildcards", "(Ljava/lang/reflect/Type;)Ljava/lang/reflect/Type;", "Ljava/lang/reflect/ParameterizedType;", "", "isWildcard", "(Ljava/lang/reflect/ParameterizedType;)Z", "gson"}, k = 2, mv = {1, 4, 2})
public final class GsonsKt {
    public static final /* synthetic */ <T> T fromJson(Gson gson, String str) {
        Type type;
        Intrinsics.checkNotNullParameter(gson, "$this$fromJson");
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.needClassReification();
        Type type2 = new TypeToken<T>() { // from class: com.avito.android.util.GsonsKt$fromJson$$inlined$typeToken$1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type2, "object : TypeToken<T>() {}.type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkNotNullExpressionValue(type, "type.rawType");
                T t = (T) gson.fromJson(str, type);
                Intrinsics.checkNotNullExpressionValue(t, "fromJson(json, typeToken<T>())");
                return t;
            }
        }
        type = removeTypeWildcards(type2);
        T t = (T) gson.fromJson(str, type);
        Intrinsics.checkNotNullExpressionValue(t, "fromJson(json, typeToken<T>())");
        return t;
    }

    public static final /* synthetic */ <T> Type gsonTypeToken() {
        Intrinsics.needClassReification();
        Type type = new TypeToken<T>() { // from class: com.avito.android.util.GsonsKt$gsonTypeToken$1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<T>() {}.type");
        return type;
    }

    public static final boolean isWildcard(@NotNull ParameterizedType parameterizedType) {
        Type type;
        Intrinsics.checkNotNullParameter(parameterizedType, "$this$isWildcard");
        Type rawType = parameterizedType.getRawType();
        Objects.requireNonNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
        TypeVariable[] typeParameters = ((Class) rawType).getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "cls.typeParameters");
        int length = typeParameters.length;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i < length) {
            TypeVariable typeVariable = typeParameters[i];
            int i3 = i2 + 1;
            Type type2 = parameterizedType.getActualTypeArguments()[i2];
            if (type2 instanceof WildcardType) {
                Intrinsics.checkNotNullExpressionValue(typeVariable, "variable");
                Type[] bounds = typeVariable.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds, "variable.bounds");
                int length2 = bounds.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        type = null;
                        break;
                    }
                    type = bounds[i4];
                    Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "argument.upperBounds");
                    if (ArraysKt___ArraysKt.contains(upperBounds, type)) {
                        break;
                    }
                    i4++;
                }
                if (type != null) {
                    if (Intrinsics.areEqual(type, Object.class)) {
                        z = true;
                    } else {
                        z3 = true;
                    }
                    i++;
                    i2 = i3;
                }
            }
            z2 = true;
            i++;
            i2 = i3;
        }
        if (!z || !z2) {
            return z || (z3 && !z2);
        }
        throw new IllegalArgumentException("Either none or all type parameters can be wildcard in " + parameterizedType);
    }

    @NotNull
    public static final Type removeTypeWildcards(@NotNull Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "type.actualTypeArguments");
        ArrayList<Type> arrayList = new ArrayList(actualTypeArguments.length);
        for (Type type2 : actualTypeArguments) {
            if (type2 instanceof WildcardType) {
                type2 = ((WildcardType) type2).getUpperBounds()[0];
            }
            arrayList.add(type2);
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (Type type3 : arrayList) {
            Intrinsics.checkNotNullExpressionValue(type3, "it");
            arrayList2.add(removeTypeWildcards(type3));
        }
        Object[] array = arrayList2.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Type[] typeArr = (Type[]) array;
        TypeToken<?> parameterized = TypeToken.getParameterized(parameterizedType.getRawType(), (Type[]) Arrays.copyOf(typeArr, typeArr.length));
        Intrinsics.checkNotNullExpressionValue(parameterized, "TypeToken.getParameteriz…type.rawType, *arguments)");
        Type type4 = parameterized.getType();
        Intrinsics.checkNotNullExpressionValue(type4, "TypeToken.getParameteriz…rawType, *arguments).type");
        return type4;
    }

    public static final /* synthetic */ <T> Type typeToken() {
        Intrinsics.needClassReification();
        Type type = new TypeToken<T>() { // from class: com.avito.android.util.GsonsKt$typeToken$$inlined$gsonTypeToken$2
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<T>() {}.type");
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (isWildcard(parameterizedType)) {
                Type rawType = parameterizedType.getRawType();
                Intrinsics.checkNotNullExpressionValue(rawType, "type.rawType");
                return rawType;
            }
        }
        return removeTypeWildcards(type);
    }
}
