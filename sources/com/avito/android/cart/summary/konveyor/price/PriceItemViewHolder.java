package com.avito.android.cart.summary.konveyor.price;

import android.view.View;
import android.widget.TextView;
import com.avito.android.cart.R;
import com.avito.android.cart.summary.konveyor.price.PriceItemView;
import com.avito.android.remote.cart.model.Price;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.TextViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/price/PriceItemViewHolder;", "Lcom/avito/android/cart/summary/konveyor/price/PriceItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/cart/model/Price;", "price", "", "setPrice", "(Lcom/avito/android/remote/cart/model/Price;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "t", "priceView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "u", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class PriceItemViewHolder extends BaseViewHolder implements PriceItemView {
    public final TextView s;
    public final TextView t;
    public final AttributedTextFormatter u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PriceItemViewHolder(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.u = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        PriceItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.cart.summary.konveyor.price.PriceItemView
    public void setPrice(@NotNull Price price) {
        Intrinsics.checkNotNullParameter(price, "price");
        AttributedText amount = price.getAmount();
        if (amount != null) {
            TextViewsKt.setAttributedText(this.s, price.getTitle(), this.u);
            TextViewsKt.setAttributedText(this.t, amount, this.u);
        }
    }
}
