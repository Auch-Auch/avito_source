package com.avito.android.advert_core.analytics.broker.events;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.SimpleClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.SessionContract;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R(\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/avito/android/advert_core/analytics/broker/events/CreditCalculatorValueChangedEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getEventId", "()I", "eventId", "getVersion", "version", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "type", "itemId", SessionContract.SESSION, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class CreditCalculatorValueChangedEvent implements ClickStreamEvent {
    @NotNull
    public final Map<String, Object> a;
    public final /* synthetic */ SimpleClickStreamEvent b = new SimpleClickStreamEvent(4499, 3);

    public CreditCalculatorValueChangedEvent(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str2, "itemId");
        Intrinsics.checkNotNullParameter(str3, SessionContract.SESSION);
        Map<String, Object> mutableMapOf = r.mutableMapOf(TuplesKt.to("item_id", str2), TuplesKt.to("broker_session", str3));
        if (str != null) {
            mutableMapOf.put(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, str);
        }
        Unit unit = Unit.INSTANCE;
        this.a = mutableMapOf;
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
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.b.getVersion();
    }
}
