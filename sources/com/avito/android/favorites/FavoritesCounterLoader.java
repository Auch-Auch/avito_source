package com.avito.android.favorites;

import com.avito.android.common.CounterLoader;
import com.avito.android.favorites.remote.FavoritesApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.FavoritesCount;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/favorites/FavoritesCounterLoader;", "Lcom/avito/android/common/CounterLoader;", "Lio/reactivex/rxjava3/core/Observable;", "", "load", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/favorites/remote/FavoritesApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/favorites/remote/FavoritesApi;", "api", "<init>", "(Lcom/avito/android/favorites/remote/FavoritesApi;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoritesCounterLoader implements CounterLoader {
    public final FavoritesApi a;

    public static final class a<T, R> implements Function<FavoritesCount, Integer> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(FavoritesCount favoritesCount) {
            return Integer.valueOf(favoritesCount.getCount());
        }
    }

    @Inject
    public FavoritesCounterLoader(@NotNull FavoritesApi favoritesApi) {
        Intrinsics.checkNotNullParameter(favoritesApi, "api");
        this.a = favoritesApi;
    }

    @Override // com.avito.android.common.CounterLoader
    @NotNull
    public Observable<Integer> load() {
        Observable<Integer> map = TypedObservablesKt.toTyped(this.a.getFavoritesCount()).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getFavoritesCount().toTyped().map { it.count }");
        return map;
    }
}
