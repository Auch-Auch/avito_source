package org.kodein.di;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
import x6.d.a.f;
import x6.d.a.h;
import x6.d.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0000*\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0000*\u00020\u0003¢\u0006\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/lang/reflect/Type;", "simpleDispString", "(Ljava/lang/reflect/Type;)Ljava/lang/String;", "fullDispString", "simpleErasedName", "fullErasedName", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class TypeDispKt {
    public static final String a(@NotNull String str) {
        if (!m.startsWith$default(str, "java.", false, 2, null)) {
            return str;
        }
        switch (str.hashCode()) {
            case -2050985813:
                return str.equals("java.lang.RuntimeException") ? "kotlin.RuntimeException" : str;
            case -1624170886:
                return str.equals("java.lang.AssertionError") ? "kotlin.AssertionError" : str;
            case -1427677637:
                return str.equals("java.util.NoSuchElementException") ? "kotlin.NoSuchElementException" : str;
            case -1402722386:
                return str.equals("java.util.HashMap") ? "kotlin.collections.HashMap" : str;
            case -1402716492:
                return str.equals("java.util.HashSet") ? "kotlin.collections.HashSet" : str;
            case -1383349348:
                return str.equals("java.util.Map") ? "kotlin.collections.Map" : str;
            case -1383343454:
                return str.equals("java.util.Set") ? "kotlin.collections.Set" : str;
            case -1282923287:
                return str.equals("java.lang.UnsupportedOperationException") ? "kotlin.UnsupportedOperationException" : str;
            case -1114099497:
                return str.equals("java.util.ArrayList") ? "kotlin.collections.ArrayList" : str;
            case -528621260:
                return str.equals("java.lang.Error") ? "kotlin.Error" : str;
            case -310638960:
                return str.equals("java.lang.IllegalArgumentException") ? "kotlin.IllegalArgumentException" : str;
            case -37663348:
                return str.equals("java.lang.ClassCastException") ? "kotlin.ClassCastException" : str;
            case 65821278:
                return str.equals("java.util.List") ? "kotlin.collections.List" : str;
            case 72706427:
                return str.equals("java.lang.Exception") ? "kotlin.Exception" : str;
            case 75599616:
                return str.equals("java.lang.IllegalStateException") ? "kotlin.IllegalStateException" : str;
            case 208316054:
                return str.equals("java.util.Comparator") ? "kotlin.Comparator" : str;
            case 1063877011:
                return str.equals("java.lang.Object") ? "kotlin.Any" : str;
            case 1195259493:
                return str.equals("java.lang.String") ? "kotlin.String" : str;
            case 1258621781:
                return str.equals("java.util.LinkedHashMap") ? "kotlin.collections.LinkedHashMap" : str;
            case 1258627675:
                return str.equals("java.util.LinkedHashSet") ? "kotlin.collections.LinkedHashSet" : str;
            case 1270017459:
                return str.equals("java.lang.IndexOutOfBoundsException") ? "kotlin.IndexOutOfBoundsException" : str;
            case 1630335596:
                return str.equals("java.lang.Throwable") ? "kotlin.Throwable" : str;
            case 1641150139:
                return str.equals("java.lang.NumberFormatException") ? "kotlin.NumberFormatException" : str;
            case 1879291277:
                return str.equals("java.lang.NullPointerException") ? "kotlin.NullPointerException" : str;
            default:
                return str;
        }
    }

    public static final String access$getPrimitiveName$p(Class cls) {
        if (Intrinsics.areEqual(cls, Boolean.TYPE) || Intrinsics.areEqual(cls, Boolean.class)) {
            return "Boolean";
        }
        if (Intrinsics.areEqual(cls, Byte.TYPE) || Intrinsics.areEqual(cls, Byte.class)) {
            return "Byte";
        }
        if (Intrinsics.areEqual(cls, Character.TYPE) || Intrinsics.areEqual(cls, Character.class)) {
            return "Char";
        }
        if (Intrinsics.areEqual(cls, Short.TYPE) || Intrinsics.areEqual(cls, Short.class)) {
            return "Short";
        }
        if (Intrinsics.areEqual(cls, Integer.TYPE) || Intrinsics.areEqual(cls, Integer.class)) {
            return "Int";
        }
        if (Intrinsics.areEqual(cls, Long.TYPE) || Intrinsics.areEqual(cls, Long.class)) {
            return "Long";
        }
        if (Intrinsics.areEqual(cls, Float.TYPE) || Intrinsics.areEqual(cls, Float.class)) {
            return "Float";
        }
        if (Intrinsics.areEqual(cls, Double.TYPE) || Intrinsics.areEqual(cls, Double.class)) {
            return "Double";
        }
        if (Intrinsics.areEqual(cls, Object.class)) {
            return "Any";
        }
        return null;
    }

    public static final String access$getStars$p(Class cls) {
        TypeVariable[] typeParameters = cls.getTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(typeParameters, "typeParameters");
        if (typeParameters.length == 0) {
            return "";
        }
        int length = cls.getTypeParameters().length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = "*";
        }
        return ArraysKt___ArraysKt.joinToString$default(strArr, ", ", "<", ">", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    @NotNull
    public static final String fullDispString(@NotNull Type type) {
        Intrinsics.checkParameterIsNotNull(type, "$this$fullDispString");
        return j.c(f.a, type, false, 2, null);
    }

    @NotNull
    public static final String fullErasedName(@NotNull Type type) {
        Intrinsics.checkParameterIsNotNull(type, "$this$fullErasedName");
        Type javaType = TypesKt.getJavaType(type);
        if (javaType instanceof Class) {
            String canonicalName = ((Class) javaType).getCanonicalName();
            Intrinsics.checkExpressionValueIsNotNull(canonicalName, "jvmType.canonicalName");
            return a(canonicalName);
        } else if (javaType instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) javaType).getRawType();
            Intrinsics.checkExpressionValueIsNotNull(rawType, "jvmType.rawType");
            return fullErasedName(rawType);
        } else if (javaType instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
            Intrinsics.checkExpressionValueIsNotNull(genericComponentType, "jvmType.genericComponentType");
            return fullErasedName(genericComponentType);
        } else if (javaType instanceof WildcardType) {
            return "*";
        } else {
            if (javaType instanceof TypeVariable) {
                String name = ((TypeVariable) javaType).getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "jvmType.name");
                return name;
            }
            StringBuilder L = a.L("Unknown type ");
            L.append(type.getClass());
            L.append(' ');
            L.append(type);
            throw new IllegalArgumentException(L.toString());
        }
    }

    @NotNull
    public static final String simpleDispString(@NotNull Type type) {
        Intrinsics.checkParameterIsNotNull(type, "$this$simpleDispString");
        return j.c(h.a, type, false, 2, null);
    }

    @NotNull
    public static final String simpleErasedName(@NotNull Type type) {
        String str;
        String simpleErasedName;
        Intrinsics.checkParameterIsNotNull(type, "$this$simpleErasedName");
        Type javaType = TypesKt.getJavaType(type);
        if (javaType instanceof Class) {
            StringBuilder sb = new StringBuilder();
            Class cls = (Class) javaType;
            Class<?> enclosingClass = cls.getEnclosingClass();
            if (enclosingClass == null || (simpleErasedName = simpleErasedName(enclosingClass)) == null || (str = a.c3(simpleErasedName, ".")) == null) {
                str = "";
            }
            sb.append(str);
            sb.append(cls.getSimpleName());
            return sb.toString();
        } else if (javaType instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) javaType).getRawType();
            Intrinsics.checkExpressionValueIsNotNull(rawType, "jvmType.rawType");
            return simpleErasedName(rawType);
        } else if (javaType instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
            Intrinsics.checkExpressionValueIsNotNull(genericComponentType, "jvmType.genericComponentType");
            return simpleErasedName(genericComponentType);
        } else if (javaType instanceof WildcardType) {
            return "*";
        } else {
            if (javaType instanceof TypeVariable) {
                String name = ((TypeVariable) javaType).getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "jvmType.name");
                return name;
            }
            StringBuilder L = a.L("Unknown type ");
            L.append(type.getClass());
            L.append(' ');
            L.append(type);
            throw new IllegalArgumentException(L.toString());
        }
    }
}
