package com.avito.android.util;

import android.text.Editable;
import android.text.Selection;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/util/PositionFormatterTextWatcher;", "Lcom/avito/android/util/SimpleTextWatcher;", "", "s", "", Tracker.Events.CREATIVE_START, "before", "count", "", "onTextChanged", "(Ljava/lang/CharSequence;III)V", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "Lcom/avito/android/util/CursorString;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/CursorString;", "formattedText", "Lcom/avito/android/util/PositionFormatter;", "c", "Lcom/avito/android/util/PositionFormatter;", "formatter", "", AuthSource.SEND_ABUSE, "Z", "selfChange", "<init>", "(Lcom/avito/android/util/PositionFormatter;)V", "formatters_release"}, k = 1, mv = {1, 4, 2})
public final class PositionFormatterTextWatcher extends SimpleTextWatcher {
    public boolean a;
    public CursorString b;
    public final PositionFormatter c;

    public PositionFormatterTextWatcher(@NotNull PositionFormatter positionFormatter) {
        Intrinsics.checkNotNullParameter(positionFormatter, "formatter");
        this.c = positionFormatter;
    }

    @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
    public void afterTextChanged(@NotNull Editable editable) {
        CursorString cursorString;
        Intrinsics.checkNotNullParameter(editable, "s");
        if (!this.a && (cursorString = this.b) != null && cursorString != null) {
            this.a = true;
            editable.replace(0, editable.length(), cursorString.getValue());
            Selection.setSelection(editable, Math.max(0, Math.min(cursorString.getCursorPosition(), editable.length())));
            this.a = false;
        }
    }

    @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
        if (!this.a) {
            if (!(i2 > 0)) {
                i += i3;
            }
            this.b = this.c.format(charSequence.toString(), i);
        }
    }
}
