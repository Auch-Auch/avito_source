package com.avito.android.analytics;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.SimpleClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import com.vk.sdk.api.VKApiConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000f\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/avito/android/analytics/RecommendedAdvertHiddenEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getVersion", "()I", "version", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "getEventId", "eventId", "id", "categoryId", "locationId", VKApiConst.POSITION, "label", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;)V", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public final class RecommendedAdvertHiddenEvent implements ClickStreamEvent {
    @NotNull
    public final Map<String, Object> a;
    public final /* synthetic */ SimpleClickStreamEvent b = new SimpleClickStreamEvent(3848, 5);

    public RecommendedAdvertHiddenEvent(@NotNull String str, @Nullable String str2, @Nullable Integer num, int i, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str3, "label");
        Map<String, Object> mutableMapOf = r.mutableMapOf(TuplesKt.to("iid", str), TuplesKt.to(VKApiConst.POSITION, Integer.valueOf(i)), TuplesKt.to(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, str3));
        if (str2 != null) {
            mutableMapOf.put("cid", str2);
        }
        if (num != null) {
            mutableMapOf.put("lid", num);
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
