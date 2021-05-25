package com.avito.android.str_calendar.di.module;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.str_calendar.calendar.view.konveyor.CalendarViewTypeProvider;
import com.avito.android.str_calendar.calendar.view.konveyor.CalendarViewTypeProviderImpl;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItemBackgroundsProvider;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItemBackgroundsProviderImpl;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItemPresenter;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItemBlueprint;
import com.avito.android.str_calendar.di.qualifier.AdvertId;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarInteractor;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarInteractorImpl;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarResourceProvider;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarResourceProviderImpl;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModel;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModelFactory;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModelImpl;
import com.avito.android.str_calendar.seller.calendar.data.SellerCalendarDataSourceProvider;
import com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u00015B\t\b\u0002¢\u0006\u0004\b3\u00104J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010#\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001eH\u0001¢\u0006\u0004\b!\u0010\"J\u000f\u0010&\u001a\u00020\u001eH\u0001¢\u0006\u0004\b$\u0010%J'\u0010/\u001a\u00020,2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020 2\u0006\u0010+\u001a\u00020*H\u0001¢\u0006\u0004\b-\u0010.J\u0015\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0001¢\u0006\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/avito/android/str_calendar/di/module/StrSellerCalendarModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModelFactory;", "viewModelFactory", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModel;", "provideSellerCalendarViewModel$str_calendar_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModelFactory;)Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModel;", "provideSellerCalendarViewModel", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractor;", "sellerInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo;", "calendarDataSourceProvider", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;", "resourceProvider", "provideCalendarViewModelFactory$str_calendar_release", "(Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractor;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;)Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModelFactory;", "provideCalendarViewModelFactory", "viewModel", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemPresenter;", "provideSellerDayItemPresenter$str_calendar_release", "(Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModel;)Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemPresenter;", "provideSellerDayItemPresenter", "presenter", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBackgroundsProvider;", "backgroundsProvider", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBlueprint;", "provideDayItemBlueprint$str_calendar_release", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemPresenter;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBackgroundsProvider;)Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBlueprint;", "provideDayItemBlueprint", "provideDayItemBackgroundsProvider$str_calendar_release", "()Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBackgroundsProvider;", "provideDayItemBackgroundsProvider", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemBlueprint;", "monthItemBlueprint", "dayItemBlueprint", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemBlueprint;", "emptyItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$str_calendar_release", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemBlueprint;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBlueprint;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "provideCalendarDataSourceProvider$str_calendar_release", "()Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "provideCalendarDataSourceProvider", "<init>", "()V", "Dependencies", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class, StrCalendarRecyclerCommon.class})
public final class StrSellerCalendarModule {
    @NotNull
    public static final StrSellerCalendarModule INSTANCE = new StrSellerCalendarModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/str_calendar/di/module/StrSellerCalendarModule$Dependencies;", "", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractorImpl;", "interactor", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractor;", "bindsCalendarInteractor", "(Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractorImpl;)Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractor;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProvider;", "bindsCalendarViewTypeProvider", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProviderImpl;)Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProvider;", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProviderImpl;", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;", "bindsSellerCalendarResourceProvider", "(Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProviderImpl;)Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        SellerCalendarInteractor bindsCalendarInteractor(@NotNull SellerCalendarInteractorImpl sellerCalendarInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        CalendarViewTypeProvider bindsCalendarViewTypeProvider(@NotNull CalendarViewTypeProviderImpl calendarViewTypeProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        SellerCalendarResourceProvider bindsSellerCalendarResourceProvider(@NotNull SellerCalendarResourceProviderImpl sellerCalendarResourceProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CalendarDataSourceProvider<SellerCalendarInfo> provideCalendarDataSourceProvider$str_calendar_release() {
        return new SellerCalendarDataSourceProvider();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SellerCalendarViewModelFactory provideCalendarViewModelFactory$str_calendar_release(@NotNull SellerCalendarInteractor sellerCalendarInteractor, @NotNull SchedulersFactory schedulersFactory, @AdvertId @NotNull String str, @NotNull CalendarDataSourceProvider<SellerCalendarInfo> calendarDataSourceProvider, @NotNull SellerCalendarResourceProvider sellerCalendarResourceProvider) {
        Intrinsics.checkNotNullParameter(sellerCalendarInteractor, "sellerInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(calendarDataSourceProvider, "calendarDataSourceProvider");
        Intrinsics.checkNotNullParameter(sellerCalendarResourceProvider, "resourceProvider");
        return new SellerCalendarViewModelFactory(sellerCalendarInteractor, schedulersFactory, str, calendarDataSourceProvider, sellerCalendarResourceProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SellerDayItemBackgroundsProvider provideDayItemBackgroundsProvider$str_calendar_release() {
        return new SellerDayItemBackgroundsProviderImpl();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SellerDayItemBlueprint provideDayItemBlueprint$str_calendar_release(@NotNull SellerDayItemPresenter sellerDayItemPresenter, @NotNull SellerDayItemBackgroundsProvider sellerDayItemBackgroundsProvider) {
        Intrinsics.checkNotNullParameter(sellerDayItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(sellerDayItemBackgroundsProvider, "backgroundsProvider");
        return new SellerDayItemBlueprint(sellerDayItemPresenter, sellerDayItemBackgroundsProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$str_calendar_release(@NotNull MonthItemBlueprint monthItemBlueprint, @NotNull SellerDayItemBlueprint sellerDayItemBlueprint, @NotNull EmptyItemBlueprint emptyItemBlueprint) {
        Intrinsics.checkNotNullParameter(monthItemBlueprint, "monthItemBlueprint");
        Intrinsics.checkNotNullParameter(sellerDayItemBlueprint, "dayItemBlueprint");
        Intrinsics.checkNotNullParameter(emptyItemBlueprint, "emptyItemBlueprint");
        return new ItemBinder.Builder().registerItem(monthItemBlueprint).registerItem(sellerDayItemBlueprint).registerItem(emptyItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SellerCalendarViewModel provideSellerCalendarViewModel$str_calendar_release(@NotNull Fragment fragment, @NotNull SellerCalendarViewModelFactory sellerCalendarViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(sellerCalendarViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, sellerCalendarViewModelFactory).get(SellerCalendarViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (SellerCalendarViewModel) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SellerDayItemPresenter provideSellerDayItemPresenter$str_calendar_release(@NotNull SellerCalendarViewModel sellerCalendarViewModel) {
        Intrinsics.checkNotNullParameter(sellerCalendarViewModel, "viewModel");
        return new SellerDayItemPresenter(sellerCalendarViewModel.getDayClicksConsumer());
    }
}
