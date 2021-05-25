package com.avito.android.booking.di;

import android.content.res.Resources;
import com.avito.android.booking.di.module.BookingOrderModule;
import com.avito.android.booking.di.qualifier.ItemId;
import com.avito.android.booking.order.BookingOrderFragment;
import com.avito.android.di.PerFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/booking/di/BookingOrderComponent;", "", "Lcom/avito/android/booking/order/BookingOrderFragment;", "fragment", "", "inject", "(Lcom/avito/android/booking/order/BookingOrderFragment;)V", "Builder", "booking_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {BookingOrderDependencies.class}, modules = {BookingOrderModule.class})
@PerFragment
public interface BookingOrderComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0004\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/booking/di/BookingOrderComponent$Builder;", "", "", "itemId", "withItemId", "(Ljava/lang/String;)Lcom/avito/android/booking/di/BookingOrderComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/booking/di/BookingOrderComponent$Builder;", "Lcom/avito/android/booking/di/BookingOrderDependencies;", "dependencies", "(Lcom/avito/android/booking/di/BookingOrderDependencies;)Lcom/avito/android/booking/di/BookingOrderComponent$Builder;", "Lcom/avito/android/booking/di/BookingOrderComponent;", "build", "()Lcom/avito/android/booking/di/BookingOrderComponent;", "booking_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        BookingOrderComponent build();

        @NotNull
        Builder dependencies(@NotNull BookingOrderDependencies bookingOrderDependencies);

        @BindsInstance
        @NotNull
        Builder withItemId(@ItemId @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);
    }

    void inject(@NotNull BookingOrderFragment bookingOrderFragment);
}
