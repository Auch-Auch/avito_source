package com.avito.android.analytics_adjust;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Strings;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics_adjust/HashedEmail;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "email", "<init>", "(Ljava/lang/String;)V", "analytics-adjust_release"}, k = 1, mv = {1, 4, 2})
public final class HashedEmail {
    @NotNull
    public final String a;

    public HashedEmail(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        this.a = Strings.md5(m.replace$default(lowerCase, " ", "", false, 4, (Object) null));
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }
}
