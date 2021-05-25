package com.avito.android.suggest_locations.analytics.events;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.suggest_locations.analytics.FromBlock;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/avito/android/suggest_locations/analytics/events/SuggestLocationsScreenCloseEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getVersion", "()I", "version", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCategoryId", "categoryId", AuthSource.BOOKING_ORDER, "getLocationId", "locationId", "getEventId", "eventId", "locationInput", "Lcom/avito/android/suggest_locations/analytics/FromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "fromPage", "oldLocationId", "geoSessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/suggest_locations/analytics/FromBlock;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsScreenCloseEvent implements ClickStreamEvent {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    public final /* synthetic */ ParametrizedClickStreamEvent c;

    public SuggestLocationsScreenCloseEvent(@Nullable String str, @Nullable String str2, @NotNull String str3, @NotNull FromBlock fromBlock, @Nullable Integer num, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str3, "locationInput");
        Intrinsics.checkNotNullParameter(fromBlock, BookingInfoActivity.EXTRA_FROM_BLOCK);
        HashMap hashMapOf = r.hashMapOf(TuplesKt.to("from_block", Integer.valueOf(fromBlock.getId())), TuplesKt.to("location_text_input", str3));
        if (str2 != null) {
            hashMapOf.put("lid", str2);
        }
        if (str != null) {
            hashMapOf.put("cid", str);
        }
        if (num != null) {
            hashMapOf.put(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, Integer.valueOf(num.intValue()));
        }
        if (str4 != null) {
            hashMapOf.put("locationid", str4);
        }
        if (str5 != null) {
            hashMapOf.put("geo_session", str5);
        }
        this.c = new ParametrizedClickStreamEvent(2918, 8, hashMapOf, null, 8, null);
        this.a = str;
        this.b = str2;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.c.description();
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
}
