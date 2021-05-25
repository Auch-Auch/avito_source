package com.avito.android.serp.adapter;

import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0006\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/serp/adapter/FavoriteStatusResolverImpl;", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "Lcom/avito/conveyor_item/Item;", "T", "", "items", "Lio/reactivex/rxjava3/core/Observable;", "resolve", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Observable;", "", "resolveSync", "(Ljava/util/List;)V", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "favoritesInteractor", "<init>", "(Lcom/avito/android/favorite/FavoriteAdvertsInteractor;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteStatusResolverImpl implements FavoriteStatusResolver {
    public final FavoriteAdvertsInteractor a;

    public static final class a<V> implements Callable<List<? extends String>> {
        public final /* synthetic */ List a;

        public a(List list) {
            this.a = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends String> call() {
            List<Item> list = this.a;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            for (Item item : list) {
                arrayList.add(item.getStringId());
            }
            return arrayList;
        }
    }

    public static final class b<T, R> implements Function<List<? extends String>, SingleSource<? extends Map<String, ? extends Boolean>>> {
        public final /* synthetic */ FavoriteStatusResolverImpl a;

        public b(FavoriteStatusResolverImpl favoriteStatusResolverImpl) {
            this.a = favoriteStatusResolverImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.favorite.FavoriteAdvertsInteractor */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends Map<String, ? extends Boolean>> apply(List<? extends String> list) {
            List<? extends String> list2 = list;
            FavoriteAdvertsInteractor favoriteAdvertsInteractor = this.a.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            return favoriteAdvertsInteractor.getSavedFavoriteStatuses(list2);
        }
    }

    public static final class c<T, R> implements Function<Map<String, ? extends Boolean>, List<? extends T>> {
        public final /* synthetic */ List a;

        public c(List list) {
            this.a = list;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Map<String, ? extends Boolean> map) {
            Map<String, ? extends Boolean> map2 = map;
            for (T t : this.a) {
                if (t instanceof FavorableItem) {
                    T t2 = t;
                    Boolean bool = (Boolean) map2.get(t.getStringId());
                    t2.setFavorite(bool != null ? bool.booleanValue() : t.isFavorite());
                }
            }
            return this.a;
        }
    }

    @Inject
    public FavoriteStatusResolverImpl(@NotNull FavoriteAdvertsInteractor favoriteAdvertsInteractor) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsInteractor, "favoritesInteractor");
        this.a = favoriteAdvertsInteractor;
    }

    @Override // com.avito.android.serp.adapter.FavoriteStatusResolver
    @NotNull
    public <T extends Item> Observable<List<T>> resolve(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        Observable<List<T>> map = Observable.fromCallable(new a(list)).flatMapSingle(new b(this)).map(new c(list));
        Intrinsics.checkNotNullExpressionValue(map, "Observable.fromCallable …          items\n        }");
        return map;
    }

    @Override // com.avito.android.serp.adapter.FavoriteStatusResolver
    public <T extends Item> void resolveSync(@NotNull List<? extends T> list) {
        ArrayList<Item> i0 = a2.b.a.a.a.i0(list, "items");
        for (T t : list) {
            if (t instanceof FavorableItem) {
                i0.add(t);
            }
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(i0, 10));
        for (Item item : i0) {
            arrayList.add(item.getStringId());
        }
        Map<String, Boolean> savedFavoriteStatusesSync = this.a.getSavedFavoriteStatusesSync(arrayList);
        ArrayList<Item> arrayList2 = new ArrayList();
        for (T t2 : list) {
            if (t2 instanceof FavorableItem) {
                arrayList2.add(t2);
            }
        }
        for (Item item2 : arrayList2) {
            Boolean bool = savedFavoriteStatusesSync.get(item2.getStringId());
            if (bool != null) {
                ((FavorableItem) item2).setFavorite(bool.booleanValue());
            }
        }
    }
}
