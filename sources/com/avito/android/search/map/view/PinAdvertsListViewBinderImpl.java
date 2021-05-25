package com.avito.android.search.map.view;

import a2.g.r.g;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.di.PinAdvertsList;
import com.avito.android.search.map.di.PublishFloatingViews;
import com.avito.android.search.map.provider.PublishFloatingViewsProvider;
import com.avito.android.search.map.view.adapter.AppendingRetryListener;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.DataSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\b\u0007\u0012\b\b\u0001\u0010#\u001a\u00020 \u0012\b\b\u0001\u0010+\u001a\u00020(\u0012\b\b\u0001\u0010'\u001a\u00020$\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0018\u0012\b\b\u0001\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/avito/android/search/map/view/PinAdvertsListViewBinderImpl;", "Lcom/avito/android/search/map/view/PinAdvertsListViewBinder;", "Lcom/avito/android/search/map/view/AdvertsListView;", "view", "", "bind", "(Lcom/avito/android/search/map/view/AdvertsListView;)V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "dataSource", "", "columnCount", "dataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;I)V", "unbind", "()V", "Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;", g.a, "Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;", "publishFloatingViewsProvider", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "f", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "appendingRetryListener", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "d", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "spanProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "e", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/konveyor/adapter/AdapterPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "c", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/serp/adapter/SerpSpanProvider;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class PinAdvertsListViewBinderImpl implements PinAdvertsListViewBinder {
    public final AdapterPresenter a;
    public final FavoriteAdvertsPresenter b;
    public final ViewedAdvertsPresenter c;
    public final SerpSpanProvider d;
    public final SpannedGridPositionProvider e;
    public final AppendingRetryListener f;
    public final PublishFloatingViewsProvider g;

    @Inject
    public PinAdvertsListViewBinderImpl(@PinAdvertsList @NotNull AdapterPresenter adapterPresenter, @PinAdvertsList @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @PinAdvertsList @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @PinAdvertsList @NotNull SerpSpanProvider serpSpanProvider, @PinAdvertsList @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @PinAdvertsList @NotNull AppendingRetryListener appendingRetryListener, @PublishFloatingViews @NotNull PublishFloatingViewsProvider publishFloatingViewsProvider) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(serpSpanProvider, "spanProvider");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(appendingRetryListener, "appendingRetryListener");
        Intrinsics.checkNotNullParameter(publishFloatingViewsProvider, "publishFloatingViewsProvider");
        this.a = adapterPresenter;
        this.b = favoriteAdvertsPresenter;
        this.c = viewedAdvertsPresenter;
        this.d = serpSpanProvider;
        this.e = spannedGridPositionProvider;
        this.f = appendingRetryListener;
        this.g = publishFloatingViewsProvider;
        serpSpanProvider.setAppendingListener(appendingRetryListener);
    }

    @Override // com.avito.android.search.map.view.AdvertsListBinder
    public void bind(@NotNull AdvertsListView advertsListView) {
        Intrinsics.checkNotNullParameter(advertsListView, "view");
        this.b.attachErrorMessageView(advertsListView);
        this.b.attachView(advertsListView);
        this.c.attachView(advertsListView);
        this.g.attachAppendingListener(this.f);
    }

    @Override // com.avito.android.search.map.view.ItemDataSourceChangeConsumer
    public void dataSourceChanged(@NotNull DataSource<? extends SpannedItem> dataSource, int i) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.d.setColumnsCount(i);
        this.d.onDataSourceChanged(dataSource);
        this.a.onDataSourceChanged(dataSource);
        this.e.setColumnsCount(i);
        this.e.onDataSourceChanged(dataSource);
        this.b.onDataSourceChanged(dataSource);
        this.c.onDataSourceChanged(dataSource);
    }

    @Override // com.avito.android.search.map.view.AdvertsListBinder
    public void unbind() {
        this.b.detachViews();
        this.c.detachView();
        this.g.detachAppendingListener();
    }
}
