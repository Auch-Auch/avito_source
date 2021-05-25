package com.avito.android.brandspace.items.marketplace.carouselLoader;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.brandspace.items.carousel.CarouselDecoration;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.FixedWidthLinearLayoutManager;
import com.avito.android.brandspace.view.decorators.SnippetSkeletonItemDecoration;
import com.avito.android.recycler.base.DestroyableViewHolder;
import com.avito.android.ui_components.R;
import com.avito.android.util.RecyclerViewsKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.ListRecyclerAdapter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B;\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020+\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010-\u0012\b\b\u0002\u00100\u001a\u00020/\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010/¢\u0006\u0004\b2\u00103J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u00020\u001c8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u00064"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderItemView;", "Lcom/avito/android/recycler/base/DestroyableViewHolder;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "items", "", "bindGrid", "(Ljava/util/List;)V", "bindHorizontal", "onUnbind", "()V", "destroy", "Lcom/avito/android/brandspace/items/carousel/CarouselDecoration;", "u", "Lcom/avito/android/brandspace/items/carousel/CarouselDecoration;", "carouselDecoration", "Lcom/avito/konveyor/adapter/ListRecyclerAdapter;", "s", "Lcom/avito/konveyor/adapter/ListRecyclerAdapter;", "listAdapter", "Landroidx/recyclerview/widget/GridLayoutManager;", "w", "Lkotlin/Lazy;", "getGridLayoutManager", "()Landroidx/recyclerview/widget/GridLayoutManager;", "gridLayoutManager", "Lcom/avito/android/brandspace/presenter/FixedWidthLinearLayoutManager;", "x", "getScrollableLayoutManager", "()Lcom/avito/android/brandspace/presenter/FixedWidthLinearLayoutManager;", "scrollableLayoutManager", "Landroidx/recyclerview/widget/RecyclerView;", "t", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/brandspace/view/decorators/SnippetSkeletonItemDecoration;", VKApiConst.VERSION, "Lcom/avito/android/brandspace/view/decorators/SnippetSkeletonItemDecoration;", "snippetSkeletonItemDecoration", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroid/view/View;", "view", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "viewHolderProvider", "", "columnOffset", "itemFixedWidth", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Landroid/view/View;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;ILjava/lang/Integer;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselLoaderItemViewImpl extends BaseViewHolder implements CarouselLoaderItemView, DestroyableViewHolder {
    public ListRecyclerAdapter s;
    public final RecyclerView t;
    public final CarouselDecoration u;
    public final SnippetSkeletonItemDecoration v;
    public final Lazy w;
    public final Lazy x;

    public static final class a extends Lambda implements Function0<GridLayoutManager> {
        public final /* synthetic */ View a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(0);
            this.a = view;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public GridLayoutManager invoke() {
            return new GridLayoutManager(this.a.getContext(), 1);
        }
    }

    public static final class b extends Lambda implements Function0<FixedWidthLinearLayoutManager> {
        public final /* synthetic */ View a;
        public final /* synthetic */ Integer b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view, Integer num) {
            super(0);
            this.a = view;
            this.b = num;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public FixedWidthLinearLayoutManager invoke() {
            return new FixedWidthLinearLayoutManager(this.a.getContext(), 0, false, this.b, false);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CarouselLoaderItemViewImpl(AdapterPresenter adapterPresenter, View view, ViewHolderBuilder viewHolderBuilder, int i, Integer num, int i2, j jVar) {
        this(adapterPresenter, view, viewHolderBuilder, (i2 & 8) != 0 ? view.getResources().getDimensionPixelOffset(R.dimen.rds_column_offset) : i, (i2 & 16) != 0 ? null : num);
    }

    @Override // com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderItemView
    public void bindGrid(@NotNull List<? extends BrandspaceItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        ((GridLayoutManager) this.w.getValue()).setSpanCount(list.size() / 3);
        this.t.addItemDecoration(this.v);
        this.t.setLayoutManager((GridLayoutManager) this.w.getValue());
        this.t.setAdapter(this.s);
        this.s.submitList(list);
    }

    @Override // com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderItemView
    public void bindHorizontal(@NotNull List<? extends BrandspaceItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.t.addItemDecoration(this.u);
        this.t.setLayoutManager((FixedWidthLinearLayoutManager) this.x.getValue());
        this.t.setAdapter(this.s);
        this.s.submitList(list);
    }

    @Override // com.avito.android.recycler.base.DestroyableViewHolder
    public void destroy() {
        this.t.setAdapter(null);
        this.t.setLayoutManager(null);
        this.s.submitList(null);
        RecyclerViewsKt.clearItemDecorations(this.t);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        destroy();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselLoaderItemViewImpl(@NotNull AdapterPresenter adapterPresenter, @NotNull View view, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, int i, @Nullable Integer num) {
        super(view);
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderProvider");
        this.s = new ListRecyclerAdapter(adapterPresenter, viewHolderBuilder, null, 4, null);
        View findViewById = view.findViewById(com.avito.android.brandspace.R.id.recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.t = (RecyclerView) findViewById;
        this.u = new CarouselDecoration(i, false);
        this.v = new SnippetSkeletonItemDecoration();
        this.w = c.lazy(new a(view));
        this.x = c.lazy(new b(view, num));
    }
}
