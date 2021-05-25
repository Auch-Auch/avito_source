package a2.a.a.v2.a;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.RequestPayUrlResponse;
import com.avito.android.short_term_rent.analytics.StrAnalyticsTracker;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModelImpl;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class n<T> implements Consumer<LoadingState<? super RequestPayUrlResponse>> {
    public final /* synthetic */ StrConfirmBookingViewModelImpl a;

    public n(StrConfirmBookingViewModelImpl strConfirmBookingViewModelImpl) {
        this.a = strConfirmBookingViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super RequestPayUrlResponse> loadingState) {
        LoadingState<? super RequestPayUrlResponse> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            StrConfirmBookingViewModelImpl.access$showProgress(this.a);
        } else if (loadingState2 instanceof LoadingState.Error) {
            StrConfirmBookingViewModelImpl.access$onError(this.a, ((LoadingState.Error) loadingState2).getError());
            StrConfirmBookingViewModelImpl.access$showContent(this.a);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
            if (((RequestPayUrlResponse) loaded.getData()).getPaymentUrl() == null || ((RequestPayUrlResponse) loaded.getData()).getOrderId() == null) {
                DeepLink redirect = ((RequestPayUrlResponse) loaded.getData()).getRedirect();
                if (redirect != null) {
                    this.a.getDeepLinkChanges().setValue(redirect);
                    return;
                }
                return;
            }
            SingleLiveEvent<String> payUrlChanges = this.a.getPayUrlChanges();
            String paymentUrl = ((RequestPayUrlResponse) loaded.getData()).getPaymentUrl();
            Intrinsics.checkNotNull(paymentUrl);
            payUrlChanges.setValue(paymentUrl);
            StrAnalyticsTracker strAnalyticsTracker = this.a.A;
            String orderId = ((RequestPayUrlResponse) loaded.getData()).getOrderId();
            Intrinsics.checkNotNull(orderId);
            strAnalyticsTracker.trackBookingCreateEvent(orderId);
        }
    }
}
