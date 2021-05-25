package com.avito.android.advert.item.safedeal.button.legacy;

import android.view.View;
import com.avito.android.advert.item.safedeal.button.legacy.AdvertDetailsSafeDealLegacyButtonView;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.remote.model.SafeDeal;
import com.avito.android.remote.model.SafeDealAction;
import com.avito.android.ui_components.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonView;", "Lcom/avito/android/remote/model/SafeDeal$Actions;", "actions", "Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonView$Router;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showLegacyButton", "(Lcom/avito/android/remote/model/SafeDeal$Actions;Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonView$Router;)V", "Lcom/avito/android/lib/design/button/Button;", "s", "Lcom/avito/android/lib/design/button/Button;", "buyButton", "<init>", "(Lcom/avito/android/lib/design/button/Button;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSafeDealLegacyButtonViewImpl extends BaseViewHolder implements AdvertDetailsSafeDealLegacyButtonView {
    public final Button s;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SafeDealAction a;
        public final /* synthetic */ SafeDeal.Actions b;
        public final /* synthetic */ AdvertDetailsSafeDealLegacyButtonView.Router c;

        public a(SafeDealAction safeDealAction, SafeDeal.Actions actions, AdvertDetailsSafeDealLegacyButtonView.Router router) {
            this.a = safeDealAction;
            this.b = actions;
            this.c = router;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.c.followLegacyButtonDeepLink(this.a.getDeepLink(), this.b.getFormattedOrderTypes());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsSafeDealLegacyButtonViewImpl(@NotNull Button button) {
        super(button);
        Intrinsics.checkNotNullParameter(button, "buyButton");
        this.s = button;
    }

    @Override // com.avito.android.advert.item.safedeal.button.legacy.AdvertDetailsSafeDealLegacyButtonView
    public void showLegacyButton(@NotNull SafeDeal.Actions actions, @NotNull AdvertDetailsSafeDealLegacyButtonView.Router router) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(router, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Button button = this.s;
        SafeDealAction buyButton = actions.getBuyButton();
        if (buyButton != null) {
            String icon = buyButton.getIcon();
            if (icon != null && icon.hashCode() == 823466996 && icon.equals("delivery")) {
                Button.setImageResource$default(button, R.drawable.ic_rds_delivery_black_20, 0, 2, null);
            }
            ButtonsKt.bindText$default(button, buyButton.getTitle(), false, 2, null);
            button.setOnClickListener(new a(buyButton, actions, router));
        }
    }
}
