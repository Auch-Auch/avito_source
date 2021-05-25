package com.avito.android.safedeal.delivery_courier.order_update;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.Event;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.delivery_courier.analytics.ConfirmCourierOrderUpdateByBuyerEvent;
import com.avito.android.safedeal.delivery_courier.analytics.ConfirmCourierOrderUpdateBySellerEvent;
import com.avito.android.safedeal.delivery_courier.analytics.OpenCourierOrderUpdateScreenByBuyerEvent;
import com.avito.android.safedeal.delivery_courier.analytics.OpenCourierOrderUpdateScreenBySellerEvent;
import com.avito.android.util.Logs;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J/\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTrackerImpl;", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;", "", "trackLoadFormFailed", "()V", "trackRequiredFieldChangeError", "trackSubmitError", "trackSelectTimeIntervalError", "trackSelectDeepLinkError", "", "source", SDKConstants.PARAM_USER_ID, "advertID", "orderID", "trackScreenOpened", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "trackSubmitButtonClicked", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierOrderUpdateAnalyticsTrackerImpl implements DeliveryCourierOrderUpdateAnalyticsTracker {
    public final Analytics a;

    @Inject
    public DeliveryCourierOrderUpdateAnalyticsTrackerImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateAnalyticsTracker
    public void trackLoadFormFailed() {
        this.a.track(new StatsdEvent.CountEvent("delivery-courier..order_update.load.error", 0, 2, null));
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateAnalyticsTracker
    public void trackRequiredFieldChangeError() {
        this.a.track(new StatsdEvent.CountEvent("delivery-courier..order_update.required_field_change.error", 0, 2, null));
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateAnalyticsTracker
    public void trackScreenOpened(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Event event;
        Intrinsics.checkNotNullParameter(str, "source");
        Intrinsics.checkNotNullParameter(str2, SDKConstants.PARAM_USER_ID);
        Intrinsics.checkNotNullParameter(str3, "advertID");
        Intrinsics.checkNotNullParameter(str4, "orderID");
        int hashCode = str.hashCode();
        if (hashCode != -906014849) {
            if (hashCode == 94110131 && str.equals("buyer")) {
                event = new OpenCourierOrderUpdateScreenByBuyerEvent(str2, str3, str4);
            }
            Logs.error$default("Illegal source while tracking analytic event", null, 2, null);
            return;
        }
        if (str.equals("seller")) {
            event = new OpenCourierOrderUpdateScreenBySellerEvent(str2, str3, str4);
        }
        Logs.error$default("Illegal source while tracking analytic event", null, 2, null);
        return;
        this.a.track(event);
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateAnalyticsTracker
    public void trackSelectDeepLinkError() {
        this.a.track(new StatsdEvent.CountEvent("delivery-courier..order_update.select_deep_link.error", 0, 2, null));
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateAnalyticsTracker
    public void trackSelectTimeIntervalError() {
        this.a.track(new StatsdEvent.CountEvent("delivery-courier..order_update.select_time_interval.error", 0, 2, null));
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateAnalyticsTracker
    public void trackSubmitButtonClicked(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Event event;
        Intrinsics.checkNotNullParameter(str, "source");
        Intrinsics.checkNotNullParameter(str2, SDKConstants.PARAM_USER_ID);
        Intrinsics.checkNotNullParameter(str3, "advertID");
        Intrinsics.checkNotNullParameter(str4, "orderID");
        int hashCode = str.hashCode();
        if (hashCode != -906014849) {
            if (hashCode == 94110131 && str.equals("buyer")) {
                event = new ConfirmCourierOrderUpdateByBuyerEvent(str2, str3, str4);
            }
            Logs.error$default("Illegal source while tracking analytic event", null, 2, null);
            return;
        }
        if (str.equals("seller")) {
            event = new ConfirmCourierOrderUpdateBySellerEvent(str2, str3, str4);
        }
        Logs.error$default("Illegal source while tracking analytic event", null, 2, null);
        return;
        this.a.track(event);
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateAnalyticsTracker
    public void trackSubmitError() {
        this.a.track(new StatsdEvent.CountEvent("delivery-courier..order_update.submit.error", 0, 2, null));
    }
}
