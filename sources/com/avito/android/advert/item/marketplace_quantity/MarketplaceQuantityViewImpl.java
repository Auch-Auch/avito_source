package com.avito.android.advert.item.marketplace_quantity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.android.remote.marketplace.AdvertQuantity;
import com.avito.android.util.Views;
import com.avito.android.util.text.TextViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert/item/marketplace_quantity/MarketplaceQuantityViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/marketplace_quantity/MarketplaceQuantityView;", "Lcom/avito/android/remote/marketplace/AdvertQuantity;", FirebaseAnalytics.Param.QUANTITY, "", "setQuantity", "(Lcom/avito/android/remote/marketplace/AdvertQuantity;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "title", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "icon", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceQuantityViewImpl extends BaseViewHolder implements MarketplaceQuantityView {
    public final TextView s;
    public final ImageView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketplaceQuantityViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.marketplace_quantity_item_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.m…place_quantity_item_text)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.marketplace_quantity_item_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.m…place_quantity_item_icon)");
        this.t = (ImageView) findViewById2;
    }

    @Override // com.avito.android.advert.item.marketplace_quantity.MarketplaceQuantityView
    public void setQuantity(@NotNull AdvertQuantity advertQuantity) {
        Intrinsics.checkNotNullParameter(advertQuantity, FirebaseAnalytics.Param.QUANTITY);
        ImageView imageView = this.t;
        Boolean showIcon = advertQuantity.getShowIcon();
        Views.setVisible(imageView, showIcon != null ? showIcon.booleanValue() : false);
        TextViewsKt.bindAttributedText$default(this.s, advertQuantity.getTitle(), null, 2, null);
    }
}
