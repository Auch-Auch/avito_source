package com.avito.android.favorite;

import io.reactivex.rxjava3.core.Flowable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/favorite/FavoriteAdvertsEventProvider;", "", "Lio/reactivex/rxjava3/core/Flowable;", "Lcom/avito/android/favorite/FavoriteAdvertsEvent;", "favoritesEvents", "()Lio/reactivex/rxjava3/core/Flowable;", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteAdvertsEventProvider {
    @NotNull
    Flowable<FavoriteAdvertsEvent> favoritesEvents();
}
