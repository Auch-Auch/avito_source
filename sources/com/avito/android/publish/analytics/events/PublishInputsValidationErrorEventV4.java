package com.avito.android.publish.analytics.events;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0017\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b0\u00138\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/publish/analytics/events/PublishInputsValidationErrorEventV4;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "toString", "()Ljava/lang/String;", "description", "d", "Ljava/lang/String;", "infomodelParameters", "", "getEventId", "()I", "eventId", "getVersion", "version", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "dataProvider", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "errors", "", "c", "Ljava/util/List;", Navigation.CATEGORY_IDS, "", "getParams", "()Ljava/util/Map;", "params", "<init>", "(Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishInputsValidationErrorEventV4 implements ClickStreamEvent {
    public final PublishAnalyticsDataProvider a;
    public final Map<String, String> b;
    public final List<Integer> c;
    public final String d;
    public final /* synthetic */ ParametrizedClickStreamEvent e;

    public PublishInputsValidationErrorEventV4(@NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull Map<String, String> map, @Nullable List<Integer> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "dataProvider");
        Intrinsics.checkNotNullParameter(map, "errors");
        this.e = new ParametrizedClickStreamEvent(2712, 4, PublishInputsValidationErrorEventV4Kt.access$createParams(publishAnalyticsDataProvider, map, list, str), null, 8, null);
        this.a = publishAnalyticsDataProvider;
        this.b = map;
        this.c = list;
        this.d = str;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.e.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.e.getEventId();
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

    @NotNull
    public String toString() {
        StringBuilder L = a.L("PublishInputsValidationErrorEventV4(eventId = 2712, params = ");
        L.append(PublishInputsValidationErrorEventV4Kt.access$createParams(this.a, this.b, this.c, this.d));
        L.append(")}");
        return L.toString();
    }
}
