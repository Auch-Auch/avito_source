package kotlin.reflect.jvm.internal.impl.name;

import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.w.f.a.m.d.a;
import t6.y.m;
public final class FqNamesUtilKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 3, 2};

        static {
            a.values();
        }
    }

    public static final boolean isSubpackageOf(@NotNull FqName fqName, @NotNull FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(fqName2, Constants.FirelogAnalytics.PARAM_PACKAGE_NAME);
        if (Intrinsics.areEqual(fqName, fqName2) || fqName2.isRoot()) {
            return true;
        }
        String asString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "this.asString()");
        String asString2 = fqName2.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "packageName.asString()");
        if (!m.startsWith$default(asString, asString2, false, 2, null) || asString.charAt(asString2.length()) != '.') {
            return false;
        }
        return true;
    }

    public static final boolean isValidJavaFqName(@Nullable String str) {
        a aVar = a.AFTER_DOT;
        if (str == null) {
            return false;
        }
        a aVar2 = a.BEGINNING;
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            i++;
            int ordinal = aVar2.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        continue;
                    }
                } else if (charAt == '.') {
                    aVar2 = aVar;
                } else if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
            }
            if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
            aVar2 = a.MIDDLE;
        }
        if (aVar2 != aVar) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final FqName tail(@NotNull FqName fqName, @NotNull FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(fqName2, "prefix");
        if (!isSubpackageOf(fqName, fqName2) || fqName2.isRoot()) {
            return fqName;
        }
        if (Intrinsics.areEqual(fqName, fqName2)) {
            FqName fqName3 = FqName.ROOT;
            Intrinsics.checkNotNullExpressionValue(fqName3, "ROOT");
            return fqName3;
        }
        String asString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString()");
        String substring = asString.substring(fqName2.asString().length() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        return new FqName(substring);
    }
}
