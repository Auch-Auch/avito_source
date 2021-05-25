package com.avito.android.serp.adapter;

import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0006\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/serp/adapter/ViewedStatusResolverImpl;", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "Lcom/avito/conveyor_item/Item;", "T", "", "items", "Lio/reactivex/rxjava3/core/Observable;", "resolve", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Observable;", "", "resolveSync", "(Ljava/util/List;)V", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "viewedAdvertsInteractor", "<init>", "(Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;)V", "viewed-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedStatusResolverImpl implements ViewedStatusResolver {
    public final ViewedAdvertsInteractor a;

    public static final class a<T, R> implements Function<T, T> {
        public final /* synthetic */ ViewedStatusResolverImpl a;

        public a(ViewedStatusResolverImpl viewedStatusResolverImpl) {
            this.a = viewedStatusResolverImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            Item item = (Item) obj;
            if (item instanceof ViewedAdvertItem) {
                ((ViewedAdvertItem) item).setViewed(this.a.a.isViewed(item.getStringId()));
            }
            return item;
        }
    }

    public ViewedStatusResolverImpl(@NotNull ViewedAdvertsInteractor viewedAdvertsInteractor) {
        Intrinsics.checkNotNullParameter(viewedAdvertsInteractor, "viewedAdvertsInteractor");
        this.a = viewedAdvertsInteractor;
    }

    @Override // com.avito.android.serp.adapter.ViewedStatusResolver
    @NotNull
    public <T extends Item> Observable<List<T>> resolve(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        Observable<List<T>> observable = Observable.fromIterable(list).map(new a(this)).toList().toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "Observable.fromIterable(…          .toObservable()");
        return observable;
    }

    @Override // com.avito.android.serp.adapter.ViewedStatusResolver
    public <T extends Item> void resolveSync(@NotNull List<? extends T> list) {
        ArrayList<Item> i0 = a2.b.a.a.a.i0(list, "items");
        for (T t : list) {
            if (t instanceof ViewedAdvertItem) {
                i0.add(t);
            }
        }
        for (Item item : i0) {
            ((ViewedAdvertItem) item).setViewed(this.a.isViewed(item.getStringId()));
        }
    }
}
