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
import com.avito.android.remote.model.AdvertisementVerticalAlias;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010 \u001a\u00020\u000f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR(\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R$\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0012¨\u0006'"}, d2 = {"Lcom/avito/android/advert_core/analytics/contactbar/ContactSellerVerticalEvent;", "Lcom/avito/android/analytics_adjust/AdjustEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "Lcom/avito/android/analytics_adjust/AdjustTokenWithFirebaseName;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics_adjust/AdjustTokenWithFirebaseName;", "adjustTokenWithFirebaseName", "", "", "", "c", "Ljava/util/Map;", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "", "e", "Ljava/lang/Double;", "customerValue", "d", BookingInfoActivity.EXTRA_ITEM_ID, "f", "params", "Lcom/avito/android/remote/model/AdvertisementVerticalAlias;", "verticalAlias", "<init>", "(Lcom/avito/android/remote/model/AdvertisementVerticalAlias;Ljava/lang/String;Ljava/lang/Double;Ljava/util/Map;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ContactSellerVerticalEvent implements AdjustEvent, FirebaseEvent {
    public final AdjustTokenWithFirebaseName a;
    @NotNull
    public final String b;
    @NotNull
    public final Map<String, Object> c;
    public final String d;
    public final Double e;
    public final Map<String, String> f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AdvertisementVerticalAlias.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            AdvertisementVerticalAlias advertisementVerticalAlias = AdvertisementVerticalAlias.REALTY;
            iArr[0] = 1;
            AdvertisementVerticalAlias advertisementVerticalAlias2 = AdvertisementVerticalAlias.AUTO;
            iArr[1] = 2;
            AdvertisementVerticalAlias advertisementVerticalAlias3 = AdvertisementVerticalAlias.GENERAL;
            iArr[2] = 3;
            AdvertisementVerticalAlias advertisementVerticalAlias4 = AdvertisementVerticalAlias.JOB;
            iArr[3] = 4;
            AdvertisementVerticalAlias advertisementVerticalAlias5 = AdvertisementVerticalAlias.SERVICES;
            iArr[4] = 5;
            AdvertisementVerticalAlias advertisementVerticalAlias6 = AdvertisementVerticalAlias.NO_VALUE;
            iArr[5] = 6;
        }
    }

    public ContactSellerVerticalEvent(@NotNull AdvertisementVerticalAlias advertisementVerticalAlias, @NotNull String str, @Nullable Double d2, @Nullable Map<String, String> map) {
        AdjustTokenWithFirebaseName adjustTokenWithFirebaseName;
        String str2;
        Intrinsics.checkNotNullParameter(advertisementVerticalAlias, "verticalAlias");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.d = str;
        this.e = d2;
        this.f = map;
        int ordinal = advertisementVerticalAlias.ordinal();
        if (ordinal == 0) {
            adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.CONTACT_SELLER_REALTY;
        } else if (ordinal == 1) {
            adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.CONTACT_SELLER_TRANSPORT;
        } else if (ordinal == 2) {
            adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.CONTACT_SELLER_GENERAL;
        } else if (ordinal == 3) {
            adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.CONTACT_SELLER_JOB;
        } else if (ordinal == 4) {
            adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.CONTACT_SELLER_SERVICES;
        } else if (ordinal == 5) {
            adjustTokenWithFirebaseName = null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.a = adjustTokenWithFirebaseName;
        this.b = (adjustTokenWithFirebaseName == null || (str2 = adjustTokenWithFirebaseName.getFirebaseName()) == null) ? "" : str2;
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
