package com.avito.android.str_calendar.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.str_calendar.booking.CalendarFragment;
import com.avito.android.str_calendar.di.module.StrBookingCalendarModule;
import com.avito.android.str_calendar.di.qualifier.AdvertId;
import com.avito.android.str_calendar.di.qualifier.EndDate;
import com.avito.android.str_calendar.di.qualifier.StartDate;
import dagger.BindsInstance;
import dagger.Component;
import java.util.Date;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/str_calendar/di/component/StrBookingCalendarComponent;", "", "Lcom/avito/android/str_calendar/booking/CalendarFragment;", "fragment", "", "inject", "(Lcom/avito/android/str_calendar/booking/CalendarFragment;)V", "Builder", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {StrBookingCalendarDependencies.class}, modules = {StrBookingCalendarModule.class})
@PerFragment
public interface StrBookingCalendarComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u00002\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00002\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00002\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/str_calendar/di/component/StrBookingCalendarComponent$Builder;", "", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/str_calendar/di/component/StrBookingCalendarComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "viewModelFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/str_calendar/di/component/StrBookingCalendarComponent$Builder;", "", BookingInfoActivity.EXTRA_ITEM_ID, "(Ljava/lang/String;)Lcom/avito/android/str_calendar/di/component/StrBookingCalendarComponent$Builder;", "Ljava/util/Date;", "checkInDate", "(Ljava/util/Date;)Lcom/avito/android/str_calendar/di/component/StrBookingCalendarComponent$Builder;", "checkOutDate", "Lcom/avito/android/str_calendar/di/component/StrBookingCalendarDependencies;", "dependencies", "bookingCalendarDependencies", "(Lcom/avito/android/str_calendar/di/component/StrBookingCalendarDependencies;)Lcom/avito/android/str_calendar/di/component/StrBookingCalendarComponent$Builder;", "Lcom/avito/android/str_calendar/di/component/StrBookingCalendarComponent;", "build", "()Lcom/avito/android/str_calendar/di/component/StrBookingCalendarComponent;", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder advertId(@AdvertId @Nullable String str);

        @NotNull
        Builder bookingCalendarDependencies(@NotNull StrBookingCalendarDependencies strBookingCalendarDependencies);

        @NotNull
        StrBookingCalendarComponent build();

        @BindsInstance
        @NotNull
        Builder checkInDate(@StartDate @Nullable Date date);

        @BindsInstance
        @NotNull
        Builder checkOutDate(@EndDate @Nullable Date date);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder viewModelFragment(@NotNull Fragment fragment);
    }

    void inject(@NotNull CalendarFragment calendarFragment);
}
