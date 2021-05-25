package com.avito.android.advert.item.safedeal.info;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert.item.safedeal.info.AdvertDetailsSafeDealInfoView;
import com.avito.android.advert_details.R;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.SafeDeal;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoView;", "Lcom/avito/android/remote/model/SafeDeal$Info;", "info", "Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoView$Router;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showSafeDealInfoBlock", "(Lcom/avito/android/remote/model/SafeDeal$Info;Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoView$Router;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSafeDealInfoViewImpl extends BaseViewHolder implements AdvertDetailsSafeDealInfoView {
    public final TextView s;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SafeDeal.Info.OrderType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            SafeDeal.Info.OrderType orderType = SafeDeal.Info.OrderType.DELIVERY;
            iArr[0] = 1;
            SafeDeal.Info.OrderType orderType2 = SafeDeal.Info.OrderType.COURIER;
            iArr[1] = 2;
            SafeDeal.Info.OrderType orderType3 = SafeDeal.Info.OrderType.SAFE_DEAL;
            iArr[2] = 3;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DeepLink a;
        public final /* synthetic */ AdvertDetailsSafeDealInfoView.Router b;

        public a(DeepLink deepLink, AdvertDetailsSafeDealInfoViewImpl advertDetailsSafeDealInfoViewImpl, AdvertDetailsSafeDealInfoView.Router router) {
            this.a = deepLink;
            this.b = router;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.followInfoDeepLink(this.a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsSafeDealInfoViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.info_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
    }

    @Override // com.avito.android.advert.item.safedeal.info.AdvertDetailsSafeDealInfoView
    public void showSafeDealInfoBlock(@NotNull SafeDeal.Info info, @NotNull AdvertDetailsSafeDealInfoView.Router router) {
        Integer num;
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(router, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        SafeDeal.Info.OrderType orderType = info.getOrderType();
        if (orderType == null) {
            num = null;
        } else {
            int ordinal = orderType.ordinal();
            if (ordinal == 0) {
                num = Integer.valueOf(com.avito.android.advert_core.R.drawable.rds_delivery_24);
            } else if (ordinal == 1) {
                num = Integer.valueOf(com.avito.android.advert_core.R.drawable.rds_delivery_24);
            } else if (ordinal == 2) {
                num = Integer.valueOf(R.drawable.ic_card_24);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        TextViews.bindText$default(this.s, info.getTitle(), false, 2, null);
        if (num != null) {
            TextViews.setCompoundDrawables$default(this.s, 0, 0, num.intValue(), 0, 11, (Object) null);
        }
        DeepLink deeplink = info.getDeeplink();
        if (deeplink != null) {
            this.s.setOnClickListener(new a(deeplink, this, router));
        }
    }
}
