package com.avito.android.html_editor;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/html_editor/HistorySnapshot;", "", "", "c", "I", "getSelectionEnd", "()I", "selectionEnd", AuthSource.BOOKING_ORDER, "getSelectionStart", "selectionStart", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;II)V", "html-editor_release"}, k = 1, mv = {1, 4, 2})
public class HistorySnapshot {
    @NotNull
    public final String a;
    public final int b;
    public final int c;

    public HistorySnapshot(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public final int getSelectionEnd() {
        return this.c;
    }

    public final int getSelectionStart() {
        return this.b;
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }
}
