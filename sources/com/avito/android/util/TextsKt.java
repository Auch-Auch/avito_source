package com.avito.android.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.text.Text;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lru/avito/component/text/Text;", "", "text", "", "bindText", "(Lru/avito/component/text/Text;Ljava/lang/CharSequence;)V", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class TextsKt {
    public static final void bindText(@NotNull Text text, @Nullable CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(text, "$this$bindText");
        if (charSequence == null || charSequence.length() == 0) {
            text.hide();
            return;
        }
        text.show();
        text.setText(charSequence);
    }
}
