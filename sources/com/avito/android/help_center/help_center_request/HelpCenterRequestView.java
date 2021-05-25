package com.avito.android.help_center.help_center_request;

import com.avito.android.help_center.HelpCenterJSInterface;
import com.yatatsu.powerwebview.PowerWebViewInterceptor;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\u000bJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0006J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/help_center/help_center_request/HelpCenterRequestView;", "", "", "url", "", "loadUrl", "(Ljava/lang/String;)V", "", "pageBack", "()Z", "startLoad", "()V", "showData", "showError", "hideScreen", "Lcom/avito/android/help_center/HelpCenterJSInterface;", "jsInterface", "name", "addJavascriptInterface", "(Lcom/avito/android/help_center/HelpCenterJSInterface;Ljava/lang/String;)V", "removeJavascriptInterface", "Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;", "interceptor", "addInterceptor", "(Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;)V", "removeInterceptor", "showResultMessage", "Lio/reactivex/Observable;", "Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "getStateChangeEvents", "()Lio/reactivex/Observable;", "stateChangeEvents", "getNavigationClick", "navigationClick", "help-center_release"}, k = 1, mv = {1, 4, 2})
public interface HelpCenterRequestView {
    void addInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor);

    void addJavascriptInterface(@NotNull HelpCenterJSInterface helpCenterJSInterface, @NotNull String str);

    @NotNull
    Observable<Unit> getNavigationClick();

    @NotNull
    Observable<PowerWebViewStateChangeEvent> getStateChangeEvents();

    void hideScreen();

    void loadUrl(@NotNull String str);

    boolean pageBack();

    void removeInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor);

    void removeJavascriptInterface(@NotNull String str);

    void showData();

    void showError();

    void showResultMessage();

    void startLoad();
}
