package com.avito.android.location_list.analytics.events;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.location_list.analytics.FromBlock;
import com.avito.android.remote.auth.AuthSource;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J<\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u001e8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001cR\u0016\u0010&\u001a\u00020\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b%\u0010\u0011¨\u0006)"}, d2 = {"Lcom/avito/android/location_list/analytics/events/LocationListScreenCloseEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "component1", "component2", "categoryId", "locationId", "locationInput", "Lcom/avito/android/location_list/analytics/FromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/location_list/analytics/FromBlock;)Lcom/avito/android/location_list/analytics/events/LocationListScreenCloseEvent;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "getEventId", "eventId", "d", "Lcom/avito/android/location_list/analytics/FromBlock;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getLocationId", "", "getParams", "()Ljava/util/Map;", "params", AuthSource.SEND_ABUSE, "getCategoryId", "c", "getVersion", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/location_list/analytics/FromBlock;)V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public final class LocationListScreenCloseEvent implements ClickStreamEvent {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    public final String c;
    public final FromBlock d;
    public final /* synthetic */ ParametrizedClickStreamEvent e;

    public LocationListScreenCloseEvent(@Nullable String str, @Nullable String str2, @NotNull String str3, @NotNull FromBlock fromBlock) {
        Intrinsics.checkNotNullParameter(str3, "locationInput");
        Intrinsics.checkNotNullParameter(fromBlock, BookingInfoActivity.EXTRA_FROM_BLOCK);
        HashMap hashMapOf = r.hashMapOf(TuplesKt.to("from_block", Integer.valueOf(fromBlock.getId())), TuplesKt.to("location_text_input", str3));
        if (str2 != null) {
            hashMapOf.put("lid", str2);
        }
        if (str != null) {
            hashMapOf.put("cid", str);
        }
        this.e = new ParametrizedClickStreamEvent(2918, 1, hashMapOf, null, 8, null);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = fromBlock;
    }

    public static /* synthetic */ LocationListScreenCloseEvent copy$default(LocationListScreenCloseEvent locationListScreenCloseEvent, String str, String str2, String str3, FromBlock fromBlock, int i, Object obj) {
        if ((i & 1) != 0) {
            str = locationListScreenCloseEvent.a;
        }
        if ((i & 2) != 0) {
            str2 = locationListScreenCloseEvent.b;
        }
        if ((i & 4) != 0) {
            str3 = locationListScreenCloseEvent.c;
        }
        if ((i & 8) != 0) {
            fromBlock = locationListScreenCloseEvent.d;
        }
        return locationListScreenCloseEvent.copy(str, str2, str3, fromBlock);
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
    public final LocationListScreenCloseEvent copy(@Nullable String str, @Nullable String str2, @NotNull String str3, @NotNull FromBlock fromBlock) {
        Intrinsics.checkNotNullParameter(str3, "locationInput");
        Intrinsics.checkNotNullParameter(fromBlock, BookingInfoActivity.EXTRA_FROM_BLOCK);
        return new LocationListScreenCloseEvent(str, str2, str3, fromBlock);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.e.description();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationListScreenCloseEvent)) {
            return false;
        }
        LocationListScreenCloseEvent locationListScreenCloseEvent = (LocationListScreenCloseEvent) obj;
        return Intrinsics.areEqual(this.a, locationListScreenCloseEvent.a) && Intrinsics.areEqual(this.b, locationListScreenCloseEvent.b) && Intrinsics.areEqual(this.c, locationListScreenCloseEvent.c) && Intrinsics.areEqual(this.d, locationListScreenCloseEvent.d);
    }

    @Nullable
    public final String getCategoryId() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.e.getEventId();
    }

    @Nullable
    public final String getLocationId() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.e.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.e.getVersion();
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        FromBlock fromBlock = this.d;
        if (fromBlock != null) {
            i = fromBlock.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("LocationListScreenCloseEvent(categoryId=");
        L.append(this.a);
        L.append(", locationId=");
        L.append(this.b);
        L.append(", locationInput=");
        L.append(this.c);
        L.append(", fromBlock=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }
}
