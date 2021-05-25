package com.avito.android.booking.info;

import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.Event;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bR\"\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR \u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/booking/info/BookingInfoViewModel;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "", "onButtonClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onRetryClicked", "()V", "onBackClicked", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/util/LoadingState;", "getStateChanges", "()Landroidx/lifecycle/LiveData;", "stateChanges", "Lcom/avito/android/util/architecture_components/Event;", "getRoutingEvents", "routingEvents", "Lcom/avito/android/booking/info/ActionButtonState;", "getActionButtonState", "actionButtonState", "booking_release"}, k = 1, mv = {1, 4, 2})
public interface BookingInfoViewModel {
    @NotNull
    LiveData<ActionButtonState> getActionButtonState();

    @NotNull
    LiveData<Event<?>> getRoutingEvents();

    @NotNull
    LiveData<LoadingState<Unit>> getStateChanges();

    void onBackClicked();

    void onButtonClicked(@Nullable DeepLink deepLink);

    void onRetryClicked();
}
