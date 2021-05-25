package com.avito.android.search;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.UrlParams;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJG\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/search/SearchDeepLinkInteractorImpl;", "Lcom/avito/android/search/SearchDeepLinkInteractor;", "", "query", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "context", "", "clearGeoFilters", UrlParams.SIMPLE_MAP, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/deep_linking/links/DeepLink;", "loadSearchDeepLink", "(Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Ljava/lang/Boolean;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/SearchApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/SearchApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/model/SearchParamsConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsConverter", "<init>", "(Lcom/avito/android/remote/SearchApi;Lcom/avito/android/remote/model/SearchParamsConverter;Lcom/avito/android/util/SchedulersFactory3;)V", "search-base_release"}, k = 1, mv = {1, 4, 2})
public final class SearchDeepLinkInteractorImpl implements SearchDeepLinkInteractor {
    public final SearchApi a;
    public final SearchParamsConverter b;
    public final SchedulersFactory3 c;

    public static final class a<T, R> implements Function<TypedResult<DeepLinkResponse>, LoadingState<? super DeepLink>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DeepLink> apply(TypedResult<DeepLinkResponse> typedResult) {
            TypedResult<DeepLinkResponse> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((DeepLinkResponse) ((TypedResult.OfResult) typedResult2).getResult()).getDeepLink());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Inject
    public SearchDeepLinkInteractorImpl(@NotNull SearchApi searchApi, @NotNull SearchParamsConverter searchParamsConverter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(searchApi, "api");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParamsConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = searchApi;
        this.b = searchParamsConverter;
        this.c = schedulersFactory3;
    }

    @Override // com.avito.android.search.SearchDeepLinkInteractor
    @NotNull
    public Observable<LoadingState<DeepLink>> loadSearchDeepLink(@NotNull String str, @NotNull SearchParams searchParams, @Nullable String str2, @Nullable Boolean bool, boolean z) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        return a2.b.a.a.a.a2(this.c, this.a.getSerpDeeplink(bool, str2, SearchParamsConverter.DefaultImpls.convertToMap$default(this.b, SearchParams.copy$default(searchParams, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388095, null), null, false, z, 6, null)).map(a.a), "api.getSerpDeeplink(clea…scribeOn(schedulers.io())");
    }
}
