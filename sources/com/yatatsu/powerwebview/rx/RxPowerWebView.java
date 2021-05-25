package com.yatatsu.powerwebview.rx;

import androidx.annotation.CheckResult;
import com.yatatsu.powerwebview.PowerWebView;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/yatatsu/powerwebview/rx/RxPowerWebView;", "", "<init>", "()V", "Companion", "powerwebview_release"}, k = 1, mv = {1, 4, 2})
public final class RxPowerWebView {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/yatatsu/powerwebview/rx/RxPowerWebView$Companion;", "", "Lcom/yatatsu/powerwebview/PowerWebView;", "view", "Lio/reactivex/Observable;", "Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "stateChangeEvents", "(Lcom/yatatsu/powerwebview/PowerWebView;)Lio/reactivex/Observable;", "<init>", "()V", "powerwebview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @CheckResult
        @NotNull
        public final Observable<PowerWebViewStateChangeEvent> stateChangeEvents(@NotNull PowerWebView powerWebView) {
            Intrinsics.checkNotNullParameter(powerWebView, "view");
            return new PowerWebViewStateChangeEventObservable(powerWebView);
        }

        public Companion(j jVar) {
        }
    }

    public RxPowerWebView() {
        throw new AssertionError("No instances.");
    }
}
