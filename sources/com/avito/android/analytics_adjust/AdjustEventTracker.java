package com.avito.android.analytics_adjust;

import a2.b.a.a.a;
import android.net.Uri;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.criteo.CriteoProduct;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJG\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\nH&¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001f\u0010 J%\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0017H&¢\u0006\u0004\b#\u0010\u001a¨\u0006$"}, d2 = {"Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "", "Lcom/adjust/sdk/AdjustEvent;", "event", "", "trackEvent", "(Lcom/adjust/sdk/AdjustEvent;)V", "trackOnPause", "()V", "trackOnResume", "", "email", "injectCriteoEmail", "(Ljava/lang/String;)V", "productId", "", "price", "", FirebaseAnalytics.Param.QUANTITY, "transactionId", "newCustomer", "injectCriteoTransactionConfirmed", "(Lcom/adjust/sdk/AdjustEvent;Ljava/lang/String;FILjava/lang/String;Ljava/lang/String;)V", "", "productIds", "injectCriteoViewListing", "(Lcom/adjust/sdk/AdjustEvent;Ljava/util/List;)V", "injectCriteoViewProduct", "(Lcom/adjust/sdk/AdjustEvent;Ljava/lang/String;)V", "Landroid/net/Uri;", "url", "injectCriteoAppDeeplink", "(Lcom/adjust/sdk/AdjustEvent;Landroid/net/Uri;)V", "Lcom/adjust/sdk/criteo/CriteoProduct;", "products", "injectCriteoViewBasket", "analytics-adjust_release"}, k = 1, mv = {1, 4, 2})
public interface AdjustEventTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void injectCriteoTransactionConfirmed$default(AdjustEventTracker adjustEventTracker, AdjustEvent adjustEvent, String str, float f, int i, String str2, String str3, int i2, Object obj) {
            if (obj == null) {
                float f2 = (i2 & 4) != 0 ? 1.0f : f;
                int i3 = (i2 & 8) != 0 ? 1 : i;
                if ((i2 & 16) != 0) {
                    str2 = a.I2("UUID.randomUUID().toString()");
                }
                if ((i2 & 32) != 0) {
                    str3 = "1";
                }
                adjustEventTracker.injectCriteoTransactionConfirmed(adjustEvent, str, f2, i3, str2, str3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: injectCriteoTransactionConfirmed");
        }
    }

    void injectCriteoAppDeeplink(@NotNull AdjustEvent adjustEvent, @NotNull Uri uri);

    void injectCriteoEmail(@Nullable String str);

    void injectCriteoTransactionConfirmed(@NotNull AdjustEvent adjustEvent, @NotNull String str, float f, int i, @NotNull String str2, @NotNull String str3);

    void injectCriteoViewBasket(@NotNull AdjustEvent adjustEvent, @NotNull List<? extends CriteoProduct> list);

    void injectCriteoViewListing(@NotNull AdjustEvent adjustEvent, @NotNull List<String> list);

    void injectCriteoViewProduct(@NotNull AdjustEvent adjustEvent, @NotNull String str);

    void trackEvent(@NotNull AdjustEvent adjustEvent);

    void trackOnPause();

    void trackOnResume();
}
