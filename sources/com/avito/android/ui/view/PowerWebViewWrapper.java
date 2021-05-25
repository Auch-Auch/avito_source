package com.avito.android.ui.view;

import com.yatatsu.powerwebview.PowerWebViewInterceptor;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bH&¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\u0015R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/avito/android/ui/view/PowerWebViewWrapper;", "", "Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;", "interceptor", "", "addInterceptor", "(Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;)V", "removeInterceptor", "", "url", "loadUrl", "(Ljava/lang/String;)V", "", "goBack", "()Z", "jsInterface", "name", "addJavascriptInterface", "(Ljava/lang/Object;Ljava/lang/String;)V", "removeJavascriptInterface", "reloadPage", "()V", "hideWebView", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "getStateChangeEvents", "()Lio/reactivex/rxjava3/core/Observable;", "stateChangeEvents", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface PowerWebViewWrapper {
    void addInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor);

    void addJavascriptInterface(@NotNull Object obj, @NotNull String str);

    @NotNull
    Observable<PowerWebViewStateChangeEvent> getStateChangeEvents();

    boolean goBack();

    void hideWebView();

    void loadUrl(@NotNull String str);

    void reloadPage();

    void removeInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor);

    void removeJavascriptInterface(@NotNull String str);
}
