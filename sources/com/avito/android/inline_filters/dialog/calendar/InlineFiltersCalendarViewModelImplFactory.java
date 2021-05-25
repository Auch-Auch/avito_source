package com.avito.android.inline_filters.dialog.calendar;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.str_calendar.booking.CalendarInteractor;
import com.avito.android.str_calendar.booking.CalendarResourceProvider;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.util.SchedulersFactory;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BV\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0017\u0010\u000e\u001a\u0013\u0012\u000f\u0012\r\u0012\t\u0012\u00070\n¢\u0006\u0002\b\u000b0\t0\b\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b'\u0010(J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R'\u0010\u000e\u001a\u0013\u0012\u000f\u0012\r\u0012\t\u0012\u00070\n¢\u0006\u0002\b\u000b0\t0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarViewModelImplFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "", "Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", "Lkotlin/jvm/JvmWildcard;", "d", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "restrictionsDataSourceProvider", "Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterDateRangeValue;", "f", "Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterDateRangeValue;", "value", "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "interactor", "", "e", "Ljava/lang/String;", "title", "Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "c", "Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "resourceProvider", "Lcom/avito/android/remote/model/search/Filter$Widget;", g.a, "Lcom/avito/android/remote/model/search/Filter$Widget;", "widget", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/str_calendar/booking/CalendarInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;Ljava/lang/String;Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterDateRangeValue;Lcom/avito/android/remote/model/search/Filter$Widget;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersCalendarViewModelImplFactory implements ViewModelProvider.Factory {
    public final CalendarInteractor a;
    public final SchedulersFactory b;
    public final CalendarResourceProvider c;
    public final CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>> d;
    public final String e;
    public final InlineFilterValue.InlineFilterDateRangeValue f;
    public final Filter.Widget g;

    @Inject
    public InlineFiltersCalendarViewModelImplFactory(@NotNull CalendarInteractor calendarInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull CalendarResourceProvider calendarResourceProvider, @NotNull CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>> calendarDataSourceProvider, @NotNull String str, @Nullable InlineFilterValue.InlineFilterDateRangeValue inlineFilterDateRangeValue, @Nullable Filter.Widget widget) {
        Intrinsics.checkNotNullParameter(calendarInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(calendarResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(calendarDataSourceProvider, "restrictionsDataSourceProvider");
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = calendarInteractor;
        this.b = schedulersFactory;
        this.c = calendarResourceProvider;
        this.d = calendarDataSourceProvider;
        this.e = str;
        this.f = inlineFilterDateRangeValue;
        this.g = widget;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(InlineFiltersCalendarViewModelImpl.class)) {
            return new InlineFiltersCalendarViewModelImpl(this.a, this.b, this.c, this.d, this.g, this.f, this.e);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
