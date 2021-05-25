package com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen;

import android.webkit.WebView;
import com.avito.android.advert_core.analytics.broker.SravniWebAnalyticsEventLogger;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.view.PowerWebViewWrapper;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/SravniWebAnalyticsHandler;", "", "Landroid/webkit/WebView;", "webView", "Lcom/avito/android/ui/view/PowerWebViewWrapper;", "powerWebView", "", "attach", "(Landroid/webkit/WebView;Lcom/avito/android/ui/view/PowerWebViewWrapper;)V", "destroy", "()V", "Lcom/avito/android/advert_core/analytics/broker/SravniWebAnalyticsEventLogger;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/analytics/broker/SravniWebAnalyticsEventLogger;", "getEventLogger", "()Lcom/avito/android/advert_core/analytics/broker/SravniWebAnalyticsEventLogger;", "eventLogger", "Lio/reactivex/rxjava3/disposables/Disposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/Disposable;", "getDisposable", "()Lio/reactivex/rxjava3/disposables/Disposable;", "setDisposable", "(Lio/reactivex/rxjava3/disposables/Disposable;)V", "disposable", "<init>", "(Lcom/avito/android/advert_core/analytics/broker/SravniWebAnalyticsEventLogger;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SravniWebAnalyticsHandler {
    @Nullable
    public Disposable a;
    @NotNull
    public final SravniWebAnalyticsEventLogger b;

    public static final class a<T> implements Consumer<PowerWebViewStateChangeEvent> {
        public final /* synthetic */ WebView a;

        public a(WebView webView) {
            this.a = webView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(PowerWebViewStateChangeEvent powerWebViewStateChangeEvent) {
            if (powerWebViewStateChangeEvent.getState() == PowerWebViewStateChangeEvent.State.STARTED) {
                this.a.loadUrl(" \n    javascript: (function() {\n        function receiveMessage(event) {\n            if (event.origin === 'https://www.sravni.ru' && event.data && typeof event.data === 'string') {\n                const msg = JSON.parse(event.data);\n                if (msg.type !== undefined && msg.result !== undefined) {\n                    AndroidAnalytics.receiveMessage(msg.type, JSON.stringify(msg.result), event.data);\n                } else if (msg.data !== undefined) {\n                    AndroidAnalytics.receiveMessage(msg.data.type, \"\", event.data);\n                } else if (msg.banksData !== undefined) {\n                    AndroidAnalytics.receiveMessage(\"offersShown\", event.data, event.data);\n                } else if (msg.requestId !== undefined) {\n                    AndroidAnalytics.receiveMessage(\"offerAccepted\", event.data, event.data);\n                }\n            }\n        }\n        window.addEventListener('message', receiveMessage, false);\n    })()\n");
            }
        }
    }

    @Inject
    public SravniWebAnalyticsHandler(@NotNull SravniWebAnalyticsEventLogger sravniWebAnalyticsEventLogger) {
        Intrinsics.checkNotNullParameter(sravniWebAnalyticsEventLogger, "eventLogger");
        this.b = sravniWebAnalyticsEventLogger;
    }

    public final void attach(@NotNull WebView webView, @NotNull PowerWebViewWrapper powerWebViewWrapper) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(powerWebViewWrapper, "powerWebView");
        powerWebViewWrapper.addJavascriptInterface(new a2.a.a.f.x.t.j.a(this.b), "AndroidAnalytics");
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a = powerWebViewWrapper.getStateChangeEvents().subscribe(new a(webView));
    }

    public final void destroy() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a = null;
    }

    @Nullable
    public final Disposable getDisposable() {
        return this.a;
    }

    @NotNull
    public final SravniWebAnalyticsEventLogger getEventLogger() {
        return this.b;
    }

    public final void setDisposable(@Nullable Disposable disposable) {
        this.a = disposable;
    }
}
