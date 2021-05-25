package com.avito.android.advert.item.safedeal.button;

import android.view.View;
import com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.remote.model.SafeDeal;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/item/safedeal/button/AdvertDetailsSafeDealButtonViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/safedeal/button/AdvertDetailsSafeDealButtonView;", "Lcom/avito/android/remote/model/SafeDeal;", "safeDeal", "Lcom/avito/android/advert/item/safedeal/button/AdvertDetailsSafeDealButtonView$Router;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showButton", "(Lcom/avito/android/remote/model/SafeDeal;Lcom/avito/android/advert/item/safedeal/button/AdvertDetailsSafeDealButtonView$Router;)V", "Lcom/avito/android/lib/design/button/Button;", "s", "Lcom/avito/android/lib/design/button/Button;", "buyButton", "<init>", "(Lcom/avito/android/lib/design/button/Button;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSafeDealButtonViewImpl extends BaseViewHolder implements AdvertDetailsSafeDealButtonView {
    public final Button s;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            SafeDeal.Button.Style.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            SafeDeal.Button.Style style = SafeDeal.Button.Style.PRIMARY;
            iArr[0] = 1;
            SafeDeal.Button.Style style2 = SafeDeal.Button.Style.SECONDARY;
            iArr[1] = 2;
            SafeDeal.Button.Style style3 = SafeDeal.Button.Style.DEFAULT;
            iArr[2] = 3;
            SafeDeal.Button.Icon.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            SafeDeal.Button.Icon icon = SafeDeal.Button.Icon.DELIVERY;
            iArr2[0] = 1;
            SafeDeal.Button.Icon icon2 = SafeDeal.Button.Icon.COURIER;
            iArr2[1] = 2;
            SafeDeal.Button.Icon icon3 = SafeDeal.Button.Icon.SAFE_DEAL;
            iArr2[2] = 3;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DeepLink a;
        public final /* synthetic */ SafeDeal b;
        public final /* synthetic */ AdvertDetailsSafeDealButtonView.Router c;

        public a(DeepLink deepLink, Button button, AdvertDetailsSafeDealButtonViewImpl advertDetailsSafeDealButtonViewImpl, SafeDeal safeDeal, AdvertDetailsSafeDealButtonView.Router router) {
            this.a = deepLink;
            this.b = safeDeal;
            this.c = router;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.c.followButtonDeepLink(this.a, this.b.getFormattedOrderTypes());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsSafeDealButtonViewImpl(@NotNull Button button) {
        super(button);
        Intrinsics.checkNotNullParameter(button, "buyButton");
        this.s = button;
    }

    @Override // com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonView
    public void showButton(@NotNull SafeDeal safeDeal, @NotNull AdvertDetailsSafeDealButtonView.Router router) {
        Intrinsics.checkNotNullParameter(safeDeal, "safeDeal");
        Intrinsics.checkNotNullParameter(router, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Button button = this.s;
        SafeDeal.Button button2 = safeDeal.getButton();
        if (button2 != null) {
            SafeDeal.Button.Style style = button2.getStyle();
            if (style == null) {
                button.setAppearanceFromAttr(R.attr.buttonPrimaryLarge);
            } else {
                int ordinal = style.ordinal();
                if (ordinal == 0) {
                    button.setAppearanceFromAttr(R.attr.buttonPrimaryLarge);
                } else if (ordinal == 1) {
                    button.setAppearanceFromAttr(R.attr.buttonSecondaryLarge);
                } else if (ordinal == 2) {
                    button.setAppearanceFromAttr(R.attr.buttonDefaultLarge);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            ButtonsKt.bindText$default(button, button2.getTitle(), false, 2, null);
            SafeDeal.Button.Icon icon = button2.getIcon();
            if (icon == null) {
                Button.setImageResource$default(button, 0, 0, 3, null);
            } else {
                int ordinal2 = icon.ordinal();
                if (ordinal2 == 0) {
                    Button.setImageResource$default(button, com.avito.android.ui_components.R.drawable.ic_rds_delivery_black_20, 0, 2, null);
                } else if (ordinal2 == 1) {
                    Button.setImageResource$default(button, 0, 0, 3, null);
                } else if (ordinal2 == 2) {
                    Button.setImageResource$default(button, 0, 0, 3, null);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            DeepLink deeplink = button2.getDeeplink();
            if (deeplink != null) {
                button.setOnClickListener(new a(deeplink, button, this, safeDeal, router));
            } else {
                Views.disable(this.s);
            }
        }
    }
}
