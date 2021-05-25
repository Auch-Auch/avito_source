package com.avito.android.location_list.analytics.events;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J(\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u00168\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004R\u0016\u0010 \u001a\u00020\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000e¨\u0006#"}, d2 = {"Lcom/avito/android/location_list/analytics/events/LocationListScreenOpenEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "component1", "component2", "categoryId", "locationId", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/location_list/analytics/events/LocationListScreenOpenEvent;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "getEventId", "eventId", "", "getParams", "()Ljava/util/Map;", "params", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCategoryId", AuthSource.BOOKING_ORDER, "getLocationId", "getVersion", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public final class LocationListScreenOpenEvent implements ClickStreamEvent {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    public final /* synthetic */ ParametrizedClickStreamEvent c;

    public LocationListScreenOpenEvent(@Nullable String str, @Nullable String str2) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("cid", str);
        }
        if (str2 != null) {
            hashMap.put("lid", str2);
        }
        this.c = new ParametrizedClickStreamEvent(2916, 1, hashMap, null, 8, null);
        this.a = str;
        this.b = str2;
    }

    public static /* synthetic */ LocationListScreenOpenEvent copy$default(LocationListScreenOpenEvent locationListScreenOpenEvent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = locationListScreenOpenEvent.a;
        }
        if ((i & 2) != 0) {
            str2 = locationListScreenOpenEvent.b;
        }
        return locationListScreenOpenEvent.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final LocationListScreenOpenEvent copy(@Nullable String str, @Nullable String str2) {
        return new LocationListScreenOpenEvent(str, str2);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.c.description();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationListScreenOpenEvent)) {
            return false;
        }
        LocationListScreenOpenEvent locationListScreenOpenEvent = (LocationListScreenOpenEvent) obj;
        return Intrinsics.areEqual(this.a, locationListScreenOpenEvent.a) && Intrinsics.areEqual(this.b, locationListScreenOpenEvent.b);
    }

    @Nullable
    public final String getCategoryId() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.c.getEventId();
    }

    @Nullable
    public final String getLocationId() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.c.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.c.getVersion();
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("LocationListScreenOpenEvent(categoryId=");
        L.append(this.a);
        L.append(", locationId=");
        return a.t(L, this.b, ")");
    }
}
