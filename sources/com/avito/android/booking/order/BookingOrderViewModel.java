package com.avito.android.booking.order;

import android.text.TextWatcher;
import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.architecture_components.Event;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J!\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderViewModel;", "", "", "loadBookingData", "()V", "onNavigationButtonClicked", "onActionButtonClicked", "", "resultCode", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "resolvePaymentResult", "(ILcom/avito/android/deep_linking/links/DeepLink;)V", "Landroid/text/TextWatcher;", "getInputTextWatcher", "()Landroid/text/TextWatcher;", "inputTextWatcher", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/booking/order/BookingOrderScreenState;", "getScreenStateChanges", "()Landroidx/lifecycle/LiveData;", "screenStateChanges", "Lcom/avito/android/util/architecture_components/Event;", "getRoutingEvents", "routingEvents", "booking_release"}, k = 1, mv = {1, 4, 2})
public interface BookingOrderViewModel {
    @NotNull
    TextWatcher getInputTextWatcher();

    @NotNull
    LiveData<Event<?>> getRoutingEvents();

    @NotNull
    LiveData<BookingOrderScreenState> getScreenStateChanges();

    void loadBookingData();

    void onActionButtonClicked();

    void onNavigationButtonClicked();

    void resolvePaymentResult(int i, @Nullable DeepLink deepLink);
}
