package com.avito.android.analytics_adjust;

import a2.b.a.a.a;
import android.net.Uri;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.criteo.CriteoProduct;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006JG\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\tH&¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0013H&¢\u0006\u0004\b\u001f\u0010\u0016¨\u0006 "}, d2 = {"Lcom/avito/android/analytics_adjust/Criteo;", "", "Lcom/avito/android/analytics_adjust/HashedEmail;", "hashedEmail", "", "injectHashedEmail", "(Lcom/avito/android/analytics_adjust/HashedEmail;)V", "Lcom/adjust/sdk/AdjustEvent;", "event", "", "productId", "", "price", "", FirebaseAnalytics.Param.QUANTITY, "transactionId", "newCustomer", "injectTransactionConfirmed", "(Lcom/adjust/sdk/AdjustEvent;Ljava/lang/String;FILjava/lang/String;Ljava/lang/String;)V", "", "productIds", "injectViewListing", "(Lcom/adjust/sdk/AdjustEvent;Ljava/util/List;)V", "injectViewProduct", "(Lcom/adjust/sdk/AdjustEvent;Ljava/lang/String;)V", "Landroid/net/Uri;", "url", "injectAppDeeplink", "(Lcom/adjust/sdk/AdjustEvent;Landroid/net/Uri;)V", "Lcom/adjust/sdk/criteo/CriteoProduct;", "products", "injectViewBasket", "analytics-adjust_release"}, k = 1, mv = {1, 4, 2})
public interface Criteo {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void injectTransactionConfirmed$default(Criteo criteo, AdjustEvent adjustEvent, String str, float f, int i, String str2, String str3, int i2, Object obj) {
            if (obj == null) {
                float f2 = (i2 & 4) != 0 ? 1.0f : f;
                int i3 = (i2 & 8) != 0 ? 1 : i;
                if ((i2 & 16) != 0) {
                    str2 = a.I2("UUID.randomUUID().toString()");
                }
                if ((i2 & 32) != 0) {
                    str3 = "1";
                }
                criteo.injectTransactionConfirmed(adjustEvent, str, f2, i3, str2, str3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: injectTransactionConfirmed");
        }
    }

    void injectAppDeeplink(@NotNull AdjustEvent adjustEvent, @NotNull Uri uri);

    void injectHashedEmail(@NotNull HashedEmail hashedEmail);

    void injectTransactionConfirmed(@NotNull AdjustEvent adjustEvent, @NotNull String str, float f, int i, @NotNull String str2, @NotNull String str3);

    void injectViewBasket(@NotNull AdjustEvent adjustEvent, @NotNull List<? extends CriteoProduct> list);

    void injectViewListing(@NotNull AdjustEvent adjustEvent, @NotNull List<String> list);

    void injectViewProduct(@NotNull AdjustEvent adjustEvent, @NotNull String str);
}
