package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
public final class PropertiesConventionUtilKt {
    public static Name a(Name name, String str, boolean z, String str2, int i) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if (!name.isSpecial()) {
            String identifier = name.getIdentifier();
            Intrinsics.checkNotNullExpressionValue(identifier, "methodName.identifier");
            boolean z2 = false;
            if (m.startsWith$default(identifier, str, false, 2, null) && identifier.length() != str.length()) {
                char charAt = identifier.charAt(str.length());
                if ('a' <= charAt && charAt <= 'z') {
                    z2 = true;
                }
                if (!z2) {
                    if (str2 != null) {
                        return Name.identifier(Intrinsics.stringPlus(str2, StringsKt__StringsKt.removePrefix(identifier, (CharSequence) str)));
                    }
                    if (!z) {
                        return name;
                    }
                    String decapitalizeSmartForCompiler = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(StringsKt__StringsKt.removePrefix(identifier, (CharSequence) str), true);
                    if (Name.isValidIdentifier(decapitalizeSmartForCompiler)) {
                        return Name.identifier(decapitalizeSmartForCompiler);
                    }
                }
            }
        }
        return null;
    }

    @NotNull
    public static final List<Name> getPropertyNamesCandidatesByAccessorName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        JvmAbi jvmAbi = JvmAbi.INSTANCE;
        if (JvmAbi.isGetterName(asString)) {
            return CollectionsKt__CollectionsKt.listOfNotNull(propertyNameByGetMethodName(name));
        }
        if (JvmAbi.isSetterName(asString)) {
            return propertyNamesBySetMethodName(name);
        }
        return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(name);
    }

    @Nullable
    public static final Name propertyNameByGetMethodName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "methodName");
        Name a = a(name, "get", false, null, 12);
        return a == null ? a(name, "is", false, null, 8) : a;
    }

    @Nullable
    public static final Name propertyNameBySetMethodName(@NotNull Name name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "methodName");
        return a(name, "set", false, z ? "is" : null, 4);
    }

    @NotNull
    public static final List<Name> propertyNamesBySetMethodName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "methodName");
        return CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new Name[]{propertyNameBySetMethodName(name, false), propertyNameBySetMethodName(name, true)});
    }
}
