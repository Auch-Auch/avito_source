package com.avito.android.lib.design.input;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/lib/design/input/FormattedResult;", "", "", AuthSource.BOOKING_ORDER, "I", "getFormatSelection", "()I", "formatSelection", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getFormattedText", "()Ljava/lang/String;", "formattedText", "<init>", "(Ljava/lang/String;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class FormattedResult {
    @NotNull
    public final String a;
    public final int b;

    public FormattedResult(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "formattedText");
        this.a = str;
        this.b = i;
    }

    public final int getFormatSelection() {
        return this.b;
    }

    @NotNull
    public final String getFormattedText() {
        return this.a;
    }
}
