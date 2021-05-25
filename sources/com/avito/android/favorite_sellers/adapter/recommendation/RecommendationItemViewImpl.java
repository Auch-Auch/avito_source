package com.avito.android.favorite_sellers.adapter.recommendation;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.favorite_sellers.RecommendationCarouselItem;
import com.avito.android.favorite_sellers_items.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.section.GravitySnapHelper;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.DataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001CB\u001f\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BJ\u001f\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\tJ\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006D"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/favorite_sellers/RecommendationCarouselItem;", "dataSource", "setCarouselItems", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "", VKApiConst.POSITION, "notifyItemChanged", "(I)V", "scrollToNextItem", "Landroid/os/Parcelable;", "state", "restoreScrollState", "(Landroid/os/Parcelable;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", VKApiConst.VERSION, "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lio/reactivex/rxjava3/core/Observable;", "y", "Lio/reactivex/rxjava3/core/Observable;", "getScrollStateUpdates", "()Lio/reactivex/rxjava3/core/Observable;", "scrollStateUpdates", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "z", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView;", "t", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/content/res/Resources;", "s", "Landroid/content/res/Resources;", "resources", "Landroidx/recyclerview/widget/LinearLayoutManager;", "w", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "titleView", "x", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "view", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", AuthSource.SEND_ABUSE, "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class RecommendationItemViewImpl extends BaseViewHolder implements RecommendationItemView {
    public final Resources s;
    public final RecyclerView t;
    public final TextView u;
    public final SimpleRecyclerAdapter v;
    public final LinearLayoutManager w;
    public Function0<Unit> x;
    @NotNull
    public final Observable<Parcelable> y;
    public final AdapterPresenter z;

    public static final class a extends LinearSmoothScroller {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, @NotNull Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            setTargetPosition(i);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return 100.0f / ((float) displayMetrics.densityDpi);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecommendationItemViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.z = adapterPresenter;
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        this.s = resources;
        View findViewById = view.findViewById(R.id.carousel);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.t = recyclerView;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        this.v = simpleRecyclerAdapter;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        this.w = linearLayoutManager;
        simpleRecyclerAdapter.setHasStableIds(true);
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.setScrollingTouchSlop(0);
        new GravitySnapHelper(GravityCompat.END, 0).attachToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new RecommendationItemDecorator(resources.getDimensionPixelOffset(R.dimen.recommendation_carousel_item_padding)));
        Observable<Parcelable> create = Observable.create(new RecommendationItemViewImpl$scrollStateUpdates$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…istener(listener) }\n    }");
        this.y = create;
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemView
    @NotNull
    public Observable<Parcelable> getScrollStateUpdates() {
        return this.y;
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemView
    public void notifyItemChanged(int i) {
        this.v.notifyItemChanged(i);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.x;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemView
    public void restoreScrollState(@NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "state");
        RecyclerView.LayoutManager layoutManager = this.t.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.onRestoreInstanceState(parcelable);
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemView
    public void scrollToNextItem() {
        if (this.t.getScrollState() == 0) {
            int findLastCompletelyVisibleItemPosition = this.w.findLastCompletelyVisibleItemPosition();
            int i = findLastCompletelyVisibleItemPosition + 1;
            if (findLastCompletelyVisibleItemPosition != -1 && i < this.v.getItemCount()) {
                this.w.scrollToPosition(findLastCompletelyVisibleItemPosition);
                LinearLayoutManager linearLayoutManager = this.w;
                Context context = this.t.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "recycler.context");
                linearLayoutManager.startSmoothScroll(new a(i, context));
            }
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemView
    public void setCarouselItems(@NotNull DataSource<RecommendationCarouselItem> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.z.onDataSourceChanged(dataSource);
        RecyclerView.Adapter adapter = this.t.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        Views.setVisible(this.t, !dataSource.isEmpty());
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.u, charSequence, false, 2, null);
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.x = function0;
    }
}
