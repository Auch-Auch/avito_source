package com.redmadrobot.inputmask.helper;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt___StringsKt;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"input-mask-android_release"}, k = 2, mv = {1, 4, 0})
public final class RTLMaskKt {
    public static final String access$reversedFormat(String str) {
        if (str != null) {
            String replace$default = m.replace$default(m.replace$default(m.replace$default(m.replace$default(StringsKt___StringsKt.reversed(str).toString(), "[\\", "\\]", false, 4, (Object) null), "]\\", "\\[", false, 4, (Object) null), "{\\", "\\}", false, 4, (Object) null), "}\\", "\\{", false, 4, (Object) null);
            ArrayList arrayList = new ArrayList(replace$default.length());
            for (int i = 0; i < replace$default.length(); i++) {
                char charAt = replace$default.charAt(i);
                if (charAt == '[') {
                    charAt = ']';
                } else if (charAt == ']') {
                    charAt = '[';
                } else if (charAt == '{') {
                    charAt = '}';
                } else if (charAt == '}') {
                    charAt = '{';
                }
                arrayList.add(Character.valueOf(charAt));
            }
            return CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
