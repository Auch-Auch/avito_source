package ru.avito.component.text_input;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lru/avito/component/text_input/SpannableColorizer;", "Lru/avito/component/text_input/Colorizer;", "", "value", "", Tracker.Events.CREATIVE_START, "end", "colorize", "(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;", AuthSource.SEND_ABUSE, "I", "color", "<init>", "(I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SpannableColorizer implements Colorizer {
    public final int a;

    public SpannableColorizer(@ColorInt int i) {
        this.a = i;
    }

    @Override // ru.avito.component.text_input.Colorizer
    @NotNull
    public CharSequence colorize(@NotNull CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.a);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(foregroundColorSpan, i, i2, 0);
        return spannableStringBuilder;
    }
}
