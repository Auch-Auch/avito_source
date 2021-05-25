package com.avito.android.booking.di;

import com.avito.android.booking.di.module.BookingInfoModule;
import com.avito.android.booking.di.qualifier.FromBlock;
import com.avito.android.booking.di.qualifier.ItemId;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.booking.info.BookingInfoFragment;
import com.avito.android.di.PerFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/booking/di/BookingInfoComponent;", "", "Lcom/avito/android/booking/info/BookingInfoFragment;", "fragment", "", "inject", "(Lcom/avito/android/booking/info/BookingInfoFragment;)V", "Builder", "booking_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {BookingInfoDependencies.class}, modules = {BookingInfoModule.class})
@PerFragment
public interface BookingInfoComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\u0005H'¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/booking/di/BookingInfoComponent$Builder;", "", "Lcom/avito/android/booking/di/BookingInfoDependencies;", "dependencies", "(Lcom/avito/android/booking/di/BookingInfoDependencies;)Lcom/avito/android/booking/di/BookingInfoComponent$Builder;", "", "itemId", "withItemId", "(Ljava/lang/String;)Lcom/avito/android/booking/di/BookingInfoComponent$Builder;", BookingInfoActivity.EXTRA_FROM_BLOCK, "withFromBlock", "Lcom/avito/android/booking/di/BookingInfoComponent;", "build", "()Lcom/avito/android/booking/di/BookingInfoComponent;", "booking_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        BookingInfoComponent build();

        @NotNull
        Builder dependencies(@NotNull BookingInfoDependencies bookingInfoDependencies);

        @BindsInstance
        @NotNull
        Builder withFromBlock(@FromBlock @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withItemId(@ItemId @NotNull String str);
    }

    void inject(@NotNull BookingInfoFragment bookingInfoFragment);
}
