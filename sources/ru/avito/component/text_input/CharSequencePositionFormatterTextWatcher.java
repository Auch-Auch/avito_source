package ru.avito.component.text_input;

import android.text.Editable;
import android.text.Selection;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SimpleTextWatcher;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b0\u0016¢\u0006\u0004\b\u001f\u0010 J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b0\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lru/avito/component/text_input/CharSequencePositionFormatterTextWatcher;", "Lcom/avito/android/util/SimpleTextWatcher;", "", "s", "", Tracker.Events.CREATIVE_START, "before", "count", "", "onTextChanged", "(Ljava/lang/CharSequence;III)V", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "Lru/avito/component/text_input/CursorCharSequence;", AuthSource.BOOKING_ORDER, "Lru/avito/component/text_input/CursorCharSequence;", "formattedText", "", AuthSource.SEND_ABUSE, "Z", "selfChange", "Lkotlin/Function1;", "", "d", "Lkotlin/jvm/functions/Function1;", "textChangeListener", "Lru/avito/component/text_input/TextChangeAwareFormatter;", "c", "Lru/avito/component/text_input/TextChangeAwareFormatter;", "formatter", "<init>", "(Lru/avito/component/text_input/TextChangeAwareFormatter;Lkotlin/jvm/functions/Function1;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CharSequencePositionFormatterTextWatcher extends SimpleTextWatcher {
    public boolean a;
    public CursorCharSequence b;
    public final TextChangeAwareFormatter c;
    public final Function1<String, Unit> d;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public CharSequencePositionFormatterTextWatcher(@NotNull TextChangeAwareFormatter textChangeAwareFormatter, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(textChangeAwareFormatter, "formatter");
        Intrinsics.checkNotNullParameter(function1, "textChangeListener");
        this.c = textChangeAwareFormatter;
        this.d = function1;
    }

    @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
    public void afterTextChanged(@NotNull Editable editable) {
        CursorCharSequence cursorCharSequence;
        Intrinsics.checkNotNullParameter(editable, "s");
        if (!this.a && (cursorCharSequence = this.b) != null && cursorCharSequence != null) {
            this.d.invoke(cursorCharSequence.getValue().toString());
            this.a = true;
            editable.replace(0, editable.length(), cursorCharSequence.getValue());
            Selection.setSelection(editable, Math.max(0, Math.min(cursorCharSequence.getCursorPosition(), editable.length())));
            this.a = false;
        }
    }

    @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
        if (!this.a) {
            this.b = this.c.format(charSequence, i, i2, i3);
        }
    }
}
