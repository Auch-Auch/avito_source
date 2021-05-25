package com.avito.android.advert.item.auto_catalog;

import android.view.View;
import com.avito.android.advert.AdvertDetailsResourcesProvider;
import com.avito.android.advert.item.AdvertDetailsRouter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogPresenterImpl;", "Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogPresenter;", "Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogView;", "view", "Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogView;Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogItem;I)V", "Lcom/avito/android/advert/item/AdvertDetailsRouter;", "router", "setRouter", "(Lcom/avito/android/advert/item/AdvertDetailsRouter;)V", "Lcom/avito/android/advert/AdvertDetailsResourcesProvider;", "d", "Lcom/avito/android/advert/AdvertDetailsResourcesProvider;", "resourceProvider", "", AuthSource.BOOKING_ORDER, "Z", "isShowButtonSent", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/AdvertDetailsRouter;", "advertDetailsRouter", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "c", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "<init>", "(Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/advert/AdvertDetailsResourcesProvider;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAutoCatalogPresenterImpl implements AdvertDetailsAutoCatalogPresenter {
    public AdvertDetailsRouter a;
    public boolean b;
    public final AdvertDetailsAnalyticsInteractor c;
    public final AdvertDetailsResourcesProvider d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AdvertDetailsAutoCatalogPresenterImpl a;
        public final /* synthetic */ AdvertDetailsAutoCatalogItem b;
        public final /* synthetic */ DeepLink c;

        public a(AdvertDetailsAutoCatalogPresenterImpl advertDetailsAutoCatalogPresenterImpl, AdvertDetailsAutoCatalogItem advertDetailsAutoCatalogItem, DeepLink deepLink) {
            this.a = advertDetailsAutoCatalogPresenterImpl;
            this.b = advertDetailsAutoCatalogItem;
            this.c = deepLink;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.c.sendModelSpecificationsClick(this.b.getAdvertId(), AdvertDetailsAnalyticsInteractorKt.PAGE_TYPE_AUTO_CARD, false);
            AdvertDetailsAutoCatalogPresenterImpl.access$getAdvertDetailsRouter$p(this.a).followDeepLink(this.c);
        }
    }

    @Inject
    public AdvertDetailsAutoCatalogPresenterImpl(@NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull AdvertDetailsResourcesProvider advertDetailsResourcesProvider) {
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(advertDetailsResourcesProvider, "resourceProvider");
        this.c = advertDetailsAnalyticsInteractor;
        this.d = advertDetailsResourcesProvider;
    }

    public static final /* synthetic */ AdvertDetailsRouter access$getAdvertDetailsRouter$p(AdvertDetailsAutoCatalogPresenterImpl advertDetailsAutoCatalogPresenterImpl) {
        AdvertDetailsRouter advertDetailsRouter = advertDetailsAutoCatalogPresenterImpl.a;
        if (advertDetailsRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
        }
        return advertDetailsRouter;
    }

    @Override // com.avito.android.advert.item.auto_catalog.AdvertDetailsAutoCatalogPresenter
    public void setRouter(@NotNull AdvertDetailsRouter advertDetailsRouter) {
        Intrinsics.checkNotNullParameter(advertDetailsRouter, "router");
        this.a = advertDetailsRouter;
    }

    public void bindView(@NotNull AdvertDetailsAutoCatalogView advertDetailsAutoCatalogView, @NotNull AdvertDetailsAutoCatalogItem advertDetailsAutoCatalogItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsAutoCatalogView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsAutoCatalogItem, "item");
        DeepLink autoCatalogLink = advertDetailsAutoCatalogItem.getAutoCatalogLink();
        if (autoCatalogLink != null) {
            String advertId = advertDetailsAutoCatalogItem.getAdvertId();
            if (!this.b) {
                this.b = true;
                this.c.sendShowModelSpecificationButton(advertId, AdvertDetailsAnalyticsInteractorKt.PAGE_TYPE_AUTO_CARD);
            }
            advertDetailsAutoCatalogView.show(this.d.getAutoCatalogButtonTitle(), new a(this, advertDetailsAutoCatalogItem, autoCatalogLink));
            return;
        }
        advertDetailsAutoCatalogView.hide();
    }
}
