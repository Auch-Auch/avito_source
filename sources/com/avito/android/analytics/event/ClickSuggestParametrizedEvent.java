package com.avito.android.analytics.event;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/analytics/event/ClickSuggestParametrizedEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getEventId", "()I", "eventId", "getVersion", "version", "", "", "getParams", "()Ljava/util/Map;", "params", "Companion", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ClickSuggestParametrizedEvent implements ClickStreamEvent {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/event/ClickSuggestParametrizedEvent$Companion;", "", "Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;", "action", "Lcom/avito/android/analytics/event/ClickSuggestParametrizedEvent;", "fromAction", "(Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;)Lcom/avito/android/analytics/event/ClickSuggestParametrizedEvent;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ClickSuggestParametrizedEvent fromAction(@NotNull SuggestAnalyticsEvent suggestAnalyticsEvent) {
            Intrinsics.checkNotNullParameter(suggestAnalyticsEvent, "action");
            return new ClickSuggestParametrizedEvent(suggestAnalyticsEvent.getId(), suggestAnalyticsEvent.getVersion(), suggestAnalyticsEvent.getParameters(), null);
        }

        public Companion(j jVar) {
        }
    }

    public ClickSuggestParametrizedEvent(int i, int i2, Map map, j jVar) {
        this.a = new ParametrizedClickStreamEvent(i, i2, map, null, 8, null);
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
