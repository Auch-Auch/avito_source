package a2.a.a.i.e;

import com.avito.android.analytics.events.ExposureEventKt;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.model.ab_tests.AnalyticsParams;
import com.avito.android.remote.model.ab_tests.WithClientExposure;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a implements ClickStreamEvent {
    public final WithClientExposure a;
    public final /* synthetic */ ParametrizedClickStreamEvent b;

    public a(@NotNull WithClientExposure withClientExposure) {
        Intrinsics.checkNotNullParameter(withClientExposure, "abTest");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (ExposureEventKt.access$shouldExpose(withClientExposure.getAnalyticParams())) {
            StringBuilder I = a2.b.a.a.a.I('[');
            AnalyticsParams analyticParams = withClientExposure.getAnalyticParams();
            Intrinsics.checkNotNull(analyticParams);
            I.append(analyticParams.getAbToken());
            I.append(']');
            linkedHashMap.put("abs", I.toString());
        }
        this.b = new ParametrizedClickStreamEvent(2587, 0, linkedHashMap, null, 8, null);
        this.a = withClientExposure;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.b.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.b.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.b.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.b.getVersion();
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("ExposureEvent(2587) -> abs [");
        AnalyticsParams analyticParams = this.a.getAnalyticParams();
        return a2.b.a.a.a.s(L, analyticParams != null ? analyticParams.getAbToken() : null, ']');
    }
}
