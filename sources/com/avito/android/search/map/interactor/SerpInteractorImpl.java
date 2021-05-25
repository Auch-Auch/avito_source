package com.avito.android.search.map.interactor;

import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.PageParams;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SerpBannerContainer;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpDisplayTypeKt;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.remote.model.search.map.AreaKt;
import com.avito.android.search.map.di.SerpList;
import com.avito.android.search.map.interactor.SerpInteractor;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.avito.android.serp.adapter.SerpCommercialBannerKt;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.util.LoadingState;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.util.DataSources;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BS\b\u0007\u0012\u0006\u0010J\u001a\u00020H\u0012\u0006\u00104\u001a\u000202\u0012\b\b\u0001\u0010?\u001a\u00020=\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u00101\u001a\u00020.¢\u0006\u0004\bK\u0010LJS\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010 JC\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020!2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b$\u0010%J/\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e\"\b\b\u0000\u0010'*\u00020&*\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010I¨\u0006M"}, d2 = {"Lcom/avito/android/search/map/interactor/SerpInteractorImpl;", "Lcom/avito/android/search/map/interactor/SerpInteractor;", "Lcom/avito/android/search/map/interactor/SerpKey;", "key", "", "nextPage", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "context", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/remote/model/search/map/Area;", "area", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/search/map/interactor/SerpInteractor$Result;", "loadSerp", "(Lcom/avito/android/search/map/interactor/SerpKey;ZLcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/remote/model/search/map/Area;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "itemsDataSource", "loadAds", "(Lcom/avito/konveyor/data_source/DataSource;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "serpKey", "", VKApiConst.POSITION, "Lio/reactivex/rxjava3/core/Completable;", "removeElement", "(Lcom/avito/android/search/map/interactor/SerpKey;I)Lio/reactivex/rxjava3/core/Completable;", "columns", AuthSource.SEND_ABUSE, "(Lcom/avito/android/search/map/interactor/SerpKey;I)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/PageParams;", "pageParams", "Lcom/avito/android/remote/model/SerpElementResult;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/remote/model/PageParams;Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/remote/model/search/map/Area;)Lio/reactivex/rxjava3/core/Observable;", "", "T", "c", "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/RandomKeyProvider;", "e", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "Lcom/avito/android/util/SchedulersFactory3;", "i", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/model/SearchParamsConverter;", "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsConverter", "Lcom/avito/android/search/map/interactor/MapViewPortProvider;", "h", "Lcom/avito/android/search/map/interactor/MapViewPortProvider;", "viewPortProvider", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", a2.g.r.g.a, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/serp/CommercialBannersInteractor;", "Lcom/avito/android/serp/CommercialBannersInteractor;", "commercialBannersInteractor", "Lcom/avito/android/search/map/interactor/SerpCacheInteractor;", "d", "Lcom/avito/android/search/map/interactor/SerpCacheInteractor;", "cacheInteractor", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "f", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "resourcesProvider", "Lcom/avito/android/remote/SearchApi;", "Lcom/avito/android/remote/SearchApi;", "api", "<init>", "(Lcom/avito/android/remote/SearchApi;Lcom/avito/android/remote/model/SearchParamsConverter;Lcom/avito/android/serp/CommercialBannersInteractor;Lcom/avito/android/search/map/interactor/SerpCacheInteractor;Lcom/avito/android/util/RandomKeyProvider;Lcom/avito/android/search/map/view/SerpListResourcesProvider;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/search/map/interactor/MapViewPortProvider;Lcom/avito/android/util/SchedulersFactory3;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SerpInteractorImpl implements SerpInteractor {
    public final SearchApi a;
    public final SearchParamsConverter b;
    public final CommercialBannersInteractor c;
    public final SerpCacheInteractor d;
    public final RandomKeyProvider e;
    public final SerpListResourcesProvider f;
    public final TypedErrorThrowableConverter g;
    public final MapViewPortProvider h;
    public final SchedulersFactory3 i;

    public static final class a<T> implements Predicate<ViewTypeSerpItem> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(ViewTypeSerpItem viewTypeSerpItem) {
            ViewTypeSerpItem viewTypeSerpItem2 = viewTypeSerpItem;
            return (viewTypeSerpItem2 instanceof SerpCommercialBanner) && ((SerpCommercialBanner) viewTypeSerpItem2).getHasNotLoadedAd();
        }
    }

    public static final class b<T, R> implements Function<ViewTypeSerpItem, SerpCommercialBanner> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SerpCommercialBanner apply(ViewTypeSerpItem viewTypeSerpItem) {
            ViewTypeSerpItem viewTypeSerpItem2 = viewTypeSerpItem;
            Objects.requireNonNull(viewTypeSerpItem2, "null cannot be cast to non-null type com.avito.android.serp.adapter.SerpCommercialBanner");
            return (SerpCommercialBanner) viewTypeSerpItem2;
        }
    }

    public static final class c<T, R> implements Function<SerpCommercialBanner, ObservableSource<? extends SerpCommercialBanner>> {
        public final /* synthetic */ SerpInteractorImpl a;
        public final /* synthetic */ long b;
        public final /* synthetic */ SearchParams c;

        public c(SerpInteractorImpl serpInteractorImpl, long j, SearchParams searchParams) {
            this.a = serpInteractorImpl;
            this.b = j;
            this.c = searchParams;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends SerpCommercialBanner> apply(SerpCommercialBanner serpCommercialBanner) {
            SerpCommercialBanner serpCommercialBanner2 = serpCommercialBanner;
            CommercialBanner commercialBanner = serpCommercialBanner2.getCommercialBanner();
            Objects.requireNonNull(commercialBanner, "null cannot be cast to non-null type com.avito.android.remote.model.CommercialBanner");
            return this.a.c.loadBanner(commercialBanner, this.b, this.c.getCategoryId(), this.c.getLocationId()).map(new a2.a.a.k2.b.f.b(serpCommercialBanner2)).onErrorReturn(new a2.a.a.k2.b.f.c(serpCommercialBanner2));
        }
    }

    public static final class d<T, R> implements Function<SerpCommercialBanner, ObservableSource<? extends ViewTypeSerpItem>> {
        public final /* synthetic */ SerpInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ SerpDisplayType c;

        public d(SerpInteractorImpl serpInteractorImpl, String str, SerpDisplayType serpDisplayType) {
            this.a = serpInteractorImpl;
            this.b = str;
            this.c = serpDisplayType;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends ViewTypeSerpItem> apply(SerpCommercialBanner serpCommercialBanner) {
            SerpCommercialBanner serpCommercialBanner2 = serpCommercialBanner;
            SerpCacheInteractor serpCacheInteractor = this.a.d;
            Intrinsics.checkNotNullExpressionValue(serpCommercialBanner2, "it");
            return serpCacheInteractor.replaceAds(serpCommercialBanner2, this.b, this.c);
        }
    }

    public static final class e<T, R> implements Function<SerpElementResult, ObservableSource<? extends SerpInteractor.Result>> {
        public final /* synthetic */ SerpInteractorImpl a;
        public final /* synthetic */ SerpKey b;
        public final /* synthetic */ PageParams c;

        public e(SerpInteractorImpl serpInteractorImpl, SerpKey serpKey, PageParams pageParams) {
            this.a = serpInteractorImpl;
            this.b = serpKey;
            this.c = pageParams;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0028, code lost:
            if (r1 != null) goto L_0x004a;
         */
        @Override // io.reactivex.rxjava3.functions.Function
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.reactivex.rxjava3.core.ObservableSource<? extends com.avito.android.search.map.interactor.SerpInteractor.Result> apply(com.avito.android.remote.model.SerpElementResult r13) {
            /*
                r12 = this;
                r2 = r13
                com.avito.android.remote.model.SerpElementResult r2 = (com.avito.android.remote.model.SerpElementResult) r2
                com.avito.android.search.map.interactor.SerpInteractorImpl r13 = r12.a
                com.avito.android.search.map.view.SerpListResourcesProvider r13 = com.avito.android.search.map.interactor.SerpInteractorImpl.access$getResourcesProvider$p(r13)
                com.avito.android.remote.model.SerpDisplayType r0 = r2.getSerpDisplayType()
                int r13 = r13.getColumnsCount(r0)
                com.avito.android.search.map.interactor.SerpKey r3 = r12.b
                java.lang.String r0 = "pageParams"
                if (r3 == 0) goto L_0x002b
                r4 = 0
                com.avito.android.remote.model.PageParams r5 = r12.c
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 61
                r11 = 0
                com.avito.android.search.map.interactor.SerpKey r1 = com.avito.android.search.map.interactor.SerpKey.copy$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
                if (r1 == 0) goto L_0x002b
                goto L_0x004a
            L_0x002b:
                com.avito.android.search.map.interactor.SerpKey r1 = new com.avito.android.search.map.interactor.SerpKey
                com.avito.android.search.map.interactor.SerpInteractorImpl r3 = r12.a
                com.avito.android.util.RandomKeyProvider r3 = com.avito.android.search.map.interactor.SerpInteractorImpl.access$getKeyProvider$p(r3)
                java.lang.String r4 = r3.generateKey()
                com.avito.android.remote.model.PageParams r5 = r12.c
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                r7 = 0
                r8 = 0
                com.avito.android.remote.model.SearchDescription r9 = r2.getSearchDescription()
                r10 = 24
                r11 = 0
                r3 = r1
                r6 = r13
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            L_0x004a:
                com.avito.android.search.map.interactor.SerpInteractorImpl r0 = r12.a
                java.lang.String r3 = "result"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                com.avito.android.remote.model.SerpDisplayType r4 = r2.getSerpDisplayType()
                java.lang.String r5 = r2.getSubscriptionId()
                r3 = r13
                io.reactivex.rxjava3.core.Observable r13 = com.avito.android.search.map.interactor.SerpInteractorImpl.access$appendElements(r0, r1, r2, r3, r4, r5)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.map.interactor.SerpInteractorImpl.e.apply(java.lang.Object):java.lang.Object");
        }
    }

    public static final class f<T, R> implements Function<SerpKey, ObservableSource<? extends Pair<? extends SerpKey, ? extends SerpElementResult>>> {
        public final /* synthetic */ SerpInteractorImpl a;
        public final /* synthetic */ SearchParams b;
        public final /* synthetic */ String c;
        public final /* synthetic */ PageParams d;
        public final /* synthetic */ SerpDisplayType e;
        public final /* synthetic */ Area f;

        public f(SerpInteractorImpl serpInteractorImpl, SearchParams searchParams, String str, PageParams pageParams, SerpDisplayType serpDisplayType, Area area) {
            this.a = serpInteractorImpl;
            this.b = searchParams;
            this.c = str;
            this.d = pageParams;
            this.e = serpDisplayType;
            this.f = area;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Pair<? extends SerpKey, ? extends SerpElementResult>> apply(SerpKey serpKey) {
            SerpInteractorImpl serpInteractorImpl = this.a;
            SearchParams searchParams = this.b;
            String str = this.c;
            PageParams pageParams = this.d;
            Intrinsics.checkNotNullExpressionValue(pageParams, "pageParams");
            return serpInteractorImpl.b(searchParams, str, pageParams, this.e, this.f).map(new a2.a.a.k2.b.f.d(serpKey));
        }
    }

    public static final class g<T, R> implements Function<Pair<? extends SerpKey, ? extends SerpElementResult>, ObservableSource<? extends SerpInteractor.Result>> {
        public final /* synthetic */ SerpInteractorImpl a;
        public final /* synthetic */ int b;
        public final /* synthetic */ SerpDisplayType c;

        public g(SerpInteractorImpl serpInteractorImpl, int i, SerpDisplayType serpDisplayType) {
            this.a = serpInteractorImpl;
            this.b = i;
            this.c = serpDisplayType;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends SerpInteractor.Result> apply(Pair<? extends SerpKey, ? extends SerpElementResult> pair) {
            Pair<? extends SerpKey, ? extends SerpElementResult> pair2 = pair;
            SerpKey serpKey = (SerpKey) pair2.component1();
            SerpElementResult serpElementResult = (SerpElementResult) pair2.component2();
            SerpInteractorImpl serpInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(serpKey, "key");
            Intrinsics.checkNotNullExpressionValue(serpElementResult, "result");
            return SerpInteractorImpl.access$appendElements(serpInteractorImpl, serpKey, serpElementResult, this.b, this.c, serpElementResult.getSubscriptionId());
        }
    }

    public static final class h<T, R> implements Function<SerpKey, ObservableSource<? extends Pair<? extends SerpKey, ? extends SerpDataSources>>> {
        public final /* synthetic */ SerpInteractorImpl a;
        public final /* synthetic */ int b;
        public final /* synthetic */ SerpDisplayType c;

        public h(SerpInteractorImpl serpInteractorImpl, int i, SerpDisplayType serpDisplayType) {
            this.a = serpInteractorImpl;
            this.b = i;
            this.c = serpDisplayType;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Pair<? extends SerpKey, ? extends SerpDataSources>> apply(SerpKey serpKey) {
            SerpKey serpKey2 = serpKey;
            return this.a.d.getElements(serpKey2.getId(), this.b, this.c).map(new a2.a.a.k2.b.f.e(serpKey2));
        }
    }

    public static final class i<T, R> implements Function<Pair<? extends SerpKey, ? extends SerpDataSources>, SerpInteractor.Result> {
        public final /* synthetic */ SerpInteractorImpl a;
        public final /* synthetic */ SerpDisplayType b;

        public i(SerpInteractorImpl serpInteractorImpl, SerpDisplayType serpDisplayType) {
            this.a = serpInteractorImpl;
            this.b = serpDisplayType;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SerpInteractor.Result apply(Pair<? extends SerpKey, ? extends SerpDataSources> pair) {
            Pair<? extends SerpKey, ? extends SerpDataSources> pair2 = pair;
            SerpKey serpKey = (SerpKey) pair2.component1();
            SerpDataSources serpDataSources = (SerpDataSources) pair2.component2();
            Intrinsics.checkNotNullExpressionValue(serpKey, "key");
            String subscriptionId = this.a.d.getSubscriptionId(serpKey.getId());
            Intrinsics.checkNotNullExpressionValue(serpDataSources, "dataSources");
            return new SerpInteractor.Result(serpKey, serpDataSources, true, subscriptionId, 0, this.b, null, null, 208, null);
        }
    }

    public static final class j<T, R> implements Function<SerpElementResult, SerpElementResult> {
        public static final j a = new j();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SerpElementResult apply(SerpElementResult serpElementResult) {
            SerpElementResult serpElementResult2 = serpElementResult;
            List<SerpElement> elements = serpElementResult2.getElements();
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(elements, 10));
            for (T t : elements) {
                if (t instanceof SerpBannerContainer) {
                    t = (T) SerpCommercialBannerKt.toSerpCommercialBanner(t);
                }
                arrayList.add(t);
            }
            return serpElementResult2.cloneWithNewElements(arrayList);
        }
    }

    public static final class k<T, R> implements Function<T, LoadingState.Loaded<T>> {
        public static final k a = new k();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return new LoadingState.Loaded(obj);
        }
    }

    public static final class l<T, R> implements Function<Throwable, LoadingState<? super T>> {
        public final /* synthetic */ SerpInteractorImpl a;

        public l(SerpInteractorImpl serpInteractorImpl) {
            this.a = serpInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.g;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public SerpInteractorImpl(@NotNull SearchApi searchApi, @NotNull SearchParamsConverter searchParamsConverter, @SerpList @NotNull CommercialBannersInteractor commercialBannersInteractor, @NotNull SerpCacheInteractor serpCacheInteractor, @NotNull RandomKeyProvider randomKeyProvider, @NotNull SerpListResourcesProvider serpListResourcesProvider, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull MapViewPortProvider mapViewPortProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(searchApi, "api");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParamsConverter");
        Intrinsics.checkNotNullParameter(commercialBannersInteractor, "commercialBannersInteractor");
        Intrinsics.checkNotNullParameter(serpCacheInteractor, "cacheInteractor");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        Intrinsics.checkNotNullParameter(serpListResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(mapViewPortProvider, "viewPortProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = searchApi;
        this.b = searchParamsConverter;
        this.c = commercialBannersInteractor;
        this.d = serpCacheInteractor;
        this.e = randomKeyProvider;
        this.f = serpListResourcesProvider;
        this.g = typedErrorThrowableConverter;
        this.h = mapViewPortProvider;
        this.i = schedulersFactory3;
    }

    public static final Observable access$appendElements(SerpInteractorImpl serpInteractorImpl, SerpKey serpKey, SerpElementResult serpElementResult, int i2, SerpDisplayType serpDisplayType, String str) {
        return serpInteractorImpl.d.appendElements(serpKey.getId(), serpElementResult.getElements(), i2, serpDisplayType, str).map(new a2.a.a.k2.b.f.a(serpKey, serpElementResult, i2, serpDisplayType));
    }

    public final Observable<SerpKey> a(SerpKey serpKey, int i2) {
        if (serpKey.getColumnsCount() != i2) {
            Completable recalculatePositions = this.d.recalculatePositions(serpKey.getId(), i2);
            Observable just = Observable.just(serpKey);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            Observable<SerpKey> andThen = recalculatePositions.andThen(just);
            Intrinsics.checkNotNullExpressionValue(andThen, "cacheInteractor.recalcul….toSingletonObservable())");
            return andThen;
        }
        Observable<SerpKey> just2 = Observable.just(serpKey);
        Intrinsics.checkNotNullExpressionValue(just2, "Observable.just(this)");
        return just2;
    }

    public final Observable<SerpElementResult> b(SearchParams searchParams, String str, PageParams pageParams, SerpDisplayType serpDisplayType, Area area) {
        Integer valueOf = Integer.valueOf(pageParams.getPage());
        Long lastStamp = pageParams.getLastStamp();
        String parameterValue = serpDisplayType != null ? SerpDisplayTypeKt.toParameterValue(serpDisplayType) : null;
        Observable<TypedResult<SerpElementResult>> subscribeOn = this.a.getSerpElementTypedResult(valueOf, lastStamp, parameterValue, str, null, pageParams.getNextPageId(), r.plus(r.plus(SearchParamsConverter.DefaultImpls.convertToMap$default(this.b, searchParams, null, false, false, 14, null), MapViewPortProviderKt.toMap(this.h.getViewPort())), AreaKt.toMap(area)), searchParams.getForcedLocationForRecommendation()).subscribeOn(this.i.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "getSerpElementTypedResul…scribeOn(schedulers.io())");
        Observable<SerpElementResult> map = TypedObservablesKt.toTyped(subscribeOn).map(j.a);
        Intrinsics.checkNotNullExpressionValue(map, "serpElementsObservable.m…hReplaceBanner)\n        }");
        return map;
    }

    public final <T> Observable<LoadingState<T>> c(Observable<T> observable) {
        Observable<R> map = observable.map(k.a);
        Intrinsics.checkNotNullExpressionValue(map, "map { LoadingState.Loaded(it) }");
        Observable<U> cast = map.cast(LoadingState.class);
        Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
        Observable<U> startWithItem = cast.onErrorReturn(new l(this)).startWithItem((U) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWithItem, "map { LoadingState.Loade…tem(LoadingState.Loading)");
        return startWithItem;
    }

    @Override // com.avito.android.search.map.interactor.SerpInteractor
    @NotNull
    public Observable<ViewTypeSerpItem> loadAds(@NotNull DataSource<ViewTypeSerpItem> dataSource, @NotNull SearchParams searchParams, @NotNull SerpDisplayType serpDisplayType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(dataSource, "itemsDataSource");
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(str, "key");
        Observable<ViewTypeSerpItem> flatMap = Observable.fromIterable(DataSources.toIterableDataSource(dataSource)).filter(a.a).map(b.a).flatMap(new c(this, this.c.getPageCdtm(), searchParams)).flatMap(new d(this, str, serpDisplayType));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Observable.fromIterable(…s(it, key, displayType) }");
        return flatMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b5, code lost:
        if (r1 != null) goto L_0x00d1;
     */
    @Override // com.avito.android.search.map.interactor.SerpInteractor
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Observable<com.avito.android.util.LoadingState<com.avito.android.search.map.interactor.SerpInteractor.Result>> loadSerp(@org.jetbrains.annotations.Nullable com.avito.android.search.map.interactor.SerpKey r18, boolean r19, @org.jetbrains.annotations.NotNull com.avito.android.remote.model.SearchParams r20, @org.jetbrains.annotations.Nullable java.lang.String r21, @org.jetbrains.annotations.Nullable com.avito.android.remote.model.SerpDisplayType r22, @org.jetbrains.annotations.Nullable com.avito.android.remote.model.search.map.Area r23) {
        /*
        // Method dump skipped, instructions count: 264
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.map.interactor.SerpInteractorImpl.loadSerp(com.avito.android.search.map.interactor.SerpKey, boolean, com.avito.android.remote.model.SearchParams, java.lang.String, com.avito.android.remote.model.SerpDisplayType, com.avito.android.remote.model.search.map.Area):io.reactivex.rxjava3.core.Observable");
    }

    @Override // com.avito.android.search.map.interactor.SerpInteractor
    @NotNull
    public Completable removeElement(@Nullable SerpKey serpKey, int i2) {
        if (serpKey != null) {
            Completable observeOn = this.d.removeAtPosition(serpKey.getId(), i2).observeOn(this.i.io());
            Intrinsics.checkNotNullExpressionValue(observeOn, "cacheInteractor\n        …bserveOn(schedulers.io())");
            return observeOn;
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }
}
