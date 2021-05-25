package com.avito.android.auto_catalog;

import a2.g.r.g;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert_core.RetryListener;
import com.avito.android.advert_core.advert.GridAfterHeaderItemDecorator;
import com.avito.android.auto_catalog.items.AutoCatalogResourceProvider;
import com.avito.android.auto_catalog.items.serp.SerpHeaderItem;
import com.avito.android.deprecated_design.R;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxbinding3.view.RxMenuItem;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bg\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010U\u001a\u00020T\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010W\u001a\u00020V\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010K\u001a\u00020H¢\u0006\u0004\bX\u0010YJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u000f008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006Z"}, d2 = {"Lcom/avito/android/auto_catalog/AutoCatalogViewImpl;", "Lcom/avito/android/auto_catalog/AutoCatalogView;", "", "attach", "()V", "detach", "Lio/reactivex/Observable;", "upButtonClicks", "()Lio/reactivex/Observable;", "showError", "", "isSharingEnabled", "setupToolbar", "(Z)V", "", "Lcom/avito/android/serp/adapter/SpannedItem;", "items", "bindItems", "(Ljava/util/List;)V", "shareButtonClicks", "", VKApiConst.POSITION, "notifyItemAtPositionChanged", "(I)V", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "i", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "spanProvider", "", "c", "Ljava/util/List;", "recyclerItems", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "j", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "k", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/advert_core/RetryListener;", "n", "Lcom/avito/android/advert_core/RetryListener;", "retryListener", "Lcom/avito/konveyor/data_source/ListDataSource;", "d", "Lcom/avito/konveyor/data_source/ListDataSource;", "itemsDatasource", "Landroid/view/View;", "f", "Landroid/view/View;", "view", "Lcom/avito/konveyor/adapter/AdapterPresenter;", g.a, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "e", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecorator", "Lcom/avito/android/util/DeviceMetrics;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/ui/adapter/AppendingListener;", "o", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "l", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "h", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "recyclerAdapter", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;", "resourceProvider", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/SafeRecyclerAdapter;Lcom/avito/android/serp/adapter/SerpSpanProvider;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/advert_core/RetryListener;Lcom/avito/android/ui/adapter/AppendingListener;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class AutoCatalogViewImpl implements AutoCatalogView {
    public final RecyclerView a;
    public final Toolbar b;
    public List<SpannedItem> c;
    public final ListDataSource<SpannedItem> d;
    public RecyclerView.ItemDecoration e;
    public final View f;
    public final AdapterPresenter g;
    public final SafeRecyclerAdapter h;
    public final SerpSpanProvider i;
    public final SpannedGridPositionProvider j;
    public final FavoriteAdvertsPresenter k;
    public final ViewedAdvertsPresenter l;
    public final DeviceMetrics m;
    public final RetryListener n;
    public final AppendingListener o;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AutoCatalogViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AutoCatalogViewImpl autoCatalogViewImpl) {
            super(0);
            this.a = autoCatalogViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.n.onRetry();
            return Unit.INSTANCE;
        }
    }

    public AutoCatalogViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull SafeRecyclerAdapter safeRecyclerAdapter, @NotNull SerpSpanProvider serpSpanProvider, @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @NotNull AutoCatalogResourceProvider autoCatalogResourceProvider, @NotNull DeviceMetrics deviceMetrics, @NotNull RetryListener retryListener, @NotNull AppendingListener appendingListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(safeRecyclerAdapter, "recyclerAdapter");
        Intrinsics.checkNotNullParameter(serpSpanProvider, "spanProvider");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(spanSizeLookup, "spanSizeLookup");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(autoCatalogResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(retryListener, "retryListener");
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        this.f = view;
        this.g = adapterPresenter;
        this.h = safeRecyclerAdapter;
        this.i = serpSpanProvider;
        this.j = spannedGridPositionProvider;
        this.k = favoriteAdvertsPresenter;
        this.l = viewedAdvertsPresenter;
        this.m = deviceMetrics;
        this.n = retryListener;
        this.o = appendingListener;
        View findViewById = view.findViewById(R.id.auto_catalog_recycler);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.auto_catalog_recycler)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.b = (Toolbar) findViewById2;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.d = new ListDataSource<>(arrayList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), autoCatalogResourceProvider.spanCount(), 1, false);
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(null);
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogView
    public void attach() {
        this.k.attachView(this);
        this.l.attachView(this);
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogView
    public void bindItems(@NotNull List<? extends SpannedItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.c.clear();
        this.c.addAll(list);
        if (this.a.getAdapter() == null) {
            this.i.setAppendingListener(this.o);
            this.i.onDataSourceChanged(this.d);
            this.j.onDataSourceChanged(this.d);
            this.g.onDataSourceChanged(this.d);
            this.k.onDataSourceChanged(this.d);
            this.l.onDataSourceChanged(this.d);
            this.a.setAdapter(this.h);
        } else {
            RecyclerView.Adapter adapter = this.a.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        int i2 = 0;
        Iterator<SpannedItem> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (it.next() instanceof SerpHeaderItem) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 > -1) {
            RecyclerView.ItemDecoration itemDecoration = this.e;
            if (itemDecoration != null) {
                this.a.removeItemDecoration(itemDecoration);
            }
            List listOf = d.listOf(Integer.valueOf(i2));
            int columnsCount = this.i.getColumnsCount();
            Resources resources = this.f.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
            GridAfterHeaderItemDecorator gridAfterHeaderItemDecorator = new GridAfterHeaderItemDecorator(listOf, columnsCount, resources, this.m);
            this.e = gridAfterHeaderItemDecorator;
            this.a.addItemDecoration(gridAfterHeaderItemDecorator);
        }
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogView
    public void detach() {
        this.k.detachViews();
        this.l.detachView();
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i2) {
        RecyclerView.Adapter adapter = this.a.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i2);
        }
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogView
    public void setupToolbar(boolean z) {
        Toolbars.setBackIconByAttr(this.b, com.avito.android.lib.design.R.attr.black);
        if (z && !this.b.getMenu().hasVisibleItems()) {
            this.b.inflateMenu(R.menu.auto_catalog);
            Toolbars.tintMenuByAttr(this.b, com.avito.android.lib.design.R.attr.blue);
        }
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogView
    @NotNull
    public Observable<Unit> shareButtonClicks() {
        MenuItem findItem = this.b.getMenu().findItem(R.id.menu_share);
        if (findItem != null) {
            return RxMenuItem.clicks$default(findItem, null, 1, null);
        }
        throw new IllegalArgumentException("Toolbar was not inflated".toString());
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogView
    public void showError() {
        View view = this.f;
        String string = view.getResources().getString(R.string.network_retry_message_auto_catalog);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString…try_message_auto_catalog)");
        Views.showCustomSnackbar$default(view, com.avito.android.advert_core.R.layout.network_retry, string, -2, com.avito.android.advert_core.R.id.advert_network_error_text, com.avito.android.advert_core.R.id.advert_network_error_retry, null, new a(this), 32, null);
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogView
    @NotNull
    public Observable<Unit> upButtonClicks() {
        return InteropKt.toV2(Toolbars.upClicks(this.b));
    }
}
