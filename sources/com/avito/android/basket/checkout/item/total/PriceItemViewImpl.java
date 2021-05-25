package com.avito.android.basket.checkout.item.total;

import android.view.View;
import android.widget.TextView;
import com.avito.android.basket.checkout.item.total.PriceItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/basket/checkout/item/total/PriceItemViewImpl;", "Lcom/avito/android/basket/checkout/item/total/PriceItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "value", "", "setTotal", "(Ljava/lang/String;)V", "Landroid/view/View;", "s", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class PriceItemViewImpl extends BaseViewHolder implements PriceItemView {
    public final View s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PriceItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = view;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        PriceItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.basket.checkout.item.total.PriceItemView
    public void setTotal(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        View view = this.s;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) view).setText(str);
    }
}
