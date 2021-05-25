package com.avito.android.analytics;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.event.AddToFavoriteClickStreamEvent;
import com.avito.android.analytics.event.RemoveFromFavoriteClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/analytics/FavoriteAdvertsAnalyticsInteractorImpl;", "Lcom/avito/android/analytics/FavoriteAdvertsAnalyticsInteractor;", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/rxjava3/core/Completable;", "sendAddToFavorites", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "sendRemoveFromFavorites", "Lcom/avito/android/analytics/Event;", "event", AuthSource.SEND_ABUSE, "(Lcom/avito/android/analytics/Event;)Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/account/AccountStateProvider;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertsAnalyticsInteractorImpl implements FavoriteAdvertsAnalyticsInteractor {
    public final Analytics a;
    public final AccountStateProvider b;

    public static final class a<T, R> implements Function<Boolean, SingleSource<? extends Boolean>> {
        public final /* synthetic */ FavoriteAdvertsAnalyticsInteractorImpl a;
        public final /* synthetic */ Event b;

        public a(FavoriteAdvertsAnalyticsInteractorImpl favoriteAdvertsAnalyticsInteractorImpl, Event event) {
            this.a = favoriteAdvertsAnalyticsInteractorImpl;
            this.b = event;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends Boolean> apply(Boolean bool) {
            Boolean bool2 = bool;
            if (!bool2.booleanValue()) {
                this.a.a.track(this.b);
            }
            return Single.just(bool2);
        }
    }

    @Inject
    public FavoriteAdvertsAnalyticsInteractorImpl(@NotNull Analytics analytics, @NotNull AccountStateProvider accountStateProvider) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        this.a = analytics;
        this.b = accountStateProvider;
    }

    public final Completable a(Event event) {
        Completable ignoreElement = this.b.currentAuthorized().observeOn(Schedulers.io()).flatMap(new a(this, event)).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "accountStateProvider.cur…        }.ignoreElement()");
        return ignoreElement;
    }

    @Override // com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractor
    @NotNull
    public Completable sendAddToFavorites(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return a(new AddToFavoriteClickStreamEvent(str));
    }

    @Override // com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractor
    @NotNull
    public Completable sendRemoveFromFavorites(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return a(new RemoveFromFavoriteClickStreamEvent(str));
    }
}
