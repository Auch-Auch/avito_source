package com.avito.android.help_center;

import com.yatatsu.powerwebview.PowerWebViewInterceptor;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0006J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u001b\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001e¨\u0006%"}, d2 = {"Lcom/avito/android/help_center/HelpCenterView;", "", "", "url", "", "loadUrl", "(Ljava/lang/String;)V", "", "pageBack", "()Z", "visible", "setMenuHomeButtonVisible", "(Z)V", "startLoad", "()V", "showData", "showError", "Lcom/avito/android/help_center/HelpCenterJSInterface;", "jsInterface", "name", "addJavascriptInterface", "(Lcom/avito/android/help_center/HelpCenterJSInterface;Ljava/lang/String;)V", "removeJavascriptInterface", "Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;", "interceptor", "addInterceptor", "(Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;)V", "removeInterceptor", "Lio/reactivex/Observable;", "getNavigationClick", "()Lio/reactivex/Observable;", "navigationClick", "getHomeClick", "homeClick", "Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "getStateChangeEvents", "stateChangeEvents", "help-center_release"}, k = 1, mv = {1, 4, 2})
public interface HelpCenterView {
    void addInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor);

    void addJavascriptInterface(@NotNull HelpCenterJSInterface helpCenterJSInterface, @NotNull String str);

    @NotNull
    Observable<Unit> getHomeClick();

    @NotNull
    Observable<Unit> getNavigationClick();

    @NotNull
    Observable<PowerWebViewStateChangeEvent> getStateChangeEvents();

    void loadUrl(@NotNull String str);

    boolean pageBack();

    void removeInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor);

    void removeJavascriptInterface(@NotNull String str);

    void setMenuHomeButtonVisible(boolean z);

    void showData();

    void showError();

    void startLoad();
}
