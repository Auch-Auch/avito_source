package com.avito.android.serp;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdNetworkBanner;
import com.avito.android.remote.model.AdNetworkBannerItem;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.remote.model.LoadedNetworkBanner;
import com.avito.android.remote.model.MyTargetBannerItem;
import com.avito.android.remote.model.YandexBannerItem;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.ad.DfpBannerLoader;
import com.avito.android.serp.ad.MyTargetBannerLoader;
import com.avito.android.serp.ad.YandexBannerLoader;
import com.avito.android.util.SchedulersFactory3;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0015BC\b\u0007\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\b\b\u0002\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b6\u00107J9\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u0006038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u00104¨\u00068"}, d2 = {"Lcom/avito/android/serp/CommercialBannersInteractorImpl;", "Lcom/avito/android/serp/CommercialBannersInteractor;", "Lcom/avito/android/remote/model/CommercialBanner;", "banner", "", "pageCdtm", "", "categoryId", "locationId", "Lio/reactivex/rxjava3/core/Observable;", "loadBanner", "(Lcom/avito/android/remote/model/CommercialBanner;JLjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "getPageCdtm", "()J", "", "Lcom/avito/android/remote/model/AdNetworkBannerItem;", "bannerItems", "", FirebaseAnalytics.Param.INDEX, "Lcom/avito/android/serp/CommercialBannersInteractorImpl$a;", "loadInfo", AuthSource.SEND_ABUSE, "(Ljava/util/List;ILcom/avito/android/serp/CommercialBannersInteractorImpl$a;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/SchedulersFactory3;", g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/serp/ad/MyTargetBannerLoader;", "d", "Lcom/avito/android/serp/ad/MyTargetBannerLoader;", "myTargetBannerLoader", "Lcom/avito/android/serp/BannerInfoFactory;", "h", "Lcom/avito/android/serp/BannerInfoFactory;", "bannerInfoFactory", "Lcom/avito/android/serp/CommercialBannerTimeProvider;", "f", "Lcom/avito/android/serp/CommercialBannerTimeProvider;", "timeProvider", "Lcom/avito/android/serp/ad/YandexBannerLoader;", "c", "Lcom/avito/android/serp/ad/YandexBannerLoader;", "yandexBannerLoader", "Lcom/avito/android/serp/ad/DfpBannerLoader;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/ad/DfpBannerLoader;", "dfpBannerLoader", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "e", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "analyticsInteractor", "", "Ljava/util/Set;", "loadingIds", "<init>", "(Lcom/avito/android/serp/ad/DfpBannerLoader;Lcom/avito/android/serp/ad/YandexBannerLoader;Lcom/avito/android/serp/ad/MyTargetBannerLoader;Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;Lcom/avito/android/serp/CommercialBannerTimeProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/serp/BannerInfoFactory;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class CommercialBannersInteractorImpl implements CommercialBannersInteractor {
    public final Set<String> a;
    public final DfpBannerLoader b;
    public final YandexBannerLoader c;
    public final MyTargetBannerLoader d;
    public final CommercialBannersAnalyticsInteractor e;
    public final CommercialBannerTimeProvider f;
    public final SchedulersFactory3 g;
    public final BannerInfoFactory h;

    public static final class a {
        @NotNull
        public final CommercialBanner a;
        @Nullable
        public final String b;
        @Nullable
        public final String c;
        public final long d;
        public final boolean e;

        public a(@NotNull CommercialBanner commercialBanner, @Nullable String str, @Nullable String str2, long j, boolean z) {
            Intrinsics.checkNotNullParameter(commercialBanner, "banner");
            this.a = commercialBanner;
            this.b = str;
            this.c = str2;
            this.d = j;
            this.e = z;
        }
    }

    public static final class b<T> implements Consumer<CommercialBanner> {
        public final /* synthetic */ CommercialBannersInteractorImpl a;
        public final /* synthetic */ BannerInfo b;
        public final /* synthetic */ a c;

        public b(CommercialBannersInteractorImpl commercialBannersInteractorImpl, BannerInfo bannerInfo, a aVar) {
            this.a = commercialBannersInteractorImpl;
            this.b = bannerInfo;
            this.c = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(CommercialBanner commercialBanner) {
            CommercialBannersInteractorImpl.access$sendBannerLoaded(this.a, this.b, this.c);
        }
    }

    public static final class c<T, R> implements Function<Throwable, ObservableSource<? extends CommercialBanner>> {
        public final /* synthetic */ CommercialBannersInteractorImpl a;
        public final /* synthetic */ BannerInfo b;
        public final /* synthetic */ a c;
        public final /* synthetic */ int d;
        public final /* synthetic */ List e;

        public c(CommercialBannersInteractorImpl commercialBannersInteractorImpl, BannerInfo bannerInfo, a aVar, int i, List list) {
            this.a = commercialBannersInteractorImpl;
            this.b = bannerInfo;
            this.c = aVar;
            this.d = i;
            this.e = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends CommercialBanner> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            CommercialBannersInteractorImpl.access$sendBannerLoadingFailed(this.a, this.b, this.c, th2, this.d == CollectionsKt__CollectionsKt.getLastIndex(this.e));
            return this.a.a(this.e, this.d + 1, this.c);
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ CommercialBannersInteractorImpl a;
        public final /* synthetic */ CommercialBanner b;

        public d(CommercialBannersInteractorImpl commercialBannersInteractorImpl, CommercialBanner commercialBanner) {
            this.a = commercialBannersInteractorImpl;
            this.b = commercialBanner;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.a.remove(this.b.getUniqueId());
        }
    }

    @Inject
    public CommercialBannersInteractorImpl(@NotNull DfpBannerLoader dfpBannerLoader, @NotNull YandexBannerLoader yandexBannerLoader, @NotNull MyTargetBannerLoader myTargetBannerLoader, @NotNull CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, @NotNull CommercialBannerTimeProvider commercialBannerTimeProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull BannerInfoFactory bannerInfoFactory) {
        Intrinsics.checkNotNullParameter(dfpBannerLoader, "dfpBannerLoader");
        Intrinsics.checkNotNullParameter(yandexBannerLoader, "yandexBannerLoader");
        Intrinsics.checkNotNullParameter(myTargetBannerLoader, "myTargetBannerLoader");
        Intrinsics.checkNotNullParameter(commercialBannersAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(commercialBannerTimeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(bannerInfoFactory, "bannerInfoFactory");
        this.b = dfpBannerLoader;
        this.c = yandexBannerLoader;
        this.d = myTargetBannerLoader;
        this.e = commercialBannersAnalyticsInteractor;
        this.f = commercialBannerTimeProvider;
        this.g = schedulersFactory3;
        this.h = bannerInfoFactory;
        this.a = new HashSet();
    }

    public static final CommercialBanner access$createCommercialBanner(CommercialBannersInteractorImpl commercialBannersInteractorImpl, String str, AdNetworkBanner adNetworkBanner, int i, a aVar) {
        Objects.requireNonNull(commercialBannersInteractorImpl);
        return aVar.a.copy(aVar.d, new LoadedNetworkBanner(str, adNetworkBanner, i, commercialBannersInteractorImpl.f.getTimestamp(), false, 16, null));
    }

    public static final void access$sendBannerLoaded(CommercialBannersInteractorImpl commercialBannersInteractorImpl, BannerInfo bannerInfo, a aVar) {
        CommercialBannersAnalyticsInteractor.DefaultImpls.sendBannerLoaded$default(commercialBannersInteractorImpl.e, bannerInfo, aVar.b, aVar.c, null, aVar.e, null, 32, null);
    }

    public static final void access$sendBannerLoadingFailed(CommercialBannersInteractorImpl commercialBannersInteractorImpl, BannerInfo bannerInfo, a aVar, Throwable th, boolean z) {
        Objects.requireNonNull(commercialBannersInteractorImpl);
        if (z) {
            CommercialBannersAnalyticsInteractor.DefaultImpls.sendBannerLoadingFailed$default(commercialBannersInteractorImpl.e, bannerInfo, aVar.b, aVar.c, th, null, null, null, 96, null);
        } else if (aVar.e) {
            CommercialBannersAnalyticsInteractor.DefaultImpls.sendBannerPassback$default(commercialBannersInteractorImpl.e, bannerInfo, null, 2, null);
        }
    }

    public final Observable<CommercialBanner> a(List<? extends AdNetworkBannerItem<?>> list, int i, a aVar) {
        Observable<R> observable;
        AdNetworkBannerItem<?> adNetworkBannerItem = (AdNetworkBannerItem) CollectionsKt___CollectionsKt.getOrNull(list, i);
        if (adNetworkBannerItem == null) {
            Observable<CommercialBanner> error = Observable.error(new CommercialBannerNotLoadedException());
            Intrinsics.checkNotNullExpressionValue(error, "Observable.error(Commerc…nnerNotLoadedException())");
            return error;
        }
        BannerInfo create = this.h.create(adNetworkBannerItem, aVar.d, i, aVar.e);
        if (aVar.e) {
            CommercialBannersAnalyticsInteractor.DefaultImpls.sendBannerRequested$default(this.e, create, null, 2, null);
        }
        boolean z = true;
        if (adNetworkBannerItem instanceof DfpBannerItem) {
            DfpBannerItem dfpBannerItem = (DfpBannerItem) adNetworkBannerItem;
            DfpBannerLoader dfpBannerLoader = this.b;
            if (i == 0) {
                z = false;
            }
            observable = dfpBannerLoader.loadBanner(dfpBannerItem, z).subscribeOn(this.g.io()).map(new a2.a.a.n2.a(this, dfpBannerItem, i, aVar));
            Intrinsics.checkNotNullExpressionValue(observable, "dfpBannerLoader.loadBann…d, it, index, loadInfo) }");
        } else if (adNetworkBannerItem instanceof YandexBannerItem) {
            YandexBannerItem yandexBannerItem = (YandexBannerItem) adNetworkBannerItem;
            YandexBannerLoader yandexBannerLoader = this.c;
            if (i == 0) {
                z = false;
            }
            observable = yandexBannerLoader.loadBanner(yandexBannerItem, z).subscribeOn(this.g.io()).map(new a2.a.a.n2.b(this, yandexBannerItem, i, aVar));
            Intrinsics.checkNotNullExpressionValue(observable, "yandexBannerLoader.loadB…d, it, index, loadInfo) }");
        } else if (adNetworkBannerItem instanceof MyTargetBannerItem) {
            MyTargetBannerItem myTargetBannerItem = (MyTargetBannerItem) adNetworkBannerItem;
            MyTargetBannerLoader myTargetBannerLoader = this.d;
            if (i == 0) {
                z = false;
            }
            observable = myTargetBannerLoader.loadBanner(myTargetBannerItem, z).subscribeOn(this.g.io()).map(new a2.a.a.n2.c(this, myTargetBannerItem, i, aVar));
            Intrinsics.checkNotNullExpressionValue(observable, "myTargetBannerLoader.loa…), it, index, loadInfo) }");
        } else {
            observable = Observable.error(new IllegalArgumentException("Not supported SerpBanner type: " + this));
        }
        Observable<CommercialBanner> onErrorResumeNext = observable.doOnNext(new b(this, create, aVar)).onErrorResumeNext(new c(this, create, aVar, i, list));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "when (banner) {\n        …adInfo)\n                }");
        return onErrorResumeNext;
    }

    @Override // com.avito.android.serp.CommercialBannersInteractor
    public long getPageCdtm() {
        return this.f.getTimestamp();
    }

    @Override // com.avito.android.serp.CommercialBannersInteractor
    @NotNull
    public Observable<CommercialBanner> loadBanner(@NotNull CommercialBanner commercialBanner, long j, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(commercialBanner, "banner");
        if (commercialBanner.isLoaded()) {
            Observable<CommercialBanner> just = Observable.just(commercialBanner);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(banner)");
            return just;
        } else if (this.a.contains(commercialBanner.getUniqueId())) {
            Observable<CommercialBanner> empty = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
            return empty;
        } else {
            this.a.add(commercialBanner.getUniqueId());
            Observable<CommercialBanner> doFinally = a(commercialBanner.getAdNetworkBannerItems(), 0, new a(commercialBanner, str, str2, j, commercialBanner.getSamplingEnabled())).doFinally(new d(this, commercialBanner));
            Intrinsics.checkNotNullExpressionValue(doFinally, "loadAdNetworkBanner(bann…r.uniqueId)\n            }");
            return doFinally;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommercialBannersInteractorImpl(DfpBannerLoader dfpBannerLoader, YandexBannerLoader yandexBannerLoader, MyTargetBannerLoader myTargetBannerLoader, CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, CommercialBannerTimeProvider commercialBannerTimeProvider, SchedulersFactory3 schedulersFactory3, BannerInfoFactory bannerInfoFactory, int i, j jVar) {
        this(dfpBannerLoader, yandexBannerLoader, myTargetBannerLoader, commercialBannersAnalyticsInteractor, commercialBannerTimeProvider, schedulersFactory3, (i & 64) != 0 ? new BannerInfoFactoryImpl() : bannerInfoFactory);
    }
}
