package com.avito.android.analytics.provider.clickstream;

import a2.b.a.a.a;
import com.avito.android.analytics.Event;
import com.avito.android.analytics.HasCustomLogger;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "Lcom/avito/android/analytics/Event;", "Lcom/avito/android/analytics/HasCustomLogger;", "", "description", "()Ljava/lang/String;", "", "getEventId", "()I", "eventId", "getVersion", "version", "", "", "getParams", "()Ljava/util/Map;", "params", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public interface ClickStreamEvent extends Event, HasCustomLogger {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static String description(@NotNull ClickStreamEvent clickStreamEvent) {
            StringBuilder L = a.L("ClickStreamEvent (id:");
            L.append(clickStreamEvent.getEventId());
            L.append(", params:");
            L.append(clickStreamEvent.getParams());
            L.append(", version:");
            L.append(clickStreamEvent.getVersion());
            L.append(')');
            return L.toString();
        }
    }

    @NotNull
    String description();

    int getEventId();

    @NotNull
    Map<String, Object> getParams();

    int getVersion();
}
