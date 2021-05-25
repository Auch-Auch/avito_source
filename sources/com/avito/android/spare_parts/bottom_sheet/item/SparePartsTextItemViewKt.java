package com.avito.android.spare_parts.bottom_sheet.item;

import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/widget/TextView;", "Landroid/text/Spannable;", "spannable", "", "spanIndex", "", "dispatchClicksToClickableSpan", "(Landroid/widget/TextView;Landroid/text/Spannable;I)V", "spare-parts_release"}, k = 2, mv = {1, 4, 2})
public final class SparePartsTextItemViewKt {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ClickableSpan a;

        public a(ClickableSpan clickableSpan) {
            this.a = clickableSpan;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.onClick(view);
        }
    }

    public static final void dispatchClicksToClickableSpan(@NotNull TextView textView, @NotNull Spannable spannable, int i) {
        Intrinsics.checkNotNullParameter(textView, "$this$dispatchClicksToClickableSpan");
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        boolean z = false;
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class);
        Intrinsics.checkNotNullExpressionValue(clickableSpanArr, "spans");
        if (clickableSpanArr.length == 0) {
            z = true;
        }
        if ((!z) && i <= clickableSpanArr.length - 1) {
            textView.setOnClickListener(new a(clickableSpanArr[i]));
        }
    }

    public static /* synthetic */ void dispatchClicksToClickableSpan$default(TextView textView, Spannable spannable, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        dispatchClicksToClickableSpan(textView, spannable, i);
    }
}
