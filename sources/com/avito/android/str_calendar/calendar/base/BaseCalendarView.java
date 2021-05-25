package com.avito.android.str_calendar.calendar.base;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.str_calendar.R;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH$¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0004@\u0004X.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/str_calendar/calendar/base/BaseCalendarView;", "", "Landroid/view/View;", "parentView", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "", "setCalendarUpRecyclerView", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getCalendarItemDecoration", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "<init>", "()V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseCalendarView {
    public RecyclerView recyclerView;

    @NotNull
    public abstract RecyclerView.ItemDecoration getCalendarItemDecoration(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup);

    @NotNull
    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView2;
    }

    public final void setCalendarUpRecyclerView(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(view, "parentView");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        View findViewById = view.findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "parentView.findViewById(R.id.recycler_view)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById;
        this.recyclerView = recyclerView2;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView2.setAdapter(new SimpleRecyclerAdapter(adapterPresenter, itemBinder));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView.RecycledViewPool recycledViewPool = recyclerView3.getRecycledViewPool();
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recycledViewPool.setMaxRecycledViews(0, recyclerView4.getResources().getInteger(R.integer.max_recycled_views_count_month_item));
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView.RecycledViewPool recycledViewPool2 = recyclerView5.getRecycledViewPool();
        RecyclerView recyclerView6 = this.recyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recycledViewPool2.setMaxRecycledViews(1, recyclerView6.getResources().getInteger(R.integer.max_recycled_views_count_day_item));
        RecyclerView recyclerView7 = this.recyclerView;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView.RecycledViewPool recycledViewPool3 = recyclerView7.getRecycledViewPool();
        RecyclerView recyclerView8 = this.recyclerView;
        if (recyclerView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recycledViewPool3.setMaxRecycledViews(2, recyclerView8.getResources().getInteger(R.integer.max_recycled_views_count_empty_item));
        BaseCalendarView$getCalendarSpanSizeLookup$1 baseCalendarView$getCalendarSpanSizeLookup$1 = new GridLayoutManager.SpanSizeLookup() { // from class: com.avito.android.str_calendar.calendar.base.BaseCalendarView$getCalendarSpanSizeLookup$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                int viewType = AdapterPresenter.this.getViewType(i);
                if (viewType == 0) {
                    return 7;
                }
                if (viewType == 1 || viewType == 2) {
                    return 1;
                }
                throw new UnsupportedOperationException("Unknown view type");
            }
        };
        RecyclerView recyclerView9 = this.recyclerView;
        if (recyclerView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 7);
        gridLayoutManager.setSpanSizeLookup(baseCalendarView$getCalendarSpanSizeLookup$1);
        recyclerView9.setLayoutManager(gridLayoutManager);
        RecyclerView recyclerView10 = this.recyclerView;
        if (recyclerView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView10.addItemDecoration(getCalendarItemDecoration(baseCalendarView$getCalendarSpanSizeLookup$1));
        RecyclerView recyclerView11 = this.recyclerView;
        if (recyclerView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView11.setItemAnimator(null);
    }

    public final void setRecyclerView(@NotNull RecyclerView recyclerView2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "<set-?>");
        this.recyclerView = recyclerView2;
    }
}
