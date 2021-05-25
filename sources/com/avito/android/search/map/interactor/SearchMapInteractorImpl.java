package com.avito.android.search.map.interactor;

import com.avito.android.Features;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SuggestParamsConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.remote.model.search.map.AreaKt;
import com.avito.android.remote.model.search.map.MarkersResponse;
import com.avito.android.remote.model.search.map.PinAdvertsResult;
import com.avito.android.remote.model.search.suggest.SuggestItem;
import com.avito.android.remote.model.search.suggest.SuggestResponse;
import com.avito.android.search.SearchDeepLinkInteractor;
import com.avito.android.search.map.provider.SearchHashProvider;
import com.avito.android.serp.InlineFiltersInteractor;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.UrlParams;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Ba\b\u0007\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bN\u0010OJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00110\t2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00110\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001c2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 JG\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00110\t2\b\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010%R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006P"}, d2 = {"Lcom/avito/android/search/map/interactor/SearchMapInteractorImpl;", "Lcom/avito/android/search/map/interactor/SearchMapInteractor;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "updateSearchParams", "(Lcom/avito/android/remote/model/SearchParams;)Z", "", "query", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/search/suggest/SuggestItem;", "loadSuggestions", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/search/map/Area;", "area", UrlParams.SIMPLE_MAP, "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/search/map/MarkersResponse;", "loadMarkers", "(Lcom/avito/android/remote/model/search/map/Area;Z)Lio/reactivex/rxjava3/core/Observable;", "id", "", "limit", "isFirstPage", "Lcom/avito/android/remote/model/search/map/PinAdvertsResult;", "loadAdvertsInPin", "(Ljava/lang/String;IZ)Lio/reactivex/rxjava3/core/Observable;", "", "changesMap", "Lcom/avito/android/remote/model/search/InlineFilters;", "loadInlineFilters", "(Ljava/util/Map;Z)Lio/reactivex/rxjava3/core/Observable;", "clearGeoFilters", "context", "Lcom/avito/android/deep_linking/links/DeepLink;", "loadSearchDeepLink", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Z)Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/SearchParams;", "Lcom/avito/android/search/SearchDeepLinkInteractor;", "f", "Lcom/avito/android/search/SearchDeepLinkInteractor;", "searchDeepLinkInteractor", "Lcom/avito/android/search/map/provider/SearchHashProvider;", "i", "Lcom/avito/android/search/map/provider/SearchHashProvider;", "searchHashProvider", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/SearchApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/SearchApi;", "api", "Lcom/avito/android/search/map/interactor/MapViewPortProvider;", a2.g.r.g.a, "Lcom/avito/android/search/map/interactor/MapViewPortProvider;", "mapViewPortProvider", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "e", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/remote/model/SuggestParamsConverter;", "c", "Lcom/avito/android/remote/model/SuggestParamsConverter;", "suggestParamsConverter", "Lcom/avito/android/remote/model/SearchParamsConverter;", "d", "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsConverter", "Lcom/avito/android/serp/InlineFiltersInteractor;", "j", "Lcom/avito/android/serp/InlineFiltersInteractor;", "inlineFiltersInteractor", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/remote/SearchApi;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/SuggestParamsConverter;Lcom/avito/android/remote/model/SearchParamsConverter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/search/SearchDeepLinkInteractor;Lcom/avito/android/search/map/interactor/MapViewPortProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/search/map/provider/SearchHashProvider;Lcom/avito/android/serp/InlineFiltersInteractor;Lcom/avito/android/Features;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SearchMapInteractorImpl implements SearchMapInteractor {
    public final SearchApi a;
    public SearchParams b;
    public final SuggestParamsConverter c;
    public final SearchParamsConverter d;
    public final TypedErrorThrowableConverter e;
    public final SearchDeepLinkInteractor f;
    public final MapViewPortProvider g;
    public final SchedulersFactory3 h;
    public final SearchHashProvider i;
    public final InlineFiltersInteractor j;

    public static final class a<T, R> implements Function<TypedResult<PinAdvertsResult>, LoadingState<? super PinAdvertsResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super PinAdvertsResult> apply(TypedResult<PinAdvertsResult> typedResult) {
            TypedResult<PinAdvertsResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<InlineFilters, LoadingState.Loaded<InlineFilters>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState.Loaded<InlineFilters> apply(InlineFilters inlineFilters) {
            return new LoadingState.Loaded<>(inlineFilters);
        }
    }

    public static final class c<T, R> implements Function<Throwable, LoadingState<? super InlineFilters>> {
        public final /* synthetic */ SearchMapInteractorImpl a;

        public c(SearchMapInteractorImpl searchMapInteractorImpl) {
            this.a = searchMapInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super InlineFilters> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.e;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class d<V> implements Callable<Map<String, ? extends String>> {
        public final /* synthetic */ SearchMapInteractorImpl a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Area c;

        public d(SearchMapInteractorImpl searchMapInteractorImpl, boolean z, Area area) {
            this.a = searchMapInteractorImpl;
            this.b = z;
            this.c = area;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Map<String, ? extends String> call() {
            return r.plus(SearchParamsConverter.DefaultImpls.convertToMap$default(this.a.d, this.a.b, null, false, this.b, 6, null), AreaKt.toMap(this.c));
        }
    }

    public static final class e<T, R> implements Function<Map<String, ? extends String>, ObservableSource<? extends TypedResult<MarkersResponse>>> {
        public final /* synthetic */ SearchMapInteractorImpl a;

        public e(SearchMapInteractorImpl searchMapInteractorImpl) {
            this.a = searchMapInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.remote.SearchApi */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends TypedResult<MarkersResponse>> apply(Map<String, ? extends String> map) {
            Map<String, ? extends String> map2 = map;
            Pair<Integer, Integer> reducedViewPort = this.a.g.getReducedViewPort();
            SearchApi searchApi = this.a.a;
            Intrinsics.checkNotNullExpressionValue(map2, "it");
            return searchApi.getMapMarkers(map2, reducedViewPort.getFirst().intValue(), reducedViewPort.getSecond().intValue());
        }
    }

    public static final class f<T, R> implements Function<TypedResult<MarkersResponse>, LoadingState<? super MarkersResponse>> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super MarkersResponse> apply(TypedResult<MarkersResponse> typedResult) {
            TypedResult<MarkersResponse> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class g<T, R> implements Function<SuggestResponse, List<? extends SuggestItem>> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends SuggestItem> apply(SuggestResponse suggestResponse) {
            return CollectionsKt___CollectionsKt.filterNotNull(suggestResponse.getResult());
        }
    }

    @Inject
    public SearchMapInteractorImpl(@NotNull SearchApi searchApi, @NotNull SearchParams searchParams, @NotNull SuggestParamsConverter suggestParamsConverter, @NotNull SearchParamsConverter searchParamsConverter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SearchDeepLinkInteractor searchDeepLinkInteractor, @NotNull MapViewPortProvider mapViewPortProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SearchHashProvider searchHashProvider, @NotNull InlineFiltersInteractor inlineFiltersInteractor, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(searchApi, "api");
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(suggestParamsConverter, "suggestParamsConverter");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParamsConverter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(searchDeepLinkInteractor, "searchDeepLinkInteractor");
        Intrinsics.checkNotNullParameter(mapViewPortProvider, "mapViewPortProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(searchHashProvider, "searchHashProvider");
        Intrinsics.checkNotNullParameter(inlineFiltersInteractor, "inlineFiltersInteractor");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = searchApi;
        this.b = searchParams;
        this.c = suggestParamsConverter;
        this.d = searchParamsConverter;
        this.e = typedErrorThrowableConverter;
        this.f = searchDeepLinkInteractor;
        this.g = mapViewPortProvider;
        this.h = schedulersFactory3;
        this.i = searchHashProvider;
        this.j = inlineFiltersInteractor;
    }

    @Override // com.avito.android.search.map.interactor.SearchMapInteractor
    @NotNull
    public Observable<LoadingState<PinAdvertsResult>> loadAdvertsInPin(@NotNull String str, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        return a2.b.a.a.a.a2(this.h, this.a.getPinAdverts(str, i2, this.i.getSearchHash(), Boolean.valueOf(z)).map(a.a).startWithItem((R) LoadingState.Loading.INSTANCE), "api.getPinAdverts(id, li…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.search.map.interactor.SearchMapInteractor
    @NotNull
    public Observable<LoadingState<InlineFilters>> loadInlineFilters(@NotNull Map<String, String> map, boolean z) {
        Intrinsics.checkNotNullParameter(map, "changesMap");
        Observable<R> map2 = this.j.loadInlineFilters(this.b, map, z).map(b.a);
        Intrinsics.checkNotNullExpressionValue(map2, "inlineFiltersInteractor.…LoadingState.Loaded(it) }");
        Observable<U> cast = map2.cast(LoadingState.class);
        Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
        return a2.b.a.a.a.a2(this.h, cast.onErrorReturn(new c(this)).startWithItem((U) LoadingState.Loading.INSTANCE), "inlineFiltersInteractor.…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.search.map.interactor.SearchMapInteractor
    @NotNull
    public Observable<LoadingState<MarkersResponse>> loadMarkers(@Nullable Area area, boolean z) {
        return a2.b.a.a.a.a2(this.h, Observable.fromCallable(new d(this, z, area)).flatMap(new e(this)).map(f.a).delay(800, TimeUnit.MILLISECONDS).startWithItem(LoadingState.Loading.INSTANCE), "Observable.fromCallable …scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.search.map.interactor.SearchMapInteractor
    @NotNull
    public Observable<LoadingState<DeepLink>> loadSearchDeepLink(@Nullable Boolean bool, @NotNull String str, @Nullable String str2, @NotNull SearchParams searchParams, boolean z) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        return this.f.loadSearchDeepLink(str, searchParams, str2, bool, z);
    }

    @Override // com.avito.android.component.search.SuggestInteractor
    @NotNull
    public Observable<List<SuggestItem>> loadSuggestions(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        Observable<R> map = this.a.getSearchSuggestV8(str, this.c.convertToMap(this.b)).subscribeOn(this.h.io()).map(g.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getSearchSuggestV8(q….result.filterNotNull() }");
        return map;
    }

    @Override // com.avito.android.search.map.interactor.SearchMapInteractor
    public boolean updateSearchParams(@NotNull SearchParams searchParams) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        if (!(!Intrinsics.areEqual(this.b, searchParams))) {
            return false;
        }
        this.b = searchParams;
        return true;
    }
}
