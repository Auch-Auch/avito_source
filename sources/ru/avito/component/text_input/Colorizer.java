package ru.avito.component.text_input;

import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lru/avito/component/text_input/Colorizer;", "", "", "value", "", Tracker.Events.CREATIVE_START, "end", "colorize", "(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface Colorizer {
    @NotNull
    CharSequence colorize(@NotNull CharSequence charSequence, int i, int i2);
}
