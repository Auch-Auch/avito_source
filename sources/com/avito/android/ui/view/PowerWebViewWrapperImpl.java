package com.avito.android.ui.view;

import android.annotation.SuppressLint;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.rx3.InteropKt;
import com.yatatsu.powerwebview.PowerWebView;
import com.yatatsu.powerwebview.PowerWebViewInterceptor;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import com.yatatsu.powerwebview.rx.RxPowerWebViewKt;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/ui/view/PowerWebViewWrapperImpl;", "Lcom/avito/android/ui/view/PowerWebViewWrapper;", "Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;", "interceptor", "", "addInterceptor", "(Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;)V", "removeInterceptor", "", "url", "loadUrl", "(Ljava/lang/String;)V", "", "goBack", "()Z", "", "jsInterface", "name", "addJavascriptInterface", "(Ljava/lang/Object;Ljava/lang/String;)V", "removeJavascriptInterface", "reloadPage", "()V", "hideWebView", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/core/Observable;", "getStateChangeEvents", "()Lio/reactivex/rxjava3/core/Observable;", "stateChangeEvents", "Lcom/yatatsu/powerwebview/PowerWebView;", AuthSource.BOOKING_ORDER, "Lcom/yatatsu/powerwebview/PowerWebView;", "powerWebView", "<init>", "(Lcom/yatatsu/powerwebview/PowerWebView;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PowerWebViewWrapperImpl implements PowerWebViewWrapper {
    @NotNull
    public final Observable<PowerWebViewStateChangeEvent> a;
    public final PowerWebView b;

    public PowerWebViewWrapperImpl(@NotNull PowerWebView powerWebView) {
        Intrinsics.checkNotNullParameter(powerWebView, "powerWebView");
        this.b = powerWebView;
        this.a = InteropKt.toV3(RxPowerWebViewKt.stateChangeEvents(powerWebView));
    }

    @Override // com.avito.android.ui.view.PowerWebViewWrapper
    public void addInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor) {
        Intrinsics.checkNotNullParameter(powerWebViewInterceptor, "interceptor");
        this.b.addInterceptor(powerWebViewInterceptor);
    }

    @Override // com.avito.android.ui.view.PowerWebViewWrapper
    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(@NotNull Object obj, @NotNull String str) {
        Intrinsics.checkNotNullParameter(obj, "jsInterface");
        Intrinsics.checkNotNullParameter(str, "name");
        this.b.addJavascriptInterface(obj, str);
    }

    @Override // com.avito.android.ui.view.PowerWebViewWrapper
    @NotNull
    public Observable<PowerWebViewStateChangeEvent> getStateChangeEvents() {
        return this.a;
    }

    @Override // com.avito.android.ui.view.PowerWebViewWrapper
    public boolean goBack() {
        if (!this.b.canGoBack()) {
            return false;
        }
        this.b.goBack();
        return true;
    }

    @Override // com.avito.android.ui.view.PowerWebViewWrapper
    public void hideWebView() {
        this.b.setVisibility(8);
    }

    @Override // com.avito.android.ui.view.PowerWebViewWrapper
    public void loadUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.b.loadUrl(str);
    }

    @Override // com.avito.android.ui.view.PowerWebViewWrapper
    public void reloadPage() {
        this.b.reload();
    }

    @Override // com.avito.android.ui.view.PowerWebViewWrapper
    public void removeInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor) {
        Intrinsics.checkNotNullParameter(powerWebViewInterceptor, "interceptor");
        this.b.removeInterceptor(powerWebViewInterceptor);
    }

    @Override // com.avito.android.ui.view.PowerWebViewWrapper
    public void removeJavascriptInterface(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.b.removeJavascriptInterface(str);
    }
}
