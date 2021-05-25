package com.avito.android.analytics_adjust;

import android.net.Uri;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.criteo.CriteoProduct;
import com.adjust.sdk.sig.BuildConfig;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Initializable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b4\u00105J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J%\u0010$\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0018H\u0016¢\u0006\u0004\b$\u0010\u001bJ\"\u0010'\u001a\u00020\u00052\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010%H\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)H\u0001¢\u0006\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/avito/android/analytics_adjust/AdjustEventTrackerImpl;", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "Lcom/avito/android/util/Initializable;", "Lcom/adjust/sdk/AdjustEvent;", "event", "", "trackEvent", "(Lcom/adjust/sdk/AdjustEvent;)V", "trackOnPause", "()V", "trackOnResume", "", "email", "injectCriteoEmail", "(Ljava/lang/String;)V", "productId", "", "price", "", FirebaseAnalytics.Param.QUANTITY, "transactionId", "newCustomer", "injectCriteoTransactionConfirmed", "(Lcom/adjust/sdk/AdjustEvent;Ljava/lang/String;FILjava/lang/String;Ljava/lang/String;)V", "", "productIds", "injectCriteoViewListing", "(Lcom/adjust/sdk/AdjustEvent;Ljava/util/List;)V", "injectCriteoViewProduct", "(Lcom/adjust/sdk/AdjustEvent;Ljava/lang/String;)V", "Landroid/net/Uri;", "url", "injectCriteoAppDeeplink", "(Lcom/adjust/sdk/AdjustEvent;Landroid/net/Uri;)V", "Lcom/adjust/sdk/criteo/CriteoProduct;", "products", "injectCriteoViewBasket", "Lkotlin/Function0;", "onInitialized", "initialize", "(Lkotlin/jvm/functions/Function0;)V", "", "isInitialized", "()Z", "Lcom/avito/android/analytics_adjust/Criteo;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics_adjust/Criteo;", "criteo", "Lcom/avito/android/analytics_adjust/Adjust;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics_adjust/Adjust;", BuildConfig.FLAVOR, "<init>", "(Lcom/avito/android/analytics_adjust/Adjust;Lcom/avito/android/analytics_adjust/Criteo;)V", "analytics-adjust_release"}, k = 1, mv = {1, 4, 2})
public final class AdjustEventTrackerImpl implements AdjustEventTracker, Initializable {
    public final Adjust a;
    public final Criteo b;

    @Inject
    public AdjustEventTrackerImpl(@NotNull Adjust adjust, @NotNull Criteo criteo) {
        Intrinsics.checkNotNullParameter(adjust, BuildConfig.FLAVOR);
        Intrinsics.checkNotNullParameter(criteo, "criteo");
        this.a = adjust;
        this.b = criteo;
    }

    @Override // com.avito.android.util.Initializable
    public void initialize(@Nullable Function0<Unit> function0) {
        this.a.initialize(function0);
    }

    @Override // com.avito.android.analytics_adjust.AdjustEventTracker
    public void injectCriteoAppDeeplink(@NotNull AdjustEvent adjustEvent, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        Intrinsics.checkNotNullParameter(uri, "url");
        this.b.injectAppDeeplink(adjustEvent, uri);
    }

    @Override // com.avito.android.analytics_adjust.AdjustEventTracker
    public void injectCriteoEmail(@Nullable String str) {
        if (str != null) {
            this.b.injectHashedEmail(new HashedEmail(str));
        }
    }

    @Override // com.avito.android.analytics_adjust.AdjustEventTracker
    public void injectCriteoTransactionConfirmed(@NotNull AdjustEvent adjustEvent, @NotNull String str, float f, int i, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(str2, "transactionId");
        Intrinsics.checkNotNullParameter(str3, "newCustomer");
        this.b.injectTransactionConfirmed(adjustEvent, str, f, i, str2, str3);
    }

    @Override // com.avito.android.analytics_adjust.AdjustEventTracker
    public void injectCriteoViewBasket(@NotNull AdjustEvent adjustEvent, @NotNull List<? extends CriteoProduct> list) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        Intrinsics.checkNotNullParameter(list, "products");
        this.b.injectViewBasket(adjustEvent, list);
    }

    @Override // com.avito.android.analytics_adjust.AdjustEventTracker
    public void injectCriteoViewListing(@NotNull AdjustEvent adjustEvent, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        Intrinsics.checkNotNullParameter(list, "productIds");
        this.b.injectViewListing(adjustEvent, list);
    }

    @Override // com.avito.android.analytics_adjust.AdjustEventTracker
    public void injectCriteoViewProduct(@NotNull AdjustEvent adjustEvent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        Intrinsics.checkNotNullParameter(str, "productId");
        this.b.injectViewProduct(adjustEvent, str);
    }

    @Override // com.avito.android.util.Initializable
    public boolean isInitialized() {
        return this.a.isInitialized();
    }

    @Override // com.avito.android.analytics_adjust.AdjustEventTracker
    public void trackEvent(@NotNull AdjustEvent adjustEvent) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        this.a.trackEvent(adjustEvent);
    }

    @Override // com.avito.android.analytics_adjust.AdjustEventTracker
    public void trackOnPause() {
        this.a.onPause();
    }

    @Override // com.avito.android.analytics_adjust.AdjustEventTracker
    public void trackOnResume() {
        this.a.onResume();
    }
}
