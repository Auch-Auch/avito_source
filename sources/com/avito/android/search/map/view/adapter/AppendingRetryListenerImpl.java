package com.avito.android.search.map.view.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nRD\u0010\u0012\u001a0\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00020\u0002 \u000e*\u0017\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\r¢\u0006\u0002\b\u000f0\r¢\u0006\u0002\b\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011RD\u0010\u0014\u001a0\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00020\u0002 \u000e*\u0017\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\r¢\u0006\u0002\b\u000f0\r¢\u0006\u0002\b\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\"\u0010\u001c\u001a\u00020\u00158\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/search/map/view/adapter/AppendingRetryListenerImpl;", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "", "onAppend", "()V", "", "canAppend", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "appendEvents", "()Lio/reactivex/rxjava3/core/Observable;", "onRetry", "retryEvents", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "appendRelay", AuthSource.BOOKING_ORDER, "retryRelay", "Lcom/avito/android/search/map/view/adapter/AppendingState;", "c", "Lcom/avito/android/search/map/view/adapter/AppendingState;", "getAppendingState", "()Lcom/avito/android/search/map/view/adapter/AppendingState;", "setAppendingState", "(Lcom/avito/android/search/map/view/adapter/AppendingState;)V", "appendingState", "<init>", "map_release"}, k = 1, mv = {1, 4, 2})
public final class AppendingRetryListenerImpl implements AppendingRetryListener {
    public final PublishRelay<Unit> a = PublishRelay.create();
    public final PublishRelay<Unit> b = PublishRelay.create();
    @NotNull
    public AppendingState c = AppendingState.NONE;

    @Override // com.avito.android.search.map.view.adapter.AppendingRetryListener
    @NotNull
    public Observable<Unit> appendEvents() {
        Observable<Unit> throttleFirst = this.a.hide().throttleFirst(500, TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNullExpressionValue(throttleFirst, "appendRelay.hide().throt…0, TimeUnit.MILLISECONDS)");
        return throttleFirst;
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public boolean canAppend() {
        return getAppendingState() != AppendingState.NONE;
    }

    @Override // com.avito.android.search.map.view.adapter.AppendingRetryListener
    @NotNull
    public AppendingState getAppendingState() {
        return this.c;
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public void onAppend() {
        this.a.accept(Unit.INSTANCE);
    }

    @Override // com.avito.android.search.map.view.adapter.AppendingRetryListener
    public void onRetry() {
        this.b.accept(Unit.INSTANCE);
    }

    @Override // com.avito.android.search.map.view.adapter.AppendingRetryListener
    @NotNull
    public Observable<Unit> retryEvents() {
        Observable<Unit> hide = this.b.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "retryRelay.hide()");
        return hide;
    }

    @Override // com.avito.android.search.map.view.adapter.AppendingRetryListener
    public void setAppendingState(@NotNull AppendingState appendingState) {
        Intrinsics.checkNotNullParameter(appendingState, "<set-?>");
        this.c = appendingState;
    }
}
