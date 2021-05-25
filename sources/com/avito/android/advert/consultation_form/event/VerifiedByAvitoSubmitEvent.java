package com.avito.android.advert.consultation_form.event;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/consultation_form/event/VerifiedByAvitoSubmitEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", AuthSource.BOOKING_ORDER, "I", "getVersion", "()I", "version", "", "", "", "c", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", AuthSource.SEND_ABUSE, "getEventId", "eventId", "<init>", "(IILjava/util/Map;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class VerifiedByAvitoSubmitEvent implements ClickStreamEvent {
    public final int a;
    public final int b;
    @NotNull
    public final Map<String, Object> c;

    public VerifiedByAvitoSubmitEvent() {
        this(0, 0, null, 7, null);
    }

    public VerifiedByAvitoSubmitEvent(int i, int i2, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        this.a = i;
        this.b = i2;
        this.c = map;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return ClickStreamEvent.DefaultImpls.description(this);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.c;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VerifiedByAvitoSubmitEvent(int i, int i2, Map map, int i3, j jVar) {
        this((i3 & 1) != 0 ? 4646 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? q.mapOf(TuplesKt.to(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, "photo_verification_popup")) : map);
    }
}
