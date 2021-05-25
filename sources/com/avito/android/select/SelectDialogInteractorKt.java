package com.avito.android.select;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import t6.y.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Ljava/lang/String;", "select_release"}, k = 2, mv = {1, 4, 2})
public final class SelectDialogInteractorKt {
    public static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!a.isWhitespace(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    public static final boolean access$matchesQuery(String str, String str2) {
        return StringsKt__StringsKt.contains((CharSequence) a(str), (CharSequence) str2, true);
    }
}
