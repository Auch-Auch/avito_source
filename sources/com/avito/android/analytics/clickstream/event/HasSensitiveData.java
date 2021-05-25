package com.avito.android.analytics.clickstream.event;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/analytics/clickstream/event/HasSensitiveData;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public interface HasSensitiveData extends ClickStreamEvent {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static String description(@NotNull HasSensitiveData hasSensitiveData) {
            return ClickStreamEvent.DefaultImpls.description(hasSensitiveData);
        }
    }
}
