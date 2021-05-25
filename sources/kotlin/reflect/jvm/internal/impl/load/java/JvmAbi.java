package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
public final class JvmAbi {
    @NotNull
    public static final JvmAbi INSTANCE = new JvmAbi();
    @JvmField
    @NotNull
    public static final FqName JVM_FIELD_ANNOTATION_FQ_NAME = new FqName("kotlin.jvm.JvmField");

    static {
        Intrinsics.checkNotNullExpressionValue(ClassId.topLevel(new FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl")), "topLevel(FqName(\"kotlin.reflect.jvm.internal.ReflectionFactoryImpl\"))");
    }

    @JvmStatic
    @NotNull
    public static final String getterName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "propertyName");
        return startsWithIsPrefix(str) ? str : Intrinsics.stringPlus("get", CapitalizeDecapitalizeKt.capitalizeAsciiOnly(str));
    }

    @JvmStatic
    public static final boolean isGetterName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return m.startsWith$default(str, "get", false, 2, null) || m.startsWith$default(str, "is", false, 2, null);
    }

    @JvmStatic
    public static final boolean isSetterName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return m.startsWith$default(str, "set", false, 2, null);
    }

    @JvmStatic
    @NotNull
    public static final String setterName(@NotNull String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "propertyName");
        if (startsWithIsPrefix(str)) {
            str2 = str.substring(2);
            Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.String).substring(startIndex)");
        } else {
            str2 = CapitalizeDecapitalizeKt.capitalizeAsciiOnly(str);
        }
        return Intrinsics.stringPlus("set", str2);
    }

    @JvmStatic
    public static final boolean startsWithIsPrefix(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (!m.startsWith$default(str, "is", false, 2, null) || str.length() == 2) {
            return false;
        }
        char charAt = str.charAt(2);
        if (Intrinsics.compare(97, (int) charAt) > 0 || Intrinsics.compare((int) charAt, 122) > 0) {
            return true;
        }
        return false;
    }
}
