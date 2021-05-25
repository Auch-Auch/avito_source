package com.avito.android.webview.models;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0010\u0010\u0011R(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/webview/models/WebViewInnerEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "", "", "params", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "", "version", "I", "getVersion", "()I", "eventId", "getEventId", "<init>", "(IILjava/util/Map;)V", "webview_release"}, k = 1, mv = {1, 4, 2})
public final class WebViewInnerEvent implements ClickStreamEvent {
    @SerializedName("id")
    private final int eventId;
    @SerializedName("params")
    @NotNull
    private final Map<String, Object> params;
    @SerializedName("version")
    private final int version;

    public WebViewInnerEvent(int i, int i2, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        this.eventId = i;
        this.version = i2;
        this.params = map;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return ClickStreamEvent.DefaultImpls.description(this);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.eventId;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.params;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.version;
    }
}
