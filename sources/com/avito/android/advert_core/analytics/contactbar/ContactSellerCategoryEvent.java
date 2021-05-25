package com.avito.android.advert_core.analytics.contactbar;

import com.avito.android.analytics_adjust.AdjustEvent;
import com.avito.android.analytics_adjust.AdjustEventTracker;
import com.avito.android.analytics_adjust.AdjustTokenWithFirebaseName;
import com.avito.android.analytics_adjust.utils.AdjustContentType;
import com.avito.android.analytics_adjust.utils.AdjustEventsKt;
import com.avito.android.analytics_firebase.FirebaseEvent;
import com.avito.android.analytics_firebase.FirebaseEventTracker;
import com.avito.android.analytics_firebase.FirebaseKt;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CategoryIds;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\b\u0010#\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u001cR(\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001e0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/avito/android/advert_core/analytics/contactbar/ContactSellerCategoryEvent;", "Lcom/avito/android/analytics_adjust/AdjustEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "d", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/analytics_adjust/AdjustTokenWithFirebaseName;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics_adjust/AdjustTokenWithFirebaseName;", "adjustTokenWithFirebaseName", "", "f", "Ljava/util/Map;", "params", "", "e", "Ljava/lang/Double;", "customerValue", AuthSource.BOOKING_ORDER, "getName", "()Ljava/lang/String;", "name", "", "c", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "categoryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/Map;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ContactSellerCategoryEvent implements AdjustEvent, FirebaseEvent {
    public final AdjustTokenWithFirebaseName a;
    @NotNull
    public final String b;
    @NotNull
    public final Map<String, Object> c;
    public final String d;
    public final Double e;
    public final Map<String, String> f;

    public ContactSellerCategoryEvent(@Nullable String str, @NotNull String str2, @Nullable Double d2, @Nullable Map<String, String> map) {
        AdjustTokenWithFirebaseName adjustTokenWithFirebaseName;
        String str3;
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        this.d = str2;
        this.e = d2;
        this.f = map;
        if (Intrinsics.areEqual(str, CategoryIds.AUTO.SPAREPARTS.getId())) {
            adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.CONTACT_SELLER_SPAREPARTS;
        } else if (Intrinsics.areEqual(str, CategoryIds.AUTO.CARS.getId())) {
            adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.CONTACT_SELLER_TRANSPORT_CARS;
        } else if (!Intrinsics.areEqual(str, CategoryIds.AUTO.MOTO.getId()) && !Intrinsics.areEqual(str, CategoryIds.AUTO.WATER.getId())) {
            adjustTokenWithFirebaseName = Intrinsics.areEqual(str, CategoryIds.AUTO.TRUCKS.getId()) ? AdjustTokenWithFirebaseName.CONTACT_SELLER_TRANSPORT_TRUCKS : null;
        } else {
            adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.CONTACT_SELLER_TRANSPORT_MOTOWATER;
        }
        this.a = adjustTokenWithFirebaseName;
        this.b = (adjustTokenWithFirebaseName == null || (str3 = adjustTokenWithFirebaseName.getFirebaseName()) == null) ? "" : str3;
        this.c = FirebaseKt.withCustomerValue(map, d2);
    }

    @Override // com.avito.android.analytics_adjust.AdjustEvent
    public void accept(@NotNull AdjustEventTracker adjustEventTracker) {
        Intrinsics.checkNotNullParameter(adjustEventTracker, "tracker");
        if (this.a != null) {
            adjustEventTracker.trackEvent(AdjustEventsKt.withParams(AdjustEventsKt.withCustomerValue(AdjustEventsKt.withContentIds(AdjustEventsKt.withContentType(new com.adjust.sdk.AdjustEvent(this.a.getAdjustToken()), AdjustContentType.PRODUCT), this.d), this.e), this.f));
        }
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @NotNull
    public Map<String, Object> getFirebaseEventParams() {
        return this.c;
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @NotNull
    public String getName() {
        return this.b;
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
        if (this.a != null) {
            firebaseEventTracker.trackEvent(this);
        }
    }
}
