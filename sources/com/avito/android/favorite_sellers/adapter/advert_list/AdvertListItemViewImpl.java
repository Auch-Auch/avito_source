package com.avito.android.favorite_sellers.adapter.advert_list;

import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite_sellers_items.R;
import com.avito.android.recycler.base.DestroyableViewHolder;
import com.avito.android.section.SectionSnapHelper;
import com.avito.android.ui.snap_helper.PagingSnapHelper;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B7\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u00104\u001a\u00020/\u0012\u0006\u0010'\u001a\u00020\"\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010EJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u000eJ\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u000eJ\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010!\u001a\u00020\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010'\u001a\u00020\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00104\u001a\u00020/8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006F"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemView;", "Lcom/avito/android/recycler/base/DestroyableViewHolder;", "", "isDisabled", "", "setDisabled", "(Z)V", "", "id", "setTag", "(Ljava/lang/String;)V", "onDataSourceChanged", "()V", "", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "setupViewForLargeItems", "setupViewForSmallItems", "notifyItemAtPositionChanged", "destroy", "onUnbind", "Landroidx/recyclerview/widget/SnapHelper;", "snapHelper", "t", "(Landroidx/recyclerview/widget/SnapHelper;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "x", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "z", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "u", "I", "padding", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;", "w", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;", "presenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "y", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoritesPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoritesPresenter", VKApiConst.VERSION, "Landroidx/recyclerview/widget/SnapHelper;", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView;", "s", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Landroid/view/View;Lcom/avito/konveyor/ItemBinder;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertListItemViewImpl extends BaseViewHolder implements AdvertListItemView, DestroyableViewHolder {
    public final View A;
    public final RecyclerView s;
    public final LinearLayoutManager t;
    public final int u;
    public SnapHelper v;
    public final AdvertListItemPresenter w;
    @NotNull
    public final AdapterPresenter x;
    @NotNull
    public final FavoriteAdvertsPresenter y;
    @NotNull
    public final ViewedAdvertsPresenter z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertListItemViewImpl(@NotNull AdvertListItemPresenter advertListItemPresenter, @NotNull AdapterPresenter adapterPresenter, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @NotNull View view, @NotNull ItemBinder itemBinder) {
        super(view);
        Intrinsics.checkNotNullParameter(advertListItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoritesPresenter");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.w = advertListItemPresenter;
        this.x = adapterPresenter;
        this.y = favoriteAdvertsPresenter;
        this.z = viewedAdvertsPresenter;
        this.A = view;
        View findViewById = view.findViewById(R.id.items);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.s = recyclerView;
        this.u = view.getResources().getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.list_serp_card_padding);
        recyclerView.setItemAnimator(null);
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(getAdapterPresenter(), itemBinder);
        simpleRecyclerAdapter.setHasStableIds(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        this.t = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(simpleRecyclerAdapter);
    }

    @Override // com.avito.android.recycler.base.DestroyableViewHolder
    public void destroy() {
        getFavoritesPresenter().detachViews();
        getViewedAdvertsPresenter().detachView();
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemView
    @NotNull
    public AdapterPresenter getAdapterPresenter() {
        return this.x;
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemView
    @NotNull
    public FavoriteAdvertsPresenter getFavoritesPresenter() {
        return this.y;
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemView
    @NotNull
    public ViewedAdvertsPresenter getViewedAdvertsPresenter() {
        return this.z;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i) {
        RecyclerView.Adapter adapter = this.s.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i);
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemView
    public void onDataSourceChanged() {
        RecyclerView.Adapter adapter = this.s.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        getFavoritesPresenter().detachViews();
        getViewedAdvertsPresenter().detachView();
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemView
    public void setCurrentPosition(int i) {
        this.t.scrollToPositionWithOffset(i, this.u);
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemView
    public void setDisabled(boolean z2) {
        this.A.setAlpha(z2 ? 0.5f : 1.0f);
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemView
    public void setTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.A.setTag(str);
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemView
    public void setupViewForLargeItems() {
        this.s.setScrollingTouchSlop(1);
        t(new PagingSnapHelper(this.u));
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemView
    public void setupViewForSmallItems() {
        this.s.setScrollingTouchSlop(0);
        t(new SectionSnapHelper(GravityCompat.START, this.u));
    }

    public final void t(SnapHelper snapHelper) {
        SnapHelper snapHelper2 = this.v;
        if (snapHelper2 != null) {
            snapHelper2.attachToRecyclerView(null);
        }
        this.s.setOnFlingListener(null);
        this.s.clearOnScrollListeners();
        this.s.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemViewImpl$addScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (i == 0) {
                    AdvertListItemPresenter advertListItemPresenter = AdvertListItemViewImpl.this.w;
                    Object tag = AdvertListItemViewImpl.this.A.getTag();
                    Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
                    advertListItemPresenter.onCurrentPositionChanged((String) tag, AdvertListItemViewImpl.this.t.findFirstCompletelyVisibleItemPosition());
                }
            }
        });
        snapHelper.attachToRecyclerView(this.s);
        this.v = snapHelper;
    }
}
