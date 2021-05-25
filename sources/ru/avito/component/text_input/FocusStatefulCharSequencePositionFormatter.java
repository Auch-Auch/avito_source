package ru.avito.component.text_input;

import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\"\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lru/avito/component/text_input/FocusStatefulCharSequencePositionFormatter;", "Lru/avito/component/text_input/TextChangeAwareFormatter;", "", "text", "", Tracker.Events.CREATIVE_START, "before", "count", "Lru/avito/component/text_input/CursorCharSequence;", "format", "(Ljava/lang/CharSequence;III)Lru/avito/component/text_input/CursorCharSequence;", "c", "Lru/avito/component/text_input/TextChangeAwareFormatter;", "unfocusedFormatter", AuthSource.BOOKING_ORDER, "focusedFormatter", "", AuthSource.SEND_ABUSE, "Z", "isFocused", "()Z", "setFocused", "(Z)V", "<init>", "(Lru/avito/component/text_input/TextChangeAwareFormatter;Lru/avito/component/text_input/TextChangeAwareFormatter;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class FocusStatefulCharSequencePositionFormatter implements TextChangeAwareFormatter {
    public boolean a;
    public final TextChangeAwareFormatter b;
    public final TextChangeAwareFormatter c;

    public FocusStatefulCharSequencePositionFormatter(@NotNull TextChangeAwareFormatter textChangeAwareFormatter, @NotNull TextChangeAwareFormatter textChangeAwareFormatter2) {
        Intrinsics.checkNotNullParameter(textChangeAwareFormatter, "focusedFormatter");
        Intrinsics.checkNotNullParameter(textChangeAwareFormatter2, "unfocusedFormatter");
        this.b = textChangeAwareFormatter;
        this.c = textChangeAwareFormatter2;
    }

    @Override // ru.avito.component.text_input.TextChangeAwareFormatter
    @NotNull
    public CursorCharSequence format(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        if (this.a) {
            return this.b.format(charSequence, i, i2, i3);
        }
        return this.c.format(charSequence, i, i2, i3);
    }

    public final boolean isFocused() {
        return this.a;
    }

    public final void setFocused(boolean z) {
        this.a = z;
    }
}
