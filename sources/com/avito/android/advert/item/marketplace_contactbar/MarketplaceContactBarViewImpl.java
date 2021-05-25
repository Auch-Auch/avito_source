package com.avito.android.advert.item.marketplace_contactbar;

import android.view.View;
import com.avito.android.lib.design.button.Button;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert/item/marketplace_contactbar/MarketplaceContactBarViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/marketplace_contactbar/MarketplaceContactBarView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Landroid/view/View$OnClickListener;", "clickListener", "setListener", "(Landroid/view/View$OnClickListener;)V", "Lcom/avito/android/lib/design/button/Button;", "s", "Lcom/avito/android/lib/design/button/Button;", "contactButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceContactBarViewImpl extends BaseViewHolder implements MarketplaceContactBarView {
    public final Button s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketplaceContactBarViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (Button) view;
    }

    @Override // com.avito.android.advert.item.marketplace_contactbar.MarketplaceContactBarView
    public void setListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
        this.s.setOnClickListener(onClickListener);
    }

    @Override // com.avito.android.advert.item.marketplace_contactbar.MarketplaceContactBarView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }
}
