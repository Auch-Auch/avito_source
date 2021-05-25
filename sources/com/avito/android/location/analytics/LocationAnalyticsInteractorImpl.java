package com.avito.android.location.analytics;

import android.location.Location;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.location.LocationSource;
import com.avito.android.location.analytics.events.CoordinatesResolveEvent;
import com.avito.android.location.analytics.events.ExitScreenAfterCoordinatesResolveEvent;
import com.avito.android.location.analytics.events.FindUserCoordinatesEvent;
import com.avito.android.location.analytics.events.HomeRequestWithUserLocationEvent;
import com.avito.android.location.analytics.events.LocationNotificationActionEvent;
import com.avito.android.location.analytics.events.LocationNotificationShownEvent;
import com.avito.android.location.analytics.events.LocationStorageEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u00105\u001a\u000200\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b6\u00107JG\u0010\n\u001a\u00020\t2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0017\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001c\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ3\u0010#\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010$J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040%2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010'R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010(R\u0016\u0010+\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0019\u00105\u001a\u0002008\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/avito/android/location/analytics/LocationAnalyticsInteractorImpl;", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "Ljava/util/HashMap;", "Lcom/avito/android/location/LocationSource;", "", "Lkotlin/collections/HashMap;", "storageTypes", BookingInfoActivity.EXTRA_FROM_BLOCK, "locationId", "", "trackLocationStorageRequested", "(Ljava/util/HashMap;Lcom/avito/android/location/LocationSource;Ljava/lang/String;)V", "Landroid/location/Location;", "location", "fromPage", "", "coordinateResolveTime", "trackHomeRequestWithUserCoordinates", "(Landroid/location/Location;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "geoSessionId", "", "isChange", "changeRule", "trackLocationNotificationSubmitted", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "trackFindCoordinates", "(Ljava/lang/String;)V", "errorText", "trackResolveCoordinates", "(Landroid/location/Location;Ljava/lang/String;)V", "trackScreenExitAfterCoordinatesResolve", "()V", "changeReason", "oldLocationId", "newLocationId", "trackLocationNotificationWasShown", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", AuthSource.SEND_ABUSE, "(Landroid/location/Location;)Ljava/util/List;", "Ljava/lang/String;", AuthSource.BOOKING_ORDER, "Z", "coordinatesResolve", "Lcom/avito/android/server_time/TimeSource;", "d", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/server_time/TimeSource;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class LocationAnalyticsInteractorImpl implements LocationAnalyticsInteractor {
    public String a = "";
    public boolean b;
    @NotNull
    public final Analytics c;
    public final TimeSource d;

    @Inject
    public LocationAnalyticsInteractorImpl(@NotNull Analytics analytics, @NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.c = analytics;
        this.d = timeSource;
    }

    public final List<String> a(Location location) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(location.getTime());
        String provider = location.getProvider();
        Intrinsics.checkNotNullExpressionValue(provider, "location.provider");
        return CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()), String.valueOf(location.getAccuracy()), String.valueOf(seconds), provider});
    }

    @NotNull
    public final Analytics getAnalytics() {
        return this.c;
    }

    @Override // com.avito.android.location.analytics.LocationAnalyticsInteractor
    public void trackFindCoordinates(@Nullable String str) {
        String stringPlus = Intrinsics.stringPlus(str, String.valueOf(this.d.now()));
        this.a = stringPlus;
        this.c.track(new FindUserCoordinatesEvent(str, stringPlus));
    }

    @Override // com.avito.android.location.analytics.LocationAnalyticsInteractor
    public void trackHomeRequestWithUserCoordinates(@NotNull Location location, @Nullable String str, @Nullable String str2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.c.track(new HomeRequestWithUserLocationEvent(a(location), str, str2, num));
    }

    @Override // com.avito.android.location.analytics.LocationAnalyticsInteractor
    public void trackLocationNotificationSubmitted(@Nullable String str, boolean z, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str3, "changeRule");
        this.c.track(new LocationNotificationActionEvent(str, z ? "0" : "1", str2, str3));
    }

    @Override // com.avito.android.location.analytics.LocationAnalyticsInteractor
    public void trackLocationNotificationWasShown(@Nullable String str, @NotNull String str2, @Nullable String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str2, "changeReason");
        Intrinsics.checkNotNullParameter(str4, "newLocationId");
        this.c.track(new LocationNotificationShownEvent(str3, str4, str, str2));
    }

    @Override // com.avito.android.location.analytics.LocationAnalyticsInteractor
    public void trackLocationStorageRequested(@NotNull HashMap<LocationSource, String> hashMap, @Nullable LocationSource locationSource, @Nullable String str) {
        Intrinsics.checkNotNullParameter(hashMap, "storageTypes");
        this.c.track(new LocationStorageEvent(hashMap, locationSource, str));
    }

    @Override // com.avito.android.location.analytics.LocationAnalyticsInteractor
    public void trackResolveCoordinates(@Nullable Location location, @Nullable String str) {
        boolean z = true;
        this.b = true;
        Analytics analytics = this.c;
        List<String> a3 = location != null ? a(location) : null;
        String str2 = this.a;
        if (location == null) {
            z = false;
        }
        analytics.track(new CoordinatesResolveEvent(a3, str2, str, z));
    }

    @Override // com.avito.android.location.analytics.LocationAnalyticsInteractor
    public void trackScreenExitAfterCoordinatesResolve() {
        if ((this.a.length() > 0) && this.b) {
            this.c.track(new ExitScreenAfterCoordinatesResolveEvent(this.a));
        }
    }
}
