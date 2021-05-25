package com.avito.android.analytics;

import androidx.annotation.VisibleForTesting;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.TestObserver;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ@\u0010\r\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R:\u0010\u0019\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00030\u0003 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/analytics/TestEventObserver;", "Lcom/avito/android/analytics/EventObserver;", "Lio/reactivex/Observable;", "Lcom/avito/android/analytics/Event;", "events", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "throwable", "", "onError", "Lio/reactivex/disposables/Disposable;", "observe", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/disposables/Disposable;", "Lio/reactivex/observers/TestObserver;", AuthSource.BOOKING_ORDER, "Lio/reactivex/observers/TestObserver;", "getTestObserver", "()Lio/reactivex/observers/TestObserver;", "testObserver", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "relay", "<init>", "()V", "analytics-core_release"}, k = 1, mv = {1, 4, 2})
@VisibleForTesting
public class TestEventObserver implements EventObserver {
    public final PublishRelay<Event> a;
    @NotNull
    public final TestObserver<Event> b;

    @Inject
    public TestEventObserver() {
        PublishRelay<Event> create = PublishRelay.create();
        this.a = create;
        TestObserver<Event> test = create.test();
        Intrinsics.checkNotNullExpressionValue(test, "relay.test()");
        this.b = test;
    }

    @NotNull
    public TestObserver<Event> getTestObserver() {
        return this.b;
    }

    @Override // com.avito.android.analytics.EventObserver
    @NotNull
    public Disposable observe(@NotNull Observable<Event> observable, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(observable, "events");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Disposable subscribe = observable.subscribe(this.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "events.subscribe(relay)");
        return subscribe;
    }
}
