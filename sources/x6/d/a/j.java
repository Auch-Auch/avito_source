package x6.d.a;

import a2.b.a.a.a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.TypesKt;
public abstract class j {
    public static /* synthetic */ String c(j jVar, Type type, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return jVar.b(type, z);
    }

    @NotNull
    public abstract String a(@NotNull Class<?> cls, boolean z);

    @NotNull
    public final String b(@NotNull Type type, boolean z) {
        String str;
        boolean z2;
        Intrinsics.checkParameterIsNotNull(type, "type");
        Type javaType = TypesKt.getJavaType(type);
        if (javaType instanceof Class) {
            return a((Class) javaType, z);
        }
        if (javaType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) javaType;
            Type rawType = parameterizedType.getRawType();
            if (rawType != null) {
                TypeVariable[] typeParameters = ((Class) rawType).getTypeParameters();
                Intrinsics.checkExpressionValueIsNotNull(typeParameters, "cls.typeParameters");
                ArrayList arrayList = new ArrayList(typeParameters.length);
                int length = typeParameters.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    TypeVariable typeVariable = typeParameters[i];
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
                                z2 = false;
                                break;
                            }
                            Type type3 = bounds[i4];
                            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                            Intrinsics.checkExpressionValueIsNotNull(upperBounds, "argument.upperBounds");
                            if (ArraysKt___ArraysKt.contains(upperBounds, type3)) {
                                z2 = true;
                                break;
                            }
                            i4++;
                        }
                        if (z2) {
                            str = "*";
                            arrayList.add(str);
                            i++;
                            i2 = i3;
                        }
                    }
                    Intrinsics.checkExpressionValueIsNotNull(type2, "argument");
                    str = c(this, type2, false, 2, null);
                    arrayList.add(str);
                    i++;
                    i2 = i3;
                }
                StringBuilder sb = new StringBuilder();
                Type rawType2 = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(rawType2, "jvmType.rawType");
                sb.append(b(rawType2, true));
                sb.append("<");
                return a.t(sb, CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null), ">");
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
        } else if (javaType instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) javaType;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Intrinsics.checkExpressionValueIsNotNull(lowerBounds, "jvmType.lowerBounds");
            if (!(lowerBounds.length == 0)) {
                StringBuilder L = a.L("in ");
                Type type4 = wildcardType.getLowerBounds()[0];
                Intrinsics.checkExpressionValueIsNotNull(type4, "jvmType.lowerBounds[0]");
                L.append(c(this, type4, false, 2, null));
                return L.toString();
            }
            Type[] upperBounds2 = wildcardType.getUpperBounds();
            Intrinsics.checkExpressionValueIsNotNull(upperBounds2, "jvmType.upperBounds");
            if (!(!(upperBounds2.length == 0)) || Intrinsics.areEqual(wildcardType.getUpperBounds()[0], Object.class)) {
                return "*";
            }
            StringBuilder L2 = a.L("out ");
            Type type5 = wildcardType.getUpperBounds()[0];
            Intrinsics.checkExpressionValueIsNotNull(type5, "jvmType.upperBounds[0]");
            L2.append(c(this, type5, false, 2, null));
            return L2.toString();
        } else if (javaType instanceof GenericArrayType) {
            StringBuilder L3 = a.L("Array<");
            Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
            Intrinsics.checkExpressionValueIsNotNull(genericComponentType, "jvmType.genericComponentType");
            L3.append(c(this, genericComponentType, false, 2, null));
            L3.append(">");
            return L3.toString();
        } else if (javaType instanceof TypeVariable) {
            String name = ((TypeVariable) javaType).getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "jvmType.name");
            return name;
        } else {
            StringBuilder L4 = a.L("Unknown type ");
            L4.append(getClass());
            throw new IllegalStateException(L4.toString());
        }
    }
}
