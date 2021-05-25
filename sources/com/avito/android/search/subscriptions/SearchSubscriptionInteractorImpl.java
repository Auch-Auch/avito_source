package com.avito.android.search.subscriptions;

import com.avito.android.analytics.event.SavedSearchesCounter;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.remote.model.SubscriptionResult;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionInteractorImpl;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/SearchSubscription;", "loadRemoteSearchSubscriptions", "()Lio/reactivex/rxjava3/core/Observable;", "", "searchSubscriptionId", "Lcom/avito/android/remote/model/SubscriptionResult;", "removeSearchSubscription", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", "c", "Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", "searchSubscriptionConsumer", "Lcom/avito/android/db/SearchSubscriptionDao;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/db/SearchSubscriptionDao;", "subscriptionDao", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", "api", "<init>", "(Lcom/avito/android/subscriptions/remote/SubscriptionsApi;Lcom/avito/android/db/SearchSubscriptionDao;Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;Lcom/avito/android/util/SchedulersFactory3;)V", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscriptionInteractorImpl implements SearchSubscriptionInteractor {
    public final SubscriptionsApi a;
    public final SearchSubscriptionDao b;
    public final SearchSubscriptionConsumer c;
    public final SchedulersFactory3 d;

    public static final class a<T> implements Consumer<SubscriptionResult> {
        public final /* synthetic */ SearchSubscriptionInteractorImpl a;
        public final /* synthetic */ String b;

        public a(SearchSubscriptionInteractorImpl searchSubscriptionInteractorImpl, String str) {
            this.a = searchSubscriptionInteractorImpl;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SubscriptionResult subscriptionResult) {
            this.a.b.deleteSearchSubscription(this.b);
            this.a.c.accept(new SavedSearchesCounter(this.a.b.getUnreadChangesCount()));
        }
    }

    @Inject
    public SearchSubscriptionInteractorImpl(@NotNull SubscriptionsApi subscriptionsApi, @NotNull SearchSubscriptionDao searchSubscriptionDao, @NotNull SearchSubscriptionConsumer searchSubscriptionConsumer, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(subscriptionsApi, "api");
        Intrinsics.checkNotNullParameter(searchSubscriptionDao, "subscriptionDao");
        Intrinsics.checkNotNullParameter(searchSubscriptionConsumer, "searchSubscriptionConsumer");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.a = subscriptionsApi;
        this.b = searchSubscriptionDao;
        this.c = searchSubscriptionConsumer;
        this.d = schedulersFactory3;
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionInteractor
    @NotNull
    public Observable<List<SearchSubscription>> loadRemoteSearchSubscriptions() {
        return a2.b.a.a.a.a2(this.d, this.a.getSearchSubscriptions(), "api.getSearchSubscriptio…n(schedulersFactory.io())");
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionInteractor
    @NotNull
    public Observable<SubscriptionResult> removeSearchSubscription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "searchSubscriptionId");
        Observable<SubscriptionResult> doOnNext = this.a.deleteSubscription(str).doOnNext(new a(this, str));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "api\n            .deleteS…ngesCount))\n            }");
        return doOnNext;
    }
}
