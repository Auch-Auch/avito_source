package com.avito.android.lib.design.button;

import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/design/button/Button;", "", "text", "", "concealWhenEmpty", "", "bindText", "(Lcom/avito/android/lib/design/button/Button;Ljava/lang/CharSequence;Z)V", "components_release"}, k = 2, mv = {1, 4, 2})
public final class ButtonsKt {
    @JvmOverloads
    public static final void bindText(@NotNull Button button, @Nullable CharSequence charSequence) {
        bindText$default(button, charSequence, false, 2, null);
    }

    @JvmOverloads
    public static final void bindText(@NotNull Button button, @Nullable CharSequence charSequence, boolean z) {
        Intrinsics.checkNotNullParameter(button, "$this$bindText");
        if (!(charSequence == null || charSequence.length() == 0)) {
            Views.show(button);
            button.setText(charSequence);
        } else if (z) {
            Views.conceal(button);
        } else {
            Views.hide(button);
        }
    }

    public static /* synthetic */ void bindText$default(Button button, CharSequence charSequence, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        bindText(button, charSequence, z);
    }
}
