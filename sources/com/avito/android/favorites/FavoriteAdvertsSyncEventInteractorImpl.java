package com.avito.android.favorites;

import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.ReplayRelay;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertsSyncEventInteractorImpl;", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEventInteractor;", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent;", "event", "", "acceptEvent", "(Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent;)V", "Lio/reactivex/rxjava3/core/Observable;", "observeEvents", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/jakewharton/rxrelay3/ReplayRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/ReplayRelay;", "relay", "<init>", "()V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertsSyncEventInteractorImpl implements FavoriteAdvertsSyncEventInteractor {
    public final ReplayRelay<FavoriteAdvertsSyncEvent> a;

    public FavoriteAdvertsSyncEventInteractorImpl() {
        ReplayRelay<FavoriteAdvertsSyncEvent> createWithSize = ReplayRelay.createWithSize(1);
        Intrinsics.checkNotNullExpressionValue(createWithSize, "ReplayRelay.createWithSize(1)");
        this.a = createWithSize;
    }

    @Override // com.avito.android.favorites.FavoriteAdvertsSyncEventInteractor
    public void acceptEvent(@NotNull FavoriteAdvertsSyncEvent favoriteAdvertsSyncEvent) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsSyncEvent, "event");
        this.a.accept(favoriteAdvertsSyncEvent);
    }

    @Override // com.avito.android.favorites.FavoriteAdvertsSyncEventProvider
    @NotNull
    public Observable<FavoriteAdvertsSyncEvent> observeEvents() {
        Observable<FavoriteAdvertsSyncEvent> hide = this.a.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "relay.hide()");
        return hide;
    }
}
