package com.avito.android.short_term_rent.analytics.event;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.model.hotels.HotelsLocation;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.str_calendar.utils.StrDateUtilsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/short_term_rent/analytics/event/HotelsFindButtonClickEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getEventId", "()I", "eventId", "getVersion", "version", "Lcom/avito/android/remote/model/hotels/HotelsLocation;", "location", "adultsNumber", "Lcom/avito/android/str_calendar/utils/DateRange;", "dateRange", "<init>", "(Lcom/avito/android/remote/model/hotels/HotelsLocation;ILcom/avito/android/str_calendar/utils/DateRange;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsFindButtonClickEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public HotelsFindButtonClickEvent(@NotNull HotelsLocation hotelsLocation, int i, @NotNull DateRange dateRange) {
        Intrinsics.checkNotNullParameter(hotelsLocation, "location");
        Intrinsics.checkNotNullParameter(dateRange, "dateRange");
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to("direction_type", "location"), TuplesKt.to("direction_id", hotelsLocation.getName()), TuplesKt.to("booking_adult_number", Integer.valueOf(i)), TuplesKt.to("booking_rooms_number", 1), TuplesKt.to("dateto", StrDateUtilsKt.convertToStrDate(dateRange.getEndInclusive())), TuplesKt.to("datefrom", StrDateUtilsKt.convertToStrDate(dateRange.getStart())));
        String region = hotelsLocation.getRegion();
        if (region != null) {
            mutableMapOf.put("direction_location", region);
        }
        this.a = new ParametrizedClickStreamEvent(4812, 2, mutableMapOf, null, 8, null);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.a.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.a.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.a.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.a.getVersion();
    }
}
