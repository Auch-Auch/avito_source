package com.avito.android.component.disclaimer;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/component/disclaimer/DisclaimerViewHolderImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/component/disclaimer/DisclaimerViewHolder;", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "", "setText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "t", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/view/View;", "s", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class DisclaimerViewHolderImpl extends BaseViewHolder implements DisclaimerViewHolder {
    public final View s;
    public final AttributedTextFormatter t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DisclaimerViewHolderImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.s = view;
        this.t = attributedTextFormatter;
    }

    @Override // com.avito.android.component.disclaimer.DisclaimerViewHolder
    public void setText(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "text");
        AttributedTextFormatter attributedTextFormatter = this.t;
        Context context = this.s.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        CharSequence format = attributedTextFormatter.format(context, attributedText);
        if (format != null) {
            View view = this.s;
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) view).setMovementMethod(LinkMovementMethod.getInstance());
            ((TextView) this.s).setText(format);
        }
    }
}
