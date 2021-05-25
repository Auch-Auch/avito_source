package com.avito.android.short_term_rent.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule;
import com.avito.android.short_term_rent.di.qualifier.AdvertId;
import com.avito.android.short_term_rent.di.qualifier.CheckInDate;
import com.avito.android.short_term_rent.di.qualifier.CheckOutDate;
import com.avito.android.short_term_rent.di.qualifier.ShowCalendar;
import com.avito.android.short_term_rent.di.qualifier.Workflow;
import com.avito.android.short_term_rent.start_booking.StrStartBookingFragment;
import dagger.BindsInstance;
import dagger.Component;
import java.util.Date;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/short_term_rent/di/component/StrStartBookingComponent;", "", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingFragment;", "fragment", "", "inject", "(Lcom/avito/android/short_term_rent/start_booking/StrStartBookingFragment;)V", "Builder", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {StrStartBookingDependencies.class}, modules = {StrStartBookingModule.class})
@PerFragment
public interface StrStartBookingComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00002\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00002\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00002\b\b\u0001\u0010\u0013\u001a\u00020\tH'¢\u0006\u0004\b\u0013\u0010\u000bJ\u001b\u0010\u0014\u001a\u00020\u00002\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u0014\u0010\u000bJ\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/short_term_rent/di/component/StrStartBookingComponent$Builder;", "", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/short_term_rent/di/component/StrStartBookingComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "viewModelFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/short_term_rent/di/component/StrStartBookingComponent$Builder;", "", BookingInfoActivity.EXTRA_ITEM_ID, "(Ljava/lang/String;)Lcom/avito/android/short_term_rent/di/component/StrStartBookingComponent$Builder;", "Ljava/util/Date;", "checkInDate", "(Ljava/util/Date;)Lcom/avito/android/short_term_rent/di/component/StrStartBookingComponent$Builder;", "checkOutDate", "", "showCalendar", "(Z)Lcom/avito/android/short_term_rent/di/component/StrStartBookingComponent$Builder;", "source", "workflow", "Lcom/avito/android/short_term_rent/di/component/StrStartBookingDependencies;", "dependencies", "startBookingDependencies", "(Lcom/avito/android/short_term_rent/di/component/StrStartBookingDependencies;)Lcom/avito/android/short_term_rent/di/component/StrStartBookingComponent$Builder;", "Lcom/avito/android/short_term_rent/di/component/StrStartBookingComponent;", "build", "()Lcom/avito/android/short_term_rent/di/component/StrStartBookingComponent;", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder advertId(@AdvertId @NotNull String str);

        @NotNull
        StrStartBookingComponent build();

        @BindsInstance
        @NotNull
        Builder checkInDate(@CheckInDate @Nullable Date date);

        @BindsInstance
        @NotNull
        Builder checkOutDate(@CheckOutDate @Nullable Date date);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder showCalendar(@ShowCalendar boolean z);

        @BindsInstance
        @NotNull
        Builder source(@StrStartBookingModule.Source @NotNull String str);

        @NotNull
        Builder startBookingDependencies(@NotNull StrStartBookingDependencies strStartBookingDependencies);

        @BindsInstance
        @NotNull
        Builder viewModelFragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder workflow(@Workflow @Nullable String str);
    }

    void inject(@NotNull StrStartBookingFragment strStartBookingFragment);
}
