package com.avito.android.analytics_adjust;

import android.net.Uri;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.criteo.AdjustCriteo;
import com.adjust.sdk.criteo.CriteoProduct;
import com.avito.android.util.Logs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0013H\u0016¢\u0006\u0004\b\u001f\u0010\u0016¨\u0006\""}, d2 = {"Lcom/avito/android/analytics_adjust/CriteoImpl;", "Lcom/avito/android/analytics_adjust/Criteo;", "Lcom/avito/android/analytics_adjust/HashedEmail;", "hashedEmail", "", "injectHashedEmail", "(Lcom/avito/android/analytics_adjust/HashedEmail;)V", "Lcom/adjust/sdk/AdjustEvent;", "event", "", "productId", "", "price", "", FirebaseAnalytics.Param.QUANTITY, "transactionId", "newCustomer", "injectTransactionConfirmed", "(Lcom/adjust/sdk/AdjustEvent;Ljava/lang/String;FILjava/lang/String;Ljava/lang/String;)V", "", "productIds", "injectViewListing", "(Lcom/adjust/sdk/AdjustEvent;Ljava/util/List;)V", "injectViewProduct", "(Lcom/adjust/sdk/AdjustEvent;Ljava/lang/String;)V", "Landroid/net/Uri;", "url", "injectAppDeeplink", "(Lcom/adjust/sdk/AdjustEvent;Landroid/net/Uri;)V", "Lcom/adjust/sdk/criteo/CriteoProduct;", "products", "injectViewBasket", "<init>", "()V", "analytics-adjust_release"}, k = 1, mv = {1, 4, 2})
public final class CriteoImpl implements Criteo {
    @Override // com.avito.android.analytics_adjust.Criteo
    public void injectAppDeeplink(@NotNull AdjustEvent adjustEvent, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        Intrinsics.checkNotNullParameter(uri, "url");
        Logs.info$default("Criteo", "injectAppDeeplink: " + uri, null, 4, null);
        AdjustCriteo.injectDeeplinkIntoEvent(adjustEvent, uri);
    }

    @Override // com.avito.android.analytics_adjust.Criteo
    public void injectHashedEmail(@NotNull HashedEmail hashedEmail) {
        Intrinsics.checkNotNullParameter(hashedEmail, "hashedEmail");
        Logs.info$default("Criteo", "injectHashedEmail: " + hashedEmail.getValue(), null, 4, null);
        AdjustCriteo.injectHashedEmailIntoCriteoEvents(hashedEmail.getValue());
    }

    @Override // com.avito.android.analytics_adjust.Criteo
    public void injectTransactionConfirmed(@NotNull AdjustEvent adjustEvent, @NotNull String str, float f, int i, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(str2, "transactionId");
        Intrinsics.checkNotNullParameter(str3, "newCustomer");
        Logs.info$default("Criteo", "injectTransactionConfirmed: " + str, null, 4, null);
        AdjustCriteo.injectTransactionConfirmedIntoEvent(adjustEvent, d.listOf(new CriteoProduct(f, i, str)), str2, str3);
    }

    @Override // com.avito.android.analytics_adjust.Criteo
    public void injectViewBasket(@NotNull AdjustEvent adjustEvent, @NotNull List<? extends CriteoProduct> list) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        Intrinsics.checkNotNullParameter(list, "products");
        Logs.info$default("Criteo", "injectViewBasket: " + list, null, 4, null);
        AdjustCriteo.injectCartIntoEvent(adjustEvent, list);
    }

    @Override // com.avito.android.analytics_adjust.Criteo
    public void injectViewListing(@NotNull AdjustEvent adjustEvent, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        Intrinsics.checkNotNullParameter(list, "productIds");
        Logs.info$default("Criteo", "injectViewListing: " + list, null, 4, null);
        AdjustCriteo.injectViewListingIntoEvent(adjustEvent, list);
    }

    @Override // com.avito.android.analytics_adjust.Criteo
    public void injectViewProduct(@NotNull AdjustEvent adjustEvent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        Intrinsics.checkNotNullParameter(str, "productId");
        Logs.info$default("Criteo", "injectViewProduct: " + str, null, 4, null);
        AdjustCriteo.injectViewProductIntoEvent(adjustEvent, str);
    }
}
