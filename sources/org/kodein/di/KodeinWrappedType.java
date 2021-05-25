package org.kodein.di;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lorg/kodein/di/KodeinWrappedType;", "Ljava/lang/reflect/Type;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "toString", "()Ljava/lang/String;", AuthSource.BOOKING_ORDER, "Ljava/lang/reflect/Type;", "getType", "()Ljava/lang/reflect/Type;", "type", AuthSource.SEND_ABUSE, "I", "_hashCode", "<init>", "(Ljava/lang/reflect/Type;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class KodeinWrappedType implements Type {
    public int a;
    @NotNull
    public final Type b;

    public static final class a {
        public static final boolean a(@NotNull Type type, @NotNull Type type2) {
            Intrinsics.checkParameterIsNotNull(type, "l");
            Intrinsics.checkParameterIsNotNull(type2, "r");
            Type javaType = TypesKt.getJavaType(type);
            Type javaType2 = TypesKt.getJavaType(type2);
            if (!Intrinsics.areEqual(javaType.getClass(), javaType2.getClass())) {
                return false;
            }
            if (javaType instanceof Class) {
                return Intrinsics.areEqual(javaType, javaType2);
            }
            if (javaType instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) javaType2;
                ParameterizedType parameterizedType2 = (ParameterizedType) javaType;
                Type rawType = parameterizedType2.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(rawType, "left.rawType");
                Type rawType2 = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(rawType2, "right.rawType");
                if (a(rawType, rawType2)) {
                    Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                    Intrinsics.checkExpressionValueIsNotNull(actualTypeArguments, "left.actualTypeArguments");
                    Type[] actualTypeArguments2 = parameterizedType.getActualTypeArguments();
                    Intrinsics.checkExpressionValueIsNotNull(actualTypeArguments2, "right.actualTypeArguments");
                    if (b(actualTypeArguments, actualTypeArguments2)) {
                        return true;
                    }
                }
            } else if (javaType instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) javaType2;
                WildcardType wildcardType2 = (WildcardType) javaType;
                Type[] lowerBounds = wildcardType2.getLowerBounds();
                Intrinsics.checkExpressionValueIsNotNull(lowerBounds, "left.lowerBounds");
                Type[] lowerBounds2 = wildcardType.getLowerBounds();
                Intrinsics.checkExpressionValueIsNotNull(lowerBounds2, "right.lowerBounds");
                if (b(lowerBounds, lowerBounds2)) {
                    Type[] upperBounds = wildcardType2.getUpperBounds();
                    Intrinsics.checkExpressionValueIsNotNull(upperBounds, "left.upperBounds");
                    Type[] upperBounds2 = wildcardType.getUpperBounds();
                    Intrinsics.checkExpressionValueIsNotNull(upperBounds2, "right.upperBounds");
                    if (b(upperBounds, upperBounds2)) {
                        return true;
                    }
                }
            } else if (javaType instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                Intrinsics.checkExpressionValueIsNotNull(genericComponentType, "left.genericComponentType");
                Type genericComponentType2 = ((GenericArrayType) javaType2).getGenericComponentType();
                Intrinsics.checkExpressionValueIsNotNull(genericComponentType2, "right.genericComponentType");
                return a(genericComponentType, genericComponentType2);
            } else if (!(javaType instanceof TypeVariable)) {
                return Intrinsics.areEqual(javaType, javaType2);
            } else {
                Type[] bounds = ((TypeVariable) javaType).getBounds();
                Intrinsics.checkExpressionValueIsNotNull(bounds, "left.bounds");
                Type[] bounds2 = ((TypeVariable) javaType2).getBounds();
                Intrinsics.checkExpressionValueIsNotNull(bounds2, "right.bounds");
                return b(bounds, bounds2);
            }
            return false;
        }

        public static final boolean b(@NotNull Type[] typeArr, @NotNull Type[] typeArr2) {
            Intrinsics.checkParameterIsNotNull(typeArr, ViewHierarchyConstants.DIMENSION_LEFT_KEY);
            Intrinsics.checkParameterIsNotNull(typeArr2, "right");
            if (typeArr.length != typeArr2.length) {
                return false;
            }
            IntRange indices = ArraysKt___ArraysKt.getIndices(typeArr);
            if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                Iterator it = indices.iterator();
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    if (!a(typeArr[nextInt], typeArr2[nextInt])) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static final int c(@NotNull Type type) {
            Intrinsics.checkParameterIsNotNull(type, "type");
            if (type instanceof Class) {
                return type.hashCode();
            }
            int i = 0;
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type rawType = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(rawType, "type.rawType");
                int c = c(rawType);
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments.length;
                while (i < length) {
                    Type type2 = actualTypeArguments[i];
                    Intrinsics.checkExpressionValueIsNotNull(type2, "arg");
                    c = (c * 31) + c(type2);
                    i++;
                }
                return c;
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                int i2 = 0;
                for (Type type3 : upperBounds) {
                    Intrinsics.checkExpressionValueIsNotNull(type3, "arg");
                    i2 = (i2 * 19) + c(type3);
                }
                Type[] lowerBounds = wildcardType.getLowerBounds();
                int length2 = lowerBounds.length;
                while (i < length2) {
                    Type type4 = lowerBounds[i];
                    Intrinsics.checkExpressionValueIsNotNull(type4, "arg");
                    i2 = (i2 * 17) + c(type4);
                    i++;
                }
                return i2;
            } else if (type instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
                Intrinsics.checkExpressionValueIsNotNull(genericComponentType, "type.genericComponentType");
                return c(genericComponentType) + 53;
            } else if (!(type instanceof TypeVariable)) {
                return type.hashCode();
            } else {
                Type[] bounds = ((TypeVariable) type).getBounds();
                for (Type type5 : bounds) {
                    int i3 = i * 29;
                    Intrinsics.checkExpressionValueIsNotNull(type5, "arg");
                    i = i3 + c(type5);
                }
                return i;
            }
        }
    }

    public KodeinWrappedType(@NotNull Type type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.b = type;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof Type) || hashCode() != obj.hashCode()) {
            return false;
        }
        return a.a(this.b, (Type) obj);
    }

    @NotNull
    public final Type getType() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.a == 0) {
            this.a = a.c(this.b);
        }
        return this.a;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("KodeinWrappedType{");
        L.append(this.b);
        L.append('}');
        return L.toString();
    }
}
