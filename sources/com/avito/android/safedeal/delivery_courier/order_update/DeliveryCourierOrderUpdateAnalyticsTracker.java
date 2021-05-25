package com.avito.android.safedeal.delivery_courier.order_update;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J/\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;", "", "", "trackLoadFormFailed", "()V", "trackRequiredFieldChangeError", "trackSubmitError", "trackSelectTimeIntervalError", "trackSelectDeepLinkError", "", "source", SDKConstants.PARAM_USER_ID, "advertID", "orderID", "trackScreenOpened", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "trackSubmitButtonClicked", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryCourierOrderUpdateAnalyticsTracker {
    void trackLoadFormFailed();

    void trackRequiredFieldChangeError();

    void trackScreenOpened(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    void trackSelectDeepLinkError();

    void trackSelectTimeIntervalError();

    void trackSubmitButtonClicked(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    void trackSubmitError();
}
