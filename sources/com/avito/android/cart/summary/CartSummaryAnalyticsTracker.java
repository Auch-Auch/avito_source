package com.avito.android.cart.summary;

import a2.b.a.a.a;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.Event;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.SimpleClickStreamEvent;
import com.avito.android.cart.analytics.summary.CartItemDeletionEvent;
import com.avito.android.cart.analytics.summary.CartStepperUsageEvent;
import com.avito.android.cart.analytics.summary.CartSummaryOpenedEvent;
import com.avito.android.cart.analytics.summary.CartSummarySubmitClickedEvent;
import com.avito.android.cart.analytics.summary.EmptyCartButtonClickedEvent;
import com.avito.android.cart.analytics.summary.StepperUsageType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.cart.model.Action;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002¢\u0006\u0004\b\u0012\u0010\u0007J\r\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;", "", "", "Lcom/avito/android/remote/cart/model/Action$LogEvent;", "events", "", "trackEvents", "(Ljava/util/List;)V", "", "xHash", "Lcom/avito/android/cart/summary/ItemQuantity;", "cartItems", "trackScreenOpened", "(Ljava/lang/String;Ljava/util/List;)V", "itemId", "source", "trackItemDeleted", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "trackSubmitClicked", "trackEmptyCartButtonClicked", "()V", "", "quantityAfterUsage", "Lcom/avito/android/cart/analytics/summary/StepperUsageType;", "usageType", "trackStepperUsage", "(Ljava/lang/String;ILcom/avito/android/cart/analytics/summary/StepperUsageType;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public class CartSummaryAnalyticsTracker {
    public final Analytics a;

    @Inject
    public CartSummaryAnalyticsTracker(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    public final void trackEmptyCartButtonClicked() {
        this.a.track(new EmptyCartButtonClickedEvent());
    }

    public final void trackEvents(@NotNull List<Action.LogEvent> list) {
        Event event;
        Intrinsics.checkNotNullParameter(list, "events");
        for (Action.LogEvent logEvent : list) {
            Map<String, String> params = logEvent.getParams();
            if (params == null || params.isEmpty()) {
                event = new SimpleClickStreamEvent(logEvent.getId(), logEvent.getVersion());
            } else {
                event = new ParametrizedClickStreamEvent(logEvent.getId(), logEvent.getVersion(), params, null, 8, null);
            }
            this.a.track(event);
        }
    }

    public final void trackItemDeleted(@NotNull String str, @NotNull List<ItemQuantity> list, @NotNull String str2) {
        a.d1(str, "itemId", list, "cartItems", str2, "source");
        this.a.track(new CartItemDeletionEvent(str2, str, list));
    }

    public final void trackScreenOpened(@Nullable String str, @NotNull List<ItemQuantity> list) {
        Intrinsics.checkNotNullParameter(list, "cartItems");
        this.a.track(new CartSummaryOpenedEvent(str, list));
    }

    public final void trackStepperUsage(@NotNull String str, int i, @NotNull StepperUsageType stepperUsageType) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(stepperUsageType, "usageType");
        this.a.track(new CartStepperUsageEvent(str, i, stepperUsageType, null, 8, null));
    }

    public final void trackSubmitClicked(@NotNull List<ItemQuantity> list) {
        Intrinsics.checkNotNullParameter(list, "cartItems");
        this.a.track(new CartSummarySubmitClickedEvent(list));
    }
}
