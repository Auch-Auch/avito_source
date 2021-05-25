package com.avito.android.service.short_task.clickstream;

import android.location.Location;
import com.avito.android.analytics.clickstream.ClickStreamSender;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.geo.GeoStorage;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.UserAgentProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Collections;
import com.avito.android.util.preferences.Names;
import com.sumsub.sns.core.common.SNSConstants;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/service/short_task/clickstream/AvitoCommonParametersProvider;", "Lcom/avito/android/analytics/clickstream/ClickStreamSender$CommonParametersProvider;", "", "", "", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "()Ljava/util/Map;", "Lcom/avito/android/geo/GeoStorage;", "c", "Lcom/avito/android/geo/GeoStorage;", "geoProvider", "Lcom/avito/android/remote/DeviceIdProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "Lcom/avito/android/remote/UserAgentProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/UserAgentProvider;", "userAgentProvider", "<init>", "(Lcom/avito/android/remote/DeviceIdProvider;Lcom/avito/android/remote/UserAgentProvider;Lcom/avito/android/geo/GeoStorage;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoCommonParametersProvider implements ClickStreamSender.CommonParametersProvider {
    public final DeviceIdProvider a;
    public final UserAgentProvider b;
    public final GeoStorage c;

    @Inject
    public AvitoCommonParametersProvider(@NotNull DeviceIdProvider deviceIdProvider, @NotNull UserAgentProvider userAgentProvider, @NotNull GeoStorage geoStorage) {
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(userAgentProvider, "userAgentProvider");
        Intrinsics.checkNotNullParameter(geoStorage, "geoProvider");
        this.a = deviceIdProvider;
        this.b = userAgentProvider;
        this.c = geoStorage;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0063: APUT  
      (r1v0 kotlin.Pair[])
      (2 ??[int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x005f: INVOKE  (r0v2 kotlin.Pair) = 
      (wrap: java.lang.String : ?: SGET   com.avito.android.util.preferences.Names.GEO java.lang.String)
      (r6v0 java.lang.Number[])
     type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    @Override // com.avito.android.analytics.clickstream.ClickStreamSender.CommonParametersProvider
    @NotNull
    public Map<String, Object> parameters() {
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(AuthSource.OPEN_USER_ADVERT, this.b.getUserAgent());
        pairArr[1] = TuplesKt.to(SNSConstants.Preference.KEY_DEVICE_ID, this.a.getValue());
        Location location = this.c.getLocation();
        pairArr[2] = TuplesKt.to(Names.GEO, location != null ? new Number[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Float.valueOf(location.getAccuracy()), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(location.getTime()))} : null);
        return Collections.filterValuesNotNull(r.mapOf(pairArr));
    }
}
