package com.avito.android.search.map.view;

import a2.g.r.g;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.search.map.di.PublishFloatingViews;
import com.avito.android.search.map.di.SerpList;
import com.avito.android.search.map.provider.PublishFloatingViewsProvider;
import com.avito.android.search.map.view.adapter.AppendingRetryListener;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.serp.adapter.closable.ClosedItemPresenter;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.DataSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bi\b\u0007\u0012\b\b\u0001\u0010!\u001a\u00020\u001e\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0016\u0012\b\b\u0001\u0010%\u001a\u00020\"\u0012\b\b\u0001\u00105\u001a\u000202\u0012\b\b\u0001\u00101\u001a\u00020.\u0012\u0006\u0010)\u001a\u00020&\u0012\b\b\u0001\u0010-\u001a\u00020*\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u00109\u001a\u000206¢\u0006\u0004\b:\u0010;J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\u000e\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/avito/android/search/map/view/SerpListViewBinderImpl;", "Lcom/avito/android/search/map/view/SerpListViewBinder;", "Lcom/avito/android/search/map/view/AdvertsListView;", "view", "", "bind", "(Lcom/avito/android/search/map/view/AdvertsListView;)V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "spannedItems", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "serpItems", "", "columnCount", "dataSourcesChanged", "(Lcom/avito/konveyor/data_source/DataSource;Lcom/avito/konveyor/data_source/DataSource;I)V", "unbind", "()V", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "c", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;", "i", "Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;", "publishFloatingViewsProvider", "Lcom/avito/konveyor/adapter/AdapterPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "d", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "spanProvider", "Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;", g.a, "Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;", "closedItemPresenter", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "h", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "appendingRetryListener", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "f", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "listItemVisibilityTracker", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "e", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "j", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "snippetScrollDepthTracker", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/serp/adapter/SerpSpanProvider;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SerpListViewBinderImpl implements SerpListViewBinder {
    public final AdapterPresenter a;
    public final FavoriteAdvertsPresenter b;
    public final ViewedAdvertsPresenter c;
    public final SerpSpanProvider d;
    public final SpannedGridPositionProvider e;
    public final ItemVisibilityTracker f;
    public final ClosedItemPresenter g;
    public final AppendingRetryListener h;
    public final PublishFloatingViewsProvider i;
    public final SnippetScrollDepthTracker j;

    @Inject
    public SerpListViewBinderImpl(@SerpList @NotNull AdapterPresenter adapterPresenter, @SerpList @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @SerpList @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @SerpList @NotNull SerpSpanProvider serpSpanProvider, @SerpList @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @SerpList @NotNull ItemVisibilityTracker itemVisibilityTracker, @NotNull ClosedItemPresenter closedItemPresenter, @SerpList @NotNull AppendingRetryListener appendingRetryListener, @PublishFloatingViews @NotNull PublishFloatingViewsProvider publishFloatingViewsProvider, @NotNull SnippetScrollDepthTracker snippetScrollDepthTracker) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(serpSpanProvider, "spanProvider");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(itemVisibilityTracker, "listItemVisibilityTracker");
        Intrinsics.checkNotNullParameter(closedItemPresenter, "closedItemPresenter");
        Intrinsics.checkNotNullParameter(appendingRetryListener, "appendingRetryListener");
        Intrinsics.checkNotNullParameter(publishFloatingViewsProvider, "publishFloatingViewsProvider");
        Intrinsics.checkNotNullParameter(snippetScrollDepthTracker, "snippetScrollDepthTracker");
        this.a = adapterPresenter;
        this.b = favoriteAdvertsPresenter;
        this.c = viewedAdvertsPresenter;
        this.d = serpSpanProvider;
        this.e = spannedGridPositionProvider;
        this.f = itemVisibilityTracker;
        this.g = closedItemPresenter;
        this.h = appendingRetryListener;
        this.i = publishFloatingViewsProvider;
        this.j = snippetScrollDepthTracker;
        serpSpanProvider.setAppendingListener(appendingRetryListener);
    }

    @Override // com.avito.android.search.map.view.AdvertsListBinder
    public void bind(@NotNull AdvertsListView advertsListView) {
        Intrinsics.checkNotNullParameter(advertsListView, "view");
        this.b.attachErrorMessageView(advertsListView);
        this.b.attachView(advertsListView);
        this.c.attachView(advertsListView);
        this.g.attachView(advertsListView);
        this.i.attachAppendingListener(this.h);
    }

    @Override // com.avito.android.search.map.view.SerpDataSourcesChangeConsumer
    public void dataSourcesChanged(@NotNull DataSource<SpannedItem> dataSource, @NotNull DataSource<ViewTypeSerpItem> dataSource2, int i2) {
        Intrinsics.checkNotNullParameter(dataSource, "spannedItems");
        Intrinsics.checkNotNullParameter(dataSource2, "serpItems");
        this.d.setColumnsCount(i2);
        this.d.onDataSourceChanged(dataSource);
        this.a.onDataSourceChanged(dataSource2);
        this.e.setColumnsCount(i2);
        this.e.onDataSourceChanged(dataSource);
        this.b.onDataSourceChanged(dataSource2);
        this.c.onDataSourceChanged(dataSource2);
        this.g.onDataSourceChanged(dataSource2);
        this.f.onDataSourceChanged(dataSource2);
        this.j.onDataSourceChanged(dataSource2);
    }

    @Override // com.avito.android.search.map.view.AdvertsListBinder
    public void unbind() {
        this.b.detachViews();
        this.c.detachView();
        this.g.detachView();
        this.i.detachAppendingListener();
    }
}
