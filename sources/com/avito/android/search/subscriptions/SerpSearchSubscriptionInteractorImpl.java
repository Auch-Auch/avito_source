package com.avito.android.search.subscriptions;

import com.avito.android.Features;
import com.avito.android.analytics.event.SavedSearchesCounter;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.remote.model.SubscriptionResult;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/search/subscriptions/SerpSearchSubscriptionInteractorImpl;", "Lcom/avito/android/search/subscriptions/SerpSearchSubscriptionInteractor;", "", "subscriptionId", "", "isSubscribed", "(Ljava/lang/String;)Z", "Lio/reactivex/rxjava3/core/Observable;", "Lorg/funktionale/option/Option;", "Lcom/avito/android/remote/model/SearchParams;", "loadSearchParams", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "resetUnreadChangesCount", "(Ljava/lang/String;)V", "Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", "api", "Lcom/avito/android/Features;", "e", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/db/SearchSubscriptionDao;", AuthSource.SEND_ABUSE, "Lcom/avito/android/db/SearchSubscriptionDao;", "dao", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", "d", "Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", "searchSubscriptionConsumer", "<init>", "(Lcom/avito/android/db/SearchSubscriptionDao;Lcom/avito/android/subscriptions/remote/SubscriptionsApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;Lcom/avito/android/Features;)V", "search-base_release"}, k = 1, mv = {1, 4, 2})
public final class SerpSearchSubscriptionInteractorImpl implements SerpSearchSubscriptionInteractor {
    public final SearchSubscriptionDao a;
    public final SubscriptionsApi b;
    public final SchedulersFactory3 c;
    public final SearchSubscriptionConsumer d;
    public final Features e;

    public static final class a<T, R> implements Function<SearchSubscription, Option<? extends SearchParams>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Option<? extends SearchParams> apply(SearchSubscription searchSubscription) {
            return OptionKt.toOption(searchSubscription.getSearchParams());
        }
    }

    public static final class b<T> implements Consumer<SubscriptionResult> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SubscriptionResult subscriptionResult) {
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    @Inject
    public SerpSearchSubscriptionInteractorImpl(@NotNull SearchSubscriptionDao searchSubscriptionDao, @NotNull SubscriptionsApi subscriptionsApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SearchSubscriptionConsumer searchSubscriptionConsumer, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(searchSubscriptionDao, "dao");
        Intrinsics.checkNotNullParameter(subscriptionsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(searchSubscriptionConsumer, "searchSubscriptionConsumer");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = searchSubscriptionDao;
        this.b = subscriptionsApi;
        this.c = schedulersFactory3;
        this.d = searchSubscriptionConsumer;
        this.e = features;
    }

    @Override // com.avito.android.search.subscriptions.SerpSearchSubscriptionInteractor
    public boolean isSubscribed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionId");
        return this.a.hasSubscription(str);
    }

    @Override // com.avito.android.search.subscriptions.SerpSearchSubscriptionInteractor
    @NotNull
    public Observable<Option<SearchParams>> loadSearchParams(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionId");
        return a2.b.a.a.a.a2(this.c, this.b.getSearchSubscription(str).map(a.a), "api.getSearchSubscriptio…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.search.subscriptions.SerpSearchSubscriptionInteractor
    public void resetUnreadChangesCount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionId");
        if (!this.e.getRemoveSearchSubscriptionResetRequest().invoke().booleanValue()) {
            SubscriptionsApi.DefaultImpls.updateSearchSubscription$default(this.b, str, true, null, 4, null).subscribeOn(this.c.io()).subscribe(b.a, c.a);
        }
        this.a.resetUnreadChangesCount(str);
        this.d.accept(new SavedSearchesCounter(this.a.getUnreadChangesCount()));
    }
}
