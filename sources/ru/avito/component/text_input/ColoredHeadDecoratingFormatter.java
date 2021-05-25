package ru.avito.component.text_input;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0001¢\u0006\u0004\b!\u0010\"J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lru/avito/component/text_input/ColoredHeadDecoratingFormatter;", "Lru/avito/component/text_input/TextChangeAwareFormatter;", "", "text", "", Tracker.Events.CREATIVE_START, "before", "count", "Lru/avito/component/text_input/CursorCharSequence;", "format", "(Ljava/lang/CharSequence;III)Lru/avito/component/text_input/CursorCharSequence;", "", "c", "Ljava/lang/String;", "mask", "", AuthSource.BOOKING_ORDER, "Z", "hasHeadToColor", AuthSource.SEND_ABUSE, "I", "maskPlaceholderStartPosition", "Lru/avito/component/text_input/Colorizer;", "e", "Lru/avito/component/text_input/Colorizer;", "colorizer", "f", "Lru/avito/component/text_input/TextChangeAwareFormatter;", "preformatter", "", "d", "C", InternalConstsKt.PLACEHOLDER, "<init>", "(Ljava/lang/String;CLru/avito/component/text_input/Colorizer;Lru/avito/component/text_input/TextChangeAwareFormatter;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ColoredHeadDecoratingFormatter implements TextChangeAwareFormatter {
    public final int a;
    public final boolean b;
    public final String c;
    public final char d;
    public final Colorizer e;
    public final TextChangeAwareFormatter f;

    public ColoredHeadDecoratingFormatter(@NotNull String str, char c2, @NotNull Colorizer colorizer, @NotNull TextChangeAwareFormatter textChangeAwareFormatter) {
        Intrinsics.checkNotNullParameter(str, "mask");
        Intrinsics.checkNotNullParameter(colorizer, "colorizer");
        Intrinsics.checkNotNullParameter(textChangeAwareFormatter, "preformatter");
        this.c = str;
        this.d = c2;
        this.e = colorizer;
        this.f = textChangeAwareFormatter;
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        this.a = indexOf$default;
        this.b = indexOf$default > 0;
    }

    @Override // ru.avito.component.text_input.TextChangeAwareFormatter
    @NotNull
    public CursorCharSequence format(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        CursorCharSequence format = this.f.format(charSequence, i, i2, i3);
        CharSequence value = format.getValue();
        if (this.b) {
            value = this.e.colorize(value, 0, this.a);
        }
        return new CursorCharSequence(value, format.getCursorPosition());
    }
}
