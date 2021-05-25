package com.avito.android.cart.summary.konveyor.header;

import android.view.View;
import android.widget.TextView;
import com.avito.android.cart.R;
import com.avito.android.cart.summary.konveyor.header.HeaderItemView;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/header/HeaderItemViewHolder;", "Lcom/avito/android/cart/summary/konveyor/header/HeaderItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "bindText", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderItemViewHolder extends BaseViewHolder implements HeaderItemView {
    public final TextView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.header);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
    }

    @Override // com.avito.android.cart.summary.konveyor.header.HeaderItemView
    public void bindText(@Nullable String str) {
        TextViews.bindText$default(this.s, str, false, 2, null);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        HeaderItemView.DefaultImpls.onUnbind(this);
    }
}
