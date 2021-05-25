package com.avito.android.advert.item.price_subscription;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionView;
import com.avito.android.advert_details.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionView;", "Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionItem;", "item", "Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showPriceSubscription", "(Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionItem;Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionView$Listener;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "text", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsPriceSubscriptionViewImpl extends BaseViewHolder implements AdvertDetailsPriceSubscriptionView {
    public TextView s;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AdvertDetailsPriceSubscriptionView.Listener a;
        public final /* synthetic */ AdvertDetailsPriceSubscriptionItem b;

        public a(AdvertDetailsPriceSubscriptionView.Listener listener, AdvertDetailsPriceSubscriptionItem advertDetailsPriceSubscriptionItem) {
            this.a = listener;
            this.b = advertDetailsPriceSubscriptionItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.onPriceSubscriptionClick(this.b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsPriceSubscriptionViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.price_subscription_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.price_subscription_text)");
        this.s = (TextView) findViewById;
    }

    @Override // com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionView
    public void showPriceSubscription(@NotNull AdvertDetailsPriceSubscriptionItem advertDetailsPriceSubscriptionItem, @NotNull AdvertDetailsPriceSubscriptionView.Listener listener) {
        Intrinsics.checkNotNullParameter(advertDetailsPriceSubscriptionItem, "item");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!advertDetailsPriceSubscriptionItem.isFavorite() || !advertDetailsPriceSubscriptionItem.getAreNotificationsEnabled()) {
            this.s.setText(R.string.price_subscription_item_on);
        } else {
            this.s.setText(R.string.price_subscription_item_off);
        }
        this.s.setOnClickListener(new a(listener, advertDetailsPriceSubscriptionItem));
    }
}
