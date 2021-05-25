package com.avito.android.advert_stats.item;

import a2.b.a.a.a;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_stats.R;
import com.avito.android.advert_stats.recycler.WeeksDecoration;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001;\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010D\u001a\u00020?\u0012\u0006\u0010V\u001a\u00020U\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010H\u001a\u00020E¢\u0006\u0004\bY\u0010ZJ%\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0012\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010$\u001a\n !*\u0004\u0018\u00010 0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R$\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001eR$\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00101R\u0016\u00106\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010\u001eR\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0019\u0010D\u001a\u00020?8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001e\u0010T\u001a\n !*\u0004\u0018\u00010Q0Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010S¨\u0006["}, d2 = {"Lcom/avito/android/advert_stats/item/PlotItemViewImpl;", "Lcom/avito/android/advert_stats/item/PlotItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "Lcom/avito/android/advert_stats/item/WeekItem;", "items", "", "hasSelectedBar", "", "setItems", "(Ljava/util/List;Z)V", "onUnbind", "()V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setScrollStateListener", "(Lkotlin/jvm/functions/Function1;)V", "", "setWeekSelectedListener", "removeDaySelection", "dayIndex", "selected", "setDaySelected", "(IZ)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setHeight", "(I)V", FirebaseAnalytics.Param.INDEX, "scrollToItem", "z", "I", "lastDx", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "t", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "y", "Lkotlin/jvm/functions/Function1;", "weekChangeListener", "C", "recyclerState", "x", "scrollChangeListener", "Landroidx/recyclerview/widget/LinearLayoutManager;", VKApiConst.VERSION, "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "D", "Z", "isScrollingFinished", "B", "isDraggingOutsideRecycler", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "lastPosition", "Lcom/avito/android/advert_stats/recycler/WeeksDecoration;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/advert_stats/recycler/WeeksDecoration;", "weeksDecoration", "com/avito/android/advert_stats/item/PlotItemViewImpl$onScrollListener$1", "F", "Lcom/avito/android/advert_stats/item/PlotItemViewImpl$onScrollListener$1;", "onScrollListener", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "G", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;", "H", "Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;", "plotDimensionsProvider", "Lcom/avito/android/advert_stats/item/StatSnapHelper;", "w", "Lcom/avito/android/advert_stats/item/StatSnapHelper;", "snapHelper", "Lcom/avito/android/advert_stats/item/SnappingListener;", "s", "Lcom/avito/android/advert_stats/item/SnappingListener;", "snapListener", "Lcom/avito/android/advert_stats/item/DaysView;", "u", "Lcom/avito/android/advert_stats/item/DaysView;", "daysView", "Landroid/view/View;", "view", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Landroid/view/View;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class PlotItemViewImpl extends BaseViewHolder implements PlotItemView {
    public int A = -1;
    public boolean B;
    public int C;
    public boolean D = true;
    public WeeksDecoration E;
    public final PlotItemViewImpl$onScrollListener$1 F;
    @NotNull
    public final AdapterPresenter G;
    public final PlotDimensionsProvider H;
    public final SnappingListener s;
    public final RecyclerView t;
    public final DaysView u;
    public final LinearLayoutManager v;
    public final StatSnapHelper w;
    public Function1<? super Boolean, Unit> x;
    public Function1<? super Integer, Unit> y;
    public int z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlotItemViewImpl(@NotNull AdapterPresenter adapterPresenter, @NotNull View view, @NotNull ItemBinder itemBinder, @NotNull PlotDimensionsProvider plotDimensionsProvider) {
        super(view);
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(plotDimensionsProvider, "plotDimensionsProvider");
        this.G = adapterPresenter;
        this.H = plotDimensionsProvider;
        PlotItemViewImpl$snapListener$1 plotItemViewImpl$snapListener$1 = new SnappingListener(this) { // from class: com.avito.android.advert_stats.item.PlotItemViewImpl$snapListener$1
            public final /* synthetic */ PlotItemViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.advert_stats.item.SnappingListener
            public void onTargetPositionFound(int i) {
                PlotItemViewImpl.access$notifyWeekSelected(this.a, i);
            }
        };
        this.s = plotItemViewImpl$snapListener$1;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.week_recycler);
        this.t = recyclerView;
        DaysView daysView = (DaysView) view.findViewById(R.id.days_view);
        this.u = daysView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recycler");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        this.v = (LinearLayoutManager) layoutManager;
        StatSnapHelper statSnapHelper = new StatSnapHelper(plotItemViewImpl$snapListener$1);
        this.w = statSnapHelper;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recycler");
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "recycler.context");
        this.E = new WeeksDecoration(context, plotDimensionsProvider.getPlotSideMargin(), false);
        this.F = new PlotItemViewImpl$onScrollListener$1(this);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recycler");
        recyclerView.setItemAnimator(null);
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recycler");
        recyclerView.setAdapter(simpleRecyclerAdapter);
        statSnapHelper.attachToRecyclerView(recyclerView);
        daysView.setDayWidth(plotDimensionsProvider.getBarWidth());
        Intrinsics.checkNotNullExpressionValue(daysView, "daysView");
        ViewGroup.LayoutParams layoutParams = daysView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = plotDimensionsProvider.getPlotSideMargin();
    }

    public static final int access$findNextIndex(PlotItemViewImpl plotItemViewImpl) {
        int findLastVisibleItemPosition = plotItemViewImpl.v.findLastVisibleItemPosition();
        View findViewByPosition = plotItemViewImpl.v.findViewByPosition(findLastVisibleItemPosition);
        int right = findViewByPosition != null ? findViewByPosition.getRight() : -1;
        RecyclerView recyclerView = plotItemViewImpl.t;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recycler");
        return right < recyclerView.getWidth() / 2 ? findLastVisibleItemPosition - 1 : findLastVisibleItemPosition;
    }

    public static final void access$notifyWeekSelected(PlotItemViewImpl plotItemViewImpl, int i) {
        if (!plotItemViewImpl.D) {
            Function1<? super Integer, Unit> function1 = plotItemViewImpl.y;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i));
            }
            plotItemViewImpl.D = true;
        }
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        return this.G;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.t.removeOnScrollListener(this.F);
    }

    @Override // com.avito.android.advert_stats.item.PlotItemView
    public void removeDaySelection() {
        this.u.removeSelection();
    }

    @Override // com.avito.android.advert_stats.item.PlotItemView
    public void scrollToItem(int i) {
        this.v.scrollToPositionWithOffset(i, this.H.getPlotSideMargin());
    }

    @Override // com.avito.android.advert_stats.item.PlotItemView
    public void setDaySelected(int i, boolean z2) {
        this.u.selectDay(i, z2);
    }

    @Override // com.avito.android.advert_stats.item.PlotItemView
    public void setHeight(int i) {
        RecyclerView recyclerView = this.t;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recycler");
        recyclerView.getLayoutParams().height = i;
        this.t.requestLayout();
    }

    @Override // com.avito.android.advert_stats.item.PlotItemView
    public void setItems(@NotNull List<WeekItem> list, boolean z2) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.t.removeOnScrollListener(this.F);
        this.t.addOnScrollListener(this.F);
        this.t.removeItemDecoration(this.E);
        RecyclerView recyclerView = this.t;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recycler");
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "recycler.context");
        WeeksDecoration weeksDecoration = new WeeksDecoration(context, this.H.getPlotSideMargin(), z2);
        this.E = weeksDecoration;
        this.t.addItemDecoration(weeksDecoration);
        a.s1(list, this.G);
        RecyclerView recyclerView2 = this.t;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recycler");
        RecyclerView.Adapter adapter = recyclerView2.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.advert_stats.item.PlotItemView
    public void setScrollStateListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x = function1;
    }

    @Override // com.avito.android.advert_stats.item.PlotItemView
    public void setWeekSelectedListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.y = function1;
    }
}
