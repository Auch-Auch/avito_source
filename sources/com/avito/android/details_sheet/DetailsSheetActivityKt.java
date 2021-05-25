package com.avito.android.details_sheet;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/widget/TextView;", "", "text", "", "setTextAndVisibility", "(Landroid/widget/TextView;Ljava/lang/CharSequence;)V", "details-sheet_release"}, k = 2, mv = {1, 4, 2})
public final class DetailsSheetActivityKt {
    public static final void setTextAndVisibility(@NotNull TextView textView, @Nullable CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(textView, "$this$setTextAndVisibility");
        textView.setText(charSequence);
        int i = 0;
        if (charSequence == null || charSequence.length() == 0) {
            i = 8;
        }
        textView.setVisibility(i);
    }
}
