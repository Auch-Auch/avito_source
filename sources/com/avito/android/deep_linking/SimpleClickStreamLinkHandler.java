package com.avito.android.deep_linking;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.Event;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.SimpleClickStreamEvent;
import com.avito.android.deep_linking.links.ClickStreamLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/deep_linking/SimpleClickStreamLinkHandler;", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "Lcom/avito/android/deep_linking/links/ClickStreamLink;", "link", "Lkotlin/Function1;", "Lcom/avito/android/deep_linking/links/DeepLink;", "", "redirectAction", "handleDeepLink", "(Lcom/avito/android/deep_linking/links/ClickStreamLink;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleClickStreamLinkHandler implements ClickStreamLinkHandler {
    @NotNull
    public final Analytics a;

    @Inject
    public SimpleClickStreamLinkHandler(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @NotNull
    public final Analytics getAnalytics() {
        return this.a;
    }

    @Override // com.avito.android.deep_linking.ClickStreamLinkHandler
    public void handleDeepLink(@NotNull ClickStreamLink clickStreamLink, @Nullable Function1<? super DeepLink, Unit> function1) {
        Event event;
        Intrinsics.checkNotNullParameter(clickStreamLink, "link");
        int eventVersion = clickStreamLink.getEventVersion();
        Map<String, String> parameters = clickStreamLink.getParameters();
        if (parameters != null) {
            event = new ParametrizedClickStreamEvent(clickStreamLink.getEventId(), eventVersion, parameters, null, 8, null);
        } else {
            event = new SimpleClickStreamEvent(clickStreamLink.getEventId(), eventVersion);
        }
        this.a.track(event);
        DeepLink redirect = clickStreamLink.getRedirect();
        if (redirect != null && function1 != null) {
            function1.invoke(redirect);
        }
    }
}
