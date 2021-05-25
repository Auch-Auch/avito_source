package com.avito.android.str_calendar.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule;
import com.avito.android.str_calendar.di.qualifier.AdvertId;
import com.avito.android.str_calendar.di.qualifier.EndDate;
import com.avito.android.str_calendar.di.qualifier.StartDate;
import com.avito.android.str_calendar.seller.SellerCalendarRouter;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersFragment;
import dagger.BindsInstance;
import dagger.Component;
import java.util.Date;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/str_calendar/di/component/StrSellerCalendarParametersComponent;", "", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersFragment;", "fragment", "", "inject", "(Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersFragment;)V", "Builder", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {StrSellerCalendarParametersDependencies.class}, modules = {StrSellerCalendarParametersModule.class})
@PerFragment
public interface StrSellerCalendarParametersComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\u00002\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u000bH'¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00002\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000bH'¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/str_calendar/di/component/StrSellerCalendarParametersComponent$Builder;", "", "Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;", "router", "(Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;)Lcom/avito/android/str_calendar/di/component/StrSellerCalendarParametersComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/str_calendar/di/component/StrSellerCalendarParametersComponent$Builder;", "", BookingInfoActivity.EXTRA_ITEM_ID, "(Ljava/lang/String;)Lcom/avito/android/str_calendar/di/component/StrSellerCalendarParametersComponent$Builder;", "Ljava/util/Date;", "startDate", "(Ljava/util/Date;)Lcom/avito/android/str_calendar/di/component/StrSellerCalendarParametersComponent$Builder;", "endDate", "Landroidx/fragment/app/Fragment;", "fragment", "viewModelFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/str_calendar/di/component/StrSellerCalendarParametersComponent$Builder;", "Lcom/avito/android/str_calendar/di/component/StrSellerCalendarParametersDependencies;", "dependencies", "sellerBaseCalendarParametersDependencies", "(Lcom/avito/android/str_calendar/di/component/StrSellerCalendarParametersDependencies;)Lcom/avito/android/str_calendar/di/component/StrSellerCalendarParametersComponent$Builder;", "Lcom/avito/android/str_calendar/di/component/StrSellerCalendarParametersComponent;", "build", "()Lcom/avito/android/str_calendar/di/component/StrSellerCalendarParametersComponent;", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder advertId(@AdvertId @NotNull String str);

        @NotNull
        StrSellerCalendarParametersComponent build();

        @BindsInstance
        @NotNull
        Builder endDate(@EndDate @Nullable Date date);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder router(@NotNull SellerCalendarRouter sellerCalendarRouter);

        @NotNull
        Builder sellerBaseCalendarParametersDependencies(@NotNull StrSellerCalendarParametersDependencies strSellerCalendarParametersDependencies);

        @BindsInstance
        @NotNull
        Builder startDate(@StartDate @Nullable Date date);

        @BindsInstance
        @NotNull
        Builder viewModelFragment(@NotNull Fragment fragment);
    }

    void inject(@NotNull SellerCalendarParametersFragment sellerCalendarParametersFragment);
}
