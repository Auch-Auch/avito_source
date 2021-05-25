package com.avito.android.advert;

import a2.a.a.f.d;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.advert.AdvertDetailsInteractor;
import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert.item.commercials.PositionedBannerContainer;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.module.AdvertId;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdNetworkBannerItem;
import com.avito.android.remote.model.AdSize;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.DeliveryInfoResponse;
import com.avito.android.remote.model.PositionedCommercialCascade;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.advert_details.commercials.AdvertCommercialsResponse;
import com.avito.android.remote.model.section.SectionResponse;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.avito.android.serp.adapter.SerpCommercialBannerKt;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.Observables;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B]\b\u0007\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0001\u0010=\u001a\u00020:\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020*¢\u0006\u0004\b>\u0010?J3\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\tR\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/avito/android/advert/AdvertDetailsInteractorImpl;", "Lcom/avito/android/advert/AdvertDetailsInteractor;", "", "context", "requestId", "marketplaceLocationId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsWithMeta;", "getAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/section/SectionResponse;", "getComplementaryItems", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "", "Lcom/avito/android/advert/item/commercials/PositionedBannerContainer;", "getCommercials", "(Lcom/avito/android/remote/model/AdvertDetails;)Lio/reactivex/rxjava3/core/Observable;", "locationIdFrom", "locationIdTo", "Lcom/avito/android/remote/model/DeliveryInfoResponse;", "getDeliveryInfo", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "api", "Lcom/avito/android/serp/CommercialBannersInteractor;", "c", "Lcom/avito/android/serp/CommercialBannersInteractor;", "bannersInteractor", "Lcom/avito/android/html_formatter/HtmlCleaner;", "i", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "j", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "htmlRenderOptions", "Lcom/avito/android/rec/ScreenSource;", "f", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "Lcom/avito/android/html_formatter/HtmlRenderer;", "h", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "Lcom/avito/android/Features;", g.a, "Lcom/avito/android/Features;", "features", "", "e", "Z", "isTablet", "<init>", "(Ljava/lang/String;Lcom/avito/android/advert_details/remote/AdvertDetailsApi;Lcom/avito/android/serp/CommercialBannersInteractor;Lcom/avito/android/util/SchedulersFactory3;ZLcom/avito/android/rec/ScreenSource;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlRenderer;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlRenderOptions;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsInteractorImpl implements AdvertDetailsInteractor {
    public final String a;
    public final AdvertDetailsApi b;
    public final CommercialBannersInteractor c;
    public final SchedulersFactory3 d;
    public final boolean e;
    public final ScreenSource f;
    public final Features g;
    public final HtmlRenderer h;
    public final HtmlCleaner i;
    public final HtmlRenderOptions j;

    public static final class b<T, R> implements Function<AdvertCommercialsResponse, ObservableSource<? extends List<? extends PositionedBannerContainer>>> {
        public final /* synthetic */ AdvertDetailsInteractorImpl a;
        public final /* synthetic */ AdvertDetails b;

        public b(AdvertDetailsInteractorImpl advertDetailsInteractorImpl, AdvertDetails advertDetails) {
            this.a = advertDetailsInteractorImpl;
            this.b = advertDetails;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends List<? extends PositionedBannerContainer>> apply(AdvertCommercialsResponse advertCommercialsResponse) {
            AdvertCommercialsResponse advertCommercialsResponse2 = advertCommercialsResponse;
            List<PositionedCommercialCascade> positions = advertCommercialsResponse2.getPositions();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(positions, 10));
            Iterator<T> it = positions.iterator();
            while (it.hasNext()) {
                AdvertDetailsInteractorImpl advertDetailsInteractorImpl = this.a;
                arrayList.add(AdvertDetailsInteractorImpl.access$load(advertDetailsInteractorImpl, it.next(), this.b, advertDetailsInteractorImpl.c.getPageCdtm(), advertCommercialsResponse2.getEnableEventSampling()));
            }
            return Observables.combineLatest(arrayList, a2.a.a.f.a.a);
        }
    }

    public static final class c<T, R> implements Function<Throwable, SectionResponse> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SectionResponse apply(Throwable th) {
            return new SectionResponse(CollectionsKt__CollectionsKt.emptyList(), null);
        }
    }

    @Inject
    public AdvertDetailsInteractorImpl(@AdvertId @NotNull String str, @NotNull AdvertDetailsApi advertDetailsApi, @NotNull CommercialBannersInteractor commercialBannersInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @AdvertFragmentModule.IsTablet boolean z, @NotNull ScreenSource screenSource, @NotNull Features features, @NotNull HtmlRenderer htmlRenderer, @NotNull HtmlCleaner htmlCleaner, @NotNull HtmlRenderOptions htmlRenderOptions) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(advertDetailsApi, "api");
        Intrinsics.checkNotNullParameter(commercialBannersInteractor, "bannersInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(screenSource, "screenSource");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlRenderer, "htmlRenderer");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(htmlRenderOptions, "htmlRenderOptions");
        this.a = str;
        this.b = advertDetailsApi;
        this.c = commercialBannersInteractor;
        this.d = schedulersFactory3;
        this.e = z;
        this.f = screenSource;
        this.g = features;
        this.h = htmlRenderer;
        this.i = htmlCleaner;
        this.j = htmlRenderOptions;
    }

    public static final Observable access$createAdvertDetailsMetaIfNeeded(AdvertDetailsInteractorImpl advertDetailsInteractorImpl, AdvertDetails advertDetails) {
        Objects.requireNonNull(advertDetailsInteractorImpl);
        String descriptionHtml = advertDetails.getDescriptionHtml();
        Observable just = Observable.just(new AdvertDetailsInteractor.AdvertDetailsWithMeta(advertDetails, new AdvertDetailsInteractor.AdvertDetailsMeta(descriptionHtml != null ? advertDetailsInteractorImpl.h.fromHtml(advertDetailsInteractorImpl.i.cleanHtml(descriptionHtml), advertDetailsInteractorImpl.j) : null)));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(\n       …)\n            )\n        )");
        return just;
    }

    public static final Observable access$load(AdvertDetailsInteractorImpl advertDetailsInteractorImpl, PositionedCommercialCascade positionedCommercialCascade, AdvertDetails advertDetails, long j2, boolean z) {
        Objects.requireNonNull(advertDetailsInteractorImpl);
        List<SerpElement> banners = positionedCommercialCascade.getBanners();
        ArrayList arrayList = new ArrayList();
        for (T t : banners) {
            if (t instanceof AdNetworkBannerItem) {
                arrayList.add(t);
            }
        }
        if (arrayList.isEmpty()) {
            Observable just = Observable.just(CollectionsKt__CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(emptyList())");
            return just;
        }
        CommercialBanner commercialBanner = new CommercialBanner(a2.b.a.a.a.I2("UUID.randomUUID().toString()"), arrayList, z, 0, null, 24, null);
        SerpCommercialBanner serpCommercialBanner = SerpCommercialBannerKt.toSerpCommercialBanner(commercialBanner, AdSize.BIG);
        CommercialBannersInteractor commercialBannersInteractor = advertDetailsInteractorImpl.c;
        String str = null;
        String categoryId = advertDetails != null ? advertDetails.getCategoryId() : null;
        if (advertDetails != null) {
            str = advertDetails.getLocationId();
        }
        Observable<R> onErrorReturnItem = commercialBannersInteractor.loadBanner(commercialBanner, j2, categoryId, str).subscribeOn(advertDetailsInteractorImpl.d.io()).map(new a2.a.a.f.b(serpCommercialBanner)).startWithItem(serpCommercialBanner).map(new a2.a.a.f.c(positionedCommercialCascade)).onErrorReturnItem((R) CollectionsKt__CollectionsKt.emptyList());
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "bannersInteractor.loadBa…orReturnItem(emptyList())");
        return onErrorReturnItem;
    }

    @Override // com.avito.android.advert.AdvertDetailsInteractor
    @NotNull
    public Observable<AdvertDetailsInteractor.AdvertDetailsWithMeta> getAdvertDetails(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        Observable<AdvertDetails> observable;
        if (this.g.getSupportApiItemsV16().invoke().booleanValue()) {
            observable = this.b.getAdvertDetails(this.a, str, str2, str3);
        } else {
            observable = this.b.getAdvertDetailsV15(this.a, str, str2, str3);
        }
        return a2.b.a.a.a.a2(this.d, observable.observeOn(this.d.computation()).flatMap(new d(new Function1<AdvertDetails, Observable<AdvertDetailsInteractor.AdvertDetailsWithMeta>>(this) { // from class: com.avito.android.advert.AdvertDetailsInteractorImpl.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Observable<AdvertDetailsInteractor.AdvertDetailsWithMeta> invoke(AdvertDetails advertDetails) {
                AdvertDetails advertDetails2 = advertDetails;
                Intrinsics.checkNotNullParameter(advertDetails2, "p1");
                return AdvertDetailsInteractorImpl.access$createAdvertDetailsMetaIfNeeded((AdvertDetailsInteractorImpl) this.receiver, advertDetails2);
            }
        })), "if (features.supportApiI…n(schedulersFactory.io())");
    }

    @Override // com.avito.android.advert.AdvertDetailsInteractor
    @NotNull
    public Observable<List<PositionedBannerContainer>> getCommercials(@Nullable AdvertDetails advertDetails) {
        if (!this.g.getCommercialsOnAdvertisement().invoke().booleanValue() || this.e) {
            Observable<List<PositionedBannerContainer>> just = Observable.just(CollectionsKt__CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(emptyList())");
            return just;
        }
        return a2.b.a.a.a.a2(this.d, TypedObservablesKt.toTyped(this.b.getCommercials(this.a)).flatMap(new b(this, advertDetails)).onErrorReturnItem(CollectionsKt__CollectionsKt.emptyList()).defaultIfEmpty(CollectionsKt__CollectionsKt.emptyList()), "api.getCommercials(adver…n(schedulersFactory.io())");
    }

    @Override // com.avito.android.advert.AdvertDetailsInteractor
    @NotNull
    public Observable<SectionResponse> getComplementaryItems() {
        return a2.b.a.a.a.a2(this.d, this.b.getComplementaryItems(this.a, this.f.getSource()).onErrorReturn(c.a), "request\n            .onE…n(schedulersFactory.io())");
    }

    @Override // com.avito.android.advert.AdvertDetailsInteractor
    @NotNull
    public Observable<DeliveryInfoResponse> getDeliveryInfo(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        Observable<TypedResult<DeliveryInfoResponse>> observable;
        if (this.g.getDeliveryInfoOptionalMapAction().invoke().booleanValue()) {
            observable = this.b.getDeliveryInfoWithOptionalAction(this.a, str, str2, str3);
        } else {
            observable = this.b.getDeliveryInfo(this.a, str, str2, str3);
        }
        return a2.b.a.a.a.a2(this.d, TypedObservablesKt.toTyped(observable), "if (features.deliveryInf…n(schedulersFactory.io())");
    }
}
