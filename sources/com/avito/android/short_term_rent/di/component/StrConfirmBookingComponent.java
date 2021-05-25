package com.avito.android.short_term_rent.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingFragment;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingModule;
import com.avito.android.short_term_rent.di.qualifier.AdvertId;
import com.avito.android.short_term_rent.di.qualifier.CheckInDate;
import com.avito.android.short_term_rent.di.qualifier.CheckOutDate;
import com.avito.android.short_term_rent.di.qualifier.Workflow;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/short_term_rent/di/component/StrConfirmBookingComponent;", "", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingFragment;", "fragment", "", "inject", "(Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingFragment;)V", "Builder", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {StrBookingCommonDependencies.class}, modules = {StrConfirmBookingModule.class})
@PerFragment
public interface StrConfirmBookingComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\tH'¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\tH'¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00002\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/short_term_rent/di/component/StrConfirmBookingComponent$Builder;", "", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/short_term_rent/di/component/StrConfirmBookingComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "viewModelFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/short_term_rent/di/component/StrConfirmBookingComponent$Builder;", "", BookingInfoActivity.EXTRA_ITEM_ID, "(Ljava/lang/String;)Lcom/avito/android/short_term_rent/di/component/StrConfirmBookingComponent$Builder;", "checkInDate", "checkOutDate", "", "guestsCount", "(I)Lcom/avito/android/short_term_rent/di/component/StrConfirmBookingComponent$Builder;", "workflow", "Lcom/avito/android/short_term_rent/di/component/StrBookingCommonDependencies;", "dependencies", "confirmBookingDependencies", "(Lcom/avito/android/short_term_rent/di/component/StrBookingCommonDependencies;)Lcom/avito/android/short_term_rent/di/component/StrConfirmBookingComponent$Builder;", "Lcom/avito/android/short_term_rent/di/component/StrConfirmBookingComponent;", "build", "()Lcom/avito/android/short_term_rent/di/component/StrConfirmBookingComponent;", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder advertId(@AdvertId @NotNull String str);

        @NotNull
        StrConfirmBookingComponent build();

        @BindsInstance
        @NotNull
        Builder checkInDate(@CheckInDate @NotNull String str);

        @BindsInstance
        @NotNull
        Builder checkOutDate(@CheckOutDate @NotNull String str);

        @NotNull
        Builder confirmBookingDependencies(@NotNull StrBookingCommonDependencies strBookingCommonDependencies);

        @BindsInstance
        @NotNull
        Builder guestsCount(@StrConfirmBookingModule.GuestsCount int i);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder viewModelFragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder workflow(@Workflow @Nullable String str);
    }

    void inject(@NotNull StrConfirmBookingFragment strConfirmBookingFragment);
}
