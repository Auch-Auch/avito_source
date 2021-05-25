package com.avito.android.lib.expected.badge_bar;

import androidx.annotation.ColorInt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/avito/android/lib/expected/badge_bar/BadgeParams;", "", "", "c", "I", "getBackgroundColor", "()I", "backgroundColor", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "", "d", "Z", "getShouldShowOnboarding", "()Z", "shouldShowOnboarding", AuthSource.BOOKING_ORDER, "getTextColor", "textColor", "<init>", "(Ljava/lang/String;IIZ)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeParams {
    @NotNull
    public final String a;
    public final int b;
    public final int c;
    public final boolean d;

    public BadgeParams(@NotNull String str, @ColorInt int i, @ColorInt int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = z;
    }

    public final int getBackgroundColor() {
        return this.c;
    }

    public final boolean getShouldShowOnboarding() {
        return this.d;
    }

    @NotNull
    public final String getText() {
        return this.a;
    }

    public final int getTextColor() {
        return this.b;
    }
}
