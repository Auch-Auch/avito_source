package ru.avito.component.text_input;

import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lru/avito/component/text_input/TextChangeAwareFormatter;", "", "", "text", "", Tracker.Events.CREATIVE_START, "before", "count", "Lru/avito/component/text_input/CursorCharSequence;", "format", "(Ljava/lang/CharSequence;III)Lru/avito/component/text_input/CursorCharSequence;", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface TextChangeAwareFormatter {
    @NotNull
    CursorCharSequence format(@NotNull CharSequence charSequence, int i, int i2, int i3);
}
