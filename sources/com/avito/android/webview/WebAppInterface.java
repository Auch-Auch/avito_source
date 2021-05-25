package com.avito.android.webview;

import android.webkit.JavascriptInterface;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractor;
import com.avito.android.webview.models.WebViewInnerEvent;
import com.avito.android.webview.models.WebViewInnerEventDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\t\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/webview/WebAppInterface;", "", "", "message", "", "postMessage", "(Ljava/lang/String;)V", "payload", "clickstreamEvent", "Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;", "analyticsInteractor", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "backCommandListener", "Lcom/google/gson/Gson;", AuthSource.SEND_ABUSE, "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;Lkotlin/jvm/functions/Function0;)V", "webview_release"}, k = 1, mv = {1, 4, 2})
public final class WebAppInterface {
    public final Gson a;
    public final WebViewAnalyticsInteractor b;
    public final Function0<Unit> c;

    public WebAppInterface(@NotNull WebViewAnalyticsInteractor webViewAnalyticsInteractor, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(webViewAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(function0, "backCommandListener");
        this.b = webViewAnalyticsInteractor;
        this.c = function0;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(WebViewInnerEvent.class, new WebViewInnerEventDeserializer());
        Gson create = gsonBuilder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        this.a = create;
    }

    @JavascriptInterface
    public final void clickstreamEvent(@Nullable String str) {
        WebViewInnerEvent webViewInnerEvent = (WebViewInnerEvent) this.a.fromJson(str, (Class<Object>) WebViewInnerEvent.class);
        WebViewAnalyticsInteractor webViewAnalyticsInteractor = this.b;
        Intrinsics.checkNotNullExpressionValue(webViewInnerEvent, "event");
        webViewAnalyticsInteractor.trackInnerEvent(webViewInnerEvent);
    }

    @JavascriptInterface
    public final void postMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (Intrinsics.areEqual(str, VerticalFilterCloseDialogEventKt.ACTION_BACK)) {
            this.c.invoke();
        }
    }
}
