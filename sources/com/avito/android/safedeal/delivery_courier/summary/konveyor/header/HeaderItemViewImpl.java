package com.avito.android.safedeal.delivery_courier.summary.konveyor.header;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.safedeal.R;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItemView;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/header/HeaderItemViewImpl;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/header/HeaderItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setText", "(Ljava/lang/CharSequence;)V", "", ProductAction.ACTION_ADD, "addTopMargin", "(Z)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderItemViewImpl extends BaseViewHolder implements HeaderItemView {
    public final TextView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.text_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.text_view)");
        this.s = (TextView) findViewById;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItemView
    public void addTopMargin(boolean z) {
        TextView textView = this.s;
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).topMargin = z ? textView.getResources().getDimensionPixelOffset(R.dimen.delivery_summary_header_top_margin) : 0;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        HeaderItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItemView
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        TextViews.bindText$default(this.s, charSequence, false, 2, null);
    }
}
