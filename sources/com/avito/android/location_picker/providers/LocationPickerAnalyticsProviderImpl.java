package com.avito.android.location_picker.providers;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Names;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017¨\u0006 "}, d2 = {"Lcom/avito/android/location_picker/providers/LocationPickerAnalyticsProviderImpl;", "Lcom/avito/android/location_picker/providers/LocationPickerAnalyticsProvider;", "Lcom/avito/android/location_picker/entities/LocationPickerState;", "state", "", "trackSearchQueryChanged", "(Lcom/avito/android/location_picker/entities/LocationPickerState;)V", "trackAddressSuggestionSelected", "trackTryToSaveEmptyAddress", "trackTryToSaveNotSuggestedAddress", "trackMapPositionChanged", "trackDevicePositionUsed", "", "", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/location_picker/entities/LocationPickerState;)Ljava/util/Map;", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "", AuthSource.BOOKING_ORDER, "Z", "trackedSearchQueryChanged", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "d", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "trackedMapPositionChanged", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class LocationPickerAnalyticsProviderImpl implements LocationPickerAnalyticsProvider {
    public boolean a;
    public boolean b;
    public final Analytics c;
    public final PublishAnalyticsDataProvider d;

    @Inject
    public LocationPickerAnalyticsProviderImpl(@NotNull Analytics analytics, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsData");
        this.c = analytics;
        this.d = publishAnalyticsDataProvider;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0057: APUT  
      (r0v1 kotlin.Pair[])
      (2 ??[int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x0053: INVOKE  (r8v2 kotlin.Pair) = (r2v7 java.lang.String), (r8v1 java.lang.String) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public final Map<String, Object> a(LocationPickerState locationPickerState) {
        String str;
        String str2;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(Names.GEO, CollectionsKt__CollectionsKt.listOf((Object[]) new Double[]{Double.valueOf(locationPickerState.getLatLng().getLatitude()), Double.valueOf(locationPickerState.getLatLng().getLongitude())}));
        pairArr[1] = TuplesKt.to("cid", this.d.getSelectedWizardId());
        if (locationPickerState.getItemId() != null) {
            str = locationPickerState.getItemId();
            str2 = "iid";
        } else {
            str = this.d.getSessionId();
            str2 = "esid";
        }
        pairArr[2] = TuplesKt.to(str2, str);
        return r.mapOf(pairArr);
    }

    @Override // com.avito.android.location_picker.providers.LocationPickerAnalyticsProvider
    public void trackAddressSuggestionSelected(@NotNull LocationPickerState locationPickerState) {
        Intrinsics.checkNotNullParameter(locationPickerState, "state");
        Map mutableMap = r.toMutableMap(a(locationPickerState));
        mutableMap.put(IntegrityManager.INTEGRITY_TYPE_ADDRESS, locationPickerState.getAddressString());
        this.c.track(new ParametrizedClickStreamEvent(2357, 6, mutableMap, null, 8, null));
    }

    @Override // com.avito.android.location_picker.providers.LocationPickerAnalyticsProvider
    public void trackDevicePositionUsed(@NotNull LocationPickerState locationPickerState) {
        Intrinsics.checkNotNullParameter(locationPickerState, "state");
        this.c.track(new ParametrizedClickStreamEvent(2356, 4, a(locationPickerState), null, 8, null));
    }

    @Override // com.avito.android.location_picker.providers.LocationPickerAnalyticsProvider
    public void trackMapPositionChanged(@NotNull LocationPickerState locationPickerState) {
        Intrinsics.checkNotNullParameter(locationPickerState, "state");
        if (!this.a) {
            this.a = true;
            this.c.track(new ParametrizedClickStreamEvent(2351, 4, a(locationPickerState), null, 8, null));
        }
    }

    @Override // com.avito.android.location_picker.providers.LocationPickerAnalyticsProvider
    public void trackSearchQueryChanged(@NotNull LocationPickerState locationPickerState) {
        Intrinsics.checkNotNullParameter(locationPickerState, "state");
        if (!this.b) {
            this.b = true;
            this.c.track(new ParametrizedClickStreamEvent(2350, 4, a(locationPickerState), null, 8, null));
        }
    }

    @Override // com.avito.android.location_picker.providers.LocationPickerAnalyticsProvider
    public void trackTryToSaveEmptyAddress(@NotNull LocationPickerState locationPickerState) {
        Intrinsics.checkNotNullParameter(locationPickerState, "state");
        this.c.track(new ParametrizedClickStreamEvent(2681, 1, a(locationPickerState), null, 8, null));
    }

    @Override // com.avito.android.location_picker.providers.LocationPickerAnalyticsProvider
    public void trackTryToSaveNotSuggestedAddress(@NotNull LocationPickerState locationPickerState) {
        Intrinsics.checkNotNullParameter(locationPickerState, "state");
        Map mutableMap = r.toMutableMap(a(locationPickerState));
        mutableMap.put(IntegrityManager.INTEGRITY_TYPE_ADDRESS, locationPickerState.getAddressString());
        mutableMap.put("success", String.valueOf(!locationPickerState.getSuggestionList().isEmpty()));
        this.c.track(new ParametrizedClickStreamEvent(2685, 1, mutableMap, null, 8, null));
    }
}
