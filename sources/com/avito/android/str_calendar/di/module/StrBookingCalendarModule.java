package com.avito.android.str_calendar.di.module;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.server_time.TimeSource;
import com.avito.android.str_calendar.analytics.StrAnalyticsTracker;
import com.avito.android.str_calendar.booking.CalendarInteractor;
import com.avito.android.str_calendar.booking.CalendarInteractorImpl;
import com.avito.android.str_calendar.booking.CalendarResourceProvider;
import com.avito.android.str_calendar.booking.CalendarResourceProviderImpl;
import com.avito.android.str_calendar.booking.CalendarViewModel;
import com.avito.android.str_calendar.booking.CalendarViewModelFactory;
import com.avito.android.str_calendar.booking.CalendarViewModelImpl;
import com.avito.android.str_calendar.booking.data.BookingItemsDataSourceProvider;
import com.avito.android.str_calendar.booking.data.RestrictionsDataSourceProvider;
import com.avito.android.str_calendar.booking.model.BookingCalendarItem;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.str_calendar.calendar.view.konveyor.CalendarViewTypeProvider;
import com.avito.android.str_calendar.calendar.view.konveyor.CalendarViewTypeProviderImpl;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking.DayItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking.DayItemPresenter;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItemBlueprint;
import com.avito.android.str_calendar.di.qualifier.AdvertId;
import com.avito.android.str_calendar.di.qualifier.EndDate;
import com.avito.android.str_calendar.di.qualifier.StartDate;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001:\u00018B\t\b\u0002¢\u0006\u0004\b6\u00107J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0001\u00100\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0012\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0#2\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0$0#2\n\b\u0001\u0010*\u001a\u0004\u0018\u00010)2\n\b\u0001\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0001\u0010-\u001a\u0004\u0018\u00010+H\u0001¢\u0006\u0004\b.\u0010/J3\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0#2\n\b\u0001\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0001\u0010-\u001a\u0004\u0018\u00010+H\u0001¢\u0006\u0004\b1\u00102J3\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0$0#2\n\b\u0001\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0001\u0010-\u001a\u0004\u0018\u00010+H\u0001¢\u0006\u0004\b4\u00102¨\u00069"}, d2 = {"Lcom/avito/android/str_calendar/di/module/StrBookingCalendarModule;", "", "Lcom/avito/android/str_calendar/booking/CalendarViewModel;", "viewModel", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/booking/DayItemPresenter;", "provideDayItemPresenter$str_calendar_release", "(Lcom/avito/android/str_calendar/booking/CalendarViewModel;)Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/booking/DayItemPresenter;", "provideDayItemPresenter", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemBlueprint;", "monthItemBlueprint", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/booking/DayItemBlueprint;", "dayItemBlueprint", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemBlueprint;", "emptyItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$str_calendar_release", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemBlueprint;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/booking/DayItemBlueprint;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/str_calendar/booking/CalendarViewModelFactory;", "viewModelFactory", "provideCalendarViewModel$str_calendar_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/str_calendar/booking/CalendarViewModelFactory;)Lcom/avito/android/str_calendar/booking/CalendarViewModel;", "provideCalendarViewModel", "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "resourceProvider", "Lcom/avito/android/str_calendar/analytics/StrAnalyticsTracker;", "strAnalyticsTracker", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "", "Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", "restrictionsDataSourceProvider", "Lcom/avito/android/str_calendar/booking/model/BookingCalendarItem;", "calendarItemDataSourceProvider", "", BookingInfoActivity.EXTRA_ITEM_ID, "Ljava/util/Date;", "checkInDate", "checkOutDate", "provideCalendarViewModelFactory$str_calendar_release", "(Lcom/avito/android/str_calendar/booking/CalendarInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;Lcom/avito/android/str_calendar/analytics/StrAnalyticsTracker;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)Lcom/avito/android/str_calendar/booking/CalendarViewModelFactory;", "provideCalendarViewModelFactory", "provideCalendarDataSourceProvider$str_calendar_release", "(Ljava/util/Date;Ljava/util/Date;)Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "provideCalendarDataSourceProvider", "provideNewCalendarDataSourceProvider$str_calendar_release", "provideNewCalendarDataSourceProvider", "<init>", "()V", "Dependencies", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class, StrAnalyticsTrackerModule.class, StrCalendarRecyclerCommon.class})
public final class StrBookingCalendarModule {
    @NotNull
    public static final StrBookingCalendarModule INSTANCE = new StrBookingCalendarModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/str_calendar/di/module/StrBookingCalendarModule$Dependencies;", "", "Lcom/avito/android/str_calendar/booking/CalendarInteractorImpl;", "interactor", "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "bindsCalendarInteractor", "(Lcom/avito/android/str_calendar/booking/CalendarInteractorImpl;)Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "Lcom/avito/android/str_calendar/booking/CalendarResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "bindsCalendarResourceProvider", "(Lcom/avito/android/str_calendar/booking/CalendarResourceProviderImpl;)Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProviderImpl;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProvider;", "bindsCalendarViewTypeProvider", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProviderImpl;)Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProvider;", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        CalendarInteractor bindsCalendarInteractor(@NotNull CalendarInteractorImpl calendarInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        CalendarResourceProvider bindsCalendarResourceProvider(@NotNull CalendarResourceProviderImpl calendarResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        CalendarViewTypeProvider bindsCalendarViewTypeProvider(@NotNull CalendarViewTypeProviderImpl calendarViewTypeProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CalendarDataSourceProvider<List<CalendarBookingRestriction>> provideCalendarDataSourceProvider$str_calendar_release(@StartDate @Nullable Date date, @EndDate @Nullable Date date2) {
        return new RestrictionsDataSourceProvider(date, date2);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CalendarViewModel provideCalendarViewModel$str_calendar_release(@NotNull Fragment fragment, @NotNull CalendarViewModelFactory calendarViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(calendarViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, calendarViewModelFactory).get(CalendarViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (CalendarViewModel) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CalendarViewModelFactory provideCalendarViewModelFactory$str_calendar_release(@NotNull CalendarInteractor calendarInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull TimeSource timeSource, @NotNull CalendarResourceProvider calendarResourceProvider, @NotNull StrAnalyticsTracker strAnalyticsTracker, @NotNull CalendarDataSourceProvider<List<CalendarBookingRestriction>> calendarDataSourceProvider, @NotNull CalendarDataSourceProvider<List<BookingCalendarItem>> calendarDataSourceProvider2, @AdvertId @Nullable String str, @StartDate @Nullable Date date, @EndDate @Nullable Date date2) {
        Intrinsics.checkNotNullParameter(calendarInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(calendarResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(strAnalyticsTracker, "strAnalyticsTracker");
        Intrinsics.checkNotNullParameter(calendarDataSourceProvider, "restrictionsDataSourceProvider");
        Intrinsics.checkNotNullParameter(calendarDataSourceProvider2, "calendarItemDataSourceProvider");
        return new CalendarViewModelFactory(calendarInteractor, timeSource, schedulersFactory, calendarResourceProvider, strAnalyticsTracker, str, calendarDataSourceProvider, calendarDataSourceProvider2, (date == null || date2 == null) ? false : true);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DayItemPresenter provideDayItemPresenter$str_calendar_release(@NotNull CalendarViewModel calendarViewModel) {
        Intrinsics.checkNotNullParameter(calendarViewModel, "viewModel");
        return new DayItemPresenter(calendarViewModel.getDayClicksConsumer());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$str_calendar_release(@NotNull MonthItemBlueprint monthItemBlueprint, @NotNull DayItemBlueprint dayItemBlueprint, @NotNull EmptyItemBlueprint emptyItemBlueprint) {
        Intrinsics.checkNotNullParameter(monthItemBlueprint, "monthItemBlueprint");
        Intrinsics.checkNotNullParameter(dayItemBlueprint, "dayItemBlueprint");
        Intrinsics.checkNotNullParameter(emptyItemBlueprint, "emptyItemBlueprint");
        return new ItemBinder.Builder().registerItem(monthItemBlueprint).registerItem(dayItemBlueprint).registerItem(emptyItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CalendarDataSourceProvider<List<BookingCalendarItem>> provideNewCalendarDataSourceProvider$str_calendar_release(@StartDate @Nullable Date date, @EndDate @Nullable Date date2) {
        return new BookingItemsDataSourceProvider(date, date2);
    }
}
