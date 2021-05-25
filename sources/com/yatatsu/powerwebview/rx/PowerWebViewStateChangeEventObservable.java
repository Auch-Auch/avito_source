package com.yatatsu.powerwebview.rx;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.yatatsu.powerwebview.LoadStateWatcher;
import com.yatatsu.powerwebview.PowerWebView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEventObservable;", "Lio/reactivex/Observable;", "Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "Lio/reactivex/Observer;", "observer", "", "subscribeActual", "(Lio/reactivex/Observer;)V", "Lcom/yatatsu/powerwebview/PowerWebView;", AuthSource.SEND_ABUSE, "Lcom/yatatsu/powerwebview/PowerWebView;", "view", "<init>", "(Lcom/yatatsu/powerwebview/PowerWebView;)V", "powerwebview_release"}, k = 1, mv = {1, 4, 2})
public final class PowerWebViewStateChangeEventObservable extends Observable<PowerWebViewStateChangeEvent> {
    public final PowerWebView a;

    public PowerWebViewStateChangeEventObservable(@NotNull PowerWebView powerWebView) {
        Intrinsics.checkNotNullParameter(powerWebView, "view");
        this.a = powerWebView;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super PowerWebViewStateChangeEvent> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            PowerWebViewStateChangeEventObservable$createWatcherForObserver$1 powerWebViewStateChangeEventObservable$createWatcherForObserver$1 = new LoadStateWatcher(observer) { // from class: com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEventObservable$createWatcherForObserver$1
                public final /* synthetic */ Observer c;

                {
                    this.c = r2;
                }

                @Override // io.reactivex.android.MainThreadDisposable
                public void onDispose() {
                    PowerWebViewStateChangeEventObservable.access$getView$p(PowerWebViewStateChangeEventObservable.this).removeLoadStateWatcher(this);
                }

                @Override // com.yatatsu.powerwebview.LoadStateWatcher
                public void onError(@NotNull WebView webView, int i, @Nullable String str, @Nullable String str2) {
                    Intrinsics.checkNotNullParameter(webView, "webView");
                    if (!isDisposed()) {
                        this.c.onNext(PowerWebViewStateChangeEvent.Companion.error(i, str, str2));
                    }
                }

                @Override // com.yatatsu.powerwebview.LoadStateWatcher
                public void onFinished(@NotNull WebView webView, @Nullable String str) {
                    Intrinsics.checkNotNullParameter(webView, "webView");
                    if (!isDisposed()) {
                        this.c.onNext(PowerWebViewStateChangeEvent.Companion.finish(str));
                    }
                }

                @Override // com.yatatsu.powerwebview.LoadStateWatcher
                public void onProgressChanged(@NotNull WebView webView, int i) {
                    Intrinsics.checkNotNullParameter(webView, "webView");
                    if (!isDisposed()) {
                        this.c.onNext(PowerWebViewStateChangeEvent.Companion.progress(i));
                    }
                }

                @Override // com.yatatsu.powerwebview.LoadStateWatcher
                public void onStarted(@NotNull WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
                    Intrinsics.checkNotNullParameter(webView, "webView");
                    if (!isDisposed()) {
                        this.c.onNext(PowerWebViewStateChangeEvent.Companion.start(str, bitmap));
                    }
                }
            };
            observer.onSubscribe(powerWebViewStateChangeEventObservable$createWatcherForObserver$1);
            this.a.addLoadStateWatcher(powerWebViewStateChangeEventObservable$createWatcherForObserver$1);
        }
    }
}
