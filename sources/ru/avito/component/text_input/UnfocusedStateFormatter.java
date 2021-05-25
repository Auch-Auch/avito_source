package ru.avito.component.text_input;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\r\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lru/avito/component/text_input/UnfocusedStateFormatter;", "Lru/avito/component/text_input/TextChangeAwareFormatter;", "", "text", "", Tracker.Events.CREATIVE_START, "before", "count", "Lru/avito/component/text_input/CursorCharSequence;", "format", "(Ljava/lang/CharSequence;III)Lru/avito/component/text_input/CursorCharSequence;", AuthSource.BOOKING_ORDER, "Lru/avito/component/text_input/TextChangeAwareFormatter;", "delegateFormatter", "Lru/avito/component/text_input/Mask;", AuthSource.SEND_ABUSE, "Lru/avito/component/text_input/Mask;", "mask", "", "", InternalConstsKt.PLACEHOLDER, "<init>", "(Ljava/lang/String;CLru/avito/component/text_input/TextChangeAwareFormatter;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class UnfocusedStateFormatter implements TextChangeAwareFormatter {
    public final Mask a;
    public final TextChangeAwareFormatter b;

    public UnfocusedStateFormatter(@NotNull String str, char c, @NotNull TextChangeAwareFormatter textChangeAwareFormatter) {
        Intrinsics.checkNotNullParameter(str, "mask");
        Intrinsics.checkNotNullParameter(textChangeAwareFormatter, "delegateFormatter");
        this.b = textChangeAwareFormatter;
        this.a = new Mask(str, c);
    }

    @Override // ru.avito.component.text_input.TextChangeAwareFormatter
    @NotNull
    public CursorCharSequence format(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        boolean z = true;
        if (!this.a.correlatesWithText(charSequence) ? m.isBlank(charSequence) : Mask.rawText$default(this.a, charSequence, null, 2, null).length() <= 0) {
            z = false;
        }
        if (z) {
            return this.b.format(charSequence, i, i2, i3);
        }
        return new CursorCharSequence("", 0);
    }
}
