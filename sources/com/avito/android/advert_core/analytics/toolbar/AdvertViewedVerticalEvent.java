package com.avito.android.advert_core.analytics.toolbar;

import com.avito.android.analytics_adjust.AdjustEvent;
import com.avito.android.analytics_adjust.AdjustEventTracker;
import com.avito.android.analytics_adjust.AdjustTokenWithFirebaseName;
import com.avito.android.analytics_adjust.utils.AdjustContentType;
import com.avito.android.analytics_adjust.utils.AdjustEventsKt;
import com.avito.android.analytics_firebase.FirebaseEvent;
import com.avito.android.analytics_firebase.FirebaseEventTracker;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertisementVerticalAlias;
import com.avito.android.remote.model.CategoryIds;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010!\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR'\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R*\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u001d¨\u0006$"}, d2 = {"Lcom/avito/android/advert_core/analytics/toolbar/AdvertViewedVerticalEvent;", "Lcom/avito/android/analytics_adjust/AdjustEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "d", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "", "e", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "c", "getFirebaseEventParams", "firebaseEventParams", "Lcom/avito/android/analytics_adjust/AdjustTokenWithFirebaseName;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics_adjust/AdjustTokenWithFirebaseName;", "adjustTokenWithFirebaseName", AuthSource.BOOKING_ORDER, "getName", "()Ljava/lang/String;", "name", "Lcom/avito/android/remote/model/AdvertisementVerticalAlias;", "verticalAlias", "categoryId", "<init>", "(Lcom/avito/android/remote/model/AdvertisementVerticalAlias;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertViewedVerticalEvent implements AdjustEvent, FirebaseEvent {
    public final AdjustTokenWithFirebaseName a;
    @NotNull
    public final String b;
    @Nullable
    public final Map<String, String> c;
    public final String d;
    @Nullable
    public final Map<String, String> e;

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

    public AdvertViewedVerticalEvent(@NotNull AdvertisementVerticalAlias advertisementVerticalAlias, @Nullable String str, @NotNull String str2, @Nullable Map<String, String> map) {
        AdjustTokenWithFirebaseName adjustTokenWithFirebaseName;
        String str3;
        Intrinsics.checkNotNullParameter(advertisementVerticalAlias, "verticalAlias");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        this.d = str2;
        this.e = map;
        int ordinal = advertisementVerticalAlias.ordinal();
        if (ordinal == 0) {
            adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.ADVERT_VIEWED_REALTY;
        } else if (ordinal != 1) {
            if (ordinal == 2) {
                adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.ADVERT_VIEWED_GENERAL;
            } else if (ordinal == 3) {
                adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.ADVERT_VIEWED_JOB;
            } else if (ordinal == 4) {
                adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.ADVERT_VIEWED_SERVICES;
            } else if (ordinal == 5) {
                adjustTokenWithFirebaseName = null;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (Intrinsics.areEqual(str, CategoryIds.AUTO.SPAREPARTS.getId())) {
            adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.ADVERT_VIEWED_GENERAL;
        } else {
            adjustTokenWithFirebaseName = AdjustTokenWithFirebaseName.ADVERT_VIEWED_TRANSPORT;
        }
        this.a = adjustTokenWithFirebaseName;
        this.b = (adjustTokenWithFirebaseName == null || (str3 = adjustTokenWithFirebaseName.getFirebaseName()) == null) ? "" : str3;
        this.c = map;
    }

    @Override // com.avito.android.analytics_adjust.AdjustEvent
    public void accept(@NotNull AdjustEventTracker adjustEventTracker) {
        Intrinsics.checkNotNullParameter(adjustEventTracker, "tracker");
        if (this.a != null) {
            com.adjust.sdk.AdjustEvent withContentIds = AdjustEventsKt.withContentIds(AdjustEventsKt.withContentType(new com.adjust.sdk.AdjustEvent(this.a.getAdjustToken()), AdjustContentType.PRODUCT), this.d);
            adjustEventTracker.injectCriteoViewProduct(withContentIds, this.d);
            adjustEventTracker.trackEvent(withContentIds);
        }
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @Nullable
    public Map<String, String> getFirebaseEventParams() {
        return this.c;
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @NotNull
    public String getName() {
        return this.b;
    }

    @Nullable
    public final Map<String, String> getParams() {
        return this.e;
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
        if (this.a != null) {
            firebaseEventTracker.trackEvent(this);
        }
    }
}
