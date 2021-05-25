package com.yatatsu.powerwebview.rx;

import com.yatatsu.powerwebview.PowerWebView;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/yatatsu/powerwebview/PowerWebView;", "Lio/reactivex/Observable;", "Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "stateChangeEvents", "(Lcom/yatatsu/powerwebview/PowerWebView;)Lio/reactivex/Observable;", "powerwebview_release"}, k = 2, mv = {1, 4, 2})
public final class RxPowerWebViewKt {
    @NotNull
    public static final Observable<PowerWebViewStateChangeEvent> stateChangeEvents(@NotNull PowerWebView powerWebView) {
        Intrinsics.checkNotNullParameter(powerWebView, "$this$stateChangeEvents");
        return RxPowerWebView.Companion.stateChangeEvents(powerWebView);
    }
}
