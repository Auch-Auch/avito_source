package com.avito.android.favorite;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.favorite.FavoriteAdvertsEvent;
import com.avito.android.favorite.event.AddToFavoritesEvent;
import com.avito.android.favorite.event.RemoveFromFavoritesEvent;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/favorite/FavoriteAdvertsEventInteractorImpl;", "Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "Lio/reactivex/rxjava3/core/Flowable;", "Lcom/avito/android/favorite/FavoriteAdvertsEvent;", "favoritesEvents", "()Lio/reactivex/rxjava3/core/Flowable;", "event", "", "acceptEvent", "(Lcom/avito/android/favorite/FavoriteAdvertsEvent;)V", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/jakewharton/rxrelay3/Relay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/Relay;", "events", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/analytics/Analytics;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertsEventInteractorImpl implements FavoriteAdvertsEventInteractor {
    public final Relay<FavoriteAdvertsEvent> a;
    public final AccountStateProvider b;
    public final Analytics c;

    @Inject
    public FavoriteAdvertsEventInteractorImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = accountStateProvider;
        this.c = analytics;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsEventInteractor
    public void acceptEvent(@NotNull FavoriteAdvertsEvent favoriteAdvertsEvent) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsEvent, "event");
        this.a.accept(favoriteAdvertsEvent);
        if (favoriteAdvertsEvent instanceof FavoriteAdvertsEvent.AddedToFavorites) {
            FavoriteAdvertsEvent.AddedToFavorites addedToFavorites = (FavoriteAdvertsEvent.AddedToFavorites) favoriteAdvertsEvent;
            Iterator<T> it = addedToFavorites.getIds().iterator();
            while (it.hasNext()) {
                this.c.track(new AddToFavoritesEvent(it.next(), this.b.isAuthorized(), addedToFavorites.getSrc().getValue(), addedToFavorites.getSrc().getContext(), addedToFavorites.getSrc().isMarketplace()));
            }
        } else if (favoriteAdvertsEvent instanceof FavoriteAdvertsEvent.RemovedFromFavorites) {
            FavoriteAdvertsEvent.RemovedFromFavorites removedFromFavorites = (FavoriteAdvertsEvent.RemovedFromFavorites) favoriteAdvertsEvent;
            Iterator<T> it2 = removedFromFavorites.getIds().iterator();
            while (it2.hasNext()) {
                this.c.track(new RemoveFromFavoritesEvent(it2.next(), this.b.isAuthorized(), removedFromFavorites.getSrc().getValue(), removedFromFavorites.getSrc().getContext(), removedFromFavorites.getSrc().isMarketplace()));
            }
        }
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsEventProvider
    @NotNull
    public Flowable<FavoriteAdvertsEvent> favoritesEvents() {
        Flowable<FavoriteAdvertsEvent> flowable = this.a.hide().toFlowable(BackpressureStrategy.BUFFER);
        Intrinsics.checkNotNullExpressionValue(flowable, "events.hide().toFlowable…kpressureStrategy.BUFFER)");
        return flowable;
    }
}
