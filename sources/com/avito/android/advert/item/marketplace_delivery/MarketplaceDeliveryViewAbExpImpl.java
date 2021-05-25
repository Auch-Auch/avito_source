package com.avito.android.advert.item.marketplace_delivery;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter;
import com.avito.android.advert_details.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryViewAbExpImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryView;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "item", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showDelivery", "(Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter$Listener;)V", "disableDeliveryInfo", "()V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "selectCityView", "Landroid/view/View;", "u", "Landroid/view/View;", "view", "t", "infoView", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceDeliveryViewAbExpImpl extends BaseViewHolder implements MarketplaceDeliveryView {
    public final TextView s;
    public final TextView t;
    public final View u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketplaceDeliveryViewAbExpImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = view;
        View findViewById = view.findViewById(R.id.marketplace_delivery_select_city);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.m…ace_delivery_select_city)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.marketplace_delivery_info);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.marketplace_delivery_info)");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryView
    public void disableDeliveryInfo() {
        Views.hide(this.t);
    }

    @Override // com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryView
    public void showDelivery(@NotNull MarketplaceDeliveryItem marketplaceDeliveryItem, @Nullable MarketplaceDeliveryPresenter.Listener listener) {
        String str;
        Intrinsics.checkNotNullParameter(marketplaceDeliveryItem, "item");
        MarketplaceDeliveryViewKt.access$bindSelectCity(this.s, this.u, marketplaceDeliveryItem, listener);
        TextView textView = this.t;
        StringBuilder sb = new StringBuilder();
        sb.append(marketplaceDeliveryItem.getDeliveryStatic().getDescription());
        String deliveryInfo = marketplaceDeliveryItem.getDeliveryInfo();
        if (deliveryInfo != null) {
            String str2 = ", " + deliveryInfo;
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            str = str2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase()");
        } else {
            str = null;
        }
        sb.append(str);
        TextViews.bindText$default(textView, sb.toString(), false, 2, null);
    }
}
