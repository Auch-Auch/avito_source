package com.avito.android.analytics;

import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.model.ParametrizedEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/ParametrizedEvent;", "Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "toClickStreamEvent", "(Lcom/avito/android/remote/model/ParametrizedEvent;)Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "analytics_release"}, k = 2, mv = {1, 4, 2})
public final class ParametrizedEventsKt {
    @NotNull
    public static final ParametrizedClickStreamEvent toClickStreamEvent(@NotNull ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(parametrizedEvent, "$this$toClickStreamEvent");
        int id = parametrizedEvent.getId();
        int version = parametrizedEvent.getVersion();
        Map<String, String> parameters = parametrizedEvent.getParameters();
        if (parameters == null) {
            parameters = r.emptyMap();
        }
        return new ParametrizedClickStreamEvent(id, version, parameters, null, 8, null);
    }
}
