package com.avito.android.short_term_rent.start_booking.items.summary;

import android.view.View;
import android.widget.TextView;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007R\u001e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemViewImpl;", "Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "description", "setDescription", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "t", "Landroid/widget/TextView;", "descriptionTextView", "s", "titleTextView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class SummaryItemViewImpl extends BaseViewHolder implements SummaryItemView {
    public final TextView s;
    public final TextView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SummaryItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = (TextView) view.findViewById(R.id.description);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SummaryItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemView
    public void setDescription(@Nullable CharSequence charSequence) {
        if (charSequence != null) {
            TextView textView = this.t;
            Intrinsics.checkNotNullExpressionValue(textView, "descriptionTextView");
            textView.setText(charSequence);
            return;
        }
        TextView textView2 = this.t;
        Intrinsics.checkNotNullExpressionValue(textView2, "descriptionTextView");
        textView2.setVisibility(8);
    }

    @Override // com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemView
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "titleTextView");
        textView.setText(charSequence);
    }
}
