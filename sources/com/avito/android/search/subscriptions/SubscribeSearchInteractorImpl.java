package com.avito.android.search.subscriptions;

import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.remote.model.SubscriptionDeeplinkResult;
import com.avito.android.remote.model.SubscriptionResult;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.remote.model.search.map.AreaKt;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020*¢\u0006\u0004\b2\u00103J7\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\t0\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0011J#\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\b2\u0006\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0018Ji\u0010\u001d\u001aH\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u001b*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\t \u001b*#\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u001b*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\t\u0018\u00010\b¢\u0006\u0002\b\u001c0\b¢\u0006\u0002\b\u001c\"\b\b\u0000\u0010\u001a*\u00020\u0019*\b\u0012\u0004\u0012\u00028\u00000\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/avito/android/search/subscriptions/SubscribeSearchInteractorImpl;", "Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "pushFrequency", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/SearchSubscription;", "subscribeToSearch", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/Integer;Lcom/avito/android/remote/model/search/map/Area;)Lio/reactivex/rxjava3/core/Observable;", "", "searchSubscriptionId", "Lcom/avito/android/remote/model/SubscriptionResult;", "updatePushFrequencyForSubscription", "(Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/Observable;", "filterId", "Lcom/avito/android/deep_linking/links/DeepLink;", "getSearchSubscriptionControlDeeplink", "(Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;)Lio/reactivex/rxjava3/core/Observable;", "subscriptionId", "unsubscribeFromSearch", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "T", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", "Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", "api", "Lcom/avito/android/db/SearchSubscriptionDao;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/db/SearchSubscriptionDao;", "dao", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "d", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/model/SearchParamsConverter;", "c", "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsConverter", "<init>", "(Lcom/avito/android/subscriptions/remote/SubscriptionsApi;Lcom/avito/android/db/SearchSubscriptionDao;Lcom/avito/android/remote/model/SearchParamsConverter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;)V", "search-base_release"}, k = 1, mv = {1, 4, 2})
public final class SubscribeSearchInteractorImpl implements SubscribeSearchInteractor {
    public final SubscriptionsApi a;
    public final SearchSubscriptionDao b;
    public final SearchParamsConverter c;
    public final TypedErrorThrowableConverter d;
    public final SchedulersFactory3 e;

    public static final class a<T, R> implements Function<SubscriptionDeeplinkResult, DeepLink> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public DeepLink apply(SubscriptionDeeplinkResult subscriptionDeeplinkResult) {
            return subscriptionDeeplinkResult.getSearchSubscriptionAction();
        }
    }

    public static final class b<T, R> implements Function<T, LoadingState<? super T>> {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return new LoadingState.Loaded(obj);
        }
    }

    public static final class c<T, R> implements Function<Throwable, LoadingState<? super T>> {
        public final /* synthetic */ SubscribeSearchInteractorImpl a;

        public c(SubscribeSearchInteractorImpl subscribeSearchInteractorImpl) {
            this.a = subscribeSearchInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.d;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class d<T> implements Consumer<SubscriptionResult> {
        public final /* synthetic */ SubscribeSearchInteractorImpl a;
        public final /* synthetic */ String b;

        public d(SubscribeSearchInteractorImpl subscribeSearchInteractorImpl, String str) {
            this.a = subscribeSearchInteractorImpl;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SubscriptionResult subscriptionResult) {
            this.a.b.deleteSearchSubscription(this.b);
        }
    }

    @Inject
    public SubscribeSearchInteractorImpl(@NotNull SubscriptionsApi subscriptionsApi, @NotNull SearchSubscriptionDao searchSubscriptionDao, @NotNull SearchParamsConverter searchParamsConverter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(subscriptionsApi, "api");
        Intrinsics.checkNotNullParameter(searchSubscriptionDao, "dao");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParamsConverter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = subscriptionsApi;
        this.b = searchSubscriptionDao;
        this.c = searchParamsConverter;
        this.d = typedErrorThrowableConverter;
        this.e = schedulersFactory3;
    }

    public final <T> Observable<LoadingState<T>> a(Observable<T> observable) {
        return observable.subscribeOn(this.e.io()).map(b.a).startWithItem((R) LoadingState.Loading.INSTANCE).onErrorReturn(new c(this));
    }

    @Override // com.avito.android.search.subscriptions.SubscribeSearchInteractor
    @NotNull
    public Observable<LoadingState<DeepLink>> getSearchSubscriptionControlDeeplink(@Nullable String str, @NotNull SearchParams searchParams) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Map<String, String> emptyMap = r.emptyMap();
        if (str == null) {
            emptyMap = r.toMutableMap(SearchParamsConverter.DefaultImpls.convertToMap$default(this.c, searchParams, null, false, false, 14, null));
        }
        Observable map = TypedObservablesKt.toTyped(this.a.getSearchSubscriptionControlDeeplink(str, emptyMap)).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getSearchSubscriptio…earchSubscriptionAction }");
        Observable<LoadingState<DeepLink>> a3 = a(map);
        Intrinsics.checkNotNullExpressionValue(a3, "observableDeeplink.toLoadingState()");
        return a3;
    }

    @Override // com.avito.android.search.subscriptions.SubscribeSearchInteractor
    @NotNull
    public Observable<LoadingState<SearchSubscription>> subscribeToSearch(@NotNull SearchParams searchParams, @Nullable Integer num, @Nullable Area area) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Map<String, String> map = area != null ? AreaKt.toMap(area) : null;
        Map<String, String> mutableMap = r.toMutableMap(SearchParamsConverter.DefaultImpls.convertToMap$default(this.c, searchParams, null, true, false, 10, null));
        if (map != null) {
            mutableMap.putAll(map);
        }
        Observable<SearchSubscription> doOnNext = this.a.addSearchSubscription(mutableMap, num).doOnNext(new a2.a.a.k2.c.c(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "api.addSearchSubscriptio…\n            .saveToDao()");
        Observable<LoadingState<SearchSubscription>> a3 = a(doOnNext);
        Intrinsics.checkNotNullExpressionValue(a3, "api.addSearchSubscriptio…        .toLoadingState()");
        return a3;
    }

    @Override // com.avito.android.search.subscriptions.SubscribeSearchInteractor
    @NotNull
    public Observable<LoadingState<SubscriptionResult>> unsubscribeFromSearch(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionId");
        Observable<SubscriptionResult> doOnNext = this.a.deleteSubscription(str).doOnNext(new d(this, str));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "api.deleteSubscription(s…ription(subscriptionId) }");
        Observable<LoadingState<SubscriptionResult>> a3 = a(doOnNext);
        Intrinsics.checkNotNullExpressionValue(a3, "api.deleteSubscription(s…        .toLoadingState()");
        return a3;
    }

    @Override // com.avito.android.search.subscriptions.SubscribeSearchInteractor
    @NotNull
    public Observable<LoadingState<SubscriptionResult>> updatePushFrequencyForSubscription(@NotNull String str, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "searchSubscriptionId");
        Observable<LoadingState<SubscriptionResult>> a3 = a(this.a.updateSearchSubscription(str, true, num));
        Intrinsics.checkNotNullExpressionValue(a3, "api.updateSearchSubscrip…        .toLoadingState()");
        return a3;
    }

    @Override // com.avito.android.search.subscriptions.SubscribeSearchInteractor
    @NotNull
    public Observable<LoadingState<SearchSubscription>> subscribeToSearch(@NotNull String str, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "subscriptionId");
        Observable<SearchSubscription> doOnNext = this.a.addSearchSubscription(str, num).doOnNext(new a2.a.a.k2.c.c(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "api.addSearchSubscriptio…\n            .saveToDao()");
        Observable<LoadingState<SearchSubscription>> a3 = a(doOnNext);
        Intrinsics.checkNotNullExpressionValue(a3, "api.addSearchSubscriptio…        .toLoadingState()");
        return a3;
    }
}
