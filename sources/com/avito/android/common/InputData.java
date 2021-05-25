package com.avito.android.common;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/avito/android/common/InputData;", "", "", AuthSource.BOOKING_ORDER, "I", "getSelectionEnd", "()I", "selectionEnd", "", "c", "Ljava/lang/CharSequence;", "getValue", "()Ljava/lang/CharSequence;", "value", AuthSource.SEND_ABUSE, "getSelectionStart", "selectionStart", "<init>", "(Ljava/lang/CharSequence;II)V", "formatters-provider_release"}, k = 1, mv = {1, 4, 2})
public final class InputData {
    public final int a;
    public final int b;
    @NotNull
    public final CharSequence c;

    public InputData(@NotNull CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.c = charSequence;
        this.a = Math.min(Math.max(0, i), charSequence.length());
        this.b = Math.min(Math.max(0, i2), charSequence.length());
    }

    public final int getSelectionEnd() {
        return this.b;
    }

    public final int getSelectionStart() {
        return this.a;
    }

    @NotNull
    public final CharSequence getValue() {
        return this.c;
    }
}
