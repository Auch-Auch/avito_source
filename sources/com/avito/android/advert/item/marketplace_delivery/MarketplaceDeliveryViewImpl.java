package com.avito.android.advert.item.marketplace_delivery;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter;
import com.avito.android.advert_details.R;
import com.avito.android.remote.model.SimpleAdvertAction;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryView;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "item", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showDelivery", "(Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter$Listener;)V", "disableDeliveryInfo", "()V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "selectCityView", "t", "titleView", VKApiConst.VERSION, "mapView", "Landroid/view/View;", "w", "Landroid/view/View;", "view", "u", "infoView", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceDeliveryViewImpl extends BaseViewHolder implements MarketplaceDeliveryView {
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final View w;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MarketplaceDeliveryPresenter.Listener a;
        public final /* synthetic */ MarketplaceDeliveryItem b;

        public a(MarketplaceDeliveryPresenter.Listener listener, MarketplaceDeliveryItem marketplaceDeliveryItem) {
            this.a = listener;
            this.b = marketplaceDeliveryItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MarketplaceDeliveryPresenter.Listener listener = this.a;
            if (listener != null) {
                SimpleAdvertAction deliveryAction = this.b.getDeliveryAction();
                listener.onMarketplaceDeliveryMapClick(deliveryAction != null ? deliveryAction.getDeepLink() : null);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketplaceDeliveryViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.w = view;
        View findViewById = view.findViewById(R.id.marketplace_delivery_select_city);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.m…ace_delivery_select_city)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.marketplace_delivery_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.marketplace_delivery_title)");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.marketplace_delivery_info);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.marketplace_delivery_info)");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.marketplace_delivery_map);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.marketplace_delivery_map)");
        this.v = (TextView) findViewById4;
    }

    @Override // com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryView
    public void disableDeliveryInfo() {
        Views.hide(this.u);
        Views.hide(this.v);
    }

    @Override // com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryView
    public void showDelivery(@NotNull MarketplaceDeliveryItem marketplaceDeliveryItem, @Nullable MarketplaceDeliveryPresenter.Listener listener) {
        Intrinsics.checkNotNullParameter(marketplaceDeliveryItem, "item");
        MarketplaceDeliveryViewKt.access$bindSelectCity(this.s, this.w, marketplaceDeliveryItem, listener);
        TextViews.bindText$default(this.t, marketplaceDeliveryItem.getDeliveryStatic().getDescription(), false, 2, null);
        TextViews.bindText$default(this.u, marketplaceDeliveryItem.getDeliveryInfo(), false, 2, null);
        TextView textView = this.v;
        SimpleAdvertAction deliveryAction = marketplaceDeliveryItem.getDeliveryAction();
        TextViews.bindText$default(textView, deliveryAction != null ? deliveryAction.getTitle() : null, false, 2, null);
        this.v.setOnClickListener(new a(listener, marketplaceDeliveryItem));
    }
}
