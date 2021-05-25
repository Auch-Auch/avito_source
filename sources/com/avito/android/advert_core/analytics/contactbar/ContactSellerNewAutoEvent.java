package com.avito.android.advert_core.analytics.contactbar;

import com.avito.android.analytics_adjust.AdjustEvent;
import com.avito.android.analytics_adjust.AdjustEventTracker;
import com.avito.android.analytics_adjust.utils.AdjustContentType;
import com.avito.android.analytics_adjust.utils.AdjustEventsKt;
import com.avito.android.analytics_firebase.FirebaseEvent;
import com.avito.android.analytics_firebase.FirebaseEventTracker;
import com.avito.android.analytics_firebase.FirebaseKt;
import com.avito.android.analytics_firebase.SimpleFirebaseEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0006\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/advert_core/analytics/contactbar/ContactSellerNewAutoEvent;", "Lcom/avito/android/analytics_adjust/AdjustEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "getName", "()Ljava/lang/String;", "name", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Double;", "customerValue", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "", "", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "c", "Ljava/util/Map;", "params", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/util/Map;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ContactSellerNewAutoEvent implements AdjustEvent, FirebaseEvent {
    public final String a;
    public final Double b;
    public final Map<String, String> c;
    public final /* synthetic */ SimpleFirebaseEvent d;

    public ContactSellerNewAutoEvent(@NotNull String str, @Nullable Double d2, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.d = new SimpleFirebaseEvent(ContactSellerNewAutoEventKt.a.getFirebaseName(), FirebaseKt.withCustomerValue(map, d2));
        this.a = str;
        this.b = d2;
        this.c = map;
    }

    @Override // com.avito.android.analytics_adjust.AdjustEvent
    public void accept(@NotNull AdjustEventTracker adjustEventTracker) {
        Intrinsics.checkNotNullParameter(adjustEventTracker, "tracker");
        com.adjust.sdk.AdjustEvent withParams = AdjustEventsKt.withParams(AdjustEventsKt.withCustomerValue(AdjustEventsKt.withContentIds(AdjustEventsKt.withContentType(new com.adjust.sdk.AdjustEvent(ContactSellerNewAutoEventKt.a.getAdjustToken()), AdjustContentType.PRODUCT), this.a), this.b), this.c);
        AdjustEventTracker.DefaultImpls.injectCriteoTransactionConfirmed$default(adjustEventTracker, withParams, this.a, 0.0f, 0, null, null, 60, null);
        adjustEventTracker.trackEvent(withParams);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
        this.d.accept(firebaseEventTracker);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @Nullable
    public Map<String, Object> getFirebaseEventParams() {
        return this.d.getFirebaseEventParams();
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @NotNull
    public String getName() {
        return this.d.getName();
    }
}
