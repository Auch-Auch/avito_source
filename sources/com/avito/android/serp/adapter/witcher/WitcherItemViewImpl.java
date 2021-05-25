package com.avito.android.serp.adapter.witcher;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.section.SectionSnapHelper;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.witcher.WitcherItemView;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.DataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002BJ\u0012\u0006\u0010F\u001a\u00020C\u0012\u0007\u0010\u0001\u001a\u00020~\u0012\u0006\u0010<\u001a\u000207\u0012\u0006\u0010d\u001a\u00020b\u0012\u0006\u0010y\u001a\u00020t\u0012\u0006\u0010'\u001a\u00020\"\u0012\u0006\u0010T\u001a\u00020O\u0012\u0006\u0010^\u001a\u00020Y¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u000eJ\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00052\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u000eR\u001c\u0010'\u001a\u00020\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\"\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u00102R\"\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b5\u0010/R\u0019\u0010<\u001a\u0002078\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001d\u0010B\u001a\u00020=8B@\u0002X\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0019\u0010T\u001a\u00020O8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0019\u0010^\u001a\u00020Y8\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010cR\"\u0010l\u001a\u00020e8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u001d\u0010s\u001a\u00020=8B@\u0002X\u0002¢\u0006\f\n\u0004\bq\u0010?\u001a\u0004\br\u0010AR\u001c\u0010y\u001a\u00020t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0001\u001a\u00020~8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/serp/adapter/witcher/WitcherItemViewImpl;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "setButtonText", "Lcom/avito/android/serp/adapter/witcher/WitcherItemView$SelectionType;", "selectionType", "setSelectionType", "(Lcom/avito/android/serp/adapter/witcher/WitcherItemView$SelectionType;)V", "onUnbind", "()V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "items", "setItems", "(Lcom/avito/konveyor/data_source/DataSource;)V", "subscribeToScrollChanges", "", VKApiConst.POSITION, "notifyItemAtPositionChanged", "(I)V", "Landroid/os/Parcelable;", "parcel", "setInnerItemsSavedState", "(Landroid/os/Parcelable;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "t", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "K", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoriteAdvertsPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "y", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lio/reactivex/rxjava3/core/Observable;", "C", "Lio/reactivex/rxjava3/core/Observable;", "getButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "buttonClicks", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleView", "D", "getTitleClicks", "titleClicks", "Lcom/avito/konveyor/ItemBinder;", "H", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Landroidx/recyclerview/widget/GridLayoutManager;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/Lazy;", "getCarouselLayoutManager", "()Landroidx/recyclerview/widget/GridLayoutManager;", "carouselLayoutManager", "Landroid/view/View;", "F", "Landroid/view/View;", "view", "Lcom/avito/android/lib/design/button/Button;", "u", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "z", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "simpleAdapter", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "L", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "adapterPresenter", "Landroid/widget/LinearLayout;", "s", "Landroid/widget/LinearLayout;", "witcherRoot", "Lcom/avito/android/util/DeviceMetrics;", "M", "Lcom/avito/android/util/DeviceMetrics;", "getDeviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "w", "I", "padding", "Lcom/avito/android/serp/adapter/witcher/WitcherResourceProvider;", "Lcom/avito/android/serp/adapter/witcher/WitcherResourceProvider;", "witcherResourceProvider", "", ExifInterface.LONGITUDE_EAST, "Z", "getHasCarousel", "()Z", "setHasCarousel", "(Z)V", "hasCarousel", "Landroidx/recyclerview/widget/SnapHelper;", "x", "Landroidx/recyclerview/widget/SnapHelper;", "snapHelper", "B", "getDefaultLayoutManager", "defaultLayoutManager", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "J", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Landroidx/recyclerview/widget/RecyclerView;", VKApiConst.VERSION, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "G", "Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "witcherItemPresenter", "<init>", "(Landroid/view/View;Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/serp/adapter/witcher/WitcherResourceProvider;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;Lcom/avito/android/util/DeviceMetrics;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class WitcherItemViewImpl extends BaseViewHolder implements WitcherItemView {
    public final Lazy A;
    public final Lazy B;
    @NotNull
    public final Observable<Unit> C;
    @NotNull
    public final Observable<Unit> D;
    public boolean E;
    public final View F;
    public final WitcherItemPresenter G;
    @NotNull
    public final ItemBinder H;
    public final WitcherResourceProvider I;
    @NotNull
    public final ViewedAdvertsPresenter J;
    @NotNull
    public final FavoriteAdvertsPresenter K;
    @NotNull
    public final SimpleAdapterPresenter L;
    @NotNull
    public final DeviceMetrics M;
    public final LinearLayout s;
    public final TextView t;
    public final Button u;
    public final RecyclerView v;
    public final int w;
    public SnapHelper x;
    public Function0<Unit> y;
    public final SimpleRecyclerAdapter z;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<GridLayoutManager> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final GridLayoutManager invoke() {
            int i = this.a;
            if (i == 0) {
                return new GridLayoutManager(((WitcherItemViewImpl) this.b).F.getContext(), 1, 0, false);
            }
            if (i == 1) {
                return new GridLayoutManager(((WitcherItemViewImpl) this.b).F.getContext(), ((WitcherItemViewImpl) this.b).I.getElementsCountForWitcher(), 1, false);
            }
            throw null;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WitcherItemViewImpl(@NotNull View view, @NotNull WitcherItemPresenter witcherItemPresenter, @NotNull ItemBinder itemBinder, @NotNull WitcherResourceProvider witcherResourceProvider, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull SimpleAdapterPresenter simpleAdapterPresenter, @NotNull DeviceMetrics deviceMetrics) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(witcherItemPresenter, "witcherItemPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(witcherResourceProvider, "witcherResourceProvider");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(simpleAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        this.F = view;
        this.G = witcherItemPresenter;
        this.H = itemBinder;
        this.I = witcherResourceProvider;
        this.J = viewedAdvertsPresenter;
        this.K = favoriteAdvertsPresenter;
        this.L = simpleAdapterPresenter;
        this.M = deviceMetrics;
        View findViewById = view.findViewById(R.id.witcher_root);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.s = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.witcher_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById2;
        this.t = textView;
        View findViewById3 = view.findViewById(R.id.witcher_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById3;
        this.u = button;
        View findViewById4 = view.findViewById(R.id.witcher_recycler);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.v = recyclerView;
        this.w = view.getResources().getDimensionPixelOffset(R.dimen.serp_horizontal_padding);
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(simpleAdapterPresenter, itemBinder);
        this.z = simpleRecyclerAdapter;
        Lazy lazy = c.lazy(new a(0, this));
        this.A = lazy;
        Lazy lazy2 = c.lazy(new a(1, this));
        this.B = lazy2;
        this.C = RxView.clicks(button);
        this.D = RxView.clicks(textView);
        simpleRecyclerAdapter.setHasStableIds(true);
        if (getHasCarousel()) {
            recyclerView.setLayoutManager((GridLayoutManager) lazy.getValue());
            recyclerView.setScrollingTouchSlop(0);
        } else {
            recyclerView.setLayoutManager((GridLayoutManager) lazy2.getValue());
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setScrollingTouchSlop(1);
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(simpleRecyclerAdapter);
    }

    public static final void access$saveState(WitcherItemViewImpl witcherItemViewImpl) {
        WitcherItemPresenter witcherItemPresenter = witcherItemViewImpl.G;
        RecyclerView.LayoutManager layoutManager = witcherItemViewImpl.v.getLayoutManager();
        witcherItemPresenter.getSavedState(layoutManager != null ? layoutManager.onSaveInstanceState() : null);
    }

    @NotNull
    public final SimpleAdapterPresenter getAdapterPresenter() {
        return this.L;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemView
    @NotNull
    public Observable<Unit> getButtonClicks() {
        return this.C;
    }

    @NotNull
    public final DeviceMetrics getDeviceMetrics() {
        return this.M;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemView
    @NotNull
    public FavoriteAdvertsPresenter getFavoriteAdvertsPresenter() {
        return this.K;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemView
    public boolean getHasCarousel() {
        return this.E;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        return this.H;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemView
    @NotNull
    public Observable<Unit> getTitleClicks() {
        return this.D;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemView
    @NotNull
    public ViewedAdvertsPresenter getViewedAdvertsPresenter() {
        return this.J;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i) {
        RecyclerView.Adapter adapter = this.v.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i);
        }
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.y;
        if (function0 != null) {
            function0.invoke();
        }
        this.y = null;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemView
    public void setButtonText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        boolean z2 = false;
        ButtonsKt.bindText$default(this.u, str, false, 2, null);
        if (str.length() == 0) {
            z2 = true;
        }
        if (z2) {
            Views.changePadding$default(this.s, 0, 0, 0, this.I.getBottomPaddingForEmptyButton(), 7, null);
        } else {
            Views.changePadding$default(this.s, 0, 0, 0, 0, 7, null);
        }
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemView
    public void setHasCarousel(boolean z2) {
        this.E = z2;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemView
    public void setInnerItemsSavedState(@Nullable Parcelable parcelable) {
        RecyclerView.LayoutManager layoutManager = this.v.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.onRestoreInstanceState(parcelable);
        }
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemView
    public void setItems(@NotNull DataSource<PersistableSerpItem> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "items");
        this.L.onDataSourceChanged(dataSource);
        if (this.v.getAdapter() == null) {
            this.v.setAdapter(new SimpleRecyclerAdapter(this.L, this.H));
        } else {
            this.z.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemView
    public void setSelectionType(@NotNull WitcherItemView.SelectionType selectionType) {
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        LinearLayout linearLayout = this.s;
        Context context = linearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "witcherRoot.context");
        linearLayout.setBackgroundColor(Contexts.getColorByAttr(context, selectionType.getBackgroundColor()));
        if (!selectionType.getHasElevation()) {
            this.s.setElevation(0.0f);
        }
        if (selectionType.getHasExtraPaddingTop()) {
            Views.changeMargin$default(this.s, 0, this.I.getPaddingTopForSelectedWitcher(), 0, 0, 13, null);
        }
        setHasCarousel(selectionType.getHasCarousel());
        if (getHasCarousel()) {
            if (!this.I.isTablet()) {
                Views.changeMargin$default(this.t, this.I.getPadding() + this.I.getPaddingForTitleStart(), 0, this.I.getPadding() + this.I.getPaddingForTitleEnd(), 0, 10, null);
                Views.changeMargin$default(this.u, this.I.getPadding() + this.I.getPaddingForButton(), 0, this.I.getPadding() + this.I.getPaddingForButton(), this.I.getBottomMarginForButton(), 2, null);
            }
            this.v.setLayoutManager((GridLayoutManager) this.A.getValue());
            this.v.setAdapter(this.z);
            RecyclerView recyclerView = this.v;
            Resources resources = recyclerView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "recycler.resources");
            recyclerView.addItemDecoration(new WitcherElementsDecorator(resources, this.M));
            SectionSnapHelper sectionSnapHelper = new SectionSnapHelper(GravityCompat.START, this.w);
            SnapHelper snapHelper = this.x;
            if (snapHelper != null) {
                snapHelper.attachToRecyclerView(null);
            }
            this.v.setOnFlingListener(null);
            this.v.clearOnScrollListeners();
            t();
            sectionSnapHelper.attachToRecyclerView(this.v);
            this.x = sectionSnapHelper;
        } else {
            this.v.setLayoutManager((GridLayoutManager) this.B.getValue());
            this.v.setAdapter(this.z);
            while (this.v.getItemDecorationCount() > 0) {
                this.v.removeItemDecorationAt(0);
            }
            SnapHelper snapHelper2 = this.x;
            if (snapHelper2 != null) {
                snapHelper2.attachToRecyclerView(null);
            }
            this.v.setOnFlingListener(null);
            this.v.clearOnScrollListeners();
            t();
        }
        if (selectionType.getCustomBackground()) {
            this.s.setBackgroundResource(R.drawable.bg_witcher_marketplace);
        }
        if (selectionType.getCustomButtonStyle()) {
            this.u.setAppearance(R.style.ButtonPrimaryLargeViolet);
        } else {
            this.u.setAppearanceFromAttr(com.avito.android.lib.design.R.attr.buttonPrimaryLarge);
        }
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.y = function0;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemView
    public void subscribeToScrollChanges() {
        this.v.setOnFlingListener(null);
        this.v.clearOnScrollListeners();
        t();
    }

    public final void t() {
        this.v.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener(this) { // from class: com.avito.android.serp.adapter.witcher.WitcherItemViewImpl$addScrollListener$1
            public final /* synthetic */ WitcherItemViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                WitcherItemViewImpl.access$saveState(this.a);
            }
        });
        this.v.addOnItemTouchListener(new RecyclerView.OnItemTouchListener(this) { // from class: com.avito.android.serp.adapter.witcher.WitcherItemViewImpl$addScrollListener$2
            public final /* synthetic */ WitcherItemViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(@NotNull RecyclerView recyclerView, @NotNull MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter(recyclerView, "rv");
                Intrinsics.checkNotNullParameter(motionEvent, "e");
                WitcherItemViewImpl.access$saveState(this.a);
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean z2) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(@NotNull RecyclerView recyclerView, @NotNull MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter(recyclerView, "rv");
                Intrinsics.checkNotNullParameter(motionEvent, "e");
            }
        });
        this.v.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.avito.android.serp.adapter.witcher.WitcherItemViewImpl$addScrollListener$3
            public final /* synthetic */ WitcherItemViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (i == 0) {
                    WitcherItemViewImpl.access$saveState(this.a);
                }
            }
        });
    }
}
