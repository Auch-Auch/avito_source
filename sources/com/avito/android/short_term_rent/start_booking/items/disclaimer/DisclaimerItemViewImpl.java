package com.avito.android.short_term_rent.start_booking.items.disclaimer;

import android.view.View;
import android.widget.TextView;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemViewImpl;", "Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setText", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class DisclaimerItemViewImpl extends BaseViewHolder implements DisclaimerItemView {
    public final TextView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DisclaimerItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.text);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        DisclaimerItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItemView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "textView");
        textView.setText(str);
    }
}
