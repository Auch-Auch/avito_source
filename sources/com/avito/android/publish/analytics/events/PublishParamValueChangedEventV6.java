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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0004R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0010R\u0016\u0010\u001f\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\r¨\u0006\""}, d2 = {"Lcom/avito/android/publish/analytics/events/PublishParamValueChangedEventV6;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "toString", "()Ljava/lang/String;", "description", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getEventId", "()I", "eventId", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "inputFieldValue", "", "c", "Ljava/util/List;", Navigation.CATEGORY_IDS, "d", "infomodelParameters", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "e", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "dataProvider", AuthSource.SEND_ABUSE, "inputFieldName", "getVersion", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishParamValueChangedEventV6 implements ClickStreamEvent {
    public final String a;
    public final String b;
    public final List<Integer> c;
    public final String d;
    public final PublishAnalyticsDataProvider e;
    public final /* synthetic */ ParametrizedClickStreamEvent f;

    public PublishParamValueChangedEventV6(@NotNull String str, @NotNull String str2, @Nullable List<Integer> list, @Nullable String str3, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(str, "inputFieldName");
        Intrinsics.checkNotNullParameter(str2, "inputFieldValue");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "dataProvider");
        this.f = new ParametrizedClickStreamEvent(2609, 6, PublishParamValueChangedEventV6Kt.access$createParams(str, str2, list, str3, publishAnalyticsDataProvider), null, 8, null);
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = str3;
        this.e = publishAnalyticsDataProvider;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.f.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.f.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.f.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.f.getVersion();
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("PublishInputChangedEventV6(2609) ");
        L.append(PublishParamValueChangedEventV6Kt.access$createParams(this.a, this.b, this.c, this.d, this.e));
        return L.toString();
    }
}
