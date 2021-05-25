package com.avito.android.lib.design.input;

import android.text.Editable;
import android.text.TextWatcher;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B4\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR1\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/avito/android/lib/design/input/SimpleTextWatcher;", "Landroid/text/TextWatcher;", "", "s", "", Tracker.Events.CREATIVE_START, "count", "after", "", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "text", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "lastEmitted", "initialText", "<init>", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleTextWatcher implements TextWatcher {
    public String a;
    public final Function1<String, Unit> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleTextWatcher(@Nullable CharSequence charSequence, @NotNull Function1<? super String, Unit> function1) {
        String str;
        Intrinsics.checkNotNullParameter(function1, "onTextChanged");
        this.b = function1;
        this.a = (charSequence == null || (str = charSequence.toString()) == null) ? "" : str;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        String str;
        if (editable == null || (str = editable.toString()) == null) {
            str = "";
        }
        if (!Intrinsics.areEqual(str, this.a)) {
            this.b.invoke(str);
            this.a = str;
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }
}
