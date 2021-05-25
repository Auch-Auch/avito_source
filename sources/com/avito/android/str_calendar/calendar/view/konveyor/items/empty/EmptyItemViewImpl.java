package com.avito.android.str_calendar.calendar.view.konveyor.items.empty;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarItemState;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.Position;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemView;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemViewImpl;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "state", "", "bind", "(Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;)V", "Landroid/view/View;", "kotlin.jvm.PlatformType", "s", "Landroid/view/View;", "backgroundView", "t", "view", "<init>", "(Landroid/view/View;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class EmptyItemViewImpl extends BaseViewHolder implements EmptyItemView {
    public final View s;
    public final View t;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            CalendarItemState.values();
            int[] iArr = new int[11];
            $EnumSwitchMapping$0 = iArr;
            iArr[5] = 1;
            iArr[9] = 2;
            iArr[10] = 3;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmptyItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = view;
        this.s = view.findViewById(R.id.background_view);
    }

    @Override // com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemView
    public void bind(@NotNull CalendarItemState calendarItemState) {
        Intrinsics.checkNotNullParameter(calendarItemState, "state");
        int ordinal = calendarItemState.ordinal();
        if (ordinal == 5) {
            this.t.setTag(Position.MIDDLE);
            View view = this.s;
            Intrinsics.checkNotNullExpressionValue(view, "backgroundView");
            Views.setBackgroundCompat(view, R.drawable.str_calendar_booking_selected_day_background);
        } else if (ordinal == 9) {
            this.t.setTag(Position.MIDDLE);
            View view2 = this.s;
            Intrinsics.checkNotNullExpressionValue(view2, "backgroundView");
            Views.setBackgroundCompat(view2, R.drawable.str_calendar_seller_unavailable_day_background);
        } else if (ordinal != 10) {
            this.t.setTag(Position.DEFAULT);
            View view3 = this.s;
            Intrinsics.checkNotNullExpressionValue(view3, "backgroundView");
            Views.setBackgroundCompat(view3, (Drawable) null);
        } else {
            this.t.setTag(Position.MIDDLE);
            View view4 = this.s;
            Intrinsics.checkNotNullExpressionValue(view4, "backgroundView");
            Views.setBackgroundCompat(view4, R.drawable.str_calendar_seller_booked_day_background);
        }
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        EmptyItemView.DefaultImpls.onUnbind(this);
    }
}
