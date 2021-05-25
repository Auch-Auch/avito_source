package com.avito.android.shop.detailed.item;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.recycler.base.DestroyableViewHolder;
import com.avito.android.section.SectionSnapHelper;
import com.avito.android.shop.R;
import com.avito.android.shop.detailed.ShowcaseItemDecorator;
import com.avito.android.ui.snap_helper.PagingSnapHelper;
import com.avito.android.util.TextViews;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B7\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010C\u001a\u00020>\u0012\u0006\u0010=\u001a\u000208\u0012\u0006\u0010-\u001a\u00020(\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bF\u0010GJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\fJ\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010&R\u001c\u0010-\u001a\u00020(8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u0010=\u001a\u0002088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010C\u001a\u00020>8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B¨\u0006H"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShowcaseItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/shop/detailed/item/ShowcaseItemView;", "Lcom/avito/android/recycler/base/DestroyableViewHolder;", "", "id", "", "setTag", "(Ljava/lang/String;)V", "text", "bindTitle", "onDataSourceChanged", "()V", "", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "setupViewForLargeItems", "setupViewForSmallItems", "notifyItemAtPositionChanged", "destroy", "onUnbind", "Landroidx/recyclerview/widget/SnapHelper;", "snapHelper", "t", "(Landroidx/recyclerview/widget/SnapHelper;)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "u", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Landroid/view/View;", "B", "Landroid/view/View;", "view", VKApiConst.VERSION, "I", "padding", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "w", "Landroidx/recyclerview/widget/SnapHelper;", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "title", "Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;", "x", "Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;", "presenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "z", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoritesPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoritesPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "y", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Landroid/view/View;Lcom/avito/konveyor/ItemBinder;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShowcaseItemViewImpl extends BaseViewHolder implements ShowcaseItemView, DestroyableViewHolder {
    @NotNull
    public final ViewedAdvertsPresenter A;
    public final View B;
    public final TextView s;
    public final RecyclerView t;
    public final LinearLayoutManager u;
    public final int v;
    public SnapHelper w;
    public final ShowcaseItemPresenter x;
    @NotNull
    public final AdapterPresenter y;
    @NotNull
    public final FavoriteAdvertsPresenter z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShowcaseItemViewImpl(@NotNull ShowcaseItemPresenter showcaseItemPresenter, @NotNull AdapterPresenter adapterPresenter, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @NotNull View view, @NotNull ItemBinder itemBinder) {
        super(view);
        Intrinsics.checkNotNullParameter(showcaseItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoritesPresenter");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.x = showcaseItemPresenter;
        this.y = adapterPresenter;
        this.z = favoriteAdvertsPresenter;
        this.A = viewedAdvertsPresenter;
        this.B = view;
        View findViewById = view.findViewById(R.id.showcase_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.showcase_items);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.t = recyclerView;
        this.v = view.getResources().getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.serp_horizontal_padding);
        Resources resources = recyclerView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "recycler.resources");
        recyclerView.addItemDecoration(new ShowcaseItemDecorator(resources));
        recyclerView.setItemAnimator(null);
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(getAdapterPresenter(), itemBinder);
        simpleRecyclerAdapter.setHasStableIds(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        this.u = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(simpleRecyclerAdapter);
    }

    @Override // com.avito.android.shop.detailed.item.ShowcaseItemView
    public void bindTitle(@Nullable String str) {
        TextViews.bindText$default(this.s, str, false, 2, null);
    }

    @Override // com.avito.android.recycler.base.DestroyableViewHolder
    public void destroy() {
        getFavoritesPresenter().detachViews();
        getViewedAdvertsPresenter().detachView();
    }

    @Override // com.avito.android.shop.detailed.item.ShowcaseItemView
    @NotNull
    public AdapterPresenter getAdapterPresenter() {
        return this.y;
    }

    @Override // com.avito.android.shop.detailed.item.ShowcaseItemView
    @NotNull
    public FavoriteAdvertsPresenter getFavoritesPresenter() {
        return this.z;
    }

    @Override // com.avito.android.shop.detailed.item.ShowcaseItemView
    @NotNull
    public ViewedAdvertsPresenter getViewedAdvertsPresenter() {
        return this.A;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i) {
        RecyclerView.Adapter adapter = this.t.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i);
        }
    }

    @Override // com.avito.android.shop.detailed.item.ShowcaseItemView
    public void onDataSourceChanged() {
        RecyclerView.Adapter adapter = this.t.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        getFavoritesPresenter().detachViews();
        getViewedAdvertsPresenter().detachView();
    }

    @Override // com.avito.android.shop.detailed.item.ShowcaseItemView
    public void setCurrentPosition(int i) {
        this.u.scrollToPositionWithOffset(i, this.v);
    }

    @Override // com.avito.android.shop.detailed.item.ShowcaseItemView
    public void setTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.B.setTag(str);
    }

    @Override // com.avito.android.shop.detailed.item.ShowcaseItemView
    public void setupViewForLargeItems() {
        this.t.setScrollingTouchSlop(1);
        t(new PagingSnapHelper(this.v));
    }

    @Override // com.avito.android.shop.detailed.item.ShowcaseItemView
    public void setupViewForSmallItems() {
        this.t.setScrollingTouchSlop(0);
        t(new SectionSnapHelper(GravityCompat.START, this.v));
    }

    public final void t(SnapHelper snapHelper) {
        SnapHelper snapHelper2 = this.w;
        if (snapHelper2 != null) {
            snapHelper2.attachToRecyclerView(null);
        }
        this.t.setOnFlingListener(null);
        this.t.clearOnScrollListeners();
        this.t.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.avito.android.shop.detailed.item.ShowcaseItemViewImpl$addScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (i == 0) {
                    ShowcaseItemPresenter showcaseItemPresenter = ShowcaseItemViewImpl.this.x;
                    Object tag = ShowcaseItemViewImpl.this.B.getTag();
                    Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
                    showcaseItemPresenter.onCurrentPositionChanged((String) tag, ShowcaseItemViewImpl.this.u.findFirstCompletelyVisibleItemPosition());
                }
            }
        });
        snapHelper.attachToRecyclerView(this.t);
        this.w = snapHelper;
    }
}
