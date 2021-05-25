package com.avito.android.advert.item.cre_geo_report;

import com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PromoLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserPresenterImp;", "Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserPresenter;", "Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserView;", "view", "Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserView;Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserItem;I)V", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analytics", "Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserPresenter$Router;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserPresenter$Router;", "getRouter", "()Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserPresenter$Router;", "setRouter", "(Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserPresenter$Router;)V", "router", "<init>", "(Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGeoReportTeaserPresenterImp implements AdvertDetailsGeoReportTeaserPresenter {
    @Nullable
    public AdvertDetailsGeoReportTeaserPresenter.Router a;
    public final AdvertDetailsAnalyticsInteractor b;

    public static final class a extends Lambda implements Function1<Action, Unit> {
        public final /* synthetic */ AdvertDetailsGeoReportTeaserPresenterImp a;
        public final /* synthetic */ AdvertDetailsGeoReportTeaserItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertDetailsGeoReportTeaserPresenterImp advertDetailsGeoReportTeaserPresenterImp, AdvertDetailsGeoReportTeaserItem advertDetailsGeoReportTeaserItem) {
            super(1);
            this.a = advertDetailsGeoReportTeaserPresenterImp;
            this.b = advertDetailsGeoReportTeaserItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Action action) {
            Action action2 = action;
            Intrinsics.checkNotNullParameter(action2, "it");
            AdvertDetailsGeoReportTeaserPresenterImp.access$onActionClicked(this.a, action2, this.b.getAdvertId());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AdvertDetailsGeoReportTeaserPresenterImp(@NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analytics");
        this.b = advertDetailsAnalyticsInteractor;
    }

    public static final void access$onActionClicked(AdvertDetailsGeoReportTeaserPresenterImp advertDetailsGeoReportTeaserPresenterImp, Action action, String str) {
        Objects.requireNonNull(advertDetailsGeoReportTeaserPresenterImp);
        String type = action.getType();
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != -1015263653) {
                if (hashCode == 1498103 && type.equals(AdvertDetailsGeoReportTeaserItem.TYPE_BUY)) {
                    advertDetailsGeoReportTeaserPresenterImp.b.trackBuyGeoReportEvent(str);
                }
            } else if (type.equals(AdvertDetailsGeoReportTeaserItem.TYPE_EXAMPLE)) {
                advertDetailsGeoReportTeaserPresenterImp.b.trackShowGeoReportExampleEvent(str);
            }
        }
        DeepLink deepLink = action.getDeepLink();
        if (deepLink instanceof PromoLink) {
            deepLink = new PromoLink(((PromoLink) deepLink).getExtendedUrl(), true);
        }
        AdvertDetailsGeoReportTeaserPresenter.Router router = advertDetailsGeoReportTeaserPresenterImp.getRouter();
        if (router != null) {
            router.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenter
    @Nullable
    public AdvertDetailsGeoReportTeaserPresenter.Router getRouter() {
        return this.a;
    }

    @Override // com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenter
    public void setRouter(@Nullable AdvertDetailsGeoReportTeaserPresenter.Router router) {
        this.a = router;
    }

    public void bindView(@NotNull AdvertDetailsGeoReportTeaserView advertDetailsGeoReportTeaserView, @NotNull AdvertDetailsGeoReportTeaserItem advertDetailsGeoReportTeaserItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsGeoReportTeaserView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsGeoReportTeaserItem, "item");
        advertDetailsGeoReportTeaserView.showTitle(advertDetailsGeoReportTeaserItem.getTitle());
        advertDetailsGeoReportTeaserView.showButtons(advertDetailsGeoReportTeaserItem.getActions(), new a(this, advertDetailsGeoReportTeaserItem));
        advertDetailsGeoReportTeaserView.showInsights(advertDetailsGeoReportTeaserItem.getInsights());
        advertDetailsGeoReportTeaserView.showResult();
    }
}
