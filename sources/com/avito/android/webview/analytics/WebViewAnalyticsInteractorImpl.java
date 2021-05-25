package com.avito.android.webview.analytics;

import android.net.Uri;
import android.os.Bundle;
import com.avito.android.CalledFrom;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.notification.Payload;
import com.avito.android.util.Collections;
import com.avito.android.webview.models.WebViewInnerEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u001b\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00190\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001eR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractorImpl;", "Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;", "Landroid/net/Uri;", "url", "", "trackPageScrolledToEnd", "(Landroid/net/Uri;)V", "Lcom/avito/android/CalledFrom;", "calledFrom", "trackLinkClicked", "(Lcom/avito/android/CalledFrom;)V", "Lcom/avito/android/webview/models/WebViewInnerEvent;", "event", "trackInnerEvent", "(Lcom/avito/android/webview/models/WebViewInnerEvent;)V", "trackPageOpened", "Landroid/os/Bundle;", "onSave", "()Landroid/os/Bundle;", "savedData", "onRestore", "(Landroid/os/Bundle;)V", "", "key", "", "", "container", AuthSource.SEND_ABUSE, "(Landroid/os/Bundle;Ljava/lang/String;Ljava/util/Map;)V", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "pageOpenedAlreadyTrackedPages", "scrolledToTheEndAlreadyTrackedPages", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "webview_release"}, k = 1, mv = {1, 4, 2})
public final class WebViewAnalyticsInteractorImpl implements WebViewAnalyticsInteractor {
    public final Map<String, Boolean> a = new LinkedHashMap();
    public final Map<String, Boolean> b = new LinkedHashMap();
    public final Analytics c;

    @Inject
    public WebViewAnalyticsInteractorImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.c = analytics;
    }

    public final void a(Bundle bundle, String str, Map<String, Boolean> map) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "s");
                map.put(next, Boolean.TRUE);
            }
        }
    }

    @Override // com.avito.android.webview.analytics.WebViewAnalyticsInteractor
    public void onRestore(@Nullable Bundle bundle) {
        if (bundle != null) {
            a(bundle, WebViewAnalyticsInteractorKt.STATE_SCROLLED_PAGES, this.a);
        }
        if (bundle != null) {
            a(bundle, WebViewAnalyticsInteractorKt.STATE_OPENED_PAGES, this.b);
        }
    }

    @Override // com.avito.android.webview.analytics.WebViewAnalyticsInteractor
    @NotNull
    public Bundle onSave() {
        Bundle bundle = new Bundle(this.a.size());
        bundle.putStringArrayList(WebViewAnalyticsInteractorKt.STATE_SCROLLED_PAGES, Collections.asArrayList(this.a.keySet()));
        bundle.putStringArrayList(WebViewAnalyticsInteractorKt.STATE_OPENED_PAGES, Collections.asArrayList(this.b.keySet()));
        return bundle;
    }

    @Override // com.avito.android.webview.analytics.WebViewAnalyticsInteractor
    public void trackInnerEvent(@NotNull WebViewInnerEvent webViewInnerEvent) {
        Intrinsics.checkNotNullParameter(webViewInnerEvent, "event");
        this.c.track(webViewInnerEvent);
    }

    @Override // com.avito.android.webview.analytics.WebViewAnalyticsInteractor
    public void trackLinkClicked(@Nullable CalledFrom calledFrom) {
        if (calledFrom != null) {
            Map<String, String> map = null;
            if (calledFrom instanceof CalledFrom.NotificationCenter) {
                map = ((CalledFrom.NotificationCenter) calledFrom).getAnalyticParams();
            } else if (calledFrom instanceof CalledFrom.Push) {
                Payload payload = ((CalledFrom.Push) calledFrom).getPayload();
                if (payload instanceof Payload.NotificationCenter) {
                    map = ((Payload.NotificationCenter) payload).getAnalyticParams();
                }
            }
            if (map != null) {
                this.c.track(new WebViewClickEvent(map));
                this.c.track(new WebViewLandingClickEvent(map));
            }
        }
    }

    @Override // com.avito.android.webview.analytics.WebViewAnalyticsInteractor
    public void trackPageOpened(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "url");
        String queryParameter = uri.getQueryParameter(WebViewAnalyticsInteractorKt.PAGE_ANALYTICS_ID_KEY);
        if (queryParameter != null) {
            String queryParameter2 = uri.getQueryParameter("iid");
            String queryParameter3 = uri.getQueryParameter(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY);
            Boolean bool = Boolean.TRUE;
            if (!Intrinsics.areEqual(this.b.get(queryParameter), bool)) {
                Analytics analytics = this.c;
                String uri2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "url.toString()");
                analytics.track(new WebViewPageOpenedEvent(uri2, queryParameter, queryParameter2, queryParameter3));
                this.b.put(queryParameter, bool);
            }
        }
    }

    @Override // com.avito.android.webview.analytics.WebViewAnalyticsInteractor
    public void trackPageScrolledToEnd(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "url");
        String queryParameter = uri.getQueryParameter(WebViewAnalyticsInteractorKt.PAGE_ANALYTICS_ID_KEY);
        if (queryParameter != null) {
            Boolean bool = Boolean.TRUE;
            if (!Intrinsics.areEqual(this.a.get(queryParameter), bool)) {
                this.c.track(new WebViewPageScrolledToEndEvent(queryParameter));
                this.a.put(queryParameter, bool);
            }
        }
    }
}
