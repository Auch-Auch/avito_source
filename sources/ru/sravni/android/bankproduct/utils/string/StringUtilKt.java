package ru.sravni.android.bankproduct.utils.string;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"", "text", "textWithoutSpace", "(Ljava/lang/String;)Ljava/lang/String;", "textWithThousandSpace", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class StringUtilKt {
    @NotNull
    public static final String textWithThousandSpace(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        StringBuilder sb = new StringBuilder();
        String obj = StringsKt___StringsKt.reversed(str).toString();
        int i = 0;
        int i2 = 0;
        while (i < obj.length()) {
            char charAt = obj.charAt(i);
            int i3 = i2 + 1;
            if (i2 > 0 && i2 % 3 == 0) {
                sb.append(' ');
            }
            sb.append(charAt);
            i++;
            i2 = i3;
        }
        String sb2 = sb.reverse().toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "resStr.reverse().toString()");
        return sb2;
    }

    @NotNull
    public static final String textWithoutSpace(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        return m.replace$default(StringsKt__StringsKt.removePrefix(StringsKt__StringsKt.trim(str).toString(), (CharSequence) "0"), " ", "", false, 4, (Object) null);
    }
}
