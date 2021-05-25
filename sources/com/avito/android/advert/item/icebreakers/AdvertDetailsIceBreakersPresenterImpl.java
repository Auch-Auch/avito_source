package com.avito.android.advert.item.icebreakers;

import com.avito.android.advert.item.AdvertDetailsRouter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.IceBreaker;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersPresenterImpl;", "Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersPresenter;", "Lcom/avito/android/advert/item/AdvertDetailsRouter;", "router", "", "attachRouter", "(Lcom/avito/android/advert/item/AdvertDetailsRouter;)V", "detachRouter", "()V", "Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersView;", "view", "Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersItem;", "item", "", VKApiConst.POSITION, "bindView", "(Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersView;Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersItem;I)V", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/AdvertDetailsRouter;", "<init>", "(Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsIceBreakersPresenterImpl implements AdvertDetailsIceBreakersPresenter {
    public AdvertDetailsRouter a;
    public final AdvertDetailsAnalyticsInteractor b;

    @Inject
    public AdvertDetailsIceBreakersPresenterImpl(@NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        this.b = advertDetailsAnalyticsInteractor;
    }

    @Override // com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersPresenter
    public void attachRouter(@NotNull AdvertDetailsRouter advertDetailsRouter) {
        Intrinsics.checkNotNullParameter(advertDetailsRouter, "router");
        this.a = advertDetailsRouter;
    }

    @Override // com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersPresenter
    public void detachRouter() {
        this.a = null;
    }

    public void bindView(@NotNull AdvertDetailsIceBreakersView advertDetailsIceBreakersView, @NotNull AdvertDetailsIceBreakersItem advertDetailsIceBreakersItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsIceBreakersView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsIceBreakersItem, "item");
        advertDetailsIceBreakersView.setIcebreakers(advertDetailsIceBreakersItem, new IcebreakersListener(this, advertDetailsIceBreakersItem, i) { // from class: com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersPresenterImpl$bindView$1
            public final /* synthetic */ AdvertDetailsIceBreakersPresenterImpl a;
            public final /* synthetic */ AdvertDetailsIceBreakersItem b;
            public final /* synthetic */ int c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // com.avito.android.advert.item.icebreakers.IcebreakersListener
            public void onIcebreakerClick(@NotNull IceBreaker iceBreaker, int i2) {
                Intrinsics.checkNotNullParameter(iceBreaker, "iceBreaker");
                AdvertDetailsRouter advertDetailsRouter = this.a.a;
                if (advertDetailsRouter != null) {
                    advertDetailsRouter.followDeepLink(iceBreaker.getLink());
                    this.a.b.sendClickOnIcebreaker(iceBreaker.getPreviewText(), i2, iceBreaker.getId());
                }
            }

            @Override // com.avito.android.advert.item.icebreakers.IcebreakersListener
            public void onShowIcebreakers() {
                StringBuilder sb = new StringBuilder();
                Iterator<T> it = this.b.getIcebreakers().getTexts().iterator();
                while (it.hasNext()) {
                    sb.append(it.next().getPreviewText());
                    sb.append(";");
                }
                AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor = this.a.b;
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "allTitles.toString()");
                int i2 = this.c;
                List<IceBreaker> texts = this.b.getIcebreakers().getTexts();
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(texts, 10));
                Iterator<T> it2 = texts.iterator();
                while (it2.hasNext()) {
                    arrayList.add(Integer.valueOf(it2.next().getId()));
                }
                advertDetailsAnalyticsInteractor.sendShowIcebreakersBlock(sb2, i2, arrayList);
            }
        });
    }
}
