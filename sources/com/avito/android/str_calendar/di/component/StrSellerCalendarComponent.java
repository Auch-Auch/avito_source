package com.avito.android.str_calendar.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.str_calendar.di.module.StrSellerCalendarModule;
import com.avito.android.str_calendar.di.qualifier.AdvertId;
import com.avito.android.str_calendar.seller.SellerCalendarRouter;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/str_calendar/di/component/StrSellerCalendarComponent;", "", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarFragment;", "fragment", "", "inject", "(Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarFragment;)V", "Builder", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {StrSellerCalendarDependencies.class}, modules = {StrSellerCalendarModule.class})
@PerFragment
public interface StrSellerCalendarComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/str_calendar/di/component/StrSellerCalendarComponent$Builder;", "", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/str_calendar/di/component/StrSellerCalendarComponent$Builder;", "", BookingInfoActivity.EXTRA_ITEM_ID, "(Ljava/lang/String;)Lcom/avito/android/str_calendar/di/component/StrSellerCalendarComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "viewModelFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/str_calendar/di/component/StrSellerCalendarComponent$Builder;", "Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;", "router", "(Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;)Lcom/avito/android/str_calendar/di/component/StrSellerCalendarComponent$Builder;", "Lcom/avito/android/str_calendar/di/component/StrSellerCalendarDependencies;", "dependencies", "sellerCalendarDependencies", "(Lcom/avito/android/str_calendar/di/component/StrSellerCalendarDependencies;)Lcom/avito/android/str_calendar/di/component/StrSellerCalendarComponent$Builder;", "Lcom/avito/android/str_calendar/di/component/StrSellerCalendarComponent;", "build", "()Lcom/avito/android/str_calendar/di/component/StrSellerCalendarComponent;", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder advertId(@AdvertId @NotNull String str);

        @NotNull
        StrSellerCalendarComponent build();

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder router(@NotNull SellerCalendarRouter sellerCalendarRouter);

        @NotNull
        Builder sellerCalendarDependencies(@NotNull StrSellerCalendarDependencies strSellerCalendarDependencies);

        @BindsInstance
        @NotNull
        Builder viewModelFragment(@NotNull Fragment fragment);
    }

    void inject(@NotNull SellerCalendarFragment sellerCalendarFragment);
}
