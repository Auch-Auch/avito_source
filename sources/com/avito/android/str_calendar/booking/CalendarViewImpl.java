package com.avito.android.str_calendar.booking;

import a2.a.a.b3.a.c;
import a2.a.a.b3.a.d;
import a2.a.a.b3.a.e;
import a2.a.a.b3.a.h;
import a2.a.a.b3.a.i;
import a2.a.a.b3.a.j;
import a2.a.a.b3.a.k;
import a2.a.a.b3.a.l;
import a2.a.a.b3.a.m;
import a2.a.a.b3.a.n;
import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.calendar.base.BaseCalendarView;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\b2\u00103J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001f\u001a\n \u001d*\u0004\u0018\u00010\u00190\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00064"}, d2 = {"Lcom/avito/android/str_calendar/booking/CalendarViewImpl;", "Lcom/avito/android/str_calendar/booking/CalendarView;", "Lcom/avito/android/str_calendar/calendar/base/BaseCalendarView;", "Lcom/avito/android/str_calendar/booking/CalendarViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/str_calendar/booking/CalendarViewModel;)V", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getCalendarItemDecoration", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Lcom/avito/android/util/DeviceMetrics;", g.a, "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/jakewharton/rxrelay2/Relay;", "c", "Lcom/jakewharton/rxrelay2/Relay;", "closeClicksRelay", "d", "getCloseClicks", "()Lcom/jakewharton/rxrelay2/Relay;", "closeClicks", "Landroid/view/View;", "e", "Landroid/view/View;", "view", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.SEND_ABUSE, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/str_calendar/booking/CalendarHeaderView;", "h", "Lcom/avito/android/str_calendar/booking/CalendarHeaderView;", "calendarHeaderView", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Lcom/avito/android/analytics/Analytics;Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/str_calendar/booking/CalendarHeaderView;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class CalendarViewImpl extends BaseCalendarView implements CalendarView {
    public final ProgressOverlay a;
    public final View b;
    public final Relay<Unit> c;
    @NotNull
    public final Relay<Unit> d;
    public final View e;
    public final LifecycleOwner f;
    public final DeviceMetrics g;
    public final CalendarHeaderView h;

    public CalendarViewImpl(@NotNull Analytics analytics, @NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull LifecycleOwner lifecycleOwner, @NotNull DeviceMetrics deviceMetrics, @NotNull CalendarHeaderView calendarHeaderView) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(calendarHeaderView, "calendarHeaderView");
        this.e = view;
        this.f = lifecycleOwner;
        this.g = deviceMetrics;
        this.h = calendarHeaderView;
        view.getContext();
        View findViewById = view.findViewById(R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.content_holder)");
        this.a = new ProgressOverlay((ViewGroup) findViewById, 0, analytics, false, 0, 26, null);
        this.b = view.findViewById(R.id.button);
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.c = create;
        this.d = create;
        calendarHeaderView.setNavigationClickListener(new n(this));
        setCalendarUpRecyclerView(view, adapterPresenter, itemBinder);
    }

    @Override // com.avito.android.str_calendar.booking.CalendarView
    public void bindTo(@NotNull CalendarViewModel calendarViewModel) {
        Intrinsics.checkNotNullParameter(calendarViewModel, "viewModel");
        calendarViewModel.getUpdateViewChanges().observe(this.f, new m(this));
        calendarViewModel.getShowContentChanges().observe(this.f, new k(this));
        calendarViewModel.getProgressChanges().observe(this.f, new i(this));
        calendarViewModel.getErrorMessageChanges().observe(this.f, new h(this));
        calendarViewModel.getErrorChanges().observe(this.f, new a2.a.a.b3.a.g(this));
        calendarViewModel.getClearButtonEnableChanges().observe(this.f, new e(this));
        calendarViewModel.getToolbarTitleChanges().observe(this.f, new l(this));
        calendarViewModel.getScrollToChanges().observe(this.f, new j(this));
        Consumer<Unit> clearClicksConsumer = calendarViewModel.getClearClicksConsumer();
        Consumer<Unit> chooseClicksConsumer = calendarViewModel.getChooseClicksConsumer();
        this.h.setClearBtnClickListener(new c(clearClicksConsumer));
        this.b.setOnClickListener(new d(chooseClicksConsumer));
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarView
    @NotNull
    public RecyclerView.ItemDecoration getCalendarItemDecoration(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        Intrinsics.checkNotNullParameter(spanSizeLookup, "spanSizeLookup");
        Context context = getRecyclerView().getContext();
        a aVar = new Function2<Integer, Integer, Integer>(spanSizeLookup) { // from class: com.avito.android.str_calendar.booking.CalendarViewImpl.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public Integer invoke(Integer num, Integer num2) {
                return Integer.valueOf(((GridLayoutManager.SpanSizeLookup) this.receiver).getSpanIndex(num.intValue(), num2.intValue()));
            }
        };
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new BookingCalendarRecyclerViewDecoration(7, aVar, context.getResources().getDimensionPixelSize(R.dimen.calendar_recycler_view_horizontal_padding), context.getResources().getDimensionPixelSize(R.dimen.calendar_recycler_view_day_horizontal_padding), context.getResources().getDimensionPixelSize(R.dimen.calendar_recycler_view_day_vertical_margin));
    }

    @Override // com.avito.android.str_calendar.booking.CalendarView
    @NotNull
    public Relay<Unit> getCloseClicks() {
        return this.d;
    }
}
