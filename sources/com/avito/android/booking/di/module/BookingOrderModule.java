package com.avito.android.booking.di.module;

import com.avito.android.booking.order.BookingOrderInputValidator;
import com.avito.android.booking.order.BookingOrderInputValidatorImpl;
import com.avito.android.booking.order.BookingOrderInteractor;
import com.avito.android.booking.order.BookingOrderInteractorImpl;
import com.avito.android.booking.order.BookingOrderPresenter;
import com.avito.android.booking.order.BookingOrderPresenterImpl;
import com.avito.android.booking.order.BookingOrderResourceProvider;
import com.avito.android.booking.order.BookingOrderResourceProviderImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/booking/di/module/BookingOrderModule;", "", "Lcom/avito/android/util/text/AttributedTextFormatterImpl;", "formatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "bindAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatterImpl;)Lcom/avito/android/util/text/AttributedTextFormatter;", "Lcom/avito/android/booking/order/BookingOrderInteractorImpl;", "interactor", "Lcom/avito/android/booking/order/BookingOrderInteractor;", "bindBookingOrderInteractor", "(Lcom/avito/android/booking/order/BookingOrderInteractorImpl;)Lcom/avito/android/booking/order/BookingOrderInteractor;", "Lcom/avito/android/booking/order/BookingOrderPresenterImpl;", "presenter", "Lcom/avito/android/booking/order/BookingOrderPresenter;", "bindBookingOrderPresenter", "(Lcom/avito/android/booking/order/BookingOrderPresenterImpl;)Lcom/avito/android/booking/order/BookingOrderPresenter;", "Lcom/avito/android/booking/order/BookingOrderResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/booking/order/BookingOrderResourceProvider;", "bindBookingOrderResourceProvider", "(Lcom/avito/android/booking/order/BookingOrderResourceProviderImpl;)Lcom/avito/android/booking/order/BookingOrderResourceProvider;", "Lcom/avito/android/booking/order/BookingOrderInputValidatorImpl;", "validator", "Lcom/avito/android/booking/order/BookingOrderInputValidator;", "bindBookingOrderInputValidator", "(Lcom/avito/android/booking/order/BookingOrderInputValidatorImpl;)Lcom/avito/android/booking/order/BookingOrderInputValidator;", "booking_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface BookingOrderModule {
    @PerFragment
    @Binds
    @NotNull
    AttributedTextFormatter bindAttributedTextFormatter(@NotNull AttributedTextFormatterImpl attributedTextFormatterImpl);

    @PerFragment
    @Binds
    @NotNull
    BookingOrderInputValidator bindBookingOrderInputValidator(@NotNull BookingOrderInputValidatorImpl bookingOrderInputValidatorImpl);

    @PerFragment
    @Binds
    @NotNull
    BookingOrderInteractor bindBookingOrderInteractor(@NotNull BookingOrderInteractorImpl bookingOrderInteractorImpl);

    @PerFragment
    @Binds
    @NotNull
    BookingOrderPresenter bindBookingOrderPresenter(@NotNull BookingOrderPresenterImpl bookingOrderPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    BookingOrderResourceProvider bindBookingOrderResourceProvider(@NotNull BookingOrderResourceProviderImpl bookingOrderResourceProviderImpl);
}
