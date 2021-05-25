package com.avito.android.profile_phones;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "nonBreakingText", "(Ljava/lang/String;)Ljava/lang/String;", "profile-phones_release"}, k = 2, mv = {1, 4, 2})
public final class StringsKt {
    @NotNull
    public static final String nonBreakingText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$nonBreakingText");
        return m.replace$default(str, ' ', (char) Typography.nbsp, false, 4, (Object) null);
    }
}
