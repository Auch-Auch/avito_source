package com.avito.android.util;

import android.text.Editable;
import android.text.Selection;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b \u0010!J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/util/MasksFormatterTextWatcher;", "Lcom/avito/android/util/SimpleTextWatcher;", "", "s", "", Tracker.Events.CREATIVE_START, "count", "after", "", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "", AuthSource.BOOKING_ORDER, "Z", "isDeletionFromCenter", "Lcom/avito/android/util/PositionFormatter;", "e", "Lcom/avito/android/util/PositionFormatter;", "formatter", "d", "Ljava/lang/CharSequence;", "textBeforeChanges", AuthSource.SEND_ABUSE, "isInProcessing", "c", "I", "cursorPosition", "<init>", "(Lcom/avito/android/util/PositionFormatter;)V", "formatters_release"}, k = 1, mv = {1, 4, 2})
public final class MasksFormatterTextWatcher extends SimpleTextWatcher {
    public boolean a;
    public boolean b;
    public int c;
    public CharSequence d;
    public final PositionFormatter e;

    public MasksFormatterTextWatcher(@NotNull PositionFormatter positionFormatter) {
        Intrinsics.checkNotNullParameter(positionFormatter, "formatter");
        this.e = positionFormatter;
    }

    @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
    public void afterTextChanged(@NotNull Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "s");
        if (!this.a) {
            this.a = true;
            if (this.b) {
                editable.clear();
                Intrinsics.checkNotNullExpressionValue(editable.append(this.d), "s.append(textBeforeChanges)");
            } else {
                CursorString format = this.e.format(editable.toString(), this.c);
                editable.clear();
                editable.append((CharSequence) format.getValue());
                Selection.setSelection(editable, Math.max(0, Math.min(format.getCursorPosition(), editable.length())));
            }
            this.a = false;
        }
    }

    @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
    public void beforeTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
        if (!this.a) {
            boolean z = true;
            if (!(i2 > i3) || i2 + i == charSequence.length()) {
                z = false;
            }
            this.b = z;
            this.d = charSequence.toString();
        }
    }

    @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
        if (!this.a) {
            this.c = i + i3;
        }
    }
}
