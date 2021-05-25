package ru.avito.component.text_input;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/avito/component/text_input/CursorCharSequence;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getValue", "()Ljava/lang/CharSequence;", "value", "", AuthSource.BOOKING_ORDER, "I", "getCursorPosition", "()I", "cursorPosition", "<init>", "(Ljava/lang/CharSequence;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CursorCharSequence {
    @NotNull
    public final CharSequence a;
    public final int b;

    public CursorCharSequence(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.a = charSequence;
        this.b = i;
    }

    public final int getCursorPosition() {
        return this.b;
    }

    @NotNull
    public final CharSequence getValue() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CursorCharSequence(CharSequence charSequence, int i, int i2, j jVar) {
        this(charSequence, (i2 & 2) != 0 ? 0 : i);
    }
}
