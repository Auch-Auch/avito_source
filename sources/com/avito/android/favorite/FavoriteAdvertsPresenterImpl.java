package com.avito.android.favorite;

import a2.a.a.r0.c;
import a2.g.r.g;
import com.avito.android.favorite.FavoriteActionSource;
import com.avito.android.legacy_mvp.ErrorMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Singles;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.IterableDataSource;
import com.avito.konveyor.util.DataSources;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00109\u001a\u000206¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u000fJ\u001f\u0010\u0017\u001a\u00020\u00042\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001b\u001a\u00020\u00042\u0016\u0010\u001a\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R&\u0010\u001a\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.RD\u00105\u001a0\u0012\f\u0012\n 1*\u0004\u0018\u00010\n0\n 1*\u0017\u0012\f\u0012\n 1*\u0004\u0018\u00010\n0\n\u0018\u000100¢\u0006\u0002\b200¢\u0006\u0002\b28\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/avito/android/favorite/FavoriteAdvertsPresenterImpl;", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "view", "", "attachView", "(Lcom/avito/android/favorite/FavoriteAdvertsView;)V", "Lcom/avito/android/legacy_mvp/ErrorMessageView;", "attachErrorMessageView", "(Lcom/avito/android/legacy_mvp/ErrorMessageView;)V", "Lcom/avito/android/serp/adapter/FavorableItem;", "favorableItem", "onFavoriteButtonClicked", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", "wipeSynchronizedIds", "()V", "Lio/reactivex/rxjava3/core/Observable;", "subscribeToFavoriteButtonClicked", "()Lio/reactivex/rxjava3/core/Observable;", "detachViews", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "secondaryDataSources", "onSecondaryDataSourcesChanged", "(Ljava/util/List;)V", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", g.a, "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "interactor", "d", "Lcom/avito/android/legacy_mvp/ErrorMessageView;", "errorView", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "e", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;", "h", "Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;", "resourceProvider", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "f", "Lcom/jakewharton/rxrelay3/PublishRelay;", "favoriteButtonClicked", "Lcom/avito/android/util/SchedulersFactory3;", "i", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "c", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "<init>", "(Lcom/avito/android/favorite/FavoriteAdvertsInteractor;Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;Lcom/avito/android/util/SchedulersFactory3;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertsPresenterImpl implements FavoriteAdvertsPresenter {
    public DataSource<? extends Item> a;
    public List<? extends DataSource<? extends Item>> b;
    public FavoriteAdvertsView c;
    public ErrorMessageView d;
    public final CompositeDisposable e = new CompositeDisposable();
    public final PublishRelay<FavorableItem> f = PublishRelay.create();
    public final FavoriteAdvertsInteractor g;
    public final FavoriteAdvertsResourceProvider h;
    public final SchedulersFactory3 i;

    public static final class a implements Action {
        public static final a a = new a();

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    @Inject
    public FavoriteAdvertsPresenterImpl(@NotNull FavoriteAdvertsInteractor favoriteAdvertsInteractor, @NotNull FavoriteAdvertsResourceProvider favoriteAdvertsResourceProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(favoriteAdvertsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.g = favoriteAdvertsInteractor;
        this.h = favoriteAdvertsResourceProvider;
        this.i = schedulersFactory3;
    }

    public static final void access$changeAdvertsFavorite(FavoriteAdvertsPresenterImpl favoriteAdvertsPresenterImpl, List list, boolean z) {
        DataSource<? extends Item> dataSource = favoriteAdvertsPresenterImpl.a;
        if (dataSource != null) {
            int i2 = 0;
            int i3 = 0;
            for (Object obj : DataSources.toIterableDataSource(dataSource)) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Item item = (Item) obj;
                if (item instanceof FavorableItem) {
                    FavorableItem favorableItem = (FavorableItem) item;
                    if (list.contains(favorableItem.getStringId())) {
                        favorableItem.setFavorite(z);
                        FavoriteAdvertsView favoriteAdvertsView = favoriteAdvertsPresenterImpl.c;
                        if (favoriteAdvertsView != null) {
                            favoriteAdvertsView.notifyItemAtPositionChanged(i3);
                        }
                    }
                }
                i3 = i4;
            }
            List<? extends DataSource<? extends Item>> list2 = favoriteAdvertsPresenterImpl.b;
            if (list2 != null) {
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(DataSources.toIterableDataSource(it.next()));
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Object next = it2.next();
                    int i5 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    IterableDataSource iterableDataSource = (IterableDataSource) next;
                    if (iterableDataSource instanceof FavorableItem) {
                        FavorableItem favorableItem2 = (FavorableItem) iterableDataSource;
                        if (list.contains(favorableItem2.getStringId())) {
                            favorableItem2.setFavorite(z);
                        }
                    }
                    i2 = i5;
                }
            }
        }
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsPresenter
    public void attachErrorMessageView(@NotNull ErrorMessageView errorMessageView) {
        Intrinsics.checkNotNullParameter(errorMessageView, "view");
        this.d = errorMessageView;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsPresenter
    public void attachView(@NotNull FavoriteAdvertsView favoriteAdvertsView) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsView, "view");
        this.c = favoriteAdvertsView;
        CompositeDisposable compositeDisposable = this.e;
        Disposable subscribe = this.g.favoritesEvents().observeOn(this.i.mainThread()).subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.favoritesEven…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsPresenter
    public void detachViews() {
        this.c = null;
        this.d = null;
        this.e.clear();
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsPresenter
    public void onDataSourceChanged(@NotNull DataSource<? extends Item> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.a = dataSource;
    }

    @Override // com.avito.android.favorite.FavoriteButtonClickListener
    public void onFavoriteButtonClicked(@NotNull FavorableItem favorableItem) {
        Intrinsics.checkNotNullParameter(favorableItem, "favorableItem");
        this.f.accept(favorableItem);
        DisposableKt.plusAssign(this.e, Singles.subscribeIgnoreResult(this.g.toggleFavoriteStatus(favorableItem.getStringId(), new FavoriteActionSource.Snippet(favorableItem.getAnalyticsContext()), favorableItem.isFavorite())));
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsPresenter
    public void onSecondaryDataSourcesChanged(@Nullable List<? extends DataSource<? extends Item>> list) {
        this.b = list;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsPresenter
    @NotNull
    public Observable<FavorableItem> subscribeToFavoriteButtonClicked() {
        PublishRelay<FavorableItem> publishRelay = this.f;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "favoriteButtonClicked");
        return publishRelay;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsPresenter
    public void wipeSynchronizedIds() {
        CompositeDisposable compositeDisposable = this.e;
        Disposable subscribe = this.g.wipeSynced().subscribe(a.a, b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.wipeSynced().subscribe({}) {}");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
