package com.avito.android.str_calendar.seller.calendar;

import a2.b.a.a.a;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.calendar.view.CalendarRecyclerViewDecoration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000f\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarRecyclerViewDecoration;", "Lcom/avito/android/str_calendar/calendar/view/CalendarRecyclerViewDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "gridSize", "Lkotlin/Function2;", "span", "screenMargin", "itemsMargin", "verticalMargin", "<init>", "(ILkotlin/jvm/functions/Function2;III)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarRecyclerViewDecoration extends CalendarRecyclerViewDecoration {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SellerCalendarRecyclerViewDecoration(int i, @NotNull Function2<? super Integer, ? super Integer, Integer> function2, int i2, int i3, int i4) {
        super(function2, i, i2, i3, i4);
        Intrinsics.checkNotNullParameter(function2, "span");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        View findViewById = view.findViewById(R.id.text_view_container);
        if (findViewById != null) {
            int viewSpanPosition = viewSpanPosition(view);
            alignOutRect(rect, viewSpanPosition);
            alignView(view, R.id.secondary_background_view, viewSpanPosition, findViewById);
            alignView(view, R.id.background_view, viewSpanPosition, findViewById);
        }
    }
}
