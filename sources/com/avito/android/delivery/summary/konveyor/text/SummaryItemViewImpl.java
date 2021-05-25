package com.avito.android.delivery.summary.konveyor.text;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.delivery.R;
import com.avito.android.delivery.summary.konveyor.text.TextItemView;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.TextViews;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007R\u001e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/text/SummaryItemViewImpl;", "Lcom/avito/android/delivery/summary/konveyor/text/TextItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "", "setTitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "description", "setDescription", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "t", "Landroid/widget/TextView;", "descriptionTextView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "u", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "s", "titleTextView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class SummaryItemViewImpl extends BaseViewHolder implements TextItemView {
    public final TextView s;
    public final TextView t;
    public final AttributedTextFormatter u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SummaryItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.u = attributedTextFormatter;
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = (TextView) view.findViewById(R.id.description);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        TextItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.delivery.summary.konveyor.text.TextItemView
    public void setDescription(@Nullable AttributedText attributedText) {
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "descriptionTextView");
        AttributedTextFormatter attributedTextFormatter = this.u;
        TextView textView2 = this.t;
        Intrinsics.checkNotNullExpressionValue(textView2, "descriptionTextView");
        Context context = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "descriptionTextView.context");
        TextViews.bindText$default(textView, attributedTextFormatter.format(context, attributedText), false, 2, null);
    }

    @Override // com.avito.android.delivery.summary.konveyor.text.TextItemView
    public void setTitle(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "title");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "titleTextView");
        AttributedTextFormatter attributedTextFormatter = this.u;
        TextView textView2 = this.s;
        Intrinsics.checkNotNullExpressionValue(textView2, "titleTextView");
        Context context = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "titleTextView.context");
        textView.setText(attributedTextFormatter.format(context, attributedText));
    }
}
