package com.avito.android.brandspace.view;

import a2.g.r.g;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabsItem;
import com.avito.android.brandspace.items.text.TextItem;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import com.avito.android.brandspace.view.decorators.BrandspaceAdvertItemDecoration;
import com.avito.android.brandspace.view.decorators.BrandspaceItemDecoration;
import com.avito.android.brandspace.view.decorators.BrandspaceMarketplaceSinppetItemDecoration;
import com.avito.android.deprecated_design.R;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.adapter.ListRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010K\u001a\u00020F¢\u0006\u0004\bP\u0010QJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\bR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010K\u001a\u00020F8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006R"}, d2 = {"Lcom/avito/android/brandspace/view/BrandspaceViewImpl;", "Lcom/avito/android/brandspace/view/BrandspaceView;", "", VKApiConst.POSITION, "", "notifyItemAtPositionChanged", "(I)V", "showLoading", "()V", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "items", "showItems", "(Ljava/util/List;)V", "showItemsWithPostRefresh", "", "message", "showError", "(Ljava/lang/String;)V", "title", "showTitle", "destroy", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", g.a, "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "presenter", "Lcom/avito/android/analytics/Analytics;", "h", "Lcom/avito/android/analytics/Analytics;", "analytics", "", "e", "Ljava/util/List;", "headerPositions", "Lcom/avito/android/util/DeviceMetrics;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/brandspace/view/BrandpaceSpanProvider;", "j", "Lcom/avito/android/brandspace/view/BrandpaceSpanProvider;", "spanProvider", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "l", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "brandspaceResources", "Lcom/avito/konveyor/adapter/ListRecyclerAdapter;", "i", "Lcom/avito/konveyor/adapter/ListRecyclerAdapter;", "adapter", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "k", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableViewHolderBuilder", "Landroidx/recyclerview/widget/GridLayoutManager;", "d", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "n", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "getItemVisibilityTracker", "()Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "Landroid/view/View;", "f", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/brandspace/presenter/BrandspacePresenter;Lcom/avito/android/analytics/Analytics;Lcom/avito/konveyor/adapter/ListRecyclerAdapter;Lcom/avito/android/brandspace/view/BrandpaceSpanProvider;Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceViewImpl implements BrandspaceView {
    public final Toolbar a;
    public final RecyclerView b;
    public final ProgressOverlay c;
    public final GridLayoutManager d;
    public List<Integer> e = new ArrayList();
    public final View f;
    public final BrandspacePresenter g;
    public final Analytics h;
    public final ListRecyclerAdapter i;
    public final BrandpaceSpanProvider j;
    public final DestroyableViewHolderBuilder k;
    public final BrandspaceResourcesProvider l;
    public final DeviceMetrics m;
    @NotNull
    public final ItemVisibilityTracker n;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BrandspaceViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BrandspaceViewImpl brandspaceViewImpl) {
            super(0);
            this.a = brandspaceViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.g.onRetryClicked();
            return Unit.INSTANCE;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ BrandspaceViewImpl a;

        public b(BrandspaceViewImpl brandspaceViewImpl) {
            this.a = brandspaceViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.g.onUpClicked();
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ BrandspaceViewImpl a;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;

            public a(c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.b.requestLayout();
            }
        }

        public c(BrandspaceViewImpl brandspaceViewImpl) {
            this.a = brandspaceViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b.post(new a(this));
        }
    }

    public BrandspaceViewImpl(@NotNull View view, @NotNull BrandspacePresenter brandspacePresenter, @NotNull Analytics analytics, @NotNull ListRecyclerAdapter listRecyclerAdapter, @NotNull BrandpaceSpanProvider brandpaceSpanProvider, @NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder, @NotNull BrandspaceResourcesProvider brandspaceResourcesProvider, @NotNull DeviceMetrics deviceMetrics, @NotNull ItemVisibilityTracker itemVisibilityTracker) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(brandspacePresenter, "presenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(listRecyclerAdapter, "adapter");
        Intrinsics.checkNotNullParameter(brandpaceSpanProvider, "spanProvider");
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "destroyableViewHolderBuilder");
        Intrinsics.checkNotNullParameter(brandspaceResourcesProvider, "brandspaceResources");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(itemVisibilityTracker, "itemVisibilityTracker");
        this.f = view;
        this.g = brandspacePresenter;
        this.h = analytics;
        this.i = listRecyclerAdapter;
        this.j = brandpaceSpanProvider;
        this.k = destroyableViewHolderBuilder;
        this.l = brandspaceResourcesProvider;
        this.m = deviceMetrics;
        this.n = itemVisibilityTracker;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.a = (Toolbar) findViewById;
        int i2 = com.avito.android.brandspace.R.id.brandspace_recycler;
        View findViewById2 = view.findViewById(i2);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.b = recyclerView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), brandspaceResourcesProvider.getBrandspaceColumnCount());
        this.d = gridLayoutManager;
        View findViewById3 = view.findViewById(com.avito.android.brandspace.R.id.brandspace_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById3, i2, analytics, false, 0, 24, null);
        this.c = progressOverlay;
        progressOverlay.setToolbarPadding();
        progressOverlay.setOnRefreshListener(new a(this));
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.avito.android.brandspace.view.BrandspaceViewImpl$createSpanSizeLookup$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i3) {
                List currentList = BrandspaceViewImpl.this.i.getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList, "adapter.currentList");
                Object orNull = CollectionsKt___CollectionsKt.getOrNull(currentList, i3);
                if (!(orNull instanceof BrandspaceItem)) {
                    orNull = null;
                }
                BrandspaceItem brandspaceItem = (BrandspaceItem) orNull;
                if (brandspaceItem != null) {
                    return BrandspaceViewImpl.this.j.getSpanCount(brandspaceItem);
                }
                return 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        List<Integer> list = this.e;
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        List<Integer> list2 = this.e;
        Resources resources2 = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
        for (BrandspaceItemDecoration brandspaceItemDecoration : CollectionsKt__CollectionsKt.listOf((Object[]) new BrandspaceItemDecoration[]{new BrandspaceAdvertItemDecoration(list, brandspaceResourcesProvider, resources, deviceMetrics), new BrandspaceMarketplaceSinppetItemDecoration(list2, brandspaceResourcesProvider, resources2, deviceMetrics)})) {
            this.b.addItemDecoration(brandspaceItemDecoration);
        }
        this.a.setNavigationOnClickListener(new b(this));
    }

    @Override // com.avito.android.util.architecture_components.auto_clear.LifecycleDestroyable
    public void destroy() {
        this.b.setAdapter(null);
        this.k.destroy();
    }

    @Override // com.avito.android.brandspace.view.BrandspaceView
    @NotNull
    public ItemVisibilityTracker getItemVisibilityTracker() {
        return this.n;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i2) {
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i2, Unit.INSTANCE);
        }
    }

    @Override // com.avito.android.brandspace.view.BrandspaceView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.c.showLoadingProblem(str);
    }

    @Override // com.avito.android.brandspace.view.BrandspaceView
    public void showItems(@NotNull List<? extends BrandspaceItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.c.showContent();
        this.e.clear();
        List<Integer> list2 = this.e;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        int i2 = 0;
        while (true) {
            Integer num = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t = next;
            if ((t instanceof TextItem) || (t instanceof MarketplaceTabsItem)) {
                num = Integer.valueOf(i2);
            }
            if (num != null) {
                arrayList.add(num);
            }
            i2 = i3;
        }
        list2.addAll(arrayList);
        getItemVisibilityTracker().onDataSourceChanged(new ListDataSource(list));
        this.i.submitList(list);
        if (this.b.getAdapter() == null) {
            this.b.setAdapter(this.i);
            ItemVisibilityTracker.DefaultImpls.subscribe$default(getItemVisibilityTracker(), this.b, null, 2, null);
        }
    }

    @Override // com.avito.android.brandspace.view.BrandspaceView
    public void showItemsWithPostRefresh(@NotNull List<? extends BrandspaceItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        showItems(list);
        this.i.submitList(list, new c(this));
    }

    @Override // com.avito.android.brandspace.view.BrandspaceView
    public void showLoading() {
        this.c.showLoading();
    }

    @Override // com.avito.android.brandspace.view.BrandspaceView
    public void showTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a.setTitle(str);
    }
}
