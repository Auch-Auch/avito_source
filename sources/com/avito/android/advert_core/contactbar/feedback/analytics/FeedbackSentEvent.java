package com.avito.android.advert_core.contactbar.feedback.analytics;

import com.avito.android.advert_core.contactbar.feedback.FeedbackDialog;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert_core/contactbar/feedback/analytics/FeedbackSentEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getEventId", "()I", "eventId", "", "", "getParams", "()Ljava/util/Map;", "params", "getVersion", "version", "uid", "cid", "mcid", "iid", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;", "fromPage", "feedbackId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;Ljava/lang/String;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class FeedbackSentEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public FeedbackSentEvent(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable FeedbackDialog.Source source, @Nullable String str5) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str != null) {
            linkedHashMap.put("uid", str);
        }
        if (str2 != null) {
            linkedHashMap.put("cid", str2);
        }
        if (str3 != null) {
            linkedHashMap.put("mcid", str3);
        }
        if (str4 != null) {
            linkedHashMap.put("iid", str4);
        }
        if (source != null) {
            linkedHashMap.put(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, source.getTextValue());
        }
        if (str5 != null) {
            linkedHashMap.put("feedback_id", str5);
        }
        this.a = new ParametrizedClickStreamEvent(4236, 2, linkedHashMap, null, 8, null);
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
