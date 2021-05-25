package com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking;

import a2.a.a.b3.b.a.a.a.a.a.a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.avito.android.remote.model.Sort;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarItemState;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.Position;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking.DayItemView;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0016\u001a\n \u000f*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\n \u000f*\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/booking/DayItemViewImpl;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/booking/DayItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "state", "Lio/reactivex/functions/Consumer;", "Ljava/util/Date;", "clickConsumer", Sort.DATE, "", "bind", "(Ljava/lang/String;Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;Lio/reactivex/functions/Consumer;Ljava/util/Date;)V", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "t", "Landroid/widget/FrameLayout;", "textViewContainer", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "s", "Landroid/view/View;", "backgroundView", VKApiConst.VERSION, "view", "<init>", "(Landroid/view/View;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class DayItemViewImpl extends BaseViewHolder implements DayItemView {
    public final View s;
    public final FrameLayout t;
    public final TextView u;
    public final View v;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            CalendarItemState.values();
            int[] iArr = new int[11];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
            iArr[4] = 5;
            iArr[5] = 6;
            iArr[6] = 7;
            iArr[8] = 8;
            iArr[7] = 9;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DayItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.v = view;
        this.s = view.findViewById(R.id.background_view);
        this.t = (FrameLayout) view.findViewById(R.id.text_view_container);
        this.u = (TextView) view.findViewById(R.id.text_view);
    }

    @Override // com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking.DayItemView
    public void bind(@NotNull String str, @NotNull CalendarItemState calendarItemState, @NotNull Consumer<Date> consumer, @NotNull Date date) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(calendarItemState, "state");
        Intrinsics.checkNotNullParameter(consumer, "clickConsumer");
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        TextView textView = this.u;
        Intrinsics.checkNotNullExpressionValue(textView, "textView");
        textView.setText(str);
        switch (calendarItemState.ordinal()) {
            case 0:
                View view = this.s;
                Intrinsics.checkNotNullExpressionValue(view, "backgroundView");
                view.setTag(Position.DEFAULT);
                View view2 = this.s;
                Intrinsics.checkNotNullExpressionValue(view2, "backgroundView");
                Views.setBackgroundCompat(view2, (Drawable) null);
                FrameLayout frameLayout = this.t;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "textViewContainer");
                frameLayout.setForeground(null);
                TextView textView2 = this.u;
                Intrinsics.checkNotNullExpressionValue(textView2, "textView");
                Views.setBackgroundCompat(textView2, com.avito.android.ui_components.R.drawable.bg_selectable_blue_oval);
                TextView textView3 = this.u;
                Context context = this.v.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                textView3.setTextColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.black));
                break;
            case 1:
                View view3 = this.s;
                Intrinsics.checkNotNullExpressionValue(view3, "backgroundView");
                view3.setTag(Position.DEFAULT);
                View view4 = this.s;
                Intrinsics.checkNotNullExpressionValue(view4, "backgroundView");
                Views.setBackgroundCompat(view4, (Drawable) null);
                FrameLayout frameLayout2 = this.t;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "textViewContainer");
                frameLayout2.setForeground(null);
                TextView textView4 = this.u;
                Intrinsics.checkNotNullExpressionValue(textView4, "textView");
                Views.setBackgroundCompat(textView4, R.drawable.str_calendar_booking_current_day_background);
                TextView textView5 = this.u;
                Context context2 = this.v.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "view.context");
                textView5.setTextColor(Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.black));
                break;
            case 2:
                View view5 = this.s;
                Intrinsics.checkNotNullExpressionValue(view5, "backgroundView");
                view5.setTag(Position.SINGLE);
                View view6 = this.s;
                Intrinsics.checkNotNullExpressionValue(view6, "backgroundView");
                Views.setBackgroundCompat(view6, (Drawable) null);
                FrameLayout frameLayout3 = this.t;
                Intrinsics.checkNotNullExpressionValue(frameLayout3, "textViewContainer");
                frameLayout3.setForeground(null);
                TextView textView6 = this.u;
                Intrinsics.checkNotNullExpressionValue(textView6, "textView");
                Views.setBackgroundCompat(textView6, R.drawable.str_calendar_booking_selected_single_day_background);
                TextView textView7 = this.u;
                Context context3 = this.v.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "view.context");
                textView7.setTextColor(Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.constantWhite));
                break;
            case 3:
                View view7 = this.s;
                Intrinsics.checkNotNullExpressionValue(view7, "backgroundView");
                view7.setTag(Position.LEFT);
                View view8 = this.s;
                Intrinsics.checkNotNullExpressionValue(view8, "backgroundView");
                Views.setBackgroundCompat(view8, R.drawable.str_calendar_booking_selected_day_left_background);
                FrameLayout frameLayout4 = this.t;
                Intrinsics.checkNotNullExpressionValue(frameLayout4, "textViewContainer");
                frameLayout4.setForeground(null);
                TextView textView8 = this.u;
                Intrinsics.checkNotNullExpressionValue(textView8, "textView");
                Views.setBackgroundCompat(textView8, (Drawable) null);
                TextView textView9 = this.u;
                Context context4 = this.v.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "view.context");
                textView9.setTextColor(Contexts.getColorByAttr(context4, com.avito.android.lib.design.R.attr.constantWhite));
                break;
            case 4:
                View view9 = this.s;
                Intrinsics.checkNotNullExpressionValue(view9, "backgroundView");
                view9.setTag(Position.RIGHT);
                View view10 = this.s;
                Intrinsics.checkNotNullExpressionValue(view10, "backgroundView");
                Views.setBackgroundCompat(view10, R.drawable.str_calendar_booking_selected_day_right_background);
                FrameLayout frameLayout5 = this.t;
                Intrinsics.checkNotNullExpressionValue(frameLayout5, "textViewContainer");
                frameLayout5.setForeground(null);
                TextView textView10 = this.u;
                Intrinsics.checkNotNullExpressionValue(textView10, "textView");
                Views.setBackgroundCompat(textView10, (Drawable) null);
                TextView textView11 = this.u;
                Context context5 = this.v.getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "view.context");
                textView11.setTextColor(Contexts.getColorByAttr(context5, com.avito.android.lib.design.R.attr.constantWhite));
                break;
            case 5:
                View view11 = this.s;
                Intrinsics.checkNotNullExpressionValue(view11, "backgroundView");
                view11.setTag(Position.MIDDLE);
                View view12 = this.s;
                Intrinsics.checkNotNullExpressionValue(view12, "backgroundView");
                Views.setBackgroundCompat(view12, R.drawable.str_calendar_booking_selected_day_background);
                FrameLayout frameLayout6 = this.t;
                Intrinsics.checkNotNullExpressionValue(frameLayout6, "textViewContainer");
                frameLayout6.setForeground(null);
                TextView textView12 = this.u;
                Intrinsics.checkNotNullExpressionValue(textView12, "textView");
                Views.setBackgroundCompat(textView12, (Drawable) null);
                TextView textView13 = this.u;
                Context context6 = this.v.getContext();
                Intrinsics.checkNotNullExpressionValue(context6, "view.context");
                textView13.setTextColor(Contexts.getColorByAttr(context6, com.avito.android.lib.design.R.attr.constantWhite));
                break;
            case 6:
                View view13 = this.s;
                Intrinsics.checkNotNullExpressionValue(view13, "backgroundView");
                view13.setTag(Position.DEFAULT);
                View view14 = this.s;
                Intrinsics.checkNotNullExpressionValue(view14, "backgroundView");
                Views.setBackgroundCompat(view14, (Drawable) null);
                FrameLayout frameLayout7 = this.t;
                Intrinsics.checkNotNullExpressionValue(frameLayout7, "textViewContainer");
                frameLayout7.setForeground(this.v.getContext().getDrawable(R.drawable.str_calendar_booking_cross_date_line));
                TextView textView14 = this.u;
                Intrinsics.checkNotNullExpressionValue(textView14, "textView");
                Views.setBackgroundCompat(textView14, (Drawable) null);
                this.u.setTextColor(ContextCompat.getColor(this.v.getContext(), R.color.calendar_past_text_color));
                break;
            case 7:
                View view15 = this.s;
                Intrinsics.checkNotNullExpressionValue(view15, "backgroundView");
                view15.setTag(Position.DEFAULT);
                View view16 = this.s;
                Intrinsics.checkNotNullExpressionValue(view16, "backgroundView");
                Views.setBackgroundCompat(view16, (Drawable) null);
                FrameLayout frameLayout8 = this.t;
                Intrinsics.checkNotNullExpressionValue(frameLayout8, "textViewContainer");
                frameLayout8.setForeground(this.v.getContext().getDrawable(R.drawable.str_calendar_booking_cross_date_line));
                TextView textView15 = this.u;
                Intrinsics.checkNotNullExpressionValue(textView15, "textView");
                Views.setBackgroundCompat(textView15, R.drawable.str_calendar_booking_current_day_background);
                this.u.setTextColor(ContextCompat.getColor(this.v.getContext(), R.color.calendar_past_text_color));
                break;
            case 8:
                View view17 = this.s;
                Intrinsics.checkNotNullExpressionValue(view17, "backgroundView");
                view17.setTag(Position.DEFAULT);
                View view18 = this.s;
                Intrinsics.checkNotNullExpressionValue(view18, "backgroundView");
                Views.setBackgroundCompat(view18, (Drawable) null);
                FrameLayout frameLayout9 = this.t;
                Intrinsics.checkNotNullExpressionValue(frameLayout9, "textViewContainer");
                frameLayout9.setForeground(null);
                TextView textView16 = this.u;
                Intrinsics.checkNotNullExpressionValue(textView16, "textView");
                Views.setBackgroundCompat(textView16, (Drawable) null);
                this.u.setTextColor(ContextCompat.getColor(this.v.getContext(), R.color.calendar_past_text_color));
                break;
        }
        if (calendarItemState == CalendarItemState.UNAVAILABLE || calendarItemState == CalendarItemState.CROSSED) {
            this.u.setOnClickListener(null);
        } else {
            this.u.setOnClickListener(new a(consumer, date));
        }
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        DayItemView.DefaultImpls.onUnbind(this);
    }
}
