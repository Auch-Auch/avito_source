package com.avito.android.home.default_search_location;

import android.location.Location;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/home/default_search_location/DefaultSearchLocationAnalyticsInteractorImpl;", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationAnalyticsInteractor;", "Landroid/location/Location;", "location", "", "time", "", "fromPage", "", "sendUserCoordinates", "(Landroid/location/Location;Ljava/lang/Integer;Ljava/lang/String;)V", "sendFindCoordinates", "(Ljava/lang/String;)V", "errorText", "sendResolveCoordinates", "(Landroid/location/Location;Ljava/lang/String;)V", "sendScreenExitAfterCoordinatesResolve", "()V", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalyticsInteractor", "<init>", "(Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultSearchLocationAnalyticsInteractorImpl implements DefaultSearchLocationAnalyticsInteractor {
    public final LocationAnalyticsInteractor a;

    public DefaultSearchLocationAnalyticsInteractorImpl(@NotNull LocationAnalyticsInteractor locationAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(locationAnalyticsInteractor, "locationAnalyticsInteractor");
        this.a = locationAnalyticsInteractor;
    }

    @Override // com.avito.android.home.default_search_location.DefaultSearchLocationAnalyticsInteractor
    public void sendFindCoordinates(@Nullable String str) {
        this.a.trackFindCoordinates(str);
    }

    @Override // com.avito.android.home.default_search_location.DefaultSearchLocationAnalyticsInteractor
    public void sendResolveCoordinates(@Nullable Location location, @Nullable String str) {
        this.a.trackResolveCoordinates(location, str);
    }

    @Override // com.avito.android.home.default_search_location.DefaultSearchLocationAnalyticsInteractor
    public void sendScreenExitAfterCoordinatesResolve() {
        this.a.trackScreenExitAfterCoordinatesResolve();
    }

    @Override // com.avito.android.home.default_search_location.DefaultSearchLocationAnalyticsInteractor
    public void sendUserCoordinates(@NotNull Location location, @Nullable Integer num, @NotNull String str) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(str, "fromPage");
        this.a.trackHomeRequestWithUserCoordinates(location, null, str, num);
    }
}
