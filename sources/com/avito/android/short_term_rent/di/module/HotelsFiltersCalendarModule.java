package com.avito.android.short_term_rent.di.module;

import com.avito.android.di.PerFragment;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarViewModelImplFactory;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsFiltersCalendarViewModel;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsFiltersCalendarViewModelImpl;
import com.avito.android.str_calendar.booking.CalendarInteractor;
import com.avito.android.str_calendar.booking.CalendarInteractorImpl;
import com.avito.android.str_calendar.booking.CalendarResourceProvider;
import com.avito.android.str_calendar.booking.CalendarResourceProviderImpl;
import com.avito.android.str_calendar.booking.CalendarViewModel;
import com.avito.android.str_calendar.booking.data.RestrictionsDataSourceProvider;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.str_calendar.calendar.view.konveyor.CalendarViewTypeProvider;
import com.avito.android.str_calendar.calendar.view.konveyor.CalendarViewTypeProviderImpl;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking.DayItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking.DayItemPresenter;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItemBlueprint;
import com.avito.android.str_calendar.di.module.StrCalendarRecyclerCommon;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/avito/android/short_term_rent/di/module/HotelsFiltersCalendarModule;", "", "Lcom/avito/android/str_calendar/booking/CalendarViewModel;", "viewModel", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/booking/DayItemPresenter;", "provideDayItemPresenter$short_term_rent_release", "(Lcom/avito/android/str_calendar/booking/CalendarViewModel;)Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/booking/DayItemPresenter;", "provideDayItemPresenter", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemBlueprint;", "monthItemBlueprint", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/booking/DayItemBlueprint;", "dayItemBlueprint", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemBlueprint;", "emptyItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$short_term_rent_release", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemBlueprint;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/booking/DayItemBlueprint;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsCalendarViewModelImplFactory;", "viewModelFactory", "Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsFiltersCalendarViewModel;", "provideCalendarViewModel$short_term_rent_release", "(Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsCalendarViewModelImplFactory;)Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsFiltersCalendarViewModel;", "provideCalendarViewModel", "<init>", "()V", "Dependencies", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class, StrCalendarRecyclerCommon.class})
public final class HotelsFiltersCalendarModule {
    @NotNull
    public static final HotelsFiltersCalendarModule INSTANCE = new HotelsFiltersCalendarModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u001a\u001a\u0013\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0018¢\u0006\u0002\b\u00190\u00170\u00162\u0006\u0010\b\u001a\u00020\u0015H'¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/short_term_rent/di/module/HotelsFiltersCalendarModule$Dependencies;", "", "Lcom/avito/android/str_calendar/booking/CalendarInteractorImpl;", "interactor", "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "bindsCalendarInteractor", "(Lcom/avito/android/str_calendar/booking/CalendarInteractorImpl;)Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "Lcom/avito/android/str_calendar/booking/CalendarResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "bindsCalendarResourceProvider", "(Lcom/avito/android/str_calendar/booking/CalendarResourceProviderImpl;)Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProviderImpl;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProvider;", "bindsCalendarViewTypeProvider", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProviderImpl;)Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProvider;", "Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsFiltersCalendarViewModel;", "hotelsFiltersCalendarViewModel", "Lcom/avito/android/str_calendar/booking/CalendarViewModel;", "bindViewModel", "(Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsFiltersCalendarViewModel;)Lcom/avito/android/str_calendar/booking/CalendarViewModel;", "Lcom/avito/android/str_calendar/booking/data/RestrictionsDataSourceProvider;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "", "Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", "Lkotlin/jvm/JvmWildcard;", "bindCalendarDataSourceProvider", "(Lcom/avito/android/str_calendar/booking/data/RestrictionsDataSourceProvider;)Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @Binds
        @NotNull
        @PerFragment
        CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>> bindCalendarDataSourceProvider(@NotNull RestrictionsDataSourceProvider restrictionsDataSourceProvider);

        @PerFragment
        @Binds
        @NotNull
        CalendarViewModel bindViewModel(@NotNull HotelsFiltersCalendarViewModel hotelsFiltersCalendarViewModel);

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
    public static final HotelsFiltersCalendarViewModel provideCalendarViewModel$short_term_rent_release(@NotNull HotelsCalendarViewModelImplFactory hotelsCalendarViewModelImplFactory) {
        Intrinsics.checkNotNullParameter(hotelsCalendarViewModelImplFactory, "viewModelFactory");
        return (HotelsFiltersCalendarViewModel) hotelsCalendarViewModelImplFactory.create(HotelsFiltersCalendarViewModelImpl.class);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DayItemPresenter provideDayItemPresenter$short_term_rent_release(@NotNull CalendarViewModel calendarViewModel) {
        Intrinsics.checkNotNullParameter(calendarViewModel, "viewModel");
        return new DayItemPresenter(calendarViewModel.getDayClicksConsumer());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$short_term_rent_release(@NotNull MonthItemBlueprint monthItemBlueprint, @NotNull DayItemBlueprint dayItemBlueprint, @NotNull EmptyItemBlueprint emptyItemBlueprint) {
        Intrinsics.checkNotNullParameter(monthItemBlueprint, "monthItemBlueprint");
        Intrinsics.checkNotNullParameter(dayItemBlueprint, "dayItemBlueprint");
        Intrinsics.checkNotNullParameter(emptyItemBlueprint, "emptyItemBlueprint");
        return new ItemBinder.Builder().registerItem(monthItemBlueprint).registerItem(dayItemBlueprint).registerItem(emptyItemBlueprint).build();
    }
}
