package com.avito.android.section;

import a2.a.a.l2.e;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.recycler.base.DestroyableViewHolder;
import com.avito.android.section.complementary.ComplementarySnapHelper;
import com.avito.android.section.title.SectionTitleItemView;
import com.avito.android.serp_core.R;
import com.avito.android.ui.snap_helper.PagingSnapHelper;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BG\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010:\u001a\u000205\u0012\u0006\u0010/\u001a\u00020*\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010G\u001a\u00020\u0004\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\bR\u0010SJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\r\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u000bJ\u001a\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0004\b\u0017\u0010\tJ\u001a\u0010\u0018\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0004\b\u0018\u0010\tJ\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\u00020\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010(R\u001c\u0010/\u001a\u00020*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u0010:\u001a\u0002058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u00101R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u00101¨\u0006T"}, d2 = {"Lcom/avito/android/section/SectionItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/section/SectionItemView;", "Lcom/avito/android/recycler/base/DestroyableViewHolder;", "Lcom/avito/android/section/title/SectionTitleItemView;", "", "id", "", "setTag", "(Ljava/lang/String;)V", "onDataSourceChanged", "()V", "", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "setupViewForLargeItems", "setupViewForSmallItems", "notifyItemAtPositionChanged", "destroy", "onUnbind", "sendCurrentPositionToPresenter", "text", "bindSubtitle", "bindTitle", "Landroidx/recyclerview/widget/SnapHelper;", "snapHelper", "t", "(Landroidx/recyclerview/widget/SnapHelper;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroid/view/View;", "D", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "C", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "u", "I", "padding", "x", "Landroidx/recyclerview/widget/SnapHelper;", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "B", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoritesPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoritesPresenter", "Landroidx/recyclerview/widget/RecyclerView;", "s", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "w", "halfColumnOffset", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "y", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "eventSubscription", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/section/title/SectionTitleItemView;", "titleItemView", "Lcom/avito/android/section/SectionItemPresenter;", "z", "Lcom/avito/android/section/SectionItemPresenter;", "presenter", VKApiConst.VERSION, "columnOffset", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "<init>", "(Lcom/avito/android/section/SectionItemPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Landroid/view/View;Lcom/avito/android/section/title/SectionTitleItemView;Lcom/avito/konveyor/ItemBinder;Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SectionItemViewHolder extends BaseViewHolder implements SectionItemView, DestroyableViewHolder, SectionTitleItemView {
    @NotNull
    public final AdapterPresenter A;
    @NotNull
    public final FavoriteAdvertsPresenter B;
    @NotNull
    public final ViewedAdvertsPresenter C;
    public final View D;
    public final SectionTitleItemView E;
    public final RecyclerView s;
    public final LinearLayoutManager t;
    public final int u;
    public final int v;
    public final int w;
    public SnapHelper x;
    public final CompositeDisposable y;
    public final SectionItemPresenter z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SectionItemViewHolder(@NotNull SectionItemPresenter sectionItemPresenter, @NotNull AdapterPresenter adapterPresenter, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @NotNull View view, @NotNull SectionTitleItemView sectionTitleItemView, @NotNull ItemBinder itemBinder, @NotNull RecyclerView.ItemDecoration itemDecoration) {
        super(view);
        Intrinsics.checkNotNullParameter(sectionItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoritesPresenter");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(sectionTitleItemView, "titleItemView");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(itemDecoration, "itemDecoration");
        this.z = sectionItemPresenter;
        this.A = adapterPresenter;
        this.B = favoriteAdvertsPresenter;
        this.C = viewedAdvertsPresenter;
        this.D = view;
        this.E = sectionTitleItemView;
        View findViewById = view.findViewById(R.id.section_items);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.s = recyclerView;
        this.u = view.getResources().getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.content_horizontal_padding);
        int dimensionPixelOffset = view.getResources().getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.rds_column_offset);
        this.v = dimensionPixelOffset;
        this.w = dimensionPixelOffset / 2;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.y = compositeDisposable;
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setItemAnimator(null);
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(getAdapterPresenter(), itemBinder);
        simpleRecyclerAdapter.setHasStableIds(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        this.t = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        Disposable subscribe = RxView.globalLayouts(recyclerView).take(1).subscribe(new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "recycler.globalLayouts()…onToPresenter()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        Intrinsics.checkNotNullExpressionValue(OrientationHelper.createHorizontalHelper(linearLayoutManager), "OrientationHelper.create…ntalHelper(layoutManager)");
    }

    @Override // com.avito.android.section.title.SectionTitleItemView
    public void bindSubtitle(@Nullable String str) {
        this.E.bindSubtitle(str);
    }

    @Override // com.avito.android.section.title.SectionTitleItemView
    public void bindTitle(@Nullable String str) {
        this.E.bindTitle(str);
    }

    @Override // com.avito.android.recycler.base.DestroyableViewHolder
    public void destroy() {
        getFavoritesPresenter().detachViews();
        getViewedAdvertsPresenter().detachView();
        this.y.dispose();
    }

    @Override // com.avito.android.section.SectionItemView
    @NotNull
    public AdapterPresenter getAdapterPresenter() {
        return this.A;
    }

    @Override // com.avito.android.section.SectionItemView
    @NotNull
    public FavoriteAdvertsPresenter getFavoritesPresenter() {
        return this.B;
    }

    @Override // com.avito.android.section.SectionItemView
    @NotNull
    public ViewedAdvertsPresenter getViewedAdvertsPresenter() {
        return this.C;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i) {
        RecyclerView.Adapter adapter = this.s.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i);
        }
    }

    @Override // com.avito.android.section.SectionItemView
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
        this.y.dispose();
    }

    public final void sendCurrentPositionToPresenter() {
        Object tag = this.D.getTag();
        if (tag instanceof String) {
            this.z.onCurrentPositionChanged((String) tag, this.t.findFirstCompletelyVisibleItemPosition(), this.t.findLastVisibleItemPosition());
        }
    }

    @Override // com.avito.android.section.SectionItemView
    public void setCurrentPosition(int i) {
        this.t.scrollToPositionWithOffset(i, this.u);
    }

    @Override // com.avito.android.section.SectionItemView
    public void setTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.D.setTag(str);
    }

    @Override // com.avito.android.section.SectionItemView
    public void setupViewForLargeItems() {
        this.s.setScrollingTouchSlop(1);
        t(new PagingSnapHelper(this.u));
    }

    @Override // com.avito.android.section.SectionItemView
    public void setupViewForSmallItems() {
        this.s.setScrollingTouchSlop(0);
        t(new ComplementarySnapHelper(this.w));
    }

    public final void t(SnapHelper snapHelper) {
        SnapHelper snapHelper2 = this.x;
        if (snapHelper2 != null) {
            snapHelper2.attachToRecyclerView(null);
        }
        this.s.setOnFlingListener(null);
        this.s.clearOnScrollListeners();
        this.s.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.avito.android.section.SectionItemViewHolder$addScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (i == 0) {
                    SectionItemViewHolder.this.sendCurrentPositionToPresenter();
                }
            }
        });
        snapHelper.attachToRecyclerView(this.s);
        this.x = snapHelper;
    }
}
