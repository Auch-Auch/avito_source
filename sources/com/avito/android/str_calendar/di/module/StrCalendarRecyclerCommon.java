package com.avito.android.str_calendar.di.module;

import com.avito.android.di.PerFragment;
import com.avito.android.str_calendar.calendar.view.konveyor.CalendarViewTypeProvider;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemPresenter;
import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItemPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/str_calendar/di/module/StrCalendarRecyclerCommon;", "", "Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProvider;", "viewTypeProvider", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$str_calendar_release", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProvider;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemPresenter;", "provideEmptyItemPresenter$str_calendar_release", "()Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemPresenter;", "provideEmptyItemPresenter", "presenter", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemBlueprint;", "provideEmptyItemBlueprint$str_calendar_release", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemPresenter;)Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemBlueprint;", "provideEmptyItemBlueprint", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemPresenter;", "provideMonthItemPresenter$str_calendar_release", "()Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemPresenter;", "provideMonthItemPresenter", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemBlueprint;", "provideMonthItemBlueprint$str_calendar_release", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemPresenter;)Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemBlueprint;", "provideMonthItemBlueprint", "<init>", "()V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class StrCalendarRecyclerCommon {
    @NotNull
    public static final StrCalendarRecyclerCommon INSTANCE = new StrCalendarRecyclerCommon();

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$str_calendar_release(@NotNull CalendarViewTypeProvider calendarViewTypeProvider, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(calendarViewTypeProvider, "viewTypeProvider");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new SimpleAdapterPresenter(calendarViewTypeProvider, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final EmptyItemBlueprint provideEmptyItemBlueprint$str_calendar_release(@NotNull EmptyItemPresenter emptyItemPresenter) {
        Intrinsics.checkNotNullParameter(emptyItemPresenter, "presenter");
        return new EmptyItemBlueprint(emptyItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final EmptyItemPresenter provideEmptyItemPresenter$str_calendar_release() {
        return new EmptyItemPresenter();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final MonthItemBlueprint provideMonthItemBlueprint$str_calendar_release(@NotNull MonthItemPresenter monthItemPresenter) {
        Intrinsics.checkNotNullParameter(monthItemPresenter, "presenter");
        return new MonthItemBlueprint(monthItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final MonthItemPresenter provideMonthItemPresenter$str_calendar_release() {
        return new MonthItemPresenter();
    }
}
